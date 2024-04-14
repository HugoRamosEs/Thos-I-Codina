<?php
    //error_reporting(E_ALL);
    //ini_set('display_errors', 1);
    if (isset($_COOKIE["idioma"])){
        $idioma = $_COOKIE["idioma"];
    }else {
        $idioma = "CAT";
    }
    
    if (isset($_GET["inicials"])) {
        $idioma = $_GET["inicials"];
        setcookie("idioma", $idioma, time() + 31536000);
    }
    
    $fitxer = $idioma . '_traduccions.php';
    if (file_exists($fitxer)) {
        include($fitxer);
    }
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Landing Page - Hugo Ramos</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <div class="contenedor">
            <h1>Landing Page</h1>
            <nav>
                <ul>
                    <li><a href="#personal"><?php echo $traduccio["personal"]?></a></li>
                    <li><a href="#habilitats"><?php echo $traduccio["habilitats"]?></a></li>
                    <li><a href="#projectes"><?php echo $traduccio["projectes"]?></a></li>
                    <li><a href="formulari.php"><?php echo $traduccio["contacte"]?></a></li>
                </ul>
            </nav>
        </div>
    </header>

    <div class="contenedor">
        <main>
        	<form id="idiomes" method="get" action="landing_page.php">
        		<label><?php echo $traduccio["idiomes"]?></label>
        		<div class="idioma-cont">
        			<input type="submit" name="inicials" value="CAT" <?php echo ($idioma === "CAT") ? 'class="seleccionat"' : ""; ?>>
                    <input type="submit" name="inicials" value="ESP" <?php echo ($idioma === "ESP") ? 'class="seleccionat"' : ""; ?>>
                    <input type="submit" name="inicials" value="EN" <?php echo ($idioma === "EN") ? 'class="seleccionat"' : ""; ?>>
                    <input type="submit" name="inicials" value="FR" <?php echo ($idioma === "FR") ? 'class="seleccionat"' : ""; ?>>
                    <input type="submit" name="inicials" value="GER" <?php echo ($idioma === "GER") ? 'class="seleccionat"' : ""; ?>>
        		</div>
            </form>
            <div id="personal">
                <h2><?php echo $traduccio["personal"]?></h2>
                <h3>Hugo Ramos</h3>
                <h4><?php echo $traduccio["desenvolupador"]?></h4>
                <article>
                    <p><?php echo $traduccio["desc1"]?></p>
                </article>
            </div>
            <div id="habilitats">
                <h2><?php echo $traduccio["habilitats"]?></h2>
                <div id="habilitats-css">
                    <div class="element">
                        <img alt="sistemes.png" src="img/sistemes.png">
                        <p><?php echo $traduccio["coneix1"]?></p>
                    </div>
                    <div class="element">
                        <img alt="codi.png" src="img/codi.png">
                        <p><?php echo $traduccio["coneix2"]?></p>
                    </div>
                    <div class="element">
                        <img alt="web.png" src="img/web.png">
                        <p><?php echo $traduccio["coneix3"]?></p>
                    </div>
                </div>
            </div>
            <div id="projectes">
                <h2><?php echo $traduccio["projectes"]?></h2>
                <article>
                    <figure>
                        <img alt="e13.png" src="img/e13.png">
                    </figure>
                    <h3>E13_Cotitzacions</h3>
                    <h4>(29 oct. 2023)</h4>
                    <p><?php echo $traduccio["desc2"]?></p>
                    <a href="cotitzacions.php"><?php echo $traduccio["visualitzar"]?></a>
                </article>

                <article>
                    <figure>
                        <img alt="e11.png" src="img/e11.png">
                    </figure>
                    <h3>E11_Formulari</h3>
                    <h4>(15 oct. 2023)</h4>
                    <p><?php echo $traduccio["desc3"]?></p>
                    <a href="formulari.php"><?php echo $traduccio["visualitzar"]?></a>
                </article>
            </div>
        </main>
    </div>

    <footer>
        <div class="contenedor">
            <div class="element">
                <h3><?php echo $traduccio["contacte"]?></h3>
                <p>hramosthosi@gmail.com</p>
            </div>
            <div class="element">
                <h3><?php echo $traduccio["legal"]?></h3>
                <p><?php echo $traduccio["drets"]?>. 2023<br>
                    &copy; Hugo Ramos
                </p>
            </div>
        </div>
    </footer>
</body>
</html>