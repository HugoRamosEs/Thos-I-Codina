<?php
namespace controller;

use model\Data;

class DataController extends Controller {
    
    public function __construct() {
        parent::__construct();
    }
    
    public function get($data) {
        if (isset($data["id"]) && trim($data["id"]) !== "") {
            $data["id"] = $this->sanitize($data["id"]);
            $dataE = $this->entityManager->getRepository(Data::class)->findOneBy(["id" => $data["id"]]);
            if ($dataE === null) {
                http_response_code(404);
                return ["error" => "Data not found"];
            } else {
                return $this->parseResult($dataE);
            }
        }
        
        $dates = $this->entityManager->getRepository(Data::class)->findAll();
        return $this->parseResult($dates);
    }
}
