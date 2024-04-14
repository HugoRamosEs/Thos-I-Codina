<?php

class Idioma {
    private $id;
    private $iso;
    private $imatge;
    private $actiu;
    private $created_at;
    private $updated_at;
    private $traduccions;
    
    public function __construct($id, $iso, $imatge, $actiu, $created_at = null, $updated_at = null, $traduccions = null){
        $this->id = $id;
        $this->iso = $iso;
        $this->imatge = $imatge;
        $this->actiu = $actiu;
        $this->created_at = $created_at;
        $this->updated_at = $updated_at;
        $this->traduccions = $traduccions;
    }
   
    public function getId(){
        return $this->id;
    }
    public function getIso(){
        return $this->iso;
    }
    public function getImatge(){
        return $this->imatge;
    }
    public function getActiu(){
        return $this->actiu;
    }
    public function getCreated_at(){
        return $this->created_at;
    }
    public function getUpdated_at(){
        return $this->updated_at;
    }
    public function getTraduccions(){
        return $this->traduccions;
    }
    public function setId($id){
        $this->id = $id;
    }
    public function setIso($iso){
        $this->iso = $iso;
    }
    public function setImatge($imatge){
        $this->imatge = $imatge;
    }
    public function setActiu($actiu){
        $this->actiu = $actiu;
    }
    public function setCreated_at($created_at){
        $this->created_at = $created_at;
    }
    public function setUpdated_at($updated_at){
        $this->updated_at = $updated_at;
    }
    public function setTraduccions($traduccions){
        $this->traduccions = $traduccions;
    }
}

