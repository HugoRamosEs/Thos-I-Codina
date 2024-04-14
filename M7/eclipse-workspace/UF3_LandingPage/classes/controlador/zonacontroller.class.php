<?php

class ZonaController extends Controller {
    private $zona;
    private $zonaModel;
    private $zonaView;

    public function __construct(Zona $param = null) {
        parent::__construct();
        $this->zona = (is_null($param)) ? new Zona("", "") : $param;
        $this->zonaModel = new ZonaModel();
        $this->zonaView = new ZonaView();
    }
    
    public function show($params) {
        if (isset($_COOKIE["lang"])) {
            $lang = $_COOKIE["lang"];
        }else {
            $lang = "cat";
        }
        
        $langTraduccions = $this->menuIdiomes($lang);
        
        $frmErrors = array();
        $zones = $this->zonaModel->read();
        if ($params !== null) {
            $this->zona = $this->zonaModel->getById(intval($params[0]));
        }
        
        if ($_SERVER["REQUEST_METHOD"] == "POST" && (isset($_POST["enviar"]))) {
            $frmDescripcio = $this->sanitize($_POST["descripcio"], 2);
            
            if (strlen($frmDescripcio) == 0) {
                $frmErrors["descripcio1"] = "Has de posar una descripció obligatoriament.";
                $frmDescripcio = "";
            }else if (strlen($frmDescripcio) > 30){
                $frmErrors["descripcio2"] = "Tamany d'entrada exedit.";
                $frmDescripcio = "";
            }
            
            if ($params) {
                if (empty($frmErrors)) {
                    $this->zona->descripcio = $frmDescripcio;
                    $this->zonaModel->update($this->zona);
                    header("Location: index.php?Zona/show");
                    exit();
                }
            }else {
                $this->zona = new Zona(null, $frmDescripcio);
                if (empty($frmErrors)){
                    $this->zonaModel->create($this->zona);
                    $this->zona = null;
                    header("Location: index.php?Zona/show");
                    exit();
                }
            } 
        }
        
        if ($_SERVER["REQUEST_METHOD"] == "POST" && (isset($_POST["cancelar"]))) {
            $this->zona = null;
            header("Location: index.php?Zona/show");
            exit();
        }
        
        $this->zonaView->show($lang, $langTraduccions, $zones, $frmErrors, $this->zona);
    }

    public function delete($params) {
        $zonaGetById = $this->zonaModel->getById(intval($params[0]));
        $this->zonaModel->delete($zonaGetById);
        header("Location: index.php?Zona/show");
        exit();
    }
}

