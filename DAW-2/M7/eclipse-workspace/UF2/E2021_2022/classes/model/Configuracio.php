<?php

class Configuracio {
    private $usuariDatabase;
    private static $_instance;

    private function __construct(){
        if (file_exists("docs/usr_consulta.php")){
            include_once "config/config.php";
            $this->usuariDatabase = new UsuariDatabase($host, $db, $user, $password, $dbtype);
        }
    }
    
    public static function getInstance(){
        if (!(self::$_instance instanceof self)){
            self::$_instance = new self();
        }
        return self::$_instance;
    }
    
    public function getUsuariDatabase() {
        return $this->usuariDatabase;
    }
    
    public function __clone(){}
}

