import java.io.*;
 
public class E14_NumeroSecreto {
 
    public static void main(String args[]) throws IOException {
 
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
 
        int num;
        int min=0;
        int max=1000;
        boolean acierto=false;
        int intento=0;
        ;
        
        do {
        	intento++;
        	num = (max + min) / 2;
        	System.out.println("Intento: " +intento+ ". Introduce uno de los siguientes caracteres (< , > , =) - (Max = 1000 / Min = 0): " +num);
        	char opcion = entrada.readLine().charAt(0);
        	
        	if (opcion == '<') {
        		max=num;
        	}
        	if (opcion == '>') {
        		min=num;
        	}
        	if (opcion == '=') {
        		acierto = true;
        	}
        	if (max == min) {
        		System.out.println("Es es este numero, no me engañes");
        	}
        	
        }while (!acierto);
        System.out.println("El número secreto és: " +num+ ". He necesitado "+intento+" intentos.");
    }
}	   