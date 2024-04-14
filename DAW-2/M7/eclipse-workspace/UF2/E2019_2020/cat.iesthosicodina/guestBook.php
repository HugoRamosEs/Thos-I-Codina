<?php 
session_start();
require_once 'php/generalFunctions.php';
require_once 'php/variablesDeconfiguracio.php';
require_once 'php/xmlFunctions.php';
require_once 'php/idioma.php';

$file=fopen($rutaDelGuestBook,"r") or die("Error 3000: El fitxer no s'ha pogut crear correctament.");
while(!feof($file)) {
    $Llibre .= fgets($file);
}
fclose($file);

$elementNumero = 1;

while (($registreActual = getElement("REGISTRE", $Llibre, $elementNumero)) !== false) {
    $sData = getDada("DATA",getElement("DATA", $registreActual, 1));
    $sNom  = getDada("NOM",getElement("NOM", $registreActual, 1));
    $sPais = ucwords(getDada("PAIS",getElement("PAIS", $registreActual, 1)));
    $sExperiencia = convertirExperiencia(getDada("EXPERIENCIA",getElement("EXPERIENCIA", $registreActual, 1)));
    $sComentari = getDada("COMENTARI",getElement("COMENTARI", $registreActual, 1));
    
    $aLlibre[$elementNumero]["qui"] = "El $sData, en $sNom ($sPais) va tenir una $sExperiencia i va escriure:\n";
    $aLlibre[$elementNumero++]["que"] = $sComentari ;
}



include "plantilles/header.php";
include "plantilles/navigationIdiomes.php";
include "plantilles/navigation.php";
include "plantilles/guestBook.php";
include "plantilles/footer.php";

?>
