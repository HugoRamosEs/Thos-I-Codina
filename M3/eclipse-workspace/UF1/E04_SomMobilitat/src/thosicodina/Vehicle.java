package thosicodina;

public abstract class Vehicle {
	private int id;
	private String carnetNecesari;
	private String geolocalizacio;
	private double preuLloger;
	private boolean ocupacio;
	private Ocupacio registreOcupacio[];
	
	public Vehicle(int id, String carnetNecesari, String geolocalizacio, double preuLloger) {
		super();
		this.id = id;
		this.carnetNecesari = carnetNecesari;
		this.geolocalizacio = geolocalizacio;
		this.preuLloger = preuLloger;
		this.ocupacio = false;
		this.registreOcupacio = new Ocupacio[0];
	}
	
	public void afegirOcupacio (Ocupacio o) {
		Ocupacio[] tmp = new Ocupacio[this.registreOcupacio.length + 1];
		for (int i=0; i<this.registreOcupacio.length; i++) {
			tmp[i] = this.registreOcupacio[i];
		}
		tmp[this.registreOcupacio.length] = o;
		this.registreOcupacio = tmp;
	}

	public int getId() {
		return id;
	}

	public String getCarnetNecesari() {
		return carnetNecesari;
	}

	public String getGeolocalizacio() {
		return geolocalizacio;
	}

	public double getPreuLloger() {
		return preuLloger;
	}

	public boolean isOcupacio() {
		return ocupacio;
	}

	public Ocupacio[] getRegistreOcupacio() {
		return registreOcupacio;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCarnetNecesari(String carnetNecesari) {
		this.carnetNecesari = carnetNecesari;
	}

	public void setGeolocalizacio(String geolocalizacio) {
		this.geolocalizacio = geolocalizacio;
	}

	public void setPreuLloger(double preuLloger) {
		this.preuLloger = preuLloger;
	}

	public void setOcupacio(boolean ocupacio) {
		this.ocupacio = ocupacio;
	}

	public void setRegistreOcupacio(Ocupacio[] registreOcupacio) {
		this.registreOcupacio = registreOcupacio;
	}
}
