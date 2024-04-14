<?php 
//error_reporting(E_ALL);
//ini_set("display_errors", 1);

$valorsPossibles = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    				   				
for ($i=1; $i<=6; $i++) {
    $resultat .= $valorsPossibles[rand(0,strlen($valorsPossibles)-1)]; 
}
?>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
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
			<div class="grid allcenter">
	
    				<div class="float-md-50 wimg">
    					<img src="https://www.malagana.net/wp-content/uploads/2015/11/generador-numeros-aleatorios.jpg" />
    				</div>
    				<div class="float-md-50 winfo">
    				
    				<?php
    				echo "<h1 class='title'>$resultat</h1>";
    				?>
    						
					<p class="description">Codi generat aleatoriament</p>
					<a href='index.php'>
    				<input type="button" class="btn" value="Genera codi"></a>
    					
    				</div>

			</div>
			
			
			<div class="grid allcenter" href="cotis.php">
				<div class="float-md-50 wimg">
				<a href="cotis.php">
					<img src="https://www.farobursatil.com/wp-content/uploads/2017/09/tiempo-real.jpg" />
				</a>
				</div>
				<div class="float-md-50 winfo">
				<a href="cotis.php">
					<h1 class="title">Cotitzacions bursàtils en temps real</h1>
					<p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed a odio ac libero semper auctor. Suspendisse eu ultrices nunc, non pulvinar nibh. Duis tincidunt eros et lobortis dignissim. Nulla a leo ac quam vulputate feugiat non ac magna. Integer venenatis feugiat lacinia. Pellentesque venenatis bibendum metus, at feugiat dui elementum id. Nulla eu sodales sapien. Morbi eget eleifend urna, et sodales mi. Nulla aliquet sagittis aliquet.  </p>
					</a>
				</div>
				
			</div>
			<div class="grid allcenter" href="cotis.php">
				<div class="float-md-50 wimg">
					<img
						src="https://www.capgros.com/uploads/s1/18/85/5/20131212101227.jpg" />
				</div>
				<div class="float-md-50 winfo">
					<h1 class="title">Lorem Ipsum</h1>
					<p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed a odio ac libero semper auctor. Suspendisse eu ultrices nunc, non pulvinar nibh. Duis tincidunt eros et lobortis dignissim. Nulla a leo ac quam vulputate feugiat non ac magna. Integer venenatis feugiat lacinia. Pellentesque venenatis bibendum metus, at feugiat dui elementum id. Nulla eu sodales sapien. Morbi eget eleifend urna, et sodales mi. Nulla aliquet sagittis aliquet.  </p>
				</div>
			</div>
			
			
			<div class="grid allcenter">
				<div class="float-md-50 wimg">
					<img
						src="http://www.totmataro.cat/index.php?option=com_joomgallery&view=image&format=raw&id=3403&type=img" />
				</div>
				<div class="float-md-50 winfo">
					<h1 class="title">Lorem Ipsum</h1>
					<p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed a odio ac libero semper auctor. Suspendisse eu ultrices nunc, non pulvinar nibh. Duis tincidunt eros et lobortis dignissim. Nulla a leo ac quam vulputate feugiat non ac magna. Integer venenatis feugiat lacinia. Pellentesque venenatis bibendum metus, at feugiat dui elementum id. Nulla eu sodales sapien. Morbi eget eleifend urna, et sodales mi. Nulla aliquet sagittis aliquet.  </p>
				</div>
			</div>
		</div>
	</section>

</body>
</html>
