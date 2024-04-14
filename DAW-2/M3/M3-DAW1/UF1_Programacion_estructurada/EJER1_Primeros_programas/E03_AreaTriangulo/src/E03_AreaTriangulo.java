import java.util.Scanner;

public class E03_AreaTriangulo {

	public static void main(String[] args) {
		double areaTriangulo;
		
		Scanner teclat = new Scanner(System.in);
		System.out.println("Introduce el valor de la base: ");
		double base = teclat.nextDouble();
		
		Scanner teclat2 = new Scanner(System.in);
		System.out.println("Introduce el valor de la altura: ");
		double altura = teclat2.nextDouble();
		
		areaTriangulo = (base*altura) / 2;
		
		System.out.println("El area del triangulo es: " +areaTriangulo);

	}

}
