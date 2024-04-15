<form id="msform" action="index.php" method="post" autocomplete="off">
	<fieldset>
		<h1> Hi ha hagut una error a  Toni's Web Page </h1>
		<hr /> <br>
		<h3> En el procés 	<?php echo $this->getThrownException()->getCodi();?> ha sortit l'error:</h3>
		<h5> <?php echo $this->getThrownException();?></h5>
		<h5> Codi d'error: 	<?php echo $this->getThrownException()->getErrorCode();?></h5>
		<h6> <?php echo $this->getThrownException()->getPrevious();?></h6>
		<h3> Posa't en contacte amb l'administrador de la web: toni@myweb.cat </h3>
	</fieldset>
<?php 
echo "<p><a href='confirmacio.php?tipo=conf&cod=".$_GET["reg"]."'>http://localhost/confirmacio/index.php?tipo=conf&cod=".$_GET["reg"]."</a>\n<p>";
?>
		
	</fieldset>
</form>
