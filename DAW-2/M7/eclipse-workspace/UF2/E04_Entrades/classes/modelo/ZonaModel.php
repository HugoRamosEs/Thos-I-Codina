<?php

class ZonaModel {
    private $_table = "tbl_zona";
    private $_db;
    
    public function __construct() {
        $this->_db = BaseDades::getInstance();
    }
    
    public function create(Zona $params) {
        $sSql = "INSERT INTO {$this->_table} (descripcio) VALUES (?);";
        $aParams = array ($params->getDescripcio());
        
        if (!$this->_db->execute($sSql, $aParams, "accio")) {
            throw new Exception ("No s'ha fet l'insert per: \n " . $this->_db->getLastError());
        }
    }
    public function read() {
        $retorn = array();
        $sSql = "SELECT * FROM {$this->_table} ORDER BY id DESC;";
        
        if ($oResultat = $this->_db->execute($sSql)) {
            while ( ($aResult = $this->_db->obtenirFila($oResultat)) != null ) {
                $retorn[] = new Zona($aResult->id, $aResult->descripcio);
            }
        }
        
        return $retorn;
    }
    public function getOneById(Zona $param) {
        $sSql = "SELECT * FROM {$this->_table} WHERE id=?;";
        
        if ($oResultat = $this->_db->execute($sSql, array($param->getId()))) {
            while ( ($aResult = $this->_db->obtenirFila($oResultat)) != null ) {
                $retorn = new Zona($aResult->id, $aResult->descripcio);
            }
        }
        
        return $retorn;
    }
    public function update(Zona $param) {
        $sSql = "UPDATE {$this->_table} SET descripcio=? WHERE id=?";
        $aParams = array ($param->getDescripcio(), $param->getId());
        
        if (!$this->_db->execute($sSql, $aParams, "accio")) {
            throw new Exception ("No s'ha modificat per \n " . $this->_db->getLastError());
        }
    }
    public function delete(Zona $param) {
        $sSql = "DELETE FROM {$this->_table} WHERE id=?";
        $aParams = array ($param->getId());
        
        if (!$this->_db->execute($sSql, $aParams, "accio")) {
            throw new Exception ("No s'ha esborrat per \n " . $this->_db->getLastError());
        }
    }
    
    
}

