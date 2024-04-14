package thosicodina;

import java.time.LocalDate;

public class Trombocits extends Recompte {
	private double plaquetes;
	
	public Trombocits(Pacient pacient, Metge metge, LocalDate data, double plaquetes) {
		super(pacient, metge, data);
		this.plaquetes = plaquetes;
	}

	public double getPlaquetes() {
		return plaquetes;
	}

	public void setPlaquetes(double plaquetes) {
		this.plaquetes = plaquetes;
	}

	@Override
	public String toString() {
		return "PLAQUETES " + this.plaquetes + " µL ( 150000 - 400000 )\n";
	}
}
