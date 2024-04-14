<section class="infos">
	<div class="content">
		<div class="grid allcenter">
			<div class="float-md-50 wimg">
				<img
					src="<?php echo $esdeveniment->imatge; ?>" />
			</div>
			<div class="float-md-50 winfo">
				<form action="?venda/step1/<?php echo $esdeveniment->id; ?>" method="POST"
					id="msform" style="width:100%">
    				<h1 class="title"><?php echo $esdeveniment->titol;?></h1>
    				<p class="description"><?php echo $esdeveniment->subtitol;?></p>
    				<p class="description"><?php echo $input_localitzacio;?></p>
    				<p class="description"><?php echo $input_data;?></p>
    				<p>
    				<?php
    				    echo $input_bBack;
    				    echo $input_bSend;
    			    ?>
    				</p>
				</form>
			</div>
		</div>
	</div>
</section>

