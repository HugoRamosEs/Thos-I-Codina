<?php
namespace curriculum;

class Habilitat {
    private $categoria;
    private $valoracio;
    

    /**
     * @return mixed
     */
    public function getCategoria()
    {
        return $this->categoria;
    }

    /**
     * @return mixed
     */
    public function getValoracio()
    {
        return $this->valoracio;
    }

    /**
     * @param mixed $categoria
     */
    public function setCategoria($categoria)
    {
        $this->categoria = $categoria;
    }

    /**
     * @param mixed $valoracio
     */
    public function setValoracio($valoracio)
    {
        $this->valoracio = $valoracio;
    }

    

    
    
}

