<?php 
class BaseDades {
    private $sgbd = "mysql";
    private $servidor = "localhost";
    private $dbname = "myweb";
    private $usuari = "usr_consulta";
    private $password = "2024@Thos";
    
    private $link;
    
    public static $_instance;
    
    private function __construct() { 
        switch ($this->sgbd) {
        case "mysql":
            if ($link = new mysqli($this->servidor, $this->usuari, $this->password, $this->dbname)) {
                $this->link=$link;
            } else {
                throw new Exception("No s'ha pogut crear l'objecte");
            }
            break;
        case "postgre":
            $link = pg_connect("host=" . $this->servidor . " dbname=" . $this->baseDades . " user=" . $this->usuari . " password=" . $this->password);
            break;
        case "sqlserver":
            $link = sqlsrv_connect($this->servidor, array(
                "Database" => $this->dbname,
                "UID" => $this->usuari,
                "PWD" => $this->password,
                "CharacterSet" => "UTF-8"
                ));
            break;
        }
    }

    public function __destruct() {
        switch ($this->sgbd) {
            case "mysql":
                $this->link->close();
                break;
            case "postgre":
                $result = pg_close($this->link);
                break;
            case "sqlserver":
                sqlsrv_close($this->link);
                break;
        }
    }
    
    private function __clone(){}
    
    public static function getInstance() {
        if (!(self::$_instance instanceof self)) {
            self::$_instance = new self();
        }
        return self::$_instance;
    }
    
    public static function canviUsuari($link) {
        $res = $link->change_user(ini_get("mysqli.default_user"), ini_get("mysqli.default_pw"), "myweb");
    }

    /**
     * Realitza consultes sql a la base de dades.
     *
     * @param String $sql
     *            String amb la sentencia sql que volem esecutar
     * @param Array $parametres
     *            Conjunt de paràmetres de ls sentència Sql.
     * @return mixed recurs[Resource] on s'enmagatzema el resultat de la consulta
     */
    public function execute($sentencia, $parametres=null, $conexio="consulta") {
        switch ($this->sgbd) {
            case "mysql":
                if ($conexio == "consulta") {
                    if ($stmt = $this->link->prepare($sentencia)) {
                        if ($res = $stmt->execute($parametres)) {
                            $dades = $stmt->get_result();
                        }
                    }
                } else {
                    $link = $this->link;
                    self::canviUsuari($link);

                    if ($stmt = $link->prepare($sentencia)) {
                        $dades = $stmt->execute($parametres);
                    }
                }
                break;
            case "postgre":
                $this->stmt = pg_query($this->link, $sql);
                break;
            case "sqlserver":
                $this->stmt = sqlsrv_query($this->link, $sql);
                break;
        }
        return $dades;
    }
    
    /**
     * Obetenció d'una fila de resultats d'una sentencia sql
     *
     * @param mysqli_result $result
     *            recurs[Resource] on s'enmagatzema el resultat de la consulta i hem obtingut
     *            amb la funció ejecutar(sql)
     * @param integer $fila
     *            Numero de fila que volem recuperar.
     *            0 -> seqüencial, una fila rera l'altre.
     *            num -> una fila específica.
     * @return multitype: array amb els resultats en forma d'objecte.
     */
    public function obtenirFila(mysqli_result $result, $fila=0) {
        switch ($this->sgbd) {
            case "mysql":
                if ($fila != 0) {
                    $result->data_seek($fila);
                }
                break;
            case "postgre":
                if ($fila == 0) {
                    pg_fetch_row($stmt);
                }
                $result = pg_fetch_row($stmt, $fila);
                break;
            case "sqlserver":
                if ($fila == 0) {
                    sqlsrv_fetch_array($stmt);
                }
                $resultsqlsrv_fetch_array($stmt, "SQLSRV_FETCH_ASSOC", $fila, 1);
                break;
        }
//         return $result->fetch_assoc();
        return $result->fetch_object();
    }
    
    public function numeroDeFiles($result) {
        switch ($this->sgbd) {
            case "mysql":
                $result = $result->num_rows;
                break;
            case "postgre":
                $result = pg_num_rows();
                break;
            case "sqlserver":
                $result = sqlsrv_num_rows();
                break;
        }
        return $result;
    }
    
    public function getLastError() {
        switch ($this->sgbd) {
            case "mysql":
                if (isset($this->link->errno)) {
                    $result=$this->link->errno;
                } else {
                    $result=$this->link->errno;
                }
                break;
            case "postgre":
                $result = pg_last_error($this->link);
                break;
            case "sqlserver":
                $result = sqlsrv_errors();
                break;
        }
        return $result;
        
    }
    
    public function getLastId() {
        switch ($this->sgbd) {
            case "mysql":
                $result = $this->link->insert_id;
                break;
            case "postgre":
                $result = pg_last_oid($this->link);
                break;
            case "sqlserver":
                $result = sqlsrv_insert_id();
                break;
        }
        return $result;
        
    }
    
    private function refValues($arr)  {
        $refs = array();
        foreach ($arr as $key => $value)
            $refs[$key] = &$arr[$key];
            return $refs;
    }
}
?>