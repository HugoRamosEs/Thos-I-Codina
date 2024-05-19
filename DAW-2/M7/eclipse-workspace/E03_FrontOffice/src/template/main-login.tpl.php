<main>
	<div class="contenedor-main">
		<h2>Compte</h2>
		<div class="form">
			<form id="form-usuari-login" action="" method="post">
				<h2>Iniciar sessió</h2>
				<div class="form-img"><img src="../src/img/login.jpg" alt="login"></div>
				<div class="ok"<?php if (empty($ok)) {echo 'style="display: none;"';} ?>>
    				<span class="ok"><?php echo $ok; ?></span>
				</div>
    			<div class="errors-2"<?php if (empty($error)) {echo 'style="display: none;"';} ?>>
    				<span class="error"><?php echo $error; ?></span>
				</div>
    			<fieldset>
    			    <legend>Requerit</legend>
    				<label for="email">Email</label> 
    				<input type="email" id="email" name="email" placeholder="Escriu el teu email..." value="<?php echo $user->getEmail();?>">
    				<div class="errors"><span class="error"><?php echo $frmErrors["email1"];?></span></div>
    				<div class="errors"><span class="error"><?php echo $frmErrors["email2"];?></span></div>
    				<label for="password">Contrasenya</label>
    				<input type="password" id="password" name="password" placeholder="Escriu la teva contrasenya..." value="<?php echo $user->getPassword();?>"> 
    				<div class="errors"><span class="error"><?php echo $frmErrors["password1"];?></span></div>
				</fieldset>
				<input type="submit" id="enviar" name="enviar" value="Enviar">
				<a href="?User/signup">No temps compte? Fes clic aquí per crear-la!</a>
			</form>
		</div>
	</div>
</main>
