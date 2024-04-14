<html>
<body>
	<h1>E04_CalculaEdat</h1>
	<?php 
    	error_reporting(E_ALL);
    	ini_set("display_errors",1);
    	
    	$diaActual = date("d");
    	$mesActual = date("m");
    	$anyActual = date("Y");
    	
    	$dia = 18;
    	$mes = 2;
    	$any = 2004;
    	
    	$edat = 0;
    	$mesos = 0;
    	$dies = 0;
	?>
	<p>
		<?php 
		  echo "Data Escollida: $dia-$mes-$any";
    	?>
	</p>
	<p>
		<?php 
    	   echo "Data Actual: $diaActual-$mesActual-$anyActual";
    	?>
	</p>
	<?php 
    	if ($any <= $anyActual){
    	    $edat = $anyActual - $any;
    	    if($mes > $mesActual){
    	        $edat--;
    	    }
    	    if($mes == $mesActual && $dia > $diaActual){
    	        $edat--;
    	    }
    	    echo "Edat: $edat";
    	}else{
    	    echo "ERROR: La data de naixament no és vàlida, perque la data de naixament es posterior a la actual";
    	}
    	
    	if ($any == $anyActual && $mes < $mesActual){
    	    $mesos = $mesActual - $mes;
    	    $dies = $diaActual - $dia;
    	    echo " / Mesos: $mesos i Dies: $dies";
    	}
    	
    	if ($any == $anyActual && $mes == $mesActual && $dia < $diaActual){
    	    $dies = $diaActual - $dia;
    	    echo " / Dies: $dies";
    	}
	?>
</body>
</html>