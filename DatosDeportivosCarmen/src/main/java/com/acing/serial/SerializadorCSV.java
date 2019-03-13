package com.acing.serial;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.acing.eventos.Evento;
import com.acing.eventos.EventoDAO;
import com.acing.eventos.Gol;
import com.acing.eventos.Participante;
import com.acing.eventos.Partido;
import com.acing.eventos.Suceso;
import com.acing.eventos.Tarjeta;

public class SerializadorCSV implements EventoDAO {
	
	private final String ruta;
	
	public SerializadorCSV(String ruta) {
		this.ruta=ruta;
	}

	
	public static Collection<? extends Evento> getEventos(String rutaArchivoCSV) throws ParseException{
		
		Collection<Evento> eventosLeidos = new ArrayList();
		
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(rutaArchivoCSV),"UTF-8"))){
			
			String linea = reader.readLine();
			while((linea = reader.readLine()) != null) {
				eventosLeidos.add((Evento) deserializarEvento(linea));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		return eventosLeidos;

	}


	private static Partido deserializarEvento(String linea) throws ParseException {
		String [] campos = linea.split(",");
		String fechasString = campos [1];
		String localString = campos [2];
		String visitanteString = campos[3];
		String golesLocalString = campos [4];
		String golesVisitanteString =campos[5];
		
		String tarjetaYLocal = campos [18];
		String tarjetaYVisitante = campos [19];		
		String tarjetaRLocal = campos [20];
		String tarjetaRVisitante = campos [21];	
		
		SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/yy");
		
		Date fecha =sdformat.parse(fechasString);
		
		Participante local = new Participante(localString);
		Participante visitante = new Participante(visitanteString);
		int golesLocal = Integer.parseInt(golesLocalString);
		int golesVisitante = Integer.parseInt(golesVisitanteString);
		
		int tjtaYellowLocal =Integer.parseInt(tarjetaYLocal);
		int tjtaYellowVisitante = Integer.parseInt(tarjetaYVisitante);
		int tjtaRedLocal =Integer.parseInt(tarjetaRLocal);
		int tjtaRedVisitante = Integer.parseInt(tarjetaRVisitante);		
		Partido miEvento = new Partido (local, visitante, fecha);
		
//		Suceso suceso = new Suceso();
		
//		miEvento.addSucesos(suceso.getClass(),golesLocal,local);
//		miEvento.addSucesos(suceso.getClass(),golesVisitante,visitante);
//		
		Gol golLocal = new Gol(local);
		miEvento.addSucesos(golLocal.getClass(), golesLocal, golLocal.getParticipanteAnotador());
		Gol golVisitante = new Gol(visitante);
		miEvento.addSucesos(golVisitante.getClass(), golesVisitante, golVisitante.getParticipanteAnotador());

		Tarjeta tarjetaYellowLocal = new Tarjeta(local, "Y");	
		Tarjeta tarjetaYellowVisitante = new Tarjeta(visitante, "Y");
		Tarjeta tarjetaRedLocal = new Tarjeta(local, "R");
		Tarjeta tarjetaRedVisitante= new Tarjeta(visitante, "R");
		
		miEvento.addSucesos(tarjetaYellowLocal.getClass(), tjtaYellowLocal, tarjetaYellowLocal.getParticipanteAmonestado());
		miEvento.addSucesos(tarjetaYellowVisitante.getClass(), tjtaYellowVisitante, tarjetaYellowVisitante.getParticipanteAmonestado());
		miEvento.addSucesos(tarjetaRedLocal.getClass(), tjtaRedLocal, tarjetaRedLocal.getParticipanteAmonestado());
		miEvento.addSucesos(tarjetaRedVisitante.getClass(), tjtaRedVisitante, tarjetaRedVisitante.getParticipanteAmonestado());
		
		return miEvento;
	}


	@Override
	public Collection<? extends Evento> getEventos() throws ParseException {
		return getEventos(ruta);
	}


	@Override
	public Collection<? extends Evento> getEventos(Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <T extends Evento> int guardarEventos(Evento... eventos) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public <T extends Evento> Evento borrarEvento(Evento evento) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <T extends Evento> boolean actualizarEvento(Evento evento) {
		// TODO Auto-generated method stub
		return false;
	}
		

 }
