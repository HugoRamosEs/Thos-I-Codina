<?php
namespace view;

class HomeView {
    
    public static function show() {
        include __DIR__ . "/../template/head.tpl.php";
        include __DIR__ . "/../template/header.tpl.php";
        include __DIR__ . "/../template/main-index.tpl.php";
        include __DIR__ . "/../template/footer.tpl.php";
    }
}
