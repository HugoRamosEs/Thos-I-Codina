<?php

class Autoloader {
    
    public static function load ($classe){
        $class = substr($classe, 11);
        
        if (file_exists("classes/$class.php")){
            include "classes/$class.php";
            return;
        }
        
        throw new Exception("No s'ha pogut carregar la clase: $class");
    }
}

