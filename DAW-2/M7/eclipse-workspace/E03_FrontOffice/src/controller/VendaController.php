<?php
namespace controller;

use view\VendaView;
use Mpdf\Mpdf;
use model\Entrada;


class VendaController extends Controller {
    
    public function __construct() {
        parent::__construct();
    }
    
    public function form($params = null) {
        $data = array();
        $frmErrors = array();
        $url = "?Venda/form/";
        
        if ($_SERVER["REQUEST_METHOD"] == "POST") {
            $event_id = isset($_POST["esdeveniment_id"]) ? $_POST["esdeveniment_id"] : (isset($params[0]) ? $params[0] : null);
            $localitzacio_id = isset($_POST["localitzacio_id"]) ? $_POST["localitzacio_id"] : (isset($params[1]) ? $params[1] : null);
            $data_id = isset($_POST["data_id"]) ? $_POST["data_id"] : (isset($params[2]) ? $params[2] : null);
            $zona_id = isset($_POST["zona_id"]) ? $_POST["zona_id"] : (isset($params[3]) ? $params[3] : null);
            $fila = isset($_POST["fila"]) ? $_POST["fila"] : (isset($params[4]) ? $params[4] : null);
            $butaca = isset($_POST["butaca"]) ? $_POST["butaca"] : (isset($params[5]) ? $params[5] : null);
            $dni = isset($_POST["dni"]) ? $_POST["dni"] : (isset($params[6]) ? $params[6] : null);
            
            if (isset($_POST["fila"]) && trim($_POST["fila"]) === "") {
                $frmErrors["fila1"] = "Has d'introduir una fila.";
            } else if (isset($_POST["fila"]) && !ctype_digit($_POST["fila"])) {
                $frmErrors["fila2"] = "Has d'introduir un número.";
            } else if ($_POST["fila"] < 0 || $_POST["fila"] > 150) {
                $frmErrors["fila3"] = "Has d'introduir un número entre 0 i 150.";
            }
            
            if (isset($_POST["butaca"]) && trim($_POST["butaca"]) === "") {
                $frmErrors["butaca1"] = "Has d'insertar una butaca.";
            } else if (isset($_POST["butaca"]) && ! ctype_digit($_POST["butaca"])) {
                $frmErrors["butaca2"] = "Has d'introduir un número.";
            } else if ($_POST["butaca"] < 0 || $_POST["butaca"] > 50) {
                $frmErrors["butaca3"] = "Has d'introduir un número entre 0 i 50.";
            }
            
            if (isset($_POST["targeta"]) && trim($_POST["targeta"]) === "") {
                $frmErrors["targeta1"] = "Has d'introduir una targeta.";
            }
            
            if (isset($_POST["dni"]) && trim($_POST["dni"]) === "") {
                $frmErrors["dni1"] = "Has d'introduir un DNI.";
            } else if (isset($_POST["dni"]) && !$this->verifyDni($_POST["dni"])) {
                $frmErrors["dni2"] = "El format del DNI es incorrecte.";
            }
            
            if (empty($frmErrors)) {
                if ($event_id) {
                    $url .= $event_id;
                }
                if ($localitzacio_id) {
                    $url .= "/$localitzacio_id";
                }
                if ($data_id) {
                    $url .= "/$data_id";
                }
                if ($zona_id) {
                    $url .= "/$zona_id";
                }
                if ($fila) {
                    $url .= "/$fila";
                }
                if ($butaca) {
                    $url .= "/$butaca";
                }
                if ($dni) {
                    $url .= "/$dni";
                }
                
                header("Location: $url");
                exit();
            }
        }
        
        if ($params === null) {
            $data["type"] = "Event";
            $events = $this->fetch($data, "get", "Event");
            VendaView::events($events);
        } else if (count($params) === 1) {
            $data["type"] = "Event";
            $data["id"] = $this->sanitize($params[0]);
            $event = $this->fetch($data, "get", "Event");
            unset($data["id"]);
            $data["type"] = "Localitzacio";
            $localitzacions = $this->fetch($data, "get", "Localitzacio");
            VendaView::localitzacions($localitzacions, $event, $frmErrors);
        } else if (count($params) === 2) {
            $data["type"] = "Data";
            $dates = $this->fetch($data, "get", "Data");
            VendaView::dates($dates, $frmErrors);
        } else if (count($params) === 3) {
            $data["type"] = "Zona";
            $zones = $this->fetch($data, "get", "Zona");
            VendaView::zones($zones, $frmErrors);
        } else if (count($params) === 6) {
            $data["type"] = "Pagament";
            VendaView::pagament($frmErrors);
        } else if (count($params) === 7) {
            $data["type"] = "Entrada";
            $data["id"] = $this->generateEntradaId();
            $data["esdeveniment_id"] = $this->sanitize($params[0]);
            $data["localitzacio_id"] = $this->sanitize($params[1]);
            $data["data_id"] = $this->sanitize($params[2]);
            $data["zona_id"] = $this->sanitize($params[3]);
            $data["fila"] = $this->sanitize($params[4]);
            $data["butaca"] = $this->sanitize($params[5]);
            $data["dni"] = $this->sanitize($params[6], 2);
            
            $pagament = $this->generatePagament();
            $responsePagament = $this->fetch($pagament, "post", "Pagament");
            
            if (isset($responsePagament["OK"])) {
                $pagament_id = $responsePagament["id"];
                if ($pagament_id) {
                    $data["pagamanet_id"] = $pagament_id;
                    $responseEntrada = $this->fetch($data, "post", "Entrada");
                    $entrada_id = $responseEntrada["id"];
                    if (isset($responseEntrada["OK"]) && $entrada_id !== null) {
                        VendaView::entrada($entrada_id);
                    } else {
                        VendaView::entrada("", $responseEntrada);
                    }
                }
            } 
        }
    }
    
