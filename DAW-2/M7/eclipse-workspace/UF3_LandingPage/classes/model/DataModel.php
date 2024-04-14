<?php

class DataModel {
    /*
     * DIFERENCIES ENTRE MODEL ESTÀTIC I DINÀMIC
     * - No es pot implementar l'interface Crudable, perquè els métodes d'una interface sempre son públics i no estátics, per tant no puc fer els métodes estàtics.
     * - No es poden emplear dos usuaris per les operacions, és a dir, no és pot emplear l'usuari consulta (només pot fer SELECT) per la funció read() o getById i
     *   l'usuari generic que pot fer totes les operacions (SELECT, INSERT, UPDATE, DELETE) en tots els métodes. Això es degut a que al ser una clase estática, una
     *   vegada creada l'instancia que conecta amb la base de dades, no es pot canviar dinámicament.
     */
    
    private static $db_generic;

    public static function create($data){
        $dataInsert = [$data->getId(), $data->getData(), $data->getHora()];
        self::getDb_generic()->executeSQL("INSERT INTO `tbl_data` (id, data, hora) VALUES (?,?,?)", $dataInsert);
    }
    
    public static function read($data = null){
        $dates = self::getDb_generic()->executeSQL("SELECT * FROM `tbl_data` ORDER BY `id` DESC");
        if (!$dates){
            return null;
        }
        
        $datesObj = array();
        foreach ($dates as $fila) {
            $datesObj[] = new Data($fila["id"], $fila["data"], $fila["hora"]);
        }
        return $datesObj;
    }
    
    public static function update($data){
        $dataUpdate = [$data->getData(), $data->getHora(), $data->getId()];
        self::getDb_generic()->executeSQL("UPDATE `tbl_data` SET data = ?, hora = ? WHERE id = ?", $dataUpdate);
    }
    
    public static function delete($data){
        self::getDb_generic()->executeSQL("DELETE FROM `tbl_data` WHERE id = ?", [$data->getId()]);
    }
    
    public static function getById($id){
        $data = self::getDb_generic()->executeSQL("SELECT * FROM `tbl_data` WHERE id = ?", [$id]);
        if (!$data){
            return null;
        }
        
        $dataObj = new Data($data[0]["id"], $data[0]["data"], $data[0]["hora"]);
        return $dataObj;
    }
    
    public static function getDb_generic(){
        return self::$db_generic = DataBase::getInstance();
    }
}

