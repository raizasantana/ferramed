<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/tableStyleGenerator.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar indicadores</title>
</head>
<body>
<div id="listarIndicadores" name="acao" value="Listar">
		<table class='CSSTableGenerator'>
			<tr>
				<td>DESCRICAO</td>
				<td>META</td>
				<td>ACAO</td>
			</tr>
			<c:if test="${indicadores!=null}">
				<c:forEach var="indicador" items="${indicadores}">
					<tr>
						<td> ${indicador.descricao} </td>
						<td> ${indicador.meta} </td>

						<td><center><a data-target="#conteudo" class="button" href="indicador?acao=editarIndicador&id=${indicador.id}">Editar</a><center></td>
					</tr>
					
				</c:forEach>
			</c:if>
			
		</table>
		<br/>
		<center><a class="button" href="criarIndicador.jsp"">Nova Indicador</a><center>
	</div>

</body>
</html>