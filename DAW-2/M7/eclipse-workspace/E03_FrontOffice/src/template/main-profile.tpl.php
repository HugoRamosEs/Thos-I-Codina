<main>
	<div class="contenedor-main">
		<h2>Perfil</h2>
		<div class="main-profile">
			<div class="main-profile-user">
				<img src="../src/img/profile.png" alt="profile.png">
				<div class="main-profile-dades">
    				<h3><?php echo $user->getName() . " " . $user->getSurname();?></h3>
    				<table>
    					<thead>
    						<tr>
    							<th>Dada</th>
    							<th>Data</th>
    							<th>Hora</th>
    						</tr>
    					</thead>
    					<tbody>
    						<tr>
    							<td>Registre</td>
    							<td><?php echo date('d/m/Y', strtotime($user->getDateCreated())); ?></td>
    							<td><?php echo date('H:i:s', strtotime($user->getDateCreated())); ?></td>
    						</tr>
							<tr>
								<td>Actualització</td>
								<td><?php echo date('d/m/Y', strtotime($user->getDateUpdated())); ?></td>
								<td><?php echo date('H:i:s', strtotime($user->getDateUpdated())); ?></td>
							</tr>
						</tbody>
    				</table>
					<div class="ok"<?php if (empty($ok)) {echo 'style="display: none;"';} ?>>
    					<span class="ok"><?php echo $ok; ?></span>
    				</div>
        			<div class="errors-2"<?php if (empty($error)) {echo 'style="display: none;"';} ?>>
        				<span class="error"><?php echo $error; ?></span>
    				</div>
				</div>
			</div>
			<div class="form-update">
				<div class="form">
        			<form id="form-usuari-modify" action="" method="post">
        				<h2>Modificar</h2>
        				<div class="errors-2"<?php if (empty($error)) {echo 'style="display: none;"';} ?>>
            				<span class="error"><?php echo $error; ?></span>
        				</div>
        				<fieldset>
        				    <legend>Requerit</legend>
        				    <div>
        				    	<label for="name">Nom</label>
                        		<input type="text" id="name" name="name" placeholder="Escriu el teu nom..." value="<?php echo $user->getName();?>">
                        		<div class="errors"><span class="error"><?php echo $frmErrors["name1"];?></span></div> 
                        		<div class="errors"><span class="error"><?php echo $frmErrors["name2"];?></span></div> 
        				    </div>
        				    <div>
        				    	<label for="surname">Cognom</label>
                        		<input type="text" id="surname" name="surname" placeholder="Escriu el teu cognom..." value="<?php echo $user->getSurname();?>">
                        		<div class="errors"><span class="error"><?php echo $frmErrors["surname1"];?></span></div> 
                        		<div class="errors"><span class="error"><?php echo $frmErrors["surname2"];?></span></div> 
        				    </div>
        				    <div>
        				    	<label for="email">Email</label> 
                				<input type="email" id="email" name="email" placeholder="Escriu el teu email..." value="<?php echo $user->getEmail();?>">
                				<div class="errors"><span class="error"><?php echo $frmErrors["email1"];?></span></div>
                				<div class="errors"><span class="error"><?php echo $frmErrors["email2"];?></span></div>
                				<div class="errors"><span class="error"><?php echo $frmErrors["email3"];?></span></div>
        				    </div>
        				    <div>
        				    	<label for="password">Contrasenya</label>
                				<input type="password" id="password" name="password" placeholder="Escriu la teva contrasenya..." value="<?php echo $user->getPassword();?>"> 
                				<div class="errors"><span class="error"><?php echo $frmErrors["password1"];?></span></div>
                				<div class="errors"><span class="error"><?php echo $frmErrors["password2"];?></span></div>
                				<div class="errors"><span class="error"><?php echo $frmErrors["password3"];?></span></div>
        				    </div>
            				<div>
            					<label for="phone">Telèfon</label>
                    			<input type="text" id="phone" name="phone" placeholder="Escriu el teu telèfon..." value="<?php echo $user->getPhone();?>">
                    			<div class="errors"><span class="error"><?php echo $frmErrors["phone1"];?></span></div> 
            				</div>
            				<div>
            					<label for="dateOfBirth">Data de naixament</label>
                    			<input type="text" id="dateOfBirth" name="dateOfBirth" placeholder="Escriu la teva data de naixament..." value="<?php echo $user->getDateOfBirth();?>">
                    			<div class="errors"><span class="error"><?php echo $frmErrors["dateOfBirth1"];?></span></div> 
            				</div>
        				</fieldset>
        				<input type="submit" id="enviar" name="enviar" value="Enviar">
        			</form>
				</div>
			</div>
		</div>
	</div>
</main>