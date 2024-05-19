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
    
    /* No es requereix el camp id perquè s’autoincrementa per Doctrine. Encara que s’afegeixi un camp id, 
    Doctrine no ho tindrà en compte i continuarà amb l’id autoincremental. Per aquest motiu, tampoc es comprova
    si l’id ja existeix a la base de dades, perque no es pot repetir. */
    public function post($data) {
        $errors_400 = array();
        $data_fields = ["banc", "ref_externa", "data", "estat"];
        $estats = ["CONFIRMAT", "PENDENT", "WEB"];
        $data_sanitized = array();
        
        foreach ($data_fields as $field) {
            if (!isset($data[$field])) {
                $errors_400[$field] = $field . " required";
            } else if (trim($data[$field]) === "") {
                $errors_400[$field] = $field . " cannot be empty";
            } else {
                $data_sanitized[$field] = $this->sanitize($data[$field], 2);
            }
        }
        
        if (isset($data_sanitized["data"]) && ! $this->verifyData($data_sanitized["data"], "/", 0)) {
            $errors_400["data"] = "Invalid data. Format (dd/mm/yyyy)";
        }
        if (isset($data_sanitized["estat"]) && !in_array($data_sanitized["estat"], $estats)) {
            $errors_400["estat"] = "Invalid estat";
        }
        
        if (!empty($errors_400)) {
            http_response_code(400);
            return ["errors" => $errors_400];
        }
        
        $pagament = new Pagament();
        $pagament->setBanc($data_sanitized["banc"]);
        $pagament->setReferenciaExterna($data_sanitized["ref_externa"]);
        $pagament->setData($data_sanitized["data"]);
        $pagament->setEstat($data_sanitized["estat"]);
        
        $this->entityManager->persist($pagament);
        $this->entityManager->flush();

        $lastId = $pagament->getId();
        
        http_response_code(200);
        return ["OK" => "Pagament added successfully", 
                "id" => $lastId];
    }
}
