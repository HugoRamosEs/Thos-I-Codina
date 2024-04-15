<?php
namespace Frases\Entity;

use Doctrine\Common\Collections\ArrayCollection;

/**
 * Frase
 * 
 * @Entity
 * @Table(name="tbl_frases")
 */
class Frase {
    /**
     * @var int
     *
     * @Id
     * @GeneratedValue(strategy="AUTO")
     * @Column(type="integer", nullable=false)
     */
    private $id;
    
    /**
     * @var Autor
     *
     * @ManyToOne(targetEntity="Autor", inversedBy="frases")
     */
    private $autor;
    
    /**
     * @var string
     * 
     * @Column(type="string", length=550, nullable=false)
     */ 
    private $texto;
    
    /**
     * @var Tema[]
     *
     * @ManyToMany(targetEntity="Tema", inversedBy="frases")
     * @JoinTable(name="tbl_frases_temes")
     */
    private $temes;
    
    public function __construct(){
        $this->temes = new ArrayCollection();
    }
    
    /**
     * Add Tema
     *
     * @param Tema $tema
     * @return Frase
     */
    public function addTema(Tema $tema){
        $this->temes[] = $tema;
        $tema->addFrase($this);
        return $this;
    }
    
    public function getId(){
        return $this->id;
    }
    public function getAutor(){
        return $this->autor;
    }
    public function getTexto(){
        return $this->texto;
    }
    public function getTemes(){
        return $this->temes;
    }
    public function setId($id){
        $this->id = $id;
    }
    public function setAutor($autor){
        $this->autor = $autor;
    }
    public function setTexto($texto){
        $this->texto = $texto;
    }
    public function setTemes($temes){
        $this->temes = $temes;
    }
}


