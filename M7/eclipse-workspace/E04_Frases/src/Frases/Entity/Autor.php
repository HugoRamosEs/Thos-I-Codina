<?php
namespace Frases\Entity;

use Doctrine\Common\Collections\ArrayCollection;

/**
 * Autor
 *
 * @Entity
 * @Table(name="tbl_autors")
 */
class Autor {
    /**
     * @var int
     *
     * @Id
     * @GeneratedValue(strategy="AUTO")
     * @Column(type="integer", nullable=false)
     */
    private $id;
    
    /**
     * @var string
     * 
     * @column(type="string", length=50, nullable=false)
     */
    private $nombre;
    
    /**
     * @var string
     * 
     * @column(type="string", length=90)
     */
    private $descripcion;
    
    /**
     * @var Frase[]
     * 
     * @OneToMany(targetEntity="Frase", mappedBy="autor")
     */
    private $frases;
    
    public function __construct(){
        $this->frases = new ArrayCollection();
    }
    
    /**
     * Add frase
     *
     * @param Frase $frase
     * @return Autor
     */
    public function addFrase(Frase $frase){
        $this->frases[] = $frase;
        $frase->setAutor($this);
        return $this;
    }
    
    public function getId(){
        return $this->id;
    }
    public function getNombre(){
        return $this->nombre;
    }
    public function getDescripcion(){
        return $this->descripcion;
    }
    public function getFrases(){
        return $this->frases;
    }
    public function setId($id){
        $this->id = $id;
    }
    public function setNombre($nombre){
        $this->nombre = $nombre;
    }
    public function setDescripcion($descripcion){
        $this->descripcion = $descripcion;
    }
    public function setFrases($frases){
        $this->frases = $frases;
    }
}

