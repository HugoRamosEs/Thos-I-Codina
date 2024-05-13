<?php
namespace config;

use Exception;

class Autoload {
    private const FOLDERS = array("controller", "model", "repository", "views");
    
    public static function load($class) {
        $class = basename(str_replace("\\", "/", $class));
        
        foreach (self::FOLDERS as $folder) {
            $path = "../src/$folder/$class.php";
            if (file_exists($path)) {
                require_once ($path);
                return;
            } else {
                throw new Exception("Arxiu {$class}.php no trobat a {$path}");
            }
        }
    }
}
