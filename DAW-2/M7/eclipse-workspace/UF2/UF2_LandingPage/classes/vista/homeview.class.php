<?php

class HomeView extends View {
    public function __construct(){
        parent::__construct();
    }
    
    public function show($idioma, $errors){
        $fitxer = "languages/{$idioma}_traduccions.php";
        require_once $fitxer;
        include "templates/head.tpl.php";
        include "templates/header.tpl.php";
        include "templates/main-index.tpl.php";
        include "templates/footer.tpl.php";
    }
}

