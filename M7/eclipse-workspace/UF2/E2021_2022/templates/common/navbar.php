<!-- És necessari tenir definida la variable $active
Ha de ser un array associatiu on les seves claus poden ser:
main, escocia, islandia, palamos, vic, vall, barcelona, mataro, o login
y el seu valor és booleà.
 -->

<!-- 
Ha d'estar definit l'objecte de negoci $frm_lang de tipus FormTagLang
 -->

<div class="body-wrap">
	<div class="container">
		<nav class="navbar navbar-inverse" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Thos i Codina</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li <?php echo (isset($active["main"]))?"class=\"active\"":"";?>><a href="./index.php"><?php echo $frm_lang->benvinguts;?></a></li>
						<li <?php echo (isset($active["escocia"]))?"class=\"active\"":"";?>><a href="./escocia.php"><?php echo $frm_lang->escocia;?></a></li>
						<li <?php echo (isset($active["islandia"]))?"class=\"active\"":"";?>><a href="./islandia.php"><?php echo $frm_lang->islandia;?></a></li>
						<li <?php echo (isset($active["palamos"]) || isset($active["vic"]) || isset($active["vall"]) ||isset($active["barcelona"]) || isset($active["mataro"]))?"class=\"active\"":"";?>class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><?php echo $frm_lang->catalunya;?><b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li <?php echo (isset($active["palamos"]))?"class=\"active\"":"";?>><a href="./palamos.php">Palamós</a></li>
								<li <?php echo (isset($active["vic"]))?"class=\"active\"":"";?>><a href="./vic.php">Vic</a></li>
								<li <?php echo (isset($active["vall"]))?"class=\"active\"":"";?>><a href="./vall.php">Vall d'Aran</a></li>
								<li class="divider"></li>
								<li <?php echo (isset($active["barcelona"]))?"class=\"active\"":"";?>><a href="#">Barcelona</a></li>
								<li class="divider"></li>
								<li <?php echo (isset($active["mataro"]))?"class=\"active\"":"";?>><a href="#">Mataró</a></li>
							</ul></li>
					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li <?php echo (isset($active["login"]))?"class=\"active\"":"";?>><a href="./log_in.php"><?php echo $frm_lang->identificat;?></a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><?php echo $frm_lang->idioma;?><b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="?lang=es"><?php echo $frm_lang->espanyol;?></a></li>
								<li><a href="?lang=gb"><?php echo $frm_lang->angles;?></a></li>
								<li><a href="?lang=de"><?php echo $frm_lang->alemany;?></a></li>
								<li class="divider"></li>
								<li><a href="?lang=ca"><?php echo $frm_lang->catala;?></a></li>
							</ul></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	</div>
</div>
