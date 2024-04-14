<?php

class VMain extends View {
    public function __construct() {
        parent::__construct();
    }
    
    public function show($idioma) {
        $frm_lang = "idiomes/traduccions.{$idioma}";
        include_once $frm_lang;
        
        include "templates/common/html_head.php";
        include "templates/common/header.php";
        include "templates/common/navbar.php";
        include "templates/common/title.php";
        include "templates/body/main.php";
        include "templates/common/footer.php";
        include "templates/common/html_end.php";
    }
}
