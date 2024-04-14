<?php
session_start();

include 'funcions.php';
$cart = carregaDeDades();
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
					<li role="presentation" class="active"><a href="veureCarro.php">Veure
							Carro</a></li>
					<li role="presentation"><a href="pagaments.php">Pagament</a></li>
				</ul>
			</div>
			<div class="panel-body">
				<h1>Carro de compres</h1>
				<table class="table">
					<thead>
						<tr>
							<th>Producte</th>
							<th>Preu</th>
							<th>Quantitat</th>
							<th>Sub total</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
				        <?php echo generaTBody($cart); ?>
    				</tbody>
					<tfoot>
						<tr>
							<td><a href="index.php" class="btn btn-warning">
								<i class="glyphicon glyphicon-menu-left"></i> Segueix Comprant</a></td>
							<td colspan="2"></td>
            					<?php echo generaTFooter($cart); ?>
            				<td><a href="pagaments.php" class="btn btn-success btn-block">Pagaments 
            					<i	class="glyphicon glyphicon-menu-right"></i></a>
            				</td>
						</tr>
					</tfoot>
				</table>

			</div>
			<div class="panel-footer">Examen M07 UF1 2022-2023</div>
		</div>
	</div>
</body>
</html>