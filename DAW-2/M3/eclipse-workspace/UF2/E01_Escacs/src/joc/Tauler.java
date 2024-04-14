package joc;

import peces.*;

public class Tauler {
	private Escac[][] escacs;

	public Tauler() {
		this.escacs = new Escac[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				this.escacs[i][j] = new SensePeca(
						(((i+j)%2)==0 ? Color.NEGRE : Color.BLANC )
						);
			}
		}
	}
	
	public void crearPartida() {
		this.addPeca(new Torre(Color.BLANC, new Posicio(0,0)), new Posicio(0,0));
		this.addPeca(new Torre(Color.BLANC, new Posicio(7,0)), new Posicio(7,0));
		this.addPeca(new Cavall(Color.BLANC, new Posicio(1,0)), new Posicio(1,0));
		this.addPeca(new Cavall(Color.BLANC, new Posicio(6,0)), new Posicio(6,0));
		this.addPeca(new Alfil(Color.BLANC, new Posicio(2,0)), new Posicio(2,0));
		this.addPeca(new Alfil(Color.BLANC, new Posicio(5,0)), new Posicio(5,0));
		this.addPeca(new Reina(Color.BLANC, new Posicio(3,0)), new Posicio(3,0));
		this.addPeca(new Rei(Color.BLANC, new Posicio(4,0)), new Posicio(4,0));
		
		for (int i=0; i<8; i++) {
			this.addPeca(new Peo(Color.BLANC, new Posicio(i,1)), new Posicio(i,1));
		}
		
		this.addPeca(new Torre(Color.NEGRE, new Posicio(0,7)), new Posicio(0,7));
		this.addPeca(new Torre(Color.NEGRE, new Posicio(7,7)), new Posicio(7,7));
		this.addPeca(new Cavall(Color.NEGRE, new Posicio(1,7)), new Posicio(1,7));
		this.addPeca(new Cavall(Color.NEGRE, new Posicio(6,7)), new Posicio(6,7));
		this.addPeca(new Alfil(Color.NEGRE, new Posicio(2,7)), new Posicio(2,7));
		this.addPeca(new Alfil(Color.NEGRE, new Posicio(5,7)), new Posicio(5,7));
		this.addPeca(new Reina(Color.NEGRE, new Posicio(3,7)), new Posicio(3,7));
		this.addPeca(new Rei(Color.NEGRE, new Posicio(4,7)), new Posicio(4,7));
		
		for (int i=0; i<8; i++) {
			this.addPeca(new Peo(Color.NEGRE, new Posicio(i,6)), new Posicio(i,6));
		}
	}
	
	public void addPeca (Peca e, Posicio p) {
		this.escacs[p.getX()][p.getY()] = new AmbPeca(e, this.escacs[p.getX()][p.getY()].getColor() );
	}
	
	public Peca mouPeca(Posicio posInicial, Posicio posFinal) {
		Peca mort = null;		
	
		if (this.escacs[posFinal.getX()][posFinal.getY()] instanceof AmbPeca) {
			mort = ((AmbPeca)this.escacs[posFinal.getX()][posFinal.getY()]).getPeca();
		} else {
			this.escacs[posFinal.getX()][posFinal.getY()] = new AmbPeca(null,this.escacs[posFinal.getX()][posFinal.getY()].getColor());
		}
		((AmbPeca)this.escacs[posFinal.getX()][posFinal.getY()]).setPeca(((AmbPeca)this.escacs[posInicial.getX()][posInicial.getY()]).getPeca());
		((AmbPeca)this.escacs[posFinal.getX()][posFinal.getY()]).getPeca().setPosicio(posFinal);
		this.escacs[posInicial.getX()][posInicial.getY()] = new SensePeca(this.escacs[posInicial.getX()][posInicial.getY()].getColor());
		return mort;
	}
	
	public boolean[][] pecesDelMateixEquip(Color col) {
		boolean[][] pecesDelMateixEquip = new boolean[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((this.escacs[i][j] instanceof AmbPeca) &&
					(((AmbPeca)this.escacs[i][j]).getPeca().isMateixEquip(col)))
					pecesDelMateixEquip[i][j] = true;
			}
		}
		return pecesDelMateixEquip;
	}
	
	public boolean[][] pecesEquipContrari(Color col) {
		boolean[][] pecesEquipContrari = new boolean[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((this.escacs[i][j] instanceof AmbPeca) &&
					!(((AmbPeca)this.escacs[i][j]).getPeca().isMateixEquip(col)))
					pecesEquipContrari[i][j] = true;
			}
		}
		return pecesEquipContrari;
	}
	
	public Escac[][] getCaselles() {
		return this.escacs;
	}
	
	public Peca getPeca(Posicio pos) {
		return (this.escacs[pos.getX()][pos.getY()] instanceof AmbPeca) ? 
				((AmbPeca)this.escacs[pos.getX()][pos.getY()]).getPeca() :
				null;
	}
	
	public void imprimirTauler() {
		for (int j = 7; j >= 0; j--) {
			System.out.print(j + " - ");
			for (int i = 0; i < 8; i++) {
				if (this.escacs[i][j] != null) {
					System.out.print("|(" + this.escacs[i][j].toString() + ")|");
				}
				
			}
			System.out.println("");
		}
		System.out.print("    ");
		for (int i = 0; i < 8; i++) {
			System.out.print("|  " + i + "  |");
		}
	}
	
	public void imprimirMateix(Color col) {
		boolean[][] peces = this.pecesDelMateixEquip(col);
		for (int j = 7; j >= 0; j--) {
			System.out.print(j + " - ");
			for (int i = 0; i < 8; i++) {
				if (this.escacs[i][j] != null) {
					String aux = (peces[i][j])?" * ":" O ";
					System.out.print("|(" + aux + ")|");
				}
				
			}
			System.out.println("");
		}
		System.out.print("    ");
		for (int i = 0; i < 8; i++) {
			System.out.print("|  " + i + "  |");
		}
	}
	public void imprimirContrari(Color col) {
		boolean[][] peces = this.pecesEquipContrari(col);
		for (int j = 7; j >= 0; j--) {
			System.out.print(j + " - ");
			for (int i = 0; i < 8; i++) {
				if (this.escacs[i][j] != null) {
					String aux = (peces[i][j])?" * ":" O ";
					System.out.print("|(" + aux + ")|");
				}
				
			}
			System.out.println("");
		}
		System.out.print("    ");
		for (int i = 0; i < 8; i++) {
			System.out.print("|  " + i + "  |");
		}
	}
}
