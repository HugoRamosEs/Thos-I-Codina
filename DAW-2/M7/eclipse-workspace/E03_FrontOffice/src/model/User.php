<?php
namespace model;

class User {
    private $id;
    private $name;
    private $surname;
    private $email;
    private $password;
    private $phone;
    private $dateOfBirth;
    private $dateCreated;
    private $dateUpdated;
    
    public function __construct($id, $name, $surname, $email, $password, $phone, $dateOfBirth, $dateCreated = null, $dateUpdated = null) {
        $this->id = $id;
        $this->name = $name;
        $this->surname = $surname;
        $this->email = $email;
        $this->password = $password;
        $this->phone = $phone;
        $this->dateOfBirth = $dateOfBirth;
        $this->dateCreated = $dateCreated;
        $this->dateUpdated = $dateUpdated;
    }
    
    public function getId() {
        return $this->id;
    }
    public function getName() {
        return $this->name;
    }
    public function getSurname() {
        return $this->surname;
    }
    public function getEmail() {
        return $this->email;
    }
    public function getPassword() {
        return $this->password;
    }
    public function getPhone() {
        return $this->phone;
    }
    public function getDateOfBirth() {
        return $this->dateOfBirth;
    }
    public function getDateCreated() {
        return $this->dateCreated;
    }
    public function getDateUpdated() {
        return $this->dateUpdated;
    }
    public function setId($id) {
        $this->id = $id;
    }
    public function setName($name) {
        $this->name = $name;
    }
    public function setSurname($surname) {
        $this->surname = $surname;
    }
    public function setEmail($email) {
        $this->email = $email;
    }
    public function setPassword($password) {
        $this->password = $password;
    }
    public function setPhone($phone) {
        $this->phone = $phone;
    }
    public function setDateOfBirth($dateOfBirth) {
        $this->dateOfBirth = $dateOfBirth;
    }
    public function setDateCreated($dateCreated) {
        $this->dateCreated = $dateCreated;
    }
    public function setDateUpdated($dateUpdated) {
        $this->dateUpdated = $dateUpdated;
    } 
}
