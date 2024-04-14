package thosicodina;

import java.time.LocalDate;

public class Leucocits extends Recompte {
	private double leucocits;
	private double limfocits;
	private double neutrofils;
	private double eosinofils;
	
	public Leucocits(Pacient pacient, Metge metge, LocalDate data, double leucocits, double limfocits, double neutrofils, double eosinofils) {
		super(pacient, metge, data);
		this.leucocits = leucocits;
		this.limfocits = limfocits;
		this.neutrofils = neutrofils;
		this.eosinofils = eosinofils;
	}

	public double getLeucocits() {
		return leucocits;
	}

	public double getLimfocits() {
		return limfocits;
	}

	public double getNeutrofils() {
		return neutrofils;
	}

	public double getEosinofils() {
		return eosinofils;
	}

	public void setLeucocits(double leucocits) {
		this.leucocits = leucocits;
	}

	public void setLimfocits(double limfocits) {
		this.limfocits = limfocits;
	}

	public void setNeutrofils(double neutrofils) {
		this.neutrofils = neutrofils;
	}

	public void setEosinofils(double eosinofils) {
		this.eosinofils = eosinofils;
	}

	@Override
	public String toString() {
		return "LEUCOCITS " + this.leucocits + " µL ( 4500 - 11000 )\n"
				+ "LIMFOCITS " + this.limfocits + " µL ( 1000 - 4800 )\n"
				+ "NEUTRÒFILS " + this.neutrofils + " cèl·lules/µL ( 2000 - 7500 )\n"
				+ "EOSINÒFILS " + this.neutrofils + " cèl·lules/µL ( 40 - 450 )\n";
	}
}
