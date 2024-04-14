<?php
error_reporting(E_ALL);
ini_set("display_errors",1);

function buscar_text_cadena($text, $cadena){
    $cont = 0;
    
    $text_min = strtolower($text);
    $cadena_min = strtolower($cadena);
    $text_split = explode(" ", $text_min);
    
    for ($i=0; $i<count($text_split); $i++){
        if ($text_split[$i] ==  $cadena_min){
            $cont++;
        }
    }
    
    if ($cont != 0){
        return "Contador paraula: " . $cont;
    }else{
        return "No existeix la cadena en el text, llavors la paraula apareix " .$cont. " vegades.";
    }
}

function posicions_text_cadena($text, $cadena){
    $posicions = [];
    
    $text_min = strtolower($text);
    $cadena_min = strtolower($cadena);
    $pos = strpos($text_min,  $cadena_min);
    
    while ($pos == true) {
        array_push($posicions, $pos + 1);
        $pos = strpos($text_min, $cadena_min, $pos + 1);
    }
    
    if ($posicions != null){
        return"<br>Posicions dins del text: " . implode(", ", $posicions);
    }else{
        return "<br>No existeix la cadena en el text, per tant no es poden mostrar les posicions.";
    }
}
?>

<html>
<body>
	<h1>E08_BUSCAR-UNA-CADENA</h1>
	<p>
		<?php 
		   $text = "Es un text breu i senzill que permet comptar les vegades que apareix una cadena en un text";
		   $cadena = "text";
		   
    	   echo buscar_text_cadena($text, $cadena);
    	   echo posicions_text_cadena($text, $cadena);
    	?>
	</p>
</body>
</html>