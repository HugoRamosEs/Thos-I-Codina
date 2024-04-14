<?php 
/*
 * El present document, té dues parts:
 * - id="dialog-message": Informació sobre dades de caràcter personal
 * - id="contingut": Contingut de la pàgina propiament dita.
 * 
 * Volem que el missatge sobre protecció de dades (Part 1) aparegui només
 * una vegada, i un cop l'usuari ha dit "ho entenc" no torni a aparèixer
 * mai més, accedit directament al contingut.
 * 
 * No pots fer servir javascript.
 * 
 */

session_start();

if (isset($_SESSION["entenc"])){
    $_SESSION["entenc"] = false;
}else{
    $_SESSION["entenc"] = true;
}

if(isset($_POST["submit"]) && $_SERVER["REQUEST_METHOD"] == "POST") {
    $_SESSION["entenc"] = false;
}

?>

<!DOCTYPE html>
<html lang="en">
    <head>
    <meta charset="UTF-8">
    <title>INS Thos i Codina - UF1</title>
    <link rel="stylesheet" href="./style.css">
</head>
<body>
	<?php 
	if ($_SESSION["entenc"]) {
	    echo "<div id='dialog-message'>
		<p class='avis'>
		<p><b>INFORMACIÓ SOBRE PROTECCIÓ DE DADES DE CARÀCTER PERSONAL</b></p>
		<p>El tractament de dades de caràcter personal es realitzarà conforme
			al que es disposa en el Reglament (UE) 2016/679 del Parlament Europeu
			i del Consell, de 27 d'abril de 2016, relatiu a la protecció de les
			persones físiques pel que fa al tractament de dades personals i a la
			lliure circulació d'aquestes dades i pel qual es deroga la Directiva
			95/46/CE (Reglament general de protecció de dades), i en la Llei
			orgànica 3/2018, de 5 de desembre, de Protecció de Dades Personals i
			garantia dels drets digitals.</p>
		<p>En compliment del que es disposa en l'article 13 d'aquest Reglament
			s'informa del següent:<p>
		<table>
			<tr>
				<td>RESPONSABLE DEL TRACTAMENT</td>
				<td>Departament de Desenvolupament de l'Institut Thos i Codina.<br />
					Riera de Cirera 57, 08304 Mataró. <br /> info@iesthosicodina.cat <br />
					Autoritat Catalana de Protecció de Dades<br /> C/ Rosselló, 214,
					Esc. A, 1r 1a 08008 Barcelona <br /> apdcat@gencat.cat
				</td>
			</tr>
			<tr>
				<td>FINALITAT DEL TRACTAMENT</td>
				<td>Les seves dades es tracten per a la gestió del present
					procediment. També es preveu la seva utilització amb finalitats
					estadístics. Les dades personals proporcionades es conservaran
					mentre siguin necessaris per a donar compliment als fins del
					tractament.</td>
			</tr>
			<tr>
				<td>LEGITIMACIÓ DEL TRACTAMENT</td>
				<td>El tractament és necessari per al compliment d'una missió
					d'interès públic o l'exercici de poders públics, com és la
					concessió d'una subvenció en la forma prevista en la Llei foral
					11/2005, de 9 de novembre, de Subvencions.</td>
			</tr>
			<tr>
				<td>PROCEDÈNCIA DE DADES</td>
				<td>Les dades identificatives, els de contacte, els socioeconòmics i
					financers i, si és el cas, d'activitat laboral, s'obtenen,
					fonamentalment, a través dels que aporta amb la sol·licitud, així
					com els generats en el transcurs de la relació administrativa i els
					que per a l'adequada gestió siguin imprescindibles recaptar
					d'altres administracions i organismes públics o privats.</td>
			</tr>
			<tr>
				<td>DESTINATARIS DE LES DADES</td>
				<td>Les dades podran ser cedits a altres òrgans del Govern de
					Catalunya, així com a altres Administracions públiques o a les
					autoritats, tribunals i organismes de públics de control per a
					l'exercici de les seves funcions. També podran ser cedits a
					entitats financeres per a la gestió de pagaments i per obligacions
					legals.</td>
			</tr>
			<tr>
				<td>DRETS QUAN FACILITA LES SEVES DADES</td>
				<td>Els drets que pot exercir en relació amb les seves dades són:
					<ul>
						<li>Accés: conèixer quines dades s'estan tractant.</li>
						<li>Rectificació: en el cas que siguin inexactes o incomplets.</li>
						<li>Limitació: per a limitar el tractament i en aquest cas
							únicament es conservaran per a l'exercici o la defensa de
							possibles reclamacions.</li>
						<li>Oposició: perquè cessi el tractament de les seves dades,
							excepte per motius legítims imperiosos o per a l'exercici o la
							defensa de possibles reclamacions.</li>
						<li>Supressió: per a eliminar aquelles dades que no siguin
							necessaris per a la finalitat que van ser recollits.</li>
						<li>Portabilitat: dret al fet que se li lliurin les seves dades
							per a transmetre'ls-hi a una altra entitat responsable.</li>
						<li>Revocació del consentiment: suposa la possibilitat de retirar
							el consentiment en qualsevol moment després de donar
							l'autorització del tractament, sense que això afecti la licitud
							del tractament basat en el consentiment previ, i amb les
							conseqüències que d'això es derivin.</li>
					</ul> Podrà exercitar aquests drets mitjançant escrit dirigit al
					Departament de Desenvolupament Econòmic. Els models d'aquests
					documents per a exercitar els seus drets els pot trobar en la
					pàgina web de l'Agència Espanyola de Protecció de Dades
					(www.agpd.es). També se l'informa que pot presentar una reclamació
					davant l'autoritat de control competent en matèria de protecció de
					dades o davant la Delegada de Protecció de dades del Govern de
					Catalunya.
				</td>
			</tr>
		</table>
		</p>
		<form method='post' action='index.php'>
			<input type='submit' id='entenc' name='entenc' value='Ho entenc'>
		</form>
		<!-- <button type='button'>Ho entenc</button> -->
		</p>";
	}else{
	    
	}
	?>
	<div id="contingut">
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget
			turpis imperdiet, porta nisi eleifend, lacinia arcu. Integer
			ultricies dictum orci ac finibus. Cras feugiat risus diam, mollis
			faucibus leo efficitur quis. Sed ante mauris, convallis in sagittis
			sed, gravida at lorem. Cras interdum tincidunt nulla, nec faucibus
			nulla tincidunt a. Nulla dignissim pretium tortor vitae feugiat.
			Donec ultricies libero ligula, lacinia lacinia massa sagittis sit
			amet. Mauris pretium turpis quis risus faucibus, sit amet venenatis
			nulla pharetra.</p>
		<p>Mauris pellentesque et sem at consectetur. Ut tincidunt ullamcorper
			enim, et fermentum ipsum viverra id. Pellentesque habitant morbi
			tristique senectus et netus et malesuada fames ac turpis egestas.
			Class aptent taciti sociosqu ad litora torquent per conubia nostra,
			per inceptos himenaeos. Nunc vestibulum elementum urna, quis dapibus
			nisl. Ut volutpat a arcu at ultrices. Sed ac risus egestas, mattis
			sem ut, facilisis sem. Nam consequat, leo non consectetur laoreet,
			sem arcu posuere odio, sed aliquam massa velit a velit. Donec tempus
			massa sodales sem finibus, quis maximus dui vestibulum.</p>
		<p>Donec dapibus blandit ex, eu sagittis quam consectetur et. Interdum
			et malesuada fames ac ante ipsum primis in faucibus. Integer
			condimentum luctus ex posuere auctor. Morbi et felis euismod, laoreet
			dolor non, dignissim dui. Nulla facilisi. Vivamus id tristique augue.
			Integer lobortis aliquam dui, vehicula convallis tortor suscipit
			eget. Duis nec vestibulum ligula. Mauris vel mi non velit aliquam
			vehicula sit amet in tortor. Nunc euismod ultrices placerat. Vivamus
			quis lacus ut ex tincidunt molestie. Sed et est lectus. Nunc eget
			diam urna. Nam interdum purus nec finibus ultrices. Suspendisse eget
			nisl libero.</p>
		<p>Quisque ultrices sodales massa, id aliquam metus vestibulum vitae.
			Praesent lobortis elit id commodo suscipit. Duis consectetur posuere
			condimentum. Cras velit odio, tristique nec neque vitae, auctor
			imperdiet dui. Nunc volutpat felis a lacus mattis, et lobortis metus
			eleifend. Cras ut tincidunt arcu. Phasellus vehicula sollicitudin
			tristique. Suspendisse posuere turpis non lacinia gravida.</p>
		<p>Aenean quis ultricies lacus. Ut ullamcorper efficitur efficitur.
			Integer vulputate a tortor vel tempor. Curabitur lacus metus,
			porttitor a mauris feugiat, ultrices gravida enim. Nam urna odio,
			feugiat in luctus a, pulvinar vitae nunc. Vivamus pellentesque at
			erat non cursus. Fusce ornare iaculis est vitae bibendum. Vestibulum
			vel dolor turpis. Morbi malesuada tincidunt dictum.</p>
	</div>
</body>
</html>
