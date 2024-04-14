package figuras.figuras3D;

import figuras.figuras2D.*;

public class PiramideBasePentagonal extends Piramide implements Figura {
	private Pentagon basePentagonal;

	public PiramideBasePentagonal(double altura, Pentagon basePentagonal) {
		super(altura);
		this.basePentagonal = basePentagonal;
	}

	public double calculaVolum() {
		return basePentagonal.calculaArea() * super.getAltura() / 3;
	}

	@Override
	public double calculaArea() {
		return basePentagonal.calculaArea();
	}

	@Override
	public double calculaPerimetre() {
		return basePentagonal.calculaPerimetre();
	}
}
