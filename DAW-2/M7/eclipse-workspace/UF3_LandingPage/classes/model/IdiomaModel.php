<?php

class IdiomaModel implements Crudable {
    public $db;
    public $traduccioModel;
    
    public function __construct(){
        $this->traduccioModel = new TraduccioModel();
        try {
            $this->db = new PDO("mysql:host=localhost;dbname=myweb",
                "usr_generic", "2024@Thos");
            $this->db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        }catch (PDOException $e) {
            echo $e->getMessage();
        }
    }
    
    public function create($idioma){
        $valors = array();
        $stmt = $this->db->prepare("INSERT INTO `tbl_idiomes` VALUES(:id, :iso, :imatge, :actiu, :created_at, :updated_at)");
        foreach (array("id", "iso", "imatge", "actiu", "created_at", "updated_at") as $v){
            $get = "get" . ucfirst($v);
            $valors[$v] = $idioma->$get();
            $stmt->bindParam(":".$v, $valors[$v]);
        } 
        $stmt->execute();
        $lastId = $this->db->lastInsertId();
        return $lastId;
    }
    
    public function read($idioma = null){
        $idiomes = array();
        $res = $this->db->query("SELECT * FROM `tbl_idiomes` ORDER BY `id` DESC");
        while ($col = $res->fetch(PDO::FETCH_ASSOC)) {
            $i = new Idioma($col['id'], $col['iso'], $col['imatge'], $col['actiu'], $col['created_at'], $col['updated_at']);
            $idiomes[] = $i;
        }
        
        return $idiomes;
    }

    public function update($idioma){
        $valors = array();
        $stmt = $this->db->prepare("UPDATE `tbl_idiomes` SET iso = :iso, imatge = :imatge, actiu = :actiu WHERE id = :id");
        foreach (array("iso", "imatge", "actiu", "id") as $v){
            $get = "get" . ucfirst($v);
            $valors[$v] = $idioma->$get();
            $stmt->bindParam(":".$v, $valors[$v]);
        }
        $stmt->execute();
    }
    
    public function delete($idioma){
        $stmt = $this->db->prepare("DELETE FROM `tbl_idiomes` WHERE id = :id");
        $id = $idioma->getId();
        $stmt->bindParam(":id", $id);
        $stmt->execute();
    }
    
    public function getById($idiomaId){
        $stmt = $this->db->prepare("SELECT * FROM `tbl_idiomes` WHERE id = :id");
        $stmt->bindParam(":id", $idiomaId);
        $stmt->execute();
        $col = $stmt->fetch(PDO::FETCH_ASSOC);
        if ($col) {
            $idioma = new Idioma($col['id'], $col['iso'], $col['imatge'], $col['actiu'], $col['created_at'], $col['updated_at']);
            $idioma->setTraduccions($this->getTraductions($idioma));
            return $idioma;
        }else {
            return null;
        }
    }
    
    public function getTraductions($idioma){
        $traduccions = array();
        $res = $this->db->prepare("SELECT * FROM `tbl_traduccions` WHERE idioma_id = :idioma_id ORDER BY `id` DESC");
        $res->bindParam(":idioma_id", $idioma->getId());
        $res->execute();
        while ($col = $res->fetch(PDO::FETCH_ASSOC)) {
            $t = new Traduccio($col['id'], $col['variable'], $col['idioma_id'], $col['valor'], $col['created_at'], $col['updated_at'], $idioma);
            $traduccions[] = $t;
        }
        
        return $traduccions;
    }
    
    public function getActiveLangs(){
        $idiomesActius = array();
        $res = $this->db->prepare("SELECT * FROM `tbl_idiomes` WHERE actiu = :actiu");
        $actiu = 1;
        $res->bindParam(":actiu", $actiu);
        $res->execute();
        while ($col = $res->fetch(PDO::FETCH_ASSOC)) {
            $iA = new Idioma($col['id'], $col['iso'], $col['imatge'], $col['actiu'], $col['created_at'], $col['updated_at']);
            $iA->setTraduccions($this->getTraductions($iA));
            $idiomesActius[] = $iA;
        }
        
        return $idiomesActius;
    }
}

