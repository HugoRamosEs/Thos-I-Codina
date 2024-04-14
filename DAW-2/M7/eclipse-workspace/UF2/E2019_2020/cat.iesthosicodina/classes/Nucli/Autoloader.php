<?php

class Autoloader {
    private const CARPETES = ["Model", "Vista", "Controlador", "Nucli"];
    
    public static function load ($classe){
        foreach (self::CARPETES as $carpeta){
            if (file_exists("classes/$carpeta/" . $classe. ".class.php")){
                include "classes/$carpeta/" . $classe. ".class.php";
                return;
            }
        }
    }
    
    public static function newLoad ($classe){
        foreach (self::CARPETES as $carpeta){
            if (file_exists("classes/$carpeta/$classe.php")){
                include "classes/$carpeta/$classe.php";
                return;
            }
        }
        throw new Exception("No s'ha pogut carregar la clase: $classe");
    }
}

