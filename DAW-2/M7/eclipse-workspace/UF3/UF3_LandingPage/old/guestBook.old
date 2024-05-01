<?php
    // error_reporting(E_ALL);
    // ini_set('display_errors', 1);
    include_once "common/language.php";
    include_once "common/funcions.php";
    
    spl_autoload_register(function ($classe) {
        include_once 'classes/' . ucfirst(strtolower($classe)) . '.class.php';
    });
    
    if (isset($_COOKIE["registres"])) {
        $registres = unserialize($_COOKIE["registres"]);
    } else {
        $registres = [];
    }
    $ok = "";
    if ($_SERVER["REQUEST_METHOD"]=="POST" && (isset($_POST["enviar"]))) {
        $frmNom = sanitize($_POST["nom"]);
        $frmMail = sanitize($_POST["email"]);
        $frmOpcio = sanitize($_POST["seleccio"]);
        $frmMsg = sanitize($_POST["missatge"]);
        $errors = [];
        
        if (strlen($frmNom) == 0) {
            $errors["nom"] = "Nom no vàlid.";
        }
        if (!filter_var($frmMail, FILTER_VALIDATE_EMAIL)) {
            $errors["mail"] = "Email no vàlid.";
        }
        $opcions = ["molt bona", "bona", "regular", "dolenta", "molt dolenta"];
        if (empty($frmOpcio) || !in_array($frmOpcio, $opcions)) {
            $errors["seleccio"] = "Has de seleccionar una opció vàlida.";
        }
        if (strlen($frmMsg) == 0) {
            $errors["missatge"] = "Has d'escriure un missatge.";
        }
        if (empty($errors)) {
            try {
                $data = getdate();
                $usuari = new Usuari($frmNom, $frmMail, $frmOpcio, $frmMsg, $data);
                $usuariModel = new UsuariModel();
                $usuariModel->create($usuari);
                $registres = $usuariModel->read($usuari); 
                setcookie("registres", serialize($registres), time() + 31536000);
                
                unset($frmNom);
                unset($frmMail);
                unset($frmOpcio);
                unset($frmMsg);
                $ok = "S'ha enviat correctament.";
            } catch (Exception $e) {
                $errors["classe"] = $e->getMessage();
            }            
        } 
    }
    $thead = "<table><thead><tr>";
    $th = array("Nom", "Email", "Experiència", "Missatge", "Data");
    foreach ($th as $titol){
        $thead .= "<th> $titol </th>";
    }
    $thead .= "</tr></thead>";
    $tbody = "<tbody>";
    foreach ($registres as $registre) {
        $tbody .= "<tr>";
        foreach ($registre as $dada) {
            $tbody .= "<td>$dada</td>";
        }
        $tbody .= "</tr>";
    }
    $tbody .= "</tbody></table>";
    $taula = $thead . $tbody;
?>

<?php
    include "templates/head.tpl.php";
    include "templates/header.tpl.php";
    include "templates/main-guest.tpl.php";
    include "templates/footer.tpl.php";
?>

