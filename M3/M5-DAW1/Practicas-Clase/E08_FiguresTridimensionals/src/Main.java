import figuras.figuras2D.*;
import figuras.figuras3D.*;

/* Què modificaries si ens demanessin que cada element simple podria tenir una densitat específica?
 * 
 * Afegiria un atribut de "densitat" a la clase pare Figuras3D i afegiria un constructor que asignes la quantitat del parametre a l'atribut
 * (this.densitat = densitat), a més modificaria el metode de calculaPes per tal de no rebre un parametre "densitat" (que es com esta fet
 * originalment). Posteriorment a les clases filles de Piramide, Esfera i Prisma, afegiria en el constructor un parametre de densitat que
 * trucaria al pare amb l'instrucció super(densitat). Per últim a les clases filles faria el mateix, en el constructor afegiria un parametre
 * "densitat" que faria una trucada a la classe superior per l'altura i també a la classe Figuras3D per agafar el valor de la densitat
 * super(altura, densitat). Amb tot això, cada element podria tenir una densitat especifica, i el metode calculaPes de Figuras3D tindrá en
 * compte la densitat especifica per calcular el seu pes.
 * 
 */


public class Main {

	public static void main(String[] args) throws Exception {
		// BASES
		PoligonRegular baseHexagonal = new PoligonRegular(6, 4);
		Pentagon basePentagonal = new Pentagon(4);
		Quadrat baseQuadrada = new Quadrat(3);
		Rectangle baseTriangular = new Rectangle(2, 3);

		// PIRAMIDES
		PiramideBaseHexagonal piramideBaseHexagonal = new PiramideBaseHexagonal(10, baseHexagonal);
		PiramideBasePentagonal piramideBasePentagonal = new PiramideBasePentagonal(5, basePentagonal);
		PiramideBaseQuadrada piramideBaseQuadrada = new PiramideBaseQuadrada(4.3, baseQuadrada);
		PiramideBaseTriangular piramideBaseTriangular = new PiramideBaseTriangular(6, baseTriangular);

		// PRISMES
		PrismaBaseHexagonal prismaBaseHexagonal = new PrismaBaseHexagonal(7, baseHexagonal);
		PrismaBasePentagonal prismaBasePentagonal = new PrismaBasePentagonal(8.2, basePentagonal);
		PrismaBaseQuadrada prismaBaseQuadrada = new PrismaBaseQuadrada(9.5, baseQuadrada);
		PrismaBaseTriangular prismaBaseTriangular = new PrismaBaseTriangular(2.6, baseTriangular);

		// ESFERA
		Esfera esfera = new Esfera(5);

		// MOSTRAR RESULTATS
		Figuras3D[] figures3D = new Figuras3D[9];
		figures3D[0] = piramideBaseHexagonal;
		figures3D[1] = piramideBasePentagonal;
		figures3D[2] = piramideBaseQuadrada;
		figures3D[3] = piramideBaseTriangular;
		figures3D[4] = prismaBaseHexagonal;
		figures3D[5] = prismaBasePentagonal;
		figures3D[6] = prismaBaseQuadrada;
		figures3D[7] = prismaBaseTriangular;
		figures3D[8] = esfera;

		double volum = 0;
		double pes = 0;
		double densitat = 1.2;

		for (int i = 0; i < figures3D.length; i++) {
			volum = figures3D[i].calculaVolum();
			pes = figures3D[i].calculaPes(densitat);
			System.out.println(figures3D[i].getClass().getSimpleName() + ":");
			System.out.println("Volum: " + String.format("%.2f", volum));
			System.out.println("Pes: " + String.format("%.2f", pes));
			System.out.println();
		}

		System.out.println("------------------------------------------------");
		System.out.println();

		double volumTotal = 0;
		double pesTotal = 0;

		for (int i = 0; i < figures3D.length; i++) {
			volumTotal = volumTotal + figures3D[i].calculaVolum();
			pesTotal = pesTotal + figures3D[i].calculaPes(densitat);
		}
		System.out.println("Volum Total: " + String.format("%.2f", volumTotal));
		System.out.println("Pes Total: " + String.format("%.2f", pesTotal));
	}
}
