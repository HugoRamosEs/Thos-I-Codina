package figuras.figuras3D;

import figuras.figuras2D.*;

public class PiramideBaseTriangular extends Piramide implements Figura {
	private Rectangle baseTriangular;

	public PiramideBaseTriangular(double altura, Rectangle baseTriangular) {
		super(altura);
		this.baseTriangular = baseTriangular;
	}

	public double calculaVolum() {
		return baseTriangular.calculaArea() * super.getAltura() / 3;
	}

	@Override
	public double calculaArea() {
		return baseTriangular.calculaArea() / 2;
	}

	@Override
	public double calculaPerimetre() {
		return baseTriangular.calculaPerimetre();
	}
}
