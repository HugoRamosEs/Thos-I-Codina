<?php

class LocalitzacioController extends Controller {
    private $localitzacio;
    private $localitzacioModel;
    private $localitzacioView;
    
    public function __construct(Localitzacio $param = null) {
        parent::__construct();
        $this->localitzacio = (is_null($param)) ? new Localitzacio("", "", "", "") : $param;
        $this->localitzacioModel = new LocalitzacioModel();
        $this->localitzacioView = new LocalitzacioView();
    }
    
    public function show($params) {
        if (isset($_COOKIE["lang"])) {
            $lang = $_COOKIE["lang"];
        } else {
            $lang = "cat";
        }
        
        $frmErrors = array();
        $localitzacions = $this->localitzacioModel->read();
        if ($params !== null) {
            $this->localitzacio = $this->localitzacioModel->getById(intval($params[0]));
        }
        
        if ($_SERVER["REQUEST_METHOD"] == "POST" && (isset($_POST["enviar"]))) {
            $frmLloc = $this->sanitize($_POST["lloc"], 4);
            $frmAdreca = $this->sanitize($_POST["adreca"]);
            $frmLocalitat = $this->sanitize($_POST["localitat"], 4);
            
            if (strlen($frmLloc) == 0) {
                $frmErrors["lloc1"] = "Has d'incluir un lloc.";
                $frmLloc = "";
            }else if (strlen($frmLloc) > 90) {
                $frmErrors["lloc2"] = "Tamany d'entrada excedit.";
                $frmLloc = "";
            }
            if (strlen($frmAdreca) == 0) {
                $frmErrors["adreca1"] = "Has d'incluir una adreça.";
                $frmAdreca = "";
            }else if (strlen($frmAdreca) > 90){
                $frmErrors["adreca2"] = "Tamany d'entrada excedit.";
                $frmAdreca = "";
            }
            if (strlen($frmLocalitat) == 0) {
                $frmErrors["localitat1"] = "Has d'incluir una localitat.";
                $frmLocalitat = "";
            }else if (strlen($frmLocalitat) > 90){
                $frmErrors["localitat2"] = "Tamany d'entrada excedit.";
                $frmLocalitat = "";
            }else if (!preg_match("/^\d{5}\s.+/", $frmLocalitat)){
                $frmErrors["localitat3"] = "Format incorrecte. Codi Postal + Ciutat.";
                $frmLocalitat = "";
            }
            
            if ($params) {
                if (empty($frmErrors)) {
                    $this->localitzacio->lloc = $frmLloc;
                    $this->localitzacio->adreca = $frmAdreca;
                    $this->localitzacio->localitat = $frmLocalitat;
                    $this->localitzacioModel->update($this->localitzacio);
                    header("Location: index.php?Localitzacio/show");
                    exit();
                }
            }else {
                $this->localitzacio = new Localitzacio(null, $frmLloc, $frmAdreca, $frmLocalitat);
                if (empty($frmErrors)){
                    $this->localitzacioModel->create($this->localitzacio);
                    $this->localitzacio = null;
                    header("Location: index.php?Localitzacio/show");
                    exit();
                }
            }
        }
        
        if ($_SERVER["REQUEST_METHOD"] == "POST" && (isset($_POST["cancelar"]))) {
            $this->localitzacio = null;
            header("Location: index.php?Localitzacio/show");
            exit();
        }
        
        $this->localitzacioView->show($lang, $localitzacions, $frmErrors, $this->localitzacio);
    }
    
    public function delete($params) {
        $localitzacioGetById = $this->localitzacioModel->getById(intval($params[0]));
        $this->localitzacioModel->delete($localitzacioGetById);
        header("Location: index.php?Localitzacio/show");
        exit();
    }
}

