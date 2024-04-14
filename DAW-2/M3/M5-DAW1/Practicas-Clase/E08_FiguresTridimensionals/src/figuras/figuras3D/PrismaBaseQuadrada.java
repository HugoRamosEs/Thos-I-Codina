package figuras.figuras3D;

import figuras.figuras2D.*;

public class PrismaBaseQuadrada extends Prisma implements Figura {
	private Quadrat baseQuadrada;

	public PrismaBaseQuadrada(double altura, Quadrat baseQuadrada) {
		super(altura);
		this.baseQuadrada = baseQuadrada;
	}

	public double calculaVolum() {
		return baseQuadrada.calculaArea() * altura;
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
