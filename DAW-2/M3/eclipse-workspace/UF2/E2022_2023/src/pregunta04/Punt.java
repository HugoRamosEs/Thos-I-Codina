package pregunta04;

import java.awt.Color;
import java.awt.Point;

public class Punt extends Point {
	private Color color;

	public Punt(Color c) {
		super();
		this.color = c;
	}

	public Punt(Color c, int x, int y) {
		super(x, y);
		this.color = c;
	}

	public Punt(Color c, Point p) {
		super(p);
		this.color = c;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Punt [color=" + color + ", x=" + x + ", y=" + y + "]";
	}
}
