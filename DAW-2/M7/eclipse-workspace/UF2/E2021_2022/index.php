<?php
// error_reporting(E_ALL);
// ini_set("display_errors", 1);
// require_once 'classes/controlador/Controller.class.php';
// require_once 'classes/controlador/CLang.class.php';
// require_once 'classes/controlador/CError.class.php';
// require_once 'classes/controlador/CFront.class.php';
// require_once 'classes/model/Model.class.php';
// require_once 'classes/model/MLang.class.php';
// require_once 'classes/model/FormTagsLang.class.php';
// require_once 'classes/vista/View.class.php';
// require_once 'classes/vista/VError.class.php';

session_start();
include "config/Autoloader.php";
spl_autoload_register("Autoloader::load");
spl_autoload_register("Autoloader::newLoad");
$active["main"] = true;

try {
    $cFront = new FrontController();
    $cFront->dispatch();
}catch (Exception $e) {
    $vError = new VError();
    $vError->show("Error",$e);
}

// $formTagsLang = new FormTagsLang($lang);
// $formTagsLang = function __clone(){}

/** PREGUNTA 7
MySQLi (MySQL Improved) y PDO (PHP Data Objects) son dos extensiones de PHP que permiten interactuar con bases de datos relacionales, como MySQL, de manera efectiva. Aunque ambos cumplen la misma función básica, 
existen diferencias significativas en su funcionamiento y características:

API Orientada a Objetos vs. API Procedural:

MySQLi: Proporciona una API orientada a objetos y una API procedural. Esto significa que puedes elegir entre un estilo de programación orientado a objetos o uno procedural según tus preferencias o necesidades.
PDO: Ofrece una API orientada a objetos para interactuar con bases de datos. No proporciona una API procedural como MySQLi.
Soporte de Bases de Datos:

MySQLi: Está diseñado específicamente para MySQL, lo que significa que es compatible solo con bases de datos MySQL.
PDO: Es compatible con varios tipos de bases de datos, incluyendo MySQL, PostgreSQL, SQLite, SQL Server, y más. Esto hace que PDO sea más versátil si planeas cambiar entre diferentes bases de datos en tu aplicación.
Seguridad y Prevención de Inyección SQL:

MySQLi: Utiliza parámetros con consultas preparadas para prevenir la inyección SQL. Las consultas preparadas permiten la separación de datos y consultas, lo que aumenta la seguridad.
PDO: También soporta consultas preparadas, lo que la hace segura contra la inyección SQL. Además, al ser más abstracta, PDO puede ser más fácil de usar de forma segura, ya que proporciona un conjunto de funciones c
onsistentes para interactuar con diferentes bases de datos.
Compatibilidad con Características Avanzadas:

MySQLi: Ofrece soporte para características específicas de MySQL, como consultas múltiples, transacciones anidadas y almacenamiento de procedimientos.
PDO: Proporciona una capa de abstracción más alta y un conjunto de funciones más uniforme para diferentes bases de datos. Sin embargo, puede carecer de soporte para algunas características específicas de cada base de datos.
En resumen, la elección entre MySQLi y PDO depende de tus necesidades específicas. Si estás trabajando exclusivamente con MySQL y deseas un acceso rápido y directo a las funciones específicas de MySQL, 
MySQLi puede ser la mejor opción. Por otro lado, si necesitas una mayor portabilidad entre diferentes bases de datos o una capa de abstracción más alta para tus consultas, PDO puede ser la elección más 
adecuada. En general, PDO tiende a ser preferido por su versatilidad y seguridad.
 */


?>

