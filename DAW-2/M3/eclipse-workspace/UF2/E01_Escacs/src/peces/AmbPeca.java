package peces;

import joc.Color;

public class AmbPeca extends Escac {
	private Peca peca;
	
	public AmbPeca(Peca p, Color c) {
		super(c);
		this.peca = p;
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	@Override
	public String toString() {
		return super.toString() + this.peca.toString();
	}
	
	
}
