<form id="msform" action="<?php echo $self; ?>" method="post" autocomplete="off">
    <fieldset>
    <h2 class="fs-title">LLIBRE DE VISITES</h2>
    <h3 class="fs-subtitle">Signa en el meu llibre de visites i deixa'm un comentari</h3>
    		<span class="error" > <?php echo $this->getErrorsDetectats()["error"];?> </span>
		<input type="text" 	name="nom"		placeholder="Nom i Cognoms (Obligatori)" class="llarg" value="<?php echo $this->getComentari()->getNom();?>"/>
			<span class="error" > <?php echo $this->getErrorsDetectats()["nom"];?> </span>
		<input type="text" 	name="email" 	placeholder="email (Obligatori)" class="llarg" value="<?php echo $this->getComentari()->getEmail();?>" />
			<span class="error" > <?php echo $this->getErrorsDetectats()["email"];?> </span>
		<select class="llarg" name="pais" >
			<?php echo $this->getPaisos(); ?>
		</select>
				<span class="error" > <?php echo $this->getErrorsDetectats()["pais"];?> </span>
    
			<label for="experiencia">Cón ha sigut la teva experiència?</label>
				<?php echo $this->getExperiencies(); ?>
		<span class="error" > <?php echo $this->getErrorsDetectats()["experiencia"];?> </span>
    
		<textarea class="llarg" placeholder="Escriu el teu comentari" name="comentari" ><?php echo $this->getComentari()->getComentari();?></textarea>
			<span class="error" > <?php echo $this->getErrorsDetectats()["comentari"];?> </span>
    
		<input type="submit" name="submit" class="submit action-button" value="Signa" />
	</fieldset>
</form>
