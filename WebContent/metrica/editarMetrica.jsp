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
<title>Editar Metrica</title>
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
	<form action="metrica" method="post" id="form1" class="form-horizontal">
		<input type="hidden" name="acao" value="atualizarMetrica" id="acao"/>
		<input type="text" id="id" name="id" value="${metrica_id}" style="display:none">
		<p>Nome: <input type="text" id="nome" name="nome" maxlength="50" value="${metrica_nome }"></p>
		
		<select id="indicador" name="indicador">
				<c:if test="${indicadores!=null}">
					<c:forEach var="indicador" items="${indicadores}">
						<c:choose>
							<c:when test="${metrica_id_indicador == indicador.id}">
								<option value=${ indicador.id } selected="selected">${ indicador.descricao }</option>
							</c:when>
							<c:otherwise>
								<option value=${ indicador.id }> ${ indicador.descricao }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:if>
			</select>
		
		<p>Processo de coleta: <input type="text" id="processoColeta" name="processoColeta" maxlength="2000" value="${metrica_processoColeta }"></p>
		<p>Processo de analise: <input type="text" id="processoAnalise" name="processoAnalise" maxlength="2000" value="${metrica_processoAnalise }"></p>
		<p> Tipo <select id="tipoMetrica" name="tipoMetrica">
					<option value="SIMPLES"> Metrica Simples</option>
					<option value="COMPOSTA"> Metrica Composta</option>
				</select></p>
		<input type="submit"  value="Salvar Metrica" class="btn btn-success">
		
		</form>
		<c:if test="${message!=null}">
    	<h1>${message}</h1>
	</c:if>
		</div>
</body>
</html>