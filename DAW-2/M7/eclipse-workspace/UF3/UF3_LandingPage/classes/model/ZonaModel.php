<?php

class ZonaModel implements Crudable {
    public $db_generic;
    public $db_consulta;
    
    public function __construct(){
        $this->db_generic = DataBase::getInstance();
        $this->db_consulta = DataBase::getInstance(1);
    }

    public function create($zona){
        $zonaInsert = [$zona->id, $zona->descripcio];
        $this->db_generic->executeSQL("INSERT INTO `tbl_zona` (id, descripcio) VALUES (?,?)", $zonaInsert);
    }
    
    public function read($zona = null){
        $zones = $this->db_consulta->executeSQL("SELECT * FROM `tbl_zona` ORDER BY `id` DESC");
        if (!$zones){
            return null;
        }
        
        $zonesObj = array();
        foreach ($zones as $fila) {
            $zonesObj[] = new Zona($fila["id"], $fila["descripcio"]);
        }
        return $zonesObj;
    }

    public function update($zona){
        $zonaUpdate = [$zona->descripcio, $zona->id];
        $this->db_generic->executeSQL("UPDATE `tbl_zona` SET descripcio = ? WHERE id = ?", $zonaUpdate);
    }

    public function delete($zona){
        $this->db_generic->executeSQL("DELETE FROM `tbl_zona` WHERE id = ?", [$zona->id]);
    }
    
    public function getById($id){
        $zona = $this->db_consulta->executeSQL("SELECT * FROM `tbl_zona` WHERE id = ?", [$id]);
        if (!$zona){
            return null;
        }
        
        $zonaObj = new Zona($zona[0]["id"], $zona[0]["descripcio"]);
        return $zonaObj;
    }
}
