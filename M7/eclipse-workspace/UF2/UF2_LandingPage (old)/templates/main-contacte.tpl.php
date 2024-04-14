<main>
	<div class="contenedor-main">
		<h2>E11_Formulari</h2>
		<div id="form-contacte">
			<form id="form-contacte" action="" method="post">
				<h2>Contacta'm</h2>
				<div class="form-img">
					<img src="img/contacte.png" alt="contacte.png">
				</div>
				<input type="text" id="nom" name="nom" placeholder="Escriu el teu nom..." value="<?php echo $frmNom;?>"> 
				<input type="email" id="email" name="email" placeholder="Escriu el teu email..." value="<?php echo $frmMail;?>">
				<textarea id="missatge" name="missatge" placeholder="Escriu el teu missatge..."><?php echo $frmMsg;?></textarea>
				<input type="submit" id="enviar" name="enviar" value="Enviar">
				<a href="docs/contacte.xml">XML</a>
				<p style=color:green class="valid"><?php echo $ok;?></p>
    			<div class="errors">
    				<span class="error"><?php echo $errors["nom"];?></span>
        			<span class="error"><?php echo $errors["mail"];?></span>
        			<span class="error"><?php echo $errors["missatge"];?></span> 
    			</div>
			</form>
		</div>
	</div>
</main>