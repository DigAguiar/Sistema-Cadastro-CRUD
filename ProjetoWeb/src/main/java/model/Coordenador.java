package model;

import java.util.List;

public class Coordenador {

	private static Integer lastIndex = 0;
	private Integer index;
	private String nome;
	private String email;
	private List<Curso> listaDeCursos;
	private List<String> periodosDeDisponibilidade;

	public Coordenador () {
	}

	public Coordenador (String nome, String email, List<Curso> listaCursos, List<String> periodos) {
		this.nome = nome;
		this.email = email;
		this.listaDeCursos = listaCursos;
		this.periodosDeDisponibilidade = periodos;
		this.index = lastIndex++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public List<String> getPeriodosDeDisponibilidade() {
		return periodosDeDisponibilidade;
	}

	public void setPeriodosDeDisponibilidade(List<String> periodosDeDisponibilidade) {
		this.periodosDeDisponibilidade = periodosDeDisponibilidade;
	}

	public List<Curso> getListaDeCursos() {
		return listaDeCursos;
	}

	public void setListaDeCursos(List<Curso> listaDeCursos) {
		this.listaDeCursos = listaDeCursos;
	}

	
	

	

	
	
	
	
	
	
	
	
	
	





}
