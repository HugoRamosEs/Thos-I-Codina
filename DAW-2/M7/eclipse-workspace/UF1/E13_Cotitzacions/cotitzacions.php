<?php
    session_start();
    error_reporting(E_ALL);
    ini_set("display_errors", 1);
    include "web_scraping.php";
    
    function obtenirDades() {
        return web_scraping();
    }
    
    if(isset($_POST["submit"]) && $_SERVER["REQUEST_METHOD"] == "POST") {
        $resultat = obtenirDades();
    }
    
    $resultat = obtenirDades();
    
    $thead = "<table><thead><tr>";
    $th = array("Nom", "Ticker", "Mercat", "Ultima_Coti", "Divisa", "Variacio", "Variacio %", "Volum", "Mínim", "Màxim", "Data", "Hora");
    foreach ($th as $titol){
        $thead .= "<th>" . $titol . "</th>";
    }
    $thead .= "</tr></thead>";
    
    $tbody = "<tbody>";
    $num = 0;
    $ultimes_coti = 0;
    foreach($resultat as $empresa){
        $tbody .= "<tr>";
        foreach ($empresa as $td => $cela) {
            if ($td === 'ultima_coti') {
                if (isset($_SESSION['ultimes_cotitzacions' . $num])) {
                    $ultimes_coti = $_SESSION['ultimes_cotitzacions' . $num];
                    if ($ultimes_coti < $cela) {
                        $tbody .= '<td class="superior">' . $cela . "</td>";
                    } else if ($ultimes_coti == $cela) {
                        $tbody .= '<td class="iguals">' . $cela . '</td>';
                    }else{
                        $tbody .= '<td class="inferior">' . $cela . "</td>";
                    }
                } else {
                    $tbody .= '<td>' . $cela . '</td>';
                }
            } elseif ($td === 'variacio' || $td === 'variacio_percent') {
                if ($cela >= 0) {
                    $tbody .= '<td class="positiu">' . $cela . "</td>";
                } else {
                    $tbody .= '<td class="negatiu">' . $cela . "</td>";
                }
            } else {
                $tbody .= '<td>' . $cela . '</td>';
            }
        }
        $tbody .= "</tr>";
        $_SESSION['ultimes_cotitzacions' . $num] = $empresa['ultima_coti'];
        $num++;
    }
    $tbody .= "</tbody></table>";
    $taula = $thead . $tbody;
?>

<html>
    <head>
    <link rel="stylesheet" type="text/css" href="estils.css" />
    </head>
    <body>
    	<div id="contenedor">
    		<h1>E13_COTITZACIONS</h1>
            <form method="post" action="cotitzacions.php">
                <input type="submit" name="submit" value="Refrescar Dades">
            </form>
            <?php 
                echo $taula;
            ?>
    	</div>
    </body>
</html>