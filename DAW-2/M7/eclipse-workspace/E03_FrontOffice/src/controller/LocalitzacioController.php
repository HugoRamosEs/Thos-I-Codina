<?php
namespace controller;

use model\Localitzacio;

class LocalitzacioController extends Controller {
    
    public function __contruct() {
        parent::__construct();
    }
    
    public function get($data) {
        if (isset($data["id"]) && trim($data["id"]) !== "") {
            $data["id"] = $this->sanitize($data["id"]);
            $localitzacio = $this->entityManager->getRepository(Localitzacio::class)->findOneBy(["id" => $data["id"]]);
            if ($localitzacio === null) {
                http_response_code(404);
                return ["error" => "Localitzacio not found"];
            } else {
                return $this->parseResult($localitzacio);
            }
        }
        
        $localitzacions = $this->entityManager->getRepository(Localitzacio::class)->findAll();
        return $this->parseResult($localitzacions);
    }
}
