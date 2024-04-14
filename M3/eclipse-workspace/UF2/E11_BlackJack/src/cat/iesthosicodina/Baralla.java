package cat.iesthosicodina;

import java.util.Collections;
import java.util.Stack;

public class Baralla {
	private Stack<Carta> cartes;
	
	public Baralla() {
		this.cartes = new Stack<Carta>();
		
		for (int i=1; i<14; i++) {
			for (int j=1; j<5; j++ ) {
				Carta nova = new Carta (i,j);
				this.cartes.push(nova);
			}
		}
		Collections.shuffle(this.cartes);
	}
	
	public Carta get( ) {
		return this.cartes.pop();
	}
	
}
