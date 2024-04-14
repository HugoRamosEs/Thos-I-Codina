<?php

class ContacteView extends View {

    public function __construct() {
        parent::__construct();
    }
    
    public static function show($contacte, $lang, $errors=null, $missatgeOK='') {
        $fitxerDeTraduccions = "languages/{$lang}_traduccio.php";
        require_once $fitxerDeTraduccions;        
        $html_opacityLang[$lang]="style=\"opacity:1;\"";
        
        echo "<!DOCTYPE html><html lang=\"en\">";
        include "templates/head.tpl.php";
        echo "<body>";
	    include "templates/header.tpl.php";
	    include "templates/nav_bar.tpl.php";
		include "templates/info_contact.tpl.php";
		include "templates/footer.tpl.php";
		echo "</body></html>";
    }
    
    public static function maintenance($resultat, $lang) {
        $fitxerDeTraduccions = "languages/{$lang}_traduccio.php";
        require_once $fitxerDeTraduccions;
        $html_opacityLang[$lang]="style=\"opacity:1;\"";

        echo "<!DOCTYPE html><html lang=\"en\">";
        include "templates/head.tpl.php";
        echo "<body>";
        include "templates/header.tpl.php";
        include "templates/nav_bar.tpl.php";
        include "templates/info_guestbook_mant.tpl.php";
        include "templates/footer.tpl.php";
        echo "</body></html>";
        
    }
}

