<?php

class PagamentModel implements Crudable {
    public $db_generic;
    public $db_consulta;
    
    public function __construct(){
        $this->db_generic = DataBase::getInstance();
        $this->db_consulta = DataBase::getInstance(1);
    }
    
    public function create($pagament){
        $pagamentInsert = [$pagament->id, $pagament->banc, $pagament->ref_externa, $pagament->data, $pagament->estat];
        $this->db_generic->executeSQL("INSERT INTO `tbl_pagament` (id, banc, ref_externa, data, estat) VALUES (?,?,?,?,?)", $pagamentInsert);
    }
    
    public function read($pagament = null){
        $pagaments = $this->db_consulta->executeSQL("SELECT * FROM `tbl_pagament` ORDER BY `id` DESC");
        if (!$pagaments){
            return null;
        }
        
        $pagamentsObj = array();
        foreach ($pagaments as $fila) {
            $pagamentsObj[] = new Pagament($fila["id"], $fila["banc"], $fila["ref_externa"], $fila["data"], $fila["estat"]);
        }
        return $pagamentsObj;
    }
    
    public function update($pagament){
        $pagamentUpdate = [$pagament->banc, $pagament->ref_externa, $pagament->data, $pagament->estat, $pagament->id];
        $this->db_generic->executeSQL("UPDATE `tbl_pagament` SET banc = ?, ref_externa = ?, data = ?, estat = ? WHERE id = ?", $pagamentUpdate);
    }
    
    public function delete($pagament){
        $this->db_generic->executeSQL("DELETE FROM `tbl_pagament` WHERE id = ?", [$pagament->id]);
    }
    
    public function getById($id){
        $pagament = $this->db_consulta->executeSQL("SELECT * FROM `tbl_pagament` WHERE id = ?", [$id]);
        if (!$pagament){
            return null;
        }
        
        $pagamentObj = new Pagament($pagament[0]["id"], $pagament[0]["banc"], $pagament[0]["ref_externa"], $pagament[0]["data"], $pagament[0]["estat"]);
        return $pagamentObj;
    }
}

