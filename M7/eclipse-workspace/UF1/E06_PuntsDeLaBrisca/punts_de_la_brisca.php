<?php
    error_reporting(E_ALL);
    ini_set("display_errors",1);
    $valors = array("AS"=>"11", "DOS"=>"0", "TRES"=>"10", "QUATRE"=>"0", "CINC"=>"0", "SIS"=>"0", "SET"=>"0", "VUIT"=>"0", "NOU"=>"0", "SOTA"=>"2", "CAVALL"=>"3", "REI"=>"4");
    $pals = array("PALS", "ORS", "ESPASES", "COPES");
    $baralla = [];
    $punts = 0;
?>

<html>
<body>
	<h1>E06_PUNTS-DE-LA-BRISCA</h1>
	<p>
		<?php
    		for ($i=0; $i<10; $i++){
    		    do{
    		        $nom_valor = array_rand($valors);
    		        $pal = array_rand($pals);
    		        $carta = $nom_valor ." de ". $pals[$pal];
    		    }while(in_array($carta, $baralla));
    		    
    		    array_push($baralla, $carta);

    		    $punts = $punts + $valors[$nom_valor];
    		    
    		    echo $carta;
    		    echo "<br>";
    		}
		?>
	</p>
	<p>
		<?php
		  echo "Punts: " . $punts;
		?>
	</p>
</body>
</html>