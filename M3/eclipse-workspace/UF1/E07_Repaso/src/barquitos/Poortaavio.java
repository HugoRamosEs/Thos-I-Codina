package barquitos;

public class Poortaavio extends Nau {
	private static final long serialVersionUID = 1L;

	public Poortaavio(Coordenada coordenada, Direccio direccio) {
		super(coordenada, direccio, 5);
	}

	@Override
	public String toString() {
		return "Poortavio -> " + super.toString();
	}
}
