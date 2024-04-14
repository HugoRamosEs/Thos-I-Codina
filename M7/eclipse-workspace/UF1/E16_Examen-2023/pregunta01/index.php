<?php 
/*
 * La present pàgina web és un selector d'idiomes.
 * Afegeix el codi php per tal que es gestioni correctament la petició
 * i es mantingui en el temps la selecció que ha fet l'usuari.
 */

if (isset($_COOKIE["lang"])){
    $selectedLanguage = $_COOKIE["lang"];
}else {
    $selectedLanguage = "None";
}

if (isset($_GET["lang"])) {
    $selectedLanguage = $_GET["lang"];
    setcookie("lang", $selectedLanguage, time() + 31536000);
}
?>


<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Language Selection</title>
  <link rel="stylesheet" href="./style2.css">
</head>
<body>
    <div class="content">
    	<?php 
    	  echo "$selectedLanguage selected";
    	?>
	</div>
	
    <!-- partial:index.partial.html -->
    <svg xmlns="http://www.w3.org/2000/svg" version="1.1">
    	<defs>
    		<filter id="goo">
    			<feGaussianBlur in="SourceGraphic" stdDeviation="5" result="blur" />
    			<feColorMatrix in="blur" mode="matrix" values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 19 -9" result="goo" />
    			<feComposite in="SourceGraphic" in2="goo" operator="atop"/>
    		</filter>
    	</defs>
    </svg>
    <div class="select">
    	<div class="select-placeholder" data-language="none">
    		<svg class="icon-language" version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="-313.7 580.6 38.9 38.9" style="enable-background:new -313.7 580.6 38.9 38.9;" xml:space="preserve">
    			<g>
    				<path d="M-294.3,619.4c-10.7,0-19.4-8.7-19.4-19.4s8.7-19.4,19.4-19.4s19.4,8.7,19.4,19.4S-283.6,619.4-294.3,619.4z M-294.3,583.6
    					c-9.1,0-16.4,7.4-16.4,16.4c0,9.1,7.4,16.4,16.4,16.4c9.1,0,16.4-7.4,16.4-16.4C-277.9,590.9-285.2,583.6-294.3,583.6z"/>
    			</g>
    			<g>
    				<path d="M-276.4,601.5h-35.9c-0.8,0-1.5-0.7-1.5-1.5c0-0.8,0.7-1.5,1.5-1.5h35.9c0.8,0,1.5,0.7,1.5,1.5
    					C-274.9,600.8-275.6,601.5-276.4,601.5z"/>
    			</g>
    			<g>
    				<path d="M-294.3,619.4c-0.4,0-0.8-0.2-1.1-0.4c-0.3-0.3-8.3-8.5-8.3-18.9c0-10.4,8-18.6,8.3-18.9c0.3-0.3,0.7-0.4,1.1-0.4l0,0
    					c0.4,0,0.8,0.2,1.1,0.4c0.3,0.3,8.3,8.6,8.3,18.9c0,10.4-8,18.6-8.3,18.9C-293.5,619.3-293.9,619.4-294.3,619.4z M-294.3,584.4
    					c-2.1,2.5-6.4,8.6-6.4,15.6c0,7,4.3,13.1,6.4,15.6c2.1-2.5,6.4-8.6,6.4-15.6C-287.9,593.1-292.2,587-294.3,584.4z"/>
    			</g>
    			<g>
    				<path d="M-294.3,592.5c-5.4,0-10.6-1.1-14.2-2.9c-0.7-0.4-1-1.3-0.7-2c0.4-0.7,1.3-1,2-0.7c3.2,1.6,7.9,2.6,12.8,2.6
    					c5,0,9.6-0.9,12.8-2.6c0.7-0.4,1.6-0.1,2,0.7c0.4,0.7,0.1,1.6-0.7,2C-283.7,591.4-288.9,592.5-294.3,592.5z"/>
    			</g>
    			<g>
    				<path d="M-307.8,612.7c-0.5,0-1.1-0.3-1.3-0.8c-0.4-0.7-0.1-1.6,0.7-2c3.6-1.8,8.8-2.9,14.2-2.9c5.4,0,10.6,1.1,14.2,2.9
    					c0.7,0.4,1,1.3,0.7,2c-0.4,0.7-1.3,1-2,0.7c-3.2-1.6-7.9-2.6-12.8-2.6c-5,0-9.6,0.9-12.8,2.6C-307.4,612.7-307.6,612.7-307.8,612.7
    					z"/>
    			</g>
    		</svg><!-- /.icon-language -->
    	</div><!--  /.select-placeholder -->
    
    	<div class="select-option" data-language="english-us">English (US)</div><!--  /.select-option -->
    	<div class="select-option" data-language="english-uk">English (UK)</div><!--  /.select-option -->
    	<div class="select-option" data-language="german">German</div><!--  /.select-option -->
    	<div class="select-option" data-language="french">French</div><!--  /.select-option -->
    	<div class="select-option" data-language="spanish-mexico">Spanish</div><!--  /.select-option -->
    	<div class="select-option" data-language="japanese">Japanese</div><!--  /.select-option -->
    	<div class="select-option" data-language="russian">Russian</div><!--  /.select-option -->
    	<div class="select-option" data-language="mandarin">Mandarin</div><!--  /.select-option -->
    </div><!--  /.select -->

    <!-- partial -->
    <script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script  src="./script.js"></script>

</body>
</html>
