<?php

namespace model;

/**
 * Event
 *
 * @Entity(repositoryClass="repository\EventRepository")
 * @Table( name="EVENT" )
 */
class Event{
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
	 * @Column(type="string", length=90, name="TITOL")
	 */
	private $titol;

	/**
	 * @var string
	 *
	 * @Column(type="string", length=90, name="SUTBITOL")
	 */
	private $subtitol;

	/**
	 * @var string
	 *
	 * @Column(type="string", length=90, name="IMATGE")
	 */
	private $imatge;
	
	public function parseToArray() {
        return [
            "id" => $this->getId() ? $this->getId() : null,
            "titol" => $this->getTitol() ? $this->getTitol() : null,
            "subtitol" => $this->getSubtitol() ? $this->getSubtitol() : null,
            "imatge" => $this->getImatge() ? $this->getImatge() : null,
        ];
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
     * Set titol
     *
     * @param string $titol
     *
     * @return Event
     */
    public function setTitol($titol)
    {
        $this->titol = $titol;

        return $this;
    }

    /**
     * Get titol
     *
     * @return string
     */
    public function getTitol()
    {
        return $this->titol;
    }

    /**
     * Set subtitol
     *
     * @param string $subtitol
     *
     * @return Event
     */
    public function setSubtitol($subtitol)
    {
        $this->subtitol = $subtitol;

        return $this;
    }

    /**
     * Get subtitol
     *
     * @return string
     */
    public function getSubtitol()
    {
        return $this->subtitol;
    }

    /**
     * Set imatge
     *
     * @param string $imatge
     *
     * @return Event
     */
    public function setImatge($imatge)
    {
        $this->imatge = $imatge;

        return $this;
    }

    /**
     * Get imatge
     *
     * @return string
     */
    public function getImatge()
    {
        return $this->imatge;
    }
}
