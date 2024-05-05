<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="styles/styles.css" />
    <title>UF4.M7.P1 - Generació en PDF i XML</title>
</head>
<body>
	<table>
		<tbody>
			<tr>
				<td class="titol"><?php echo $entrada->getEvent()->getTitol(); ?></td>
				<td class="td-center td-logo"><img src="<?php echo __DIR__ . "/../img/logo.png"?>" alt="logo.png" class="logo" /></td>
			</tr>
			<tr>
				<td colspan="2" class="subtitol"><?php echo iconv("UTF-8", "ISO-8859-1", $entrada->getEvent()->getSubtitol()); ?></td>
			</tr>
			<tr>
				<td colspan="2" class="td-center"><img src="<?php echo __DIR__ . "/../img/" . $img; ?>" alt="<?php echo $img; ?>" class="img" /></td>
			</tr>
			<tr>
				<td class="adreca">
					<p><strong>Localització: </strong></p>
					<ul>
						<li><span>Lloc: </span><?php echo iconv("UTF-8", "ISO-8859-1", $entrada->getLocalitzacio()->getLloc()); ?></li>
						<li><span>Localitat: </span><?php echo $entrada->getLocalitzacio()->getLocalitat(); ?></li>
						<li><span>Adreça: </span><?php echo $entrada->getLocalitzacio()->getAdreca(); ?></li>
					</ul>
				</td>
				<td class="data-hora">
					<p><strong>Data i Hora: </strong></p>
					<ul>
						<li><span>Data: </span><?php echo $entrada->getData()->getData(); ?></li>
						<li><span>Hora: </span><?php echo $entrada->getData()->getHora(); ?></li>
					</ul>
				</td>
			</tr>
			<tr>
				<td class="info-comanda">
					<p><strong>Informació de la comanda: </strong></p>
					<ul>
						<li><span>Banc: </span><?php echo $entrada->getPagament()->getBanc(); ?></li>
						<li><span>REF: </span><?php echo $entrada->getPagament()->getReferenciaExterna(); ?></li>
						<li><span>Data: </span><?php echo $entrada->getPagament()->getData(); ?></li>
						<li><span>Estat: </span><?php echo $entrada->getPagament()->getEstat(); ?></li>
						<li><span>Comprador: </span><?php echo $entrada->getCompardor(); ?></li>
					</ul>
				</td>
				<td class="info-entrada">
					<p><strong>Informació de l'entrada: </strong></p>
					<ul>
						<li><span>Zona: </span><?php echo $entrada->getZona()->getDescripcio(); ?></li>
						<li><span>Fila: </span><?php echo $entrada->getFila(); ?></li>
						<li><span>Butaca: </span><?php echo $entrada->getButaca(); ?></li>
					</ul>
				</td>
			</tr>
			<tr>
				<td class="td-center">
					<barcode code="<?php echo $entrada->getId(); ?>" type="C128A" size="1.4"/><br>
					<p><?php echo $entrada->getId(); ?></p>
				</td>
				<td class="td-center"><barcode code="<?php echo $qrCode; ?>" type="qr" size="1"/></td>
			</tr>
		</tbody>
	</table>
</body>
</html>
