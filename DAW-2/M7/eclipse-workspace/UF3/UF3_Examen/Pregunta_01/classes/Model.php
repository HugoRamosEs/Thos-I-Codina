<?php
namespace curriculum;

use mysqli;

class Model {
    private $sgbd = "mysql";
    private $server = "localhost";
    private $dbname = "M07UF3Examen2024";
    private $user = "usr_consulta";
    private $password = "2024@Thos";
    
    protected $link;
    
    public function __constrcut() {
        $this->link = new mysqli($this->servidor, $this->usuari, $this->password, $this->dbname);
    }
    
}

