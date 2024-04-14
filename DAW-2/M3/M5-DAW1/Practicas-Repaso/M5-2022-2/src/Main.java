 
public class Main {
	public static void main(String[] args) throws CloneNotSupportedException {
		Tauler jugador1 = new Tauler();
		
		Cuirassat cuirassat = new Cuirassat(new Coordenada(), 4);
		jugador1.addVaixell(null);
		
		Tauler jugador2 = (Tauler) jugador1.clone();
		
		
		
	}
}
