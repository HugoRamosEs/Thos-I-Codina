<?php

class VIslandia extends View {
    public function __construct() {
        parent::__construct();
    }
    
    public function show() {
        include "templates/common/html_head.php";
        include "templates/common/header.php";
        include "templates/common/navbar.php";
        include "templates/common/title.php";
        include "templates/body/islandia.php";
        include "templates/common/footer.php";
        include "templates/common/html_end.php";
    }
}

