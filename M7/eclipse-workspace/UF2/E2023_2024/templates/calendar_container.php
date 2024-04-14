<div class="calendar-container">
	<header>
		<button class="header__btn header__btn--left" title="Menu">
			<svg class="icon" width="20px" viewBox="0 0 20 16" fill="none"
				xmlns="http://www.w3.org/2000/svg">
          			<path fill="#fff" d="M0 0h20v2H0zM0 7h20v2H0zM0 14h20v2H0z" />
        </svg>
		</button>
		<button class="header__btn header__btn--right" title="Add event">
			<svg class="icon" width="26px" xmlns="http://www.w3.org/2000/svg"
				viewBox="0 0 512 512">
          			<path fill="#fff"
					d="M416 277.333H277.333V416h-42.666V277.333H96v-42.666h138.667V96h42.666v138.667H416v42.666z" />
        </svg>
		</button>
	</header>


	<div class="calendar-container__header">
		<button class="calendar-container__btn calendar-container__btn--left"
			title="Previous">
			<i class="icon ion-ios-arrow-back"></i>
		</button>
		<h2 class="calendar-container__title">Febrer 2024</h2>
		<button class="calendar-container__btn calendar-container__btn--right"
			title="Next">
			<i class="icon ion-ios-arrow-forward"></i>
		</button>
	</div>

	<div class="calendar-container__body">
		<div class="calendar-table">
			<div class="calendar-table__header">
				<div class="calendar-table__row">
					<div class="calendar-table__col">Dg</div>
					<div class="calendar-table__col">Dl</div>
					<div class="calendar-table__col">Dm</div>
					<div class="calendar-table__col">Dx</div>
					<div class="calendar-table__col">Dj</div>
					<div class="calendar-table__col">Dv</div>
					<div class="calendar-table__col">Ds</div>
				</div>
			</div>
			<div class="calendar-table__body">
			<?php echo $calendar_table_body;?>
        </div>
		</div>
	</div>
</div>