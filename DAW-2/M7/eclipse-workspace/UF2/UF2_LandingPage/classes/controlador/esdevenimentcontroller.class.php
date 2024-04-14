<?php

class EsdevenimentController extends Controller {
    private $esdeveniment;
    private $esdevenimentModel;
    private $esdevenimentView;
    
    public function __construct(Esdeveniment $param = null) {
        parent::__construct();
        $this->esdeveniment = (is_null($param)) ? new Esdeveniment("", "", "", "", "") : $param;
        $this->esdevenimentModel = new EsdevenimentModel();
        $this->esdevenimentView = new EsdevenimentView();
    }
    
    public function show($params) {
        if (isset($_COOKIE["lang"])) {
            $lang = $_COOKIE["lang"];
        }else {
            $lang = "cat";
        }
        
        $frmErrors = array();
        $imgErrors = array();
        $esdeveniments = $this->esdevenimentModel->read();
        if ($params !== null) {
            $this->esdeveniment = $this->esdevenimentModel->getById(intval($params[0]));
        }
        
        if ($_SERVER["REQUEST_METHOD"] == "POST" && (isset($_POST["enviar"]))) {
            $frmTitol = $this->sanitize($_POST["titol"], 3);
            $frmSubtitol = $this->sanitize($_POST["subtitol"], 3);
            $frmDates = $this->sanitize($_POST["dates"], 4);
            $frmImatge = $_FILES["imatge"];
            
            if (strlen($frmTitol) > 90) {
                $frmErrors["titol1"] = "Tamany d'entrada exedit.";
                $frmTitol = "";
            }
            if (strlen($frmDates) > 90){
                $frmErrors["dates1"] = "Tamany d'entrada exedit.";
                $frmDates = "";
            }else if (strlen($frmDates) != 0 && !preg_match("/^\d{4}\s(?:gener|febrer|març|abril|maig|juny|juliol|agost|setembre|octubre|novembre|desembre)$/i", $frmDates)){
                $frmErrors["dates2"] = "Format incorrecte. Any + Mes.";
                $frmDates = "";
            }
            if ($params) {
                if (!empty($frmImatge["name"])){
                    $imatge = $this->verificarImatge($frmImatge, 2, $imgErrors, 1);
                }
            }else {
                $imatge = $this->verificarImatge($frmImatge, 2, $imgErrors, 0);
            }
            $frmErrors = array_merge($frmErrors, $imgErrors);

            
            if ($params) {
                if (empty($frmErrors)) {
                    $this->esdeveniment->titol = $frmTitol;
                    $this->esdeveniment->subtitol = $frmSubtitol;
                    $this->esdeveniment->dates = $frmDates;
                    if (!empty($frmImatge["name"])){
                        $this->esdeveniment->imatge = $imatge;
                    }
                    $this->esdevenimentModel->update($this->esdeveniment);
                    header("Location: index.php?Esdeveniment/show");
                    exit();
                }
            }else {
                $this->esdeveniment = new Esdeveniment(null, $frmTitol, $frmSubtitol, $frmDates, $imatge);
                if (empty($frmErrors)){
                    $this->esdevenimentModel->create($this->esdeveniment);
                    $this->esdeveniment = null;
                    header("Location: index.php?Esdeveniment/show");
                    exit();
                }
            }
        }
        
        if ($_SERVER["REQUEST_METHOD"] == "POST" && (isset($_POST["cancelar"]))) {
            $this->esdeveniment = null;
            header("Location: index.php?Esdeveniment/show");
            exit();
        }

        $this->esdevenimentView->show($lang, $esdeveniments, $frmErrors, $this->esdeveniment);
    }
    
    public function delete($params) {
        $esdevenimentGetById = $this->esdevenimentModel->getById(intval($params[0]));
        $this->esdevenimentModel->delete( $esdevenimentGetById);
        header("Location: index.php?Esdeveniment/show");
        exit();
    }
}

