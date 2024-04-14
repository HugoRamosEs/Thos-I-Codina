<?php

class ErrorView extends View {
    public function __construct() {
        parent::__construct();
    }
    
    public function show(Exception $e){
        $fitxer = "languages/{$this->lang}_traduccions.php";
        require_once $fitxer;
        $titol = "Hi ha hagut un error";
        $msg = $e->getMessage();
        include "templates/head.tpl.php";
        include "templates/header.tpl.php";
        include "templates/main-error.tpl.php";
        include "templates/footer.tpl.php";
    }
}

