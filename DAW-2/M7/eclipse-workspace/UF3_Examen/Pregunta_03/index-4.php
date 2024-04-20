<?php
    error_reporting(E_ALL);
    ini_set('display_errors', 1);
    
    require_once "bootstrap.php";
    
    try {
        $zones = $em->getRepository(Zona::class)->informacio();
        
        echo "<pre>";
        var_dump($zones);
        echo "</pre>";
        
    } catch (Exception $e) {
        echo "Error: " . $e->getMessage();
    }