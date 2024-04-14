package thosicodina;

import java.time.LocalDate;

public class Bioquimic extends Hemograma {

	public Bioquimic(Pacient pacient, Metge metge, LocalDate data) {
		super(pacient, metge, data);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return super.toString() 
				+ "+-----------------------------------------------------+\n"
				+ "+                      BIOQUIMIC                      +\n"
				+ "+-----------------------------------------------------+\n";
	}
}
