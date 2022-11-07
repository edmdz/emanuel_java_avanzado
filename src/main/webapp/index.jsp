<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./index.css">
<meta charset="ISO-8859-1">
<title>Formulario Prueba</title>
</head>
<body>
<div style="height: 98vh">
<div style="display: flex; justify-content:center">
<h2>Bienvenido a tu página web para calcular tu índice de Masa Corporal</h2>
</div>
<form action="/JavaAvanzadoEmanuel/UserController" method="GET" style="    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height:80%;">
<label for="username">Nombre de usuario: </label>
<input id="username" name="username" type="text"/>

<label for="password">Contraseña: </label>
<input id="password" name="password" type="password"/>

<div>
<input type="submit" value="Iniciar Sesión" class="btnStack"/>
<a href="/JavaAvanzadoEmanuel/sign_up.jsp" class="btnStack">Registrarse</a>
</div>
<p>o</p>
<div><a href="/JavaAvanzadoEmanuel/landing_anonymus.jsp">Calcular una vez</a></div>

</form>
</div>

</body>
</html>