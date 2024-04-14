<main>
	<div class="contenedor-main">
		<h2>E01_Llibre-de-visites</h2>
		<form id="form-guest" action="" method="post">
			<input type="text" id="nom" name="nom" placeholder="Escriu el teu nom..." value="<?php echo $frmNom;?>"> 
			<input type="email" id="email" name="email" placeholder="Escriu el teu email..." value="<?php echo $frmMail;?>">
			<select id="seleccio" name="seleccio" required>
				<option value="Molt Bona" <?php echo ($frmOpcio == "molt bona") ? "selected" : ""; ?>>Molt Bona</option>
				<option value="Bona" <?php echo ($frmOpcio == "bona") ? "selected" : ""; ?>>Bona</option>
				<option value="Regular" <?php echo ($frmOpcio == "regular") ? "selected" : ""; ?>>Regular</option>
				<option value="Dolenta" <?php echo ($frmOpcio == "dolenta") ? "selected" : ""; ?>>Dolenta</option>
				<option value="Molt Dolenta" <?php echo ($frmOpcio == "molt dolenta") ? "selected" : ""; ?>>Molt Dolenta</option>
			</select>
			<textarea id="missatge" name="missatge" placeholder="Escriu el teu missatge..."><?php echo $frmMsg;?></textarea>
			<input type="submit" id="enviar" name="enviar" value="Enviar">
			<p class="valid"><?php echo $ok;?></p>
			<div class="errors">
				<span class="error"><?php echo $errors["nom"];?></span>
    			<span class="error"><?php echo $errors["mail"];?></span>
    			<span class="error"><?php echo $errors["seleccio"];?></span> 
    			<span class="error"><?php echo $errors["missatge"];?></span> 
    			<span class="error"><?php echo $errors["classe"];?></span> 
			</div>
		</form>
		<div id="taula-guest"><?php echo $taula;?></div>
	</div>
</main>