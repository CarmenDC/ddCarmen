package com.acing.eventos;

import java.util.HashMap;
import java.util.Map;

import es.lanyu.commons.identificable.AbstractNombrable;

public class Participante extends AbstractNombrable{
	
	public static Map<String,Participante> mapaParticipantesMap = new HashMap<>();
	
	public Participante() {
		super();
	}

	public Participante(String nombre) {
		setIdentificador(nombre);
		setNombre(nombre);
	}
	
	public String toString() {
		return nombre;
	}

}
