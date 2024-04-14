import java.awt.Point;

public class Component implements IDrawable {
	// ATRIBUTS
	private int width;
	private int height;
	private Point position;
	
	// CONSTRUCTORS
	public Component(int width, int height, Point position) {
		super();
		this.width = width;
		this.height = height;
		this.position = position;
	}
	
	// GETTERS I SETTERS
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Point getPosition() {
		return position;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
	
	// OVERRIDES
	@Override
	public String toString() {
		return "[" + this.width + ", " + this.height + "] at [" + this.position.getX() + ", " + this.position.getY() + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return new Component (this.width, this.height, (Point)this.position.clone());
	}
}

	