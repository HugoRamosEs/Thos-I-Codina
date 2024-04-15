<form id="msform" action="index.php" method="post">
    <fieldset>
        <h2 class="fs-title">IDENTIFICA'T</h2>
        <h3 class="fs-subtitle">Per accedir al contingut de la meva pàgina, t'has d'identificar</h3>
 
 		<input type="text" 	class="llarg" name="usuari"		placeholder="Email (Obligatori)" class="llarg" value="<?php echo $this->getUser()->getEmail();?>"/>
			<span class="error" > <?php echo $this->getErrorsDetectats()["usuari"];?> </span>
		<input type="text" 	class="llarg" name="contrasenya" 	placeholder="Contrasenya (Obligatori)" class="llarg" value="<?php echo $this->getUser()->getPassword();?>" />
			<span class="error" > <?php echo $this->getErrorsDetectats()["password"];?> </span>
		<div></div><a class="llarg" href='index.php?pg=97'>Si no ets usuari, registra't</a></div>
		<div><a class="llarg" href='registre.php'>Si no t'enrecordes de la contrasenya, clica aquí</a></div>
    
		<input type="submit" name="submit" class="submit action-button" value="Verifica" />
   </fieldset>
</form>
