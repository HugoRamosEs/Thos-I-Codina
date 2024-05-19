<?php
namespace controller;

use Exception;

class AppController extends Controller {
    const DEFAULT_CONTROLLER = "HomeController";
    const DEFAULT_ACTION = "show";

    public function run() {
        $params = null;

        if ($_SERVER["REQUEST_METHOD"] == "GET" && count($_GET) == 0) {
            $controllerName = self::DEFAULT_CONTROLLER;
            $action = self::DEFAULT_ACTION;
        } else {
            $url = array_keys($_GET)[0];
            $url = $this->sanitize($url, 0);
            $url = trim($url, "/");
            $url = filter_var($url, FILTER_SANITIZE_URL);
            $url = explode("/", $url);
            if (isset($url[0])) {
                $controllerName = ucwords($url[0]) . "Controller";
                if (isset($url[1])) {
                    $action = $url[1];
                }
                if (count($url) > 2) {
                    for ($i = 2; $i < count($url); $i ++) {
                        $params[] = strtolower($url[$i]);
                    }
                }
            }  
        }
        
        $controllerFile = __DIR__ . "/{$controllerName}.php";
        if (file_exists($controllerFile)) {
            $controllerClass = "controller\\".$controllerName;
            $controller = new $controllerClass();
            if (method_exists($controller, $action)) {
                $controller->$action($params);
            } else {
                throw new Exception("L'acció {$action} no existeix en el controlador {$controllerName}.");
            }
        } else {
            throw new Exception("No existeix el controlador {$controllerName}.");
        }
    }
}
