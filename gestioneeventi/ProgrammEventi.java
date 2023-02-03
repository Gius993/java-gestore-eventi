package com.lesson.gestioneeventi;
import java.util.List;
import java.util.ArrayList;


public class ProgrammEventi {
	private String titolo;
	private List<Evento> Eventi;
	
	public ProgrammEventi(String titolo, List<Evento> Eventi) {
		
		this.titolo = titolo;
		this.Eventi = Eventi;
		

	}
	
	public void salvaEvento(Evento e) {
		Eventi.add(e);
	}
	
	public void listaEventi() {
		for(Evento Evento : Eventi) {
			System.out.println(Evento);
		}
	}
}
