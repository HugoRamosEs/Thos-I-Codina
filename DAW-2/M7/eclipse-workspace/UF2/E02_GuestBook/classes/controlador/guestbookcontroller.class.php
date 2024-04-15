<?php

class GuestBookController extends Controlador {
    private $comentari;
    
    public function __construct(Comentari $param=null){
        parent::__construct();
        $this->comentari = (is_null($param)) ? new Comentari("", "", "", "") : $param;
    }
 
    public function form() {
        if (isset($_COOKIE["lang"])) {
            $lang = $_COOKIE["lang"];
        } else {
            $lang = "ca";
        }
        
        if ($_SERVER["REQUEST_METHOD"]=="POST" && (isset($_POST["boto"]))) {
            $frmNom = $this->sanitize($_POST["nom"],4);
            $frmMail = $this->sanitize($_POST["email"],1);
            $frmExp = $this->sanitize($_POST["experiencia"],2);
            $frmMsg = $this->sanitize($_POST["missatge"],3);
            
            if (strlen($frmNom)==0) {
                $errors["nom"] = "Has d'informar un nom";
            }
            if (!filter_var($frmMail, FILTER_VALIDATE_EMAIL)) {
                $errors["mail"] = "L'adreça de correu no és vàlida";
            }
            if(!in_array($frmExp, array("MB","B","R","D", "MB"))) {
                $errors["exp"] = "Algun problema amb l'experiència";
            }
            if (strlen($frmMsg)==0) {
                $errors["missatge"] = "Has d'escriure el comentari que vols enviar";
            }
            $this->comentari->setNom($frmNom);
            $this->comentari->setMail($frmMail);
            $this->comentari->setMissatge($frmMsg);
            $this->comentari->setExperiencia($frmExp);
            
            if (!isset($errors)) {
                $sData = getdate();
                $this->comentari->setData($sData['year']."-".$sData['mon']."-".$sData['mday']);
                

                
                $mComentari = new ComentariModel();
                $mComentari->create($this->comentari);
                
                $this->comentari = new Comentari("", "", "", "");
            }
        }
        
        $mComentari = new ComentariModel();
        $comentaris = $mComentari->read();

        if ($comentaris!=null) {
            $items = array_reverse($comentaris);
        }
        
        $vGuestBook = new GuestBookView();
        $vGuestBook->show($this->comentari, $items, $lang, $errors);          
    }
}

