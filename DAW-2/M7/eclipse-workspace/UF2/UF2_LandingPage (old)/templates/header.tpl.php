<body>
	<header>
		<div class="contenedor-header">
			<div id="header1">
				<p>M7 - (2023-2024)</p>
			</div>
			<div id="header2">
				<a href="contacte.php"><?php echo $traduccio["contacte"]?></a>
			</div>
			<div id="header3">
				<h1><?php echo $traduccio["header-titol"]?></h1>
				<h2>Hugo Ramos</h2>
			</div>
			<div id="header4">
				<form id="idiomes" method="get" action="">
					<div class="idioma-cont">
						<input type="submit" name="inicials" value="CAT" <?php echo ($idioma === "cat") ? 'class="seleccionat"' : ""; ?>>
                        <input type="submit" name="inicials" value="ESP" <?php echo ($idioma === "esp") ? 'class="seleccionat"' : ""; ?>>
                        <input type="submit" name="inicials" value="EN" <?php echo ($idioma === "en") ? 'class="seleccionat"' : ""; ?>>
                        <input type="submit" name="inicials" value="FR" <?php echo ($idioma === "fr") ? 'class="seleccionat"' : ""; ?>>
                        <input type="submit" name="inicials" value="GER" <?php echo ($idioma === "ger") ? 'class="seleccionat"' : ""; ?>>
					</div>
					<span class="error"><?php echo $errors["idioma"];?></span> 
				</form>
				
			</div>

		</div>
		<div id="header5">
			<nav>
				<ul>
					<li><a href="index.php"><?php echo $traduccio["nav1"]?></a></li>
					<li><a href="contacte.php"><?php echo $traduccio["nav2"]?></a></li>
					<li><a href="cotitzacions.php"><?php echo $traduccio["nav3"]?></a></li>
					<li><a href="guestBook.php"><?php echo $traduccio["nav4"]?></a></li>
				</ul>
			</nav>
		</div>
	</header>