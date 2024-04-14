package figuras.figuras3D;

import figuras.figuras2D.*;

public class PiramideBaseHexagonal extends Piramide implements Figura {
	private PoligonRegular baseHexagonal;

	public PiramideBaseHexagonal(double altura, PoligonRegular baseHexagonal) {
		super(altura);
		this.baseHexagonal = baseHexagonal;
	}

	public double calculaVolum() {
		return baseHexagonal.calculaArea() * super.getAltura() / 3;
	}

	@Override
	public double calculaArea() {
		return baseHexagonal.calculaArea();
	}

	@Override
	public double calculaPerimetre() {
		return baseHexagonal.calculaPerimetre();
	}
}
