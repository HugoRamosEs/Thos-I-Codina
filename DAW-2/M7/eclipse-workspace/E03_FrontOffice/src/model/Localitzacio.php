<?php

namespace model;

/**
 * Localització
 *
 * @Entity(repositoryClass="repository\LocalitzacioRepository")
 * @Table( name="LOCALITZACIO" )
 */
class Localitzacio{
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
	 * @Column(type="string", length=90, name="LLOC")
	 */
	private $lloc;

	/**
	 * @var string
	 *
	 * @Column(type="string", length=90, name="ACRECA")
	 */
	private $adreca;

	/**
	 * @var string
	 *
	 * @Column(type="string", length=90, name="LOCALITAT")
	 */
	private $localitat;
	
	public function parseToArray() {
        return [
            "id" => $this->getId() ? $this->getId() : null,
            "lloc" => $this->getLloc() ? $this->getLloc() : null,
            "adreca" => $this->getAdreca() ? $this->getAdreca() : null,
            "localitat" => $this->getLocalitat() ? $this->getLocalitat() : null,
        ];
	}
	
	/**
	 * Set id
	 *
	 * @param integer $id
	 * 
	 * @return Localitzacio
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
     * Set lloc
     *
     * @param string $lloc
     *
     * @return Localitzacio
     */
    public function setLloc($lloc)
    {
        $this->lloc = $lloc;

        return $this;
    }

    /**
     * Get lloc
     *
     * @return string
     */
    public function getLloc()
    {
        return $this->lloc;
    }

    /**
     * Set adreca
     *
     * @param string $adreca
     *
     * @return Localitzacio
     */
    public function setAdreca($adreca)
    {
        $this->adreca = $adreca;

        return $this;
    }

    /**
     * Get adreca
     *
     * @return string
     */
    public function getAdreca()
    {
        return $this->adreca;
    }

    /**
     * Set localitat
     *
     * @param string $localitat
     *
     * @return Localitzacio
     */
    public function setLocalitat($localitat)
    {
        $this->localitat = $localitat;

        return $this;
    }

    /**
     * Get localitat
     *
     * @return string
     */
    public function getLocalitat()
    {
        return $this->localitat;
    }
}
