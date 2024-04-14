<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Minetest APP</title>
		<link rel="stylesheet" href="estils.css" type="text/css">
	</head>
	<body>
		<div id="contenedor">
			<div id="seccion">
				<div id="texto">
					<h1>Minetest wiki</h1>
				</div>
				<div id="login">
		        	<c:choose>
		        		<c:when test="${empty sessionScope.usuario}">
			    			<div id="icon-login">
			                	<a href="login.jsp">Log in</a>
			                </div>
		                </c:when>
		                <c:otherwise>
		                   	<div id="icon-logout">
		                    	<p><img alt="login.png" src="img/${sessionScope.usuario.ubicacion}"> ${sessionScope.usuario.nombre} <a href="M8_minetest_logout">Log Out</a></p>
		                    </div>
		                </c:otherwise>
		        	</c:choose>
            	</div>
				<div id="img">
					<img src="img/minetest_logo.png" alt="minetest_logo.png">
				</div>
            </div>
			<h2>Llistat d'items</h2>
			<p>Número d'items: ${requestScope.numero}</p>
			<div id="error">
				<c:if test="${empty requestScope.lista}">
	  				<p>${requestScope.error}</p>
				</c:if>
			</div>
			<div id="li">
				<ul>
					<c:forEach var="item" items="${requestScope.lista}">
						<li><img alt="item.png" src="img/${item.ubicacion}"> ${item.nombre} (${item.descripcion}).</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</body>
</html>