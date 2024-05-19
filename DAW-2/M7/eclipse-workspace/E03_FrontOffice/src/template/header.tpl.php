<body class="body-ticket">
	<header>
		<div class="header-login">
		    <p>M7 - 2023/2024</p>
		    <p>UF4 - Pràctica 3<p>
			<?php echo (isset($_SESSION["login"])) ? '<a href="?User/logout" class="button">Tancar Sessió</a>':'<a href="?User/login" class="button">Iniciar Sessió</a>';?>
		</div>
		<h1>TicketTune</h1>
		<h2>Sintonitza els teus concerts favorits!</h2>
		<nav>
			<ul>
				<li><a href="index.php">Inici</a></li>
				<li><?php echo (isset($_SESSION["login"])) ? '<a href="?Venda/form">Venda Entrades</a>':'<a href="?User/login">Venda Entrades</a>';?></li>
				<li><?php echo (isset($_SESSION["login"])) ? '<a href="?User/modify">Perfil</a>':'';?></li>
			</ul>
		</nav>
	</header>