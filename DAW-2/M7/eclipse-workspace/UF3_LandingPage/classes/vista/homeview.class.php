<?php

class HomeView extends View {
    public function __construct(){
        parent::__construct();
    }
    
    public function show($lang, $langTraduccions, $errors){
        $fitxer = "languages/{$lang}_traduccions.php";
        include_once $fitxer;
        
        $navIdiomes = $this->mostrarMenuIdiomes($lang, $langTraduccions);
        
        include "templates/head.tpl.php";
        include "templates/header.tpl.php";
        include "templates/main-index.tpl.php";
        include "templates/footer.tpl.php";
    }
}

