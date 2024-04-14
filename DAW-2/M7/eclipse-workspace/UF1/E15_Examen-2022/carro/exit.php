<?php
if (! isset($_REQUEST['id'])) {
    header("Location: index.php");
}
?>


<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Comanda Completada - PHP Carro de Compres</title>
    <meta charset="utf-8">
    <style>
        .container {
        	padding: 20px;
        }
        
        p {
        	color: #34a853;
        	font-size: 18px;
        }
    </style>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">

				<ul class="nav nav-pills">
					<li role="presentation"><a href="index.php">Inici</a></li>
				</ul>
			</div>
			<div class="panel-body">
				<h1>Estat de la comanda</h1>
				<p>La teva comanda ha sigut enviada correctament. L'ID de la comanda és #<?php echo $_GET['id']; ?></p>
				<p>.... i t'ha sortit gratis perquè és el dia del Thos !!!!!</p>
			</div>
			<div class="panel-footer">Examen M07 UF1 2022-2023</div>
		</div>
	</div>
</body>
</html>