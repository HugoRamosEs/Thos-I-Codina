<?php

class Zona {
    private $id;
    private $descripcio;
    
    public function __construct($id, $descripcio=null) {
       $this->id = $id;
       $this->descripcio = $descripcio;
    }
    
    public function getId() {
        return $this->id;
    }
    public function setId($id) {
        $this->id = $id;
    }
    
    public function getDescripcio() {
        return $this->descripcio;
    }
    public function setDescripcio($descripcio) {
        $this->descripcio = $descripcio;
    }
}

