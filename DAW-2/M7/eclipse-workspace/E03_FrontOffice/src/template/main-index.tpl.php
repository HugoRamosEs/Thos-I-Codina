<main>
	<div class="contenedor-main">
		<h2>Introducció</h2>
		<p id="desc1">Explora, tria i gaudeix: benvingut a TicketTune, la teva plataforma de venda d’entrades en línia. Amb nosaltres, 
		              descobriràs un món de melodies i ritmes, una àmplia selecció d’esdeveniments musicals, dates i opcions que s’adapten 
		              a tots els gustos. Navega fàcilment a través de la nostra interfície amigable i troba el teu concert ideal. Comença 
		              a viure experiències inoblidables amb només uns pocs clics!</p>
		<h3>Seccions</h3>
		<?php echo (isset($_SESSION["login"])) ? '<a href="?Venda/form">':'<a href="?User/login">';?>
			<article>
				<img src="img/venda_tickets.png" alt="venda_tickets.png">
				<div class="text">
					<h3>Venda d'entrades</h3>
					<h4>Publicat - 13/05/2024</h4>
					<p>Explora la nostra àmplia gamma d'esdeveniments musicals en línia i garanteix el teu lloc amb facilitat. 
					   Des de petits fins a grans concerts, t'oferim una experiència musical única.
					</p> 
					<p>Troba tota la informació que necessites sobre la ubicació, les dates i els detalls específics de cada 
					   esdeveniment. Amb només uns pocs clics, podràs comprar les teves entrades i preparar-te per viure la música 
					   de la manera més vibrant i emocionant. No deixis passar aquesta oportunitat de formar part d'experiències 
					   musicals inoblidables.
					</p>
					<p><b>Per accedir a aquesta secció, necessiteu un compte d'usuari.</b></p>
				</div>
			</article>
		</a>
	</div>
</main>