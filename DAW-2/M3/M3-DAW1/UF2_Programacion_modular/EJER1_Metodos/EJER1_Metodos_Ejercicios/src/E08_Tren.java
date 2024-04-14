/*
 
Programa para resolver el típico problema de fisica sobre un tren que
viaja a velocidad constante de la estación A a la estación B separadas
una distancia D y tarda un tiempo T.
 
Las 3 variables D,T,V estan relacionadas por la formula D = V * T.
 
El programa primero debe mostrar un menú para preguntar cual es la variable
desconocida, luego preguntar los datos necesarios para calcularla y mostrar
el resultado.
 
El resultado debe obtenerse llamando a un método que recibe los datos
conocidos y devuelve como valor de retorno el valor de la incógnita.
 
Deben validarse las entradas no numéricas.
 
Salida del programa
====================================
 
Variables del problema:
-----------------------
1.Distancia
2.Tiempo
3.Velocidad
4.Salir
 
Elige la incognita : 8
Valor incorrecto.
 
Elige la incognita : 2
 
Entra la distancia D (km) :100
Entra la velocidad V (km/h):50
 
El tiempo es : 2.00 horas
 
......
 
*/

import java.io.*;
import java.util.Scanner;

public class E08_Tren {
	
	public int menu() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Variables del problema:\n"
				+ "-----------------------\n"
				+ "1.Distancia\n"
				+ "2.Tiempo\n"
				+ "3.Velocidad\n"
				+ "4.Salir\n"
				+ "-----------------------\n"
				+ "Elige la incognita: ");
		int incognita = entrada.nextInt();
		return incognita;
	}
	
	public double mru() {
		Scanner entrada = new Scanner(System.in);
		double resultado = 0;
		int incognita = menu();
		if (incognita==1) {
			double distancia = 0;
			System.out.println("Entra la velocidad V (km/h): ");
			double velocidad = entrada.nextDouble();
			System.out.println("Entra el tiempo T (h): ");
			double tiempo = entrada.nextDouble();
			distancia = velocidad * tiempo;
			resultado = distancia;
		}else if (incognita==2) {
			double tiempo = 0;
			System.out.println("Entra la distancia D (km): ");
			double distancia = entrada.nextDouble();
			System.out.println("Entra la velocidad V (km/h): ");
			double velocidad = entrada.nextDouble();
			tiempo = distancia / velocidad;
			resultado = tiempo;
		}else if (incognita==3) {
			double velocidad = 0;
			System.out.println("Entra la distancia D (km): ");
			double distancia = entrada.nextDouble();
			System.out.println("Entra el tiempo T (h): ");
			double tiempo = entrada.nextDouble();
			velocidad = distancia / tiempo;
			resultado = velocidad;
		}else if (incognita==4) {
			System.out.println("Programa finalizado");
		}
		return resultado;
	}
	
	public double validarEntrada(Scanner numero) {
		while(!numero.hasNextDouble()) {
			System.out.println("Entrada no numerica, intentalo de nuevo: ");
			numero.next();
		}
		return numero.nextDouble();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E08_Tren programa = new E08_Tren();
		System.out.println();
		
		programa.menu();
		double resultado = programa.mru();
		System.out.printf("El resultado es : %.2f\n",resultado);
	}

}
