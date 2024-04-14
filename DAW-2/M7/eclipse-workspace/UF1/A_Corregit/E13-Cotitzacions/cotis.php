<?php 
session_set_cookie_params(0);
session_start();

include "functions.php";

$newTable = webScrappingInversis();
$taula = html_generateTable($newTable);
$_SESSION["cotis"] = $newTable;

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
    <title>Thos i Codina M07 UF1</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
	<section class="one">
		<header>
			<logomenu>
			<ul>
				<li class="logo">Thos i Codina</li>
				<li>M07</li>
				<li>UF1</li>
				<li>2020-2021</li>
			</ul>
			</logomenu>
			<infosmenu>
			<ul>
				<li>Contacta</li>
				
				<a href='index.php'>
				<li class="btn">Log-in</li></a>
				
			</ul>
			</infosmenu>
		</header>
		<div class="bighero">
			<h1>Llenguatges entorn servidor</h1>
			<p>Aquesta és la nostra primera pràctica de llenguatge</p>
		</div>
	</section>
	<section class="menu">
		<div class="list">
			<div class="imgMenu">Home</div>
			<div class="imgMenu">Opcio1</div>
			<div class="imgMenu">Opcio2</div>
			<div class="imgMenu">Opcio3</div>
			<div class="imgMenu">Opcio4</div>
		</div>
	</section>
	<section class="infos">
		<div class="content">
			<div class="button allcenter">
				<a href='cotis.php'>
					<ul><li class="btn">Refrescar les dades</li></ul>
				</a>
			</div>
		</div>
		<div class="table">
			<?php echo $taula;?>
		</div>			
	</section>

</body>
</html>
