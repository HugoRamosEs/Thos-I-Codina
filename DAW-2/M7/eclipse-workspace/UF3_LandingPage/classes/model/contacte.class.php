<?php

class Contacte {
    public $nom;
    public $mail;
    public $msg;
    public $data;
    
    public function __construct($nom, $mail, $msg, $data){
        $this->nom = $nom;
        $this->mail = $mail;
        $this->msg = $msg;
        $this->data = $data;
    }
}

?>