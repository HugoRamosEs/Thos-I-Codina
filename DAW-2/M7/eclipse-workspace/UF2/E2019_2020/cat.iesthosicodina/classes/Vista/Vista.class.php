<?php
class Vista {
    protected $_header;
    protected $_navigationIdiomes;
    protected $_navigation;
    protected $_body;
    protected $_footer;
    
    protected $_errorsDetectats;
    
    public function __construct() {
        $this->_header              = "plantilles/header.php";
        $this->_navigationIdiomes   = "plantilles/navigationIdiomes.php";
        $this->_navigation          = "plantilles/navigation.php";
        $this ->_footer             = "plantilles/footer.php";
     }
    
    public function show() {
        $self = Controller::sanitize($_SERVER['PHP_SELF'],0);
        
        $lang = new LanguageController();
        $formulariIdiomes = $lang->generaHTML();
        
        $nav = new NavigationController();
        $menuNavegacio = $nav->getHTMLNavigation();
        $menuUsuari = $nav->getHTMLUser();
        
        include $this->_header;
        include $this->_navigationIdiomes;
        include $this->_navigation;
        include $this->_body;
        include $this->_footer;
    }

    public function setBody($body) {
        $this->_body = $body;
    }
    
    public function getErrorsDetectats()
    {
        return $this->_errorsDetectats;
    }

    public function setErrorsDetectats($_errorsDetectats)
    {
        $this->_errorsDetectats = $_errorsDetectats;
    }
 
    
    
}