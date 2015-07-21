<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Realizar Coleta</title>
</head>
<body>
<a href="../index.html"><h4>Home</h4></a>
	<form action="coleta" method="post" id="form1">
		<input type="hidden" name="acao" value="Criar" id="acao"/>
		
		<p> Métrica <select id="metrica" name="metrica">
		<c:if test="${metricas!=null}">
			<c:forEach var="metrica" items="${metricas}">
				<option value="${metrica.id}"> ${metrica.nome}</option>
			</c:forEach>
		</c:if>
		</select></p>
		
		<p>Observação: <input type="text" id="observacao" name="observacao" maxlength="2000"></p>
		<p>Valor: <input type="text" id="valorColeta" name="valorColeta" maxlength="20"></p>
		
		<input type="submit"  value="Salvar Coleta">
		
		</form>
		<c:if test="${message!=null}">
    	<h1>${message}</h1>
	</c:if>
		
</body>
</html>