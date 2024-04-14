<?php
    //error_reporting(E_ALL);
    //ini_set("display_errors",1);
    
    function sanititzar($dada){
        $dada = trim($dada);
        $dada = strip_tags($dada);
        $dada = stripcslashes($dada);
        $dada = htmlspecialchars($dada);
        
        return $dada;
    }
    
    function mostrar($valor, $error){
        if (isset($valor)){
            echo "value='$valor'";
        }elseif (isset($error)){
            echo "value='$error'";
        }else{
            echo "value=''";
        }
    }
    
    if(isset($_POST["submit"]) && $_SERVER["REQUEST_METHOD"] == "POST"){
        $errors = [];
        
        if(empty($_POST["name"])){
            $errors['name'] = "Camp de nom obligatori.";
            $frm_nom = null;
        }elseif(strlen($_POST["name"]) > 20){
            $errors['name'] = "Longitud màxima excedida.";
            $frm_nom = null;
        }
        
        if(empty($_POST["email"])){
            $errors['email'] = "Camp d'email obligatori.";
            $frm_email = null;
        }elseif (!filter_var($_POST['email'], FILTER_VALIDATE_EMAIL)){
            $errors['email'] = "Formal d'email invàlid.";
            $frm_email = null;
        }
        
        if (empty($_POST['message'])) {
            $errors['message'] = "Camp de missatge obligatori.";
            $frm_missatge = null;
        }
        
        if (empty($errors)) {
            $frm_nom = sanititzar($_POST["name"]);
            $frm_email = sanititzar($_POST["email"]);
            $frm_missatge = sanititzar($_POST["message"]);
            $frm_data = date("d-m-Y");
            $frm_hora = date("H:i:s");
            $dades = [$frm_nom, $frm_email, $frm_missatge, $frm_data, $frm_hora];
            $camps = ["name", "email", "message", "date", "time"];
            
            $template = "<content>";
            for ($i = 0; $i < count($camps); $i++) {
                $template .= "<{$camps[$i]}>{$dades[$i]}</{$camps[$i]}>";
            }
            $template .= "</content>";
            
            file_put_contents("formulari.xml", $template);
            
            $frm_nom = "";
            $frm_email = "";
            $frm_missatge = "";
        }
    }
?>

