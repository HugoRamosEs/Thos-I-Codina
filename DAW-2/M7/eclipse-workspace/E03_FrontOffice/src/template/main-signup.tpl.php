<main>
	<div class="contenedor-main">
		<h2>Compte</h2>
		<div class="form">
			<form id="form-usuari-signup" action="" method="post">
				<h2>Registrar-se</h2>
				<div class="form-img"><img src="../src/img/signup.jpg" alt="signup"></div>
				<div class="errors-2"<?php if (empty($error)) {echo 'style="display: none;"';} ?>>
    				<span class="error"><?php echo $error; ?></span>
				</div>
				<fieldset>
				    <legend>Requerit</legend>
					<label for="name">Nom</label>
            		<input type="text" id="name" name="name" placeholder="Escriu el teu nom..." value="<?php echo $user->getName();?>">
            		<div class="errors"><span class="error"><?php echo $frmErrors["name1"];?></span></div> 
            		<div class="errors"><span class="error"><?php echo $frmErrors["name2"];?></span></div> 
        			<label for="surname">Cognom</label>
            		<input type="text" id="surname" name="surname" placeholder="Escriu el teu cognom..." value="<?php echo $user->getSurname();?>">
            		<div class="errors"><span class="error"><?php echo $frmErrors["surname1"];?></span></div> 
            		<div class="errors"><span class="error"><?php echo $frmErrors["surname2"];?></span></div> 
    				<label for="email">Email</label> 
    				<input type="email" id="email" name="email" placeholder="Escriu el teu email..." value="<?php echo $user->getEmail();?>">
    				<div class="errors"><span class="error"><?php echo $frmErrors["email1"];?></span></div>
    				<div class="errors"><span class="error"><?php echo $frmErrors["email2"];?></span></div>
    				<div class="errors"><span class="error"><?php echo $frmErrors["email3"];?></span></div>
    				<label for="password">Contrasenya</label>
    				<input type="password" id="password" name="password" placeholder="Escriu la teva contrasenya..." value="<?php echo $user->getPassword();?>"> 
    				<div class="errors"><span class="error"><?php echo $frmErrors["password1"];?></span></div>
    				<div class="errors"><span class="error"><?php echo $frmErrors["password2"];?></span></div>
    				<div class="errors"><span class="error"><?php echo $frmErrors["password3"];?></span></div>
    				<label for="password">Repetir Contrasenya</label>
    				<input type="password" id="password2" name="password2" placeholder="Repeteix la teva contrasenya..." value="<?php echo $frmPassword2;?>"> 
    				<div class="errors"><span class="error"><?php echo $frmErrors["password21"];?></span></div>
    				<div class="errors"><span class="error"><?php echo $frmErrors["password22"];?></span></div>
				</fieldset>
				<fieldset>
					<legend>Opcional</legend>
    				<label for="phone">Telèfon</label>
        			<input type="text" id="phone" name="phone" placeholder="Escriu el teu telèfon..." value="<?php echo $user->getPhone();?>">
        			<div class="errors"><span class="error"><?php echo $frmErrors["phone1"];?></span></div> 
        			<label for="dateOfBirth">Data de naixament</label>
        			<input type="text" id="dateOfBirth" name="dateOfBirth" placeholder="Escriu la teva data de naixament..." value="<?php echo $user->getDateOfBirth();?>">
        			<div class="errors"><span class="error"><?php echo $frmErrors["dateOfBirth1"];?></span></div> 
				</fieldset>
				<input type="submit" id="enviar" name="enviar" value="Enviar">
				<a href="?User/login">Tens compte? Fes clic aquí per iniciar sessió!</a>
			</form>
		</div>
	</div>
</main>

