<?php

class LocalitzacioModel {
    private $_table = "tbl_localitzacio";
    private $_db;
    
    public function __construct() {
        $this->_db = BaseDades::getInstance();
    }
    
    public function create(Localitzacio $params) {
        $sSql = "INSERT INTO {$this->_table} (lloc, adreca, localitat) VALUES (?,?,?);";
        $aParams = array ($params->lloc, $params->adreca, $params->localitat);
        
        if (!$this->_db->execute($sSql, $aParams, "accio")) {
            throw new Exception ("No s'ha fet l'insert per: \n " . $this->_db->getLastError());
        }
    }
    public function read() {
        $retorn = array();
        $sSql = "SELECT * FROM {$this->_table} ORDER BY id DESC;";
        
        if ($oResultat = $this->_db->execute($sSql)) {
            while ( ($aResult = $this->_db->obtenirFila($oResultat)) != null ) {
                $retorn[] = $this->cast($aResult, new Localitzacio());
            }
        }
        
        return $retorn;
    }
    public function getOneById(Localitzacio $param) {
        $sSql = "SELECT * FROM {$this->_table} WHERE id=?;";
        
        if ($oResultat = $this->_db->execute($sSql, array($param->id))) {
            while ( ($aResult = $this->_db->obtenirFila($oResultat)) != null ) {
                $retorn = $this->cast($aResult, new Localitzacio());
            }
        }
        
        return $retorn;
    }
    public function update(Localitzacio $params) {
        $sSql = "UPDATE {$this->_table} SET lloc=?, adreca=?, localitat=? WHERE id=?";
        $aParams = array ($params->lloc, $params->adreca, $params->localitat, $params->id);
        
        if (!$this->_db->execute($sSql, $aParams, "accio")) {
            throw new Exception ("No s'ha modificat per \n " . $this->_db->getLastError());
        }
    }
    public function delete(Localitzacio $param) {
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
}

