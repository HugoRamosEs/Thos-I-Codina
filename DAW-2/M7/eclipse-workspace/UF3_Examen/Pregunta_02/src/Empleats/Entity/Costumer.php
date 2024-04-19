<?php

namespace Empleats\Entity;

/**
 * Costumer
 */
class Costumer
{
    /**
     * @var string
     */
    private $cif;

    /**
     * @var string
     */
    private $name;


    /**
     * Set cif.
     *
     * @param string $cif
     *
     * @return Costumer
     */
    public function setCif($cif)
    {
        $this->cif = $cif;

        return $this;
    }

    /**
     * Get cif.
     *
     * @return string
     */
    public function getCif()
    {
        return $this->cif;
    }

    /**
     * Set name.
     *
     * @param string $name
     *
     * @return Costumer
     */
    public function setName($name)
    {
        $this->name = $name;

        return $this;
    }

    /**
     * Get name.
     *
     * @return string
     */
    public function getName()
    {
        return $this->name;
    }
}
