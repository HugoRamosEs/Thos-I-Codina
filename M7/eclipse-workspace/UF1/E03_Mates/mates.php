<?php
error_reporting(E_ALL);
ini_set("display_errors",1);
$a = 2;
$b = 3;
$c = 1;
$arrel = (sqrt(pow($b, 2) - (4 * $a * $c)));

if ($arrel < 0){
    echo 'La equació no es pot resoldre amb nombres reals.';
}

$solPositiva = (-$b + $arrel) / (2 * $a); 
$solNegativa = (-$b - $arrel) / (2 * $a);

?>

<html>
<body>
	<h1>E03_MATES</h1>
	<h2>Teòrica</h2>
		<p>Equació: f(x) = ax² + bx + c</p>
		<p>Fórmula per resoldre: -b +- &#8730;(b²-4ac) / 2a</p>
	<h2>Pràctica</h2>
    	<p>
        	<?php
        	   echo "Equació: f(x) = " . $a . "x² + " .$b. "x + " .$c. " = 0";
        	?>
    	</p>
    	<p>
        	<?php
        	   echo "Solució positiva (x1): " . $solPositiva;
        	?>
    	</p>
    	<p>
        	<?php
        	   echo "Solució negativa (x2): " . $solNegativa;
        	?>
    	</p>
</body>
</html>