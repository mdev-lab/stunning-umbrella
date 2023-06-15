package gestoioneVoli;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import gestoioneVoli.prenotazioni.IDAssignedException;
import gestoioneVoli.prenotazioni.PrenotazioneIndividuale;
import gestoioneVoli.prenotazioni.TIPOLOGIA_POSTO;
import gestoioneVoli.volo.Volo;

public class GestorePrenotazioneVoli {
	
	private Set<Volo> voli;
	
	public GestorePrenotazioneVoli() {
		this.voli=new HashSet<>();
	}
	
	private Volo getVolo(int id) {
		for(Volo v: voli) {
			if(v.getId()==id) {
				return v;
			}
		}
		return null;
	}
	
	public void aggiungiVolo(int id,String origine, String destinazione, String data, 
			int max_passengers) {
		this.voli.add(new Volo(id, origine, destinazione, new Date(data), max_passengers));
	}
	
	public void readPrenotazioniFromFile(String filePath) throws NumberFormatException, IDAssignedException {
		try {
			Scanner sc=new Scanner(new File(filePath));
			
			while(sc.hasNext()) {
				String line=sc.nextLine();
				String[] campi=line.split(",");
				
				if(campi[0].equals("I")) {
					
					
					PrenotazioneIndividuale prenotazione=new PrenotazioneIndividuale(
							campi[1],
							campi[3],
							Float.parseFloat(campi[4]),
							TIPOLOGIA_POSTO.valueOf(campi[5]));
					
					int id_volo=Integer.parseInt(campi[2]);
					
					Volo v=this.getVolo(id_volo);
					
					v.addPrenotazione(prenotazione);
							
					
				}else {
					if(campi[0].equals("G")) {
						
					}else {
						throw new IllegalArgumentException("Formato non corretto");
					}
					
				
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void readVoliFromFile(String filePath) {
		
		try {
			Scanner sc=new Scanner(new File(filePath));
			
			while(sc.hasNext()) {
				String line=sc.nextLine();
				String[] campi=line.split(",");
				
				this.aggiungiVolo(Integer.parseInt(campi[0]), campi[1], campi[2], campi[3], 
						Integer.parseInt(campi[4]));

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void stampa() {
		for(Volo v: voli) {
			System.out.println(v.toString());
		}
	}
	
	public void stampaPrenotazioniOrdinatePerCosto() {
		for(Volo v: voli) {
			System.out.println("Volo:"+ v.getId());
			v.stampaPrenotazioniOrdinatePerCosto();
		}
	}
	public void stampaPrenotazioniOrdinatePerAlfabetico() {
		for(Volo v: voli) {
			System.out.println("Volo:"+ v.getId());
			v.stampaPrenotazioniOrdinatePerAlfabetico();
		}
	}
}
