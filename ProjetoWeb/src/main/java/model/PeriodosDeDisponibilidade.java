package model;

import java.util.ArrayList;
import java.util.List;

public class PeriodosDeDisponibilidade {
	
	private static List<String> listaDeHorarios = new ArrayList<String>();

	static {
		//LISTA DE HORÁRIOS
		//LISTA DE HORÁRIOS SEGUNDA
		listaDeHorarios.add("Seg -> 07:00 - 09:00");
		listaDeHorarios.add("Seg -> 09:00 - 12:00");
		listaDeHorarios.add("Seg -> 14:00 - 16:00");
		listaDeHorarios.add("Seg -> 16:00 - 18:00");
		listaDeHorarios.add("Seg -> 18:00 - 20:00");
		listaDeHorarios.add("Seg -> 21:00 - 22:00");
		//LISTA DE HORÁRIOS TERÇA
		listaDeHorarios.add("Ter -> 07:00 - 09:00");
		listaDeHorarios.add("Ter -> 09:00 - 12:00");
		listaDeHorarios.add("Ter -> 14:00 - 16:00");
		listaDeHorarios.add("Ter -> 16:00 - 18:00");
		listaDeHorarios.add("Ter -> 18:00 - 20:00");
		listaDeHorarios.add("Ter -> 21:00 - 22:00");
		//LISTA DE HORÁRIOS QUARTA
		listaDeHorarios.add("Qua -> 07:00 - 09:00");
		listaDeHorarios.add("Qua -> 09:00 - 12:00");
		listaDeHorarios.add("Qua -> 14:00 - 16:00");
		listaDeHorarios.add("Qua -> 16:00 - 18:00");
		listaDeHorarios.add("Qua -> 18:00 - 20:00");
		listaDeHorarios.add("Qua -> 21:00 - 22:00");
		//LISTA DE HORÁRIOS QUINTA
		listaDeHorarios.add("Qui -> 07:00 - 09:00");
		listaDeHorarios.add("Qui -> 09:00 - 12:00");
		listaDeHorarios.add("Qui -> 14:00 - 16:00");
		listaDeHorarios.add("Qui -> 16:00 - 18:00");
		listaDeHorarios.add("Qui -> 18:00 - 20:00");
		listaDeHorarios.add("Qui -> 21:00 - 22:00");
		//LISTA DE HORÁRIOS SEXTA
		listaDeHorarios.add("Sex -> 07:00 - 09:00");
		listaDeHorarios.add("Sex -> 09:00 - 12:00");
		listaDeHorarios.add("Sex -> 14:00 - 16:00");
		listaDeHorarios.add("Sex -> 16:00 - 18:00");
		listaDeHorarios.add("Sex -> 18:00 - 20:00");
		listaDeHorarios.add("Sex -> 21:00 - 22:00");
		
	}

	public static List<String> getListadeHorarios() {
		return listaDeHorarios;
	}

}
