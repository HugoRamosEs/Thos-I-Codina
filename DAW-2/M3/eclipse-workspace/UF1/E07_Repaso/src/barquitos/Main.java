package barquitos;

public class Main {

	public static void main(String[] args) {
		Tauler jugador1 = new Tauler();
		Poortaavio p = new Poortaavio(new Coordenada(2,5), Direccio.NORD);
		Cuirassat c = new Cuirassat(new Coordenada(3,3), Direccio.OEST);
		Destructor d = new Destructor(new Coordenada(1,8), Direccio.OEST);
		Fragata f = new Fragata(new Coordenada(9,7), Direccio.SUD);
		Submari s = new Submari(new Coordenada(10,3), Direccio.NORD);
		
		jugador1.add(p);
		jugador1.add(c);
		jugador1.add(d);
		jugador1.add(f);
		jugador1.add(s);
		
		Tauler jugador2 = (Tauler) jugador1.clone();
		
		System.out.println(jugador1.toString());
		System.out.println("----------------------------------");
		System.out.println(jugador2.toString());

	}
}
