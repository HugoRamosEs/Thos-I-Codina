<body>
	<header>
		<div class="contenedor-header">
			<div id="header1">
				<p>M7 - (2023-2024)</p>
			</div>
			<div id="header2">
    			<div class="header2-class">
    				<?php echo (isset($_SESSION["login"])) ? '<a href="?Usuari/logout">Tanca Sessió</a>':'<a class="a-login" href="?Usuari/login">Inicia sessió</a>';?>
    				<?php echo (isset($_SESSION["imatge"])) ? '<img src="'.$_SESSION["imatge"].'" alt="'.$_SESSION["imatge"].'">' : "";?>
    			</div>
			</div>
			<div id="header3">
				<h1>TicketTune</h1>
				<h2>Sintonitza els teus concerts favorits!</h2>
			</div>
		</div>
		<div id="header4">
			<p>UF4 - Pràctica 3</p>
		</div>
		<div id="header5">
			<nav>
				<ul>
					<li><a href="index.php">Inici</a></li>
					<li><a href="?Service/dispatch">Venda Entrades</a></li>
				</ul>
			</nav>
		</div>
	</header>