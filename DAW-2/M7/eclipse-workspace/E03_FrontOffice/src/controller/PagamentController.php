<?php
namespace controller;

use model\Pagament;

class PagamentController extends Controller {
    
    public function __construct() {
        parent::__construct();
    }
    
    public function get($data) {
        if (isset($data["id"]) && trim($data["id"]) !== "") {
            $data["id"] = $this->sanitize($data["id"]);
            $pagament = $this->entityManager->getRepository(Pagament::class)->findOneBy(["id" => $data["id"]]);
            if ($pagament === null) {
                http_response_code(404);
                return ["error" => "Pagament not found"];
            } else {
                return $this->parseResult($pagament);
            }
        }
        
        $pagaments = $this->entityManager->getRepository(Pagament::class)->findAll();
        return $this->parseResult($pagaments);
    }
}
