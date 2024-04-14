<?php

class PagamentController extends Controller {
    private $pagament;
    private $pagamentModel;
    private $pagamentView;
    
    public function __construct(Pagament $param = null) {
        parent::__construct();
        $this->pagament = (is_null($param)) ? new Pagament("", "", "", "", "") : $param;
        $this->pagamentModel = new PagamentModel();
        $this->pagamentView = new PagamentView();
    }
    
    public function show($params) {
        if (isset($_COOKIE["lang"])) {
            $lang = $_COOKIE["lang"];
        } else {
            $lang = "cat";
        }
        
        $frmErrors = array();
        $pagaments = $this->pagamentModel->read();
        $opcions = ["CONFIRMAT", "PENDENT", "WEB"];
        if ($params !== null) {
            $this->pagament = $this->pagamentModel->getById(intval($params[0]));
        }
        
        if ($_SERVER["REQUEST_METHOD"] == "POST" && (isset($_POST["enviar"]))) {
            $frmBanc = $this->sanitize($_POST["banc"]);
            $frmRefExterna = $this->sanitize($_POST["ref_externa"], 2);
            $frmData = $this->sanitize($_POST["pData"]);
            $frmEstat = $this->sanitize($_POST["estat"], 2);
            
            if (strlen($frmBanc) == 0) {
                $frmErrors["banc1"] = "Has d'incluir un banc.";
                $frmBanc = "";
            }else if (strlen($frmBanc) > 90){
                $frmErrors["banc2"] = "Tamany d'entrada excedit.";
                $frmBanc = "";
            }else if (!ctype_digit($frmBanc)) {
                $frmErrors["banc3"] = "Han de ser números.";
                $frmBanc = "";
            }
            if (strlen($frmRefExterna) == 0) {
                $frmErrors["ref_externa1"] = "Has d'incluir una referència externa.";
                $frmRefExterna = "";
            }else if (strlen($frmRefExterna) > 90){
                $frmErrors["ref_externa2"] = "Tamany d'entrada excedit.";
                $frmRefExterna = "";
            }
            if (strlen($frmData) == 0) {
                $frmErrors["data1"] = "Has d'incloure una data.";
                $frmData = "";
            }else if ($this->verificarData($frmData, "/", 0) == false) {
                $frmErrors["data2"] = "Data invàlida.";
                $frmData = "";
            }
            if (strlen($frmEstat) == 0) {
                $frmErrors["estat1"] = "Has d'incloure un estat.";
                $frmEstat = "";
            }else if (strlen($frmEstat) > 90) {
                $frmErrors["estat2"] = "Tamany d'entrada excedit.";
                $frmEstat = "";
            }else if (!in_array($frmEstat, $opcions)) {
                $frmErrors["estat3"] = "Estat invàlid.";
                $frmEstat = "";
            }
            
            if ($params) {
                if (empty($frmErrors)) {
                    $this->pagament->banc = $frmBanc;
                    $this->pagament->ref_externa = $frmRefExterna;
                    $this->pagament->data = $frmData;
                    $this->pagament->estat = $frmEstat;
                    $this->pagamentModel->update($this->pagament);
                    header("Location: index.php?Pagament/show");
                    exit();
                }
            }else {
                $this->pagament = new Pagament(null, $frmBanc, $frmRefExterna, $frmData, $frmEstat);
                if (empty($frmErrors)){
                    $this->pagamentModel->create($this->pagament);
                    $this->pagament = null;
                    header("Location: index.php?Pagament/show");
                    exit();
                }
            }
        }
        
        if ($_SERVER["REQUEST_METHOD"] == "POST" && (isset($_POST["cancelar"]))) {
            $this->pagament = null;
            header("Location: index.php?Pagament/show");
            exit();
        }
        
        $this->pagamentView->show($lang, $pagaments, $frmErrors, $this->pagament);
    }
    
    public function delete($params) {
        $pagamentGetById = $this->pagamentModel->getById(intval($params[0]));
        $this->pagamentModel->delete($pagamentGetById);
        header("Location: index.php?Pagament/show");
        exit();
    }
}

