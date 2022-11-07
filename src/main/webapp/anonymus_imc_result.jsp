<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./index.css">
<title>Insert title here</title>
</head>
<body>
<div style="height: 98vh">
<div style="display: flex; justify-content:center">
<h2>Bienvenido a tu página web para calcular tu índice de Masa Corporal</h2>
</div>
<div style="height:80%;display:flex;justify-content: center;
    align-items: center; flex-direction: column">
    <h3>Tu Indice de Masa Corporal es: <%= request.getParameter("imc")%></h3>
    <a href="/JavaAvanzadoEmanuel/index.jsp" class="btnStack">Regresar</a>
</div>
</body>
</html>