<?php

class Comentari {
    private $data;
    private $nom;
    private $pais;
    private $experiencia;
    private $comentari;
    private $email;
    
    public function __construct() {}

    public function __clone(){
        $this->setData(null);
    }
    
    public function getData()
    {
        return $this->data;
    }

    public function getNom()
    {
        return $this->nom;
    }

    public function getPais()
    {
        return $this->pais;
    }

    public function getExperiencia()
    {
        return $this->experiencia;
    }

    public function getComentari()
    {
        return $this->comentari;
    }

    public function getEmail()
    {
        return $this->email;
    }

    public function setData($data)
    {
        $this->data = $data;
    }

    public function setNom($nom)
    {
        $this->nom = $nom;
    }

    public function setPais($pais)
    {
        $this->pais = $pais;
    }

    public function setExperiencia($experiencia)
    {
        $this->experiencia = $experiencia;
    }

    public function setComentari($comentari)
    {
        $this->comentari = $comentari;
    }

    public function setEmail($email)
    {
        $this->email = $email;
    }

    
 
    
}