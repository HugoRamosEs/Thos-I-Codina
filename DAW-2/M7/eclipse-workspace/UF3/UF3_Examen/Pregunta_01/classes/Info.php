<?php
namespace curriculum;

class Info {
    private $codi;
    private $fa;
    private $dada;
    

    
    /**
     * @return mixed
     */
    public function getCodi()
    {
        return $this->codi;
    }

    /**
     * @return mixed
     */
    public function getFa()
    {
        return $this->fa;
    }

    /**
     * @return mixed
     */
    public function getDada()
    {
        return $this->dada;
    }

    /**
     * @param mixed $codi
     */
    public function setCodi($codi)
    {
        $this->codi = $codi;
    }

    /**
     * @param mixed $fa
     */
    public function setFa($fa)
    {
        $this->fa = $fa;
    }

    /**
     * @param mixed $dada
     */
    public function setDada($dada)
    {
        $this->dada = $dada;
    }

    
    
    
}

