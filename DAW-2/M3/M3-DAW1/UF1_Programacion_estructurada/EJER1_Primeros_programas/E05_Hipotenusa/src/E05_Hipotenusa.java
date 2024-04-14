import java.util.Scanner;

public class E05_Hipotenusa {

	public static void main(String[] args) {
		double hipotenusa;
		
		Scanner teclat = new Scanner(System.in);
		System.out.println("Introduce el valor del primer cateto: ");
		double cateto1 = teclat.nextDouble();
		
		Scanner teclat2 = new Scanner(System.in);
		System.out.println("Introduce el valor del segundo cateto: ");
		double cateto2 = teclat2.nextDouble();
		
		hipotenusa = Math.sqrt((cateto1*cateto1)+(cateto2*cateto2));
		
		System.out.println("El valor de la hipotenusa sera de: " +hipotenusa);

	}

}
