<main>
	<div class="contenedor-main">
		<h2><?php echo $traduccio["main-titol"]?></h2>
		<p id="desc1"><?php echo $traduccio["desc1"]?></p>
		<h3>UF3</h3>
		<?php echo (isset($_SESSION["login"])) ? '<a href="?Idioma/show">':'<a href="?Usuari/login">';?>
			<article>
				<figure>
					<img src="img/UF3-E01.png" alt="UF3-E01.png">
				</figure>
				<div class="text">
					<h3>E01_<?php echo $traduccio["ex4"]?></h3>
					<h4>(18 feb. 2024)</h4>
					<p><?php echo $traduccio["desc7"]?></p>
				</div>
			</article>
		</a>
		<h3>UF2</h3>
		<?php echo (isset($_SESSION["login"])) ? '<a href="?Zona/show">':'<a href="?Usuari/login">';?>
			<article>
				<figure>
					<img src="img/UF2-E03.png" alt="UF2-E03.png">
				</figure>
				<div class="text">
					<h3>E03_<?php echo $traduccio["ex3"]?></h3>
					<h4>(28 gen. 2024)</h4>
					<p><?php echo $traduccio["desc6"]?></p>
				</div>
			</article>
		</a>
		<a href="?Usuari/login">
			<article>
				<figure>
					<img src="img/UF2-E02.png" alt="UF2-E02.png">
				</figure>
				<div class="text">
					<h3>E02_<?php echo $traduccio["ex2"]?></h3>
					<h4>(10 dec. 2023)</h4>
					<p><?php echo $traduccio["desc5"]?></p>
				</div>
			</article>
		</a>
		<a href="?GuestBook/form">
			<article>
				<figure>
					<img src="img/UF2-E01.png" alt="UF2-E01.png">
				</figure>
				<div class="text">
					<h3>E01_<?php echo $traduccio["ex1"]?></h3>
					<h4>(19 nov. 2023)</h4>
					<p><?php echo $traduccio["desc4"]?></p>
				</div>
			</article>
		</a> 
		<h3>UF1</h3>
		<?php echo (isset($_SESSION["login"])) ? '<a href="?Cotis/load">':'<a href="?Usuari/login">';?>
			<article>
				<figure>
					<img src="img/UF1-E13.png" alt="UF1-E13.png">
				</figure>
				<div class="text">
					<h3>E13_<?php echo $traduccio["nav3"]?></h3>
					<h4>(29 oct. 2023)</h4>
					<p><?php echo $traduccio["desc3"]?></p>
				</div>
			</article>
		</a> 
		<a href="?Contacte/form">
			<article>
				<figure>
					<img src="img/UF1-E11.png" alt="UF1-E11.png">
				</figure>
				<div class="text">
					<h3>E11_<?php echo $traduccio["nav2"]?></h3>
					<h4>(15 oct. 2023)</h4>
					<p><?php echo $traduccio["desc2"]?></p>
				</div>
			</article>
		</a> 
	</div>
</main>