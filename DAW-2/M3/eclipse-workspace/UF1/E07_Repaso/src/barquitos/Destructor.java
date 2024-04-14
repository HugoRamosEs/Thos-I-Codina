package barquitos;

public class Destructor extends Nau {

	private static final long serialVersionUID = 1L;

	public Destructor(Coordenada coordenada, Direccio direccio) {
		super(coordenada, direccio, 3);
	}
	
	@Override
	public String toString() {
		return "Destructor -> " + super.toString();
	}
}
