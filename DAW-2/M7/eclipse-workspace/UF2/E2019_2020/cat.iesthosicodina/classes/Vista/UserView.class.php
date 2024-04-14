<?php
class UserView extends Vista {
    private $_user;
    
    public function __construct() {
        parent::__construct();
        $this->_user = new User();
        $this->setBody("plantilles/body.php");
    }
    
    public function setErrorsDetectats($errors) {
        $this->_errorsDetectats = $errors;
        
    }
    
    public function getErrorsDetectats () {
        return $this->_errorsDetectats;
    }
    
    public function setUser($user) {
        $this->_user = $user;
    }
    
    public function getUser() {
        return $this->_user;
    }
    
}