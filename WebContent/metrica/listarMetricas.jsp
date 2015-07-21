<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="../css/tableStyleGenerator.css">
<head>

<title>Lista de metricas</title>
</head>
<body>
	<div id="listarMetricas" name="acao" value="Listar">
		<table class='CSSTableGenerator'>
			<tr>
				<td>NOME</td>
				<td>PROCESSO DE ANALISE</td>
				<td>PROCESSO DE COLETA</td>
				<td>TIPO</td>
				<td>ACAO</td>
			</tr>
			<c:if test="${metricas!=null}">
				<c:forEach var="metrica" items="${metricas}">
					<tr>
						<td> ${metrica.nome} </td>
						<td> ${metrica.processoAnalise} </td>
						<td> ${metrica.processoColeta} </td>
						<td> ${metrica.tipo} </td>
						<td><center><a data-target="#conteudo" class="button" href="metrica?acao=editarMetrica&id=${metrica.id}">Editar</a><center></td>
					</tr>
					
				</c:forEach>
			</c:if>
			
		</table>
		<br/>
		<center><a class="button" href="criarMetrica.jsp"">Nova Metrica</a><center>
	</div>
</body>
</html>