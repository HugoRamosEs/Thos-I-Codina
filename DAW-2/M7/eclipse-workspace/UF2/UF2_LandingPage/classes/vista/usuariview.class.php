<?php

class UsuariView extends View {
    public function __construct() {
        parent::__construct();
    }
    
    public function login($idioma, $usuari, $frmErrors){
        $fitxer = "languages/{$idioma}_traduccions.php";
        require_once $fitxer;
        include "templates/head.tpl.php";
        include "templates/header.tpl.php";
        include "templates/main-login.tpl.php";
        include "templates/footer.tpl.php";
    }
    
    public function signup($idioma, $usuari, $frmErrors, $frmPassword2){
        $fitxer = "languages/{$idioma}_traduccions.php";
        require_once $fitxer;
        include "templates/head.tpl.php";
        include "templates/header.tpl.php";
        include "templates/main-signup.tpl.php";
        include "templates/footer.tpl.php";
    }
    
    public function confirm($idioma, $usuari, $lastId){
        $fitxer = "languages/{$idioma}_traduccions.php";
        require_once $fitxer;
        $titol = "T'has registrat correctament.";
        $msg = "Benvingut $usuari->nom $usuari->cognoms!
                Estem encantats de tenir-te a la nostra pàgina. El teu registre ha estat exitós, però necessitem que verifiquis que ets tu fent click a l'enllaç que et proporcionem!
                Gràcies per unir-te a nosaltres. Esperem que la teva experiència aquí sigui increïble!";
        $link = '<a href="?Usuari/confirm/'.$lastId.'">Fes click aquí per activar el teu compte!</a>';
        include "templates/head.tpl.php";
        include "templates/header.tpl.php";
        include "templates/main-signup-correct.tpl.php";
        include "templates/footer.tpl.php";
    }
    
    public function active($idioma){
        $fitxer = "languages/{$idioma}_traduccions.php";
        require_once $fitxer;
        $titol = "Compte activat.";
        $msg = "Perfecte! El teu compte ya està activat i funcionant, ya pots iniciar sessió i disfrutar de la teva expèriencia a la nostra pàgina web!";
        include "templates/head.tpl.php";
        include "templates/header.tpl.php";
        include "templates/main-signup-active.tpl.php";
        include "templates/footer.tpl.php";
    }
}

