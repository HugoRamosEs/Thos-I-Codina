package barquitos;

public class Fragata extends Nau {

	private static final long serialVersionUID = 1L;

	public Fragata(Coordenada coordenada, Direccio direccio) {
		super(coordenada, direccio, 2);
	}
	
	@Override
	public String toString() {
		return "Fragata -> " + super.toString();
	}
}
