<?php

class UserModel {

    private $baseDeDades;
    private $user;
    private $errorsDetectats;

    public function __construct() {
        $this->baseDeDades = BaseDades::getInstance();
    }

    public function getUser($usuari, $password) {
        $sSql = "SELECT * FROM tbl_usuaris WHERE email = ? AND password = ?";

        if ($resultatConsulta = $this->baseDeDades->executar($sSql, array("ss",$usuari, $password))) {
            if ($this->baseDeDades->numeroDeFiles() == 0) {
                $this->errorsDetectats["password"] = "No existeix aquesta convinació d'usuari i contrasenya. Revisa les dades entrades";
            } else {
                $registreResultat = $this->baseDeDades->obtenir_fila($resultatConsulta, 0);
                if ($registreResultat['status'] == 0) {
                    $this->errorsDetectats["password"] = "El teu usuari encara no està actiu. Ves al teu mail i segueix les instruccions";
                } else {
                    $this->user = new User();
                    $this->user->setId($registreResultat['id']);
                    $this->user->setEmail($registreResultat['email']);
                    $this->user->setPassword($registreResultat['password']);
                    $this->user->setTipusIdent($registreResultat['tipusIdent']);
                    $this->user->setNumeroIdent($registreResultat['numeroIdent']);
                    $this->user->setNom($registreResultat['nom']);
                    $this->user->setCognoms($registreResultat['cognoms']);
                    $this->user->setSexe($registreResultat['sexe']);
                    $this->user->setDatanaixement($registreResultat['datanaixement']);
                    $this->user->setAdreca($registreResultat['adreca']);
                    $this->user->setCodiPostal($registreResultat['codiPostal']);
                    $this->user->setPoblacio($registreResultat['poblacio']);
                    $this->user->setProvincia($registreResultat['provincia']);
                    $this->user->setTelefon($registreResultat['telefon']);
                    $this->user->setImatge($registreResultat['imatge']);
                    $this->user->setStatus($registreResultat['status']);
                    $this->user->setNavegador($registreResultat['navegador']);
                    $this->user->setPlataforma($registreResultat['plataforma']);
                    $this->user->setDataCreacio($registreResultat['dataCreacio']);
                    $this->user->setDataDarrerAcces($registreResultat['dataDarrerAcces']);
                }
            }
        } else {
            $this->errorsDetectats["password"] = "Hi ha un error en al consulta a la BBDD: " . mysqli_error($idConnexioPerConsultes);
        }
        
        return $this->user;
    }
    
    public function saveUser($usuari) {
        $sSql = "INSERT INTO tbl_usuaris (id, email, password, tipusIdent, numeroIdent, 
                nom, cognoms, sexe, datanaixement, adreca, codiPostal, poblacio, provincia, 
                telefon, imatge, status, navegador, plataforma, dataCreacio, dataDarrerAcces)";
        $sSql .= "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);";
        $params = array ("ssssssssssssisiss", $usuari->getEmail(), $usuari->getPassword(), 
            $usuari->getTipusIdent(), $usuari->getNumeroIdent(), 
            $usuari->getNom(), $usuari->getCognoms(), $usuari->getSexe(), $usuari->getDatanaixement(), 
            $usuari->getAdreca(), $usuari->getCodiPostal(), $usuari->getPoblacio(), $usuari->getProvincia(), 
            $usuari->getTelefon(), $usuari->getImatge(), $usuari->getStatus(), 
            $usuari->getNavegador(), $usuari->getPlataforma());
        
        if ($this->baseDeDades->executar($sSql, $params)) {
            $idDelRegistreInsertat = $this->baseDeDades->getLastId();
        } else {
            $idDelRegistreInsertat = null;
            $this->errorsDetectats["baseDades"] = "Hi ha un error en al consulta a la BBDD: " . $this->baseDeDades->getLastError();
        }
        return $idDelRegistreInsertat;
    }
    
    public function esEmailUnic($email) {
        $sSql = "SELECT * FROM tbl_usuaris WHERE email = ?";
        $parametres = array ("s", $email);
        $this->baseDeDades->executar($sSql, $parametres);
        return $this->baseDeDades->numeroDeFiles() == 0 ? true : false; 
    }
    
    public function activa($id) {
        $sSql = "UPDATE tbl_usuaris SET status=1, dataDarrerAcces=CURRENT_TIMESTAMP WHERE id = ?" ;
        $params = array("i",$id);
        if (!$this->baseDeDades->executar($sSql, $params)) {
            $errorsDetectats["baseDades"] = "Hi ha un error en al consulta a la BBDD: " . $this->baseDeDades->getLastError();
        }
    }
    
    public function getErrors() {
        return $this->errorsDetectats;
    }
    
 
}
?>