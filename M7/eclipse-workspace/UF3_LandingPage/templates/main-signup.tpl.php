<main>
	<div class="contenedor-main">
		<h2>E02_Registre</h2>
		<div id="form-singup">
			<form id="form-singup" action="" method="post" enctype="multipart/form-data">
				<h2>Registrar-se</h2>
				<h3>Obligatori</h3>
				<div class="sEmail">
					<label for="email">Email</label>
					<input type="email" id="email" name="email" placeholder="Escriu el teu email..." value="<?php echo $usuari->email;?>">
					<div class="errors"><span class="error"><?php echo $frmErrors["email"];?></span></div>
				</div>
				<div class="sContrasenya">
					<label for="password">Contrasenya</label>
					<input type="password" id="password" name="password" placeholder="Introdueix una contrasenya..." value="<?php echo $usuari->password;?>">
					<div class="errors"><span class="error"><?php echo $frmErrors["password1"];?></span></div>
					<div class="errors"><span class="error"><?php echo $frmErrors["password2"];?></span></div>
					<div class="errors"><span class="error"><?php echo $frmErrors["password3"];?></span></div>
					<div class="errors"><span class="error"><?php echo $frmErrors["password4"];?></span></div>
				</div>
				<div class="sContrasenya">
					<label for="password2">Contrasenya Repetida</label>
					<input type="password" id="password2" name="password2" placeholder="Introdueix la mateixa contrasenya..." value="<?php echo $frmPassword2;?>">
					<div class="errors"><span class="error"><?php echo $frmErrors["password5"];?></span></div>
				</div>
				<div class="sTipusIdent">
					<label for="tipusIdent">Tipus Identificador</label> 
    				<select id="tipusIdent" name="tipusIdent">
        				<option value="Nif" <?php echo ($usuari->tipusIdent == "Nif") ? "selected" : ""; ?>>Nif</option>
        				<option value="Nie" <?php echo ($usuari->tipusIdent == "Nie") ? "selected" : ""; ?>>Nie</option>
        				<option value="Pasaport" <?php echo ($usuari->tipusIdent == "Pasaport") ? "selected" : ""; ?>>Pasaport</option>
        			</select>
        			<div class="errors"><span class="error"><?php echo $frmErrors["tipusIdent"];?></span></div>
				</div>
				<div class="sNumeroIdent">
					<label for="numeroIdent">Número Identificador</label>
					<input type="text" id="numeroIdent" name="numeroIdent" placeholder="Escriu el teu identificador..." value="<?php echo $usuari->numeroIdent;?>">
					<div class="errors"><span class="error"><?php echo $frmErrors["numeroIdent1"];?></span></div>
					<div class="errors"><span class="error"><?php echo $frmErrors["numeroIdent2"];?></span></div>
				</div>
				<div class="sNom">
					<label for="nom">Nom</label>
					<input type="text" id="nom" name="nom" placeholder="Escriu el teu nom..." value="<?php echo $usuari->nom;?>">
					<div class="errors"><span class="error"><?php echo $frmErrors["nom"];?></span></div> 
				</div>
				<div class="sCognoms">
					<label for="cognoms">Cognoms</label>
					<input type="text" id="cognoms" name="cognoms" placeholder="Escriu els teus cognoms..." value="<?php echo $usuari->cognoms;?>">
					<div class="errors"><span class="error"><?php echo $frmErrors["cognoms"];?></span></div> 
				</div>
				<div class="sNaixement">
					<label for="naixement">Data de naixament</label>
					<input type="text" id="naixement" name="naixement" placeholder="Introdueix la data de naixement (d/m/a)..." value="<?php echo $usuari->naixement;?>">
					<div class="errors"><span class="error"><?php echo $frmErrors["naixement1"];?></span></div>
					<div class="errors"><span class="error"><?php echo $frmErrors["naixement2"];?></span></div> 
				</div>
				<div class="sSexe">
					<label for="sexe">Sexe</label> 
    				<select id="sexe" name="sexe">
        				<option value="Home" <?php echo ($usuari->sexe == "Home") ? "selected" : ""; ?>>Home</option>
        				<option value="Dona" <?php echo ($usuari->sexe == "Dona") ? "selected" : ""; ?>>Dona</option>
        			</select>
        			<div class="errors"><span class="error"><?php echo $frmErrors["sexe"];?></span></div> 
				</div>
				<div class="sImatge">
					<label for="imatge">Imatge</label> 
					<input type="file" id="imatge" name="imatge"> 
					<div class="errors"><span class="error"><?php echo $frmErrors["imatge1"];?></span></div> 
					<div class="errors"><span class="error"><?php echo $frmErrors["imatge2"];?></span></div>
					<div class="errors"><span class="error"><?php echo $frmErrors["imatge3"];?></span></div>
					<div class="errors"><span class="error"><?php echo $frmErrors["imatge4"];?></span></div>    
				</div>
				<h3 class="sH3">Opcional</h3>
				<div class="sAdreca">
					<label for="adreca">Adreça</label> 
					<input type="text" id="adreca" name="adreca" placeholder="Escriu la teva adreça..." value="<?php echo $usuari->adreca;?>">
				</div>
				<div class="sCodiPostal">
					<label for="codiPostal">Codi Postal</label> 
					<input type="text" id="codiPostal" name="codiPostal" placeholder="Escriu el teu codi postal..." value="<?php echo $usuari->codiPostal;?>">
					<div class="errors"><span class="error"><?php echo $frmErrors["codiPostal"];?></span></div> 
				</div>
				<div class="sPoblacio">
					<label for="poblacio">Població</label> 
					<input type="text" id="poblacio" name="poblacio" placeholder="Escriu la teva poblacio..." value="<?php echo $usuari->poblacio;?>">
				</div>
				<div class="sProvincia">
					<label for="provincia">Província</label> 
    				<select id="provincia" name="provincia">
    					<option value="" selected <?php echo ($usuari->provincia == "") ? "selected" : ""; ?>>- Selecciona una opció -</option>
        				<option value="Alava" <?php echo ($usuari->provincia == "Alava" ) ? "selected" : ""; ?>>Alava</option>
        				<option value="Albacete" <?php echo ($usuari->provincia == "Albacete") ? "selected" : ""; ?>>Albacete</option>
        				<option value="Alicante" <?php echo ($usuari->provincia == "Alicante") ? "selected" : ""; ?>>Alicante</option>
        				<option value="Almeria" <?php echo ($usuari->provincia == "Almeria") ? "selected" : ""; ?>>Almeria</option>
        				<option value="Asturias" <?php echo ($usuari->provincia == "Asturias") ? "selected" : ""; ?>>Asturias</option>
        				<option value="Avila" <?php echo ($usuari->provincia == "Avila") ? "selected" : ""; ?>>Avila</option>
        				<option value="Badajoz" <?php echo ($usuari->provincia == "Badajoz") ? "selected" : ""; ?>>Badajoz</option>
        				<option value="Barcelona" <?php echo ($usuari->provincia == "Barcelona") ? "selected" : ""; ?>>Barcelona</option>
        				<option value="Burgos" <?php echo ($usuari->provincia == "Burgos") ? "selected" : ""; ?>>Burgos</option>
        				<option value="Caceres" <?php echo ($usuari->provincia == "Caceres") ? "selected" : ""; ?>>Caceres</option>
        				<option value="Cadiz" <?php echo ($usuari->provincia == "Cadiz") ? "selected" : ""; ?>>Cadiz</option>
        				<option value="Cantabria" <?php echo ($usuari->provincia == "Cantabria") ? "selected" : ""; ?>>Cantabria</option>
        				<option value="Castellon" <?php echo ($usuari->provincia == "Castellon") ? "selected" : ""; ?>>Castellon</option>
        				<option value="Ciudad Real" <?php echo ($usuari->provincia == "Ciudad Real") ? "selected" : ""; ?>>Ciudad Real</option>
        				<option value="Cordoba" <?php echo ($usuari->provincia == "Cordoba") ? "selected" : ""; ?>>Cordoba</option>
        				<option value="Cuenca" <?php echo ($usuari->provincia == "Cuenca") ? "selected" : ""; ?>>Cuenca</option>
        				<option value="Gerona" <?php echo ($usuari->provincia == "Gerona") ? "selected" : ""; ?>>Gerona</option>
        				<option value="Granada" <?php echo ($usuari->provincia == "Granada") ? "selected" : ""; ?>>Granada</option>
        				<option value="Guadalajara" <?php echo ($usuari->provincia == "Guadalajara") ? "selected" : ""; ?>>Guadalajara</option>
        				<option value="Guipuzcoa" <?php echo ($usuari->provincia == "Guipuzcoa") ? "selected" : ""; ?>>Guipuzcoa</option>
        				<option value="Huelva" <?php echo ($usuari->provincia == "Huelva") ? "selected" : ""; ?>>Huelva</option>
        				<option value="Huesca" <?php echo ($usuari->provincia == "Huesca") ? "selected" : ""; ?>>Huesca</option>
        				<option value="Islas Balears" <?php echo ($usuari->provincia == "Islas Balears") ? "selected" : ""; ?>>Islas Balears</option>
        				<option value="Jaen" <?php echo ($usuari->provincia == "Jaen") ? "selected" : ""; ?>>Jaen</option>
        				<option value="La Coruña" <?php echo ($usuari->provincia == "La Coruña") ? "selected" : ""; ?>>La Coruña</option>
        				<option value="La Rioja" <?php echo ($usuari->provincia == "La Rioja") ? "selected" : ""; ?>>La Rioja</option>
        				<option value="Las Palmas" <?php echo ($usuari->provincia == "Las Palmas") ? "selected" : ""; ?>>Las Palmas</option>
        				<option value="Leon" <?php echo ($usuari->provincia == "Leon") ? "selected" : ""; ?>>Leon</option>
        				<option value="Lerida" <?php echo ($usuari->provincia == "Lerida") ? "selected" : ""; ?>>Lerida</option>
        				<option value="Lugo" <?php echo ($usuari->provincia == "Lugo") ? "selected" : ""; ?>>Lugo</option>
        				<option value="Madrid" <?php echo ($usuari->provincia == "Madrid") ? "selected" : ""; ?>>Madrid</option>
        				<option value="Malaga" <?php echo ($usuari->provincia == "Malaga") ? "selected" : ""; ?>>Malaga</option>
        				<option value="Murcia" <?php echo ($usuari->provincia == "Murcia") ? "selected" : ""; ?>>Murcia</option>
        				<option value="Navarra" <?php echo ($usuari->provincia == "Navarra") ? "selected" : ""; ?>>Navarra</option>
        				<option value="Orense" <?php echo ($usuari->provincia == "Orense") ? "selected" : ""; ?>>Orense</option>
        				<option value="Palencia" <?php echo ($usuari->provincia == "Palencia") ? "selected" : ""; ?>>Palencia</option>
        				<option value="Pontevedra" <?php echo ($usuari->provincia == "Pontevedra") ? "selected" : ""; ?>>Pontevedra</option>
        				<option value="Salamanca" <?php echo ($usuari->provincia == "Salamanca") ? "selected" : ""; ?>>Salamanca</option>
        				<option value="Santa Cruz de Tenerife" <?php echo ($usuari->provincia == "Santa Cruz de Tenerife") ? "selected" : ""; ?>>Santa Cruz de Tenerife</option>
        				<option value="Segovia" <?php echo ($usuari->provincia == "Segovia") ? "selected" : ""; ?>>Segovia</option>
        				<option value="Sevilla" <?php echo ($usuari->provincia == "Sevilla") ? "selected" : ""; ?>>Sevilla</option>
        				<option value="Soria" <?php echo ($usuari->provincia == "Soria") ? "selected" : ""; ?>>Soria</option>
        				<option value="Tarragona" <?php echo ($usuari->provincia == "Tarragona") ? "selected" : ""; ?>>Tarragona</option>
        				<option value="Teruel" <?php echo ($usuari->provincia == "Teruel") ? "selected" : ""; ?>>Teruel</option>
        				<option value="Toledo" <?php echo ($usuari->provincia == "Toledo") ? "selected" : ""; ?>>Toledo</option>
        				<option value="Valencia" <?php echo ($usuari->provincia == "Valencia") ? "selected" : ""; ?>>Valencia</option>
        				<option value="Valladolid" <?php echo ($usuari->provincia == "Valladolid") ? "selected" : ""; ?>>Valladolid</option>
        				<option value="Vizcaya" <?php echo ($usuari->provincia == "Vizcaya") ? "selected" : ""; ?>>Vizcaya</option>
        				<option value="Zamora" <?php echo ($usuari->provincia == "Zamora") ? "selected" : ""; ?>>Zamora</option>
        				<option value="Zaragoza" <?php echo ($usuari->provincia == "Zaragoza") ? "selected" : ""; ?>>Zaragoza</option>
        			</select>
        			<div class="errors"><span class="error"><?php echo $frmErrors["provincia"];?></span></div> 
				</div>
				<div class="sTelefon">
					<label for="telefon">Telefón</label> 
					<input type="text" id="telefon" name="telefon" placeholder="Escriu el teu telefon..." value="<?php echo $usuari->telefon;?>">
					<div class="errors"><span class="error"><?php echo $frmErrors["telefon"];?></span></div> 
				</div>
				<input type="submit" id="enviar" name="enviar" value="Enviar">
				<div class="sLink"><a href="?Usuari/login">Tens compte? Fes clic aquí per iniciar sessió!</a></div>
			</form>
		</div>
	</div>
</main>