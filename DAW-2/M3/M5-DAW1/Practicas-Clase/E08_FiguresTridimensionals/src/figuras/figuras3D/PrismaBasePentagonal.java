package figuras.figuras3D;

import figuras.figuras2D.*;

public class PrismaBasePentagonal extends Prisma implements Figura {
	private Pentagon basePentagonal;

	public PrismaBasePentagonal(double altura, Pentagon basePentagonal) {
		super(altura);
		this.basePentagonal = basePentagonal;
	}

	public double calculaVolum() {
		return basePentagonal.calculaArea() * altura;
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
