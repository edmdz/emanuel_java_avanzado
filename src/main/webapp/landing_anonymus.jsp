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
    align-items: center;">
<form action="/JavaAvanzadoEmanuel/IMCController" method="POST" style="    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height:100%;">
<label for="height">Estatura (Centimetros): </label>
<input id="height" name="height" type="text"/>

<label for="weight">Peso (Gramos): </label>
<input id="weight" name="weight" type="text"/>
<div>
<input type="button" value="Calcular IMC" class="btnStack" onclick="calculateIMC()"/>
<a href="/JavaAvanzadoEmanuel/index.jsp" class="btnStack">Regresar</a>
</div>

</form>
</div>

<script type="text/javascript">
function calculateIMC(){
	var h = document.getElementById("height");
	var w = document.getElementById("weight");
	var imc = (w.value / 1000) / ( (h.value / 100) * (h.value / 100) )
	imc = Math.floor(imc * 100) / 100
	console.log("hola " + imc)
	
	window.location.replace("/JavaAvanzadoEmanuel/anonymus_imc_result.jsp?imc=" + imc)
}
</script>
</body>
</html>