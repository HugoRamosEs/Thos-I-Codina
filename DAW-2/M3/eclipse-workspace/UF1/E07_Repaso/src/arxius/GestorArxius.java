package arxius;

import java.util.Arrays;

public class GestorArxius {
	private Arxiu[] arxius;
	private static final int TAM = 10;
	private int num;
	private Reproduible[] contenidor;
	
	public GestorArxius() {
		super();
		this.arxius = new Arxiu[GestorArxius.TAM];
		this.contenidor = new Reproduible[5];
		this.num = 0;
	}
	
	public void add(Arxiu a) {
		if (this.num == GestorArxius.TAM) {
			System.out.println("Tamany màxim excedit.");
		}
		
		if (a != null) {
			this.arxius[this.num] = a;
			this.num++;
		}
	}
	
	public void addReproduible(Reproduible r) {
		if (this.num == GestorArxius.TAM) {
			System.out.println("Tamany màxim excedit.");
		}
		
		if (r != null) {
			this.contenidor[this.num] = r;
			this.num++;
		}
	}
	
	public void remove() {
		if (this.num < 0) {
			System.out.println("Tamany mínim excedit.");
		}
		
		this.arxius[this.arxius.length - 1] = null;
		this.num--;
	}
	
	public Object clone() {
		GestorArxius g = new GestorArxius();
		g.setArxius(this.arxius.clone());
		return g;
	}

	public Arxiu[] getArxius() {
		return arxius;
	}

	public static int getTam() {
		return TAM;
	}

	public int getNum() {
		return num;
	}

	public Reproduible[] getContenidor() {
		return contenidor;
	}

	public void setArxius(Arxiu[] arxius) {
		this.arxius = arxius;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setContenidor(Reproduible[] contenidor) {
		this.contenidor = contenidor;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("GestorArxius: [");

	    for (int i = 0; i < num; i++) {
	        if (arxius[i] != null) {
	            sb.append(arxius[i]);
	            if (i < num - 1) {
	                sb.append(", ");
	            }
	        }
	    }

	    sb.append("]");
	    return sb.toString();
	}
}
