<?php
namespace controller;

header("Content-Type: application/json");

class ServiceController extends Controller {
    
    public function dispatch() {
        $data = json_decode(file_get_contents("php://input"), true);
        
        if (json_last_error() != JSON_ERROR_NONE) {
            http_response_code(400);
            echo json_encode(["error" => "Invalid JSON"]);
            return;
        }
        
        if (!isset($data["type"])) {
            http_response_code(400);
            echo json_encode(["error" => "type required and cannot be null"]);
            return;
        } else if (trim($data["type"]) === "") {
            http_response_code(400);
            echo json_encode(["error" => "type cannot be empty"]);
            return;
        }
        
        $type = $this->sanitize($data["type"]);
        
        switch (strtolower($_SERVER["REQUEST_METHOD"])) {
            case "get":
                $this->handleGet($type, $data);
                break;
            case "post":
                $this->handlePost($type, $data);
                break;
            case "put":
                $this->handlePut($type, $data);
                break;
            case "delete":
                $this->handleDelete($type, $data);
                break;
            default:
                http_response_code(405);
                echo json_encode(["error" => "Method not allowed"]);
                break;
        }
    }
    
    public function handleGet($type, $data) {
        $controllerName = ucwords($type) . "Controller";
        $controllerClass = "controller\\" . $controllerName;
        $controller = new $controllerClass();
        if (!method_exists($controller, "get")) {
            http_response_code(405);
            echo json_encode(["error" => "Method get not allowed for this type"]);
            return;
        }
        $result = $controller->get($data);
        echo "<pre>" . json_encode($result, JSON_PRETTY_PRINT) . "</pre>";
    }
    
    public function handlePost($type, $data) {
        $controllerName = ucwords($type) . "Controller";
        $controllerClass = "controller\\" . $controllerName;
        $controller = new $controllerClass();
        if (!method_exists($controller, "post")) {
            http_response_code(405);
            echo json_encode(["error" => "Method post not allowed for this type"]);
            return;
        }
        $result = $controller->post($data);
        echo "<pre>" . json_encode($result, JSON_PRETTY_PRINT) . "</pre>";
    }
    
    public function handlePut($type, $data) {
        $controllerName = ucwords($type) . "Controller";
        $controllerClass = "controller\\" . $controllerName;
        $controller = new $controllerClass();
        if (!method_exists($controller, "put")) {
            http_response_code(405);
            echo json_encode(["error" => "Method put not allowed for this type"]);
            return;
        }
        $result = $controller->put($data);
        echo "<pre>" . json_encode($result, JSON_PRETTY_PRINT) . "</pre>";
    }
    
    public function handleDelete($type, $data) {
        $controllerName = ucwords($type) . "Controller";
        $controllerClass = "controller\\" . $controllerName;
        $controller = new $controllerClass();
        if (!method_exists($controller, "delete")) {
            http_response_code(405);
            echo json_encode(["error" => "Method delete not allowed for this type"]);
            return;
        }
        $result = $controller->delete($data);
        echo "<pre>" . json_encode($result, JSON_PRETTY_PRINT) . "</pre>";
    }
}
