import java.io.*;
 
public class E05_Factorial {
 
    public static void main(String [] args) throws IOException {
    	
        //Entrada del número con validación
        //Puede calcularse hasta el factorial de 12.
        //El factorial de 13 no cabe en una variable de tipo int y se produce un desbordamiento
    	
    	int n;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        
        do {
            System.out.print("Entra un número: ");
            n = Integer.parseInt(entrada.readLine());
        } while ( n<1 || n>12);
         
        int factorial = 1;
        for (int i=1; i<=n; i++) {
            factorial = factorial * i;
        }
        System.out.printf("El factorial de " +n+ " es: " +factorial);
    }
}