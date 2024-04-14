package barquitos;

import java.util.Arrays;

public class Tauler {
	private Nau[] naus;
	private int num;

	public Tauler() {
		super();
		this.naus = new Nau[12];
	}
	
	public void add(Nau n) {
		if (this.num == 12) {
			System.out.println("Limit màxim exedit.");
		}
		
		this.naus[this.num] = n;
		this.num++;
	}
	
	public Object clone() {
		Tauler t = new Tauler();
		t.setNaus(this.naus.clone());
		t.setNum(this.num); // creo que no hace falta esto
		return t;
	}

	public Nau[] getNaus() {
		return naus;
	}

	public int getNum() {
		return num;
	}

	public void setNaus(Nau[] naus) {
		this.naus = naus;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("NAUS\n");
		for (int i=0; i<this.naus.length; i++) {
			if (this.naus[i] != null) {
				sb.append(this.naus[i]);
				sb.append("\n");
			}
		}
		return sb.toString();
	}
}
