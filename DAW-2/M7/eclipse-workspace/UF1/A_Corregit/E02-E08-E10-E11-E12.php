<?php
    // E02_Arrodonir
    $numero = 3.19324;
    $decimals = 3;
    
    $numeroSenseDecimals = (int) ($numero*pow(10, $decimals));
    $ultim = ((int) (numero*pow(10, $decimals+1)))%10;
    
    if ($ultim >= 5){
        $numeroSenseDecimals++;
    }
    
    echo $numeroSenseDecimals/pow(10,$decimals);
    
    // E03_Mates
    $a = 0;
    $b = -1;
    $c = -2;
    
    if ($a == 0){
        "No es una equació de segon grau";
    }else{
        echo "La solucio de $a x<sup>2</sup> + $b + x + $c = 0 és: <br>";
        
        $discriminant = pow ($b, 2) - 4*$a*$c;
        if ($discriminant > 0){
            echo (-$b+sqrt($discriminant))/(2*$a) . "i" . (-$b-sqrt($discriminant))/(2*$a);
        }elseif ($discriminant = 0){
            echo -$b/(2*$a);
        }else{
            echo "No hi han solucions reals";
        }
    }
    
    // E04_CalculaEdat
    $dataNaixement = date_parse("26-09-2000");
    $dataActual = getdate();
    
    $anys = $dataActual['year'] - $dataNaixement['year'];
    
    if ($dataActual['mon'] < $dataNaixement['month']){
        $anys--;
    }elseif ($dataActual['mon'] == $dataNaixement['month']){
        if ($dataActual['mday'] > $dataNaixement['day']){
            $anys--;
        }
    }
    echo "Tens $anys anys";
?>

// E05_Escacs
<html>
<body>
    <table border=10>
    	<?php 
    	   define("TAM", 15);
    	   for ($i=0; $i<TAM;$i++){
    	       echo "<tr";
    	       for ($j=1; $j<=TAM; $j++){
    	           $variable = $i * TAM + $j;
    	           if (($i + $j) % 2 == 0){
    	               $color = "grey";
    	           }else{
    	               $color = "white";
    	           }
    	           echo "<td bgcolor='$color' align='cneter'> $variable </td>";
    	       }
    	       echo "</tr>\n";
    	   }
    	?>
    </table>
</body>
</html>

