<?php

class CMain extends Controller {
//     private $thrownException;
    
//     public function __construct($thrownEx) {
//         $this->thrownException=$thrownEx;
//     }
    
    public function show(){
        $cLang = new CLang();
        $lang = $cLang->dispatch();
        $langA = $cLang->getTraduccions();
        $vHome = new VMain();
        var_dump($langA);
        $vHome->show( $langA, $errors);
    }
}

