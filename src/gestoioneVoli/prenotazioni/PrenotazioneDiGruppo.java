package gestoioneVoli.prenotazioni;

import java.util.Set;

public class PrenotazioneDiGruppo extends Prenotazione {

	private Set<String> membri_del_gruppo;
	
	public PrenotazioneDiGruppo(String id, Set<String> membri_del_gruppo, float costo) throws IDAssignedException {
		super(id, costo);
		this.membri_del_gruppo=membri_del_gruppo;
	}
	
	/**
	 * @return the costo
	 */
	@Override
	public float getCosto() {
		
		float prezzo_biglietto=super.getCosto();
		float sconto=0;
		if(this.membri_del_gruppo.size()<=10) {
			sconto=(float) 0.1;
		}
		else {
			sconto=(float) 0.2;
		}
		float prezzo=prezzo_biglietto*this.membri_del_gruppo.size()*sconto;
		return prezzo;
	}

}
