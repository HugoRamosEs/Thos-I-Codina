<?php
namespace curriculum;

class Estudi {
    private $any;
    private $titol;
    private $descripcio;
    

    
    /**
     * @return mixed
     */
    public function getAny()
    {
        return $this->any;
    }

    /**
     * @return mixed
     */
    public function getTitol()
    {
        return $this->titol;
    }

    /**
     * @return mixed
     */
    public function getDescripcio()
    {
        return $this->descripcio;
    }

    /**
     * @param mixed $any
     */
    public function setAny($any)
    {
        $this->any = $any;
    }

    /**
     * @param mixed $titol
     */
    public function setTitol($titol)
    {
        $this->titol = $titol;
    }

    /**
     * @param mixed $descripcio
     */
    public function setDescripcio($descripcio)
    {
        $this->descripcio = $descripcio;
    }

    
    
}