<?php 
    // E06_LaBrisca
    define("PALS", array("bastos", "oros", "espadas", "copas"));
    define("VALORS", array(0,11,0,10,0,0,0,0,0,0,2,3,4));
    foreach (PALS as $value){
        for ($i=1; $i<=12; $i++){
            $baralla[] = array("pal" => $value, "numero" => $i);
        }
    }
    
    for ($i=0; $i<10; $i++){
        $clau = array_rand($baralla);
        $lesMevesCartes[] = $baralla[$clau];
        unset($baralla[$clau]);
    }
    
    echo "<pre";
    var_dump($lesMevesCartes);
    echo "</pre>";

    foreach ($lesMevesCartes as $carta){
        $suma += VALORS[$carta["numero"]];
    }
    
    echo "La suma dels meus punts es de $suma";
    
    // E07_ArraysIguals
    function areEquals($array1, $array2){
        if ($array1 === $array2){
            return true;
        }
        
        if (count($array1) !== count($array2)){
            return false;
        }
        
        foreach (array_keys($array1) as $key){
            if (!array_key_exists($key, $array2)){
                return false;
            }
        }
        
        foreach ($array1 as $key => $value){
            if ($value !== $array2[$key]){
                return false;
            }
        }
        return true;
    }
    $art1 = ["as" => [1,3,2], [2,3,3 => [1,0]]];
    $art2 = ["as" => [1,3,2], [2,3,3 => [2,1]]];
    var_dump(areEquals($art1, $art2));
    echo "hola";
    
    // E08_BuscarUnaCadena
    function stringInText ($text, $stringToFind) {
        $inici = 0;
        while ($trobat = strpos($text, $stringToFind, $inici)) {
            $resultat[] = $trobat;
            $inici = $trobat + 1;
        }
        return $resultat;
    }
    
    function countStringInText($text, $stringToFind) {
        return count(stringInText($text, $stringToFind));
    }
    
    $text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus suscipit neque lacus, id rutrum enim semper at. Quisque efficitur mollis urna, in ultrices nisl mattis quis. Ut laoreet ex non turpis egestas fermentum in id elit. Pellentesque id nulla varius neque convallis placerat. Sed in tristique lectus. Vestibulum in posuere mauris. In ac sodales magna. Ut blandit mi ut dolor fermentum efficitur. Etiam consequat velit ac nulla sodales vulputate. Aliquam ornare sapien diam, nec aliquam sem consectetur nec. Vestibulum at arcu ut metus pharetra porttitor. Nunc ultrices velit arcu, vitae ullamcorper est dapibus vel. Nullam condimentum diam id dui lobortis, sit amet aliquet risus commodo. Cras ut turpis dui. Quisque nec congue mi. Aliquam sed suscipit lorem.
             Nullam leo diam, placerat quis metus non, finibus dignissim ante. Mauris justo lacus, condimentum ut nunc id, ornare suscipit dolor. Pellentesque lobortis dolor ac tincidunt imperdiet. Donec imperdiet ipsum ipsum, ornare rhoncus tellus hendrerit eget. Donec ultrices sollicitudin erat vel faucibus. Morbi efficitur neque augue, eu bibendum libero cursus id. Phasellus placerat vehicula nunc, at tempor sapien dapibus eu. Curabitur mollis enim dolor, quis mattis massa maximus pretium. Quisque egestas aliquam dolor, sit amet tincidunt orci lacinia non. Vivamus tempus mi elit, ac pellentesque arcu tempus nec. Aenean facilisis semper enim, ultricies pulvinar enim bibendum eu. Etiam ac semper mi, eu porta ante. Aliquam erat volutpat. Maecenas ut enim pulvinar, tincidunt diam luctus, dignissim eros.
             Aenean ac enim ut magna tempus elementum et eu erat. Maecenas vel eros lorem. Morbi non pretium massa. Duis vehicula tincidunt aliquet. Donec mattis dolor sed odio mattis, nec mattis magna accumsan. Nam ultricies aliquam quam, vitae dignissim felis aliquet eget. Nam dapibus sapien nec leo porta, vitae tempus sapien finibus. Phasellus rutrum fermentum molestie. Phasellus pretium tempus sem, sit amet ornare tellus porttitor quis. In ut lacus vel arcu iaculis eleifend sed at mi. Ut diam dui, tempus vitae hendrerit vel, imperdiet sed diam. Integer posuere egestas nunc id ultrices.
             Etiam eu fringilla erat. Pellentesque cursus nunc ut eleifend placerat. Nulla convallis leo a velit vestibulum volutpat. Pellentesque a quam eget diam faucibus rhoncus nec eu nisl. Nulla facilisi. Curabitur maximus pellentesque ullamcorper. Phasellus nec sodales neque. Curabitur laoreet sollicitudin massa, sit amet posuere tellus tincidunt a. Vestibulum efficitur neque augue, in bibendum velit tristique vulputate. Vivamus interdum, ligula sit amet porta sodales, ipsum risus iaculis leo, venenatis elementum velit est at purus. Aenean faucibus ornare dui, a ornare ante. Vivamus odio ipsum, molestie at eros non, pretium eleifend urna.
             Pellentesque tellus ex, congue nec ultrices eu, suscipit sed mi. Phasellus dapibus cursus urna, a vestibulum metus. Morbi vel consequat leo. Donec ultrices, arcu at condimentum finibus, quam risus iaculis velit, sed consequat lectus massa a tellus. Curabitur orci purus, placerat et enim sit amet, commodo bibendum nibh. Nunc lacinia ut est nec vehicula. Cras ac diam eros. Phasellus non magna nisl. ";
    var_dump(countStringInText($text, "em"));
