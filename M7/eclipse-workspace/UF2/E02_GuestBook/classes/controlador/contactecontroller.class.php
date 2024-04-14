<?php

class ContacteController extends Controlador {
    private $contacte;
    
    public function __construct(Contact $param=null){
        parent::__construct();
        $this->contacte = (is_null($param)) ? new Contact("", "", "", "") : $param;
    }
 
    public function form() {
        
        if (isset($_COOKIE["lang"])) {
            $lang = $_COOKIE["lang"];
        } else {
            $lang = "ca";
        }
        
        $vContacte = new ContacteView();
        $vContacte->show($this->contacte, $lang);    
    }
    
    public function validate() {
        if (isset($_COOKIE["lang"])) {
            $lang = $_COOKIE["lang"];
        } else {
            $lang = "ca";
        }
        
        if ($_SERVER["REQUEST_METHOD"]=="POST" && (isset($_POST["boto"]))) {
            $frmNom = $this->sanitize($_POST["nom"],4);
            $frmMail = $this->sanitize($_POST["email"],1);
            $frmMsg = $this->sanitize($_POST["missatge"],3);
            
            if (strlen($frmNom)==0) {
                $errors["nom"] = "Has d'informar un nom";
            }
            if (!filter_var($frmMail, FILTER_VALIDATE_EMAIL)) {
                $errors["mail"] = "L'adreça de correu no és vàlida";
            }
            if (strlen($frmMsg)==0) {
                $errors["missatge"] = "Has d'escriure el comentari que vols enviar";
            }
            $this->contacte = new Contact($frmNom, $frmMail, $frmMsg, $frmData );
            
            if (!isset($errors)) {
                $sData = getdate();
                $this->contacte->data = $sData['mday']."/".$sData['mon']."/".$sData['year'];
                
                $mContacte = new ContactModel();
                $mContacte->create($this->contacte);
                
                $this->contacte = new Contact("", "", "", "");
                $missatgeOK="El comentari s'ha enviat correctament";               
            }
        }
 
        
        $vContacte = new ContacteView();
        $vContacte->show($this->contacte, $lang, $errors, $missatgeOK);  
    }
    
    public function maintenance() {
        if (isset($_COOKIE["lang"])) {
            $lang = $_COOKIE["lang"];
        } else {
            $lang = "ca";
        }
         
        $mContacte = new ContactModel();
        $contactes = array_reverse($mContacte->read());
        
        $capcelera = "<tr><th>Missatge</th><th>Nom</th><th>Mail</th><th>Data</th><th></th></th>\n";
        foreach ($contactes as $key => $value) {
            $cos .= "<tr><td>{$value->missatge}</td><td>{$value->nom}</td><td>{$value->mail}</td><td>{$value->data}</td><td><a href='?contacte/remove/$key'><img src='img/delete.png' width='30px'></a></td></tr>\n";
        }
        $resultat = "<table><thead>$capcelera</thead><tbody>$cos</tbody></table>";

        $vContacte = new ContacteView();
        $vContacte->maintenance($resultat, $lang);  
    }
    
    public function remove($params) {
        if (is_array($params) && count($params)==1) {
            $id = $params[0];
        } else {
            throw new Exception("No es pot eliminar registre sense la seva referència");
        }
        
        
        $mContacte = new ContactModel();
        $mContacte->delete($id);
        
        $this->maintenance();
    }
}

