<?php
    error_reporting(E_ALL);
    ini_set("display_errors", 1);
    
    function dateVerifier($data)
    {
        $dataSplit = explode("/", $data);
        $dataEntrada = [];
        
        for ($i=0; $i<count($dataSplit); $i++){
            array_push($dataEntrada, $dataSplit[$i]);
        }
        
        $dia = (int) $dataEntrada[0];
        $mes = (int) $dataEntrada[1];
        $any = (int) $dataEntrada[2];
        
        $diaActual = (int) date("d");
        $mesActual = (int) date("m");
        $anyActual = (int) date("Y");
        
        $anyDeTraspas = ((($any % 4 == 0) && ($any % 100 != 0)) || ($any % 400 == 0));
        
        if ($any < 1900 || $any > $anyActual){
            return "ERROR";
        }elseif ($any == $anyActual && $mes > $mesActual) {
            return "ERROR";
        }elseif ($any >= 1900 && $any <= $anyActual){
            if ($mes < 1 || $mes > 12){
                return "ERROR";
            }elseif ($mes == $mesActual && $dia > $diaActual) {
                return "ERROR";
            }elseif (($mes == 4 || $mes == 6 || $mes == 9 || $mes == 11) && $dia > 30) {
                return "ERROR";
            }elseif($mes >= 1 && $mes <= 12){
                if ($dia < 1 || $dia > 31){
                    return "ERROR";
                }elseif (!$anyDeTraspas && $mes == 2 && $dia >= 29){
                    return "ERROR";
                }
                
                else{
                    return "OK";
                }
            }
        }else{
            return "OK";
        }
    }
?>

<html>
<body>
	<h1>E09_DATE_VERIFIER</h1>
		<?php
		    $data = "18/04/2004";
            echo "Data introduida: $data <br>";
            echo "Verificador de Data: " . dateVerifier($data);
        ?>
</body>
</html>