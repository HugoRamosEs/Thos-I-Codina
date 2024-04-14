<form id="msform" action="index.php" method="post" autocomplete="off">
	<fieldset>
		<h1> Wellcome to Toni's Web Page </h1>
		<hr /> <br>
		<h3> El procés de registre a finalitzat correctament</h3>
		<h3> Benvingut al meu club </h3>
<?php 
echo "<p><a href='index.php?tipo=conf&cod=".$_GET["reg"]."'>http://localhost/confirmacio/index.php?tipo=conf&cod=".$_GET["reg"]."</a>\n<p>";
?>
		
	</fieldset>
</form>
