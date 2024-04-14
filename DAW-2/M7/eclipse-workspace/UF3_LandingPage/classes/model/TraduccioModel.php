<?php

class TraduccioModel implements Crudable {
    public $db;
    
    public function __construct(){
        try {
            $this->db = new PDO("mysql:host=localhost;dbname=myweb",
                "usr_generic", "2024@Thos");
            $this->db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        }catch (PDOException $e) {
            echo $e->getMessage();
        }
    }
    
    public function create($traduccio){
        $valors = array();
        $stmt = $this->db->prepare("INSERT INTO `tbl_traduccions` VALUES(:id, :variable, :idioma_id, :valor, :created_at, :updated_at)");
        foreach (array("id", "variable", "idioma_id", "valor", "created_at", "updated_at") as $v){
            $get = "get" . ucfirst($v);
            $valors[$v] = $traduccio->$get();
            $stmt->bindParam(":".$v, $valors[$v]);
        }
        $stmt->execute();
        $lastId = $this->db->lastInsertId();
        return $lastId;
    }
    
    public function read($traduccio = null){
        $traduccions = array();
        $res = $this->db->query("SELECT * FROM `tbl_traduccions` ORDER BY `id` DESC");
        while ($col = $res->fetch(PDO::FETCH_ASSOC)) {
            $t = new Traduccio($col['id'], $col['variable'], $col['idioma_id'], $col['valor'], $col['created_at'], $col['updated_at']);
            $traduccions[] = $t;
        }
        
        return $traduccions;
    }
    
    public function update($traduccio){
        $valors = array();
        $stmt = $this->db->prepare("UPDATE `tbl_traduccions` SET variable = :variable, idioma_id = :idioma_id, valor = :valor, updated_at = :updated_at WHERE id = :id");
        foreach (array("variable", "idioma_id", "valor", "updated_at", "id") as $v) {
            $get = "get" . ucfirst($v);
            $valors[$v] = $traduccio->$get();
            $stmt->bindParam(":".$v, $valors[$v]);
        }
        $stmt->execute();
    }
    
    public function delete($traduccio){
        $stmt = $this->db->prepare("DELETE FROM `tbl_traduccions` WHERE id = :id");
        $id = $traduccio->getId();
        $stmt->bindParam(":id", $id);
        $stmt->execute();
    }
    
    public function getById($traduccioId) {
        $stmt = $this->db->query("SELECT * FROM `tbl_traduccions` WHERE id = :id");
        $stmt->bindParam(":id", $traduccioId);
        $stmt->execute();
        $col = $stmt->fetch(PDO::FETCH_ASSOC);
        if ($col) {
            $traduccio = new Traduccio($col['id'], $col['variable'], $col['idioma_id'], $col['valor'], $col['created_at'], $col['updated_at']);
            return $traduccio;
        }else {
            return null;
        }
    }
}

