<?php
namespace Empleats\Entity;

use Doctrine\Common\Collections\ArrayCollection;

/**
 * Autor
 *
 * @Entity
 * @Table(name="tbl_project")
 */
class Project {
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
     * @Column(type="string", length=50, nullable=false)
     */
    private $name;
    
    /**
     * @var string
     *
     * @Column(type="string", length=250)
     */
    private $customer;
    
    /**
     * @var string
     *
     * @Column(type="string", length=250)
     */
    private $manager;
    
    
    public function getId()
    {
        return $this->id;
    }
    public function getName()
    {
        return $this->name;
    }
    public function getCustomer()
    {
        return $this->customer;
    }
    public function getManager()
    {
        return $this->manager;
    }
    public function setId($id)
    {
        $this->id = $id;
    }
    public function setName($name)
    {
        $this->name = $name;
    }
    public function setCustomer($customer)
    {
        $this->customer = $customer;
    }
    public function setManager($manager)
    {
        $this->manager = $manager;
    }
}
