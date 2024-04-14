<?php

class EntradaModel implements Crudable {
    public $db_generic;
    public $db_consulta;
    public $esdevenimentModel;
    public $localitzacioModel;
    public $zonaModel;
    public $pagamentModel;

    public function __construct(){
        $this->db_generic = DataBase::getInstance();
        $this->db_consulta = DataBase::getInstance(1);
        $this->esdevenimentModel = new EsdevenimentModel();
        $this->localitzacioModel = new LocalitzacioModel();
        $this->zonaModel = new ZonaModel();
        $this->pagamentModel = new PagamentModel();
    }

    public function create($entrada){
        $entradaInsert = [$entrada->esdeveniment_id, $entrada->data_id, $entrada->loc_id, $entrada->zona_id, $entrada->pagament_id, $entrada->id, $entrada->fila, $entrada->butaca, $entrada->dni];
        $this->db_generic->executeSQL("INSERT INTO `tbl_entrada` (esdeveniment_id, data_id, loc_id, zona_id, pagament_id, id, fila, butaca, dni) VALUES (?,?,?,?,?,?,?,?,?)", $entradaInsert);
    }

    public function read($entrada = null){
        $entrades = $this->db_consulta->executeSQL("SELECT * FROM `tbl_entrada`");
        if (!$entrades){
            return null;
        }
        
        $entradesObj = array();
        foreach ($entrades as $e){
            $entradaObj = new Entrada($e["esdeveniment_id"], $e["data_id"], $e["loc_id"], $e["zona_id"], $e["pagament_id"], $e["id"], $e["fila"], $e["butaca"], $e["dni"]);

            $esdeveniment = $this->esdevenimentModel->getById($e["esdeveniment_id"]);
            $data = DataModel::getById($e["data_id"]);
            $localitzacio = $this->localitzacioModel->getById($e["loc_id"]);
            $zona = $this->zonaModel->getById($e["zona_id"]);
            $pagament = $this->pagamentModel->getById($e["pagament_id"]);

            $entradaObj->esdeveniment = $esdeveniment;
            $entradaObj->data = $data;
            $entradaObj->loc = $localitzacio;
            $entradaObj->zona = $zona;
            $entradaObj->pagament = $pagament;

            $entradesObj[] = $entradaObj;
        }
        return $entradesObj;
    }

    public function update($entrada){
        $entradaUpdate = [$entrada->esdeveniment_id, $entrada->data_id, $entrada->loc_id, $entrada->zona_id, $entrada->pagament_id, $entrada->fila, $entrada->butaca, $entrada->dni, $entrada->id];
        $this->db_generic->executeSQL("UPDATE `tbl_entrada` SET esdeveniment_id = ?, data_id = ?, loc_id = ?, zona_id = ?, pagament_id = ?, fila = ?, butaca = ?, dni = ? WHERE id = ?", $entradaUpdate);
    }

    public function delete($entrada){
        $this->db_generic->executeSQL("DELETE FROM `tbl_entrada` WHERE id = ?", [$entrada->id]);
    }

    public function getById($id){
        $e = $this->db_consulta->executeSQL("SELECT * FROM `tbl_entrada` WHERE id = ?", [$id]);
        if (!$e){
            return null;
        }
        
        $entradaObj = new Entrada($e[0]["esdeveniment_id"], $e[0]["data_id"], $e[0]["loc_id"], $e[0]["zona_id"], $e[0]["pagament_id"], $e[0]["id"], $e[0]["fila"], $e[0]["butaca"], $e[0]["dni"]);
        
        $esdeveniment = $this->esdevenimentModel->getById($e[0]["esdeveniment_id"]);
        $data = DataModel::getById($e[0]["data_id"]);
        $localitzacio = $this->localitzacioModel->getById($e[0]["loc_id"]);
        $zona = $this->zonaModel->getById($e[0]["zona_id"]);
        $pagament = $this->pagamentModel->getById($e[0]["pagament_id"]);
        
        $entradaObj->esdeveniment = $esdeveniment;
        $entradaObj->data = $data;
        $entradaObj->loc = $localitzacio;
        $entradaObj->zona = $zona;
        $entradaObj->pagament = $pagament;

        return $entradaObj;
    }
}