?>

<?php
// E10_ComplexitatContrasenyes
//ini_set('display_errors', 1);

define("MAJUSCULES", array("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","Z"));
define("MINUSCULES", array("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","x","y","z"));
define("NUMEROS", array("1","2","3","4","5","6","7","8","9","0"));
define("SIMBOLS", array("!","\"","ª","º","!","|","@","·", "#","$","~","%","&","¬","/","(",")","=","?","¿","¡","^","+","*","ç","¨","{","}",";",":","_",",",".","-"));


function comptar($cadena, $que){
    $numeroDAparicions = 0;

    foreach ($que as $lletra) {
        $numeroDAparicions += substr_count($cadena, $lletra);
    }
    return $numeroDAparicions;
}

function complexitat($contrasenyaAVerificar) {

    $numeroDeCaracters = strlen($contrasenyaAVerificar);
    $bonos["Número de Caràcters"] = $numeroDeCaracters * 4;
    
    $numeroDeMajuscules = comptar($contrasenyaAVerificar, MAJUSCULES);
    $bonos["Lletres Majúscules"] = ($numeroDeMajuscules==0) ? 0 : ($numeroDeCaracters - $numeroDeMajuscules) * 2;
    
    $numeroDeMinuscules = comptar($contrasenyaAVerificar, MINUSCULES);
    $bonos["Lletres minúscules"] = ($numeroDeMinuscules==0) ? 0 : ($numeroDeCaracters - $numeroDeMinuscules) * 2;
    
    $numeroDeNumeros = comptar($contrasenyaAVerificar, NUMEROS);
    $bonos["Números"] = $numeroDeNumeros * 4;
    
    $numeroDeSimbols = comptar($contrasenyaAVerificar, SIMBOLS);
    $bonos["Símbols"] = $numeroDeSimbols * 6;

    $bonos["Mitat números o símbols"] = ($numeroDeNumeros + $numeroDeSimbols) >= ($numeroDeCaracters / 2) ? ($numeroDeNumeros + $numeroDeSimbols) * 2 : 0;

    $bonos["Requeriments"] = 0;
    if ($numeroDeMajuscules > 0) {
        $bonos["Requeriments"] ++;
    }
    if ($numeroDeMinuscules > 0) {
        $bonos["Requeriments"] ++;
    }
    if ($numeroDeNumeros > 0) {
        $bonos["Requeriments"] ++;
    }
    if ($numeroDeSimbolos > 0) {
        $bonos["Requeriments"] ++;
    }
    if (($numeroDeCaracters >= 8) && ($bonos["Requeriments"]>=3)) {
        $bonos["Requeriments"] ++;
        $bonos["Requeriments"] *=2;
    } else {
		$bonos["Requeriments"] = 0;
	}

	//Deduccions
	$bonos["Només lletres"] = ($numeroDeCaracters==($numeroDeMajuscules+$numeroDeMinuscules)) ? $numeroDeCaracters * -1 : 0;
	$bonos["Només numeros"] = ($numeroDeCaracters==$numeroDeNumeros) ? $numeroDeCaracters * -1 : 0;
	
	$caractersRepetits = 0;
	for ($i=0; $i < strlen($contrasenyaAVerificar); $i++) {
	    if (comptar(strtoupper($contrasenyaAVerificar), array(strtoupper($contrasenyaAVerificar[$i]))) > 1) {
	        $caractersRepetits++;
	    }
	}
	$bonos["Caràcters Repetits (no case-sensitive)"] = $caractersRepetits * -1;
	
	$numeroDeLletresMajusculesConsecutives = 0;
	for ($i=0; $i < strlen($contrasenyaAVerificar); $i++) {
	    if (in_array($contrasenyaAVerificar[$i], MAJUSCULES) && in_array($contrasenyaAVerificar[$i+1], MAJUSCULES)) {
	        $numeroDeLletresMajusculesConsecutives++;
	    }
	}
	$bonos["Lletres majúscules consecutives"] = $numeroDeLletresMajusculesConsecutives * -2;
	
	$numeroDeLletresMinusculesConsecutives = 0;
	for ($i=0; $i < strlen($contrasenyaAVerificar); $i++) {
	    if (in_array($contrasenyaAVerificar[$i], MINUSCULES) && in_array($contrasenyaAVerificar[$i+1], MINUSCULES)) {
	        $numeroDeLletresMinusculesConsecutives++;
	    }
	}
	$bonos["Lletres minúscules consecutives"] = $numeroDeLletresMinusculesConsecutives * -2;
	
	$numeroDeNumerosConsecutius = 0;
	for ($i=0; $i < strlen($contrasenyaAVerificar); $i++) {
	    if (in_array($contrasenyaAVerificar[$i], NUMEROS) && in_array($contrasenyaAVerificar[$i+1], NUMEROS)) {
	        $numeroDeNumerosConsecutius++;
	    }
	}
	$bonos["Numeros consecutius"] = $numeroDeNumerosConsecutives * -2;
	
	
	$numeroDeSequenciaDeLletres = 0;
	for ($i=0; $i < strlen($contrasenyaAVerificar); $i++) {
	    if (($pos = array_search(strtoupper($contrasenyaAVerificar[$i]), MAJUSCULES)) !== false) {
	        if (strtoupper($contrasenyaAVerificar[$i+1]) === MAJUSCULES[$pos+1] &&	strtoupper($contrasenyaAVerificar[$i+2]) === MAJUSCULES[$pos+2] ) {
	            $numeroDeSequenciaDeLletres++;
	        }
	    }
	}
	$bonos["Seqüencies de lletres (3+)"] = $numeroDeSequenciaDeLletres * -3;
	
	$numeroDeSequenciaDeNumeros = 0;
	for ($i=0; $i < strlen($contrasenyaAVerificar); $i++) {
	    if (($pos = array_search($contrasenyaAVerificar[$i], NUMEROS)) !== false) {
	        if ($contrasenyaAVerificar[$i+1] === NUMEROS[$pos+1] &&	$contrasenyaAVerificar[$i+2] === NUMEROS[$pos+2] ) {
	            $numeroDeSequenciaDeNumeros++;
	        }
	    }
	}
	$bonos["Seqüencies de numeros (3+)"] = $numeroDeSequenciaDeNumeros * -3;
	
	foreach ($bonos as $key => $valor) {
	    $suma += $valor;
	}
	$bonos["TOTAL"] = $suma;
	
    return $bonos;
}

