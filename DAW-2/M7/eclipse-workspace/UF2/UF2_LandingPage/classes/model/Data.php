<?php

class Data {
    private $id;
    private $data;
    private $hora;

    public function __construct($id, $data, $hora){
        $this->id = $id;
        $this->data = $data;
        $this->hora = $hora;
    }
    
    public function getId(){
        return $this->id;
    }
    public function getData(){
        return $this->data;
    }
    public function getHora(){
        return $this->hora;
    }
    public function setId($id){
        $this->id = $id;
    }
    public function setData($data){
        $this->data = $data;
    }
    public function setHora($hora){
        $this->hora = $hora;
    }
}

