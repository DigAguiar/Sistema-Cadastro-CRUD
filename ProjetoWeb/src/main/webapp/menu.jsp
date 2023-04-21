<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<title>Menu Principal</title>
<link rel="shortcut icon" href="./imagens/forma.png" type="image/x-icon">
</head>

<body>

	<div class="container my-5 col-3 mx-auto">

		<img src="./imagens/imagemBonitinha.png" class="img-fluid mb-3"
			alt="cadastroCoordenadores">

		<div class="d-grid gap-2 ">

			<form action="enviarParaAddCoord" method="post">
				<button name="botaoAddCoord" type="submit"
					class="btn btn-primary w-100">Adicionar</button>
			</form>
			
			<form action="fazerGet" method="get">
				<button class="btn btn-primary w-100" type="submit">Lista
					Coordenadores</button>
			</form>

		</div>
	</div>

</body>

</html>