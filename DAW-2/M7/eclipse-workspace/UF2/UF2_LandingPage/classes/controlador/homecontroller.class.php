<?php

class HomeController extends Controller {
    public function __construct(){}
    
    public function show(){
        if ($_SERVER["REQUEST_METHOD"]=="GET" && isset($_GET["lang"])) {
            $lang = $this->sanitize($_GET["lang"]);
            $errors = [];
            $opcions = ["cat", "en", "esp", "fr", "ger"];
            if (empty($lang) || !in_array($lang, $opcions)) {
                $errors["idioma"] = "Has de seleccionar una opció d'idioma vàlida.";
            }
            if (empty($errors)) {
                $idioma = $lang;
                setcookie("lang", $idioma, time() + 31536000);
            }
        }else {
            if (isset($_COOKIE["lang"])) {
                $lang = $_COOKIE["lang"];
            } else {
                $lang = "cat";
            }
        }
        $vHome = new HomeView();
        $vHome->show($lang, $errors);
    }
}

