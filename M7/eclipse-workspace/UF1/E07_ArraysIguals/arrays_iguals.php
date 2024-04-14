<?php 
    error_reporting(E_ALL);
    ini_set("display_errors",1);
    
    function comprovar_arrays($arr1, $arr2){ 
        if (!is_array($arr1) || !is_array($arr2)){
            return false;
        }
        
        if (count($arr1) !== count($arr2)){
            return false;
        }
        
        array_multisort($arr1);
        array_multisort($arr2);
        
        return $arr1 === $arr2;
    }
    
?>

<html>
<body>
	<h1>E07_ARRAYS-IGUALS</h1>
    	<?php 
        	$arr1 = [1,2,3];
        	$arr2 = [3,2,1];
        	
        	$arr3 = [["buenas", 3, 4], ["hola", 3, 5]];
        	$arr4 = [["hola", 3, 5], ["buenas", 3, 4]];
        	
        	if (comprovar_arrays($arr1, $arr2)){
        	    echo "True";
        	}else{
        	    echo "False";
        	}
    	?>
</body>
</html>
