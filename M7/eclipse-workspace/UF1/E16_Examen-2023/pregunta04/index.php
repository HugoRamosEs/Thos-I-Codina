<?php 
/*
 * Aquesta és la meva pàgina web, en la que apareix un script de log-in.
 * Verifica i valida les dades de log-in i si són correctes, posa el logged a 
 * true, mostrant-se el botó "logged". 
 * Si estàs loginat.... es produirà el procés de log-out
 */
include "log_in_out.php";
$logged = validar();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Toni Aguilar 2023">
    <title>Ins Thos i Codina</title>
    <link rel="shortcut icon" href="assets/images/tico_favicon.png">
    <link rel="stylesheet" media="screen"
    	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/main.css">
</head>

<body class="home">
	<header>
		<nav>
			<div id="logo-container">
				<img id="logo" src="assets/images/whitelogo.png" alt="Thos_i_Codina">
			</div>

			<div id="menu-container">
				<!---->
				<ul>
					<li><a href="#" style="color: white">Home</a></li>
					<li><a href="#">About</a></li>
					<div id="dropdown-more-pages">
						<li id="dropdown-more-pages-btn"><a href="#">More Pages <i
								class="fas fa-caret-down"></i>
						</a></li>
						<div id="dropdown-more-pages-content">
							<a href="#">Left sidebar</a> <a href="#">Right Sidebar</a>
						</div>
					</div>
					<li><a href="#"> Contact</a></li>
					<li>						
						<?php if ($logged == "false") {?>
							<a href="log_in_out.php">
							<button id="sign-in-out">Sing in</button>
							</a>
							
						<?php } else {?>
							<a href="log_in_out.php?out">
							<button id="sign-in-out">Logged</button>
							</a>
						<?php }?>			
					</li>
				</ul>
			</div>
		</nav>
		<!---->

		<div id="header-info-container">
			<div id="h-div1">
				<h1 id="h-div1-heading">Examen 2023 DAW2 UF1</h1>
				<p id="h-div1-desc">
					Molat sort 
					<a id="h-div1-desc-link" href="#">Tranquil que ho pots treure</a>
				</p>

				<div id="h-div1-btn-container">
					<button id="h-div1-moreinfo">More Info</button>
					<button id="h-div1-downlaoad">Download Now</button>
				</div>
			</div>
		</div>
	
	</header>
	<!-- End Header  -->


</body>
</html>




