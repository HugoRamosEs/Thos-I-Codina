<?php
namespace view;

use Exception;

class ErrorView {
    
    public static function show(Exception $e) {
        $title = "Hi ha hagut un error!";
        $message = $e->getMessage();
        
        include __DIR__ . "/../template/head.tpl.php";
        include __DIR__ . "/../template/header.tpl.php";
        include __DIR__ . "/../template/main-error.tpl.php";
        include __DIR__ . "/../template/footer.tpl.php";
    }
}
