package figuras.figuras3D;

import figuras.figuras2D.*;

public class PrismaBaseTriangular extends Prisma implements Figura {
	private Rectangle baseTriangular;

	public PrismaBaseTriangular(double altura, Rectangle baseTriangular) {
		super(altura);
		this.baseTriangular = baseTriangular;
	}

	public double calculaVolum() {
		return baseTriangular.calculaArea() * altura;
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
