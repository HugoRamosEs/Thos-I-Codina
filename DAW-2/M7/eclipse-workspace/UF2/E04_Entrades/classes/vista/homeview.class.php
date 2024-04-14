<?php

class HomeView {

    
    
    public static function show($resultat, $lang, $fitxerDeTraduccions ) {
        require_once $fitxerDeTraduccions;        
        $html_opacityLang[$lang]="style=\"opacity:1;\"";
        
        echo "<!DOCTYPE html><html lang=\"en\">";
        include "templates/head.tpl.php";
        echo "<body>";
	    include "templates/header.tpl.php";
	    include "templates/nav_bar.tpl.php";
		include "templates/info_main.tpl.php";
		include "templates/footer.tpl.php";
		echo "</body></html>";
    }
}

