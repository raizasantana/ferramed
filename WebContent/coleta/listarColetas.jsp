<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="../css/tableStyleGenerator.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Coletas Realizadas</title>
</head>

<body>

	<div id="listarColetas" name="acao" value="Listar">
		<table class='CSSTableGenerator'>
			<tr>
				<td>MÉTRICA</td>
				<td>VALOR COLETADO</td>
				<td>OBSERVAÇÃO</td>
				<td>DATA</td>
				<td>AÇÃO</td>
			</tr>
			<c:if test="${coletas!=null}">
				<c:forEach var="coleta" items="${coletas}">
					<tr>
						<td> ${coleta.metrica.nome} </td>
						<td> ${coleta.valor} </td>
						<td> ${coleta.observacao} </td>
						<td> ${coleta.data } </td>
						<td><center><a data-target="#conteudo" class="button" href="coleta?acao=editarColeta&id=${coleta.id}">Editar</a><center></td>
					</tr>
					
				</c:forEach>
			</c:if>
			
		</table>
		<br/>
		<center><a class="button" href="coleta?acao=listarMetricas"">Realizar nova Coleta</a><center>
	</div>

</body>
</html>