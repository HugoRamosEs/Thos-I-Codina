<?php
namespace curriculum;

use PDO;
use PDOException;

class UsuariModel {
    private const DSN = "mysql:host=localhost;dbname=M07UF3Examen2024";
    private const USER = "usr_generic";
    private const PASSWORD = "2024@Thos";  

    public static function getAll($usuari = null){
        try {
            $db = new PDO(UsuariModel::DSN, UsuariModel::USER, UsuariModel::PASSWORD);
            $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        }catch (PDOException $e) {
            echo $e->getMessage();
        }
        
        $usuaris = array();
        $res = $db->query("SELECT * FROM `tbl_usuaris` ORDER BY `id` DESC");
        while ($col = $res->fetch(PDO::FETCH_ASSOC)) {
            $u = new Usuari($col['id'], $col['nom'], $col['cognom'], $col['descripcio'], $col['info'], $col['habilitats'], $col['experiencia'], $col['estudis']);
            $usuaris[] = $u;
        }
        
        return $usuaris;
    }
    
    public static function getOneByName($usuari){
        try {
            $db = new PDO(UsuariModel::DSN, UsuariModel::USER, UsuariModel::PASSWORD);
            $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        }catch (PDOException $e) {
            echo $e->getMessage();
        }
        
        $stmt = $db->prepare("SELECT * FROM `tbl_idiomes` WHERE nom = :nom");
        $stmt->bindParam(":nom", $usuari->getNom());
        $stmt->execute();
        $col = $stmt->fetch(PDO::FETCH_ASSOC);
        if ($col) {
            $usuari = new Usuari($col['id'], $col['nom'], $col['cognom'], $col['descripcio'], $col['info'], $col['habilitats'], $col['experiencia'], $col['estudis']);
            return $usuari;
        }else {
            return null;
        }
    }
    
}

