import java.util.Scanner;

public class E01_EsMayorCero {

	public static void main(String[] args) {
		
		Scanner teclat = new Scanner(System.in);
		System.out.println("Introduce un numero: ");
		double numero = teclat.nextDouble();
		
		if(numero>0) {
			System.out.println("El numero es mayor que 0: " +numero);
		}
		else {
			System.out.println("El numero es menor que 0: " +numero);
		}

	}

}
