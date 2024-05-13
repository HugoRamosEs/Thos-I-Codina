<?php
namespace controller;

use model\Zona;

class ZonaController extends Controller {
    
    public function __construct() {
        parent::__construct();
    }
    
    public function get($data) {
        if (isset($data["id"]) && trim($data["id"]) !== "") {
            $data["id"] = $this->sanitize($data["id"]);
            $zona = $this->entityManager->getRepository(Zona::class)->findOneBy(["id" => $data["id"]]);
            if ($zona === null) {
                http_response_code(404);
                return ["error" => "Zona not found"];
            } else {
                return $this->parseResult($zona);
            }
        }
        
        $zones = $this->entityManager->getRepository(Zona::class)->findAll();
        return $this->parseResult($zones);
    }
}
