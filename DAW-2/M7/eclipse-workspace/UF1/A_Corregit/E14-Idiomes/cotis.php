<?php 
session_set_cookie_params(0);
session_start();

include "functions.php";

if (isset($_COOKIE["lang"])) {
    $lang = $_COOKIE["lang"];
} else {
    $lang = "ca";
}
$fitxerDeTraduccions = "languages/{$lang}_traduccio.php";
require_once $fitxerDeTraduccions;



$html_opacityLang{$lang}="style=\"opacity:1;\"";

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
		<div class="logo">
			<logomenu>
			<ul>
				<li class="logo">Thos i Codina</li>
				<li>M07</li>
				<li>UF1</li>
				<li>2022-2022</li>
			</ul>
			</logomenu>
			<infosmenu>
			<ul>
				<li><?php echo $mainContacta;?></li>

				<a href='index.php'>
					<li class="btn"><?php echo $mainLog_in;?></li>
				</a>

			</ul>
			</infosmenu>
		</div>
		<div class="bighero">
			<h1><?php echo $mainTitol;?></h1>
			<p><?php echo $mainSubTitol;?></p>
		</div>
		<div class="lang">
			<infosmenu>
			<ul>
				<div id="catala" <?php echo $html_opacityLang[ca]; ?>>
					<a href='index.php?lang=ca'><li class="btn"><?php echo $mainLangCA; ?></li></a>
				</div>
				<div id="euzkera" <?php echo $html_opacityLang[eu]; ?>>
					<a href='index.php?lang=eu'><li class="btn"><?php echo $mainLangEU; ?></li></a>
				</div>
				<div id="castella" <?php echo $html_opacityLang[es]; ?>>
					<a href='index.php?lang=es'><li class="btn"><?php echo $mainLangES; ?></li></a>
				</div>
				<div id="angles" <?php echo $html_opacityLang[en]; ?>>
					<a href='index.php?lang=en'><li class="btn"><?php echo $mainLangEN; ?></li></a>
				</div>
				<div id="frances" <?php echo $html_opacityLang[fr]; ?>>
					<a href='index.php?lang=fr'><li class="btn"><?php echo $mainLangFR; ?></li></a>
				</div>
				<div id="alemany" <?php echo $html_opacityLang[ge]; ?>>
					<a href='index.php?lang=ge'><li class="btn"><?php echo $mainLangGE; ?></li></a>
				</div>
			</ul>
			</infosmenu>
			</header>
	
	</section>
	<section class="menu">
		<div class="list">
			<div class="imgMenu"><?php echo $mainMenu1;?></div>
			<div class="imgMenu"><?php echo $mainMenu2;?></div>
			<div class="imgMenu"><?php echo $mainMenu3;?></div>
			<div class="imgMenu"><?php echo $mainMenu4;?></div>
			<div class="imgMenu"><?php echo $mainMenu5;?></div>
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
