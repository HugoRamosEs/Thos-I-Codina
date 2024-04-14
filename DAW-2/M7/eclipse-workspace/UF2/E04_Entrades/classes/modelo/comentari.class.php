<?php

class Comentari {
    private $data;
    private $nom;
    private $mail;
    private $experiencia;
    private $missatge;
    

    public function __construct($nom, $email, $experiencia, $missatge, $data=null) {
        $this->nom = $nom;
        $this->mail = $email;
        $this->experiencia = $experiencia;
        $this->missatge = $missatge;
        $this->data = ($data==null) ? date("Y-m-d") : $data;
    }
    
    /**
     * @return mixed
     */
    public function getNom() {
        return $this->nom;
    }
    
    public function setNom($param) {
        $this->nom = $param;
    }

    /**
     * @return mixed
     */
    public function getMail() {
        return $this->mail;
    }
    
    public function setMail($param) {
        $this->mail = $param;
    }

    /**
     * @return mixed
     */
    public function getMissatge() {
        return $this->missatge;
    }
    public function setMissatge($param) {
        $this->missatge = $param;
    }
    /**
     * @return mixed
     */
    public function getExperiencia() {
        return $this->experiencia;
    }
    public function setExperiencia($param) {
        $this->experiencia = $param;
    }
    /**
     * @return mixed
     */
    public function getData() {
        return $this->data;
    }
    public function setData($param) {
        $this->data = $param;
    }
   
}

?>

