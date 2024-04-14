<?php

class ErrorController extends Controller {
    private $e;
    
    public function __construct($e) {
        $this->e = $e;
    }
    
    public function show() {
        $vError = new ErrorView($this->e);
        $vError->show();
    }
}

