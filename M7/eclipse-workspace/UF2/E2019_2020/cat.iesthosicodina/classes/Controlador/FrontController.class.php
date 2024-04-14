<?php

class FrontController extends Controller {
    const DEFAULT_CONTROLLER = "HomeController";
    const DEFAULT_ACTION = "show";
    
    public function dispatch(){
        $params = null;
        if ($_SERVER["REQUEST_METHOD"] == "GET" && count($_GET) == 0) {
            $controller_name = self::DEFAULT_CONTROLLER;
            $action = self::DEFAULT_ACTION;
        }else {
            $url = array_keys($_GET)[0];
            $url = $this->sanitize($url,0);
            $url = trim($url,"/");
            $url = filter_var($url,FILTER_SANITIZE_URL);
            $url = explode("/", $url);
            if (isset($url[0])) {
                $controller_name = ucwords($url[0])."Controller";
                if (isset($url[1])) {
                    $action = $url[1];
                }
                if (count($url) > 2) {
                    for ($i=2; $i<count($url); $i++) {
                        $params[] = strtolower($url[$i]);
                    }
                }
            }
        }
        
        if (file_exists("classes/Controlador/".$controller_name.".class.php")) {
            $controller = new $controller_name();
            if (method_exists($controller,$action)) {
                $controller->$action($params);
            } else {
                throw new MyWebPageException("No existeix l'acció $action a $controller_name", 1002);
            }
        } else {
            throw new MyWebPageException("No existeix el controlador $controller_name", 1003);
        }
    }
}

