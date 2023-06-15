package gestoioneVoli.prenotazioni;

public class PrenotazioneIndividuale extends Prenotazione {

	private final String client_ID;
	
	private final TIPOLOGIA_POSTO preferenza_posto;
	
	public PrenotazioneIndividuale(String id, String client_ID, float costo, 
			TIPOLOGIA_POSTO preferenza_posto) throws IDAssignedException {
		super(id, costo);
		this.client_ID=client_ID;
		this.preferenza_posto=preferenza_posto;
	}

	/**
	 * @return the client_ID
	 */
	public String getClient_ID() {
		return client_ID;
	}

	
	/**
	 * @return the preferenza_posto
	 */
	public TIPOLOGIA_POSTO getPreferenza_posto() {
		return preferenza_posto;
	}

	@Override
	public String toString() {
		return "PrenotazioneIndividuale [client_ID=" + client_ID  + ", preferenza_posto="
				+ preferenza_posto + "]";
	}
}