<!DOCTYPE html>
<html lang="es">
<head>
   	<style>
        /* https://coolors.co/2c3e50-e74c3c-ffffff-3498db-95a3b3 */
        
        /* ========================
        Utilities
        ======================== */
        
        * {
          box-sizing: border-box;
        }
        
        .cf::before,
        .cf::after {
            content: "";
            display: table; 
        }
        
        .cf::after {
            clear: both;
        }
        
        html {
          position: relative;
        }
        
        img {
          max-width: 100%;
        }
        
        /* ========================
        Global
        ======================== */
        
        body {
          color: #444;
          font-family: Roboto, sans-serif;
          font-size: 18px;
          font-weight: 300;
          line-height: 1;
          margin: 0;
          padding: 0;
        }
        
        h1, h2, h3, h4, h5, h6, ul, ol, p {
          margin-top: 0;
        }
        
        h1 {
          font-weight: 900;
        }
        
        p {
          line-height: 1.5;
        }
        
        a, a:hover, a:focus, a:active, a:visited {
          color: #E74C3C;
          text-decoration: underline;
        }
        
        /* ========================
        Containers
        ======================== */
        
        .container-fluid {
          padding: 0 1em;
        }
        
        .container {
          margin: 0 auto;
          max-width: 996px;
        }
        
        /* ========================
        Navigation
        ======================== */
        
        @keyframes show-header {
            0% {
                top: -4em;
                opacity: 0;
            }
            100% {
                top: 0;
                opacity: 1;
            }
        }
        
        nav {
          background-color: #fff;
          box-shadow: 0 2px 2px rgba(0,0,0,.45);
          position: relative;
          top: 0;
        }
        
        nav a, nav a:hover, nav a:focus,  nav a:active, nav a:visited {
          text-decoration: none;
        }
        
        nav .brand {
          display: inline-block;
          float: left;
          font-size: 1.25em;
          font-weight: 900;
        }
        
        nav .brand a {
          color: #444;
          display: block;
          padding: 1em 0;
        }
        
        nav .nav-toggle {
          color: #444;
          cursor: pointer;
          display: inline-block;
          float: right;
          font-size: 1.25em;
          padding: 1em 0;
          z-index: 1000
        }
        
        nav ul {
          border-top: 1px solid #ccc;
          clear: both;
          list-style: none;
          margin: 0 -1em;
          padding: 0;
          z-index: 999;
        }
        
        nav ul li {
          border-bottom: 1px solid #ccc;
          text-align: center;
        }
        
        nav ul li a {
          color: #444;
          display: block;
          padding: .75em;
        }
        
        nav.sticky {
          animation: show-header .5s ease;
          position: fixed;
          top: 0;
          width: 100%;
        }
        
        /* ========================
        Sections
        ======================== */
        
        .splash {
          background: linear-gradient(rgba(44, 62, 80, 0.65), rgba(52, 152, 219, 0.65)),
        				url("img/html.png") no-repeat fixed center;
        	background-size: cover;
        	color: #fff;
        }
        
        .splash .container {
          padding-top: 25vh; /* No JS fallback*/
          padding-bottom: 25vh; /* No JS fallback*/
        }
        
        .profile-image {
          border-radius: 50%;
          display: block;
          max-width: 200px;
          margin: 0 auto 1em;
          width: 100%;
        }
        
        .splash h1 {
          font-size: 3em;
          margin-bottom: .15em;
          text-align: center;
        }
        
        .splash .lead, .splash .continue {
          display: block;
          text-align: center;
        }
        
        .splash .lead {
          font-size: 1.5em;
          font-weight: 100;
          margin-bottom: 1em;
        }
        
        .splash .continue {
          font-size: 4em;
        }
        
        .splash .continue a {
          border: 4px solid #fff;
          border-radius: 100%;
          color: #fff;
          display: inline-block;
          text-decoration: none;
          width: 80px;
        }
        .splash .continue a:hover {
          background-color: rgba(255, 255, 255, .25);
        }
        
        .intro .container, .features .container, .portfolio .container, .contact .container {
          padding: 5em 0;
        }
        
        .intro, .features, .portfolio, .contact {
          text-align: center;
        }
        
        .intro {
          background-color: #E74C3C;
          color: #fff;
        }
        
        .intro a, .intro a:hover, .intro a:focus, .intro a:active, .intro a:visited {
          color: #fff;
        }
        
        .features img {
          display: block;
          margin: 0 auto 1em;
          max-width: 200px;
          height: 150px;
        }
        
        .features .col-3 {
          margin: 3em auto;
          width: 100%;
        }
        
        .portfolio {
          background-color: #3498DB;
          color: #fff;
        }
        
        .gallery .gallery-image {
          margin: 1em auto;
          width: 100%;
        }
        
        .gallery .gallery-image img {
          background-color: #23648F;
          border-radius: 4px;
          display: block;
          height: auto;
          padding: 6px;
          width: 100%;
        }
        
        .contact form {
          background-color: #f0f0f0;
          border-radius: 4px;
          border-top: 8px solid #E74C3C;
          box-shadow: 0 1px 2px rgba(0,0,0,.15);
          padding: 1em;
          height: 400px;
        }
        
        .contact form input, .contact form textarea {
          border: none;
          border-radius: 4px;
          display: block;
          margin-bottom: 1em;
          padding: 1em;
          width: 100%;
        }
        
        .contact form textarea {
          height: 6em;
        }
        
        .contact form input[type="submit"] {
          background-color: #E74C3C;
          border-radius: 0;
          color: #fff;
          padding: 1em;
          text-transform: uppercase;
          float: left;
          font-size: 13px;
        }
        
        .contact a{
          background-color: #E74C3C;
          border: none;
          border-radius: 0;
          color: #fff;
          padding: 1em;
          text-transform: uppercase;
          text-decoration: none;
          float: right;
          width: 13.5%;
          text-decoration: none;
          font-size: 13px;
        }
        
        /* ========================
        Footer
        ======================== */
        
        .footer {
          background-color: #2C3E50;
          color:  #fff;
          font-size: 1.5em;
          text-align: center;
        }
        
        .footer .container {            
          padding: 1em 0;
        }
        
        .footer a {
          color: #fff;
          margin-right: 1em;
        }
        
        .footer a:last-of-type {
          margin-right: 0;
        }
        
        .footer p{
          font-size: 15px;
          margin-bottom: 0px;
        }
        
        /* ========================
        Media Queries
        ======================== */
        
        @media (min-width: 768px) {
          
          nav .nav-toggle {
            display: none;
          }
          
          nav ul {
            border: none;
            clear: none;
            display: inline-block !important;
            float: right;
            margin: 0;
            padding: 25px 0;
          }
          
          nav ul li {
            border: none;
            display: inline-block;
            float: left;
            margin-right: 1.5em;
          }
          
          nav ul li:last-of-type {
            margin-right: 0;
          }
          
          nav ul li a {
            padding: 0;
          }
          
          .splash h1 {
            font-size: 6em;
          }
          
          .splash .lead {
            font-size: 3em;
          }
          
          .features .col-3 {
            float: left;
            margin: 2em 5% 0 0;
            padding: 0 1em;
            width: 30%;
          }
          
          .features .col-3:last-of-type {
            margin-right: 0;
          }
          
          .gallery .gallery-image {
            float: left;
            margin-right: 2.5%;
            width: 31.6666666667%;
          }
          
          .gallery .gallery-image:nth-of-type(3n) {
            margin-right: 0;
          }
          
          .contact form {
            padding: 3em 2em 2em;
          }
          
          .contact form input[type="submit"] {
            padding: 1em 3em;
            width: auto;
          }
          
          .contact form input.full-half {
            float: left;
            margin-right: 2.5%;
            width: 48.75%;
          }
          
          .contact form input.full-half:nth-of-type(2n) {
            margin-right: 0;
          }
          
          .contact form textarea {
            height: 12em;
          }
          
        }
    </style>
