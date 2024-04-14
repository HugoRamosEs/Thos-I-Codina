package figuras.figuras3D;

public abstract class Prisma extends Figuras3D {
	protected double altura;
	
	public Prisma(double altura) {
		this.altura = altura;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
}
