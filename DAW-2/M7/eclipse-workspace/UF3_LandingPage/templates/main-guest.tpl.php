<main>
	<div class="contenedor-main">
		<h2>E01_Llibre-de-visites</h2>
		<form id="form-guest" action="" method="post">
			<input type="text" id="nom" name="nom" placeholder="Escriu el teu nom..." value="<?php echo $comentari->nom;?>"> 
			<input type="email" id="email" name="email" placeholder="Escriu el teu email..." value="<?php echo $comentari->mail;?>">
			<select id="seleccio" name="seleccio" required>
				<option value="Molt Bona" <?php echo ($comentari->opcio == "molt bona") ? "selected" : ""; ?>>Molt Bona</option>
				<option value="Bona" <?php echo ($comentari->opcio == "bona") ? "selected" : ""; ?>>Bona</option>
				<option value="Regular" <?php echo ($comentari->opcio == "regular") ? "selected" : ""; ?>>Regular</option>
				<option value="Dolenta" <?php echo ($comentari->opcio == "dolenta") ? "selected" : ""; ?>>Dolenta</option>
				<option value="Molt Dolenta" <?php echo ($comentari->opcio == "molt dolenta") ? "selected" : ""; ?>>Molt Dolenta</option>
			</select>
			<textarea id="missatge" name="missatge" placeholder="Escriu el teu missatge..."><?php echo $comentari->msg;?></textarea>
			<input type="submit" id="enviar" name="enviar" value="Enviar">
			<p class="valid"><?php echo $ok;?></p>
			<div class="errors">
				<span class="error"><?php echo $frmErrors["nom"];?></span>
    			<span class="error"><?php echo $frmErrors["mail"];?></span>
    			<span class="error"><?php echo $frmErrors["seleccio"];?></span> 
    			<span class="error"><?php echo $frmErrors["missatge"];?></span> 
    			<span class="error"><?php echo $frmErrors["classe"];?></span> 
			</div>
		</form>
		<div id="taula-guest"><?php echo $taula;?></div>
	</div>
</main>