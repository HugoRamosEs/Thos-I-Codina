package thosicodina;

public class Ocupacio {
	private Soci soci;
	private Vehicle vehicle;
	
	public Ocupacio(Soci soci, Vehicle vehicle) {
		super();
		this.soci = soci;
		this.vehicle = vehicle;
	}

	public Soci getSoci() {
		return soci;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setSoci(Soci soci) {
		this.soci = soci;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
