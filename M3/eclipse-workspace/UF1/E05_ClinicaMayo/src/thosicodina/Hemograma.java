package thosicodina;

import java.time.LocalDate;

public class Hemograma {
	private Pacient pacient;
	private Metge metge;
	private LocalDate data;
	
	public Hemograma(Pacient pacient, Metge metge, LocalDate data) {
		this.pacient = pacient;
		this.metge = metge;
		this.data = data;
	}

	public Pacient getPacient() {
		return pacient;
	}

	public Metge getMetge() {
		return metge;
	}

	public LocalDate getData() {
		return data;
	}

	public void setPacient(Pacient pacient) {
		this.pacient = pacient;
	}

	public void setMetge(Metge metge) {
		this.metge = metge;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return 	  "+-----------------------------------------------------+\n"
				+ "+                      HEMOGRAMA                      +\n"
				+ "+-----------------------------------------------------+\n"
				+ this.pacient
				+ this.metge
				+ "Data: " + this.data + "\n";
	}
}
