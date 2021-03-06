<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>Cadastro de Funcion&atilde;rios</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="css/cadastroFuncionario.css" rel="stylesheet">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />

<jsp:include page="headerCSS.jsp" />

</head>

<body>

	<div class="container">

		<jsp:include page="header.jsp" />

		<div class="masthead" align="center">
			<h1 class="muted">Cadastro de Funcionários</h1>
		</div>
		<hr />
		<div class="form">
			<form action="cadastrarFuncionario" method="post">
				${erro}
				<h4>

					Nome: <input type="text" id="usuario" name="funcionario.nome">
				</h4>
				<h4>
					Data de Admissão: <input type="text" id="datepicker"
						name="funcionario.dataDeAdmissao" />
				</h4>

				<table class="table table-striped">
					<tbody>
						<c:forEach var="beneficio" items="${beneficios}" varStatus="count">
							<label class="checkbox"> <input type="checkbox"
								name="etapasSelecionadas[${count.index}]"
								value="${beneficio.primeiraEtapa.id}" /> ${beneficio.nome}
							</label>
						</c:forEach>
					</tbody>
				</table>
				<input type="submit" class="btn btn-success" value="Cadastrar">
			</form>
		</div>

		<jsp:include page="footer.jsp"></jsp:include>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#datepicker").datepicker();
			$("#datepicker").datepicker("option", "dateFormat", "dd/mm/yy");

			$("#anim").change(
					function() {
						$("#datepicker").datepicker("option", "showAnim",
								$(this).val());
					});
		});
	</script>
</body>
</html>
