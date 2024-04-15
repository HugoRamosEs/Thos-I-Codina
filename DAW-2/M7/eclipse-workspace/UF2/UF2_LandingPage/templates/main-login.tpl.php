<main>
	<div class="contenedor-main">
		<h2>E02_Login</h2>
		<div id="form-contacte">
			<form id="form-contacte" action="" method="post">
				<h2>Inicia Sessió</h2>
				<div class="form-img">
					<img src="img/login.png" alt="login.png">
				</div>
				<div class="errors"><span class="error"><?php echo $frmErrors["db"];?></span></div>
				<div class="errors"><span class="error"><?php echo $frmErrors["status"];?></span></div>
				<label for="email">Email</label> 
				<input type="email" id="email" name="email" placeholder="Escriu el teu email..." value="<?php echo $usuari->email;?>">
				<div class="errors"><span class="error"><?php echo $frmErrors["email1"];?></span></div>
				<label for="password">Contrasenya</label>
				<input type="password" id="password" name="password" placeholder="Escriu la teva contrasenya..." value="<?php echo $usuari->password;?>"> 
				<div class="errors"><span class="error"><?php echo $frmErrors["password1"];?></span></div>
				<input type="submit" id="enviar" name="enviar" value="Enviar">
				<a href="?Usuari/signup">No temps compte? Fes clic aquí per crear-la!</a>
			</form>
		</div>
	</div>
</main>
