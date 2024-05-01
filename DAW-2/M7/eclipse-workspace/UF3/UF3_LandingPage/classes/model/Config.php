<?php

class Config {
    private $usuariDb;
    private static $_instance;
    
    private function __construct(){
        if (file_exists("docs/usr_consulta.php")){
            include_once "docs/usr_consulta.php";
            $this->usuariDb = new UsuariDb($server, $user, $password, $base);
        }
    }
    
    public static function getInstance(){
        if (!(self::$_instance instanceof self)){
            self::$_instance = new self();
        }
        return self::$_instance;
    }
    
    public function getUsuariDb(){
        return $this->usuariDb;
    }
    
    public function __clone(){}
}

