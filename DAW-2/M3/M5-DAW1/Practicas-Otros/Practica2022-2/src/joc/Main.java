package joc;

public class Main {
	public static void main(String[] args) throws CloneNotSupportedException {
		Tauler jugador1 = new Tauler();
		
		jugador1.addVaixell (new Portaavions());
		for (int i=1; i<2; i++) jugador1.addVaixell(new Cuirassat());
		for (int i=1; i<3; i++) jugador1.addVaixell(new Destructor());
		for (int i=1; i<3; i++) jugador1.addVaixell(new Fragata());
		for (int i=1; i<4; i++) jugador1.addVaixell(new Submari());
		
		Tauler jugador2 = (Tauler) jugador1.clone();
		
		System.out.println(jugador1);
		System.out.println(jugador2);
		
		jugador1.removeVaixell();
		System.out.println(jugador1);
	}
}
