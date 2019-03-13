package com.acing.eventos;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class Partido extends EventoImpl implements GestorSucesos{
	private final static SimpleDateFormat sdfToString = new SimpleDateFormat("dd/MM/yy HH:mm");
	private Participante local;
	private Participante visitante;
	
	public String getResultado() {
		long golesLocal = 0;
		long golesVisitante = 0;
		
		golesLocal = getSucesosParticipante(local);
		golesVisitante = getSucesosParticipante(visitante);
		
		return golesLocal + "-" + golesVisitante;
	}
	
	public Partido () {
		super();
	}
	
	public Partido(Participante local, Participante visitante, Date fecha) {
		super();
		this.local = local;
		this.visitante = visitante;
		setFecha(fecha);
	}



	@Override
	public Collection<Gol> getGoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGolesParticipante(Participante participante) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addGoles(int numGolesLocal, int numGolesVisitante) {
		// TODO Auto-generated method stub
		
	}


	public Participante getLocal() {

		return local;
	}


	public Participante getVisitante() {

		return visitante;
	}

	@Override
	public String toString() {
		return "(" + sdfToString.format(getFecha()) + ") " + local + " vs " + visitante + "=>" + getResultado();
		}

	static SimpleDateFormat getSdftostring() {
		return sdfToString;
	}

}
