<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="../css/tableStyleGenerator.css">
<link rel="stylesheet" type="text/css" href="../css/tableStyleGenerator.css">
<head>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/bootswatch.min.css">
 <script src="../../js/bootstrap.min.js"></script>
    <script src="js/bootswatch.js"></script>
<head>

<title>Lista de Fórmulas</title>
</head>
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
	<div id="listarFormulas" name="acao" value="listar">
		<table class="table table-striped table-hover">
			<tr>
				<td>NOME</td>
				<td>1ª MÉTRICA</td>
				<td>OPERADOR</td>
				<td>2ª MÉTRICA</td>
				<td>ACAO</td>
			</tr>
			<c:if test="${formulas!=null}">
				<c:forEach var="formula" items="${formulas}">
					<tr>
						<td> ${formula.nome} </td>
						<td> ${formula.metrica1.nome} </td>
						<td> ${formula.operador} </td>
						<td> ${formula.metrica2.nome} </td>
						<td><center><a data-target="#conteudo" class="button" href="formula?acao=editarFormula&id=${formula.id}">Editar</a><center></td>
					</tr>
					
				</c:forEach>
			</c:if>
			
		</table>
		<br/>
		<center><a  class="btn btn-success"  href="formula?acao=listarMetrica">Nova Formula</a><center>
	</div>
	</div>
</body>
</html> 
