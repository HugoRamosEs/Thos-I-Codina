<?php

use config\Autoload;
use controller\ServiceController;

error_reporting(E_ALL);
ini_set("display_errors", 1);

require "bootstrap.php";
require "../config/Autoload.php";
spl_autoload_register([Autoload::class, "load"]);

header("Content-Type: application/json");

try {
    $app = new ServiceController();
    $app->dispatch();
} catch (Exception $e) {
    http_response_code(500);
    echo json_encode(["error" => "Internal server error. Contact with the administrator"]);
}