function nivell($valor) {
  
    if ($valor <= 20) {
        return "MOLT DEBIL";
    } elseif ($valor < 40) {
        return "DEBIL";
    } elseif ($valor < 60) {
        return "BONA";
    } elseif ($valor <= 80 ) {
        return "FORTA";
    } else {
        return "MOLT FORTA";
    }
}

function generaHtml($array) {
    $taula = "<table><tr><td>Adiciones</td><td>Bonos</td></tr>\n";
    
    foreach ($array as $adicion => $bono) {
        $taula .= "<tr><td>$adicion</td><td>$bono</td></tr>\n";
    }
    $taula .= "</table>";
    return $taula;
}


if (isset($_GET["Genera"])) {
    $cts="";
    //Genero una contrasenya entre 0 i 18 caràcters
    $numeroDeCaracters = rand(1,18);
    
    //Valors possibles
    $valorsPossibles = array_merge(MINUSCULES,MAJUSCULES,NUMEROS,SIMBOLS);
    for ($i=0 ; $i<$numeroDeCaracters; $i++) {
        $aleatori = rand(0,sizeof($valorsPossibles)-1);
        $cts .= $valorsPossibles [$aleatori];
    }
} elseif (isset($_GET["pass"])) {
    $cts = $_GET["pass"];
}


