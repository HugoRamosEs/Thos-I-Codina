<?php
    //error_reporting(E_ALL);
    //ini_set("display_errors", 1);
    
    $contrasenya = $_POST["passwordPwd"];
    
    function contarCaracters($contrasenya){
        return strlen($contrasenya);
    }
    
    function contarCaractersBonus($contrasenya){
        return contarCaracters($contrasenya) * 4;
    }
   
    function contarMajuscules($contrasenya){
        $contador = 0;
        for ($i = 0; $i < strlen($contrasenya); $i++) {
            if (ctype_upper($contrasenya[$i])) {
                $contador++;
            }
        }
        return $contador;
    }
    
    function contarMajusculesBonus($contrasenya) {
        if (contarMajuscules($contrasenya) == 0){
            return 0;
        }else{
            return (contarCaracters($contrasenya) - contarMajuscules($contrasenya)) * 2;
        }
    } 
    
    function contarMinuscules($contrasenya){
        $contador = 0;
        for ($i = 0; $i < strlen($contrasenya); $i++) {
            if (ctype_lower($contrasenya[$i])) {
                $contador++;
            }
        }
        return $contador;
    }
    
    function contarMinusculesBonus($contrasenya) {
        if (contarMinuscules($contrasenya) == 0){
            return 0;
        }else{
            return (contarCaracters($contrasenya) - contarMinuscules($contrasenya)) * 2;
        }
    }
    
    function contarNumeros($contrasenya) {
        $contador = 0;
        for ($i = 0; $i < strlen($contrasenya); $i++) {
            if (is_numeric($contrasenya[$i])) {
                $contador++;
            }
        }
        return $contador;
    }
    
    function contarNumerosBonus($contrasenya) {
        return contarNumeros($contrasenya) * 4;
    }
    
    function contarSimbols($contrasenya) {
        $contador = 0;
        for ($i = 0; $i < strlen($contrasenya); $i++) {
            if (!ctype_alnum($contrasenya[$i])) {
                $contador++;
            }
        }
        return $contador;
    }
    
    function contarSimbolsBonus($contrasenya) {
        return contarSimbols($contrasenya) * 6;
    }
    
    function contarMitadNumSim($contrasenya){
        $contador = 0;
        $lletres = 0;
        
        for ($i = 0; $i < strlen($contrasenya); $i++) {
            if (ctype_alpha($contrasenya[$i])) {
                $lletres++;
            }
        }
        $numeros = contarNumeros($contrasenya);
        $simbols = contarSimbols($contrasenya);
        
        if($numeros >= $lletres / 2) {
            $contador++;
        }
        
        if($simbols >= $lletres / 2) {
            $contador++;
        }
        
        if(($numeros + $simbols) >= $lletres / 2) {
            $contador++;
        }
        
        return $contador;
    }
    
    function contarMitadNumSimBonus($contrasenya){
        return contarMitadNumSim($contrasenya) * 2;
    }
    
    function contarRequeriments($contrasenya){
        $requisit = 0;
        if (contarCaracters($contrasenya) >= 8){
            $requisit++;
        }
        
        if (contarNumeros($contrasenya) >= 1){
            $requisit++;
        }
        
        if (contarMajuscules($contrasenya) >= 1){
            $requisit++;
        }
        
        if(contarMinuscules($contrasenya) >= 1){
            $requisit++;
        }
        
        if(contarSimbols($contrasenya) >= 1){
            $requisit++;
        }
        
        return $requisit;
    }
    
    function contarRequerimentsBonus($contrasenya){
        if(contarRequeriments($contrasenya) >= 4){
            return contarRequeriments($contrasenya) * 2;
        }else{
            return 0;
        }
    }
    
    function deduccioLletres($contrasenya) {
        $contador = 0;
        for ($i = 0; $i < strlen($contrasenya); $i++) {
            if (ctype_alpha($contrasenya[$i])) {
                $contador++;
            }else{
                $contador = 0;
                break;
            }
        }
        return $contador;
    }
    
    function deduccioLletresBonus($contrasenya){
        return deduccioLletres($contrasenya) * 1;
    }
    
    function deduccioNumeros($contrasenya) {
        $contador = 0;
        for ($i = 0; $i < strlen($contrasenya); $i++) {
            if (is_numeric($contrasenya[$i])) {
                $contador++;
            }else{
                $contador = 0;
                break;
            }
        }
        return $contador;
    }
    
    function deduccioNumerosBonus($contrasenya){
        return deduccioNumeros($contrasenya) * 1;
    }
    
    function deduccioCaractersRepetits($contrasenya) {
        $contador = 0;
        for ($i = 0; $i < strlen($contrasenya) - 1; $i++) {
            if (strcasecmp($contrasenya[$i], $contrasenya[$i + 1]) == 0) {
                $contador++;
            }
        }
        return $contador;
    }
    
    function deduccioCaractersRepetitsBonus($contrasenya){
        $n = deduccioCaractersRepetits($contrasenya);
        return $n * ($n - 1);
    }
    
    function deduccioMajuscules($contrasenya) {
        $contador = 0;
        for ($i = 0; $i < strlen($contrasenya); $i++) {
            if (ctype_upper($contrasenya[$i]) && !is_numeric($contrasenya[$i])) {
                $contador++;
            }else{
                break;
            }
        }
        if ($contador > 0){
            $contador = $contador - 1;
        }
        return $contador;
    }
    
    function deduccioMajusculesBonus($contrasenya){
        return deduccioMajuscules($contrasenya) * 2;
    }
    
    function deduccioMinuscules($contrasenya) {
        $contador = 0;
        for ($i = 0; $i < strlen($contrasenya); $i++) {
            if (ctype_lower($contrasenya[$i])) {
                $contador++;
            } else {
                break;
            }
        }
        if ($contador > 0){
            $contador = $contador - 1;
        }
        return $contador;
    }
    
    function deduccioMinusculesBonus($contrasenya){
        return deduccioMinuscules($contrasenya) * 2;
    }
    
    function deduccioNumerosConsecutius($contrasenya) {
        $contador = 0;
        for ($i = 0; $i < strlen($contrasenya); $i++) {
            if (is_numeric($contrasenya[$i])) {
                $contador++;
            }
        }
        if ($contador > 0){
            $contador = $contador - 1;
        }
        return $contador;
    }
    
    function deduccioNumerosConsecutiusBonus($contrasenya){
        return deduccioNumerosConsecutius($contrasenya) * 2;
    }
    
    function deduccioSecuenciaLletres($contrasenya) {
        $contador = 0;
        $contrasenyaDividida = str_split($contrasenya, 3);
        $posibilitats = [];
        $abcMinus = range('a', 'z');
        $abcMayus = range('A', 'Z');

        for ($i = 0; $i < count($abcMinus) - 2; $i++) {
            for ($j = $i + 1; $j < count($abcMinus) - 1; $j++) {
                for ($k = $j + 1; $k < count($abcMinus); $k++) {
                    $posibilitat =  $abcMinus[$i] .  $abcMinus[$j] .  $abcMinus[$k];
                    array_push($posibilitats, $posibilitat);
                }
            }
        }
        
        for ($i = 0; $i < count($abcMayus) - 2; $i++) {
            for ($j = $i + 1; $j < count($abcMayus) - 1; $j++) {
                for ($k = $j + 1; $k < count($abcMayus); $k++) {
                    $posibilitat =  $abcMayus[$i] .  $abcMayus[$j] .  $abcMayus[$k];
                    array_push($posibilitats, $posibilitat);
                }
            }
        }
                
        for ($i = 0; $i < count($contrasenyaDividida); $i++) {
            $lletres = $contrasenyaDividida[$i];
            for ($j = 0; $j < count($posibilitats); $j++){
                if ($lletres == $posibilitats[$j]){
                    $contador++;
                }
            }
        }
        return $contador;
    }
    
    function deduccioSecuenciaLletresBonus($contrasenya){
        return deduccioSecuenciaLletres($contrasenya) * 3;
    }
    
    function deduccioSecuenciaNumeros($contrasenya) {
        $contador = 0;
        $posibilitats = [];
        
        for ($i = 0; $i <= 9; $i++) {
            for ($j = 0; $j <= 9; $j++) {
                for ($k = 0; $k <= 9; $k++) {
                    $posibilitat = $i . $j . $k;
                    array_push($posibilitats, $posibilitat);
                }
            }
        }
        $contrasenyaDividida = str_split($contrasenya, 3);
        
        for ($i = 0; $i < count($contrasenyaDividida); $i++) {
            $nums = $contrasenyaDividida[$i];
            for ($j = 0; $j < count($posibilitats); $j++){
                if ($nums ==  $posibilitats[$j]){
                    $contador++;
                }
            }
        }
        return $contador;
    }
    
    function deduccioSecuenciaNumerosBonus($contrasenya){
        return deduccioSecuenciaNumeros($contrasenya) * 3;
    }
    
    function calcularPuntuacio($contrasenya){
        $bonusCaracters = contarCaractersBonus($contrasenya);
        $bonusMajuscules = contarMajusculesBonus($contrasenya);
        $bonusMinuscules = contarMinusculesBonus($contrasenya);
        $bonusSimbols = contarSimbolsBonus($contrasenya);
        $bonusMitadNumSim = contarMitadNumSimBonus($contrasenya);
        $bonusRequeriments = contarRequerimentsBonus($contrasenya);
        
        $bonus = $bonusCaracters + $bonusMajuscules + $bonusMinuscules + $bonusSimbols + $bonusMitadNumSim + $bonusRequeriments;
        
        $deduccioLletres = deduccioLletresBonus($contrasenya);
        $deduccioNumeros = deduccioNumerosBonus($contrasenya);
        $deduccioCaractersRepetits = deduccioCaractersRepetitsBonus($contrasenya);
        $deduccioMajuscules = deduccioMajusculesBonus($contrasenya);
        $deduccioMinuscules = deduccioMinusculesBonus($contrasenya);
        $deduccioNumsConsecutius = deduccioNumerosConsecutiusBonus($contrasenya);
        $deduccioSecuenciaLletres = deduccioSecuenciaLletresBonus($contrasenya);
        $deduccioSecuenciaNums = deduccioSecuenciaNumerosBonus($contrasenya);
        
        $deduccions = $deduccioLletres + $deduccioNumeros + $deduccioCaractersRepetits + $deduccioMajuscules + $deduccioMinuscules + $deduccioNumsConsecutius + $deduccioSecuenciaLletres + $deduccioSecuenciaNums;
        
        $puntuacio = $bonus - $deduccions;
        
        return round((($puntuacio) / 117.14) * 100, 2);
    }
    
    function calcularComplexitat($contrasenya){
        $percentatge = calcularPuntuacio($contrasenya);
        
        if ($percentatge < 15){
            echo "Molt Debil";
        }elseif ($percentatge >= 15 && $percentatge < 30) {
            echo "Debil";
        }elseif ($percentatge >= 30 && $percentatge < 50){
            echo "Bona";
        }elseif ($percentatge >= 50 && $percentatge < 70){
            echo "Forta";
        }elseif ($percentatge >= 70 && $percentatge < 90){
            echo "Molt Forta";
        }else{
            echo "Perfecte";
        }
    }
