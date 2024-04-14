<?php
//error_reporting(E_ALL);
//ini_set("display_errors", 1);
include "functions.php";


$casosDeProba[1] = array("entrada" => "01/01/1614", "esperat" => FALSE);
$casosDeProba[2] = array("entrada" => "01/01/1993", "esperat" => TRUE );
$casosDeProba[3] = array("entrada" => "01/01/2025", "esperat" => FALSE);
$casosDeProba[4] = array("entrada" => "31/12/1899", "esperat" => FALSE);
$casosDeProba[5] = array("entrada" => "01/01/1900", "esperat" => TRUE);
$casosDeProba[6] = array("entrada" => date("d-m-Y"), "esperat" => TRUE);
$casosDeProba[7] = array("entrada" => date("d-m-Y")+1, "esperat" => FALSE);
$casosDeProba[8] = array("entrada" => "01/-03/2020", "esperat" => FALSE);
$casosDeProba[9] = array("entrada" => "01/04/2020", "esperat" => TRUE);
$casosDeProba[10] = array("entrada" => "01/18/2020", "esperat" => FALSE);
$casosDeProba[11] = array("entrada" => "01/00/2020", "esperat" => FALSE);
$casosDeProba[12] = array("entrada" => "01/01/2020", "esperat" => TRUE);
$casosDeProba[13] = array("entrada" => "01/12/2020", "esperat" => TRUE);
$casosDeProba[14] = array("entrada" => "01/13/2020", "esperat" => FALSE);
$casosDeProba[15] = array("entrada" => "-2/12/2020", "esperat" => FALSE);
$casosDeProba[16] = array("entrada" => "06/03/2020", "esperat" => TRUE);
$casosDeProba[17] = array("entrada" => "40/03/2020", "esperat" => FALSE);
$casosDeProba[18] = array("entrada" => "00/01/2020", "esperat" => FALSE);
$casosDeProba[19] = array("entrada" => "01/01/2020", "esperat" => TRUE);
$casosDeProba[20] = array("entrada" => "28/04/2020", "esperat" => TRUE);
$casosDeProba[21] = array("entrada" => "29/02/2019", "esperat" => FALSE);
$casosDeProba[22] = array("entrada" => "29/02/2020", "esperat" => TRUE);
$casosDeProba[23] = array("entrada" => "30/02/2021", "esperat" => FALSE);
$casosDeProba[24] = array("entrada" => "30/04/2020", "esperat" => TRUE);
$casosDeProba[25] = array("entrada" => "31/03/2020", "esperat" => TRUE);
$casosDeProba[26] = array("entrada" => "31/04/2020", "esperat" => FALSE);
$casosDeProba[27] = array("entrada" => "32/06/2020", "esperat" => FALSE);

foreach ($casosDeProba as $id => $casDeProba) { 
    if (dateVerifier($casDeProba["entrada"]) === $casDeProba["esperat"]) {
        echo "Proba $id superada. <br>";
    } else {
        echo "Error en la proba $id. <br>";
    }
}