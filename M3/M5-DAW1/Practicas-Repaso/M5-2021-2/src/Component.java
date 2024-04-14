import java.awt.Point;

public class Component implements Drawable{
	private int width;
	private int height;
	private Point position;

	public Component(int width, int height, Point position) {
		super();
		this.width = width;
		this.height = height;
		this.position = position;
	}
	
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

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "[" +this.width+ ", " +this.height + "] at [" +this.position.x+ ", " +this.position.y+ "]";
	}
	
	
}