    public function generatePdf($params) {
        if ((isset($_SESSION["login"]) && $_SESSION["login"] === false) || !isset($_SESSION["login"])) {
            header("Location: ?User/login");
            exit();
        }
        
        $entrada = $this->entityManager->getRepository(Entrada::class)->findOneBy(["id" => $params[0]]);

        if ($entrada) {
            $mpdf = new Mpdf();
            $mpdf->SetWatermarkText("TicketTune");
            $mpdf->watermark_font = "Helvetica";
            $mpdf->watermarkTextAlpha = 0.3;
            $mpdf->showWatermarkText = true;
            
            $qrCode = "http://" . $_SERVER["SERVER_NAME"] . ":" . $_SERVER["SERVER_PORT"] . $_SERVER["REQUEST_URI"];
            
            $img = $entrada->getEvent()->getImatge();
            if (strpos($img, "img/") !== false) {
                $img = str_replace("img/", "", $img);
            }
            
            ob_start();
            include __DIR__ . "/../template/entrada.tpl.php";
            $html = ob_get_clean();
            
            $mpdf->WriteHTML($html);
            $mpdf->Output();
        } else {
            $mpdf = new Mpdf();
            $mpdf->Output();
        }
    }
    
    private function fetch($data, $method, $type) {
//         $url = "http://localhost/E03_FrontOffice/src/service.php";
        $url = "http://" . $_SERVER["SERVER_NAME"] . ":" . $_SERVER["SERVER_PORT"] . dirname($_SERVER["SCRIPT_NAME"]) . "/service.php";

        $ch = curl_init();
        curl_setopt($ch, CURLOPT_URL, $url);
        curl_setopt($ch, CURLOPT_CUSTOMREQUEST, $method);
        curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($data));
        curl_setopt($ch, CURLOPT_HTTPHEADER, array("Content-Type: application/json"));
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        
        $response = curl_exec($ch);
        curl_close($ch);
        $parsed_response = $this->parseResponse($response, $type);
        
        return $parsed_response;
    }
    
    private function generateEntradaId() {
        $id = "";
        $characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for ($i = 0; $i < 14; $i ++) {
            $id .= $characters[rand(0, strlen($characters) - 1)];
        }

        return $id;
    }
    
    private function generatePagament() {
        $pagament = array();
        $pagament["type"] = "Pagament";
        $pagament["banc"] = "CAIXA BANC";
        
        $prefix = "0078 BPD ";
        $nums = "";
        for ($i=0; $i<9; $i++) {
            $nums .= rand(0,9);
        }

        $pagament["ref_externa"] = $prefix . $nums;
        $pagament["data"] = date("d/m/Y");
        $pagament["estat"] = "CONFIRMAT";
        
        return $pagament;
    }
}