?>

<html>
<head>
<title>E10_Complexitat_de_les_contrasenyes</title>
<style type="text/css">
body {
	color: #000;
	font-family: Verdana,'Trebuchet MS','Lucida Grande', Arial, sans-serif;
	font-size: .8em;
	line-height: 1.25em;
	margin: 0;
	padding: 0;
	text-align: center;
}
form,input,select,textarea {
	margin:0;
	padding:0;
}
h1,h2,h3,h4,h5,h6 
{
	font-family:Georgia, Tahoma, Arial, Serif;
	font-weight:normal;
	line-height:1.6em;
	padding: 0;
	margin: 0;
}
input {
	font-size: 100%;
	margin-bottom: 2px;
	padding: 1px;
}
ol,ul {
	line-height: 1.4em;
	margin-bottom: 4px;
	margin-top: 4px;
}
p {
	line-height: 1.4em;
	margin-bottom: 5px;
	margin-top: 5px;
	text-align: justify;
}
table {
	background: #345;
	margin-bottom: 10px;
	width: 100%;
}
td {
	background: #eee;
	text-align: left;
	vertical-align: top;
}
th {
	background: #456;
	color: #fff;
	text-align: left;
	vertical-align: top;
}
#content {
	margin: 0 auto;
	padding: 10px;
	text-align: left;
	width: 610px;
}
#linkstop {
	background: #234;
	color: #fff;
	margin-top: -10px;
	padding: 2px;
}
#linkstop a {
	color: #fff;
}
#score {
	color: #000;
	font-size: 85%;
	position:absolute;
	text-align: center;
	width: 100px;
	z-index: 10;
}
#score,#rating,#standards {
	font-weight: bold;
	color:#ffffff;
}
#scorebar {
	background-image: url(http://ontek.net/imatgesemail/password_test/bg_strength_gradient.jpg);
	background-repeat: no-repeat;
	background-position: 0 0;
	position:absolute;
	width: 100px;
	z-index: 0;
}
#scorebarBorder {
	background: #333;
	border: 1px #000 solid;
	height: 16px;
	margin-bottom: 2px;
	width: 100px;
}
#progressbar{
	background: white;
	border: 1px #000 solid;
	height: 16px;
	margin-bottom: 2px;
	width: 100px;
}
#password {
	border: 1px #000 solid;
	font-size: 85%;
	width: 100px;
}
#passwordTxt {
    display: none;
}
#tablePwdScoring {
	margin-bottom: 0 !important;
}
#listLegend li {
	list-style: none;
	padding-bottom: 4px;
	margin-left: 0;
	padding-left: 0;
}
#listLegend {
	margin-left: 0;
	padding-left: 0;
}
div.fail,div.pass,div.exceed,div.warn {
	background-repeat: no-repeat;
	background-position: left top;
	height: 16px;
	margin-left: auto;
	margin-right: auto;
	width: 16px;
}
div.exceed {
	background-image: url(http://www.ontek.net/imatgesemail/password_test/img_status_exceed.png);
}
div.fail {
	background-image: url(http://www.ontek.net/imatgesemail/password_test/img_status_fail.png);
}
div.pass {
	background-image: url(http://www.ontek.net/imatgesemail/password_test/img_status_pass.png);
}
div.warn {
	background-image: url(http://www.ontek.net/imatgesemail/password_test/img_status_warn.png);
}
td.exceed,td.fail,td.pass,td.warn {
	color: #fff;
	font-weight: bold;
	text-align: center;
}
td.exceed {
	background: #1C60A4;
}
td.fail {
	background: #C00;
}
td.pass {
	background: #093;
}
td.warn {
	background: #f60;
}
div.box {
	background: #456;
	border: 1px #000 solid;
	color: #fff;
	height: 16px;
	padding: 2px;
	white-space: nowrap;
	width: 90%;
}
div.boxMinus,div.boxPlus {
	border: none;
	color: black;
	font-weight: bold;
	padding: 2px;
	text-align: left;
	white-space: nowrap;
}
td.footnote {
	background: #ddd;
	font-size: 70%;
}
.bold {
	font-weight: bold;
}
.clearNone {
	clear: none;
}
.floatRight {
	float: right;
}
.floatLeft {
	float: left;
}
.hide {
	display: none;
}
.imgLegend {
	clear: left !important;
	float: left !important;
	position: relative !important;
	margin-bottom: -3px !important;
	margin-right: 5px !important;
}
.inline {deduccioMinusculesBonus
	display: inline;
}
.italic {
	font-style: italic;
}
.noPad {
	padding: 0;
}
.show {
	display: inline !important;
}
.txtLg {
	font-size: 125%;
}
.txtSmall {
	font-size: 75%;
}
.txtCenter {
	text-align: center;
}
.txtRight {
	text-align: right;
}
div.xtend {
	clear: both !important; 
	line-height: 0; 
	height: 0;
}

a:link, a:visited 
{
	color:#459045;
	text-decoration:none;
	border-bottom:none;
}
a:hover, a:active 
{
	text-decoration:none;
	border-bottom: 1px solid;
}
#header {
background:url(http://www.ontek.net/imatgesemail/password_test/top.gif) top repeat-x;
height:145px;
margin:0;
padding:0;
width:100%;
}
#logo {
height:100px;
width:900px;
margin:0 auto;
}
#blogname {
height:30px;
padding-left:12px;
padding-top:28px;
text-align:left;
}
h1#blogname a {
color:#fff;
font-size:1.3em;
}
#navigation 
{
	clear:both;
	height:24px;
	margin:0 auto;
	padding:0 10px;
	text-align:center;
	width:880px;
	font-size:1.1em;
}
#navigation a:link,
#navigation a:visited 
{
	background:#FFF url(http://www.ontek.net/imatgesemail/password_test/active1.gif) left bottom no-repeat;
	color:#fff;
	height:24px;
	margin-right:2px;
	padding-left:12px;
	text-decoration:none;
	border:none;
}
#navigation a:link,
#navigation a:link span,
#navigation a:visited,
#navigation a:visited span 
{
	cursor:hand;
	display:block;
	float:left;
	border:none;
}
#navigation li 
{
	line-height:23px;
	float:left;
	list-style:none;
	margin:0;
}
#navigation a:hover 
{
	background:url(http://www.ontek.net/imatgesemail/password_test/active1.gif) left bottom no-repeat;
	color:#040;
	height:24px;
	padding-left:12px;
	text-decoration:none;
	border:none;
}
#navigation .current_page_item a:link,
#navigation .current_page_item a:visited 
{
	background:#FFF url(http://www.ontek.net/imatgesemail/password_test/current1.gif) left bottom no-repeat;
	color:#fff;
	height:27px;
	line-height:24px;
	margin-right:2px;
	padding-left:15px;
	text-decoration:none;
	border:none;
}
#navigation .current_page_item a:hover 
{
	background:#FFF url(http://www.ontek.net/imatgesemail/password_test/current1.gif) left bottom no-repeat;
	color:#AAC8E0;
	height:27px;
	margin-right:2px;
	padding-left:15px;
	text-decoration:none;
	border:none;
}
#navigation ul 
{
	list-style:none;
	margin:0;
	padding:0;
}
#navigation a:link span,
#navigation a:visited span,
#navigation a:hover span 
{
	background:url(http://www.ontek.net/imatgesemail/password_test/active2.gif) right bottom no-repeat;
	height:24px;
	padding-right:12px;
	border:none;
}
#navigation .current_page_item a:link span,
#navigation .current_page_item a:visited span,
#navigation .current_page_item a:hover span 
{
	background:url(http://www.ontek.net/imatgesemail/password_test/current2.gif) right bottom no-repeat;
	height:27px;
	padding-right:15px;
	border:none;
}
#footer {
	background:#223344 url(http://www.ontek.net/imatgesemail/password_test/top.gif) bottom repeat-x;
	clear: both;
	height: 60px;
	padding: 10px;
	text-align: center;
	margin:0 auto;
	color:#ccc;
}
/* Begin hacks for IE and all it's non-compliant glory!!! */
/* \*/
<!--[if lt IE 7]>
* html div.exceed,* html div.fail,* html div.pass,* html div.warn { background-image: none !important; }
* html div.exceed { filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true', sizingMethod='crop', src='images/img_status_exceed.png'); }
* html div.fail { filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true', sizingMethod='crop', src='images/img_status_fail.png'); }
* html div.pass { filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true', sizingMethod='crop', src='images/img_status_pass.png'); }
* html div.warn { filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true', sizingMethod='crop', src='images/img_status_warn.png'); }
<![endif]-->
/* */
/* End hacks for IE */

</style>
</head>
<body>
	<div id="content">
		<?php echo "<h1>E10_COMPLEXITAT-DE-LES-CONTRASENYES</h1>"?>
        <form id="formPassword" name="formPassword" method="post">
            <table id="tablePwdCheck" cellpadding="5" cellspacing="1" border="0">
            	<tr>
                	<th colspan="2" class="txtCenter">Prueba tu Contraseña</th>
                    <th class="txtCenter">Requerimientos mínimos</th>
               </tr>
               <tr>
                    <th>Contraseña:</th>
                    <td>
                    	<input type="password" id="passwordPwd" name="passwordPwd" maxlength="16" autocomplete="off" onkeyup="chkPass(this.value);" />
						<input type="text" id="passwordTxt" name="passwordTxt" maxlength="16" autocomplete="off" onkeyup="chkPass(this.value);" class="hide" />
						<input type="submit" id="enviar" name="enviar" value="Enviar">
                    </td>
                    <td rowspan="4">
                        <ul>
                            <li>Tamaño mínimo de 8 caracteres</li>
                            <li>Contener al menos 3-4 de las siguientes cosas:<br />
                                - Letras en Mayúsculas<br />
                                - Letras en Minúsculas<br />
                                - Números<br />
                                - Símbolos<br />
                            </li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <th>Ocultar:</th>
                    <td>
                    	<input type="checkbox" id="mask" name="mask" value="1" checked="checked" onclick="togPwdMask();" />
                    </td>
                </tr>
                <tr>
                    <th>Resultado:</th>
                    <td>
                       <?php 
                           $puntuacion = calcularPuntuacio($contrasenya);
                           echo "<progress id='progressbar' max='100' value='{$puntuacion}'></progress>";
                           echo "<p>{$puntuacion}%</p>"
                       ?>
                    </td>
                </tr>
                <tr>
                    <th>Complejidad:</th>
                    <td>
                    	<?php 
                    	   $complexitat = calcularComplexitat($contrasenya);
                    	   echo "<div id='complexity'> $complexitat </div>";
                        ?>
                    </td>
                </tr>
            </table>
            <table id="tablePwdStatus" cellpadding="5" cellspacing="1" border="0">
                <tr>
                    <th colspan="2" style="height: 27px">Adiciones</th>
                    <th class="txtCenter" style="height: 27px">Tipo</th>
                    <th class="txtCenter" style="height: 27px">Ratio</th>
                    <th class="txtCenter" style="height: 27px">Contador</th>
                    <th class="txtCenter" style="height: 27px">Bonos</th>
                </tr>
                <tr>
                    <td width="1%"><div id="div_nLength" class="fail">&nbsp;</div></td>
                    <td width="94%">Número de Caracteres</td>
                    <td width="1%" class="txtCenter">Fijo</td>
                    <td width="1%" class="txtCenter italic">+(n*4)</td>
                    <td width="1%"><div id="nLength" class="box">&nbsp;<?php echo contarCaracters($contrasenya)?></div></td>
                    <td width="1%"><div id="nLengthBonus" class="boxPlus">&nbsp;<?php echo "+" . contarCaractersBonus($contrasenya)?></div></td>
                </tr>	
                <tr>
                    <td><div id="div_nAlphaUC" class="fail">&nbsp;</div></td>
                    <td>Letras Mayúsculas</td>
                    <td class="txtCenter">Cond/Incr</td>
                    <td nowrap="nowrap" class="txtCenter italic">+((len-n)*2)</td>
                   <td><div id="nAlphaUC" class="box">&nbsp;<?php echo contarMajuscules($contrasenya)?></div></td>
                    <td><div id="nAlphaUCBonus" class="boxPlus">&nbsp;<?php echo "+" . contarMajusculesBonus($contrasenya)?></div></td>
                </tr>	
                <tr>
                    <td><div id="div_nAlphaLC" class="fail">&nbsp;</div></td>
                    <td>Letras minúsculas</td>
                    <td class="txtCenter">Cond/Incr</td>
                    <td class="txtCenter italic">+((len-n)*2)</td>
                    <td><div id="nAlphaLC" class="box">&nbsp;<?php echo contarMinuscules($contrasenya)?></div></td>
                    <td><div id="nAlphaLCBonus" class="boxPlus">&nbsp;<?php echo "+" . contarMinusculesBonus($contrasenya)?></div></td>
                </tr>
                <tr>
                    <td><div id="div_nNumber" class="fail">&nbsp;</div></td>
                    <td>Números</td>
                    <td class="txtCenter">Cond</td>
                    <td class="txtCenter italic">+(n*4)</td>
                    <td><div id="nNumber" class="box">&nbsp;<?php echo contarNumeros($contrasenya)?></div></td>
                    <td><div id="nNumberBonus" class="boxPlus">&nbsp;<?php echo "+" . contarNumerosBonus($contrasenya)?></div></td>
               </tr>
                <tr>
                    <td><div id="div_nSymbol" class="fail">&nbsp;</div></td>
                    <td>Símbolos</td>
                    <td class="txtCenter">Fijo</td>
                    <td class="txtCenter italic">+(n*6)</td>
                    <td><div id="nSymbol" class="box">&nbsp;<?php echo contarSimbols($contrasenya)?></div></td>
                    <td><div id="nSymbolBonus" class="boxPlus">&nbsp;<?php echo "+" . contarSimbolsBonus($contrasenya)?></div></td>
               </tr>
                <tr>
                    <td><div id="div_nMidChar" class="fail">&nbsp;</div></td>
                    <td>Mitad Números o símbolos</td>
                    <td class="txtCenter">Fijo</td>
                    <td class="txtCenter italic">+(n*2)</td>
                    <td><div id="nMidChar" class="box">&nbsp;<?php echo contarMitadNumSim($contrasenya)?></div></td>
                    <td><div id="nMidCharBonus" class="boxPlus">&nbsp;<?php echo "+" . contarMitadNumSimBonus($contrasenya)?></div></td>
               </tr>
                <tr>
                    <td><div id="div_nRequirements" class="fail">&nbsp;</div></td>
                    <td>Requerimientos</td>
                    <td class="txtCenter">Fijo</td>
                    <td class="txtCenter italic">+(n*2)</td>
                    <td><div id="nRequirements" class="box">&nbsp;<?php echo contarRequeriments($contrasenya)?></div></td>
                    <td><div id="nRequirementsBonus" class="boxPlus">&nbsp;<?php echo "+" . contarRequerimentsBonus($contrasenya)?></div></td>
               </tr>
                <tr>
                    <th colspan="6">Deducciones</th>
                </tr>
				<tr>
                    <td width="1%"><div id="div_nAlphasOnly" class="pass">&nbsp;</div></td>
                    <td width="94%">Solo Letras</td>
                    <td width="1%" class="txtCenter">Fijo</td>
                    <td width="1%" class="txtCenter italic">-n</td>
                    <td width="1%"><div id="nAlphasOnly" class="box">&nbsp;<?php echo deduccioLletres($contrasenya)?></div></td>
                    <td width="1%"><div id="nAlphasOnlyBonus" class="boxMinus">&nbsp;<?php echo "-" . deduccioLletresBonus($contrasenya)?></div></td>
				</tr>	
				<tr>
                    <td><div id="div_nNumbersOnly" class="pass">&nbsp;</div></td>
                    <td>Solo Números</td>
                    <td class="txtCenter">Fijo</td>
                    <td class="txtCenter italic">-n</td>
                    <td><div id="nNumbersOnly" class="box">&nbsp;<?php echo deduccioNumeros($contrasenya)?></div></td>
                    <td><div id="nNumbersOnlyBonus" class="boxMinus">&nbsp;<?php echo "-" . deduccioNumerosBonus($contrasenya)?></div></td>
				</tr>	
				<tr>
                    <td><div id="div_nRepChar" class="pass">&nbsp;</div></td>
                    <td>Caracteres Repetidos (No sensible)</td>
                    <td class="txtCenter">Incr</td>
                    <td nowrap="nowrap" class="txtCenter italic">-(n(n-1))</td>
                    <td><div id="nRepChar" class="box">&nbsp;<?php echo deduccioCaractersRepetits($contrasenya)?></div></td>
                    <td><div id="nRepCharBonus" class="boxMinus">&nbsp;<?php echo "-" . deduccioCaractersRepetitsBonus($contrasenya)?></div></td>
				</tr>	
				<tr>
                    <td><div id="div_nConsecAlphaUC" class="pass">&nbsp;</div></td>
                    <td>Letras Mayúsuculas consecutivas</td>
                    <td class="txtCenter">Fijo</td>
                    <td class="txtCenter italic">-(n*2)</td>
                    <td><div id="nConsecAlphaUC" class="box">&nbsp;<?php echo deduccioMajuscules($contrasenya)?></div></td>
                    <td><div id="nConsecAlphaUCBonus" class="boxMinus">&nbsp;<?php echo "-" . deduccioMajusculesBonus($contrasenya)?></div></td>
				</tr>	
				<tr>
                    <td><div id="div_nConsecAlphaLC" class="pass">&nbsp;</div></td>
                    <td>Letras Minúsculas consecutivas</td>
                    <td class="txtCenter">Fijo</td>
                    <td class="txtCenter italic">-(n*2)</td>
                    <td><div id="nConsecAlphaLC" class="box">&nbsp;<?php echo deduccioMinuscules($contrasenya)?></div></td>
                    <td><div id="nConsecAlphaLCBonus" class="boxMinus">&nbsp;<?php echo "-" . deduccioMinusculesBonus($contrasenya)?></div></td>
				</tr>	
				<tr>
                    <td><div id="div_nConsecNumber" class="pass">&nbsp;</div></td>
                    <td>Números consecutivos</td>
                    <td class="txtCenter">Fijo</td>
                    <td class="txtCenter italic">-(n*2)</td>
                    <td><div id="nConsecNumber" class="box">&nbsp;<?php echo deduccioNumerosConsecutius($contrasenya)?></div></td>
                    <td><div id="nConsecNumberBonus" class="boxMinus">&nbsp;<?php echo "-" . deduccioNumerosConsecutiusBonus($contrasenya)?></div></td>
				</tr>	
				<tr>
                    <td><div id="div_nSeqAlpha" class="pass">&nbsp;</div></td>
                    <td>Sencuencia de Letras (3+)</td>
                    <td class="txtCenter">Fijo</td>
                    <td class="txtCenter italic">-(n*3)</td>
                    <td><div id="nSeqAlpha" class="box">&nbsp;<?php echo deduccioSecuenciaLletres($contrasenya)?></div></td>
                    <td><div id="nSeqAlphaBonus" class="boxMinus">&nbsp;<?php echo "-" . deduccioSecuenciaLletresBonus($contrasenya)?></div></td>
				</tr>	
				<tr>
                    <td><div id="div_nSeqNumber" class="pass">&nbsp;</div></td>
                    <td>Secuencia de Números (3+)</td>
                    <td class="txtCenter">Fijo</td>
                    <td class="txtCenter italic">-(n*3)</td>
                    <td><div id="nSeqNumber" class="box">&nbsp;<?php echo deduccioSecuenciaNumeros($contrasenya)?></div></td>
                    <td><div id="nSeqNumberBonus" class="boxMinus">&nbsp;<?php echo "-" . deduccioSecuenciaNumerosBonus($contrasenya)?></div></td>
				</tr>	
                <tr>
                    <th colspan="6">Leyenda</th>
                </tr>
                <tr>
                    <td colspan="6">
                        <ul id="listLegend">
                            <li><div class="exceed imgLegend">&nbsp;</div> <span class="bold">Excepcional:</span> Excede el mínimo estándar. Se aplican bonos adicionales.</li>
                            <li><div class="pass imgLegend">&nbsp;</div> <span class="bold">Suficiente:</span> Cubre minimamente los estándares. Se aplican bonos adicionales.</li>
                            <li><div class="warn imgLegend">&nbsp;</div> <span class="bold">Peligro:</span> Aviso de uso de malas prácticas. Se reduce el resultado.</li>
                            <li><div class="fail imgLegend">&nbsp;</div> <span class="bold">Fallo:</span> No cumples para nada el mínimo estándar. Se reduce el resultado.</li>
                        </ul>
                    </td>
                </tr>
			</table>
       </form>
		<div class="xtend">&nbsp;</div>
	</div>
  <script src="http://www.google-analytics.com/urchin.js" type="text/javascript">
</script>
  <script type="text/javascript">
_uacct = "UA-71902-35";
urchinTracker();
</script>
</body>
</html>