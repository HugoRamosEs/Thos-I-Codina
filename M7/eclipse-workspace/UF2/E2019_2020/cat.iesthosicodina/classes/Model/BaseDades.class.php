<?php


/**
 * Classe encarregada de gestionar les connexions a la base de dades
 * @author toni
 *
 */


Class BaseDades{
    private $sgbd;
    private $servidor;
    private $usuari;
    private $password;
    private $baseDades;
    private $link;
    private $stmt;
    private $dades;
    
    public static $_instance;
    
    
    /*
     * El constructor de l'objecte eś privat per evitar que pugui ser creat mitjançant un new.
     */
    private function __construct(){
        $this->setConexion();
        return $this->conectar();
    }
    
    public function __destruct(){
         $this->link->close();
    }
    
    public function close(){
        $result = false;
        switch ($this->sgbd) {
            case "mysql":
                // $reculst = mysqli_close($this->link);
                $result = $this->link->close();
                break;
            case "postgre":
                $result = pg_close($this->link);
                break;
            case "sqlserver":
                sqlsrv_close($this->link);
                break;
        }
        return $result;
    }
    
    /*
     * Evitem el clonatge de l'objecte -> Patró Singleton
     */
    private function __clone(){ }
    
    /*
     * Funció encarregada de la creació (en cas necessari) de l'objecte.
     * És la funció que s'ha de cridar per instanciar l'ojecte i poder cridar els seus mètodes
     * @return BaseDades
     */
    public static function getInstance(){
        if (!(self::$_instance instanceof self)){
            self::$_instance = new self();
        }
        return self::$_instance;
    }
    
    /**
     * Estableix els atributs de la connexió en funció del fitxer de configuració. Necessitem les dades en
     * config.php i cla classe conf.class.php
     */
    private function setConexion(){
        $conf = new Configuracio();
        
        $this->sgbd = $conf->getSgbd();
        $this->servidor = $conf->getDbServidor();
        $this->baseDades = $conf->getDbBaseDeDades();
        $this->usuari = $conf->getDbUsernamePerAccions();
        $this->password = $conf->getDbPassword();
    }
    
    /*
     * Realitza la connexió a la base de dades:
     * mysql_connect
     * mysql_select_db
     * Farem servir sistema de codificació UTF8
     */
    private function conectar(){
        switch ($this->sgbd) {
            case "mysql":
                // $link = mysqli_connect($this->servidor, $this->usuari, $this->password, $this->baseDades);
                $link = new mysqli($this->servidor, $this->usuari, $this->password, $this->baseDades);
                break;
            case "postgre":
                $link = pg_connect("host=".$this->servidor." dbname=".$this->baseDades." user=".$this->usuari." password=".$this->password);
                break;
            case "sqlserver":
                $link=sqlsrv_connect($this->servidor, array("Database"=> $this->baseDades,"UID"=> $this->usuari,"PWD"=>$this->password, "CharacterSet" => "UTF-8"));
                break;
        }
        
        if ($link->connect_errno > 0){
            throw new MyWebPageException($link->connect_errno, "Problemes al conectar amb la BBDD");
        } else {
            $this->link = $link;
        }
        return $link;
    }
    
    /*
     * Realitza consultes sql a la base de dades.
     * @param unknown $sql String amb la sentencia sql que volem esecutar
     * @return mixed recurs[Resource] on s'enmagatzema el resultat de la consulta
     */
    public function executar($sql, $parametres){
        $this->stmt = false;
        switch ($this->sgbd) {
            case "mysql":
                // $this->stmt = mysqli_query($this->link, $sql);
                if ($sentencia = $this->link->prepare($sql)) {
                    if ($res = call_user_func_array(array($sentencia, 'bind_param'), $this->refValues($parametres))) {
                        if ($res = $sentencia->execute()) {
                            $this->stmt = $sentencia;
                            $this->dades = $sentencia->get_result();
                         }
                    }
                }
                break;
            case "postgre":
                $this->stmt=pg_query($this->link,$sql);
                break;
            case "sqlserver":
                $this->stmt=sqlsrv_query($this->link,$sql);
                break;
        }
        return $this->stmt;
    }
    
    /*Método para obtener una fila de resultados de la sentencia sql*/
    /*
     * Obetenció d'una fila de resultats d'una sentencia sql
     * @param unknown $stmt recurs[Resource] on s'enmagatzema el resultat de la consulta i hem obtingut
     * 						amb la funció ejecutar(sql)
     * @param unknown $fila Numero de fila que volem recuperar.
     * 					0 -> seqüencial, una fila rera l'altre.
     * 					num -> una fila específica.
     * @return multitype: array amb els resultats: [0,1,2,3 ... n] amb l'ordre de camps definit per la base de dades o la
     * 					la sentencia sql, i ["camp1','camp2'...'campn'] amb el literal del mom del camp o columna a la
     * 					base de dades.
     */
    public function obtenir_fila($stmt,$fila){
        $result = null;
        switch ($this->sgbd) {
            case "mysql":
                if ($fila != 0) {
                    // mysqli_data_seek($stmt,$fila);
                    $this->dades->data_seek($fila);
                } 
                //$result = mysqli_fetch_array($stmt);
                $result = $this->dades->fetch_array(MYSQLI_BOTH);
                break;
            case "postgre":
                if ($fila==0){
                    pg_fetch_row($stmt);
                }
                $result=pg_fetch_row($stmt,$fila);
                break;
            case "sqlserver":
                if ($fila==0){
                    sqlsrv_fetch_array($stmt);
                }
                $resultsqlsrv_fetch_array($stmt,"SQLSRV_FETCH_ASSOC",$fila,1);
                break;
        }
        return $result;
    }

    
    public function numeroDeFiles() {
        $result = -1;
        switch ($this->sgbd) {
            case "mysql":
                // mysqli_num_rows($this->stmt);
                $result = $this->dades->num_rows;
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
                // mysqli_errno($this->link);
                $result = $this->link->errno;
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
    
    private function refValues($arr){
            $refs = array();
            foreach($arr as $key => $value)
                $refs[$key] = &$arr[$key];
                return $refs;
     }
}
?>
