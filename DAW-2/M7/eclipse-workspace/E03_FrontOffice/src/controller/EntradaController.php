<?php
namespace controller;

use model\Entrada;
use model\Event;
use model\Data;
use model\Localitzacio;
use model\Zona;
use model\Pagament;

class EntradaController extends Controller {
    
    public function __construct() {
        parent::__construct();
    }
    
    public function get($data) {
        if (isset($data["id"]) && trim($data["id"]) !== "") {
            $data["id"] = $this->sanitize($data["id"]);
            $entrada = $this->entityManager->getRepository(Entrada::class)->findOneBy(["id" => $data["id"]]);
            if ($entrada === null) {
                http_response_code(404);
                return ["error" => "Entrada not found"];
            } else {
                return $this->parseResult($entrada);
            }
        }
        
        $entrades = $this->entityManager->getRepository(Entrada::class)->findAll();
        return $this->parseResult($entrades);
    }
    
    public function post($data) {
        $errors_400 = array();
        $data_fields = ["id", "esdeveniment_id", "data_id", "localitzacio_id", "zona_id", "pagamanet_id", "fila", "butaca", "dni"];
        $errors_404 = array();
        $entities = array();
        $data_sanitized = array();
        
        foreach ($data_fields as $field) {
            if (!isset($data[$field])) {
                $errors_400[$field] = $field . " required";
            } else if (trim($data[$field]) === "") {
                $errors_400[$field] = $field . " cannot be empty";
            } else {
                $data_sanitized[$field] = $this->sanitize($data[$field]);
            }
        }
        
        if (isset($data_sanitized["fila"])) {
            if (!ctype_digit($data_sanitized["fila"])) {
                $errors_400["fila"] = "fila must be a number";
            } else if ($data_sanitized["fila"] < 0 || $data_sanitized["fila"] > 150) {
                $errors_400["fila"] = "fila must be between 0 and 150";
            }
        }
        if (isset($data_sanitized["butaca"])) {
            if (!ctype_digit($data_sanitized["butaca"])) {
                $errors_400["butaca"] = "butaca must be a number";
            } else if ($data_sanitized["butaca"] < 0 || $data_sanitized["butaca"] > 50) {
                $errors_400["butaca"] = "butaca must be between 0 and 50";
            }
        }
        if (isset($data_sanitized["dni"]) && !$this->verifyDni($data_sanitized["dni"])) {
            $errors_400["dni"] = "invalid dni";
        }
        
        if (isset($data_sanitized["id"])) {
            $entities["entrada"] = $this->entityManager->getRepository(Entrada::class)->findOneBy(["id" => $data_sanitized["id"]]);
            if ($entities["entrada"] !== null) {
                http_response_code(400);
                return ["error" => "Entrada already exists"];
            }
        }
        
        if (!empty($errors_400)) {
            http_response_code(400);
            return ["errors" => $errors_400];
        }
        
        $entities["event"] = $this->entityManager->getRepository(Event::class)->findOneBy(["id" => $data_sanitized["esdeveniment_id"]]);
        $entities["data"] = $this->entityManager->getRepository(Data::class)->findOneBy(["id" => $data_sanitized["data_id"]]);
        $entities["localitzacio"] = $this->entityManager->getRepository(Localitzacio::class)->findOneBy(["id" => $data_sanitized["localitzacio_id"]]);
        $entities["zona"] = $this->entityManager->getRepository(Zona::class)->findOneBy(["id" => $data_sanitized["zona_id"]]);
        $entities["pagament"] = $this->entityManager->getRepository(Pagament::class)->findOneBy(["id" => $data_sanitized["pagamanet_id"]]);
        
        foreach ($entities as $key => $entity) {
            if ($entity === null) {
                if ($key !== "entrada") {
                    $errors_404[$key] = $key . " not found";
                }
            }
        }
        
        if (!empty($errors_404)) {
            http_response_code(404);
            return ["errors" => $errors_404];
        }
        
        $entrada = new Entrada();
        $entrada->setId($data_sanitized["id"]);
        $entrada->setEvent($entities["event"]);
        $entrada->setData($entities["data"]);
        $entrada->setLocalitzacio($entities["localitzacio"]);
        $entrada->setZona($entities["zona"]);
        $entrada->setPagament($entities["pagament"]);
        $entrada->setFila($data_sanitized["fila"]);
        $entrada->setButaca($data_sanitized["butaca"]);
        $entrada->setCompardor($data_sanitized["dni"]);
        
        $this->entityManager->persist($entrada);
        $this->entityManager->flush();
        
        $lastId = $entrada->getId();
        
        http_response_code(200);
        return ["OK" => "Entrada added successfully",
                "id" => $lastId];
    }
    
