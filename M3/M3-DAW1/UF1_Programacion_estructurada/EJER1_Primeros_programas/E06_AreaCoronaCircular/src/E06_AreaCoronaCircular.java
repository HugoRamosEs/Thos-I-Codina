import java.util.Scanner;

public class E06_AreaCoronaCircular {

	public static void main(String[] args) {
		double areaCoronaCircular;
		
		Scanner teclat = new Scanner(System.in);
		System.out.println("Introduce el valor del radio menor: ");
		double radioMenor = teclat.nextDouble();
		
		Scanner teclat2 = new Scanner(System.in);
		System.out.println("Introduce el valor del radio mayor: ");
		double radioMayor = teclat2.nextDouble();
		
		areaCoronaCircular = Math.PI * ((radioMayor * radioMayor)-(radioMenor*radioMenor));
		
		System.out.println("El valor del area es: " +areaCoronaCircular);

	}

}
