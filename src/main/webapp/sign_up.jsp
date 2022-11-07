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
<form action="/JavaAvanzadoEmanuel/UserController" method="POST" style="    display: flex;
    flex-direction: column;
    height: 80%;
    align-items: center;
    justify-content: center;">
<label for="username">Nombre de Usuario: </label>
<input id="username" name="username" type="text"/>

<label for="email">Email: </label>
<input id="email" name="email" type="text"/>

<label for="password">Contraseña: </label>
<input id="password" name="password" type="password"/>

<label for="passwordConfirmation">Confirmar contraseña: </label>
<input id="passwordConfirmation" name="passwordConfirmation" type="password"/>

<label for="name">Nombre Completo: </label>
<input id="name" name="name" type="text"/>


<label for="age">Edad: </label>
<input id="age" name="age" type="text"/>


<div>
<a href="/JavaAvanzadoEmanuel/index.jsp" class="btnStack">Regresar</a>
<input type="submit" value="Crear Usuario" class="btnStack"/>
</div>

</form>
</div>

</body>
</html>