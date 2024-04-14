<section class="menu">
	<div class="list">
		<a href="index.php"><div class="imgMenu"><?php echo $mainMenu1;?></div></a> 
		<a href="?Inversis/show"><div class="imgMenu"><?php echo $mainMenu2;?></div></a> 
		<a href="?Contacte/maintenance"><div class="imgMenu"><?php echo $mainMenu3;?></div></a>
		<a href="?GuestBook/form"><div class="imgMenu"><?php echo $mainMenu4;?></div></a> 
		<a href="?Venda/show"><div class="imgMenu"><?php echo $mainMenu5;?></div></a>
		<?php if (isset($_SESSION['logged'])) { ?>
		<a href="?Entrada/show"><div class="imgMenu"><?php echo $mainMenu6;?></div></a>
		<?php }?>
	</div>
</section>