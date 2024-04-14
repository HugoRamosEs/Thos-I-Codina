<?php

class ContacteController extends Controller {
    private $contacte;
    
    public function __construct(Contacte $param = null){
        parent::__construct();
        $this->contacte = (is_null($param)) ? new Contacte("", "", "", "") : $param;
    }
    
    public function form(){
        if (isset($_COOKIE["lang"])) {
            $lang = $_COOKIE["lang"];
        } else {
            $lang = "cat";
        }
        
        if ($_SERVER["REQUEST_METHOD"] == "POST" && (isset($_POST["enviar"]))) {
            $frmNom = $this->sanitize($_POST["nom"], 4);
            $frmMail = $this->sanitize($_POST["email"], 1);
            $frmMsg = $this->sanitize($_POST["missatge"], 3);
            
            if (strlen($frmNom) == 0) {
                $frmErrors["nom"] = "Nom no vàlid.";
                $frmNom = "";
            }
            if (! filter_var($frmMail, FILTER_VALIDATE_EMAIL)) {
                $frmErrors["mail"] = "Email no vàlid.";
                $frmMail = "";
            }
            if (strlen($frmMsg) == 0) {
                $frmErrors["missatge"] = "Has d'escriure un missatge.";
                $frmMsg = "";
            }
            $this->contacte = new Contacte($frmNom, $frmMail, $frmMsg, $frmData);
            
            if (empty($frmErrors)) {
                $frmData = getdate();
                $this->contacte->data = $frmData;
                $contacteModel = new ContacteModel();
                $contacteModel->create($this->contacte);
                $this->contacte = new Contacte("", "", "", "");
                $ok = "El comentari s'ha enviat correctament.";
            }
        }
        $vContacte = new ContacteView();
        $vContacte->show($lang, $this->contacte, $ok, $frmErrors);
    }
}

