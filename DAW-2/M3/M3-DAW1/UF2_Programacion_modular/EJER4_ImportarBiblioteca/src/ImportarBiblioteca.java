import java.util.Scanner;

import Calculs.*;

public class ImportarBiblioteca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+                       CLASE PUNTO                   +\n"
		+ "+-----------------------------------------------------+\n");
		
		Punto a = new Punto(5, 1.5);
		Punto b = new Punto(1, -2.1);
		Punto c = new Punto(7, 5.6);

		System.out.println("Punto a = " + a);
		System.out.printf("Punto b = %s\n", b);
		System.out.printf("Punto c = %s\n", c);

		System.out.println("La distancia entre los puntos a y b es: " + a.distancia(b));
		System.out.println("La distancia entre los puntos b y c es: " + b.distancia(c));
		
		System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+                       CLASE TIEMPO                  +\n"
		+ "+-----------------------------------------------------+\n");
		
		System.out.println("Introduce la hora inicial: ");
		Tiempo tInicial = new Tiempo(entrada.nextLine());
		
		System.out.println("Introduce la hora final: ");
		Tiempo tFinal = new Tiempo(entrada.nextLine());
		
		Tiempo resultado = tInicial.diferenciaT(tFinal);
		
		System.out.println("La diferencia es: " +resultado);
		
		System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+                       CLASE FECHA                   +\n"
		+ "+-----------------------------------------------------+\n");
		
		System.out.println("Entra la primera fecha dd/mm/aa: ");
		Fecha f1 = new Fecha(entrada.nextLine());
		
		System.out.println("Entra la segunda fecha dd/mm/aa: ");
		Fecha f2 = new Fecha(entrada.nextLine());
		
		System.out.println("La fecha menor es ");
			if(f1.esMenor(f2)) {
				System.out.println(f1);
			}
			
			if(f2.esMenor(f1)) {
				System.out.println(f1);
			}
			
			if(f2.esMenor(f1) == f1.esMenor(f2)) {
				System.out.print("ninguna. Son iguales");
			}	
	}
}

