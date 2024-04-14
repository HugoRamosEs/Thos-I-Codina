<?php

class InversisView extends View {

    public function __construct() {
        parent::__construct();
    }    
    
    public function show($taula) {
        $fitxerDeTraduccions = "languages/{$this->lang}_traduccio.php";
        require_once $fitxerDeTraduccions;
        $html_opacityLang[$this->lang]="style=\"opacity:1;\"";
        
        echo "<!DOCTYPE html><html lang=\"en\">";
        include "templates/head.tpl.php";
        echo "<body>";
	    include "templates/header.tpl.php";
	    include "templates/nav_bar.tpl.php";
		include "templates/info_cotis.tpl.php";
		include "templates/footer.tpl.php";
		echo "</body></html>";
    }
}

