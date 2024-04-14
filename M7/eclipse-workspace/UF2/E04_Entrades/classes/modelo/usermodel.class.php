<?php
class UserModel {
    private const HOST = "localhost";
    private const CONSULT_USER = "usr_consulta";
    private const GENERIC_USER = "usr_generic";
    private const DATA_BASE = "myweb";
    private const PASSWORD = "2024@Thos";
    
    private $querylink;
    private $actionlink;

    public function __construct() {
        $this->querylink = new mysqli(self::HOST, self::CONSULT_USER, self::PASSWORD, self::DATA_BASE);
        $this->actionlink = new mysqli(self::HOST, self::GENERIC_USER, self::PASSWORD, self::DATA_BASE);
    }
    
    public function getByEmail(User $usuari) {
        $sSql = "SELECT * FROM tbl_usuaris WHERE email=?;";
        $stmt = $this->actionlink->prepare($sSql);
        $stmt->bind_param('s', $usuari->getEmail());
        
        
        if (! ($result = $stmt->execute())) {
            throw new Exception("Error 006 - Problema a l'executar la sentencia: <br> $sSql <br>".mysqli_error($this->querylink));
        } else {
            $result = $stmt->get_result();
            $retorn = $result->fetch_object("User");
        }
        return $retorn;
    }
    
    public function confirma(User $usuari) {        
        $sSql = "UPDATE tbl_usuaris SET status=1, dataDarrerAcces=CURRENT_TIMESTAMP WHERE id=?" ;
        $stmt = $this->actionlink->prepare($sSql);
        $stmt->bind_param("s",$usuari->getId());
        
        if (! $stmt->execute()) {
            throw new Exception("Hi ha un error en al consulta a la BBDD: " . $idConnexioPerAccions->getLastError());
        }
    }
    
    public function isEmailUnic(User $usuari) {
         $sSql = "SELECT COUNT(*) AS res FROM tbl_usuaris WHERE email = ?";
         $stmt = $this->querylink->prepare($sSql);
         $stmt->bind_param('s', $usuari->getEmail());
         
         if ($stmt->execute()) {
            $registreResultat = $stmt->get_result();
            $numRegistres = $registreResultat->fetch_row()[0];

            if ($numRegistres === 0) {
                return true;
            } else {
                return false;
            }
         } 
    }
    
    public function save(User $usuari) {
        $sSql = "INSERT INTO tbl_usuaris (id, email, password, tipusIdent, numeroIdent, nom, cognoms, sexe, naixement, adreca, codiPostal, poblacio, provincia, telefon, imatge, status, navegador, plataforma, dataCreacio, dataDarrerAcces)";
        $sSql .= "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);";
        $stmt = $this->actionlink->prepare($sSql);
        
        $telef=($usuari->getTelefon()=="") ? null : $usuari->getTelefon();        
        $sParam = array(
//            "ssssssssssssssss",
            $usuari->getEmail(),
            $usuari->getPassword(),
            $usuari->getTipusIdent(),
            $usuari->getNumeroIdent(),
            $usuari->getNom(),
            $usuari->getCognoms(),
            $usuari->getSexe(),
            $usuari->getDatanaixement(),
            $usuari->getAdreca(),
            $usuari->getCodiPostal(),
            $usuari->getPoblacio(),
            $usuari->getProvincia(),
            $telef ,
            $usuari->getImatge(),
            $usuari->getNavegador(),
            $usuari->getPlataforma()
        );
        
        if ($stmt->execute($sParam)) {
            return $stmt->insert_id;            
        } else {
            throw new Exception("Hi ha un error en al consulta a la BBDD: " . $this->getLastError());
        }

    }
}

