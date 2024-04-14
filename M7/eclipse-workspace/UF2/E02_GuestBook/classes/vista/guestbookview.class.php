<?php

class GuestBookView extends View {

    public function __construct() {
        parent::__construct();
    }    
    
    public function show( $comentari, $items, $lang, $errorsDetectats=null) {
        $fitxerDeTraduccions = "languages/".$lang."_traduccio.php";
        require_once $fitxerDeTraduccions;
        $html_opacityLang[$lang]="style=\"opacity:1;\"";
        
        $opcionsExperiencia = [
            "MB" => "Molt bona",
            "B" => "Bona",
            "R" => "Regular",
            "D" => "Dolenta",
            "MD" => "Molt dolenta"
        ];
        
        $options = [
            "type" => "text",
            "name" => "nom",
            "placeholder" => "Digue'ns el teu nom",
            "value" => $comentari->getNom(),
            "class" => (isset($errorsDetectats["nom"])) ? "invalid" : "",
            "span" => $errorsDetectats["nom"]
        ];
        $input_nom = $this->html_generaInput($options);
        
        $options = [
            "type" => "text",
            "name" => "email",
            "placeholder" => "Digue'ns el teu mail per pasar-nos en contacte",
            "value" => $comentari->getMail(),
            "class" => (isset($errorsDetectats["mail"])) ? "invalid" : "",
            "span" => $errorsDetectats["mail"]
        ];
        $input_mail = $this->html_generaInput($options);
        
        $atributs = [
            "name" => "experiencia",
            "span" => $errorsDetectats["exp"]
        ];
        $seleccionat = ($comentari->getExperiencia()!==null) ? $comentari->getExperiencia() : "MB";
        $select_Experiencia = $this->html_generateSelect($opcionsExperiencia, $seleccionat, $atributs);
        
        $options = [
            "type" => "textarea",
            "rows" => "4",
            "name" => "missatge",
            "placeholder" => "Què ens vols dir?",
            "value" => $comentari->getMissatge(),
            "class" => (isset($errorsDetectats["missatge"])) ? "invalid" : "",
            "span" => $errorsDetectats["missatge"]
        ];
        $input_missatge = $this->html_generaInput($options);
        
        $capcelera = "<tr><th>Missatge</th><th>Experiència</th><th>Nom</th><th>Mail</th><th>Data</th></tr>";
        
        $formulari = "<form action=\"\" method=\"post\" target=\"blank\">";
        $formulari .= "<tr><td>$input_missatge</td><td>$select_Experiencia</td><td>$input_nom</td><td>$input_mail</td>";
        $formulari .= "<td><input type=\"submit\" name=\"boto\" value=\"$contacteEnviar\" class=\"btn\"></td></tr>";
        $formulari .= "</form>";
        
        foreach ($items as $key => $value) {
            $cos .= "<tr><td>{$value->getMissatge()}</td><td>{$value->getExperiencia()}</td><td>{$value->getNom()}</td><td>{$value->getMail()}</td><td>{$value->getData()}</td></tr>\n";
        }
        
        $resultat = "<table><thead>$capcelera</thead>$formulari<tbody>$cos</tbody></table>";
        
        
        echo "<!DOCTYPE html><html lang=\"en\">";
        include "templates/head.tpl.php";
        echo "<body>";
	    include "templates/header.tpl.php";
	    include "templates/nav_bar.tpl.php";
		include "templates/info_guestbook.tpl.php";
		include "templates/footer.tpl.php";
		echo "</body></html>";
    }
    
    
}

