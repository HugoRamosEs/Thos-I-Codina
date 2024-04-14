<?php
class Model {
//     private $servidor;
//     private $baseDades;
//     private $usuario;
//     private $passowrd;
//     private $dbType;
    private $usuariDatabase;
    private $link;
    private $stmt;
    private $array;
    
    static $_instance;

    public function __construct() {
//         $this->servidor = 'localhost';
//         $this->baseDades = 'examen2022';
//         $this->usuario = 'usr_generic';
//         $this->password = 'Thico@2020';
//         $this->dbType = 'mysql';
        $this->usuariDatabase = Configuracio::getInstance()->getUsuariDatabase();
        
        try {
            $dsn = $this->usuariDatabase->dbtype . ":dbname=" . $this->usuariDatabase->db . ";host=" . $this->usuariDatabase->host;
            $this->link = new PDO ( $dsn, $this->usuariDatabase->user, $this->usuariDatabase->password );
        } catch ( PDOException $e ) {
            throw new Exception("Error 001 - Fallada de connexió: " . $e->getMessage ());
        }
    }
    
    public function executar($sSql, $sParams) {
        try {
            $this->stmt = $this->link->prepare ( $sSql );
            $res = $this->stmt->execute ($sParams);
            $res = $this->stmt->fetchAll ();
            return $res;
        } catch ( PDOException $e ) {
            throw new Exception("Error 001 - Fallada de consulta SQL: " . $e->getMessage ());
        }
    }
}

