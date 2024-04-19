<?php
namespace curriculum;

class Experiencia {
    private $periode;
    private $empresa;
    private $carrec;
    private $descripcio;
    

    /**
     * @return mixed
     */
    public function getPeriode()
    {
        return $this->periode;
    }
    /**
     * @return mixed
     */
    public function getEmpresa()
    {
        return $this->empresa;
    }

    /**
     * @return mixed
     */
    public function getCarrec()
    {
        return $this->carrec;
    }

    /**
     * @return mixed
     */
    public function getDescripcio()
    {
        return $this->descripcio;
    }

    /**
     * @param mixed $empresa
     */
    public function setPeriode($periode)
    {
        $this->periode = $periode;
    }
    /**
     * @param mixed $empresa
     */
    public function setEmpresa($empresa)
    {
        $this->empresa = $empresa;
    }

    /**
     * @param mixed $carrec
     */
    public function setCarrec($carrec)
    {
        $this->carrec = $carrec;
    }

    /**
     * @param mixed $descripcio
     */
    public function setDescripcio($descripcio)
    {
        $this->descripcio = $descripcio;
    }

    
    
    
}

