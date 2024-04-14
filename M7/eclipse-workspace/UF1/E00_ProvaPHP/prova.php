<?php
// Estas linias muestran el error, en vez de un pantallazo en blanco.
error_reporting(E_ALL);
ini_set("display_errors",1);

$valor = 7;
//var_dump($valor);
$valor2 = 7.55;
// var_dump($valor);
$valor3 = "<P>El primer paràgraf en PHP: fem servir l'instrucció 'echo'. </P>";
// var_dump($valor);
$valor4 = "3.14";

$res = $valor + $valor2;
// $sum = $valor2 + $valor3; // Pantallazo en blanco
$sum1 = $valor2 + $valor4; // Se puede, ya que PHP hace una conversion automatica del String a float. No es del todo perfecta.

?>

<HTML>
<BODY>
	<H1>Primer arxiu PHP</H1>
	<?php
	# El comentario en PHP se genera con #. Tambien se puede utilizar // y /*
	   echo $valor;
	   echo $res;
	   // echo $sum;
	   echo $sum1;
	?>
</BODY>
</HTML>