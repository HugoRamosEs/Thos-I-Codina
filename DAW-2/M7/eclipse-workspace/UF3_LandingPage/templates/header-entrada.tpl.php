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
