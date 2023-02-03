package com.lesson.gestioneeventi;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

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
	public int numeroEventi(){
		int i = 0;
		
		for(Evento Evento: Eventi) {
			i++;
		}
		return i;
	}
	
	public void svuotaArray() {
		Eventi.clear();
		System.out.println("Hai cancellato tutto gli eventi");
	}
	public void ordinaData() {
		ArrayList<String> dateArray = new ArrayList<String>();
		
		for(Evento Evento : Eventi) {
			dateArray.add(Evento.dataStr());
			Collections.sort(dateArray);
		}
		for(int n=0; n<numeroEventi(); n++) {
			
			for(Evento Evento : Eventi) {
				
				if(dateArray.get(n).equals(Evento.dataStr())) {
					System.out.println(Evento.data() + " " + Evento.getTitolo());
				}
			}
			
		}
	}
	
}
