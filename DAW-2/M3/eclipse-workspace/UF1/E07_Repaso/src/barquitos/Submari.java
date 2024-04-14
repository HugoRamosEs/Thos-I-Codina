package barquitos;

public class Submari extends Nau {

	private static final long serialVersionUID = 1L;

	public Submari(Coordenada coordenada, Direccio direccio) {
		super(coordenada, direccio, 1);
	}
	
	@Override
	public String toString() {
		return "Submari -> " + super.toString();
	}
}
