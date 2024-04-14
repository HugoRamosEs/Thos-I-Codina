/*
 
Escribir los métodos que faltan :
 
  - repetir : debe imprimir un carácter un número dado de veces.
  - enmarcar: debe imprimir un texto dado enmarcado con un caràcter dado.
 
Salida del programa :
================================
 
Entra tu nombre : Felix
--------------------------------------------------
 
 
********************
*                  *
* !! Hola Felix !! *
*                  *
********************
 
 
####################
#                  #
# Fin del programa #
#                  #
####################
 
*/

import java.util.Scanner;
import java.io.*;

public class E03_Hola {
	
	void repetir(int n, char c) {
		for (int i=0; i<n; i++) {
			System.out.print(c);
		}
	}
	
	void enmarcar(String text, char c) {
		repetir(text.length()+4, c);
		System.out.println();
		
		System.out.print(c);
		repetir(text.length()+2, ' ');
		System.out.println(c);
		
		System.out.println(c + " " +text+ " " +c);
		
		System.out.print(c);
		repetir(text.length()+2, ' ');
		System.out.println(c);
		
		repetir(text.length()+4, c);
	}
	
	public static void main(String[] args) throws Exception{
		 
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));      
        E03_Hola programa=new E03_Hola();
 
        System.out.print("Entra tu nombre: ");
        String nom = entrada.readLine();
 
        programa.repetir(50,'-');
 
        programa.repetir(3,'\n');
 
        programa.enmarcar("!! Hola " +nom+" !!",'*');
 
        programa.repetir(3,'\n');
 
        programa.enmarcar("Fin del programa",'#');
 
    }
}
