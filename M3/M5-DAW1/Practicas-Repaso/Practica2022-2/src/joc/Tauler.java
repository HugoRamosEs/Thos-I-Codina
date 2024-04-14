package joc;

import java.util.Arrays;

public class Tauler implements Cloneable {
	private Vaixell vaixells[];
	private int numVaixells;
	
	public Tauler() {
		super();
		this.vaixells = new Vaixell[5];
		this.numVaixells = 0;
	}
	
	public void addVaixell (Vaixell toAdd) {
		if (numVaixells < 5) {
			this.vaixells[this.numVaixells] = toAdd;
			this.numVaixells++;
		}
	}
	
	public Vaixell removeVaixell () {
		Vaixell esborrat = null;
		if (numVaixells > 0) {
			esborrat = this.vaixells[this.numVaixells - 1] = null;
			this.numVaixells--;
		}
		return esborrat;
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
	
	@Override
	public Object clone() {
		Tauler cp = new Tauler();
		cp.setVaixells(this.vaixells.clone());
		cp.setNumVaixells(this.numVaixells);
		return cp;
	}
	
	@Override
	public String toString() {
		return "Tauler [vaixells=" + Arrays.toString(this.vaixells) + ", numVaixells=" + this.numVaixells + "]";
	}
}
