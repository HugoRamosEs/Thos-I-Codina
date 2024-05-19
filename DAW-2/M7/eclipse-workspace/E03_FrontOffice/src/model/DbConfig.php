<?php
namespace model;

class DbConfig {
    private const XML_FILE = "../src/docs/dbConfig.xml";
    private $driver;
    private $host;
    private $dbname;
    private $user;
    private $password;
    
    private static $_instance;

    private function __construct() {
        $params = $this->getParams();
        $this->driver = $params["driver"];
        $this->host = $params["host"];
        $this->dbname = $params["dbname"];
        $this->user = $params["user"];
        $this->password = $params["password"];
    }

    public static function getInstance() {
        if (!(self::$_instance instanceof self)) {
            self::$_instance = new self();
        }

        return self::$_instance;
    }

    private function getParams() {
        $xml = simplexml_load_file(self::XML_FILE);
        $params = [
            "driver" => (string) $xml->driver,
            "host" => (string) $xml->host,
            "dbname" => (string) $xml->dbname,
            "user" => (string) $xml->user,
            "password" => (string) $xml->password
        ];
        
        return $params;
    }
    
    public function getDriver() {
        return $this->driver;
    }
    public function getHost() {
        return $this->host;
    }
    public function getDbname() {
        return $this->dbname;
    }
    public function getUser() {
        return $this->user;
    }
    public function getPassword() {
        return $this->password;
    }
    
    private function __clone(){}
}
