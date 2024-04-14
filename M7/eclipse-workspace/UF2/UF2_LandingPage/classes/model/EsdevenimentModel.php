<?php

class EsdevenimentModel implements Crudable {
    public $db_generic;
    public $db_consulta;
    
    public function __construct(){
        $this->db_generic = DataBase::getInstance();
        $this->db_consulta = DataBase::getInstance(1);
    }
    
    public function create($esdeveniment){
        $esdevenimentInsert = [$esdeveniment->id, $esdeveniment->titol, $esdeveniment->subtitol, $esdeveniment->dates, $esdeveniment->imatge];
        $this->db_generic->executeSQL("INSERT INTO `tbl_esdeveniment` (id, titol, subtitol, dates, imatge) VALUES (?,?,?,?,?)", $esdevenimentInsert);
    }
    
    public function read($esdeveniment = null){
        $esdeveniments = $this->db_consulta->executeSQL("SELECT * FROM `tbl_esdeveniment` ORDER BY `id` DESC");
        if (!$esdeveniments){
            return null;
        }
        
        $esdevenimentsObj = array();
        foreach ($esdeveniments as $fila) {
            $esdevenimentsObj[] = new Esdeveniment($fila["id"], $fila["titol"], $fila["subtitol"], $fila["dates"], $fila["imatge"]);
        }
        return $esdevenimentsObj ;
    }
    
    public function update($esdeveniment){
        $esdevenimentUpdate = [$esdeveniment->titol, $esdeveniment->subtitol, $esdeveniment->dates, $esdeveniment->imatge, $esdeveniment->id];
        $this->db_generic->executeSQL("UPDATE `tbl_esdeveniment` SET titol = ?, subtitol = ?, dates = ?, imatge = ? WHERE id = ?", $esdevenimentUpdate);
    }
    
    public function delete($esdeveniment){
        $this->db_generic->executeSQL("DELETE FROM `tbl_esdeveniment` WHERE id = ?", [$esdeveniment->id]);
    }
    
    public function getById($id){
        $esdeveniment = $this->db_consulta->executeSQL("SELECT * FROM `tbl_esdeveniment` WHERE id = ?", [$id]);
        if (!$esdeveniment){
            return null;
        }
        
        $esdevenimentObj = new Esdeveniment($esdeveniment[0]["id"], $esdeveniment[0]["titol"], $esdeveniment[0]["subtitol"], $esdeveniment[0]["dates"], $esdeveniment[0]["imatge"]);
        return $esdevenimentObj;
    }   
}

