/*
 
Programa que lee dos enteros entre 1 y 10 y muestra un gráfico de barras
indicando la cantidad de divisores de cada número que está entre estos dos.
 
Implementar los métodos que faltan
 
Salida del programa:
------------------------
Entra dos numeros : 4 10
 
 4|***
 5|**
 6|****
 7|**
 8|****
 9|***
10|****
  +------------------->
 
 */

import java.util.Scanner;

public class E11_Divisores {
	
	E03_Hola utils = new E03_Hola();
	
	public int[] leerRango() {
		Scanner entrada = new Scanner(System.in);
		int numeros[] = new int[2];
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Introduce un numero: ");
			numeros[i] = entrada.nextInt();
		}
		return numeros;
	}

	public void repetir(int n, char c) {
		for (int i = 0; i < n; i++) {
			System.out.print(c);
		}
	}

	public int numDivisores(int i) {
		int contador = 0;
		for (int j=1; j<=i;j++) {
			if (i%j == 0) {
                contador++;
            }
		}
		
		return contador;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E11_Divisores programa = new E11_Divisores();
		int[] rango = programa.leerRango();
		for (int i = rango[0]; i <= rango[1]; i++) {

			System.out.printf("%2d|", i);
			programa.repetir(programa.numDivisores(i), '*');
			System.out.println();
		}
		System.out.println("  +------------------->");
	}
}
