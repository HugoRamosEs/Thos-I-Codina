package escacs;

import java.util.Arrays;

public class Tauler {
	private static final int X = 8;
	private static final int Y = 8;
	private Casella[][] caselles;
	private Peça[] pecesBlanques;
	private int numPecesBlanques;
	private Peça[] pecesNegres;
	private int numPecesNegres;

	public Tauler() {
		super();
		this.caselles = new Casella[Tauler.X][Tauler.Y];
		this.pecesBlanques = new Peça[16];
		this.numPecesBlanques = 0;
		this.pecesNegres = new Peça[16];
		this.numPecesNegres = 0;
	}
	
	public void addBlanques(Peça p) {
		if (this.numPecesBlanques == 16) {
			System.out.println("Limit máxim de peces exedit.");
		}
		
		if (p.getColor() == Color.BLANC) {
			this.pecesBlanques[this.numPecesBlanques] = p;
			this.numPecesBlanques++;
		}
	}
	
	public void addNegres(Peça p) {
		if (this.numPecesNegres == 16) {
			System.out.println("Limit máxim de peces exedit.");
		}
		
		if (p.getColor() == Color.NEGRE) {
			this.pecesNegres[this.numPecesNegres] = p;
			this.numPecesNegres++;
		}
	}
	
	public Casella[][] generarTauler() {
	for (int i=0; i<this.caselles.length; i++) {
		for (int j=0; j<this.caselles[i].length; j++) 
			this.caselles[i][j] = new Casella(Color.NEGRE, i, j);
		}
	
	for (int i=0; i<this.caselles.length; i = i+2) {
		for (int j=0; j<this.caselles[i].length; j = j+2) 
			this.caselles[i][j] = new Casella(Color.BLANC, i, j);
		}
	return this.caselles;
	}
	
	public void generarJoc() {
		Casella[][] tauler = generarTauler();
		for (int i=0; i<tauler.length; i++) {
			for (int j=0; j<tauler[i].length; j++) {
				if (tauler[i][j].getColor() == Color.BLANC) {
					for (int k=0; k<this.pecesBlanques.length; k++) {
						// tauler[i][j] = this.pecesBlanques[k];
					}
				}
			}
		}
	}

	public static int getX() {
		return X;
	}

	public static int getY() {
		return Y;
	}

	public Casella[][] getCaselles() {
		return caselles;
	}

	public Peça[] getPecesBlanques() {
		return pecesBlanques;
	}

	public int getNumPecesBlanques() {
		return numPecesBlanques;
	}

	public Peça[] getPecesNegres() {
		return pecesNegres;
	}

	public int getNumPecesNegres() {
		return numPecesNegres;
	}

	public void setCaselles(Casella[][] caselles) {
		this.caselles = caselles;
	}

	public void setPecesBlanques(Peça[] pecesBlanques) {
		this.pecesBlanques = pecesBlanques;
	}

	public void setNumPecesBlanques(int numPecesBlanques) {
		this.numPecesBlanques = numPecesBlanques;
	}

	public void setPecesNegres(Peça[] pecesNegres) {
		this.pecesNegres = pecesNegres;
	}

	public void setNumPecesNegres(int numPecesNegres) {
		this.numPecesNegres = numPecesNegres;
	}

	@Override
	public String toString() {
		return "Tauler [caselles=" + Arrays.toString(caselles) + ",\n pecesBlanques=" + Arrays.toString(pecesBlanques)
				+ ",\n  numPecesBlanques=" + numPecesBlanques + ",\n pecesNegres=" + Arrays.toString(pecesNegres)
				+ ",\n  numPecesNegres=" + numPecesNegres + "]";
	}
}
