
public class Tauler {
	private Vaixell vaixells[];
	private int numVaixells;
	
	public Tauler() {
		super();
		this.vaixells = new Vaixell[12];
		this.numVaixells = 0;
	}

	public void addVaixell(Vaixell v) {
		if (numVaixells < 12) {
			this.vaixells[this.numVaixells] = v;
			this.numVaixells++;
		}
	}
	
	protected Object clone() throws CloneNotSupportedException {
		Tauler cp = new Tauler();
		cp.setVaixells(this.vaixells.clone());
		cp.setNumVaixells(this.numVaixells);
		return cp;
	}

	public Vaixell[] getVaixells() {
		return vaixells;
	}
	public int getNumVaixells() {
		return numVaixells;
	}
	public void setVaixells(Vaixell[] vaixells) {
		this.vaixells = vaixells;
	}
	public void setNumVaixells(int numVaixells) {
		this.numVaixells = numVaixells;
	}
}
