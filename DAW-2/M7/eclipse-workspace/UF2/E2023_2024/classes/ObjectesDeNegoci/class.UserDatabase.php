<?php

class UserDatabase {
    public $server;
    public $user;
    public $password;
    public $base;
    
    public function __construct($server, $user, $password, $base){
        $this->server = $server;
        $this->user = $user;
        $this->password = $password;
        $this->base = $base;
    }
}

