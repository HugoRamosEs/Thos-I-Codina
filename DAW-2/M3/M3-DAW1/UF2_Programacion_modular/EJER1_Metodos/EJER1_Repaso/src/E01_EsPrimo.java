/*
  
Programa que dice si un número dado es primo
( solamente divisible por el mismo y la unidad )
o no lo es.
 
Crear un método boolean esPrimo(int num)
  
Salida del programa
----------------------------------
Entra un número : 123
El numero no es primo
  
*/

import java.util.Scanner;
import java.io.*;

public class E01_EsPrimo {
	
	public boolean esPrimo(int num) {
		if (num <= 1) return false;
        int i = 2;
        while (i <= Math.sqrt(num)) {
            if (num % i == 0) return false;
            i++;
        }
        return true;
    }
	
	 int leerEntero(String texto, int min, int max) throws NumberFormatException, IOException {
		 
	        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	        int dato;
	        boolean error=false;
	        do {
	            dato=0;
	            try {
	                System.out.println(texto+" ("+min+"-"+max+")");
	                dato=Integer.parseInt(entrada.readLine());
	                if (dato<min || dato>max) System.out.println("Incorrecto");
	                error=false;
	            }
	            catch (NumberFormatException e) {
	                System.out.println("Solo se admiten dígitos");
	                error=true;
	            }
	        } while (dato<min || dato>max || error);
	        return dato;
	    }
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		E01_EsPrimo programa = new E01_EsPrimo();
		int num = programa.leerEntero("Entra un texto: ", 1, Integer.MAX_VALUE);
		
		if (programa.esPrimo(num)) {
			System.out.println("Es primo");
		}else {
			System.out.println("No es primo");
		}
		
	}
}
