package gestoioneVoli.prenotazioni.comparators;

import java.util.Comparator;

import gestoioneVoli.prenotazioni.Prenotazione;

public class AlfabeticComparator implements Comparator<Prenotazione> {

	@Override
	public int compare(Prenotazione o1, Prenotazione o2) {
		return o1.getId().compareTo(o2.getId());
	}

}
