	<!-- multistep form -->
	<form id="msform" action="<?php echo $self; ?>" method="post" autocomplete="off" enctype="multipart/form-data">
		<!-- progressbar -->
		<ul id="progressbar">
			<li class="active">Dades d'accés</li>
			<li>Dades Personals</li>
			<li>Altres dades</li>
		</ul>
		<!-- fieldsets -->
		<fieldset>
			<h2 class="fs-title">Crea el teu compte d'usuari</h2>
			<h3 class="fs-subtitle">Aquest és el primer pas</h3>
				<span class="error" > <?php echo $this->getErrorsDetectats()["error"];?> </span>
			
			<input type="text" 	name="email" 	placeholder="email (Obligatori)" class="llarg" value="<?php echo $this->getUser()->getEmail();?>" /> 
				<span class="error" > <?php echo $this->getErrorsDetectats()["email"];?> </span>
			<input type="password" name="pass" 	placeholder="Contrasenya (Obligatori)" class="llarg" value="<?php echo $this->getUser()->getPassword();?>" />
				<span class="error" > <?php echo $this->getErrorsDetectats()["pass"];?> </span>
			<input type="password" name="cpass" placeholder="Confirma la contrasenya (Obligatori)" class="llarg" value="<?php echo $this->getUser()->getPassword();?>"/>
				<span class="error" > <?php echo $this->getErrorsDetectats()["cpass"];?> </span>
			 
			<input type="button" name="next" class="next action-button" value="Next" /> 
		</fieldset>
		<fieldset>
			<h2 class="fs-title">Dades personals</h2>
			<h3 class="fs-subtitle">Entra les teves dades personals</h3>
			<select class="curt" name="tipus" >
				<option value="NIF" selected="selected">NIF: Número d'Identificació Fiscal</option>
				<option value="NIE">NIE: Número d'Identificació d'Extranjers</option>
				<option value="PAS">PAS: Passaport</option>
			</select>
				<span class="error" > <?php echo $this->getErrorsDetectats()["tipus"];?> </span>
			<input type="text"	name="dni" 		placeholder="DNI (Obligatori)" 	class="curt" value="<?php echo $this->getUser()->getNumeroIdent();?>"/>
				<span class="error" > <?php echo $this->getErrorsDetectats()["dni"];?> </span>
			<input type="text" 	name="nom" 		placeholder="Nom (Obligatori)" 	class="llarg" value="<?php echo $this->getUser()->getNom();?>"/> 
				<span class="error" > <?php echo $this->getErrorsDetectats()["nom"];?> </span>
			<input type="text"	name="cognoms" 	placeholder="Cognoms (Obligatori)" class="llarg" value="<?php echo $this->getUser()->getCognoms();?>"/>
				<span class="error" > <?php echo $this->getErrorsDetectats()["cognoms"];?> </span>
			<select name="sexe" class="llarg">
				<option value="H" >Home</option>
				<option value="D" selected="selected">Dona</option>
			</select><span class="error" > <?php echo $this->getErrorsDetectats()["sexe"];?> </span></td> 
				<span class="error" > <?php echo $this->getErrorsDetectats()["sexe"];?> </span>
			<input type="text"	name="naixement" placeholder="Data de naixement (Obligatori)" class="llarg" value="<?php echo $this->getUser()->getDatanaixement();?>"/>
				<span class="error" > <?php echo $this->getErrorsDetectats()["dNaixement"];?> </span>
			<input type="button" name="previous" class="previous action-button" value="Previous" /> 
			<input type="button" name="next" class="next action-button" value="Next" />
		</fieldset>
		<fieldset>
			<h2 class="fs-title">Altres dades</h2>
			<h3 class="fs-subtitle">Si vols, pots afegir una imatge teva</h3>
			<input type="text"	name="adreca"	placeholder="Adreça" class="llarg" value="<?php echo $this->getUser()->getAdreca();?>"/> 
				<span class="error" > <?php echo $this->getErrorsDetectats()["adreca"];?> </span>
			<input type="text" 	name="cp"		placeholder="C.P."	class="curt" value="<?php echo $this->getUser()->getCodiPostal();?>"/> 
				<span class="error" > <?php echo $this->getErrorsDetectats()["cp"];?> </span>
			<input type="text" 	name="poblacio"	placeholder="Població" class="curt" value="<?php echo $this->getUser()->getPoblacio();?>"/> 
				<span class="error" > <?php echo $this->getErrorsDetectats()["poblacio"];?> </span>
			<input type="text" 	name="provincia" placeholder="Provincia" class="curt" value="<?php echo $this->getUser()->getProvincia();?>"/>
				<span class="error" > <?php echo $this->getErrorsDetectats()["provincia"];?> </span> 
			<input type="text" 	name="telefon"	placeholder="Teléfon" class="curt" value="<?php echo $this->getUser()->getTelefon();?>"/> 
				<span class="error" > <?php echo $this->getErrorsDetectats()["telefon"];?> </span>
			<label for="imatge">Selecciona una imatge teva</label>
            <input type="hidden"name="MAX_FILE_SIZE" value="2097152" />
			<input name="imatge" type="file" class="llarg" value = "<?php echo $this->getUser()->getImatge(); ?>"/>
				<span class="error" style="color:red;"> <?php echo $this->getErrorsDetectats()["imatge"];?> </span>
				<span class="error" style="color:red;"> <?php echo $this->getErrorsDetectats()["baseDades"];?> </span>
			
			<input type="button" name="previous" class="previous action-button" value="Previous" /> 
			<input type="submit" name="submit" class="submit action-button" value="Envia" />
		</fieldset>
	</form>


	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js'></script>

	<script src="js/index.js"></script>


