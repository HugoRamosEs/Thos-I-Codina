import java.util.Scanner;

public class E02_Aritmetica {

	public static void main(String[] args) {
		double suma;
		double resta;
		double multiplicacion;
		double division;
		
		Scanner teclat = new Scanner(System.in);
		System.out.println("Introduce el primer valor: ");
		double primerValor = teclat.nextDouble();
		
		Scanner teclat2 = new Scanner(System.in);
		System.out.println("Introduce el segundo valor: ");
		double segundoValor = teclat2.nextDouble();
		
		suma = primerValor + segundoValor;
		resta = primerValor - segundoValor;
		multiplicacion = primerValor * segundoValor;
		division = primerValor / segundoValor;
		
		System.out.println("La suma es: "+suma);
		System.out.println("La resta es: "+resta);
		System.out.println("La multiplicacion es: "+multiplicacion);
		System.out.println("La division es: "+division);

	}

}
