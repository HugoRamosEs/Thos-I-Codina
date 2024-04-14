package barquitos;

public class Cuirassat extends Nau {

	private static final long serialVersionUID = 1L;

	public Cuirassat(Coordenada coordenada, Direccio direccio) {
		super(coordenada, direccio, 4);
	}
	
	@Override
	public String toString() {
		return "Cuirassat -> " + super.toString();
	}
}
