<?php

class ContacteView extends View {
    public function __construct() {
        parent::__construct();
    }
    
    public function show($lang, $langTraduccions, $contacte, $ok, $frmErrors){
        $fitxer = "languages/{$lang}_traduccions.php";
        include_once $fitxer;
        
        $navIdiomes = $this->mostrarMenuIdiomes($lang, $langTraduccions);
        
        include "templates/head.tpl.php";
        include "templates/header.tpl.php";
        include "templates/main-contacte.tpl.php";
        include "templates/footer.tpl.php";
    }
}