</head>
<body>
    <header>
    	<nav class="container-fluid nav">
          <div class="container cf">
            <div class="brand">
              <a href="#splash">Portfoli</a>
            </div>
            <i class="fa fa-bars nav-toggle"></i>
            <ul>
              <li><a href="#about">Descripció</a></li>
              <li><a href="#skills">Habilitats i Experiència</a></li>
              <li><a href="#portfolio">Projectes</a></li>
              <li><a href="#contact">Contacte</a></li>
            </ul>
          </div>
        </nav>
    </header>
    <main>
        <div class="container-fluid splash" id="splash">
          <div class="container">
            <h1>Hugo Ramos</h1>
            <span class="lead">Desenvolupador Web</span>
          </div>
        </div>
        
        <div class="container-fluid intro" id="about">
          <div class="container">
            <h2>Descripció</h2>
            <p>Estudiant de segon any de cicle superior de desenvolupament d'aplicacions web. Apassionat per el desenvolupament de software, amb capacitat d'autoaprenentatge i dedicació. Interes per la tècnologia.</p>
          </div>
        </div>
        
        <div class="container-fluid features" id="skills">
          <div class="container cf">
            <h2>Habilitats i Experiència</h2>
            <div class="col-3">
              <img src="https://img.freepik.com/iconos-gratis
          justify-content: space-between;/servidor_318-547439.jpg?w=2000" alt="sistemes.jpg">
              <h3>Sistemes</h3>
              <p>Coneixement sobre sistemes operatius GNU Linux i Windows. Instalació i gestió, amb possible resolució d'errors.</p>
            </div>
            <div class="col-3">
              <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Number_sign.svg/640px-Number_sign.svg.png" alt="codi.png">
              <h3>Codi</h3>
              <p>Coneixement sobre llenguatges de programació, tals com Java i C#. Desenvolupament d'aplicacions simples i videojocs.</p>
            </div>
            <div class="col-3">
              <img src="https://seeklogo.com/images/W/web-icon-logo-A6B586D114-seeklogo.com.png" alt="web.png">
              <h3>Web</h3>
              <p>Coneixement sobre llenguatges per crear pàgines web, tals com HTML, CSS, JavaScript i PHP. Desenvolupament de pàgines web.</p>
            </div>
          </div>
        </div>
        
        <div class="container-fluid portfolio" id="portfolio">
          <div class="container cf">
            <h2>Projectes</h2>
            <div class="gallery">
              <div class="gallery-image"><img src="img/the_cure.png" alt=""></div>
              <div class="gallery-image"><img src="img/armansion.jpg" alt=""></div>
              <div class="gallery-image"><img src="img/hugo-utils.png" alt=""></div>
            </div>
          </div>
        </div>
        
        <div class="container-fluid contact" id="contact">
          <div class="container">
            <form action="formulari.php" method="post">
              <h2>Contacta'm</h2>
              <input type="text" placeholder="Nom..." id="name" name="name" class="full-half" required="required" <?php echo mostrar($frm_nom, $errors['name'])?>>
              <input type="email" placeholder="Email..." id="email" name="email" class="full-half" required="required" <?php echo mostrar($frm_email, $errors['email'])?>>
              <textarea placeholder="Escriu el teu missatge..." id="message" name="message" required="required" <?php echo mostrar($frm_missatge, $errors['message'])?>></textarea>
              <input type="submit" name="submit" value="Enviar">
              <a href="../E11_FormulariDeContacte/formulari.xml">XML</a>
            </form>
          </div>
        </div>
    </main>
    <footer class="container-fluid footer">
      <div class="container">
        <p>&copy; Hugo Ramos. 2023</p>
      </div>
    </footer>
</body>
</html>

