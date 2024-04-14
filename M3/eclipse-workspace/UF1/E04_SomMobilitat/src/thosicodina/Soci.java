package thosicodina;

public class Soci {
	private String nom;
	private String cognom;
	private String dni;
	private String tipusCarnet;

	public Soci(String nom, String cognom, String dni, String tipusCarnet) {
		super();
		this.nom = nom;
		this.cognom = cognom;
		this.dni = dni;
		this.tipusCarnet = tipusCarnet;
	}
	
	public void alquilarVehicle(AMotor vehicle, Reserva reserva, Ocupacio ocupacio) {
	    if (this.tipusCarnet.equals(vehicle.getCarnetNecesari())) {
	        if (vehicle.isOcupacio() == false && reserva.dataSuperior()) {
	            vehicle.setOcupacio(true);
	            vehicle.afegirReserva(reserva);
	            vehicle.afegirOcupacio(ocupacio);
	            System.out.println("Vehicle alquilat per: " + this.nom + " " + this.cognom);
	        } else {
	            System.out.println("El vehicle no está disponible per alquilar.");
	        }
	    } else {
	        System.out.println("El soci no dispon del tipus de carnet necesari per alquilar aquest vehicle.");
	    }
	}

	public String getNom() {
		return nom;
	}

	public String getCognom() {
		return cognom;
	}

	public String getDni() {
		return dni;
	}

	public String getTipusCarnet() {
		return tipusCarnet;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setTipusCarnet(String tipusCarnet) {
		this.tipusCarnet = tipusCarnet;
	}
}
