<?php
namespace model;

use PDO;
use PDOException;
use Doctrine\Common\Collections\ArrayCollection;

class UserModel implements Crudable {
    private $db;
    
    public function __construct() {
        $dbConfig = DbConfig::getInstance();
        try {
            $this->db = new PDO("mysql:host=" . $dbConfig->getHost() . ";dbname=" . $dbConfig->getDbname(), $dbConfig->getUser(), $dbConfig->getPassword());
            $this->db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        } catch (PDOException $e) {
            echo "Connexió fallida: " . $e->getMessage();
        }
    }

    public function create($user) {
        $stmt = $this->db->prepare("INSERT INTO `USER` (id, name, surname, email, password, phone, dateOfBirth) VALUES (:id, :name, :surname, :email, :password, :phone, :dateOfBirth)");
        $this->bindUserParams($stmt, $user);
        
        if ($stmt->execute()) {
            return $this->db->lastInsertId();
        }
        return false;
    }
    
    public function read($user = null) {
        $stmt = $this->db->query("SELECT * FROM `USER` ORDER BY `id` DESC");
        $users = new ArrayCollection();
        while ($col = $stmt->fetch(PDO::FETCH_ASSOC)) {
            $userObject = $this->mapToUser($col);
            $users->add($userObject);
        }
        
        return $users;
    }

    public function update($user) {
        $stmt = $this->db->prepare("UPDATE `USER` SET name = :name, surname = :surname, email = :email, password = :password, phone = :phone, dateOfBirth = :dateOfBirth WHERE id = :id");
        $this->bindUserParams($stmt, $user);
        
        return $stmt->execute();
    }

    public function delete($user) {
        $stmt = $this->db->prepare("DELETE FROM `USER` WHERE id = :id");
        $stmt->bindParam(":id", $user->getId());
        
        return $stmt->execute();
    }
    
    public function getById($userId) {
        $stmt = $this->db->prepare("SELECT * FROM `USER` WHERE id = :id");
        $stmt->bindParam(":id", $userId);
        $stmt->execute();
        $col = $stmt->fetch(PDO::FETCH_ASSOC);
        if ($col) {
            return $this->mapToUser($col);
        }
        
        return null;
    }
    
    public function getByEmailAndPassword($email, $password) {
        $stmt = $this->db->prepare("SELECT * FROM `USER` WHERE email = :email AND password = :password");
        $stmt->bindParam(":email", $email);
        $stmt->bindParam(":password", $password);
        $stmt->execute();
        $col = $stmt->fetch(PDO::FETCH_ASSOC);
        if ($col) {
            return $this->mapToUser($col);
        }
        
        return null;
    }
    
    private function bindUserParams($stmt, $user) {
        $stmt->bindParam(":id", $user->getId());
        $stmt->bindParam(":name", $user->getName());
        $stmt->bindParam(":surname", $user->getSurname());
        $stmt->bindParam(":email", $user->getEmail());
        $stmt->bindParam(":password", $user->getPassword());
        $stmt->bindParam(":phone", $user->getPhone());
        $stmt->bindParam(":dateOfBirth", $user->getDateOfBirth());
    }

    private function mapToUser($col) {
        $user = new User($col["id"], $col["name"], $col["surname"], $col["email"], $col["password"], $col["phone"], $col["dateOfBirth"], $col["dateCreated"], $col["dateUpdated"]);
        return $user;
    }
}
