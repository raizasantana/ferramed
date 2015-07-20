<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Criar Metrica</title>
</head>
<!-- TODO Adicoinar relacao com o indicador--> 
<body>
<a href="../index.html"><h4>Home</h4></a>
	<form action="metrica" method="post" id="form1">
		
		<input type="hidden" name="acao" value="Criar" id="acao"/>
		
		<p>Nome: <input type="text" id="nome" name="nome" maxlength="50"></p>
		<p>Indicador: <select id="indicador" name="indicador">
			<c:if test="${indicadores!=null}">
				<c:forEach var="indicador" items="${indicadores}">
					<option value=${ indicador.id }> ${ indicador.descricao }</option>
				</c:forEach>
			</c:if></select>
		<p>Processo de coleta: <input type="text" id="processoColeta" name="processoColeta" maxlength="2000"></p>
		<p>Processo de analise: <input type="text" id="processoAnalise" name="processoAnalise" maxlength="2000"></p>
		<p> Tipo <select id="tipoMetrica" name="tipoMetrica">
					<option value="SIMPLES"> Metrica Simples</option>
					<option value="COMPOSTA"> Metrica Composta</option>
				</select></p>
		<input type="submit"  value="Criar Metrica	">
		
		</form>
		<c:if test="${message!=null}">
    	<h1>${message}</h1>
	</c:if>
		
</body>
</html>