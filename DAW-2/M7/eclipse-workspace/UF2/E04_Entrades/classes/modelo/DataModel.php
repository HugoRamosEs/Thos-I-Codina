<?php

class DataModel {
   
    public static function create(Data $params) {
        $_db = BaseDades::getInstance();
        $sSql = "INSERT INTO tbl_data (data,hora) VALUES (?,?);";
        $aParams = array ($params->data, $params->hora);
        
        if (!$_db->execute($sSql, $aParams, "accio")) {
            throw new Exception ("No s'ha fet l'insert per: \n " . $_db->getLastError());
        }
    }
    public static function read() {
        $_db = BaseDades::getInstance();
        $retorn = array();
        $sSql = "SELECT * FROM tbl_data ORDER BY id DESC;";
        
        if ($oResultat = $_db->execute($sSql)) {
            while ( ($aResult = $_db->obtenirFila($oResultat)) != null ) {
                $retorn[] = self::cast($aResult, new Data());
            }
        }
        
        return $retorn;
    }
    public static function getOneById(Data $param) {
        $_db = BaseDades::getInstance();
        $sSql = "SELECT * FROM tbl_data WHERE id=?;";
        
        if ($oResultat = $_db->execute($sSql, array($param->id))) {
            while ( ($aResult = $_db->obtenirFila($oResultat)) != null ) {
                $retorn = self::cast($aResult, new Data());
            }
        }
        
        return $retorn;
    }
    public static function getBiggerThanNow() {
        $_db = BaseDades::getInstance();
        $retorn = array();
        $sSql = "SELECT * FROM tbl_data WHERE data>CURDATE() ORDER BY data ASC;";
        
        if ($oResultat = $_db->execute($sSql)) {
            while ( ($aResult = $_db->obtenirFila($oResultat)) != null ) {
                $retorn[] = self::cast($aResult, new Data());
            }
        }
        
        return $retorn;
    }
    
    public static function update(Data $param) {
        $_db = BaseDades::getInstance();
        $sSql = "UPDATE tbl_data SET data=?, hora=? WHERE id=?";
        $aParams = array ($param->data, $param->hora, $param->id);
        
        if (!$_db->execute($sSql, $aParams, "accio")) {
            throw new Exception ("No s'ha modificat per \n " . $_db->getLastError());
        }
    }
    public static function delete(Data $param) {
        $_db = BaseDades::getInstance();
        $sSql = "DELETE FROM tbl_data WHERE id=?";
        $aParams = array ($param->id);
        
        if (!$_db->execute($sSql, $aParams, "accio")) {
            throw new Exception ("No s'ha esborrat per \n " . $_db->getLastError());
        }
    }
    
    private static function cast($sourceObject, $destinationObject) {
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

