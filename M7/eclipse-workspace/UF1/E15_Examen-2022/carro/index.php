<?php

// error_reporting(E_ALL);
// ini_set("display_errors", 1);

/* PREGUNTA 04
 * *index.php
 * Defineix algun sistema per comptar les vegades que un usuari ha accedit a la pàgina web.
 * Només comptarà la primera vegada que accdeix a index.php.
 */

session_start();

if (!isset($_COOKIE['comptador'])) {
    setcookie('comptador', 0, time() + (86400 * 30), '/');
}else{
    setcookie('comptador', 1, time() + (86400 * 30), '/');
}

require 'funcions.php';
require 'productes.php';
?>


<!DOCTYPE html>
<html lang="es">
<head>
    <title>PHP Shopping Cartl</title>
    <meta charset="utf-8">
    <link rel="stylesheet"	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .container {
        	padding: 20px;
        }
        
        .cart-link {
        	width: 100%;
        	text-align: right;
        	display: block;
        	font-size: 22px;
        }
    </style>
</head>

<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<ul class="nav nav-pills">
					<li role="presentation" class="active"><a href="index.php">Inici</a></li>
					<li role="presentation"><a href="veureCarro.php">Veure Carro</a></li>
					<li role="presentation"><a href="pagaments.php">Pagament</a></li>
				</ul>
			</div>
			<div class="panel-body">
				<h1>Els meus productes</h1>
				<a href="veureCarta.php" class="cart-link" title="Ver Carta"><i
					class="glyphicon glyphicon-shopping-cart"></i></a>
				<div id="products" class="row list-group">
        			<?php echo generaDivsAmbProductes($productes);?>
    			</div>
			</div>
			<div class="panel-footer">Examen M07 UF1 2022-2023</div>
			<div>Visita numero <?php echo $_COOKIE['comptador'];?></div>
		</div>
	</div>
</body>
</html>

