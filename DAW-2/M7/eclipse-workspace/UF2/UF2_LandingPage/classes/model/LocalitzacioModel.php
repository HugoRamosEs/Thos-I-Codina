<?php

class LocalitzacioModel implements Crudable {
    public $db_generic;
    public $db_consulta;
    
    public function __construct(){
        $this->db_generic = DataBase::getInstance();
        $this->db_consulta = DataBase::getInstance(1);
    }
    
    public function create($localitzacio){
        $localitzacioInsert = [$localitzacio->id, $localitzacio->lloc, $localitzacio->adreca, $localitzacio->localitat];
        $this->db_generic->executeSQL("INSERT INTO `tbl_localitzacio` (id, lloc, adreca, localitat) VALUES (?,?,?,?)", $localitzacioInsert);
    }
    
    public function read($localitzacio = null){
        $localitzacions = $this->db_consulta->executeSQL("SELECT * FROM `tbl_localitzacio` ORDER BY `id` DESC");
        if (!$localitzacions){
            return null;
        }
        
        $localitzacionsObj = array();
        foreach ($localitzacions as $fila) {
            $localitzacionsObj[] = new Localitzacio($fila["id"], $fila["lloc"], $fila["adreca"], $fila["localitat"]);
        }
        return $localitzacionsObj;
    }
    
    public function update($localitzacio){
        $localitzacioUpdate = [$localitzacio->lloc, $localitzacio->adreca, $localitzacio->localitat, $localitzacio->id];
        $this->db_generic->executeSQL("UPDATE `tbl_localitzacio` SET lloc = ?, adreca = ?, localitat = ? WHERE id = ?", $localitzacioUpdate);
    }
    
    public function delete($localitzacio){
        $this->db_generic->executeSQL("DELETE FROM `tbl_localitzacio` WHERE id = ?", [$localitzacio->id]);
    }
    
    public function getById($id){
        $localitzacio = $this->db_consulta->executeSQL("SELECT * FROM `tbl_localitzacio` WHERE id = ?", [$id]);
        if (!$localitzacio){
            return null;
        }
        
        $localitzacioObj = new Localitzacio($localitzacio[0]["id"], $localitzacio[0]["lloc"], $localitzacio[0]["adreca"], $localitzacio[0]["localitat"]);
        return $localitzacioObj;
    }
}

