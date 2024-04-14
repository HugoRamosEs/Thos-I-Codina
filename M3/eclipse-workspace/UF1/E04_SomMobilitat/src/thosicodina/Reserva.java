package thosicodina;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reserva {
	private Ocupacio ocupacio;
	private LocalDate dataInicialReserva;
	private LocalDate dataFinalReserva;
	
	public Reserva(Ocupacio ocupacio, LocalDate dataInicialReserva, LocalDate dataFinalReserva) {
		super();
		this.ocupacio = ocupacio;
		this.dataInicialReserva = dataInicialReserva;
		this.dataFinalReserva = dataFinalReserva;
	}
	
	public boolean dataSuperior() {
		if (this.dataInicialReserva.isAfter(dataFinalReserva)) {
			return true;
		}else {
			return false;
		}
	}

	public Ocupacio getOcupacio() {
		return ocupacio;
	}

	public LocalDate getDataInicialReserva() {
		return dataInicialReserva;
	}

	public LocalDate getDataFinalReserva() {
		return dataFinalReserva;
	}

	public void setOcupacio(Ocupacio ocupacio) {
		this.ocupacio = ocupacio;
	}

	public void setDataInicialReserva(LocalDate dataInicialReserva) {
		this.dataInicialReserva = dataInicialReserva;
	}

	public void setDataFinalReserva(LocalDate dataFinalReserva) {
		this.dataFinalReserva = dataFinalReserva;
	}
}
