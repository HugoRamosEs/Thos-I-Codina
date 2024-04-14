import java.util.Scanner;

public class E19_Areas {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("CALCULO DE AREAS: (a. Cuadrado) (b. Triangulo) (c. Circulo) Escoge una opcion: ");
		char caracter = entrada.next().charAt(0);
		
		if (caracter == 'a') {
			Scanner entrada2 = new Scanner(System.in);
			System.out.println("Introduce el valor de la base: ");
			int base = entrada2.nextInt();
			
			Scanner entrada3 = new Scanner(System.in);
			System.out.println("Introduce el valor de la altura: ");
			int altura = entrada3.nextInt();
			
			int areacuadrado = base * altura;
			
			System.out.println("El resultado del area es: " +areacuadrado);
		}
		
		if (caracter == 'b') {
			Scanner entrada4 = new Scanner(System.in);
			System.out.println("Introduce el valor de la base: ");
			int base = entrada4.nextInt();
			
			Scanner entrada5 = new Scanner(System.in);
			System.out.println("Introduce el valor de la altura: ");
			int altura = entrada5.nextInt();
			
			int areatriangulo = (base * altura) / 2;
			
			System.out.println("El resultado del area es: " +areatriangulo);
		}
		
		if (caracter == 'c') {
			Scanner entrada6 = new Scanner(System.in);
			System.out.println("Introduce el valor del radio: ");
			int radio = entrada6.nextInt();
			
			double areacirculo = Math.PI * Math.pow(radio,2);
			
			System.out.println("El resultado del area es: " +areacirculo);
		}

	}

}
