<?php

class GuestBookController extends Controller {
    public function __construct(Contacte $param = null){
        parent::__construct();
        $this->comentari = (is_null($param)) ? new Comentari("", "", "", "", "") : $param;
    }
    
    public function form(){
        if (isset($_COOKIE["lang"])) {
            $lang = $_COOKIE["lang"];
        } else {
            $lang = "cat";
        }
        
        if ($_SERVER["REQUEST_METHOD"]=="POST" && (isset($_POST["enviar"]))) {
            $frmNom = $this->sanitize($_POST["nom"], 4);
            $frmMail = $this->sanitize($_POST["email"], 1);
            $frmOpcio = $this->sanitize($_POST["seleccio"], 4);
            $frmMsg = $this->sanitize($_POST["missatge"], 3);
            $frmErrors = [];
            
            if (strlen($frmNom) == 0) {
                $frmErrors["nom"] = "Nom no vàlid.";
                $frmNom = "";
            }
            if (!filter_var($frmMail, FILTER_VALIDATE_EMAIL)) {
                $frmErrors["mail"] = "Email no vàlid.";
                $frmMail = "";
            }
            $opcions = ["Molt Bona", "Bona", "Regular", "Dolenta", "Molt Dolenta"];
            if (empty($frmOpcio) || !in_array($frmOpcio, $opcions)) {
                $frmErrors["seleccio"] = "Has de seleccionar una opció vàlida.";
                $frmOpcio = "";
            }
            if (strlen($frmMsg) == 0) {
                $frmErrors["missatge"] = "Has d'escriure un missatge.";
                $frmMsg = "";
            }
            $this->comentari = new Comentari($frmNom, $frmMail, $frmOpcio, $frmMsg, $frmData);
            
            if (empty($frmErrors)) {
                try {
                    $frmData = getdate();
                    $this->comentari->data = $frmData;
                    $comentariModel = new ComentariModel();
                    $comentariModel->create($this->comentari);
                    $this->comentari = new Comentari("", "", "", "", "");
                    $ok = "S'ha enviat correctament.";
                } catch (Exception $e) {
                    $frmErrors["classe"] = $e->getMessage();
                }
            }
        }
        $comentariModel = new ComentariModel();
        $registres = $comentariModel->read();
        
        $registresSanititzats = array();
        foreach ($registres as &$registre) {
            $registreSanititzat = array();
            foreach ($registre as $dada) {
                $dada = $this->sanitize($dada);
                $registreSanititzat[] = $dada;
            }
            $registresSanititzats[] = $registreSanititzat;
        }
        
        $vGuestBook = new GuestBookView();
        $vGuestBook->show($this->comentari, $registresSanititzats, $lang, $frmErrors, $ok);   
    }
}

