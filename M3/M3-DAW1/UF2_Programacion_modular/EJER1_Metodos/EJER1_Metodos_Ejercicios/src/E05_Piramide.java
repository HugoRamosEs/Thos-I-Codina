/*
  
Programa que muestra una pirámide de la altura entrada por el usuario.
 
  
Utilizar métodos:
void dibujarPiramide(int altura, char car)
Dibuja la pirámide utilizando el carácter car.
 
void repetir(int vegades, char car)
Escribe las veces indicades el carácter car.
  
Salida del programa :
--------------------------------
Entra la altura : (1-10)
5
 
Entra el carácter para dibujar: *
    *
   ***
  *****
 *******
*********
  
*/

import java.util.Scanner;

public class E05_Piramide {
	
	E03_Hola utils = new E03_Hola();
	
	void alturaPiramide (int altura, char car) {
		for (int i=1; i<=altura; i++) {
			int espacio = altura-i;
			utils.repetir(espacio, ' ');
			utils.repetir((i*2)-1, car);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		E05_Piramide piramide = new E05_Piramide();
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce la altura (1-10): ");
		int altura = entrada.nextInt();
		
		System.out.println("Introduce el caracter: ");
		char car = entrada.next().charAt(0);
		
		piramide.alturaPiramide(10,car);
	}

}
