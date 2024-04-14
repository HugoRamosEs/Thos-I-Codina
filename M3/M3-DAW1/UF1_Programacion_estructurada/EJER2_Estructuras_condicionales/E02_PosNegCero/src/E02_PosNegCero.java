import java.util.Scanner;

public class E02_PosNegCero {

	public static void main(String[] args) {
		
		Scanner teclat = new Scanner(System.in);
		System.out.println("Introduce un numero: ");
		double numero = teclat.nextDouble();
		
		if(numero>0) {
			System.out.println("El numero es mayor que 0: " +numero);
		}
		
		if(numero==0) {
			System.out.println("El numero es 0");
		}
		
		if(numero<0) {
			System.out.println("El numero es menor que 0: " +numero);
		}

	}

}
