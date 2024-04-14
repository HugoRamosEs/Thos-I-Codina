import java.io.*;
import java.util.Scanner; 

public class E08_SimplificaPor2 {
 
    public static void main(String args[]) throws IOException {
 
       Scanner entrada = new Scanner (System.in);
       System.out.println("Introduce el numerador: ");
       int numero = entrada.nextInt();
       
       Scanner entrada2 = new Scanner (System.in);
       System.out.println("Introduce un denominador: ");
       int numero2 = entrada.nextInt();
       
       while (numero%2 == 0 && numero2%2 == 0) {
    	   numero = numero/2;
    	   numero2 = numero2/2;
    	   
       }
       System.out.println("La fraccion simplificada es de numerador: " +numero+ " y denominador: " +numero2+ "");
	}
}
