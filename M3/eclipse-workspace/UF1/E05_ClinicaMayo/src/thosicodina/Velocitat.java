package thosicodina;

import java.time.LocalDate;

public class Velocitat extends Analitic {
	private double vsg;
	
	public Velocitat(Pacient pacient, Metge metge, LocalDate data, double vsg) {
		super(pacient, metge, data);
		this.vsg = vsg;
	}

	public double getVsg() {
		return vsg;
	}

	public void setVsg(double vsg) {
		this.vsg = vsg;
	}

	@Override
	public String toString() {
	    double maxVsg = super.getPacient().esHome() ? 15 : 20;
		return "VSG " + this.vsg + " mm/hora ( 0 - " + maxVsg + " )\n";
	}
}
