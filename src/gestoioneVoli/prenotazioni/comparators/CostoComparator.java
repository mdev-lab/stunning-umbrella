package gestoioneVoli.prenotazioni.comparators;

import java.util.Comparator;

import gestoioneVoli.prenotazioni.Prenotazione;

public class CostoComparator implements Comparator<Prenotazione> {

	@Override
	public int compare(Prenotazione o1, Prenotazione o2) {
		if(o1.getCosto()>o2.getCosto()) {
			return 1;
		}
		else {
			if(o1.getCosto()==o2.getCosto()) {
				return 0;
			}
			return -1;
		}
	}

}
