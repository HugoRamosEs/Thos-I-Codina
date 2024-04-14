package brisca;

import java.util.Arrays;
import java.util.Collections;

public class Baralla {
	private Carta[] cartes;

	public Baralla(int numeroDeCartes) throws Exception {
		if (numeroDeCartes!= 48 && numeroDeCartes!=40 && numeroDeCartes!= 36) {
			throw new Exception("numero de cartes incorrecte");
		}
		
		// Creo el contenidor de cartes
		this.cartes = new Carta[numeroDeCartes];
		
		// Creo les cartes
		int posicioArrai = 0;
		for (int i=1; i<=12; i++) {
			if ((numeroDeCartes==40) && (i==8)) {
			} else if ((numeroDeCartes==40) && (i==9)) {
			} else if ((numeroDeCartes==36) && (i==8) ) {
			} else if ((numeroDeCartes==36) && (i==9)) {
			} else if ((numeroDeCartes==36) && (i==2)) {
			} else {
				Bastos basto = new Bastos(i);
				this.cartes[posicioArrai++] = basto;
				
				Copas copa = new Copas(i);
				this.cartes[posicioArrai++] = copa;
				
				Espadas espada = new Espadas(i);
				this.cartes[posicioArrai++] = espada;
				
				Oros oro = new Oros(i);
				this.cartes[posicioArrai++] = oro;
			}
			
		}
		
	}
	
	public void barreja() {
		Collections.shuffle(Arrays.asList(this.cartes));
	}
	
	
	
}
