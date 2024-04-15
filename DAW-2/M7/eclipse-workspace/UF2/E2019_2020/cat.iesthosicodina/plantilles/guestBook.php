<form id="guestform" action="index.php" method="post">
    <fieldset>
        <h2 class="fs-title">LLIBRE DE VISITES</h2>
        <h3 class="fs-subtitle">Signa en el meu llibre de visites i deixa'm un comentari</h3>
    	<?php echo $this->getHtml(); ?>
    	<input type="submit" name="submit" class="submit action-button" value="Sortir" />
    	<input type="submit" name="submit" class="submit action-button" value="Signar Llibre" />
    </fieldset>
</form>
