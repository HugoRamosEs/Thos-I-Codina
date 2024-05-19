<?php

namespace model;

/**
 * Zona
 *
 * @Entity(repositoryClass="repository\ZonaRepository")
 * @Table( name="ZONA" )
 */
class Zona{
	/**
	 * @var int
	 *
	 * @Id
	 * @GeneratedValue
	 * @Column(type="integer")
	 */
	private $id;

	/**
	 * @var string
	 *
	 * @Column(type="string", length=10, name="DESCRIPCIO")
	 */
	private $descripcio;
	
	public function parseToArray() {
        return [
            "id" => $this->getId() ? $this->getId() : null,
            "descripcio" => $this->getDescripcio() ? $this->getDescripcio() : null,
        ];
	}
	
	/**
     * Set id
     *
     * @param integer $id
     * 
     * @return Zona
     */
	public function setId($id) {
        $this->id = $id;
        
        return $this;
	}

    /**
     * Get id
     *
     * @return integer
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set descripcio
     *
     * @param string $descripcio
     *
     * @return Zona
     */
    public function setDescripcio($descripcio)
    {
        $this->descripcio = $descripcio;

        return $this;
    }

    /**
     * Get descripcio
     *
     * @return string
     */
    public function getDescripcio()
    {
        return $this->descripcio;
    }
}
