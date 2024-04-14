<?php

class LangController extends Controller {
    public function __construct(){}
    
    public function set($params="cat"){
        $opcions = ["cat", "en", "esp", "fr", "ger"];
        if (empty($params[0]) || !in_array($params[0], $opcions)) {
            $errors["idioma"] = "Has de seleccionar una opció d'idioma vàlida.";
        }
        
        if (empty($errors)) {
            setcookie("lang", $params[0], time() + 31536000);
        }
        $lang = $params[0];
        $vHome = new HomeView();
        $vHome->show($lang, $errors);
    }
}

