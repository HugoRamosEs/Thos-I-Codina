<?php

function sanitize($camp) {
    if (empty($camp)) {
        $camp = "";
    } else {
        $camp = trim($camp);
        $camp = strip_tags($camp);
        $camp = stripcslashes($camp);
        $camp = str_replace('%', '', $camp);
        $camp = strtolower($camp);
        $camp[0] = strtoupper($camp[0]);
        $camp = iconv('ISO-8859-1', 'UTF-8', $camp);
        $camp = htmlspecialchars(stripslashes(trim($camp, '-')));
    }
    return $camp;
}

function validar(){
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        if (isset($_POST['user']) && isset($_POST['pass'])) {
            $errors = [];
            
            if (empty($_POST['user'])) {
                $errors['user'] = "Camp de username obligatori.";
                $_POST['user'] = null;
            }
            
            if (empty($_POST['pass'])) {
                $errors['pass'] = "Camp de password obligatori.";
                $_POST['pass'] = null;
            }
            
            if (empty($errors)) {
                sanitize($_POST['user']);
                sanitize($_POST['pass']);
                echo "true";
            }else{
                echo "false";
            }
        }
    }
}
validar();
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
<link rel="stylesheet" type="text/css" media="screen"
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
<link rel="stylesheet" type="text/css" media="screen"
	href="assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="assets/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="assets/css/main.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="assets/css/style.css" />
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
					<li><a href="index.php" style="color: white">Home</a></li>
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
					<li><a href="log_in_out.php">
							<button id="sign-in-out">Sing in</button>
					</a></li>
				</ul>
			</div>
		</nav>
		<!---->
	</header>
	<!-- End Header  -->

	<div class="wrapper">
		<div class="formContainer">
			<h1>Welcome</h1>

			<form class="form" action="log_in_out.php" method="POST">
				<input type="text" placeholder="Username" id="user" name="user">
				<input type="password" placeholder="Password" id="pass" name="pass">
				<!--                 <button id="login-button"> -->
				<!--                     <div class="signupB">Sign Up</div> -->
				<!--                     <div class="singinB">Sign In </div> -->
				<!--                 </button> -->
				<button data-text-swap="Sign up" data-text-original="Sign In"
					type="submit" id="login-button">Sign In</button>
				<p class="signupLink">
					Don't have an account? &nbsp;<a>Sign up</a>
				</p>
			</form>
		</div>

		<ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>


	</div>

	<script src="assets/js/script.js"></script>
</body>
</html>




