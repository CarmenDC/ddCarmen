package com.acing.eventos;

public class Corner extends Suceso {
	
	Integer minuto;
	
	public int getMinuto() {
		return minuto;
	}
	
	public Corner() {
		super();
		minuto=0;
	}

	
	public Corner(Participante participante, int minuto) {
		super(participante);
		this.minuto = minuto;
	}
	
	public Participante getParticipanteSacaCorner() {
		return this.getParticipante();
		
	}

}
