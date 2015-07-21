<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/bootswatch.min.css">
 
    <script src="../../js/bootstrap.min.js"></script>
    <script src="js/bootswatch.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar Formula</title>
</head>
<body>
<body>
<div class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a href="../index.html" class="navbar-brand">FerrAMed</a>
          
        </div>
        <div class="navbar-collapse collapse" id="navbar-main">

        </div>
      </div>
    </div>
<div align="center">
<br>
<br>
<br>
<br>
<br>

	<form action="formula" method="post" id="form1" class="form-horizontal">
		<input type="hidden" name="acao" value="atualizarFormula" id="acao"/>
		<input type="text" id="id" name="id" value="${formula_id}" style="display:none">
		<p>Nome: <input type="text" id="nome" name="nome" maxlength="50" value="${formula_nome }"></p>
		<p> Metrica Associada: 
		<select id="metricaAssociada" name="metricaAssociada" disable>
			<c:forEach var="metricaC" items="${metricasComp}">
				<option value=${ metricaC.id }> ${ metricaC.nome }</option>
			</c:forEach>
		</select></p>
		<p>Métrica 1: 
		<select id="metrica1" name="metrica1_id">
			<c:forEach var="metrica1" items="${metricas}">
				<option value="${ metrica1.id }" <c:if test="${metrica1.id == metrica1_id }">selected </c:if>> ${ metrica1.nome }</option>
			</c:forEach>
		</select></p>
		<p>Operador: 
			<select id="operadores" name="operador_f">
			<c:forEach var="operador" items="${operadores}">
				<option value=${ operador } <c:if test="${operador == operador_f }">selected </c:if>> ${ operador }</option>
			</c:forEach>
		</select></p>
		<p>Métrica 2: 
		<select id="metrica2" name="metrica2_id">
			<c:forEach var="metrica2" items="${metricas}">
				<option value=${ metrica2.id } <c:if test="${metrica2.id == metrica2_id }">selected </c:if>> ${ metrica2.nome }</option>
			</c:forEach>
		</select></p>
		<input type="submit"  value="Salvar Formula"  class="btn btn-success">
		
		</form>
		<c:if test="${message!=null}">
    	<h1>${message}</h1>
	</c:if>
		</div>
</body>
</html> 
