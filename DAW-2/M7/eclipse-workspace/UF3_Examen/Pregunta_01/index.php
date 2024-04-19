<?php
// error_reporting(E_ALL);
// ini_set("display_errors", 1);

// include 'classes/Usuari.php';
// include 'classes/Info.php';
// include 'classes/Habilitat.php';
// include 'classes/Experiencia.php';
// include 'classes/Estudi.php';

// include 'classes/Model.php';
// include 'classes/InfoModel.php';
// include 'classes/HabilitatsModel.php';
// include 'classes/ExperienciaModel.php';
// include 'classes/EstudiModel.php';

include "classes/config/autoloader.class.php";
spl_autoload_register("Autoloader::load");

use curriculum\EstudiModel;
use curriculum\ExperienciaModel;
use curriculum\InfoModel;
use curriculum\Usuari;
use curriculum\HabilitatsModel;

$usuari = new Usuari();
$usuari->setId(1);
$usuari->setNom("Toni");
$usuari->setCognom("Aguilar");
$usuari->setDescripcio('<p>Soc Juan Antonio Aguilar Amo, professor de l\'Institut Thos i Codina 
i he preparat aquest examen perque puguis desmostrar-me tot el que saps fer.</p><p>Em considero 
una persona autodidacta, amb moltes inquietuds, molt polida i ordenada quant als meus codis es 
refereix i també molt perfecionista amb la meva feina.</p><p>M\'agrada el tracte amb la gent 
i sobretot ensenyar i transmetre coneixement</p>');

$usuari->setInfo((new InfoModel())->getByUser($usuari));
$usuari->setHabilitats((new HabilitatsModel())->getByUser($usuari));
$usuari->setExperiencia((new ExperienciaModel())->getByUser($usuari));
$usuari->setEstudis((new EstudiModel())->getByUser($usuari));
?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Thos i Codina 2024 M07 UF3</title>
	<!--  
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
	<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>	
	<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css'>
	 -->
	
	<link rel="stylesheet" href="./css/reset.min.css">
	<link rel='stylesheet' href='./css/bootstrap.min.css'>
	<link rel='stylesheet' href='./css/font-awesome.min.css'>
	
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<!-- partial:index.partial.html -->
	<div class="cv container">
		<div class="row">
			<aside class="col-md-4">
				<img class="img-circle" src="./uploads/f1.jpg">
				<h2>
					<span>
					<?php echo $usuari->getNom();?>
					</span>
					<?php echo $usuari->getCognom();?>
				</h2>
				<?php echo $usuari->getDescripcio();?>
				<ul class="info">
				<?php 
				foreach ($usuari->getInfo() as $value) {
				    echo "<li><a href=\"#\"><i class=\"fa {$value->getFa()}\"></i> {$value->getDada()}</a></li>";
				}
				?>
				</ul>
			</aside>
			<div class="col-md-8">
				<h1>Habilitats</h1>
				<div class="row skills">
					
					<?php 
					$items = (int) (count($usuari->getHabilitats()) / 3);
					$itemQuePinto = 0;
					
					foreach ($usuari->getHabilitats() as $value) {
					    if ($itemQuePinto%$items == 0) echo "<div class=\"col-md-4\">";
					    $itemQuePinto++;
					    echo "<section><p>{$value->getCategoria()}</p>";
					    for ($i=5; $i>=1 ; $i--) {
					       if ($value->getValoracio() < $i) echo "<span></span>";
					       else echo "<span class=\"full\"></span>";
					    }
					    echo "</section>";
					    if ($itemQuePinto%$items == 0 || count($usuari->getHabilitats()) == $itemQuePinto) echo "</div>";
					}
					?>
				</div>

				<h1>Experiència</h1>
				
				<?php 
				foreach ($usuari->getExperiencia() as $value) {
				    echo "<section>
					<h3>{$value->getEmpresa()} ({$value->getPeriode()})</h3>
					<h4>{$value->getCarrec()}</h4>
					{$value->getDescripcio()}
				    </section>";
				}
				?>

				<h1>Estudis</h1>
				
				<?php 
				foreach ($usuari->getEstudis() as $value) {
				    echo "<section>
					<h3>{$value->getAny()} - {$value->getTitol()}</h3>
					{$value->getDescripcio()}</section>";				    
				}
				?>

			</div>
		</div>
	</div>
	<!-- partial -->

</body>
</html>
