<?php

/*
 * PREGUNTA 06
 *      *mantenimentProductes.php
 *      Defineix l'alta i la baixa d'un producte.
 *      No és necessari fer les verificacions de validessa dels camps.
 */

/*
 * 
 * PREGUNTA 07
 *      * mantenimentProductes.php
 *      Fes que les dades de productes es mantiguin actualitzades un cop es dona d'alta un
 *      producte o s'elimini.
 */

?>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>View Cart - PHP Shopping Cart</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .container {
        	padding: 20px;
        }
        
        input[type="number"] {
        	width: 20%;
        }
    </style>
    <script>
        function updateCartItem(obj,id){
            $.get("cartAction.php", {action:"updateCartItem", id:id, qty:obj.value}, function(data){
                if(data == 'ok'){
                    location.reload();
                }else{
                    alert('Cart update failed, please try again.');
                }
            });
        }
        </script>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">

			<div class="panel-heading">
				<ul class="nav nav-pills">
					<li role="presentation"><a href="index.php">Inici</a></li>
					<li role="presentation" class="active"><a href="mantenimentProducte.php">Manteniment</a></li>
				</ul>
			</div>
			<form action="mantenimentProductes.php" method="post">
			<div class="panel-body">
				<h1>Manteniment de productes</h1>
				<table class="table">
					<thead>
						<tr>
							<th>id</th>
							<th>Nom</th>
							<th>Descripció</th>
							<th>Preu</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
				        <?php echo generaTBodyManteniment($productes); ?>
    				</tbody>
					<tfoot>
						<tr>
							<td><input type="text" name="id" class="form-control text-center" value="<?php echo $frmId; ?>"></td>
							<td><input type="text" name="nom" class="form-control text-center" value="<?php echo $frmName; ?>"></td>
							<td><input type="text" name="descripcio" class="form-control text-center" value="<?php echo $frmDescripcio; ?>"></td>
							<td><input type="text" name="preu" class="form-control text-center" value="<?php echo $frmPreu; ?>"></td>						
            
						</tr>
					</tfoot>
				</table>

			</div>
			<div class="footBtn">
					<input type="submit" name="submit" value="Alta de Producte" class="btn btn-success orderBtn" class="glyphicon glyphicon-menu-right">
				
			</div>
			</form>
			<div class="panel-footer">Examen M07 UF1 2022-2023</div>
		</div>
	</div>
</body>
</html>