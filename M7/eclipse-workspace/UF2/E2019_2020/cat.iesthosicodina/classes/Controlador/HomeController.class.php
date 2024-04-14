<?php

class HomeController extends Controller {
    private $lang;
    
    public function __construct(){
        $this->lang = new LanguageController();
    }
    
    public function show(){
        $vHome = new UserView();
        $vHome->show();
    }
    
    public function getLang(){
        return $this->lang;
    }
}

