package gestoioneVoli.volo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import gestoioneVoli.prenotazioni.Prenotazione;
import gestoioneVoli.prenotazioni.comparators.AlfabeticComparator;
import gestoioneVoli.prenotazioni.comparators.CostoComparator;

public class Volo {

	private static int ID_COUNT = 0;
	private static Set<Integer> ASSIGNED_ID = new HashSet<>();

	private final int id;
	private final String origine;
	private final String destinazione;
	private final Date data;
	private final int max_passengers;
	private List<Prenotazione> prenotazioni;

	public void stampaPrenotazioniOrdinatePerCosto() {
		Collections.sort(prenotazioni, new CostoComparator());
		this.stampa();

	}
	private void stampa() {
		for (Prenotazione p : prenotazioni) {
			System.out.println(p);
		}
	}

	public void stampaPrenotazioniOrdinatePerAlfabetico() {
		Collections.sort(prenotazioni, new AlfabeticComparator());
		this.stampa();
	}

	public Volo(String origine, String destinazione, Date data, int max_passengers) {
		this(ID_COUNT, origine, destinazione, data, max_passengers);
	}

	public Volo(int id, String origine, String destinazione, Date data, int max_passengers) {
		if (ASSIGNED_ID.contains(id)) {
			throw new IllegalArgumentException("ID gia preso");
		}
		ID_COUNT = Math.max(ID_COUNT, id) + 1;
		this.id = id;
		ASSIGNED_ID.add(id);
		this.origine = origine;
		this.destinazione = destinazione;
		this.data = data;
		this.max_passengers = max_passengers;
		this.prenotazioni = new ArrayList<Prenotazione>();
	}

	public void addPrenotazione(Prenotazione p) {
		this.prenotazioni.add(p);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the origine
	 */
	public String getOrigine() {
		return origine;
	}

	/**
	 * @return the destinazione
	 */
	public String getDestinazione() {
		return destinazione;
	}

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @return the max_passengers
	 */
	public int getMax_passengers() {
		return max_passengers;
	}

	@Override
	public String toString() {
		return "Volo [id=" + id + ", origine=" + origine + ", destinazione=" + destinazione + ", data=" + data
				+ ", max_passengers=" + max_passengers + ", prenotazioni=" + prenotazioni + "]";
	}

}
