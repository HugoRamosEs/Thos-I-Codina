package thosicodina;

public abstract class NoCarrega extends AMotor{

	public NoCarrega(int id, String carnetNecesari, String geolocalizacio, double preuLloger,
			String matricula, String motor, int kilometres) {
		super(id, carnetNecesari, geolocalizacio, preuLloger, matricula, motor,
				kilometres);
	}
}
