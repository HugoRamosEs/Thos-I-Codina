<?php

class GuestBookView extends View {
    public function __construct(){
        parent::__construct();
    }
    
    public function show($comentari, $registres, $lang, $langTraduccions, $frmErrors, $ok){
        $fitxer = "languages/{$lang}_traduccions.php";
        include_once $fitxer;
        
        $navIdiomes = $this->mostrarMenuIdiomes($lang, $langTraduccions);
        
        $thead = "<table><thead><tr>";
        $th = array("Nom", "Email", "Experiència", "Missatge", "Data");
        foreach ($th as $titol){
            $thead .= "<th> $titol </th>";
        }
        $thead .= "</tr></thead>";
        $tbody = "<tbody>";
        foreach ($registres as $registre) {
            $tbody .= "<tr>";
            foreach($registre as $dada) {
                $tbody .= "<td>$dada</td>";
            }
            $tbody .= "</tr>";
        }
        $tbody .= "</tbody></table>";
        $taula = $thead . $tbody;
        
        include "templates/head.tpl.php";
        include "templates/header.tpl.php";
        include "templates/main-guest.tpl.php";
        include "templates/footer.tpl.php";
    }
}

