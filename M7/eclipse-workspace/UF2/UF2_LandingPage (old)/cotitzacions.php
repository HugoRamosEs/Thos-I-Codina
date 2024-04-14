<?php
    //error_reporting(E_ALL);
    //ini_set("display_errors", 1);
    session_start();
    include_once "common/language.php";
    include_once "common/funcions.php";
    
    function obtenirDades() {
        return web_scraping();
    }
    
    if(isset($_POST["submit"]) && $_SERVER["REQUEST_METHOD"] == "POST") {
        $resultat = obtenirDades();
    }
    
    $resultat = obtenirDades();
    
    $thead = "<table><thead><tr>";
    $th = array("Nom", "Ticker", "Mercat", "Ultima_Coti", "Divisa", "Variacio", "Variacio_%", "Volum", "Mínim", "Màxim", "Data", "Hora");
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

<?php
    include "templates/head.tpl.php";
    include "templates/header.tpl.php";
    include "templates/main-coti.tpl.php";
    include "templates/footer.tpl.php";
?>


