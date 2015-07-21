<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Criar Fórmula</title>
</head>
<!-- TODO Adicoinar relacao com o indicador--> 
<body>
<a href="../index.html"><h4>Home</h4></a>
	<form action="formula" method="post" id="form1" class="form-horizontal">
		<input type="hidden" name="acao" value="Criar" id="acao"/>
		<p>Nome: <input type="text" id="nome" name="nome" maxlength="50"></p>
		<p>Métrica 1: 
		<select id="metrica1" name="metrica1_id">
			<c:forEach var="metrica1" items="${metricas}">
				<option value=${ metrica1.id }> ${ metrica1.nome }</option>
			</c:forEach>
		</select></p>
		<p>Operador: 
			<select id="operadores" name="operador">
			<c:forEach var="operador" items="${operadores}">
				<option value=${ operador }> ${ operador }</option>
			</c:forEach>
		</select></p>
		<p>Métrica 2: 
		<select id="metrica2" name="metrica2_id">
			<c:forEach var="metrica2" items="${metricas}">
				<option value=${ metrica2.id }> ${ metrica2.nome }</option>
			</c:forEach>
		</select></p>
	
		<input type="submit"  value="Criar Formula">
		
		</form>
		<c:if test="${message!=null}">
    	<h1>${message}</h1>
	</c:if>
		
</body>
</html> 
