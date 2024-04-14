<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Minetest APP - Log in</title>
		<link rel="stylesheet" href="estils.css" type="text/css">
	</head>
	<body>
		<div id="contenedor">
			<div id="seccion">
				<div id="texto">
					<h1>Formulari de login</h1>
				</div>
				<div id="img">
					<img src="img/minetest_logo.png" alt="minetest_logo.png">
				</div>
			</div>
			<h2>Introdueix les dades: </h2>
			<div id="error">
				<c:if test="${not empty errorLogin}">
	  				<p>${requestScope.errorLogin}</p>
				</c:if>
			</div>
			<form method="post" action="M8_minetest_login" >
            	<input type="text" id="nombre" name="nombre" placeholder="Nom d'usuari..." required="required">
            	<input type="password" id="contrasenya" name="contrasenya" maxlength="20" placeholder="Contrasenya..." required="required">
				<input type="submit" value="Entrar">
			</form>
		</div>
</body>
</html>