$res = complexitat($cts);
$total = $res["TOTAL"];
$nivell = nivell($total);

?>

<!DOCTYPE html>
<html lang="es">
<head>
    <style>
        table, form {
            margin: 0 auto;
        }
    </style>
</head>
<body>
	<form action="index.php" method="get">		
		<input type="text" name="pass" value="<?php echo $cts; ?>" />
		<input type="submit" value="Send Request" />
		<input type="submit" name="Genera" value="Genera" />
		<br>
		<label for="file">Complexitat:</label>
			<progress id="file" value="<?php echo $total?>" max="200"></progress> <span><?php echo "$total $nivell";?></span>
	</form>
		<?php 
		echo generaHtml($res);	
		?>
</body>
</html>

<?php
// E11_FormulariDeContacte
// error_reporting(E_ALL);
// ini_set("display_errors", 1);

include_once 'functions.php';
include_once 'language.php';

if ($_SERVER["REQUEST_METHOD"]=="POST" && (isset($_POST["boto"]))) {
    $frmNom = sanitize($_POST["nom"],4);
    $frmMail = sanitize($_POST["email"],1);
    $frmMsg = sanitize($_POST["missatge"],3);
    
    if (strlen($frmNom)==0) {
        $errors["nom"] = "Has d'informar un nom";
    }
    if (!filter_var($frmMail, FILTER_VALIDATE_EMAIL)) {
        $errors["mail"] = "L'adreça de correu no és vàlida";
    }
    if (strlen($frmMsg)==0) {
        $errors["missatge"] = "Has d'escriure el comentari que vols enviar";
    }
    
    if (!isset($errors)) {
        if ($sFile = file_get_contents("missatgesDeContacte.xml")) {
            $sLlibre = substr($sFile,0,-13);
            $sData = getdate();
            $sLlibre .= "\n    <REGISTRE>\n        <DATA>".$sData['mday']."/".$sData['mon']."/".$sData['year']."</DATA>\n";
            $sLlibre .="        <NOM>$frmNom</NOM>\n        <MAIL>$frmMail</MAIL>\n";
            $sLlibre .= "        <COMENTARI>$frmMsg</COMENTARI>\n    </REGISTRE> \n";
            $sLlibre .= "</REGISTRES>";
            if ($file = fopen("missatgesDeContacte.xml", "w")) {
                if (!fputs($file,$sLlibre)) {
                    die ("El fitxer no deixa escriure");
                }
                fclose($file);
            } else {
                die ("No s'ha pogut obrir el fitxer per emmagatzemar informació");
            }
            unset($frmNom);
            unset($frmMail);
            unset($frmMsg);
            $missatgeOK="El comentari s'ha enviat correctament";
        }
    }
}

?>

