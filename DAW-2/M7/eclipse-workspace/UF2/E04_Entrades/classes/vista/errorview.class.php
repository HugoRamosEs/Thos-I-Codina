<?php

class ErrorView extends View {

    public function __construct() {
        parent::__construct();
    }
    
    public function show(Exception $e) {
        $fitxerDeTraduccions = "languages/{$this->lang}_traduccio.php";
        include $fitxerDeTraduccions;
        $html_opacityLang[$this->lang]="style=\"opacity:1;\"";
        
        $titol = "hi ha hagut un error";
        $missatge = $e->getMessage();
        
        echo "<!DOCTYPE html><html lang=\"en\">";
        include "templates/head.tpl.php";
        echo "<body>";
	    include "templates/header.tpl.php";
	    include "templates/nav_bar.tpl.php";
		include "templates/info_error.tpl.php";
		include "templates/footer.tpl.php";
		echo "</body></html>";
    }
    
    public function showOk($titol, $missatge) {
        $fitxerDeTraduccions = "languages/{$this->lang}_traduccio.php";
        include $fitxerDeTraduccions;
        $html_opacityLang[$this->lang]="style=\"opacity:1;\"";
        
        echo "<!DOCTYPE html><html lang=\"en\">";
        include "templates/head.tpl.php";
        echo "<body>";
        include "templates/header.tpl.php";
        include "templates/nav_bar.tpl.php";
        include "templates/info_ok.tpl.php";
        include "templates/footer.tpl.php";
        echo "</body></html>";
        
    }
    
    public function showMessage($titol, $missatge) {
        $fitxerDeTraduccions = "languages/{$this->lang}_traduccio.php";
        include $fitxerDeTraduccions;
        $html_opacityLang[$this->lang]="style=\"opacity:1;\"";
        
        echo "<!DOCTYPE html><html lang=\"en\">";
        include "templates/head.tpl.php";
        echo "<body>";
        include "templates/header.tpl.php";
        include "templates/nav_bar.tpl.php";
        include "templates/info_error.tpl.php";
        include "templates/footer.tpl.php";
        echo "</body></html>";
    }
}

