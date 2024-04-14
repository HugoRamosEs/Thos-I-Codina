(function() {
	$(document).ready(function() {
		$('.select-placeholder').on('click', function() {
			$(this).parent().toggleClass('is-open');
			
			if ($(this).parent().class==undefined && $(this).attr('data-language')!='none') {
				var language = $(this).attr('data-language');
				var url = window.location.pathname + "?lang=" + language;
            	window.location.href = url; 
			}

		});

		$('.select-option').on('click', function() {
			var language = $(this).attr('data-language');
			$('.select-placeholder').attr('data-language',language);
 		});
		
 
	});

})(jQuery);