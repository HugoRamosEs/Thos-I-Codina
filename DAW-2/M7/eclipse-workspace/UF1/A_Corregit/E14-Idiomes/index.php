<?php
//error_reporting(E_ALL);
//ini_set("display_errors", 1);

$_valorsPossibles = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

for ($i = 1; $i <= 6; $i ++) {
    $resultat .= $_valorsPossibles[rand(0, strlen($_valorsPossibles) - 1)];
}

if ($_SERVER["REQUEST_METHOD"]=="GET" && isset($_GET["lang"])) {
    $lang = $_GET["lang"];
    setcookie("lang",$lang,time()+3600);
} else {
    if (isset($_COOKIE["lang"])) {
        $lang = $_COOKIE["lang"];
    } else {
        $lang = "ca";
    }
}

$fitxerDeTraduccions = "languages/{$lang}_traduccio.php";
require_once $fitxerDeTraduccions;

$html_opacityLang[$lang]="style=\"opacity:1;\"";
?>



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
<title>Thos i Codina M07 UF1</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
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
				<li>2022-2023</li>
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
				<div id="catala" <?php echo (isset($html_opacityLang["ca"]))?$html_opacityLang["ca"]:""; ?>>
					<a href='index.php?lang=ca'><li class="btn"><?php echo $mainLangCA; ?></li></a>
				</div>
				<div id="euzkera" <?php echo (isset($html_opacityLang["eu"]))?$html_opacityLang["eu"]:""; ?>>
					<a href='index.php?lang=eu'><li class="btn"><?php echo $mainLangEU; ?></li></a>
				</div>
				<div id="castella" <?php echo (isset($html_opacityLang["es"]))?$html_opacityLang["es"]:""; ?>>
					<a href='index.php?lang=es'><li class="btn"><?php echo $mainLangES; ?></li></a>
				</div>
				<div id="angles" <?php echo (isset($html_opacityLang["en"]))?$html_opacityLang["en"]:""; ?>>
					<a href='index.php?lang=en'><li class="btn"><?php echo $mainLangEN; ?></li></a>
				</div>
				<div id="frances" <?php echo (isset($html_opacityLang["fr"]))?$html_opacityLang["fr"]:""; ?>>
					<a href='index.php?lang=fr'><li class="btn"><?php echo $mainLangFR; ?></li></a>
				</div>
				<div id="alemany" <?php echo (isset($html_opacityLang["ge"]))?$html_opacityLang["ge"]:""; ?>>
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
			<div class="grid allcenter">

				<div class="float-md-50 wimg">
					<img
						src="https://www.malagana.net/wp-content/uploads/2015/11/generador-numeros-aleatorios.jpg" />
				</div>
				<div class="float-md-50 winfo">    				
    				<?php echo "<h1 class='title'>$resultat</h1>"; ?>
    						
					<p class="description"><?php echo $mainInfo1Desc;?></p>
					<a href='index.php'> <input type="button" class="btn"
						value="<?php echo $mainInfo1Btn;?>"></a>
				</div>
			</div>

			<div class="grid allcenter" href="cotis.php">
				<div class="float-md-50 wimg">
					<a href="cotis.php"> <img
						src="https://www.farobursatil.com/wp-content/uploads/2017/09/tiempo-real.jpg" />
					</a>
				</div>
				<div class="float-md-50 winfo">
					<a href="cotis.php">
						<h1 class="title"><?php  echo $mainInfo2Title;?></h1>
						<p class="description"><?php echo $mainInfo2Desc;?></p>
					</a>
				</div>

			</div>
			<div class="grid allcenter" href="cotis.php">
				<div class="float-md-50 wimg">
					<img
						src="https://www.capgros.com/uploads/s1/18/85/5/20131212101227.jpg" />
				</div>
				<div class="float-md-50 winfo">
					<h1 class="title"><?php  echo $mainInfo3Title;?></h1>
					<p class="description"><?php echo $mainInfo3Desc;?></p>
				</div>
			</div>


			<div class="grid allcenter">
				<div class="float-md-50 wimg">
					<img
						src="http://www.totmataro.cat/index.php?option=com_joomgallery&view=image&format=raw&id=3403&type=img" />
				</div>
				<div class="float-md-50 winfo">
					<h1 class="title"><?php  echo $mainInfo4Title;?></h1>
					<p class="description"><?php echo $mainInfo4Desc;?></p>
				</div>
			</div>
		</div>
	</section>
	<!-- partial -->
	<script src="./script.js"></script>

</body>
</html>
