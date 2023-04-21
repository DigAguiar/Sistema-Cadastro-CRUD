package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Coordenador;
import model.Curso;

@WebServlet(urlPatterns = { "/menu", "/adicionandoCoord", "/apagarCoord", "/editarCoord", "/enviarParaEditarCoord",
		"/enviarParaAddCoord", "/fazerGet", "/enviandoMostruarioParaMenu" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	GerenciaCoordenador gerencia = new GerenciaCoordenador();

	static List<Curso> listaDeCursos = new ArrayList<Curso>();

	static {
		listaDeCursos.add(new Curso("Engenharia de Software"));
		listaDeCursos.add(new Curso("Administração"));
		listaDeCursos.add(new Curso("Análise e Desenvolvimento de Sistemas"));
		listaDeCursos.add(new Curso("Ciências contábeis"));
		listaDeCursos.add(new Curso("Segurança da informação"));
		listaDeCursos.add(new Curso("Serviço Social"));
		listaDeCursos.add(new Curso("Teologia"));
		listaDeCursos.add(new Curso("Matemática"));
		listaDeCursos.add(new Curso("Logística"));
		listaDeCursos.add(new Curso("Jogos Digitais"));
		listaDeCursos.add(new Curso("Gestão de qualidade"));
		listaDeCursos.add(new Curso("Geografia"));
		listaDeCursos.add(new Curso("Gestão Financeira"));
		listaDeCursos.add(new Curso("Marketing Digital"));

		listaDeCursos.sort(Comparator.comparing(Curso::getNome));
	}
	Coordenador coord = new Coordenador();
	public static List<Coordenador> listaDeCoordenadores = new ArrayList<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println("Rodando doGet - " + action);

		request.setAttribute("listaCoord", listaDeCoordenadores);
		RequestDispatcher rd = request.getRequestDispatcher("/mostruario.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println("Rodando doPost - " + action);

		if (action.equals("/adicionandoCoord")) {
			addCoordenador(request, response);
		} else if (action.equals("/apagarCoord")) {
			doDelete(request, response);
			doGet(request, response);
		} else if (action.equals("/editarCoord")) {
			doPut(request, response);
			doGet(request, response);
		} else if (action.equals("/enviarParaEditarCoord")) {
			enviandoParaEdicao(request, response);
		} else if (action.equals("/enviarParaAddCoord")) {
			enviandoParaAdd(request, response, "none");
		} else if (action.equals("/enviandoMostruarioParaMenu")) {
			enviandoMostruarioParaMenuu(request, response);
		} else {
			System.out.println("Não entrou no if -> " + action);
			response.sendRedirect("/menu");
		}

	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		gerencia.remover(request, response);

	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		gerencia.update(request, response);

	}

	protected void addCoordenador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String auxEmail = request.getParameter("emailCoordenador");
		System.out.println(auxEmail);

		boolean opCoord = listaDeCoordenadores.stream().filter((e) -> e.getEmail().equals(auxEmail)).findFirst()
				.isEmpty();

		System.out.println(opCoord);

		if (opCoord) {
			gerencia.adiciona(request, response);
			doGet(request, response);
		} else {
			var mostraErro= "";
			enviandoParaAdd(request, response, mostraErro);
		}

	}

	protected void enviandoParaEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("Rodando enviandoParaEdicao - " + action);

		String indexCoord = request.getParameter("coordenadorIndexEditar");
		Integer indexCoordOnParse = Integer.parseInt(indexCoord);

		System.out.println("Index no /enviandoParaEdicao: " + indexCoord);

		Optional<Coordenador> opCoord = listaDeCoordenadores.stream().filter((e) -> e.getIndex() == indexCoordOnParse)
				.findFirst();

		request.setAttribute("coordEdicaoId", opCoord.get());
		request.setAttribute("listaCursosCoord", listaDeCursos);

		RequestDispatcher rd = request.getRequestDispatcher("/editarCoordenador.jsp");
		rd.forward(request, response);
	}

	protected void enviandoParaAdd(HttpServletRequest request, HttpServletResponse response, String mostraErro)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("Rodando enviandoParaAdd - " + action);

		request.setAttribute("mostraErro", mostraErro);
		request.setAttribute("listaCursosCoord", listaDeCursos);
		request.setAttribute("listaCoord", listaDeCoordenadores);

		RequestDispatcher rd = request.getRequestDispatcher("/addCoordenador.jsp");
		rd.forward(request, response);
	}

	protected void enviandoMostruarioParaMenuu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("listaCoord", listaDeCoordenadores);

		System.out.println("Tamanho da lista de Coordenadores: " + listaDeCoordenadores.size());

		RequestDispatcher rd = request.getRequestDispatcher("/menu.jsp");
		rd.forward(request, response);

	}

}