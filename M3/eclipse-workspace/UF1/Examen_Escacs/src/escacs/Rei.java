package escacs;

public class Rei extends Peça {
	
	public Rei(Color color) {
		super(100, color);
	}

	@Override
	public String toString() {
		return "Rei =>" + super.toString();
	}
}
