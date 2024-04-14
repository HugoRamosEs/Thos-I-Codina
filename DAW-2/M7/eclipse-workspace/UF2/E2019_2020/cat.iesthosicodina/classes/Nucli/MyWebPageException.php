<?php

class MyWebPageException extends Exception {
    private $codi;
    
    public function __construct($codi, $missatgeError, $code = 0, Exception $previa = null) {
        parent::__construct($missatgeError, $code, $previa);
        $this->codi = $codi;
    }
    
    public function getCodi() {
        return $this->codi;
    }
}

