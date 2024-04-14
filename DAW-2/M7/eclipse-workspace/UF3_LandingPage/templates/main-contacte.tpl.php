<main>
	<div class="contenedor-main">
		<h2>E11_Formulari</h2>
		<div id="form-contacte">
			<form id="form-contacte" action="" method="post">
				<h2>Contacta'm</h2>
				<div class="form-img">
					<img src="img/contacte.png" alt="contacte.png">
				</div>
				<label for="nom">Nom</label>
				<input type="text" id="nom" name="nom" placeholder="Escriu el teu nom..." value="<?php echo $contacte->nom;?>"> 
				<div class="errors"><span class="error"><?php echo $frmErrors["nom"];?></span></div>
				<label for="email">Email</label>
				<input type="email" id="email" name="email" placeholder="Escriu el teu email..." value="<?php echo $contacte->mail;?>">
				<div class="errors"><span class="error"><?php echo $frmErrors["mail"];?></span></div>
				<label for="missatge">Missatge</label>
				<textarea id="missatge" name="missatge" placeholder="Escriu el teu missatge..."><?php echo $contacte->msg;?></textarea>
				<div class="errors"><span class="error"><?php echo $frmErrors["missatge"];?></span></div>
				<input type="submit" id="enviar" name="enviar" value="Enviar">
				<!-- <a href="docs/contacte.xml">XML</a> -->
				<p style=color:green class="valid"><?php echo $ok;?></p>
			</form>
		</div>
	</div>
</main>