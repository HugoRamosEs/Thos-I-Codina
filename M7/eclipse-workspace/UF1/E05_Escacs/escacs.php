<html>
<body>
	<h1>E05_Escacs</h1>
	<table style="border: 2px solid black; border-collapse: collapse">
		<?php 
		error_reporting(E_ALL);
		ini_set("display_errors",1);
		$num = 8;
		for ($i = 0; $i < $num; $i++) {?>
		<tr>
			<?php 
    			for ($j = 0; $j < $num; $j++) {
    			    $color = ($i + $j) % 2 == 0 ? 'white' : 'black';
    			    echo '<td style="width: 55px; height: 55px; background-color: ' . $color . ';"></td>';
    			}
		}
			?>
		</tr>
	</table>
</body>
</html>