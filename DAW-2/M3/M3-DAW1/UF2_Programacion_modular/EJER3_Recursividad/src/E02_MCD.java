/*
 
  Realiza un método recursivo que calcule el máximo común divisor 
  de dos números pasados por parámetro.
 
  Utiliza la siguiente definición recursiva:
 
                | m            si n=0
    mcd(m,n) = <
                | mcd(n, m%n)  si n!=0
        
 
*/
import java.util.Scanner;

public class E02_MCD {
	
	public static int mcd(int n, int m) {
        int num = Math.min(n,m);
        
        while ( n%num!=0 || m%num!=0 ) {
            num--;
        }
        
        return num;
	}
	
	public static int mcdRecursiu (int m, int n) {
		if(n==0) {
			return m;
		}else {
			return mcd(n, m%n);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce un numero: ");
		int n = entrada.nextInt();
		
		System.out.println("Introduce otro numero: ");
		int m = entrada.nextInt();
		
		int resultado = mcdRecursiu(n,m);
		
		System.out.println("Resultado: " +resultado);
		
	}

}
