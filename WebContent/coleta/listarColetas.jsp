<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="../css/tableStyleGenerator.css">
<head>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/bootswatch.min.css">
 
    <script src="../../js/bootstrap.min.js"></script>
    <script src="js/bootswatch.js"></script>
<link rel="stylesheet" type="text/css" href="../css/tableStyleGenerator.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Coletas Realizadas</title>
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
	<div id="listarColetas" name="acao" value="Listar">
		<table class="table table-striped table-hover">
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
		<center><a class="btn btn-success" href="coleta?acao=listarMetricas"">Realizar nova Coleta</a><center>
	</div>
</div>
</body>
</html> 
