package figuras.figuras3D;

public abstract class Figuras3D {
	public abstract double calculaVolum();

	public double calculaPes(double densitat) {
		return calculaVolum() * densitat;
	}
}
