<?php
    error_reporting(E_ALL);
    ini_set('display_errors', 1);
    
    require_once "bootstrap.php";
    
    try {
        $qb = $em->createQueryBuilder();
        $qb ->select("e")
            ->from("Entrada", "e");
        $query = $qb->getQuery();
        $entrades = $query->getResult();
        
        echo "<pre>";
        var_dump($entrades);
        echo "</pre>";
        
    } catch (Exception $e) {
        echo "Error: " . $e->getMessage();
    }