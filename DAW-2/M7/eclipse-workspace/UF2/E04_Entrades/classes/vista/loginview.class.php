<?php

class LogInView extends View {

    public function __construct() {
        parent::__construct();
    }    
    
    public function show($user) {
        $fitxerDeTraduccions = "languages/{$this->lang}_traduccio.php";
        require_once $fitxerDeTraduccions;
        $html_opacityLang[$this->lang]="style=\"opacity:1;\"";
        
        $options = array (
            "type"          => "text",
            "name"          =>"nom",
            "placeholder"   =>"Usuari",
            "value"         => $user->getNom(),
            "span"          => isset($user->errorsDetectats["nom"]) ? $user->errorsDetectats["nom"] : ""
            );
        $frmNom = $this->html_generaInput($options);
        
        $optionsPass = array(
            "type"          => "password",
            "name"          => "contrasenya",
            "placeholder"   => "Contrasenya",
            "value"         =>  $user->getPassword(),
            "span"          =>  isset ($user->errorsDetectats["contrasenya"]) ? $user->errorsDetectats["contrasenya"] : ""
            );
        $frmPass = $this->html_generaInput($optionsPass);
        
        echo "<!DOCTYPE html><html lang=\"en\">";
        include "templates/head.tpl.php";
        echo "<body>";
	    include "templates/header.tpl.php";
	    include "templates/nav_bar.tpl.php";
		include "templates/info_login.tpl.php";
		include "templates/footer.tpl.php";
		echo "</body></html>";
    }
}

