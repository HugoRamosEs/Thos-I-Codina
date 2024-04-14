package figuras.figuras3D;

public class Esfera extends Figuras3D {
	private double radi;

	public Esfera(double radi) {
		this.radi = radi;
	}

	public double calculaVolum() {
		return (4 / 3) * Math.PI * Math.pow(radi, 3);
	}
}
