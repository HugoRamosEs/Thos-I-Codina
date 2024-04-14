<section class="infos">
	<div class="content">
		<div class="grid allcenter">
			<div class="float-md-50 wimg">
				<img
					src="img/plano.jpg" />
			</div>
			<div class="float-md-50 winfo">
				<form action="?venda/step3" 
					method="POST" id="msform" style="width:100%">
    				<h1 class="title"><?php echo $entrada->esdeveniment->titol;?></h1>
    				<p class="description"><?php echo $entrada->esdeveniment->subtitol;?></p>
    				<p class="description"><?php echo $entrada->localitzacio->lloc;?></p>
    				<p class="description"><?php echo "{$entrada->data->data} - {$entrada->data->hora}";?></p>
    				<p class="description"><?php echo "{$entrada->zona->descripcio} - Fila: {$entrada->fila}, Butaca: {$entrada->butaca}"; ?></p>
    				<?php echo $input_dni; ?>
    				<p><?php echo $input_bBack; echo $input_bSend; ?></p>
				</form>
			</div>
		</div>
	</div>
</section>