    public function put($data) {
        $errors_400 = array();
        $errors_404 = array();
        $entity_fields = ["esdeveniment_id", "data_id", "localitzacio_id", "zona_id", "pagamanet_id"];
        $data_sanitized = array();

        if (!isset($data["id"])) {
            http_response_code(400);
            return ["error" => "id required"];
        } else if (trim($data["id"]) === "") {
            http_response_code(400);
            return ["error" => "id cannot be empty"];
        }

        foreach ($data as $field => $value) {
            if (trim($value) === "") {
                $errors_400[$field] = $field . " cannot be empty";
            } else {
                $data_sanitized[$field] = $this->sanitize($value);
            }
        }

        if (isset($data_sanitized["fila"])) {
            if (!ctype_digit($data_sanitized["fila"])) {
                $errors_400["fila"] = "fila must be a number";
            } else if ($data_sanitized["fila"] < 0 || $data_sanitized["fila"] > 150) {
                $errors_400["fila"] = "fila must be between 0 and 150";
            }
        }
        if (isset($data_sanitized["butaca"])) {
            if (!ctype_digit($data_sanitized["butaca"])) {
                $errors_400["butaca"] = "butaca must be a number";
            } else if ($data_sanitized["butaca"] < 0 || $data_sanitized["butaca"] > 50) {
                $errors_400["butaca"] = "butaca must be between 0 and 50";
            }
        }
        if (isset($data_sanitized["dni"]) && !$this->verifyDni($data_sanitized["dni"])) {
            $errors_400["dni"] = "invalid dni";
        }
        
        if (!empty($errors_400)) {
            http_response_code(400);
            return ["errors" => $errors_400];
        }
        
        $entrada = $this->entityManager->getRepository(Entrada::class)->findOneBy(["id" => $data_sanitized["id"]]);
        if ($entrada === null) {
            http_response_code(404);
            return ["error" => "Entrada not found"];
        }
        
        foreach ($data_sanitized as $field => $value) {
            if (in_array($field, $entity_fields) && isset($data_sanitized[$field])) {
                if ($field === "esdeveniment_id") {
                    $field = "event_id";
                } else if ($field === "pagamanet_id") {
                    $field = "pagament_id";
                }
                
                $entityClass = ucfirst(str_replace("_id", "", $field));

                switch ($entityClass) {
                    case "Event":
                        $entityClass = Event::class;
                        break;
                    case "Data":
                        $entityClass = Data::class;
                        break;
                    case "Localitzacio":
                        $entityClass = Localitzacio::class;
                        break;
                    case "Zona":
                        $entityClass = Zona::class;
                        break;
                    case "Pagament":
                        $entityClass = Pagament::class;
                        break;
                }
                
                $entity = $this->entityManager->getRepository($entityClass)->findOneBy(["id" => $value]);
                if ($entity === null) {
                    $errors_404[$field] = $field . " not found";
                } else {
                    $setter = "set" . ucfirst(str_replace("_id", "", $field));
                    if (method_exists($entrada, $setter)) {
                        $entrada->$setter($entity);
                    }
                }
            } else {
                if ($field === "dni") {
                    $field = "compardor";
                }

                $setter = "set" . ucfirst($field);
                if (method_exists($entrada, $setter)) {
                    $entrada->$setter($value);
                }
            }
        }
        
        if (!empty($errors_404)) {
            http_response_code(404);
            return ["errors" => $errors_404];
        }
        
        $this->entityManager->persist($entrada);
        $this->entityManager->flush();
        
        http_response_code(200);
        return ["OK" => "Entrada updated successfully"];
    }

    public function delete($data) {
        if (isset($data["id"]) && trim($data["id"]) !== "") {
            $data["id"] = $this->sanitize($data["id"]);
            $entrada = $this->entityManager->getRepository(Entrada::class)->findOneBy(["id" => $data["id"]]);
            if ($entrada === null) {
                http_response_code(404);
                return ["error" => "Entrada not found"];
            } else {
                $this->entityManager->remove($entrada);
                $this->entityManager->flush();
                http_response_code(200);
                return [
                    "OK" => "Entrada deleted successfully"
                ];
            }
        } else {
            http_response_code(400);
            return ["error" => "id required"];
        }
    }
}
