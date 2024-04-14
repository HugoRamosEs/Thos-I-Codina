<?php
session_start();
include 'funcions.php';

/*
 * PREGUNTA 05
 *   *pagaments.php
 *   Realitza els controls de validació dels camps del formulari:
 *   tarjeta: obligatori.
 *      El contingut ha de tenir 16 caràcters numèrics.
 *      El primer numero ha de ser 4 (Visa) o 5 (Mastercard)
 *      No poden haver tres dígits iguals conscutius.
 *      No poden haver tres dígits consecutius incrementats o decrementats.
 *   data de caducitat: obligatori
 *      6 valors numèrics
 *      Els dos primers dígits són el mes
 *      Els 4 darrers dígits són l'any i no pot ser anterior a l'actual ni més gran de 4 anys.
 *   CVC: obligatori.
 *   3 valors numèrics.
 */

$cart = carregaDeDades();

// redirect to home if cart is empty
if ($cart['total_items'] <= 0) {
    header("Location: index.php");
}

// set customer ID in session
$_SESSION['sessCustomerID'] = 1;



if ($_SERVER["REQUEST_METHOD"]=="POST" && $_POST["submit"]=="Formalitzar comanda") {
    if (!isset($error)) {
        $cart = array('cart_total' => 0, 'total_items' => 0);
        unset($_SESSION['cart_contents']);
        header("Location: exit.php?id=123456");
    }
} 



?>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Pagaments - PHP Carro de compres</title>
<meta charset="utf-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.container {
	padding: 20px;
}

.table {
	width: 65%;
	float: left;
}

.shipAddr {
	width: 30%;
	float: left;
	margin-left: 30px;
}

.footBtn {
	width: 95%;
	float: left;
}

.orderBtn {
	float: right;
}

.tarjeta {
    text-align: left;
}

input.invalid {
  border-color: #d5144d;
}

</style>
</head>
<body>
	<div class="container">
		
		<div class="panel panel-default">
			<div class="panel-heading">
				<ul class="nav nav-pills">
					<li role="presentation"><a href="index.php">Inici</a></li>
					<li role="presentation"><a href="veureCarro.php">Veure Carro</a></li>
					<li role="presentation" class="active"><a href="pagaments.php">Pagaments</a></li>
				</ul>
			</div>
			<div class="panel-body">
				<h1>Vista previa de l'Ordre</h1>
				<table class="table">
					<thead>
						<tr>
							<th>Producto</th>
							<th>Pricio</th>
							<th>Cantidad</th>
							<th>Sub total</th>
						</tr>
					</thead>
					<tbody>
				     	<?php echo generaTBody($cart); ?>
    				</tbody>
					<tfoot>
						<tr>
							<td colspan="3"></td>
            					<?php echo generaTFooter($cart); ?>
        				</tr>
					</tfoot>
				</table>
				<div class="shipAddr">
					<h4>Detalls d'enviament</h4>
					<p>Toni Aguilar</p>
					<p>toni.aguilar@iesthosicodina.cat</p>
					<p>600 500 851</p>
					<p>Riera Cirera 57 - 08304 Mataró</p>
				</div>
			</div>

			<div class="panel-body">
				<h1>Dades de Pagament</h1>
				<table class="table">
					<tr><td>
					<img src="../Visa-MasterCard.png" width="500px">
					</td></tr>
				</table>
				<form action="pagaments.php" method="post">
				<div class="shipAddr">
					<h4>Tarjeta</h4>
					<p>Titular: Toni Aguilar</p>
					<p>Num.
					<input type="text" name="tarjeta" 
					   <?php echo (isset($error["tarjeta"])) ? "class=\"invalid\" placeholder=\"{$error["tarjeta"]}\"":"placeholder=\"XXXX-XXXX-XXXX-XXXX\""; ?>
					   <?php echo (isset($frmTarjeta)) ? " value=\"$frmTarjeta\"": "";?>
					>
					</p>
					<p>Cad.
					<input type="text" name="caducitat" 				   
					<?php echo (isset($error["caducitat"])) ? "class=\"invalid\" placeholder=\"{$error["caducitat"]}\"":"placeholder=\"XX-XXXX\""; ?>
					   <?php echo (isset($frmCaducitat)) ? " value=\"$frmCaducitat\"": "";?>
					>
					</p>
					<p>Dig.
					<input type="text" name="digits" 
					<?php echo (isset($error["digits"])) ? "class=\"invalid\" placeholder=\"{$error["digits"]}\"":"placeholder=\"XXX\""; ?>
					   <?php echo (isset($frmDigits)) ? " value=\"$frmDigits\"": "";?>
					>
					</p>
				</div>
				
				<div class="footBtn">
					<a href="index.php" class="btn btn-warning"> 
						<i class="glyphicon glyphicon-menu-left"></i> Seguir Comprant
					</a> 
						<input type="submit" name="submit" value="Formalitzar comanda" class="btn btn-success orderBtn" class="glyphicon glyphicon-menu-right">
				
				</div>
				
				</form>
			</div>
		</div>
		<div class="panel-footer">Examen M07 UF1 2022-2023</div>
	</div>
	</div>
</body>
</html>