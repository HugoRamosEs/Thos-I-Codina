<?php

class Configuracio {
    private $usuariDatabase;
    private $_instance;
    public $link;

    private function __construct(){
        $xml = simplexml_load_file("config/config.xml");
        if ($link = new mysqli(ini_get("mysqli.default_host"), ini_get("mysqli.default_user"), ini_get("mysqli.default_pw"), "myweb")){
            $this->link = $link;
        }else{
            $this->usuariDatabase->server = (string) $xml->host;
            $this->usuariDatabase->user = (string) $xml->user;
            $this->usuariDatabase->password = (string) $xml->password;
            $this->usuariDatabase->base = (string) $xml->base;
            if ($link = new mysqli($this->usuariDatabase->server, $this->usuariDatabase->user, $this->usuariDatabase->password, $this->usuariDatabase->base)){
                $this->link = $link;
            }else{
                throw new Exception("No s'ha pogut establir una conexió.");
            }
        }
    }
    
    public static function getInstance(){
        if (!(self::$_instance instanceof self)){
            self::$_instance = new self();
        }
        return self::$_instance;
    }
    
    public function __clone(){}
}

