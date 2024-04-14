<?php

class Entrada {
    private $id;
    private $fila;
    private $butaca;
    private $dni;
    private $esdeveniment;
    private $data;
    private $localitzacio;
    private $zona;
    private $pagament;
    
    private $esdeveniment_id;
    private $data_id;
    private $loc_id;
    private $zona_id;
    private $pagament_id;
    
    
    public function __set($property, $value) {
        if (property_exists($this, $property)) {
            $this->$property = $value;
        } else {
            throw new Exception("No existeix la propietat $property a Entrada");
        }
    }
    
    public function __get($property) {
        if (property_exists($this, $property)) {
            return $this->$property;
        } else {
            throw new Exception("No existeix la propietat $property a Entrada");
        }
    }
}

