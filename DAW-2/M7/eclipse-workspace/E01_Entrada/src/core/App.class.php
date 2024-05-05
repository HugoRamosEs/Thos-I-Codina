<?php

namespace core;

use controller\Controller;
use controller\EntradaController;
use DateTime;

class App extends Controller {
    
	public function dispatch($entityManager) {
	    $controller = new EntradaController($entityManager);
	    
	    if ($_SERVER["REQUEST_METHOD"] == "GET" && isset($_GET["value"])) {
	        $value = $this->sanitize($_GET["value"]);
	        $value = filter_var($value, FILTER_SANITIZE_URL);
	        
	        $date = DateTime::createFromFormat("d/m/Y", $value);
	        if ($date !== false) {
	            $value = $date->format("d/m/Y");
	            $controller->xmlGenerator($value);
	        } else {
	            $controller->pdfGenerator($value);
	        }
	    } else {
	        $controller->show();
	    }
	}
}

?>