<?php

class CotisController extends Controller {
    public function __construct() {
        parent::__construct();
    }
    
    public function load(){
        if (isset($_COOKIE["lang"])) {
            $lang = $_COOKIE["lang"];
        } else {
            $lang = "cat";
        }
        
        if(isset($_POST["submit"]) && $_SERVER["REQUEST_METHOD"] == "POST") {
            $resultat = $this->web_scraping();
        }
        
        $resultat = $this->web_scraping();
        
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
        
        $vCotis = new CotisView();
        $vCotis->show($lang, $taula);
    }
    
    public function web_scraping() {
        $html = file_get_contents("https://www.inversis.com/inversiones/productos/cotizaciones-nacionales&pathMenu=3_1_0_0&esLH=N");
        $resultat = array();
        
        $patroTr = '/<tr id="tr_\d+"[^>]*>(.*?)<\/tr>/s';
        preg_match_all($patroTr, $html, $tr);
        
        foreach ($tr[1] as $encontrat) {
            $patroTd = '/<td[^>]*>(.*?)<\/td>/s';
            preg_match_all($patroTd, $encontrat, $td);
            
            $dadesTd = array(
                'nom' => iconv('ISO-8859-1', 'UTF-8', trim(strip_tags($td[1][0]))),
                'ticker' => trim(strip_tags($td[1][1])),
                'mercat' => trim(strip_tags($td[1][2])),
                'ultima_coti' => trim(strip_tags($td[1][4])),
                'divisa' => trim(strip_tags($td[1][5])),
                'variacio' => trim(strip_tags($td[1][6])),
                'variacio_percent' => trim(strip_tags($td[1][7])),
                'volum' => trim(strip_tags($td[1][8])),
                'mínim' => trim(strip_tags($td[1][9])),
                'màxim' => trim(strip_tags($td[1][10])),
                'data' => trim(strip_tags($td[1][11])),
                'hora' => trim(strip_tags($td[1][12])),
            );
            
            if ($dadesTd['data']){
                $data = explode(" ", $dadesTd['data']);
                $dadesTd['data'] = trim($data[0]);
            }
            
            if ($dadesTd['hora']){
                $hora = explode(" ", $dadesTd['hora']);
                $dadesTd['hora'] = trim($hora[0]);
            }
            array_push($resultat, $dadesTd);
        }
        return $resultat;
    }
}

