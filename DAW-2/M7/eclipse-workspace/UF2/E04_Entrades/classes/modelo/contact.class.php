<?php

class Contact {
    public $nom;
    public $mail;
    public $missatge;
    public $data;
    
    public function __construct($nom, $b, $c, $d){
        $this->nom = $nom;
        $this->mail = $b;
        $this->missatge = $c;
        $this->data = $d;
    }
}

