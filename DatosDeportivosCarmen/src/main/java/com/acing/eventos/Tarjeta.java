package com.acing.eventos;

public class Tarjeta extends Suceso{

 	
	private Integer minuto;
	private String tipoTarjeta;
	
	
	public Tarjeta() {
		super();
		minuto=0;
		tipoTarjeta= null;
	}

	public Tarjeta(Participante participante,String tipo) {
		super(participante);
		tipoTarjeta = tipo;
	}
	
	public Tarjeta (Participante participante, int minuto, String tipo) {
		super(participante);
		this.minuto= minuto;
		tipoTarjeta=tipo;
	}
	
	public Participante getParticipanteAmonestado() {
		return this.getParticipante();	
	}

	public int getMinuto() {
		return minuto;
	}
	
	


}
