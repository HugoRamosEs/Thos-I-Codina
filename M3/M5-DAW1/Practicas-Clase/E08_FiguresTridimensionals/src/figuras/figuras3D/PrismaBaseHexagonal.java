package figuras.figuras3D;

import figuras.figuras2D.*;

public class PrismaBaseHexagonal extends Prisma implements Figura {
	private PoligonRegular baseHexagonal;

	public PrismaBaseHexagonal(double altura, PoligonRegular baseHexagonal) {
		super(altura);
		this.baseHexagonal = baseHexagonal;
	}

	public double calculaVolum() {
		return baseHexagonal.calculaArea() * altura;
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
