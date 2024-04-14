package thosicodina;

import java.time.LocalDate;

public class Eritrocits extends Recompte {
	private double hematies;
	private double hematocrit;
	private double hemoglobina;
	
	public Eritrocits(Pacient pacient, Metge metge, LocalDate data, double hematies, double hematocrit, double hemoglobina) {
		super(pacient, metge, data);
		this.hematies = hematies;
		this.hematocrit = hematocrit;
		this.hemoglobina = hemoglobina;
	}
	public double getHematies() {
		return hematies;
	}

	public double getHematocrit() {
		return hematocrit;
	}

	public double getHemoglobina() {
		return hemoglobina;
	}

	public void setHematies(double hematies) {
		this.hematies = hematies;
	}

	public void setHematocrit(double hematocrit) {
		this.hematocrit = hematocrit;
	}

	public void setHemoglobina(double hemoglobina) {
		this.hemoglobina = hemoglobina;
	}

	@Override
	public String toString() {
		double minHematies = super.getPacient().esHome() ? 4.5 : 4.1;
		double maxHematies = super.getPacient().esHome() ? 5.9 : 5.1;
		double minHematocrit = super.getPacient().esHome() ? 38.3 : 35.5;
		double maxHematocrit = super.getPacient().esHome() ? 48.6 : 44.9;
		double minHemoglobina = super.getPacient().esHome() ? 13.2 : 11.6;
		double maxHemoglobina = super.getPacient().esHome() ? 16.6 : 15;
		
		return "HEMATIES " + this.hematies + " 10E12/L ( " + minHematies + " - " + maxHematies + " )\n"
				+ "HEMATÒCRIT " + this.hematocrit + " % ( " + minHematocrit + " - " + maxHematocrit + " )\n"
				+ "HEMOGLOBINA " + this.hemoglobina + " g/dL ( " + minHemoglobina + " - " + maxHemoglobina + " )\n";
	}
}
