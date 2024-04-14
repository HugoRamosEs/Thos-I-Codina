import java.util.Scanner;

public class E01_TablaMultiplicar {

	public static void main(String[] args) {
		double tabla;
		
		Scanner teclat = new Scanner(System.in);
		System.out.println("Que tabla quieres ver (1-10)?: ");
		double numero = teclat.nextDouble();
		
		for (int i=0; i<numero; i++) {
			tabla = numero * i;
			System.out.println(" %numero * %i = %tabla");
		}

	}

}
