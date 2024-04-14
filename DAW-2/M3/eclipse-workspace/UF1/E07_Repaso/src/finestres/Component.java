package finestres;

import java.awt.Point;

public abstract class Component implements Cloneable, Drawable {
	private double width;
	private double height;
	private Point posicio;
	
	public Component(double width, double height, Point posicio) {
		super();
		this.width = width;
		this.height = height;
		this.posicio = posicio;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public Point getPosicio() {
		return posicio;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setPosicio(Point posicio) {
		this.posicio = posicio;
	}

	@Override
	public String toString() {
		return "[" + this.width + ", " + this.height + "] at [" + this.posicio.getX() + ", " + this.posicio.getY() + "]";
	}
}
