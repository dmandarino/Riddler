<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>Riddler - Cadastro de Benefícios</title>

<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="css/cadastroBeneficio.css" rel="stylesheet">
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
			<h1 class="muted">Cadastro de Benefícios</h1>
		</div>
		<hr />
		<div class="form">
			<form action="cadastrarBeneficios" method="post">
				<div>
					<p class="alert-error">${erro}</p>
					<table>
						<tr>
							<td><div align="left">
								Nome: <input type="text" id="beneficio" name="beneficio.nome">
								</div>
							</td>
						
						</tr>
					</table>
						<div class="control-group  " id="rendered">
							<td>Prazo:<input type="number" min="0" id="prazo" name="beneficio.prazo" /></td>
							
							<div class="clone count">
								<label class="control-label" for="inputEtapa">Etapa:</label>
								 <input class="etapaName" type="text" id="inputEtapa"
									name="beneficio.etapas[0].nome" placeholder="Nome da etapa">
								<input type="hidden" id="ordem" class="ordem"
									name="beneficio.etapas[0].ordem" value="1" />
							</div>

						</div>
				</div>

				<div class="concluida">
					<input type="hidden" class="etapaFinal" id="inputFinal"
						name="beneficio.etapas[1].nome" value="Concluida"> <input
						type="hidden" id="ordem" class="ordem"
						name="beneficio.etapas[1].ordem" value="2" />
				</div>

				<i class="icon-plus-sign" id="add"></i> 
				<p><input type="submit" class="btn btn-success" value="Cadastrar">
				</br>
			</form>
		</div>



		<jsp:include page="footer.jsp"></jsp:include>
	</div>


	<script type="text/javascript">
		function removerEtapa(div) {
			var pai = $(div).parent();
			pai.remove();
		}

		$("#add")
				.click(
						function() {
							var clone = $(".clone").clone();
							$(clone).removeClass("clone");
							var etapaCount = $(".count").length + 1;
							var name = "beneficio.etapas[" + (etapaCount - 1)
									+ "].nome";
							var order = "beneficio.etapas[" + (etapaCount - 1)
									+ "].ordem";
							$(clone).find('label').text('Etapa: ');
							$(clone).find('input.etapaName').val('').attr(
									"name", name);
							$(clone).find('input.ordem').val(etapaCount).attr(
									"name", order);

							var nameConcluida = "beneficio.etapas["
									+ (etapaCount) + "].nome";
							var ordemConcluida = "beneficio.etapas["
									+ (etapaCount) + "].ordem";
							$(".concluida").find('input.etapaFinal').attr(
									"name", nameConcluida);
							$(".concluida").find('input.ordem').val(
									etapaCount + 1)
									.attr("name", ordemConcluida);

							$('<i/>', {
								class : "icon-minus-sign",
								onclick : "removerEtapa(this)"
							}).appendTo(clone);

							$("#rendered").append(clone);

						});
	</script>

</body>
</html>
