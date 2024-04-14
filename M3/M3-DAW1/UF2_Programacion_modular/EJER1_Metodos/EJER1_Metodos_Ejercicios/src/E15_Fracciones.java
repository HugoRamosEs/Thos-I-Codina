import java.io.IOException;
import java.util.Scanner;

class fraccion {
	int numerador;
	int denominador;

	fraccion() {

	}

	fraccion(int n, int d) {
		numerador = n;
		denominador = d;
	}

	fraccion(String fraccio) {
		String partes[] = fraccio.split("/");
		numerador = Integer.parseInt(partes[0]);
		denominador = Integer.parseInt(partes[1]);
	}

	static fraccion suma(fraccion f1, fraccion f2) {
		fraccion suma = new fraccion();
		suma.denominador = f1.denominador * f2.denominador;
		suma.numerador = f1.numerador * f2.denominador + f2.denominador * f1.numerador;
		suma.simplificaFraccion();
		return suma;
	}

	static fraccion resta(fraccion f1, fraccion f2) {
		fraccion resta = new fraccion();
		resta.denominador = f1.denominador * f2.denominador;
		resta.numerador = f1.numerador * f2.denominador - f2.denominador * f1.numerador;
		resta.simplificaFraccion();
		return resta;
	}

	static fraccion multiplicacio(fraccion f1, fraccion f2) {
		fraccion multiplicacio = new fraccion();
		multiplicacio.denominador = f1.denominador * f2.denominador;
		multiplicacio.numerador = f2.numerador * f2.numerador;
		multiplicacio.simplificaFraccion();
		return multiplicacio;
	}

	static fraccion divisio(fraccion f1, fraccion f2) {
		fraccion divisio = new fraccion();
		divisio.denominador = f1.denominador * f2.numerador;
		divisio.numerador = f1.numerador * f2.denominador;
		divisio.simplificaFraccion();
		return divisio;
	}

	void simplificaFraccion() {
		int a = numerador;
		int b = denominador;

		while (b > 0) {

			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}

		numerador = numerador / a;
		denominador = denominador / a;
	}

	public String toString() {
		return (numerador + " / " + denominador);
	}
}

public class E15_Fracciones {

	fraccion llegirFrac(String frase) {
		fraccion f = null;
		Scanner entrada = new Scanner(System.in);
		boolean correcto = false;
		do {
			try {
				System.out.println(frase);
				String valor = entrada.nextLine();
				f = new fraccion(valor);
				correcto = true;

			} catch (Exception e) {
				System.out.println("Valor incorrecto");
			}
		} while (!correcto);
		return f;
	}

	int menuOp() throws NumberFormatException, IOException {
		int op = E01_EsPrimo.leerEntero("Operaciones:\n" + "-----------------------\n" + "1.Suma\n" + "2.Resta\n"
				+ "3.Multiplicación\n" + "4.División\n" + "-----------------------\n" + "Elige entre: ", 1, 4);
		return op;
	}

	public static void main(String[] args) throws Exception {
		E15_Fracciones programa = new E15_Fracciones();
		fraccion f1 = programa.llegirFrac("Entra la primera fraccion:");
		fraccion f2 = programa.llegirFrac("Entra la segunda fraccion:");
		int operacio = programa.menuOp();
		fraccion fr = null;
		switch (operacio) {
		case 1:
			fr = fraccion.suma(f1, f2);
			break;
		case 2:
			fr = fraccion.resta(f2, f1);
			break;
		case 3:
			fr = fraccion.multiplicacio(f2, f1);
			break;
		case 4:
			fr = fraccion.divisio(f2, f1);
			break;
		}

		System.out.println("El resultat es: " + fr);
	}
}