<html lang="en">
<head>
<meta charset="UTF-8">
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
<title>Thos i Codina M07 UF1</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<section class="one">
		<div class="logo">
			<logomenu>
			<ul>
				<li class="logo">Thos i Codina</li>
				<li>M07</li>
				<li>UF1</li>
				<li>2020-2021</li>
			</ul>
			</logomenu>
			<infosmenu>
			<ul>
				<a href='contacte.php'>
					<li><?php echo $mainContacta;?></li>
				</a>

				<a href='index.php'>
					<li class="btn"><?php echo $mainLog_in;?></li>
				</a>

			</ul>
			</infosmenu>
		</div>
		<div class="bighero">
			<h1><?php echo $mainTitol;?></h1>
			<p><?php echo $mainSubTitol;?></p>
		</div>
		<div class="lang">
			<infosmenu>
			<ul>
				<div id="catala" <?php echo (isset($html_opacityLang["ca"]))?$html_opacityLang["ca"]:""; ?>>
					<a href='index.php?lang=ca'><li class="btn"><?php echo $mainLangCA; ?></li></a>
				</div>
				<div id="euzkera" <?php echo (isset($html_opacityLang["eu"]))?$html_opacityLang["eu"]:""; ?>>
					<a href='index.php?lang=eu'><li class="btn"><?php echo $mainLangEU; ?></li></a>
				</div>
				<div id="castella" <?php echo (isset($html_opacityLang["es"]))?$html_opacityLang["es"]:""; ?>>
					<a href='index.php?lang=es'><li class="btn"><?php echo $mainLangES; ?></li></a>
				</div>
				<div id="angles" <?php echo (isset($html_opacityLang["en"]))?$html_opacityLang["en"]:""; ?>>
					<a href='index.php?lang=en'><li class="btn"><?php echo $mainLangEN; ?></li></a>
				</div>
				<div id="frances" <?php echo (isset($html_opacityLang["fr"]))?$html_opacityLang["fr"]:""; ?>>
					<a href='index.php?lang=fr'><li class="btn"><?php echo $mainLangFR; ?></li></a>
				</div>
				<div id="alemany" <?php echo (isset($html_opacityLang["ge"]))?$html_opacityLang["ge"]:""; ?>>
					<a href='index.php?lang=ge'><li class="btn"><?php echo $mainLangGE; ?></li></a>
				</div>
			</ul>
			</infosmenu>
		</div>
	</section>
	<section class="menu">
		<div class="list">
			<a href='index.php'>
				<div class="imgMenu"><?php echo $mainMenu1;?></div>
			</a>			
			<div class="imgMenu"><?php echo $mainMenu2;?></div>
			<div class="imgMenu"><?php echo $mainMenu3;?></div>
			<div class="imgMenu"><?php echo $mainMenu4;?></div>
			<div class="imgMenu"><?php echo $mainMenu5;?></div>
		</div>
	</section>
	<section class="infos">
		<div class="content">
			<div class="grid">
				<div class="float-md-50 wimg">
					<img src="img/contacte.jpg" />
				</div>
				<div class="winfo">
					<h1 class="title"><?php echo $contacteForm;?></h1>
					<p class="form">
						<form action="contacte.php" method="post" target=_blank">
    						<input type="text" name="nom" placeholder="<?php echo $contacteNom;?>" value="<?php echo $frmNom; ?>">
    						<span class="error"><?php echo $errors["nom"];?></span>
    						<input type="text" name="email" placeholder="<?php echo $contacteMail;?>" value="<?php echo $frmMail; ?>">
    						<span class="error"><?php echo $errors["mail"];?></span>
    						<textarea name="missatge" placeholder="<?php echo $contacteMsg;?>"><?php echo $frmMsg; ?></textarea>
    						<span class="error"><?php echo $errors["missatge"];?></span>
    						<p class="description"><?php echo $missatgeOK;?></p>
    						<input type="submit" name="boto" value="<?php echo $contacteEnviar;?>" class="btn">
						</form>
					</p>
				</div>


			</div>
		</div>
	</section>
	<section class="footer">			
		<a href="http://www.iesthosicodina.cat" alt="Institut Thos i Codina" title="Institut Thos i Codina" target="_blank">
		<img src="https://aulavirtual.iesthosicodina.cat/moodle/theme/academi/pix/whitelogo.png"></a>
		<p>Riera de Cirera, 57 - 08304, Mataró</p>
		<p>Telèfon: 937 414 203</p>
		<p><a href="http://www.iesthosicodina.cat" target="_blank">http://www.iesthosicodina.cat</a></p>				
		<p><a href="http://www.iesthosicodina.cat/contacte/" target="_blank">Contacteu amb el centre</a></p>
	</section>
</body>
</html>

