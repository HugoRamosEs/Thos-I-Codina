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
			<div id="header4">
				<form id="idiomes" method="get" action="">
                    <div class="idioma-cont">
                        <a href="?lang/set/cat" class="<?php echo ($idioma === "cat") ? 'seleccionat' : ""; ?>">CAT</a>
                        <a href="?lang/set/esp" class="<?php echo ($idioma === "esp") ? 'seleccionat' : ""; ?>">ESP</a>
                        <a href="?lang/set/en" class="<?php echo ($idioma === "en") ? 'seleccionat' : ""; ?>">EN</a>
                        <a href="?lang/set/fr" class="<?php echo ($idioma === "fr") ? 'seleccionat' : ""; ?>">FR</a>
                        <a href="?lang/set/ger" class="<?php echo ($idioma === "ger") ? 'seleccionat' : ""; ?>">GER</a>
                    </div>
                    <div class="errors"><span class="error"><?php echo $errors["idioma"];?></span></div>
                </form>
			</div>

		</div>
		<div id="header5">
			<nav>
				<ul>
					<li><a href="index.php"><?php echo $traduccio["nav1"]?></a></li>
					<li><a href="?Entrada/show">Entrada</a></li>
					<li><a href="?Esdeveniment/show">Esdeveniment</a></li>
					<li><a href="?Data/show">Data</a></li>
					<li><a href="?Localitzacio/show">Locatització</a></li>
					<li><a href="?Zona/show">Zona</a></li>
					<li><a href="?Pagament/show">Pagament</a></li>
				</ul>
			</nav>
		</div>
	</header>
