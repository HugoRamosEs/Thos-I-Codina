<?php
class MLang extends Model {

    public function __construct() {
        parent::__construct();
        
    }
    
    public function getText($lang) {
        $param[0]=$lang;
        $sSql = "SELECT * FROM form_lang WHERE idioma=?";        
        $res = $this->executar($sSql, $param);
        
        $form = new FormTagsLang($lang);
        foreach ($res as $camp => $value) {
            $atribut=$value["camp"];
            $form->$atribut=$value["text"];
        }
        return $form;
    }
    
}

