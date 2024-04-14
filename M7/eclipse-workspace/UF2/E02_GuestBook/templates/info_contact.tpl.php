<section class="infos">
		<div class="content">
			<div class="grid">
				<div class="float-md-50 wimg">
					<img src="img/contacte.jpg" />
				</div>
				<div class="winfo">
					<h1 class="title"><?php echo $contacteForm;?></h1>
					<p class="form">
						<form action="?contacte/validate" method="post" target=_blank">
    						<input type="text" name="nom" placeholder="<?php echo $contacteNom;?>" value="<?php echo $contacte->nom; ?>">
    						<span class="error"><?php echo $errors["nom"];?></span>
    						<input type="text" name="email" placeholder="<?php echo $contacteMail;?>" value="<?php echo $contacte->mail; ?>">
    						<span class="error"><?php echo $errors["mail"];?></span>
    						<textarea name="missatge" placeholder="<?php echo $contacteMsg;?>"><?php echo $contacte->missatge; ?></textarea>
    						<span class="error"><?php echo $errors["missatge"];?></span>
    						<p class="description"><?php echo $missatgeOK;?></p>
    						<input type="submit" name="boto" value="<?php echo $contacteEnviar;?>" class="btn">
						</form>
					</p>
				</div>


			</div>
		</div>
	</section>
