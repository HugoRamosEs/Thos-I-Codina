import java.util.Scanner;

public class E01_Euro2Pts {

	public static void main(String[] args) {
		double cambio;
		double valorPesetas = 166.386;
		
		Scanner teclat = new Scanner(System.in);
		System.out.println("Introduce el valor en €: ");
		double euros = teclat.nextDouble();
		
		cambio = euros * valorPesetas;
		
		System.out.println("El cambio a pesetas es de: " +cambio);

	}

}
