<?php

class RegisterView extends View {

    public function __construct() {
        parent::__construct();
    }    
    
    public function show($user) {
        $fitxerDeTraduccions = "languages/{$this->lang}_traduccio.php";
        require_once $fitxerDeTraduccions;
        $html_opacityLang[$this->lang]="style=\"opacity:1;\"";
        
        $options = ["type"=>"text",
            "name"=>"email",
            "placeholder"=>"email (Obligatori)",
            "class"=>"llarg",
            "value"=> $user->getEmail(),
            "span"=> $user->errorsDetectats===null ? "" : $user->errorsDetectats["email"] ];
        $input_email = $this->html_generaInput($options);
        
        $options = [
            "type"=>"password",
            "name"=>"pass",
            "placeholder"=>"Contrasenya (Obligatori)",
            "class"=>"llarg",
            "value"=>$user->getPassword(),
            "span"=>$user->errorsDetectats===null ? "" : $user->errorsDetectats["pass"] ];
        $input_pass = $this->html_generaInput($options);
        
        $options = [
            "type"=>"password",
            "name"=>"cpass",
            "placeholder"=>"Confirma la contrasenya (Obligatori)",
            "class"=>"llarg",
            "value"=>$user->getPassword(),
            "span"=>$user->errorsDetectats===null ? "" : $user->errorsDetectats["cpass"] ];
        $input_cpass = $this->html_generaInput($options);
        
        $options = [
            "type"=>"button",
            "name"=>"next",
            "class"=>"next action-button",
            "value"=>"Next" ];
        $input_bNext = $this->html_generaInput($options);
        
        $atributs = [
            "class"=>"curt",
            "name"=>"tipus",
            "span"=>$user->errorsDetectats=== null ? "" : $user->errorsDetectats["tipus"] ];
        $opcions = [
            "NIF"=>"NIF: Número d'Identificació Fiscal",
            "NIE"=>"NIE: Número d'Identificació d'Extranjers",
            "PAS"=>"PAS: Passaport" ];
        $seleccionat = ($user->getTipusIdent()!==null) ? $user->getTipusIdent() : "NIF";
        $select_Tipus = $this->html_generateSelect($opcions, $seleccionat, $atributs);
        
//         var_dump($select_Tipus);
//         die;
        
        $options = [
            "type"=>"text",
            "name"=>"dni",
            "placeholder"=>"DNI (Obligatori)",
            "class"=>"curt",
            "value"=> $user->getNumeroIdent(),
            "span"=>$user->errorsDetectats===null ? "" : $user->errorsDetectats["dni"] ];
        $input_dni = $this->html_generaInput($options);
        
        $options = [
            "type"=>"text",
            "name"=>"nom",
            "placeholder"=>"Nom (Obligatori)",
            "class"=>"llarg",
            "value"=>$user->getNom(),
            "span"=>$user->errorsDetectats===null ? "" : $user->errorsDetectats["nom"] ];
        $input_nom = $this->html_generaInput($options);
        
        $options = [
            "type"=>"text",
            "name"=>"cognoms",
            "placeholder"=>"Cognoms (Obligatori)",
            "class"=>"llarg",
            "value"=>$user->getCognoms(),
            "span"=>$user->errorsDetectats===null ? "" : $user->errorsDetectats["cognoms"]  ];
        $input_cognoms = $this->html_generaInput($options);
        
        $opcions = [
            "sexe1" => [
                "name" => "sexe",
//                 "class" => "curt",
                "value" => "H",
                "checked"=>($user->getSexe()=="H") ? true : false,
                "label"=>"Home" ] ,
            "sexe2" => [
                "name" => "sexe",
//                 "class" => "curt",
                "value" => "D",
                "checked"=>($user->getSexe()=="D") ? true : false,
                "label"=>"Dona" ]
        ];
        $select_Sexe = $this->html_generateRadioButon($opcions);
        
        
        $options = [
            "type"=>"text",
            "name"=>"naixement",
            "placeholder"=>"Data de naixement (Obligatori)",
            "class"=>"llarg",
            "value"=>$user->getDatanaixement(),
            "span"=>$user->errorsDetectats===null ? "" : $user->errorsDetectats["dNaixement"] ];
        $input_naixement = $this->html_generaInput($options);
        
        $options = [
            "type"=>"button",
            "name"=>"previous",
            "class"=>"previous action-button",
            "value"=>"Previous" ];
        $input_bPrev = $this->html_generaInput($options);
        
        $options = [
            "class"=>"llarg",
            "name"=>"adreca",
            "placeholder"=>"Adreça",
            "value"=>$user->getAdreca(),
            "span"=>$user->errorsDetectats===null ? "" : $user->errorsDetectats["adreca"] ];
        $input_adreca = $this->html_generaInput($options);
        
        $options = [
            "class"=>"llarg",
            "class"=>"curt",
            "name"=>"cp",
            "placeholder"=>"C.P.",
            "value"=>$user->getCodiPostal(),
            "span"=>$user->errorsDetectats===null ? "" : $user->errorsDetectats["cp"]  ];
        $input_cp = $this->html_generaInput($options);
        
        $options = [
            "class"=>"llarg",
            "class"=>"curt",
            "name"=>"poblacio",
            "placeholder"=>"Població",
            "value"=>$user->getPoblacio(),
            "span"=>$user->errorsDetectats===null ? "" : $user->errorsDetectats["poblacio"] ];
        $input_poblacio = $this->html_generaInput($options);
        
        $options = [
            "class"=>"llarg",
            "class"=>"curt",
            "name"=>"provincia",
            "placeholder"=>"Provincia",
            "value"=>$user->getProvincia(),
            "span"=>$user->errorsDetectats===null ? "" : $user->errorsDetectats["provincia"] ];
        $input_provincia = $this->html_generaInput($options);
        
        $options = [
            "class"=>"llarg",
            "class"=>"curt",
            "name"=>"telefon",
            "placeholder"=>"Teléfon",
            "value"=>$user->getTelefon(),
            "span"=>$user->errorsDetectats===null ? "" : $user->errorsDetectats["telefon"] ];
        $input_telefon = $this->html_generaInput($options);
        
        $options = [
            "type"=>"hidden",
            "name"=>"MAX_FILE_SIZ",
            "value"=>"2097152" ];
        $input_maxFileSize = $this->html_generaInput($options);
        
        $options = [
            "type"=>"file",
            "class"=>"llarg",
            "name"=>"imatge",
            "id"=>"imatge",
            "value"=>$user->getImatge(),
            "span"=>$user->errorsDetectats==null ? "" : $user->errorsDetectats["imatge"] ];
        $input_imatge = $this->html_generaInput($options);
        
        $options = [
            "type"=>"submit",
            "name"=>"submit",
            "class"=> "submit action-button",
            "value"=> "Envia Dades"];
        $input_bSend = $this->html_generaInput($options);
        
        echo "<!DOCTYPE html><html lang=\"en\">";
        include "templates/head.tpl.php";
        echo "<body>";
	    include "templates/header.tpl.php";
	    include "templates/nav_bar.tpl.php";
		include "templates/info_register.tpl.php";
		include "templates/footer.tpl.php";
		echo "</body></html>";
    }
}

