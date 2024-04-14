<section class="infos">
	<div class="content">
		<div class="grid">
			<div class="float-md-50 wimg"><img src="img/user.png" /></div>
			<div class="winfo">
				<h1 class="title">Sign in</h1>
				<p class="description">Identifica't per accedir</p>
				<p class="form">				
				
				<form action="?user/login" method="post" target=_blank">
					<?php 
					echo $frmNom;
					echo $frmPass;
					?>
					<input type="submit" name="Login" value="login" class="btn">
				</form>

				</p>
				<ul>
					<a href='?user/remenber'>
						<li class="btn">No recordes la contrasenya?</li>
					</a>
					<a href='?user/register'>
						<li class="btn">Ets usuari nou? Dona't d'alta</li>
					</a>
				</ul>
			</div>
		</div>
	</div>
</section>