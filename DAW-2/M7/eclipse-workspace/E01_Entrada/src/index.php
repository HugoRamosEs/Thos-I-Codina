<?php

use core\App;

error_reporting(E_ALL);
ini_set("display_errors", 1);

require_once "bootstrap.php";
require_once "../config/ini-config.php";

try {
    $app = new App();
    $app->dispatch($entityManager);
} catch (Exception $e) {
    echo $e->getMessage();
}

?>