<?php 
/* E12: Web scraping.
 * Web scraping (de l'anglès to scrap 'rasclar') és una tècnica de programari o
 * software informàtic per extreure informació dels llocs web. En general, aquest
 * tipus de programes de software simulen l'exploració humana del World Wide Web,
 * ja sigui amb la implementació de baix nivell de protocol de transferència
 * d'hipertext (HTTP), o amb la incorporació d'un navegador web.
 * El web scraping està molt relacionat amb la indexació de la web, que indexa
 * informació de la web utilitzant un robot. Aquesta tècnica és una tècnica
 * universal adoptada per la majoria dels motors de cerca. Per contra, el web scraping
 * es centra més en la transformació de les dades no estructurades al web,
 * generalment en format HTML, en dades estructurades que poden ser emmagatzemades
 * i analitzades en una base de dades local, central o de full de càlcul.
 * El web scraping també està relacionat amb l'automatització del web, que simula
 * la navegació humana utilitzant software d'ordinador. Algun dels usos principals
 * del web scraping són la comparació de preus en botigues, monitorar dades
 * relacionades amb el clima de certa regió, detectar canvis en llocs webs o la
 * integració de dades en llocs web.
 * En aquesta pràctica simularem aquesta tècnica i capturarem cotitzacions d'accions
 * del mercat continu de valors.Per això farem servir la pàgina web d'Inversis
 * (https://www.inversis.com/inversiones/productos/cotizaciones-nacionales&pathMenu=3_1_0_0&esLH=N)
 * Ens interesa generar un array associatiu amb tota la informació:
 */

function isElementSimple($element) {
    $numeroDAparicions = substr_count($element, "<");
    return ($numeroDAparicions <= 2);
}

function extreuContingut($element, $etiqueta) {
    do {
        if (isElementSimple($element)) {
            $finalEtiquetaApertura = strpos($element,">",0);
            $iniciEtiquetaTancament = strpos($element,"<",$finalEtiquetaApertura);
            $longitud = $iniciEtiquetaTancament-$finalEtiquetaApertura-1;
            return ($longitud<0) ? "" : trim(substr($element,$finalEtiquetaApertura+1,$longitud)) ;
        } else {
            
            //Busquem l'etiqueta interna. El sub-element
            $iniciSubElement = strpos($element,"<", 1) + 1;
            $blancFiSubElement = strpos($element," ",$iniciSubElement);
            $majorFiSubElement = strpos($element,">",$iniciSubElement);
            $fiSubElement = ($blancFiSubElement != FALSE && $blancFiSubElement < $majorFiSubElement) ? $blancFiSubElement : $majorFiSubElement;
            
            $longitudEtiqueta = $fiSubElement - $iniciSubElement;
            $etiqueta = substr($element, $iniciSubElement, $longitudEtiqueta);
            
            $iniciElementIntern = strpos($element, "<$etiqueta", 0);
            $fiElementIntern = strpos($element, "</$etiqueta>", $iniciElementIntern);
            if ($fiElementIntern == FALSE) {
                $fiElementIntern = strpos($element, ">", $iniciElementIntern) + 1;
            }
            $elementIntern = substr($element, $iniciElementIntern, $fiElementIntern - $iniciElementIntern + strlen($etiqueta));
            $resultat = extreuContingut($elementIntern, $etiqueta);
            
            if (empty($resultat)) {
                // elimino el subelement
                $element = str_replace($elementIntern, "", $element);
            }
            
        }
    } while (empty($resultat));
    return $resultat;
}

