package escacs;

public class Reina extends PeçaMajor {

	public Reina(Color color) {
		super(15, color);
	}

	@Override
	public String toString() {
		return "Reina =>" + super.toString();
	}
}
