package cat.iesthosicodina;

public class Carta {
	public static final String[] noms = {"","As","Dos","Tres","Quatre","Cinc","Sis", "Set", "Buit","Nou", "Deu", "Jack","Queen", "King"};
	public static final int[] valors = {0,1,2,3,4,5,6,7,8,9,10,10,10,10};
	public static final String[] pals = {"","Cors","Piques","Diamants","Trébols"};
	
	public static final int COR=1;
	public static final int PICA=2;
	public static final int DIAMANT=3;
	public static final int TREBOL=4;
	
	private int numero;
	private int pal;
	private boolean vista;
	
	public Carta(int numero, int pal) {
		this.numero = numero;
		this.pal = pal;
		this.vista = false;
	}
	
	public Carta girar() {
		this.vista = !this.vista;
		return this;
	}
	public int getNumero() {
		return this.numero;
	}

	public int getPal() {
		return this.pal;
	}
	
	public boolean getVista() {
		return this.vista;
	}

	public int valor() {
		return Carta.valors[this.numero];
		
	}
	@Override
	public String toString() {		
		return Carta.noms[this.numero] + " de " + Carta.pals[this.pal] + "[" + vista + "]";
	}
}
