<section class="one">
	<div class="logo">
		<logomenu>
		<ul>
			<li class="logo">Thos i Codina</li>
			<li>M07</li>
			<li>UF1</li>
			<li>2023-2024</li>
		</ul>
		</logomenu>
		<infosmenu>
		<ul>
			<a href='?contacte/form'>
				<li><?php echo $mainContacta;?></li>
			</a>

			
			
			
			<?php
            if (isset($_SESSION['logged']) && $_SESSION['logged'] === TRUE ) {
            ?>
        		<a href='?User/logout'>
        			<img src="<?php echo $_SESSION['img'];?>" alt="imatge de l'usuari" width="50" height="50" >
        		</a>
            <?php 
            } else {
            ?>
        		<a href='?user/login'>
				<li class="btn"><?php echo $mainLog_in;?></li>
				</a>
            <?php 
            }
            ?>
			
		</ul>
		</infosmenu>
	</div>
	<div class="bighero">
		<h1><?php echo $mainTitol;?></h1>
		<p><?php echo $mainSubTitol;?></p>
	</div>
	<div class="lang">
		<infosmenu>
		<ul>
			<div id="catala"
				<?php echo (isset($html_opacityLang["ca"]))?$html_opacityLang["ca"]:""; ?>>
				<a href='index.php?lang/set/ca'><li class="btn"><?php echo $mainLangCA; ?></li></a>
			</div>
			<div id="euzkera"
				<?php echo (isset($html_opacityLang["eu"]))?$html_opacityLang["eu"]:""; ?>>
				<a href='index.php?lang/set/eu'><li class="btn"><?php echo $mainLangEU; ?></li></a>
			</div>
			<div id="castella"
				<?php echo (isset($html_opacityLang["es"]))?$html_opacityLang["es"]:""; ?>>
				<a href='index.php?lang/set/es'><li class="btn"><?php echo $mainLangES; ?></li></a>
			</div>
			<div id="angles"
				<?php echo (isset($html_opacityLang["en"]))?$html_opacityLang["en"]:""; ?>>
				<a href='index.php?lang/set/en'><li class="btn"><?php echo $mainLangEN; ?></li></a>
			</div>
			<div id="frances"
				<?php echo (isset($html_opacityLang["fr"]))?$html_opacityLang["fr"]:""; ?>>
				<a href='index.php?lang/set/fr'><li class="btn"><?php echo $mainLangFR; ?></li></a>
			</div>
			<div id="alemany"
				<?php echo (isset($html_opacityLang["ge"]))?$html_opacityLang["ge"]:""; ?>>
				<a href='index.php?lang/set/ge'><li class="btn"><?php echo $mainLangGE; ?></li></a>
			</div>
		</ul>
		</infosmenu>
	</div>
</section>
