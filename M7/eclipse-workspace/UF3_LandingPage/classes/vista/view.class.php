<?php

class View {
    public $lang;
    
    public function __construct(){
        if (isset($_COOKIE["lang"])) {
            $this->lang = $_COOKIE["lang"];
        } else {
            $this->lang = "cat";
        }
    }
    
    public function mostrarMenuIdiomes($lang, $langTraduccions){
        $navIdiomes = '<div id="header4">
            				<form id="idiomes" method="get" action="">
                                <div class="idioma-cont">';
        foreach ($langTraduccions as $iso => $dades) {
            $navIdiomes .= '<a href="?lang/set/'.$iso.'" class="'.($lang === $iso ? "seleccionat" : "").'"><img src="'.$dades["imatge"].'">';
            if (isset($dades["valors"])) {
                foreach ($dades["valors"] as $valor) {
                    $navIdiomes .= ucfirst($valor);
                }
            }
            $navIdiomes .= '</a>';
        }
        $navIdiomes .=    '</div>
                         </form>
            			</div>';

        return $navIdiomes;
    }
}

