<?php

class Config {
    private $host = "192.168.19.0";
    private $user = "usr_examen";
    private $pass = "2023@Thos";
    private $name = "examenM07UF2_2023";
    private $options = [ PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION];
    private $sgbd = "mysql";
    
    public $link;
    private static $_instance;
    
    /**
     * Constructor que inicia una instància per a establir una connexió a la base de dades amb l'usuari especificat.
     * @param int $usr:
     *      [0] usr_generic ---> Conecta a la base de dades amb l'usuari generic. Es l'usuari per defecte.
     *      [1] usr_consulta --> Conecta a la base de dades amb l'usuari consulta.
     */
    private function __construct(){
        switch ($this->sgbd){
            case "mysql":
                if ($link = new mysqli($this->host, $this->user, $this->pass, $this->name, $this->options)){
                    $this->link = $link;
                }else{
                    throw new Exception("No s'ha pogut establir una conexió.");
                }
                break;
            case "pgsql":
                // Codi per PostgreSQL.
                break;
            case "oracle":
                // Codi per Oracle.
                break;
            case "mondobd":
                // Codi per MondoBd.
                break;
            default:
                throw new Exception("$this->sgbd no es un sistema gestor de base de dades suportat.");
        }
    }
    
    public static function getInstance(){
        if (!(self::$_instance instanceof self)){
            self::$_instance = new self();
        }
        return self::$_instance;
    }
    
    public function executeSQL($query, $params = null){
        switch ($this->sgbd){
            case "mysql":
                if ($stmt = $this->link->prepare($query)){
                    if ($stmt->execute($params)){
                        $res = $stmt->get_result();
                        if ($res !== false) {
                            $dades = $res->fetch_all(MYSQLI_ASSOC);
                            $stmt->close();
                            return $dades;
                        }else {
                            $stmt->close();
                            return true;
                        }
                    }
                }
                return false;
                break;
            case "pgsql":
                // Codi per PostgreSQL.
                break;
            case "oracle":
                // Codi per Oracle.
                break;
            case "mondobd":
                // Codi per MondoBd.
                break;
            default:
                throw new Exception("$this->sgbd no es un sistema gestor de base de dades suportat.");
        }
    }
    
    public function changeUser($usr, $pass, $db){
        $this->link->change_user($usr, $pass, $db);
    }
    
    public function __destruct(){
        switch ($this->sgbd){
            case "mysql":
                $this->link->close();
                break;
            case "pgsql":
                // Codi per PostgreSQL.
                break;
            case "oracle":
                // Codi per Oracle.
                break;
            case "mondobd":
                // Codi per MondoBd.
                break;
            default:
                throw new Exception("$this->sgbd no es un sistema gestor de base de dades suportat.");
        }
    }
    
    private function __clone () {}
}

