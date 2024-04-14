<?php
// error_reporting(E_ALL);
// ini_set("display_errors", 1);
session_set_cookie_params(0);
session_start();

include 'classes/config/Autoloader.php';
spl_autoload_register("Autoloader::load");

try {
    $cFront = new FrontController();
    $cFront->dispatch();
} catch (Exception $e) {
    $vError = new ErrorView();
    $vError->show($e);
}
