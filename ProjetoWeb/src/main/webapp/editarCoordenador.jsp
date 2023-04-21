<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


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
<link rel="shortcut icon" href="./imagens/forma.png" type="image/x-icon">
<title>Editar Coordenadores</title>
</head>

<body>




	<div class="container m-3 mx-auto">
		<div class="row align-items-md-stretch">

			<div class="col-md-6">
				<div class="h-100 p-3 text-bg-dark rounded-3 ">
					<h1>Editar Coordenadores</h1>
					<p>Sistema para edição dos coordenadores</p>
					<hr class="my-4">
					<img src="./imagens/imagemBonitinha.png" class="img-fluid"
						alt="...">
				</div>
			</div>

			<div class="col-md-6">
				<div class="h-100 p-5 bg-body-tertiary border rounded-3">

					<form action="editarCoord" method="post">

							<input type="hidden" name="coordenadorIndexEdit"
								value="${coordEdicaoId.index}">

							<div class="form-floating mb-3 ">
								<input type="text" class="form-control" placeholder="Nome"
									name="nomeCoordenador" value="${coordEdicaoId.nome}" required> <label
									for="floatingTextarea" class="form-label">Nome</label>
							</div>

							<div class="form-floating mb-3">
								<input type="email" class="form-control" placeholder="Email"
									name="emailCoordenador" aria-describedby="emailHelp" value="${coordEdicaoId.email}" required>
								<label for="floatingTextarea">Email</label>
							</div>

						

						<hr class="my-4">

						<div class="table-responsive">

							<table
								class="table table-responsive my-4  table-borderless table-sm align-middle ">

								<thead>
									<tr>
										<th>Dia da Semana</th>
										<th>07:00 - 09:00</th>
										<th>09:00 - 12:00</th>
										<th>14:00 - 16:00</th>
										<th>16:00 - 18:00</th>
										<th>18:00 - 20:00</th>
									</tr>
								</thead>

								<tbody>
									<tr>
										<td>Segunda-feira</td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Segunda-> 07h-09h"></td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Segunda-> 09h-12h"></td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Segunda-> 14h-16h"></td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Segunda-> 16h-18h"></td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Segunda-> 18h-20h" ></td>
									</tr>
									<tr>
										<td>Terça-feira</td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Terca-> 07h-09h"></td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Terca-> 09h-12h"></td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Terca-> 14h-16h"></td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Terca->16h-18h"></td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Terca-> 18h-20h"></td>
									</tr>
									<tr>
										<td>Quarta-feira</td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Quarta-> 07h-09h"></td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Quarta-> 09h-12h"></td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Quarta-> 14h-16h"></td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Quarta-> 16h-18h"></td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Quarta-> 18h-20h"></td>
									</tr>
									<tr>
										<td>Quinta-feira</td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Quinta-> 07h-09h"></td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Quinta-> 09h-12h"></td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Quinta-> 14h-16h"></td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Quinta-> 16h-18h"></td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Quinta-> 18h-20h"></td>
									</tr>
									<tr>
										<td>Sexta-feira</td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Sexta-> 07h-09h"></td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Sexta-> 09h-12h"></td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Sexta-> 14h-16h"></td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Sexta-> 16h-18h"></td>
										<td><input type="checkbox" name="checkBoxHorario"
											value="Sexta-> 18h-20h"></td>
									</tr>
								</tbody>

							</table>
							<hr class="my-4">
						</div>
					
						<div class="table-responsive">

							<table
								class="table table-responsive my-4  table-borderless table-sm align-middle ">
								<thead>
									<tr>

										<th scope="col">Curso</th>
										<th scope="col">Selecionar</th>
									</tr>
								</thead>

								<tbody>

									<c:forEach items="${listaCursosCoord}" var="listaCursosCoords">
										<tr>
											<td>${listaCursosCoords.nome}</td>
											<td><input type="checkbox" name="checkBoxCurso"
												value="${listaCursosCoords.nome}"></td>
										</tr>
									</c:forEach>

								</tbody>

							</table>

						</div>
						<hr class="my-4">
					
						<div class="form-floating mb-3 ">
							<div class="btn-group w-100" role="group"
								aria-label="Basic mixed styles example">
								<button type="submit" class="btn btn-success">Salvar</button>
								<button type="reset" class="btn btn-danger">Limpar
									Campos</button>
							</div>
						</div>
					

					</form>

				</div>
			</div>
		</div>
	</div>
	
	

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>

</html>