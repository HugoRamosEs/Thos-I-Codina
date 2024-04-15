<script>
jQuery(document).ready(function($){
	$("article").click(function(){
		document.location.href=$(this).find("a").attr("href");
	});
});
</script>

<link rel='stylesheet' id='sgdg_block-css' href='css/base.css?ver=1'
	type='text/css' media='all' />
<link rel='stylesheet' id='sgdg_block-css' href='css/style3.css?ver=1'
	type='text/css' media='all' />

<div id="Content">
	<div class="content_wrapper clearfix">
		<div class="sections_group">
			<div class="section">
				<div class="section_wrapper clearfix">
					<div id="special"></div>
					<?php echo $articles;?>
				</div>
			</div>
		</div>

	</div>
</div>

