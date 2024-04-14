package thosicodina;

import java.time.LocalDate;

public class Volum extends Analitic {
	private double vcm;
	private double hcm;
	
	public Volum(Pacient pacient, Metge metge, LocalDate data, double vcm, double hcm) {
		super(pacient, metge, data);
		this.vcm = vcm;
		this.hcm = hcm;
	}

	public double getVcm() {
		return vcm;
	}

	public double getHcm() {
		return hcm;
	}

	public void setVcm(double vcm) {
		this.vcm = vcm;
	}

	public void setHcm(double hcm) {
		this.hcm = hcm;
	}

	@Override
	public String toString() {
		return "VCM " + this.vcm + " fl ( 80 - 100 )\n"
				+ "HCM " + this.hcm + " pg ( 23 - 31 )\n";
	}
}
