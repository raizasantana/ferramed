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
<title>Editar coleta</title>
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
<br>
<br>

	<form action="coleta" method="post" id="form1" class="form-horizontal">
		<input type="hidden" name="acao" value="Editar" id="acao"/>
		<input type="text" id="id" name="id" value="${coleta_id}" style="display:none">
		<p>Métrica: <input type="text" id="nome" name="nome" maxlength="50" value="${coleta_metrica.nome}" readonly="readonly"></p>
		
		
		<p>Observação: <input type="text" id="observacao" name="observacao" maxlength="2000" value="${coleta_observacao}"></p>
		<p>Valor: <input type="text" id="valorColeta" name="valorColeta" maxlength="20" value="${coleta_valor}"></p>
		
		<input type="submit"  value="Salvar Coleta" class="btn btn-success">
		
		</form>
		<c:if test="${message!=null}">
    	<h1>${message}</h1>
	</c:if>
	</div>	
</body>
</html> 
