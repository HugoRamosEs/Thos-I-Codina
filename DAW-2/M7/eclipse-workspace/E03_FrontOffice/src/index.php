<?php

use config\Autoload;
use controller\AppController;
use view\ErrorView;

error_reporting(E_ALL);
ini_set("display_errors", 1);

require "bootstrap.php";
require "../config/Autoload.php";
spl_autoload_register([Autoload::class, "load"]);

try {
    $app = new AppController();
    $app->run();
} catch (Exception $e) {
    ErrorView::show($e);
}
