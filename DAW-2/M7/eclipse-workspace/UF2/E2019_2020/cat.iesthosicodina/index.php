<?php
error_reporting(E_ALL);
ini_set("display_errors", 1);

session_start();
include "classes/Nucli/Autoloader.php";
spl_autoload_register("Autoloader::load");
spl_autoload_register("Autoloader::newLoad");

/**
 * PREGUNTA 4   
 * PHP no permet fer herència multiple.
 * 
 * PREGUNTA 10
 * No es necesario sanitizar las variables del fichero de variablesDeConfiguracio.php, debido a que es un fichero local, y durante la lectura de este, no deberia interferir nada en el proceso. 
 * Por otro lado, se debe sanitizar todo lo que llega de internet, normalmente formularios.
 * Si quisiera meter el sanitize a variablesDeConfiguració, haria que heredara de Controller, ya que es quien cuenta con este fichero. O tambien se podria crear una instancia de Controller y llamar
 * al metodo con esa instancia.
 */

try {
    $cFront = new FrontController();
    $cFront->dispatch();
}catch (MyWebPageException $e) {
    $vError = new ErrorView($e, $e->getCodi());
    $vError->show();
}

// $vista = new UserView();

// if (isset($_GET["pg"])) {
//     $_SESSION['paginaActual'] = Controller::sanitize($_GET["pg"],2);
// }

// if (!isset($_SESSION['paginaActual'])) {
//     $_SESSION['paginaActual'] = 1;
// }

// if (($_SERVER["REQUEST_METHOD"] == "GET") && (isset($_GET['lang'])))  {
//     $lang = new LanguageController();
//     $lang->defineixIdiomaDeLaPagina($_GET['lang']);
// }

// if (($_SERVER["REQUEST_METHOD"] == "GET") && (isset($_GET['tipo'])) && ($_GET['tipo'] == "conf"))  {
//     $controladorUsuari = new UserController();
//     $controladorUsuari->confirmaUsuari($_GET['cod']);
// }


// //Verifiquem si és un POST i és el log-in
// if (($_SERVER["REQUEST_METHOD"] == "POST") && (isset($_POST['submit'])) && ($_POST['submit']=="Verifica")) {
//     $controladorUsuari = new UserController();
//     $errorsDetectats = $controladorUsuari->logIn();
    
// }

// if (($_SERVER["REQUEST_METHOD"] == "POST") && (isset($_POST['submit'])) && ($_POST["submit"]=="Envia")) {
//     $controladorUsuari = new UserController();
//     $controladorUsuari->registre();
// }

// if (($_SERVER["REQUEST_METHOD"] == "POST") && ($_POST["submit"]=="Sortir")) {
//     $_SESSION['paginaActual'] = 1;
// }

// if (($_SERVER["REQUEST_METHOD"] == "POST") && ($_POST["submit"]=="Signar Llibre")) {
//     $vista = new GuestBookView();
//     $vista->setBody("plantilles/guestBookForm.php");
//     $vista->show();
//     exit;
//     //$contorladorGuetBook->nouComentari();
// }

// if (($_SERVER["REQUEST_METHOD"] == "POST") && ($_POST["submit"]=="Signa")) {
//     $contorladorGuestBook = new GuestBookController();
//     $errors = $contorladorGuestBook->nouComentari();
    
//     $vista = new GuestBookView();
//     $vista->setBody("plantilles/guestBookForm.php");
//     $vista->setComentari($contorladorGuestBook->getComentari());
//     $vista->setErrorsDetectats($errors);
//     $vista->show();
//     exit;
// }



// switch ($_SESSION['paginaActual']) {
//     case 1;
//     $vista->setBody("plantilles/body.php");
//     break;
//     case 2:
//     case 3:
//         if (!isset($_SESSION['usuari'])) {
//             $vista->setBody("plantilles/login.php");
//         } else {
//             $vista->setBody("plantilles/underConstruction.php");
//         }
//         break;
//     case 4:
//         if (!isset($_SESSION['usuari'])) {
//             $vista->setBody("plantilles/login.php");
//         } else {
//             $gb = new GuestBookController();
//             $aLlibre = $gb->getLlibre();
            
            
//             $vista = new GuestBookView($aLlibre);
//             $vista->setBody("plantilles/guestBook.php");
//         }
//         break;
//     case 5:
//         if (!isset($_SESSION['usuari'])) {
//             $vista->setBody("plantilles/login.php");
//         } else {
//             $vista->setBody("plantilles/underConstruction.php");
//         }
//         break;
//     case 97:
//         $vista->setUser(new User());
//         $vista->setBody("plantilles/register.php");
        
//         break;
//     case 98:
//         unset($_SESSION['usuari']);
//         unset($_SESSION['img']);
//         unset($_SESSION['paginaActual']);
//         $vista->setBody("plantilles/logout.php");
//         break;
//     case 99:
//         $vista->setBody("plantilles/login.php");
//         break;
//     case 100:
//         $vista->setBody("plantilles/wellcome.php");
//         break;
// }

// $vista->show();

?>