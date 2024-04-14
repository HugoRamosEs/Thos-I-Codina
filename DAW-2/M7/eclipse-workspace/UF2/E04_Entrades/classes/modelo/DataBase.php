<?php 
class DataBase {
    private $consult_user;
    public $link;    
    public static $_instance;
    
    private function __construct() {
        switch (Config::getInstance()->sgbd) {
        case "mysql":
            try {
                $this->consult_user = true;
                $link = new mysqli(Config::getInstance()->servidor,
                    Config::getInstance()->usuari_consultes,
                    Config::getInstance()->password_consultes,
                    Config::getInstance()->dbname);
            } catch (mysqli_sql_exception $e) {
                $this->consult_user = false;
                $link = new mysqli();  
                $link->select_db(Config::getInstance()->sgbd);
            }
            
            if ($link) {
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
        switch (Config::getInstance()->sgbd) {
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
    
    public function canviUsuari() {
        $this->consult_user = !$this->consult_user;
        if ($this->consult_user) {
            $res = $this->link->change_user(Config::getInstance()->usuari_consultes, 
                Config::getInstance()->password_consultes, 
                Config::getInstance()->dbname);
        } else {
            $res = $this->link->change_user(Config::getInstance()->usuari_generic, 
                Config::getInstance()->password_generic, 
                Config::getInstance()->dbname);
        }
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
        switch (Config::getInstance()->sgbd) {
            case "mysql":
                if ($conexio == "consulta") {
                    if ($stmt = $this->link->prepare($sentencia)) {
                        if ($res = $stmt->execute($parametres)) {
                            $dades = $stmt->get_result();
                        }
                    }
                } else {
                    if ($stmt = $this->link->prepare($sentencia)) {
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
        switch (Config::getInstance()->sgbd) {
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
        switch (Config::getInstance()->sgbd) {
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
        switch (Config::getInstance()->sgbd) {
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
        switch (Config::getInstance()->sgbd) {
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
    
    public static function executarSQL($stmt, $parametres){
        $prepadedStatement = $this->link->prepare($stmt);
        if ($res = call_user_func_array(array($preparedStmt, 'bind_param'), UserModel::refValues($parametres))) {
            if ($res = $preparedStmt->execute()) {
                $dades = $preparedStmt->get_result();
            } else {
                throw new Exception("Problemes d'execució de la sentència");
            }
        } else {
            throw new Exception("crida a call_user_func_array incorrecte");
        }
        
        
        return ($dades) ? $dades : $res ;
    }
    
    private function refValues($arr)  {
        $refs = array();
        foreach ($arr as $key => $value)
            $refs[$key] = &$arr[$key];
            return $refs;
    }
}
?>