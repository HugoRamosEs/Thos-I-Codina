<?php
namespace controller;

use SimpleXMLElement;
use model\Entrada;
use Mpdf\Mpdf;

class EntradaController extends Controller {
    public $entityManager;
    
    public function __construct($entityManager) {
        $this->entityManager = $entityManager;
    }
    
    public function show() {
        $mpdf = new Mpdf();
        $mpdf->Output();
    }

    public function pdfGenerator($value) {
        $entrada = $this->entityManager->getRepository(Entrada::class)->findOneBy(["id" => $value]);

        if ($entrada) {
            $mpdf = new Mpdf();
            $mpdf->SetWatermarkText("Hugo Ramos");
            $mpdf->watermark_font = "Helvetica";
            $mpdf->watermarkTextAlpha = 0.3;
            $mpdf->showWatermarkText = true;
            $mpdf->SetProtection(array("copy", "print"), "thosicodina", "2024@Thos");
            
            $img = $entrada->getEvent()->getImatge();
            if (strpos($img, 'img/') !== false) {
                $img = str_replace('img/', '', $img);
            }
            
            ob_start();
            include __DIR__ . '/../templates/entrada.tpl.php';
            $html = ob_get_clean();

            $mpdf->WriteHTML($html);
            $mpdf->Output();
        } else {
            $mpdf = new Mpdf();
            $mpdf->Output();
        }
    }
    
    public function xmlGenerator($value) {
        $entrades = $this->entityManager->getRepository(Entrada::class)->findByDate($value);

        if ($entrades) {
            $xml = new SimpleXMLElement("<entrades></entrades>");
            foreach ($entrades as $entrada) {
                $e = $xml->addChild("entrada");
                $e->addChild("id", $entrada->getId());
                $e->addChild("fila", $entrada->getFila());
                $e->addChild("butaca", $entrada->getButaca());
                $e->addChild("comprador", $entrada->getCompardor());
                $ev = $e->addChild("event");
                $ev->addChild("id", $entrada->getEvent()->getId());
                $ev->addChild("titol", $entrada->getEvent()->getTitol());
                $ev->addChild("subtitol", $entrada->getEvent()->getSubtitol());
                $ev->addChild("imatge", $entrada->getEvent()->getImatge());
                $d = $e->addChild("data");
                $d->addChild("id", $entrada->getData()->getId());
                $d->addChild("data", $entrada->getData()->getData());
                $d->addChild("hora", $entrada->getData()->getHora());
                $l = $e->addChild("localitzacio");
                $l->addChild("id", $entrada->getLocalitzacio()->getId());
                $l->addChild("lloc", $entrada->getLocalitzacio()->getLloc());
                $l->addChild("adreca", $entrada->getLocalitzacio()->getAdreca());
                $l->addChild("localitat", $entrada->getLocalitzacio()->getLocalitat());
                $z = $e->addChild("zona");
                $z->addChild("id", $entrada->getZona()->getId());
                $z->addChild("descripcio", $entrada->getZona()->getDescripcio());
                $p = $e->addChild("pagament");
                $p->addChild("id", $entrada->getPagament()->getId());
                $p->addChild("banc",  $entrada->getPagament()->getBanc());
                $p->addChild("referencia_externa", $entrada->getPagament()->getReferenciaExterna());
                $p->addChild("data", $entrada->getPagament()->getData());
                $p->addChild("estat", $entrada->getPagament()->getEstat());
            }
            
            header('Content-type: text/xml');
            echo $xml->asXML("entrades.xml");
        }
    }
}
