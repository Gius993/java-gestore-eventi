package com.lesson.gestioneeventi;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		List<Evento> Eventi = new ArrayList<>();
		boolean whilMainCicle = true;
		String tipoEvento;
		System.out.println("Che tipo di evento cerchi? Concerto o Evento generico?)");
		String eventoConcertoNon = scan.next();
		if (eventoConcertoNon.equals("Evento generico")) {
			while (whilMainCicle) {

				System.out.println("Vuoi creare un nuovo evento? si no)");
				String creaEvento = scan.next();
				if (!creaEvento.equals("si")) {
					whilMainCicle = false;
					scan.close();
					System.out.println("Torna quando vorrai creare un evento");
				}
				System.out.println("Nome even ");
				String titolo = scan.next();

				System.out.println("Gioro");
				int giorno = scan.nextInt();

				System.out.println("Mese");
				int mese = scan.nextInt();

				System.out.println("Anno");
				int anno = scan.nextInt();

				System.out.println("Numero massimo di persone che possono partecipart");
				int posti = scan.nextInt();

				System.out.println("Numero di posti già occupati");
				int postiPrenotati = scan.nextInt();

				try {

					Evento eventi = new Evento(titolo, giorno, mese, anno, LocalDate.now(), posti, postiPrenotati);

					eventi.scadenza();
					while (true) {
						System.out.println("Vuoi prenotare? (si no)");
						String p = scan.next();
						if (!p.equals("si")) {
							break;
						} else {
							System.out.println("Quanti posti vuoi prenotare?");
							int nump = scan.nextInt();
							for (int i = 0; i < nump; i++) {
								eventi.prenota();
							}
							System.out.println("I poosti prenotati sono: " + eventi.getPostiPrenotati());
							int postiLiberi = eventi.getPostiTotali() - eventi.getPostiPrenotati();
							System.out.println("I poosti liberi sono: " + postiLiberi);
							break;
						}
					}
					while (true) {
						System.out.println("Vuoi disdire? (si no)");
						String disdette = scan.next();
						if (!disdette.equals("si")) {
							break;
						} else {
							System.out.println("Quanti posti vuoi disdire?");
							int numerod = scan.nextInt();
							for (int n = 0; n < numerod; n++) {
								eventi.disdici();
							}
							System.out.println("I poosti prenotati sono: " + eventi.getPostiPrenotati());
							int postiLiberi = eventi.getPostiTotali() - eventi.getPostiPrenotati();
							System.out.println("I poosti liberi sono: " + postiLiberi);
							break;
						}
					}

				} catch (Exception e) {
					System.err.println(e.getMessage());
					whilMainCicle = false;
					scan.close();
				}
			}

		} else if(eventoConcertoNon.equals("Concerto")) {
			Concerto c = new Concerto("Ey jion jon", 18, 22, 2023, LocalDate.now(), 2008, 0, "50.78", 22, 0);
			System.out.println(c);
		}else {
			System.out.println("Non esiste tale evento");
		}

	}

}
