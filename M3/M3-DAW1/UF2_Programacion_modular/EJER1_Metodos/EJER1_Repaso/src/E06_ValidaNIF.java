/*
  
Programa que lee y valida un NIF.
  
Un NIF se considera válido si tiene los 8 dígitos y la letra de la última
posición es la que le corresponde a la parte numérica.
Se proporciona un método que calcula la letra correcta para un número dado.
  
Será necesario separar la parte númerica de la letra. Puede hacerse así:
  
String nif = "12345678A";
int numNIF = Integer.parseInt( nif.substring(0,8) );
char letra = nif.charAt(8);
  
*/

import java.util.Scanner;
import java.io.*;

public class E06_ValidaNIF {

	public String leerNIF() {
		String dato;
		Scanner entrada = new Scanner(System.in);
		do {
			System.out.println("Entra el NIF: ");
			dato = entrada.next();
		} while (dato.length() != 9);
		return dato;
	}

	public char letraNIF(int numNIF) {
		String codigo = "TRWAGMYFPDXBNJZSQVHLCKE";
		int pos = numNIF % 23;
		return codigo.charAt(pos);
	}

	public boolean esValido(String nif) {
		try {
			int numNIF = Integer.parseInt(nif.substring(0, 8));
			char letra = nif.charAt(8);
			if (Character.toUpperCase(letra) != letraNIF(numNIF)) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String args[]) throws Exception {

		E06_ValidaNIF programa = new E06_ValidaNIF();
		String nif;
		do {
			nif = programa.leerNIF();
			if (!programa.esValido(nif)) {
				System.out.println("Incorrecto");
			} else {
				break;
			}
		} while (true);
		System.out.println("El nif entrado es " + nif);
	}
}
