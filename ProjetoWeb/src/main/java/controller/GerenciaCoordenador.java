package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Coordenador;
import model.Curso;

public class GerenciaCoordenador extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void adiciona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("Rodando addCoordenador - " + action);

		// adicionar os periodos selecionados na checkBox dentro de uma lista
		String[] listaDePeriodos = request.getParameterValues("checkBoxHorario");
		List<String> periodosSelecionados = new ArrayList<String>();
		for (String p : listaDePeriodos) {
			periodosSelecionados.add(p);
		}

		String auxNome = request.getParameter("nomeCoordenador");
		String auxEmail = request.getParameter("emailCoordenador");

		// adicionar os cursos selecionados na checkBox dentro de uma lista
		String[] auxCurso = request.getParameterValues("checkBoxCurso");
		List<Curso> listaCursosSelecionados = new ArrayList<Curso>();
		for (String c : auxCurso) {
			listaCursosSelecionados.add(new Curso(c));
		}

		Coordenador coord = new Coordenador(auxNome, auxEmail, listaCursosSelecionados, periodosSelecionados);
		Controller.listaDeCoordenadores.add(coord);
		
		System.out.println("Tamanho da lista de Coordenadores: " + Controller.listaDeCoordenadores.size());
	}
	
	protected void remover(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("Rodando doDelete - " + action);

		String auxIndex = request.getParameter("coordenadorIndexApagar");
		Integer indexParametro = Integer.parseInt(auxIndex);
		
		System.out.println("APAGANDO INDEX: " + indexParametro);
		
		for (Coordenador coordenador :  Controller.listaDeCoordenadores) {
			System.out.println("Apagando " + coordenador.getNome() + " index: " + coordenador.getIndex());
		}

		Optional<Coordenador> opCoord = Controller.listaDeCoordenadores
                .stream()
                .filter((e) -> e.getIndex() == indexParametro)
                .findFirst();
		
		Controller.listaDeCoordenadores.remove(opCoord.get());
		
		System.out.println("Tamanho da lista de Coordenadores: " + Controller.listaDeCoordenadores.size());
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// EDITAR O COORDENADOR
				String action = request.getServletPath();
				System.out.println("Rodando doPut - " + action);

				String auxIndex = request.getParameter("coordenadorIndexEdit");
				Integer index = Integer.parseInt(auxIndex);

				System.out.println("Index: " + index);

				String[] listaDePeriodos = request.getParameterValues("checkBoxHorario");
				List<String> periodosSelecionados = new ArrayList<String>();
				for (String p : listaDePeriodos) {
					periodosSelecionados.add(p);
				}
				String[] auxCurso = request.getParameterValues("checkBoxCurso");
				List<Curso> listaCursosSelecionados = new ArrayList<Curso>();
				for (String c : auxCurso) {
					listaCursosSelecionados.add(new Curso(c));
				}

				String auxNomeAtualizado = request.getParameter("nomeCoordenador");
				String auxEmailAtualizado = request.getParameter("emailCoordenador");

				System.out.println("Nome at: " + auxNomeAtualizado);
				System.out.println("Email at: " + auxEmailAtualizado);
				
				Optional<Coordenador> opCoord = Controller.listaDeCoordenadores
		                .stream()
		                .filter((e) -> e.getIndex() == index)
		                .findFirst();

				opCoord.get().setNome(auxNomeAtualizado);
				opCoord.get().setEmail(auxEmailAtualizado);
				opCoord.get().setListaDeCursos(listaCursosSelecionados);
				opCoord.get().setPeriodosDeDisponibilidade(periodosSelecionados);
				
				System.out.println("Tamanho da lista de Coordenadores: " + Controller.listaDeCoordenadores.size());
		
	}
	
}
