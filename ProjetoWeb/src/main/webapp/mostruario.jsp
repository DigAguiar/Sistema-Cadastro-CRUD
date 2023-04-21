<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Coordenador"%>

<!DOCTYPE html>
<html lang="pt-BR" data-bs-theme="dark">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<link rel="shortcut icon" href="../imagens/forma.png"
	type="image/x-icon">
<title>Mostruário Coordenadores</title>
</head>

<body>
	<div class="container my-3 w-100">

		<div class="h-100 p-4 bg-body-tertiary border rounded-3">

			<!--Início banner-->
			<form action="enviandoMostruarioParaMenu" method="post">
				<button type="submit" class="btn btn-secondary">MENU</button>
			</form>
			<div class="jumbotron text-center">
				<h1 class="display-4">Coordenadores Cadastrados</h1>
				<hr class="my-4">
			</div>

			<!--Fim banner-->

			<!--Início caso a lista não esteja vazia-->
			<c:if test="${not empty listaCoord}">

				<!--Início list group-->
				<div class="list-group">

					<c:forEach items="${listaCoord}" var="coordenadores">

						<ul class="list-group list-group-horizontal mb-3">

							<li class="list-group-item flex-fill">${coordenadores.nome}</li>
							<li class="list-group-item flex-fill">${coordenadores.email}</li>
							<li class="list-group-item flex-fill">${coordenadores.periodosDeDisponibilidade}</li>

							<li class="list-group-item flex-fill"><c:forEach
									items="${coordenadores.listaDeCursos}" var="liCoord">
								${liCoord.nome} <br>
								</c:forEach></li>

							<!--Início button group-->
							<div class="btn-group  ms-2" role="group"
								aria-label="Basic mixed styles example">

								<!--Início form de editar-->
								<form action="enviarParaEditarCoord" method="post">
									<button type="submit" class="btn btn-warning me-1"
										name="botaoEditar">Editar</button>
									<input type="hidden" name="coordenadorIndexEditar"
										value="${coordenadores.index}">
								</form>
								<!--Fim form de editar-->

								<!--Início form de apagar-->
								<form action="./apagarCoord" method="post">
									<button type="submit" class="btn btn-danger">Apagar</button>
									<input type="hidden" name="coordenadorIndexApagar"
										value="${coordenadores.index}">
								</form>
								<!--Fim form de apagar-->

							</div>

							<!--Fim button group-->

						</ul>

					</c:forEach>

				</div>
				<!--Fim list group-->

			</c:if>
			<!--Fim caso a lista não esteja vazia-->

			<!--Se estiver a lista estiver vazia-->
			<c:if test="${empty listaCoord}">
				<p class="text-center my-3">Nenhum coordenador cadastrado!</p>
			</c:if>
			<!--Fim se a lista estiver vazia-->

		</div>

	</div>
</body>

</html>