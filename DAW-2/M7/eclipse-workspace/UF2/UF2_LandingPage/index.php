<?php
//     error_reporting(E_ALL);
//     ini_set('display_errors', 1);
    session_start();
    include "classes/config/autoloader.class.php";
    spl_autoload_register("Autoloader::load");
    spl_autoload_register("Autoloader::newLoad");
    
    try {
        $cFront = new FrontController();
        $cFront->dispatch();
    }catch (Exception $e) {
        $vError = new ErrorView();
        $vError->show($e);
    }
?>