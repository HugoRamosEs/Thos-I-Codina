import java.util.Scanner;

public class E04_Ordena3 {

	public static void main(String[] args) {
		
		Scanner teclat = new Scanner(System.in);
		System.out.println("Introduce el primer valor: ");
		double a = teclat.nextDouble();
		
		Scanner teclat2 = new Scanner(System.in);
		System.out.println("Introduce el segundo valor: ");
		double b = teclat2.nextDouble();
		
		Scanner teclat3 = new Scanner(System.in);
		System.out.println("Introduce el tercer valor: ");
		double c = teclat3.nextDouble();
		
		if (a>b) {
			double intercambio = a;
			a=b;
			b=intercambio;
		}
		
		if(a>c) {
			double intercambio2 = a;
			a=c;
			c=intercambio2;
			}
		
		if(b>c) {
			double intercambio3 = b;
			b=c;
			c=intercambio3;
		}

		System.out.printf("Los valores ordenados son %f %f %f ",a,b,c);
	}

}
