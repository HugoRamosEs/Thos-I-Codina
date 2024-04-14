<?php

class LangController extends Controller {
    private $idiomaModel;
    
    public function __construct(){
        parent::__construct();
        $this->idiomaModel = new IdiomaModel();
    }
    
    public function set($params="cat"){
        $opcions = [];
        $idiomesActius = $this->idiomaModel->getActiveLangs();
        foreach ($idiomesActius as $iA){
            array_push($opcions, $iA->getIso());
        }
        if (empty($params[0]) || !in_array($params[0], $opcions)) {
            $errors["idioma"] = "Has de seleccionar una opció d'idioma vàlida.";
        }
        
        if (empty($errors)) {
            setcookie("lang", $params[0], time() + 31536000);
        }
        
        $lang = $params[0];
        $langTraduccions = $this->menuIdiomes($lang);
        
        $vHome = new HomeView();
        $vHome->show($lang, $langTraduccions, $errors);
    }
}

