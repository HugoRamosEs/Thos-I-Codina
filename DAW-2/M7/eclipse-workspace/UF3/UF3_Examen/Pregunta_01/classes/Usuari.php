<?php
namespace curriculum;

class Usuari {
    private $id;
    private $nom;
    private $cognom;
    private $descripcio;
    private $info;
    private $habilitats;
    private $experiencia;
    private $estudis;
    
    
    /**
     * @return mixed
     */
    public function getId()
    {
        return $this->id;
    }
    
    /**
     * @return mixed
     */
    public function getNom()
    {
        return $this->nom;
    }

    /**
     * @return mixed
     */
    public function getCognom()
    {
        return $this->cognom;
    }

    /**
     * @return mixed
     */
    public function getDescripcio()
    {
        return $this->descripcio;
    }

    /**
     * @return mixed
     */
    public function getInfo()
    {
        return $this->info;
    }

    /**
     * @return mixed
     */
    public function getHabilitats()
    {
        return $this->habilitats;
    }

    /**
     * @return mixed
     */
    public function getExperiencia()
    {
        return $this->experiencia;
    }

    /**
     * @return mixed
     */
    public function getEstudis()
    {
        return $this->estudis;
    }

    /**
     * @param mixed $nom
     */
    public function setId($id)
    {
        $this->id = $id;
    }
    /**
     * @param mixed $nom
     */
    public function setNom($nom)
    {
        $this->nom = $nom;
    }

    /**
     * @param mixed $coggnom
     */
    public function setCognom($cognom)
    {
        $this->cognom = $cognom;
    }

    /**
     * @param mixed $descripcio
     */
    public function setDescripcio($descripcio)
    {
        $this->descripcio = $descripcio;
    }

    /**
     * @param mixed $info
     */
    public function setInfo($info)
    {
        $this->info = $info;
    }

    /**
     * @param mixed $habilitats
     */
    public function setHabilitats($habilitats)
    {
        $this->habilitats = $habilitats;
    }

    /**
     * @param mixed $experiencia
     */
    public function setExperiencia($experiencia)
    {
        $this->experiencia = $experiencia;
    }

    /**
     * @param mixed $estudis
     */
    public function setEstudis($estudis)
    {
        $this->estudis = $estudis;
    }

    
    
}

