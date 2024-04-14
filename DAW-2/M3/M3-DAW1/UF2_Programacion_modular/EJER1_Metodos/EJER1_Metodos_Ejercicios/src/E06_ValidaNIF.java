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

import java.io.*;
import java.util.Scanner;

public class E06_ValidaNIF {

	String leerNIF() {
		Scanner entrada = new Scanner(System.in);
		String NIF;
		do {
			System.out.println("Entra el NIF: ");
			NIF = entrada.next();
		} while (NIF.length() != 9);
		return NIF;
	}

	boolean esValido(String nif) {
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

	/**
	 * Calcula la letra que le corresponde a un número de NIF
	 * 
	 * @param numNIF número del que queremos la letra
	 * @return la letra calculada
	 */
	public char letraNIF(int numNIF) {
		String codigo = "TRWAGMYFPDXBNJZSQVHLCKE";
		int pos = numNIF % 23;
		return codigo.charAt(pos);
	}

}