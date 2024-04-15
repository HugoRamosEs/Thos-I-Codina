<?php
    //error_reporting(E_ALL);
    //ini_set("display_errors",1);
    function web_scraping() {
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
    
?>