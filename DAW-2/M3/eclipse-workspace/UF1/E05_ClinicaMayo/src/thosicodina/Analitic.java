package thosicodina;

import java.time.LocalDate;

public class Analitic extends Hemograma {

	public Analitic(Pacient pacient, Metge metge, LocalDate data) {
		super(pacient, metge, data);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString()
				+ "+-----------------------------------------------------+\n"
        		+ "+                      ANALITIC                       +\n"
        		+ "+-----------------------------------------------------+\n";
	}
}
