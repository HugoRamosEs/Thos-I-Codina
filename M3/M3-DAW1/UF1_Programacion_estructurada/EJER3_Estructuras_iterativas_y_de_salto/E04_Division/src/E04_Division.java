import java.io.*;
 
public class E04_Division {
 
    public static void main(String args[]) throws IOException {
 
        BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
         
        System.out.print("Ingrese dividendo: ");
        int dividendo = Integer.parseInt(entrada.readLine());
         
        System.out.print("Ingrese divisor: ");
        int divisor = Integer.parseInt(entrada.readLine());
    }
}
