<?php
namespace Empleats\Entity;

use Doctrine\Common\Collections\ArrayCollection;

/**
 * Autor
 *
 * @Entity
 * @Table(name="tbl_empleats")
 */
class Employee {
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
     * @Column(type="string", nullable=false)
     */
    private $name;
    
    /**
     * @var string
     *
     * @Column(type="string", length=50, nullable=false)
     */
    private $dni;
    
    /**
     * @var string
     *
     * @Column(type="string", length=550)
     */
    private $birthDate;
    
    /**
     * @var string
     *
     * @Column(type="string", length=550)
     */
    private $entryDate;
    
    
    public function getId()
    {
        return $this->id;
    }
    public function getName()
    {
        return $this->name;
    }
    public function getDni()
    {
        return $this->dni;
    }
    public function getBirthDate()
    {
        return $this->birthDate;
    }
    public function getEntryDate()
    {
        return $this->entryDate;
    }
    public function setId($id)
    {
        $this->id = $id;
    }
    public function setName($name)
    {
        $this->name = $name;
    }
    public function setDni($dni)
    {
        $this->dni = $dni;
    }
    public function setBirthDate($birthDate)
    {
        $this->birthDate = $birthDate;
    }
    public function setEntryDate($entryDate)
    {
        $this->entryDate = $entryDate;
    }
}
