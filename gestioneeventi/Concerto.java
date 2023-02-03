package com.lesson.gestioneeventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento {
	private BigDecimal prezzo;
	private LocalTime ora;

	public Concerto(String titolo, int giorno, int mese, int anno, LocalDate dataOggi, int postiTotali,
			int postiPrenotati, String prezzo, int ora, int minuti) throws Exception {

		super(titolo, giorno, mese, anno, dataOggi, postiTotali, postiPrenotati);

		setPrezzo(prezzo);
		setOra(ora, minuti);

	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(String prezzo) {
		this.prezzo = new BigDecimal(prezzo);
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(int ora, int minuti) {
		LocalTime orario = LocalTime.of(ora, minuti);
	}

	@Override
	public String toString() {
		return "nome concerto: " + getTitolo() + "Orario: " + getOra() + "Costo: " + getPrezzo() + "€";
	}
}
