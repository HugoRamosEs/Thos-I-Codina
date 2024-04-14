package escacs;

public class Torre extends PeçaMajor {

	public Torre(Color color) {
		super(10, color);
	}

	@Override
	public String toString() {
		return "Torre =>" + super.toString();
	}
}
