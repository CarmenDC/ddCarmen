package com.acing.app;


import java.util.Collection;

import javax.swing.JFrame;

import com.acing.eventos.Evento;
import com.acing.eventos.EventoDAO;
import com.acing.eventos.Partido;
import com.acing.iu.EjemploJFrame;
import com.acing.iu.JFramePartido;
import com.acing.serial.SerializadorCSV;
import com.acing.serial.SerializadorJSON;

public class App {
	EventoDAO eventoDAO;
	
	public static void main(String[] args) throws Exception {
		
		Collection<? extends Evento> eventos;
		String rutaCSV ="datos/SP1.csv";
		String rutaJsonString ="datos/eventos.json";
		
		App app = new App();
		
		app.eventoDAO = new SerializadorCSV(rutaCSV);
		eventos = app.eventoDAO.getEventos();
		
		app.eventoDAO = new SerializadorJSON(rutaJsonString);
		app.eventoDAO.guardarEventos(eventos.toArray(new Partido [0]));
		eventos = app.eventoDAO.getEventos();
		
		
		eventos.stream().forEach(d -> System.out.println(d));
		
		
		JFrame pruebaPartido = new JFramePartido((Partido) eventos.toArray()[0]);
		pruebaPartido.setVisible(true);
		
	}

}
