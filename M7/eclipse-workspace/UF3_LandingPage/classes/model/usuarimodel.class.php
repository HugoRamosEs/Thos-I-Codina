<?php

class UsuariModel implements Crudable {
    /*
     * private const HOST = "localhost";
     * private const CONSULT_USER = "usr_consulta";
     * private const GENERIC_USER = "usr_generic";
     * private const DATA_BASE = "myweb";
     * private const PASSWORD = "2024@Thos";
     * 
     * private $querylink;
     * private $actionlink;
     */
    
    public function __construct(){
        /*
         * this->queryLink = new msqli(self::HOST, self::CONSULT_USER, self::PASSWORD, self::DATA_BASE, self::PASSOWRD);
         * this->actionLink = new msqli(self::HOST, self::GENERIC_USER, self::PASSWORD, self::DATA_BASE, self::PASSOWRD); 
         */
    }

    public function create($usuari) {
        $db = new mysqli("localhost", "usr_generic", "2024@Thos", "myweb");
        $dades = [$usuari->email, $usuari->password, $usuari->tipusIdent, $usuari->numeroIdent, $usuari->nom, $usuari->cognoms, $usuari->sexe, $usuari->naixement, $usuari->adreca, $usuari->codiPostal, $usuari->poblacio, $usuari->provincia, $usuari->telefon, $usuari->imatge, $usuari->navegador, $usuari->plataforma];
        $contador = str_repeat("s", count($dades));
        $sql = "INSERT INTO tbl_usuaris (email, password, tipusIdent, numeroIdent, nom, cognoms, sexe, naixement, adreca, codiPostal, poblacio, provincia, telefon, imatge, navegador, plataforma) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        $stmt = $db->prepare($sql);
        if($db->connect_error){
            die("La connexió ha fallat, error número".
                $db->connect_errno . ": " . $db->connect_error);
        }
        
//         // Forma 1: parametre per parametre (no funciona)
//         $stmt->bind_param("s", $usuari->email);
//         $stmt->bind_param("s", $usuari->password);
//         $stmt->bind_param("s", $usuari->tipusIdent);
//         $stmt->bind_param("s", $usuari->numeroIdent);
//         $stmt->bind_param("s", $usuari->nom);
//         $stmt->bind_param("s", $usuari->cognoms);
//         $stmt->bind_param("s", $usuari->sexe);
//         $stmt->bind_param("s", $usuari->naixement);
//         $stmt->bind_param("s", $usuari->adreca);
//         $stmt->bind_param("s", $usuari->codiPostal);
//         $stmt->bind_param("s", $usuari->poblacio);
//         $stmt->bind_param("s", $usuari->provincia);
//         $stmt->bind_param("s", $usuari->telefon);
//         $stmt->bind_param("s", $usuari->imatge);
//         $stmt->bind_param("s", $usuari->navegador);
//         $stmt->bind_param("s", $usuari->plataforma);
//         $stmt->execute();
        
        // Forma 2: tots els parametres a la vegada
        $stmt->bind_param($contador, $usuari->email, $usuari->password, $usuari->tipusIdent, $usuari->numeroIdent, $usuari->nom, $usuari->cognoms, $usuari->sexe, $usuari->naixement, $usuari->adreca, $usuari->codiPostal, $usuari->poblacio, $usuari->provincia, $usuari->telefon, $usuari->imatge, $usuari->navegador, $usuari->plataforma);
        $stmt->execute();
        
//         // Forma 3: amb array
//         $stmt->bind_param($contador, ...$dades);
//         $stmt->execute();
        
//         // Forma 4: amb la funció call_user_func_array
//         call_user_func_array(array($stmt, "bind_param"), array_merge(array($contador), $dades));
//         $stmt->execute();
        
//         // Forma 5: directament al execute (desde PHP 8.1)
//         $stmt->execute($dades);
        
        $lastId = $stmt->insert_id;
        $stmt->close();
        $db->close();
        return $lastId;   
    }

    public function read($usuari){
        $db = new mysqli("localhost", "usr_consulta", "2024@Thos", "myweb");
        if($db->connect_error){
            die("La connexió ha fallat, error número".
                $db->connect_errno . ": " . $db->connect_error);
        }
        $stmt = $db->prepare("SELECT email, password, status, imatge FROM tbl_usuaris WHERE email = ? AND password = ?");
        $stmt->bind_param("ss", $usuari->email, $usuari->password);
        $stmt->execute();
        $resultat = $stmt->get_result();
        $dadesUsuari = $resultat->fetch_assoc();
        $stmt->close();
        $db->close();
        return $dadesUsuari;
        
        /*
         * Para retornar, mejor hacer:
         * $result = $stmt->get_result();
         * $retorn = $result->fetch_object("User");
         */   
    }

    public function update($usuariId){
        $db = new mysqli("localhost", "usr_generic", "2024@Thos", "myweb");
        if($db->connect_error){
            die("La connexió ha fallat, error número".
                $db->connect_errno . ": " . $db->connect_error);
        }
        $stmt = $db->prepare("UPDATE tbl_usuaris SET status = ? WHERE id = ?");
        $status = 1;
        $stmt->bind_param("ii", $status, $usuariId);
        $stmt->execute();
        $stmt->close();
        $db->close();
    }

    public function delete($usuari){}
    
}

