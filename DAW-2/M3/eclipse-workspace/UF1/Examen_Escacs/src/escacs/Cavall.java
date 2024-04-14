package escacs;

public class Cavall extends PeçaMenor {

	public Cavall(Color color) {
		super(8, color);
	}

	@Override
	public String toString() {
		return "Cavall =>" + super.toString();
	}
}
