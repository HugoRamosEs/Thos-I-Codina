<?php

class EntradaModel {
    private $_table = "tbl_entrada";
    private $_db;
    
    public function __construct() {
        $this->_db = BaseDades::getInstance();
    }
    
    public function create(Entrada $params) {
        $sSql = "INSERT INTO {$this->_table} (id, fila, butaca, dni, esdeveniment_id, data_id, loc_id, zona_id, pagament_id) 
            VALUES (?,?,?,?,?,?,?,?,?);";
        $aParams = array ($params->id, $params->fila, $params->butaca, $params->dni, $params->esdeveniment->id, 
            $params->data->id, $params->localitzacio->id, $params->zona->id, $params->pagament->id);

        if (!$this->_db->execute($sSql, $aParams, "accio")) {
            throw new Exception ("No s'ha fet l'insert per: \n " . $this->_db->getLastError());
        }
    }
    public function read() {
        $retorn = array();
        $sSql = "SELECT * FROM {$this->_table}";
        
        if ($oResultat = $this->_db->execute($sSql)) {
            while ( ($aResult = $this->_db->obtenirFila($oResultat)) != null ) {
                $entrada = $this->cast($aResult, new Entrada());
                $mEsdev = new EsdevenimentModel();
                $esd = new Esdeveniment();
                $esd->id=$entrada->esdeveniment_id;
                $entrada->esdeveniment =  $mEsdev->getOneById($esd);
                
                $mData = new DataModel();
                $dt = new Data();
                $dt->id = $entrada->data_id;
                $entrada->data = $mData->getOneById($dt);
                
                $mLoc = new LocalitzacioModel();
                $loc = new Localitzacio();
                $loc->id = $entrada->loc_id;
                $entrada->localitzacio = $mLoc->getOneById($loc);
                
                $mZona = new ZonaModel();
                $zn = new Zona($entrada->zona_id);
                $entrada->zona = $mZona->getOneById($zn);
                
                $mPagament = new PagamentModel();
                $pg = new Pagament();
                $pg->id = $entrada->pagament_id;
                $entrada->pagament = $mPagament->getOneById($pg);
                
                $retorn[] = $entrada;
            }
        }
        
        return $retorn;
    }
    
    public function getOneById(Entrada $param) {
        $sSql = "SELECT * FROM {$this->_table} WHERE id=?;";
        
        if ($oResultat = $this->_db->execute($sSql, array($param->id))) {
            while ( ($aResult = $this->_db->obtenirFila($oResultat)) != null ) {
                $entrada = $this->cast($aResult, new Entrada());
                $mEsdev = new EsdevenimentModel();
                $esd = new Esdeveniment();
                $esd->id=$entrada->esdeveniment_id;
                $entrada->esdeveniment =  $mEsdev->getOneById($esd);
                
                $mData = new DataModel();
                $dt = new Data();
                $dt->id = $entrada->data_id;
                $entrada->data = $mData->getOneById($dt);
                
                $mLoc = new LocalitzacioModel();
                $loc = new Localitzacio();
                $loc->id = $entrada->loc_id;
                $entrada->localitzacio = $mLoc->getOneById($loc);
                
                $mZona = new ZonaModel();
                $zn = new Zona();
                $zn->id = $entrada->zona_id;
                $entrada->zona = $mZona->getOneById($zn);
                
                $mPagament = new PagamentModel();
                $pg = new Pagament();
                $pg->id = $entrada->pagament_id;
                $entrada->pagament = $mPagament->getOneById($pg);
            }
        }
        
        return $entrada;
    }
    
    public function update(Entrada $param) {
        $sSql = "UPDATE {$this->_table} SET fila=?, butaca=?, dni=?, esdeveniment_id=?, data_id=?, loc_id=?, zona_id=?, pagament_id=? WHERE id=?";
        $aParams = array ($param->fila, $param->butaca, $param->dni, $param->esdeveniment->id, $param->data->id, 
            $param->localitzacio->id, $param->zona->id, $param->pagament->id, $param->id);
        
        if (!$this->_db->execute($sSql, $aParams, "accio")) {
            throw new Exception ("No s'ha modificat per \n " . $this->_db->getLastError());
        }
    }
    public function delete(Entrada $param) {
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

