package gestoioneVoli;

import gestoioneVoli.prenotazioni.IDAssignedException;

public class Main {

	public static void main(String[] args) {
		GestorePrenotazioneVoli gestore = new GestorePrenotazioneVoli();
		gestore.readVoliFromFile("voli.csv");
		gestore.stampa();

		gestore.aggiungiVolo(500, "CAT", "BAR", "2023/06/24", 120);
		gestore.aggiungiVolo(5, "CAT", "OLB", "2023/06/23", 60);

		try {
			gestore.aggiungiVolo(3, "CAT", "ROM", "2023/06/23", 60);
		} catch (Exception e) {
			System.out.println("Eccezione ID gia presente");
		}
		gestore.stampa();
		
		try {
			gestore.readPrenotazioniFromFile("prenotazioni.csv");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IDAssignedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		gestore.stampa();
		
		gestore.stampaPrenotazioniOrdinatePerAlfabetico();
		gestore.stampaPrenotazioniOrdinatePerCosto();
		
	}

}
