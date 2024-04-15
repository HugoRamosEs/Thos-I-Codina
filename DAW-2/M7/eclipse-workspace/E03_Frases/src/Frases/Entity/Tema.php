<?php
namespace Frases\Entity;

use Doctrine\Common\Collections\ArrayCollection;

/**
 * Tema
 *
 * @Entity
 * @Table(name="tbl_temes")
 */
class Tema {
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
     * @var Frase[] 
     * 
     * @ManyToMany(targetEntity="Frase", mappedBy="temes")
     * @JoinTable(name="tbl_frases_temes")
     */
    private $frases;
    
    public function __construct(){
        $this->frases = new ArrayCollection();
    }
    
    /**
     * Add Frase
     *
     * @param Frase $frase
     * @return Tema
     */
    public function addFrase(Frase $frase){
        $this->frases[] = $frase;
        return $this;
    }
    
    public function getId(){
        return $this->id;
    }
    public function getNombre(){
        return $this->nombre;
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
    public function setFrases($frases){
        $this->frases = $frases;
    }
}

