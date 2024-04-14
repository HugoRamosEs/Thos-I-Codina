import java.io.*;
 
public class E20_Piramide {
 
    public static void main(String args[]) throws IOException {
 
        BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
 
        System.out.print("Entra la altura : ");
        int altura = Integer.parseInt(entrada.readLine());
        System.out.println();
        
        for(int espacios=1; espacios<=altura; espacios++) {
        	
        	for(int espacio=1; espacio<=altura-espacios; espacio++) {
	        	System.out.print(" ");
        	}
        	
        	for(int asteriscos=1; asteriscos<=(espacios*2)-1; asteriscos++) {
        	        	System.out.print("*");
        	}
        	System.out.println("");
        }
    }
}