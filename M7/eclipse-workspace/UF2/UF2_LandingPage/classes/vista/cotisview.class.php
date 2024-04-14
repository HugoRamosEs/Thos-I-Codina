<?php

class CotisView extends View{
    public function __construct(){
        parent::__construct();
    }
    
    public function show($idioma, $taula){
        $fitxer = "languages/{$idioma}_traduccions.php";
        require_once $fitxer;
        include "templates/head.tpl.php";
        include "templates/header.tpl.php";
        include "templates/main-cotis.tpl.php";
        include "templates/footer.tpl.php";
    }
}

