package thosicodina;

public abstract class AMotor extends Vehicle{
	private Reserva registreReserves[];
	private String matricula;
	private String motor;
	private int kilometres;
	
	public AMotor(int id, String carnetNecesari, String geolocalizacio, double preuLloger, String matricula, String motor, int kilometres) {
		super(id, carnetNecesari, geolocalizacio, preuLloger);
		this.registreReserves = new Reserva[0];
		this.matricula = matricula;
		this.motor = motor;
		this.kilometres = kilometres;
	}
	
	public void afegirReserva (Reserva r) {
		Reserva[] tmp = new Reserva[this.registreReserves.length + 1];
		for (int i=0; i<this.registreReserves.length; i++) {
			tmp[i] = this.registreReserves[i];
		}
		tmp[this.registreReserves.length] = r;
		this.registreReserves = tmp;
	}
	
	public void eliminarReserva () {
		Reserva[] tmp = new Reserva[this.registreReserves.length - 1];
		for (int i=0; i<this.registreReserves.length - 1; i++) {
			tmp[i] = this.registreReserves[i];
		}
		this.registreReserves = tmp;
	}

	public Reserva[] getRegistreReserves() {
		return registreReserves;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getMotor() {
		return motor;
	}

	public int getKilometres() {
		return kilometres;
	}

	public void setRegistreReserves(Reserva[] registreReserves) {
		this.registreReserves = registreReserves;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public void setKilometres(int kilometres) {
		this.kilometres = kilometres;
	}
}
