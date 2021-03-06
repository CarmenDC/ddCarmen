package com.acing.eventos;

import java.util.HashMap;
import java.util.Map;

public class GestorParticipantes {

	Map<String, Participante> mapaParticipantes = new HashMap<>();
	Map<Participante, String> mapaIdentificadores = new HashMap<>();
	String formato="#%s";
	int proximoId = 1;
	
	Map<String, Participante> getMapaParticipantes() {
		return mapaParticipantes;
	}
	
	Map<Participante, String> getMapaIdentificadores() {
		return mapaIdentificadores;
	}

	String generarId() {
		return String.format(formato, proximoId++);
	}

	public boolean registrarParticipante(Participante participante) {
		boolean anadido = getMapaParticipantes().containsValue(participante);
		if(!anadido) {
			getMapaParticipantes().put(participante.getIdentificador(),participante);
			getMapaIdentificadores().put(participante,participante.getIdentificador());
		}
		return anadido;
	}
	
	public Participante getParticipante(String id) {
		return getMapaParticipantes().get(id);
	}
	
	
}