function extreureFila($element) {
    //Camp nom
    $inici = strpos($element, '<td ', 0);
    $fi = strpos($element, '</td>', $inici) + 5;
    $td = trim(substr($element, $inici, $fi-$inici));
    $text = extreuContingut($td, "td");
    $resultat["nom"] = $text;
    
    //ticker
    $inici = strpos($element, '<td', $fi);
    $fi = strpos($element, '</td>', $inici) + 5;
    $td = trim(substr($element, $inici, $fi-$inici));
    $text = extreuContingut($td, "td");
    $resultat["ticker"] = $text;
    
    //mercat
    $inici = strpos($element, '<td', $fi);
    $fi = strpos($element, '</td>', $inici) + 5;
    $td = trim(substr($element, $inici, $fi-$inici));
    $text = extreuContingut($td, "td");
    $resultat["mercat"] = $text;
    
    //no tracto
    $inici = strpos($element, '<td', $fi);
    $fi = strpos($element, '</td>', $inici);
    
    //Ultima cotitzacio
    $inici = strpos($element, '<td ', $fi);
    $fi = strpos($element, '</td>', $inici) + 5;
    $td = trim(substr($element, $inici, $fi-$inici));
    $text = extreuContingut($td, "td");
    $resultat["ultima_coti"] = $text;
    
    //Divisa
    $inici = strpos($element, '<td ', $fi);
    $fi = strpos($element, '</td>', $inici) + 5;
    $td = trim(substr($element, $inici, $fi-$inici));
    $text = extreuContingut($td, "td");
    $resultat["divisa"] = $text;
    
    //Variació
    $inici = strpos($element, '<td ', $fi);
    $fi = strpos($element, '</td>', $inici) + 5;
    $td = trim(substr($element, $inici, $fi-$inici));
    $text = extreuContingut($td, "td");
    $resultat["variacio"] = $text;
    
    //Variació percentual
    $inici = strpos($element, '<td ', $fi);
    $fi = strpos($element, '</td>', $inici) + 5;
    $td = trim(substr($element, $inici, $fi-$inici));
    $text = extreuContingut($td, "td");
    $resultat["variacio_percent"] = $text;
    
    //Volum
    $inici = strpos($element, '<td ', $fi);
    $fi = strpos($element, '</td>', $inici) + 5;
    $td = trim(substr($element, $inici, $fi-$inici));
    $text = extreuContingut($td, "td");
    $resultat["volum"] = $text;
    
    //Minim
    $inici = strpos($element, '<td ', $fi);
    $fi = strpos($element, '</td>', $inici) + 5;
    $td = trim(substr($element, $inici, $fi-$inici));
    $text = extreuContingut($td, "td");
    $resultat["mínim"] = $text;
    
    //Màxim
    $inici = strpos($element, '<td ', $fi);
    $fi = strpos($element, '</td>', $inici) + 5;
    $td = trim(substr($element, $inici, $fi-$inici));
    $text = extreuContingut($td, "td");
    $resultat["màxim"] = $text;
    
    //Data
    $inici = strpos($element, '<td ', $fi);
    $fi = strpos($element, '</td>', $inici) + 5;
    $td = trim(substr($element, $inici, $fi-$inici));
    $text = extreuContingut($td, "td");
    $resultat["data"] = $text;
    
    //Hora
    $inici = strpos($element, '<td ', $fi);
    $fi = strpos($element, '</td>', $inici) + 5;
    $td = trim(substr($element, $inici, $fi-$inici));
    $text = trim(extreuContingut($td, "td"));
    $resultat["hora"] = substr($text,0, 5);
    
    return $resultat;
}


$ruta = "https://www.inversis.com/inversiones/productos/cotizaciones-nacionales&pathMenu=3_1_0_0&esLH=N";
$contingut = file_get_contents($ruta);
$pos = 0;

while (($posIni = strpos($contingut, "<tr id=\"tr_", $pos)) !== FALSE ){
    $posFi = strpos($contingut, "</tr>", $posIni);
    $contingutDeTR = substr($contingut,$posIni, $posFi-$posIni );
    
    $taulaResultat = extreureFila($contingutDeTR);
    $ibex[] = $taulaResultat;
    $pos = $posFi;
}

var_dump($ibex);
?>
