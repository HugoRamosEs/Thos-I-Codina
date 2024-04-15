<?php

class UsuariDatabase {
    public $host;
    public $db;
    public $user;
    public $password;
    public $dbtype;
    
    public function __construct($host, $db, $user, $password, $dbtype){
        $this->host = $host;
        $this->db = $db;
        $this->user = $user;
        $this->password = $password;
        $this->dbtype = $dbtype;
    }
}

