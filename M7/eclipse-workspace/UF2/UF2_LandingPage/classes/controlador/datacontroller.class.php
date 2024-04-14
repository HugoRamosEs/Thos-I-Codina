<?php

class DataController extends Controller {
    private $data;
    
    public function __construct(Data $param = null) {
        parent::__construct();
        $this->data = (is_null($param)) ? new Data("", "", "") : $param;
    }
    
    public function show($params) {
        if (isset($_COOKIE["lang"])) {
            $lang = $_COOKIE["lang"];
        }else {
            $lang = "cat";
        }
        
        $frmErrors = array();
        $dates = DataModel::read();
        if ($params !== null) {
            $this->data = DataModel::getById(intval($params[0]));
        }
        
        if ($_SERVER["REQUEST_METHOD"] == "POST" && (isset($_POST["enviar"]))) {
            $frmData = $this->sanitize($_POST["dData"]);
            $frmHora = $this->sanitize($_POST["hora"]);
            
            if (strlen($frmData) == 0) {
                $frmErrors["data1"] = "Has d'incloure una data.";
                $frmData = "";
            }else if ($this->verificarData($frmData, "-", 1) == false) {
                $frmErrors["data2"] = "Data invàlida.";
                $frmData = "";
            }
            if (strlen($frmHora) == 0) {
                $frmErrors["hora1"] = "Has d'incloure una hora.";
                $frmHora = "";
            }else if ($this->verificarHora($frmHora, 1) == false) {
                $frmErrors["hora2"] = "Hora invàlida.";
                $frmHora = "";
            }
            
            if ($params) {
                if (empty($frmErrors)) {
                    $this->data->setData($frmData);
                    $this->data->setHora($frmHora);
                    DataModel::update($this->data);
                    header("Location: index.php?Data/show");
                    exit();
                }
            }else {
                $this->data = new Data(null, $frmData, $frmHora);
                if (empty($frmErrors)){
                    DataModel::create($this->data);
                    $this->data = null;
                    header("Location: index.php?Data/show");
                    exit();
                }
            }
        }
        
        if ($_SERVER["REQUEST_METHOD"] == "POST" && (isset($_POST["cancelar"]))) {
            $this->data = null;
            header("Location: index.php?Data/show");
            exit();
        }
        
        DataView::show($lang, $dates, $frmErrors, $this->data);
    }
    
    public function delete($params) {
        DataModel::delete(DataModel::getById(intval($params[0])));
        header("Location: index.php?Data/show");
        exit();
    }
}

