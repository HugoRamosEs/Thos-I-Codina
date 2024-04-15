<?php

class LangController extends Controlador {
 
    public function set($params="ca") {
        if (in_array($params[0], array("ca","es","gr","de", "eu", "fr"))) {
            setcookie("lang",$params[0],time()+3600);
        }
        
        $valorsPossibles = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        
        $resultat="";
        for ($i = 1; $i <= 6; $i ++) {
            $resultat .= $valorsPossibles[rand(0, strlen($valorsPossibles) - 1)];
        }
        
        $lang = $params[0];        
        $fitxerDeTraduccions = "languages/{$lang}_traduccio.php";
        
        
        $vHome = new HomeView();
        $vHome->show($resultat, $lang, $fitxerDeTraduccions);
    }
}

