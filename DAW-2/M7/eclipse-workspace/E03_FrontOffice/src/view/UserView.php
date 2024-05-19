<?php
namespace view;

class UserView {
    
    public static function login($user, $ok, $error, $frmErrors = null) {
        include __DIR__ . "/../template/head.tpl.php";
        include __DIR__ . "/../template/header.tpl.php";
        include __DIR__ . "/../template/main-login.tpl.php";
        include __DIR__ . "/../template/footer.tpl.php";
    }
    
    public static function signup($user, $frmPassword2, $error, $frmErrors = null) {
        include __DIR__ . "/../template/head.tpl.php";
        include __DIR__ . "/../template/header.tpl.php";
        include __DIR__ . "/../template/main-signup.tpl.php";
        include __DIR__ . "/../template/footer.tpl.php";
    }
    
    public static function modify($user, $ok, $error, $frmErrors = null) {
        include __DIR__ . "/../template/head.tpl.php";
        include __DIR__ . "/../template/header.tpl.php";
        include __DIR__ . "/../template/main-profile.tpl.php";
        include __DIR__ . "/../template/footer.tpl.php";
    }
}
