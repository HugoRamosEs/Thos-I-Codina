package escacs;

public class Peo extends Peça {

	public Peo(Color color) {
		super(1, color);
	}

	@Override
	public String toString() {
		return "Peo =>" + super.toString();
	}
}
