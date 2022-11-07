<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.imc.controller.IMCController"%>
<%@ page import="com.imc.model.ImcRecord"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./index.css">
<title>Insert title here</title>
</head>
<body>
<% IMCController imcController = new IMCController();
	long personId = Long.valueOf(request.getParameter("personId"));
	ArrayList<ImcRecord> records = imcController.getPersonImcRecords(personId);%>

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
<input name="personId" type="hidden" value="<%=personId%>"/>
<div>
<input type="submit" value="Calcular IMC" class="btnStack"/>
<a href="/JavaAvanzadoEmanuel/index.jsp" class="btnStack">Cerrar Sesión</a>
</div>

</form>
<div style="padding:10px; margin:10px; height:30%; border-left: 2px solid; overflow-y: scroll;">
<p>Historial de mediciones</p>
<%
for (int i=0; i < records.size(); i++) {
	ImcRecord record = records.get(i);
	String dateStr = record.getRecorDate().get(Calendar.DAY_OF_MONTH) + "/" + record.getRecorDate().get(Calendar.MONTH) + "/" + record.getRecorDate().get(Calendar.YEAR);
%>
<div style="margin:10px">
<p style="margin: 1px">IMC: <%=record.getImcResult()%></p>
<p style="margin: 0px; font-size:10px"><%=dateStr%></p>
</div>
<%}%>
</div>
</div>

</body>
</html>