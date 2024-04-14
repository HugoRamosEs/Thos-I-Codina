<?php

class EsdevenimentModel {
    private $_table = "tbl_esdeveniment";
    private $_db;
    
    public function __construct() {
        $this->_db = BaseDades::getInstance();
    }
    
    public function create(Esdeveniment $params) {
        $sSql = "INSERT INTO {$this->_table} (titol, subtitol, dates, imatge) VALUES (?,?,?, ?);";
        $aParams = array ($params->titol, $params->subtitol, $params->dates, $params->imatge);
        
        if (!$this->_db->execute($sSql, $aParams, "accio")) {
            throw new Exception ("No s'ha fet l'insert per: \n " . $this->_db->getLastError());
        }
    }
    public function read() {
        $retorn = array();
        $sSql = "SELECT * FROM {$this->_table} ORDER BY id DESC;";
        
        if ($oResultat = $this->_db->execute($sSql)) {
            while ( ($aResult = $this->_db->obtenirFila($oResultat)) != null ) {
                $retorn[] = $this->cast($aResult, new Esdeveniment());
            }
        }
        
        return $retorn;
    }
    public function getOneById(Esdeveniment $param) {
        $sSql = "SELECT * FROM {$this->_table} WHERE id=?;";
        
        if ($oResultat = $this->_db->execute($sSql, array($param->id))) {
            while ( ($aResult = $this->_db->obtenirFila($oResultat)) != null ) {
                $retorn = $this->cast($aResult, new Esdeveniment());
            }
        }
        
        return $retorn;
    }
    public function update(Esdeveniment $param) {
        $sSql = "UPDATE {$this->_table} SET titol=?, subtitol=?, dates = ?, imatge=? WHERE id=?";
        $aParams = array ($param->titol, $param->subtitol, $param->imatge, $param->dates, $param->id);
        
        if (!$this->_db->execute($sSql, $aParams, "accio")) {
            throw new Exception ("No s'ha modificat per \n " . $this->_db->getLastError());
        }
    }
    public function delete(Esdeveniment $param) {
        $sSql = "DELETE FROM {$this->_table} WHERE id=?";
        $aParams = array ($param->id);
        
        if (!$this->_db->execute($sSql, $aParams, "accio")) {
            throw new Exception ("No s'ha esborrat per \n " . $this->_db->getLastError());
        }
    }
    
    private function cast($sourceObject, $destinationObject) {
        if (is_string($destinationObject)) {
            $destinationObject = new $destinationObject();
        }
        
        $destinationReflection = new ReflectionObject($destinationObject);
        $sourceReflection = new ReflectionObject($sourceObject);
        $sourceProperties = $sourceReflection->getProperties();
        foreach ($sourceProperties as $sourceProperty) {
            $sourceProperty->setAccessible(true);
            $name = $sourceProperty->getName();
            $value = $sourceProperty->getValue($sourceObject);
            if ($destinationReflection->hasProperty($name)) {
                $propDest = $destinationReflection->getProperty($name);
                $propDest->setAccessible(true);
                $propDest->setValue($destinationObject,$value);
            } else {
                $destinationObject->$name = $value;
            }
        }
        return $destinationObject;
    }
    
    public function getRelacions(Esdeveniment $e) {
        $sSql = "SELECT * FROM rel_concerts WHERE esdeveniment_id=?;";
        
        if ($oResultat = $this->_db->execute($sSql, array($e->id))) {
            while ( ($aResult = $this->_db->obtenirFila($oResultat)) != null ) {
                $retorn[] = $aResult;
            }
        }
        
        return $retorn;
    }
}

