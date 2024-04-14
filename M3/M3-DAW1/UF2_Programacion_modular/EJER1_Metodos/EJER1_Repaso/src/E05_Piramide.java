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
import java.io.*;

public class E05_Piramide {
	
	void repetir (int num, char c) {
		for (int i=0; i<num; i++) {
			System.out.println(c);
		}
	}
	
	void dibujarPiramide(int altura, char c) {
		 int esp = altura-1;
	     int ast = 1;      
		for (int i=0; i<altura; i++) {
			repetir(esp, ' ');
			repetir(ast, c);
            System.out.println();
            esp--;      //en la siguiente línea hay un espacio inicial menos
            ast += 2;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
