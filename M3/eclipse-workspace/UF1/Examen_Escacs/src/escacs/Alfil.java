package escacs;

public class Alfil extends PeçaMenor {

	public Alfil(Color color) {
		super(5, color);
	}

	@Override
	public String toString() {
		return "Alfil =>" + super.toString();
	}
}
