import java.util.Scanner;

public class E07_CosteGasolina {

	public static void main(String[] args) {
		double costeViaje;
		
		Scanner teclat = new Scanner(System.in);
		System.out.println("Introduce la distancia (Km): ");
		double distancia = teclat.nextDouble();
		
		Scanner teclat2 = new Scanner(System.in);
		System.out.println("Introduce el precio (€) del litro de gasolina: ");
		double precio = teclat2.nextDouble();
		
		Scanner teclat3 = new Scanner(System.in);
		System.out.println("Introduce el consumo del coche (l) cada 100 km: ");
		double consumo = teclat3.nextDouble();
		
		costeViaje = ((distancia/100) * precio * consumo);
		
		System.out.println("El coste del viaje en € será de: " +costeViaje);
		
		

	}

}
