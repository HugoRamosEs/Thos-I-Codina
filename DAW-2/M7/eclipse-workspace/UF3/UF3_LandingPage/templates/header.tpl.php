<body>
	<header>
		<div class="contenedor-header">
			<div id="header1">
				<p>M7 - (2023-2024)</p>
			</div>
			<div id="header2">
    			<div class="header2-class">
    				<a href="?Contacte/form"><?php echo $traduccio["contacte"]?></a>
    				<?php echo (isset($_SESSION["login"])) ? '<a href="?Usuari/logout">'.$traduccio["logout"].'</a>':'<a class="a-login" href="?Usuari/login">'.$traduccio["login"].'</a>';?>
    				<?php echo (isset($_SESSION["imatge"])) ? '<img src="'.$_SESSION["imatge"].'" alt="'.$_SESSION["imatge"].'">' : "";?>
    			</div>
			</div>
			<div id="header3">
				<h1><?php echo $traduccio["header-titol"]?></h1>
				<h2>Hugo Ramos</h2>
			</div>
			<?php echo $navIdiomes?>
		</div>
		<div id="header5">
			<nav>
				<ul>
					<li><a href="index.php"><?php echo $traduccio["nav1"]?></a></li>
					<li><?php echo (isset($_SESSION["login"])) ? '<a href="?Cotis/load">'.$traduccio["nav3"].'</a>':'<a href="?Usuari/login">'.$traduccio["nav3"].'</a>';?></li>
					<li><a href="?GuestBook/form"><?php echo $traduccio["nav4"]?></a></li>
					<li><?php echo (isset($_SESSION["login"])) ? '<a href="?Zona/show">'.$traduccio["nav5"].'</a>':'<a href="?Usuari/login">'.$traduccio["nav5"].'</a>';?></li>
					<li><?php echo (isset($_SESSION["login"])) ? '<a href="?Idioma/show">'.$traduccio["nav6"].'</a>':'<a href="?Usuari/login">'.$traduccio["nav6"].'</a>';?></li>
				</ul>
			</nav>
		</div>
	</header>