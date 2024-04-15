<?php

class Config {
    public $sgbd;
    public $servidor;
    public $dbname;
    public $usuari_consultes;
    public $usuari_generic;
    public $password_consultes;
    public $password_generic;
    
    
    private static $_instance;
    
    private function __construct() {
        include 'config/config_vars.php';
        $this->sgbd = $sgbd;
        $this->servidor = $servidor;
        $this->dbname = $dbname;
        $this->usuari_consultes = $usuari;
        $this->password_consultes = $password;
        
        $this->usuari_generic = ini_get("mysqli.default_user");
        $this->password_generic = ini_get("mysqli.default_pw");
    }
    
    public static function getInstance() {
        if (!self::$_instance instanceof self) {
            self::$_instance = new Self(); 
        }
        return self::$_instance;
    }
    
    protected function __clone() {}
    public function __wakeup() {
        throw new \Exception("Cannot unserialize a singleton.");
    }
}

