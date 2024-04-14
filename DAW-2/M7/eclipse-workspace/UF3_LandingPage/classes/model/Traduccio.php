<?php

class Traduccio {
    private $id;
    private $variable;
    private $idioma_id;
    private $valor;
    private $created_at;
    private $updated_at;
    private $idioma;
    
    public function __construct($id, $variable, $idioma_id, $valor, $created_at = null, $updated_at = null, $idioma = null){
        $this->id = $id;
        $this->variable = $variable;
        $this->idioma_id = $idioma_id;
        $this->valor = $valor;
        $this->created_at = $created_at;
        $this->updated_at = $updated_at;
        $this->idioma = $idioma;
    }

    public function getId(){
        return $this->id;
    }
    public function getVariable(){
        return $this->variable;
    }
    public function getIdioma_id(){
        return $this->idioma_id;
    }
    public function getValor(){
        return $this->valor;
    }
    public function getCreated_at(){
        return $this->created_at;
    }
    public function getUpdated_at(){
        return $this->updated_at;
    }
    public function getIdioma(){
        return $this->idioma;
    }
    public function setId($id){
        $this->id = $id;
    }
    public function setVariable($variable){
        $this->variable = $variable;
    }
    public function setIdioma_id($idioma_id){
        $this->idioma_id = $idioma_id;
    }
    public function setValor($valor){
        $this->valor = $valor;
    }
    public function setCreated_at($created_at){
        $this->created_at = $created_at;
    }
    public function setUpdated_at($updated_at){
        $this->updated_at = $updated_at;
    }
    public function setIdioma($idioma){
        $this->idioma = $idioma;
    }
}

