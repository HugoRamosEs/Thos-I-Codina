/*
 * Realitza un mètode recursiu i un altre iteratiu 
 * que calculi un terme de la sèrie de fibonacci:
 *        0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 *        
 *        fib(0)=0
 *        fib(1)=1
 *        fib(n)=fib(n-2)+fib(n-1)  si n>1
 * 
 */
import java.util.Scanner;

public class E05_Fibonacci {
	
	public static int fibonacci (int num) {
		if (num==0) {
			return 0;
		}
		
		else if(num == 1) {
			return 1;
		}
		
		else {
			return fibonacci(num-1)+fibonacci(num-1);
		}
	}
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce un numero: ");
		int numero = entrada.nextInt();
		
		int resultado = fibonacci(numero);
		
		System.out.println("Resultado: " +resultado);
	}
}
