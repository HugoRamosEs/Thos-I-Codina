
public class GestorArxiu {
	private Arxiu arxius [];
	private Arxiu contenidor [];
	private int numArxius;
	
	public GestorArxiu() {
		super();
		this.arxius = new Arxiu [10];
		this.setContenidor(new Arxiu [5]);
		this.numArxius = 0;
	}
	
	public Object clone() {
		GestorArxiu cp = new GestorArxiu();
		cp.setArxius(this.arxius.clone());
		return cp;
	}

	public Arxiu[] getArxius() {
		return arxius;
	}

	public void setArxius(Arxiu[] arxius) {
		this.arxius = arxius;
	}

	public int getNumArxius() {
		return numArxius;
	}

	public void setNumArxius(int numArxius) {
		this.numArxius = numArxius;
	}

	public Arxiu[] getContenidor() {
		return contenidor;
	}

	public void setContenidor(Arxiu contenidor[]) {
		this.contenidor = contenidor;
	}
	
}
