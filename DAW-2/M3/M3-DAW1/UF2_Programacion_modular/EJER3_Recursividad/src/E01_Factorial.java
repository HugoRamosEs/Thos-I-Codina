/*
 
  Realiza un método recursivo que calcule el factorial
  de un número pasado por parámetro.
 
  Utiliza la siguiente definición recursiva:
 
        |  1         si n=0
   n!= < 
        |  n*(n-1)!  si n>0
        
 
*/

import java.util.Scanner;
public class E01_Factorial {
	
	public static int factorial(int n) {
		if (n==0) {
			return 1;
		}else {
			return n*factorial(n-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce un numero positivo: ");
		int numero = entrada.nextInt();
		
		int resultado = factorial(numero);
		
		System.out.println("Resultado: " +resultado);
		
	}

}
