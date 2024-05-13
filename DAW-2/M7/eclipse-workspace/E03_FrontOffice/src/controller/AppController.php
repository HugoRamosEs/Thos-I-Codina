<?php
namespace controller;

use Exception;

class AppController extends Controller {
    const DEFAULT_CONTROLLER = "HomeController";
    const DEFAULT_ACTION = "show";

    public function run() {
        $controllerName = self::DEFAULT_CONTROLLER;
        $actionName = self::DEFAULT_ACTION;
        $params = [];

        if ($_SERVER["REQUEST_METHOD"] == "GET") {
            if (count($_GET) > 0) {
                $url = array_keys($_GET)[0];
                $url = $this->sanitize($url, 0);
                $url = trim($url, "/");
                $url = filter_var($url, FILTER_SANITIZE_URL);
                $url = explode("/", $url);

                if (isset($url[0])) {
                    $controllerName = ucwords($url[0]) . "Controller";
                }
                if (isset($url[1])) {
                    $actionName = $url[1];
                }
                if (count($url) > 2) {
                    $params = array_slice($url, 2);
                }
            }
        }

        $controllerFile = __DIR__ . "/{$controllerName}.php";
        if (! file_exists($controllerFile)) {
            throw new Exception("No existeix el controlador {$controllerName}");
        }

        $controllerClass = "controller\\" . $controllerName;
        if (! class_exists($controllerClass)) {
            throw new Exception("No s'ha trobat la classe del controlador per a {$controllerName}.");
        }

        $controller = new $controllerClass();
        if (! is_callable([$controller, $actionName])) {
            throw new Exception("L'acció {$actionName} no es pot invocar en el controlador {$controllerName}.");
        }

        call_user_func_array([$controller, $actionName], $params);
    }
}
