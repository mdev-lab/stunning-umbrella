package gestoioneVoli.prenotazioni;

import java.util.HashSet;
import java.util.Set;

public abstract class Prenotazione {
	
	private static Set<String> ID_ASSEGNATI=new HashSet<>();
	private final String id;
	private final float costo;
	
	public Prenotazione(String id, float costo) throws IDAssignedException {
		if(ID_ASSEGNATI.contains(id)) {
			throw new IDAssignedException();
		}
		this.id=id;
		this.costo=costo;
		ID_ASSEGNATI.add(id);
	}
	
	/**
	 * @return the costo
	 */
	public float getCosto() {
		return costo;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	


}
