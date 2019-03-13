package com.acing.eventos;

import java.util.Collection;

public interface EventoConGoles extends LocalContraVisitante{
	
	static String getFromatoGoles() {
		return null;
	}
	
	Collection<Gol> getGoles();
	
	int getGolesParticipante(Participante participante);
	void addGoles(int numGolesLocal, int numGolesVisitante);
	
	String getResultado();	

}
