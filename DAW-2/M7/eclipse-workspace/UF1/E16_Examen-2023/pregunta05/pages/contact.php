<?php 
if (isset($_SERVER['REQUEST_METHOD'])) {
    if (isset($_POST)) {
 
        if ($data = file_get_contents('/pregunta05/data/data.xml')) {
            $data = $sLlibre = substr($sFile,0,-13);
        } else {
            $data = "<contactes>";
        }
        $sData = getdate();
//         $data.= "<registre><nom>$_POST['NAME']</nom><mail>$_POST['MAIL']</mail>";
//         $data.= "<missatge>$_POST['MISSATGE']</missatge><data>$sData</data></registre>";
        $data="</registres>";
        file_put_contents('/pregunta05/data/data.xml', $data);     
    }
}




?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>M07 UF1 2023 Thos i Codina</title>
	<link rel="shortcut icon" href="/assets/images/tico_favicon.png">
    
    <link href='https://fonts.googleapis.com/css?family=Lato:400,100,300' rel='stylesheet' type='text/css'>
    <link href="https://fonts.googleapis.com/css?family=Raleway:100,400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Oswald:200,400,700"	rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://use.fontawesome.com/20ab91acc4.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href='//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css' rel='stylesheet'>

    <link rel="stylesheet" href="/assets/css/style.css">
</head>
<body>
	<section id="contact">
		<h1 class="section-header">Contacte</h1>
		<div class="contact-wrapper">
<!-- Left contact page -->
			<form id="contact-form" class="form-horizontal" role="form">
				<div class="form-group">
					<div class="col-sm-12">
						<input type="text" class="form-control" id="name"
							placeholder="El teu nom (dada obligatòria)" required>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-12">
						<input type="email" class="form-control" id="email"
							placeholder="El teu email (dada obligatòria)" required>
					</div>
				</div>

				<textarea class="form-control" rows="10" placeholder="Comentan's el que necessites"
					required></textarea>

				<button class="btn btn-primary send-button" id="submit"
					type="submit" value="SEND">
					<div class="alt-send-button">
						<i class="fa fa-paper-plane"></i><span class="send-text">SEND</span>
					</div>

				</button>
			</form>

<!-- Rigth contact page -->

			<div class="direct-contact-container">
				<ul class="contact-list">
					<li class="list-item"><i class="fa fa-map-marker fa-2x"><span
							class="contact-text place">Riera Cirera 57<br/>08304 Mataró, Barcelona</span></i></li>
					<li class="list-item"><i class="fa fa-phone fa-2x"><span
							class="contact-text phone"><a href="tel:1-212-555-5555"
								title="Give me a call">(+34) 937 414 203</a></span></i></li>
					<li class="list-item"><i class="fa fa-envelope fa-2x"><span
							class="contact-text gmail"><a href="mailto:#"
								title="Send me an email">cantacte@iesthosicodina.cat</a></span></i></li>
				</ul>
				<hr>
				<ul class="social-media-list">
					<li><a href="#" target="_blank" class="contact-icon"> <i
							class="fa fa-github" aria-hidden="true"></i></a></li>
					<li><a href="#" target="_blank" class="contact-icon"> <i
							class="fa fa-codepen" aria-hidden="true"></i></a></li>
					<li><a href="#" target="_blank" class="contact-icon"> <i
							class="fa fa-twitter" aria-hidden="true"></i></a></li>
					<li><a href="#" target="_blank" class="contact-icon"> <i
							class="fa fa-instagram" aria-hidden="true"></i></a></li>
				</ul>
				<hr>

				<div class="copyright">&copy; ALL OF THE RIGHTS RESERVED</div>
			</div>
		</div>

	</section>
	<!-- partial -->
	<script
		src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script
		src='//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
	<script src="./script.js"></script>

</body>
</html>
