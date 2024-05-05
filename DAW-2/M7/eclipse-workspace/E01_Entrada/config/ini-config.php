<?php
    spl_autoload_register(function ($class) {
        $folders = array(
            "core",
            "controller",
            "model",
            "repository"
        );

        $class = basename(str_replace("\\", "/", $class));
        
        foreach ($folders as $folder) {
            
            $path = "../src/$folder/$class.class.php";
            if (file_exists($path)) {
                require_once($path);
                return;
            }
            
            $path = "../src/$folder/$class.php";
            if (file_exists($path)) {
                require_once($path);
                return;
            }
        }        
    });
?>
