package figuras.figuras3D;

public abstract class Piramide extends Figuras3D {
	protected double altura;

	public Piramide(double altura) {
		this.altura = altura;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
}
