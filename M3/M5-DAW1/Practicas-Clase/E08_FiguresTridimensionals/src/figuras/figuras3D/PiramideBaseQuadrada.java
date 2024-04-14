package figuras.figuras3D;

import figuras.figuras2D.*;

public class PiramideBaseQuadrada extends Piramide implements Figura {
	private Quadrat baseQuadrada;

	public PiramideBaseQuadrada(double altura, Quadrat baseQuadrada) {
		super(altura);
		this.baseQuadrada = baseQuadrada;
	}

	public double calculaVolum() {
		return baseQuadrada.calculaArea() * super.getAltura() / 3;
	}

	@Override
	public double calculaArea() {
		return baseQuadrada.calculaArea();
	}

	@Override
	public double calculaPerimetre() {
		return baseQuadrada.calculaPerimetre();
	}
}
