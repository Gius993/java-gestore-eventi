package com.lesson.gestioneeventi;

import java.time.LocalDate;

public class Evento {

	private String titolo;
	private int giorno;
	private int mese;
	private int anno;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati = 0;

	// Costruttore
	public Evento(String titolo, int giorno, int mese, int anno, LocalDate data, int postiTotali, int postiPrenotati)
			throws Exception {

		setTitolo(titolo);
		setGiorno(giorno);
		setMese(mese);
		setAnno(anno);
		setDataOggi(data);

		this.postiTotali = postiTotali;
		this.postiPrenotati = postiPrenotati;
	}

	// get
	public String getTitolo() {
		return titolo;
	}

	public int getGiorno() {
		return giorno;
	}

	public int getMese() {
		return mese;
	}

	public int getAnno() {
		return anno;
	}

	public LocalDate getDataOggi() {
		return data;
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	// set
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setGiorno(int giorno) {
		this.giorno = giorno;
	}

	public void setMese(int mese) {
		this.mese = mese;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public void setDataOggi(LocalDate dataOggi) {
		this.data = data;
	}

	public LocalDate data() {
		LocalDate inputDate = LocalDate.of(anno, mese, giorno);
		return inputDate;
	}

	public String dataStr() {
		return data().toString();
	}

	public boolean scadenza() throws Exception {
		if (data.isAfter(data())) {

			throw new Exception("Impossibile prenotare l'evento non esiste piu");
		} else {
			return true;
		}
	}

	public int prenota() throws Exception {

		if (postiPrenotati >= postiTotali) {
			throw new Exception("I posti sono esauriti");
		} else {
			return postiPrenotati = postiPrenotati + 1;
		}

	}

	public int disdici() throws Exception {
		if (postiPrenotati < 0) {

			throw new Exception("Non puoi disdire piu posti di quelli che possiedi");

		} else {
			return postiPrenotati = postiPrenotati - 1;
		}

	}

	@Override
	public String toString() {

		return "'evento: " + titolo + " giorno: " + data();
	}
}
