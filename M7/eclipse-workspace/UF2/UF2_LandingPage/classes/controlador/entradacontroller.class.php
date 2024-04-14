<?php

class EntradaController extends Controller {
    private $entrada;
    private $entradaModel;
    private $esdevenimentModel;
    private $localitzacioModel;
    private $zonaModel;
    private $pagamentModel;
    private $entradaView;
    
    public function __construct(Entrada $param = null){
        parent::__construct();
        $this->entrada = (is_null($param)) ? new Entrada("", "", "", "", "", "", "", "", "", "", "", "", "", "") : $param;
        $this->entradaModel = new EntradaModel();
        $this->esdevenimentModel = new EsdevenimentModel();
        $this->localitzacioModel = new LocalitzacioModel();
        $this->zonaModel = new ZonaModel();
        $this->pagamentModel = new PagamentModel();
        $this->entradaView = new EntradaView();
    }
    
    public function show($params){
        if (isset($_COOKIE["lang"])) {
            $lang = $_COOKIE["lang"];
        } else {
            $lang = "cat";
        }
        
        $frmErrors = array();
        $entrades = $this->entradaModel->read();
        $esdeveniments = $this->esdevenimentModel->read();
        $localitzacions = $this->localitzacioModel->read();
        $zones = $this->zonaModel->read();
        $pagaments = $this->pagamentModel->read();
        $dates = DataModel::read();
        if ($params !== null) {
            $this->entrada = $this->entradaModel->getById($params[0]);
        }
        
        if ($_SERVER["REQUEST_METHOD"] == "POST" && (isset($_POST["enviar"]))) {
            $frmEsdevenimentId = $this->sanitize($_POST["eEsdeveniments"]);
            $frmDataId = $this->sanitize($_POST["eDates"]);
            $frmLocId = $this->sanitize($_POST["eLocalitzacions"]);
            $frmZonaId = $this->sanitize($_POST["eZones"]);
            $frmPagamentId = $this->sanitize($_POST["ePagaments"]);
            $frmFila = $this->sanitize($_POST["fila"]);
            $frmButaca = $this->sanitize($_POST["butaca"]);
            $frmDni = $this->sanitize($_POST["eDni"]);

            if (strlen($frmFila) == 0) {
                $frmErrors["fila1"] = "Has d'incluir una fila.";
                $frmFila = "";
            }else if (!ctype_digit($frmFila)){
                $frmErrors["fila2"] = "Ha de ser un número.";
                $frmFila = "";
            }
            if (strlen($frmButaca) == 0) {
                $frmErrors["butaca1"] = "Has d'incluir una butaca.";
                $frmButaca = "";
            }else if (!ctype_digit($frmButaca)){
                $frmErrors["butaca2"] = "Ha de ser un número.";
                $frmButaca = "";
            }
            if (strlen($frmDni) == 0) {
                $frmErrors["dni1"] = "Has d'incluir un DNI.";
                $frmDni = "";
            }else if ($this->verificarNumeroIdent("Nif", $frmDni) == false){
                $frmErrors["dni2"] = "DNI invàlid.";
                $frmDni = "";
            }
            
            $frmEsdevenimentId = intval($frmEsdevenimentId);
            $frmDataId = intval($frmDataId);
            $frmLocId = intval($frmLocId);
            $frmZonaId = intval($frmZonaId);
            $frmPagamentId = intval($frmPagamentId);
            $frmFila = intval($frmFila);
            $frmButaca = intval($frmButaca);
            
            if ($params) {
                if (empty($frmErrors)) {
                    $this->entrada->esdeveniment_id = $frmEsdevenimentId;
                    $this->entrada->data_id = $frmDataId;
                    $this->entrada->loc_id = $frmLocId;
                    $this->entrada->zona_id = $frmZonaId;
                    $this->entrada->pagament_id = $frmPagamentId;
                    $this->entrada->fila = $frmFila;
                    $this->entrada->butaca = $frmButaca;
                    $this->entrada->dni = $frmDni;
                    $this->entradaModel->update($this->entrada);
                    header("Location: index.php?Entrada/show");
                    exit();
                }
            }else {
                $id = $this->generarEntradaId();
                
                $this->entrada = new Entrada($frmEsdevenimentId, $frmDataId, $frmLocId, $frmZonaId, $frmPagamentId, $id, $frmFila, $frmButaca, $frmDni);
                if (empty($frmErrors)){
                    $this->entradaModel->create($this->entrada);
                    $this->entrada = null;
                    header("Location: index.php?Entrada/show");
                    exit();
                }
            }
        }
        
        if ($_SERVER["REQUEST_METHOD"] == "POST" && (isset($_POST["cancelar"]))) {
            $this->entrada = null;
            header("Location: index.php?Entrada/show");
            exit();
        }

        $this->entradaView->show($lang, $entrades, $frmErrors, $esdeveniments, $dates, $localitzacions, $zones, $pagaments, $this->entrada);
    }

    public function delete($params) {
        $entradaGetById = $this->entradaModel->getById($params[0]);
        $this->entradaModel->delete($entradaGetById);
        header("Location: index.php?Entrada/show");
        exit();
    }
    
    private function generarEntradaId() {
        $nums = substr(str_shuffle(str_repeat('0123456789', 5)), 0, 5);
        $lletres = substr(str_shuffle(str_repeat('ABCDEFGHIJKLMNOPQRSTUVWXYZ', 4)), 0, 4);
        $numsLletres = substr(str_shuffle(str_repeat('0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ', 5)), 0, 5);
        $id = $nums . $lletres . $numsLletres;
        return $id;
    }
}

