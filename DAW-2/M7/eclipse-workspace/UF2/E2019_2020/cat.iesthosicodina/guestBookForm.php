<?php
require_once "php/generalFunctions.php";
require_once 'php/variablesDeconfiguracio.php';


if (($_SERVER["REQUEST_METHOD"] == "POST") && ($_POST["submit"]=="Signa")) {
    // Hem arribar per un post
    // Verifiquem les dades que han arribat.
    
    $sEmail = sanitize($_POST["email"],1);
    $sNom =  sanitize($_POST["nom"],1);
    $sPais = sanitize($_POST["pais"],0);
    $sExperiencia = sanitize($_POST["experiencia"],2);
    $sComentari = sanitize($_POST["comentari"],0);
    
    if ($sEmail == "") {
        $errorsDetectats["email"] = "l'email és una dada obligatòria, si us plau indica-la.";
    } else {
        if (!esEmail($sEmail)) {
            $errorsDetectats["email"] = "l'email no té un format adient.";
            unset($sEmail);
        }
    }
    
    if ($sNom == "") {
        $errorsDetectats["nom"] = "El nom és una dada obligatòria, si us plau indica-la.";
    } else {
        if (!esNom($sNom)) {
            $errorsDetectats["nom"] = "El nom no té un format correcte."; 
            unset($sNom);
        }
    }
    
    if ($sPais == "") {
        $errorsDetectats["pais"] = "El pais és una dada obligatòria, si us plau indica-la.";
    } else {
        if (!esPais($sPais)) {
            $errorsDetectats["pais"] = "El pais no té un format correcte.";
            unset($sPais);
        }
    }
    
    if ($sExperiencia == "") {
        $errorsDetectats["experiencia"] = "L'experieèncias és una dada obligatòria, si us plau indica-la.";
    } else {
        if (!esExperiencia($sExperiencia)) {
            $errorsDetectats["experiencia"] = "L'Experienència no té un format correcte.";
            unset($sNom);
        }
    }
    
    if ($sComentari == "") {
        $errorsDetectats["comentari"] = "Hauries de deixar un comentari.";
    } else {
        if (!esComentari($sComentari)) {
            $errorsDetectats["comentari"] = "Hi ha hagut algun problema amb el contingut del comentari.";
            unset($sComentari);
        }
    }

    if (!isset($errorsDetectats)) {
        // No hi ha errors en les dades rebudes.
        $sLlibre = substr(file_get_contents($rutaDelGuestBook),0,-13);
        $sData = getdate();
        $sLlibre .= "<REGISTRE><DATA>".$sData['mday']."/".$sData['mon']."/".$sData['year']."</DATA><NOM>$sNom</NOM><MAIL>$sEmail</MAIL><PAIS>$sPais</PAIS>";
        $sLlibre .= "<EXPERIENCIA>$sExperiencia</EXPERIENCIA><COMENTARI>$sComentari</COMENTARI></REGISTRE> \n";
        $sLlibre .= "</REGISTRES>";
        $file = fopen($rutaDelGuestBook, "w");
        fputs($file,$sLlibre);
        fclose($file);

        header('Location: guestBook.php');
        exit();
    } else {
        $errorsDetectats["error"] = "S'ha detectat algun tipus d'error. Revisa les dades introduides.";
    }
} elseif (($_SERVER["REQUEST_METHOD"] == "GET") && ($_GET["submit"]=="Sortir")) {
    header('Location: index.php');
    exit();
} else {
    $sEmail = "";
    $sNom = "";
    $sPais = "España";
    $sExperiencia = "";
    $errorsDetectats = "";
}



include "plantilles/header.php";
include "plantilles/guestBookForm.php";
include "plantilles/footer.php";

?>