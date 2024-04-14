import java.io.*;
 
public class E10_MCD {
 
    public static void main(String args[]) throws IOException {
 
        BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
         
        System.out.print("Entra el primer número : ");
        int a = Integer.parseInt(entrada.readLine());
 
        System.out.print("Entra el segundo número : ");
        int b = Integer.parseInt(entrada.readLine());
        
        int n = Math.min(a,b);
        
        while ( a%n!=0 || b%n!=0 ) {
            n--;
        }
        
        System.out.println("El MCD de " +a+ " y " +b+ " es: " +n+"");

    }
}