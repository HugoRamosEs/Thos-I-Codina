<?php
session_start();
include 'funcions.php';
include 'productes.php';
//include 'Carro.php';

date_default_timezone_set("Europe/Madrid");
// Iniciamos la clase de la carta
//include 'Carro.php';
$cart = carregaDeDades();

if(isset($_REQUEST['action']) && !empty($_REQUEST['action'])){
    if($_REQUEST['action'] == 'addToCart' && isset($_REQUEST['id'])){
        $productID = $_REQUEST['id'];
        
        $itemData = array(
            'id' => $productes[$productID]['id'],
            'name' => $productes[$productID]['name'],
            'price' => $productes[$productID]['price'],
            'qty' => 1
        );
         
        $insertItem = insert($cart, $itemData);
        $redirectLoc = ($insertItem)?'veureCarro.php':'index.php';
        header("Location: ".$redirectLoc);
    }elseif($_REQUEST['action'] == 'updateCartItem' && !empty($_REQUEST['id'])){
        $itemData = array(
            'rowid' => $_REQUEST['id'],
            'qty' => $_REQUEST['qty']
        );
        $updateItem = update($cart, $itemData);
        echo $updateItem?'ok':'err';die;
    }elseif($_REQUEST['action'] == 'removeCartItem' && !empty($_REQUEST['id'])){
        $deleteItem = remove($cart, $_REQUEST['id']);
        header("Location: veureCarro.php");
    }elseif($_REQUEST['action'] == 'placeOrder' && $cart['total_items'] > 0 && !empty($_SESSION['sessCustomerID'])){
        // insert order details into database
        
        $cart_contents = array('cart_total' => 0, 'total_items' => 0);
        unset($_SESSION['cart_contents']);
        header("Location: exit.php?id=123456789");
     }else{
        header("Location: index.php");
    }
}else{
    header("Location: index.php");
}