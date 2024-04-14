<?php
class CError {
    private $thrownException; 
    
    public function __construct($thrownEx) {
        $this->thrownException=$thrownEx;
    }
    
    public function show() {    
        $frm_lang=$cLang->getTraduccions();

        $vError = new VError();
        $vError->show("S'ha produït un error en l'aplicació.", $errorTitle=$this->thrownException->getMessage());
    }
    
    
}

