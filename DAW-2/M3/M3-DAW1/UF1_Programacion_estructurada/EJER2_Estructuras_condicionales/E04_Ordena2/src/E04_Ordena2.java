import java.util.Scanner;

public class E04_Ordena2 {

	public static void main(String[] args) {
		
		Scanner teclat = new Scanner(System.in);
		System.out.println("Introduce el primer valor: ");
		double a = teclat.nextDouble();
		
		Scanner teclat2 = new Scanner(System.in);
		System.out.println("Introduce el segundo valor: ");
		double b = teclat2.nextDouble();
		
		if (a>b){
			double intercambio = a;
			a=b;
			b=intercambio;
		}
		
		System.out.printf("Los valores ordenados son %f %f ",a,b);

	}
}
