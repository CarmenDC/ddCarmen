package com.acing.eventos;

public class Gol extends Suceso{
	Integer minuto;
	
	public Gol() {
		super();
		minuto=0;
	}
	
	
	public Gol(Participante participante) {
		super(participante);
	}
	
	public Gol(Participante participante,int minuto) {
		super(participante);
		this.minuto = minuto;
	}

	public Participante getParticipanteAnotador() {
		return this.getParticipante();
	}
	
	public int getMinuto() {
		return minuto;
	}

}
