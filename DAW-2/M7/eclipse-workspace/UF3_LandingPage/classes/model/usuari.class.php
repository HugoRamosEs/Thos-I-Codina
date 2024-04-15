<?php

class Usuari {
    public $email;
    public $password;
    public $tipusIdent;
    public $numeroIdent;
    public $nom;
    public $cognoms;
    public $sexe;
    public $naixement;
    public $adreca;
    public $codiPostal;
    public $poblacio;
    public $provincia;
    public $telefon;
    public $imatge;
    public $navegador;
    public $plataforma;
    
    public function __construct($email, $password, $tipusIdent, $numeroIdent, $nom, $cognoms, $sexe, $naixement, $adreca, $codiPostal, $poblacio, $provincia, $telefon, $imatge, $navegador, $plataforma) {
        $this->email = $email;
        $this->password = $password;
        $this->tipusIdent = $tipusIdent;
        $this->numeroIdent = $numeroIdent;
        $this->nom = $nom;
        $this->cognoms = $cognoms;
        $this->sexe = $sexe;
        $this->naixement = $naixement;
        $this->adreca = $adreca;
        $this->codiPostal = $codiPostal;
        $this->poblacio = $poblacio;
        $this->provincia = $provincia;
        $this->telefon = $telefon;
        $this->imatge = $imatge;
        $this->navegador = $navegador;
        $this->plataforma = $plataforma;
    }
}

