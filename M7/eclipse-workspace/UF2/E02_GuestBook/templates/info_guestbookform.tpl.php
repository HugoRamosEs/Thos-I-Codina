<section class="infos">
		<div class="content">
			<div class="grid">
				<div class="float-md-50 wimg">
					<img src="img/contacte.jpg" />
				</div>
				<div class="winfo">
					<h1 class="title"><?php echo $mainMenu5;?></h1>
					<p class="form">
						<form action="contacte.php" method="post" target=_blank">
    						<?php 
    						  echo $input_nom;
    						  echo $input_mail;
    						  echo "<p class='form'>Com ha sigut la teva experiència</p>";
    						  echo $select_Experiencia;
    						  echo $input_missatge;
    						?>    					
    						<p class="description"><?php echo $missatgeOK;?></p>
    						<input type="submit" name="boto" value="<?php echo $contacteEnviar;?>" class="btn">
						</form>
					</p>
				</div>


			</div>
		</div>
	</section>