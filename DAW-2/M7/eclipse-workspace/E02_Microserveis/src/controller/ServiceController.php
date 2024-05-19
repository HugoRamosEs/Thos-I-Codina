<?php
namespace controller;

header("Content-Type: application/json");

class ServiceController extends Controller {
    
    public function dispatch() {
        $response = "";
        $types = ["Entrada", "Event", "Localitzacio", "Zona", "Data", "Pagament"];
        
        $data = json_decode(file_get_contents("php://input"), true);
        
        if (json_last_error() != JSON_ERROR_NONE) {
            http_response_code(400);
            $response = json_encode(["error" => "Invalid JSON"]);
        } else if (!isset($data["type"])) {
            http_response_code(400);
            $response = json_encode(["error" => "type required and cannot be null"]);
        } else if (!in_array(ucfirst($data["type"]), $types)) {
            http_response_code(400);
            $response = json_encode(["error" => "type not found"]);
        } else if (trim($data["type"]) === "") {
            http_response_code(400);
            $response = json_encode(["error" => "type cannot be empty"]);
        } else {
            $type = $this->sanitize($data["type"]);            
            
            switch (strtolower($_SERVER["REQUEST_METHOD"])) {
                case "get":
                    $response = $this->handleGet($type, $data);
                    break;
                case "post":
                    $response = $this->handlePost($type, $data);
                    break;
                case "put":
                    $response = $this->handlePut($type, $data);
                    break;
                case "delete":
                    $response = $this->handleDelete($type, $data);
                    break;
                default:
                    http_response_code(405);
                    $response = json_encode(["error" => "method not allowed"]);
                    break;
            }
        }
        
        echo $response;
    }
    
    public function handleGet($type, $data) {
        $controllerName = ucwords($type) . "Controller";
        $controllerClass = "controller\\" . $controllerName;
        $controller = new $controllerClass();
        if (!method_exists($controller, "get")) {
            http_response_code(405);
            return json_encode(["error" => "method get not allowed for this type"]);
        }
        $result = $controller->get($data);
        $jsonResult = json_encode($result, JSON_PRETTY_PRINT);
        return $jsonResult;
    }
    
    public function handlePost($type, $data) {
        $controllerName = ucwords($type) . "Controller";
        $controllerClass = "controller\\" . $controllerName;
        $controller = new $controllerClass();
        if (!method_exists($controller, "post")) {
            http_response_code(405);
            return json_encode(["error" => "method post not allowed for this type"]);
        }
        $result = $controller->post($data);
        $jsonResult = json_encode($result, JSON_PRETTY_PRINT);
        return $jsonResult;
    }
    
    public function handlePut($type, $data) {
        $controllerName = ucwords($type) . "Controller";
        $controllerClass = "controller\\" . $controllerName;
        $controller = new $controllerClass();
        if (!method_exists($controller, "put")) {
            http_response_code(405);
            return json_encode(["error" => "method put not allowed for this type"]);
        }
        $result = $controller->put($data);
        $jsonResult = json_encode($result, JSON_PRETTY_PRINT);
        return $jsonResult;
    }
    
    public function handleDelete($type, $data) {
        $controllerName = ucwords($type) . "Controller";
        $controllerClass = "controller\\" . $controllerName;
        $controller = new $controllerClass();
        if (!method_exists($controller, "delete")) {
            http_response_code(405);
            return json_encode(["error" => "method delete not allowed for this type"]);
        }
        $result = $controller->delete($data);
        $jsonResult = json_encode($result, JSON_PRETTY_PRINT);
        return $jsonResult;
    }
}
