package thosicodina;

public abstract class Carrega extends AMotor{
	private int tara;
	private int pma;

	public Carrega(int id, String carnetNecesari, String geolocalizacio, double preuLloger, String matricula, String motor,
			int kilometres, int tara, int pma) {
		super(id, carnetNecesari, geolocalizacio, preuLloger, matricula, motor,
				kilometres);
		this.tara = tara;
		this.pma = pma;
	}

	public int getTara() {
		return tara;
	}

	public int getPma() {
		return pma;
	}

	public void setTara(int tara) {
		this.tara = tara;
	}

	public void setPma(int pma) {
		this.pma = pma;
	}
}
