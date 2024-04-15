<?php

class Comentari {
    public $nom;
    public $mail;
    public $opcio;
    public $msg;
    public $data;
    
    public function __construct($nom, $mail, $opcio, $msg, $data){
        $this->nom = $nom;
        $this->mail = $mail;
        $this->opcio = $opcio;
        $this->msg = $msg;
        $this->data = $data;
    }
}

?>