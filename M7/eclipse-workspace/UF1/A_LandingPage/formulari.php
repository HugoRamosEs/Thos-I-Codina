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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E11_Formulari - Hugo Ramos</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body class="pagines_externes">
    <header>
        <div class="contenedor">
            <h1>Landing Page</h1>
            <nav>
                <ul>
                    <li><a href="landing_page.php">Pàgina Principal</a></li>
                </ul>
            </nav>
        </div>
    </header>
    
     <div class="contenedor">
        <main>
            <div>
                <h2>E11_Formulari</h2>
                <div id="formulari">
                	<form action="formulari.php" method="post" >
                     <h2>Contacta'm</h2>
                     <input type="text" placeholder="Nom..." id="name" name="name" class="full-half" required="required" <?php echo mostrar($frm_nom, $errors['name'])?>>
                     <input type="email" placeholder="Email..." id="email" name="email" class="full-half" required="required" <?php echo mostrar($frm_email, $errors['email'])?>>
                     <textarea placeholder="Escriu el teu missatge..." id="message" name="message" required="required" <?php echo mostrar($frm_missatge, $errors['message'])?>></textarea>
                     <input type="submit" name="submit" value="Enviar">
                     <a href="formulari.xml">XML</a>
            		</form>
                </div>
            </div>
        </main>
    </div>
    
     <footer class="footer_paginas_externes">
        <div class="contenedor">
            <div class="element">
                <h3>Contacte</h3>
                <p>hramosthosi@gmail.com</p>
            </div>
            <div class="element">
                <h3>Legal</h3>
                <p>Tots els drets reservats. 2023<br>
                    &copy; Hugo Ramos
                </p>
            </div>
        </div>
    </footer>
</body>
</html>

