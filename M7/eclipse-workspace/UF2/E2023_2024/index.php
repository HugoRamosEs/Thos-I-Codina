<?php
error_reporting(E_ALL);
ini_set("display_errors", 1);
// include 'classes/Model/class.EventModel.php';
// include 'classes/Controlador/Controller.php';
// include 'classes/Controlador/class.EventController.php';
// include 'classes/Controlador/class.FrontController.php';
// include 'classes/Controlador/class.HomeController.php';
// include 'classes/ObjectesDeNegoci/class.Event.php';
// include 'classes/Vista/class.EventsView.php';

spl_autoload_register(function ($className) {
    $carpetes = [
        "Model",
        "Vista",
        "Controlador",
        "ObjectesDeNegoci"
    ];

    foreach ($carpetes as $carpeta) {
        $file = "classes/$carpeta/class." . $className . ".php";
        if (file_exists($file)) {
            include $file;
            return;
        }
    }
});

spl_autoload_register(function ($className) {
    $carpetes = [
        "Model",
        "Vista",
        "Controlador",
        "ObjectesDeNegoci"
    ];

    foreach ($carpetes as $carpeta) {
        $file = "classes/$carpeta/$className.php";
        if (file_exists($file)) {
            include $file;
            return;
        }
    }
    throw new Exception("No se pudo cargar la clase: $className");
});

EventsView::show(EventModel::read());
