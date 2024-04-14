<?php

class HomeController {

    public function __construct() {
        
    }
    
    public function show() {
        $valorsPossibles = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        
        $resultat="";
        for ($i = 1; $i <= 6; $i ++) {
            $resultat .= $valorsPossibles[rand(0, strlen($valorsPossibles) - 1)];
        }
        
        if ($_SERVER["REQUEST_METHOD"]=="GET" && isset($_GET["lang"])) {
            $lang = $_GET["lang"];
            setcookie("lang",$lang,time()+3600);
        } else {
            if (isset($_COOKIE["lang"])) {
                $lang = $_COOKIE["lang"];
            } else {
                $lang = "ca";
            }
        }
        
        $fitxerDeTraduccions = "languages/{$lang}_traduccio.php";
        
        
        HomeView::show($resultat, $lang, $fitxerDeTraduccions );      
        
    }
}

