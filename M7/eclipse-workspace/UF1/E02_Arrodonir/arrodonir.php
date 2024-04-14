<?php
error_reporting(E_ALL);
ini_set("display_errors",1);

$num = 3.142623;
$decimals = 2;
$exponent = $decimals + 1;
$num = $num * (pow(10, $exponent));

$arreglat = (int) $num % 10;
if ($arreglat < 5){
    $num = $num - $arreglat;
}else{
    $nou = 10 - $arreglat;
    $num = $num + $nou;
}

$num = (int) $num;
$num = $num / (pow(10, $exponent));
?>

<html>
<body>
	<h1>E02_ARRODONIR</h1>
	<?php
	   echo "Num: $num";
	?>
</body>
</html>