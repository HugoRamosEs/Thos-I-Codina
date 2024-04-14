<?php
class ErrorView extends Vista {
    private $thrownException;
    private $codi;
    
    public function __construct($e, $codi) {
        parent::__construct();
        $this->thrownException = $e;
        $this->codi = $codi;
        $this->setBody("plantilles/error.php");
    }
    
    public function getUser() {
        return $this->_user;
    }
    
    public function setUser($user) {
        $this->_user = $user;
    }

    public function getCodi(){
        return $this->codi;
    }
    
    public function getThrownException() {
        return $this->thrownException;
    }
 
}