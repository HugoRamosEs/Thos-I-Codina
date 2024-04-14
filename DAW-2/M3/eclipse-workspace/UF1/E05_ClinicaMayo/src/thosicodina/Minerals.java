package thosicodina;

import java.time.LocalDate;

public class Minerals extends Bioquimic {
	private double calci;
	private double ferro;
	private double potassi;
	private double sodi;
	
	public Minerals(Pacient pacient, Metge metge, LocalDate data, double calci, double ferro, double potassi, double sodi) {
		super(pacient, metge, data);
		this.calci = calci;
		this.ferro = ferro;
		this.potassi = potassi;
		this.sodi = sodi;
	}

	public double getCalci() {
		return calci;
	}

	public double getFerro() {
		return ferro;
	}

	public double getPotassi() {
		return potassi;
	}

	public double getSodi() {
		return sodi;
	}

	public void setCalci(double calci) {
		this.calci = calci;
	}

	public void setFerro(double ferro) {
		this.ferro = ferro;
	}

	public void setPotassi(double potassi) {
		this.potassi = potassi;
	}

	public void setSodi(double sodi) {
		this.sodi = sodi;
	}

	@Override
	public String toString() {
		return "CALCI " + this.calci + " mg/dL ( 8.5 - 10.2 )\n"
				+ "FERRO " + this.ferro + " µg/dl ( 60 - 170 )\n"
				+ "POTASSI " + this.potassi + " mEq/L ( 3.7 - 5.2 )\n"
				+ "SODI " + this.sodi + " mEq/L ( 135 - 145 )\n";
	}
}
