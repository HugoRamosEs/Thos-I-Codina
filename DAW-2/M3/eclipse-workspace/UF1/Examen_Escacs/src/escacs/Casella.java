package escacs;

public class Casella {
	private Color color;
	private int x;
	private int y;
	
	public Casella(Color color, int x, int y) {
		super();
		this.color = color;
		this.x = x;
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Casella [" + this.color + ", posicio=(" + this.x + ", " + this.y + ")]";
	}
}
