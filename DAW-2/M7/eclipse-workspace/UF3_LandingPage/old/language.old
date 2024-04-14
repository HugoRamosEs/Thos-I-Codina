<?php
    //error_reporting(E_ALL);
    //ini_set('display_errors', 1);
    include_once "common/funcions.php";
    
    if ($_SERVER["REQUEST_METHOD"]=="GET" && isset($_GET["inicials"])) {
        $inicials = sanitize($_GET["inicials"]);
        $errors = [];
        $opcions = ["cat", "en", "esp", "fr", "ger"];
        if (empty($inicials) || !in_array($inicials, $opcions)) {
            $errors["idioma"] = "Has de seleccionar una opció d'idioma vàlida.";
        }
        if (empty($errors)) {
            $idioma = $inicials;
            setcookie("inicials", $idioma, time() + 31536000);
        }
    } else {
        if (isset($_COOKIE["inicials"])) {
            $idioma = $_COOKIE["inicials"];
        } else {
            $idioma = "cat";
        }
    }
    $fitxer = "languages/{$idioma}_traduccions.php";
    include $fitxer;
?>