/*
 
  Realiza un método recursivo que determine si una frase
  pasada por parámetro es palíndroma.
 
  Palíndroma significa que la frase se puede leer igual
  de izquierda a derecha que de derecha a izquierda.
 
  Ejemplos de frases palíndromas:
 
    Dabale arroz a la zorra el Abad
    Se van sus naves
    Anita lava la tina
 
  Para simplificar el problema supondremos que no hay 
  espacios ni signos de puntuación y que todas las letras son minúsculas.
 
  Los ejemplos quedarían así:
 
    dabalearrozalazorraelabad
    sevansusnaves
    anitalavalatina
 
  Primero define el problema de manera recursiva y después 
  codifica el método correspondiente.
 
*/
import java.util.Scanner;

public class E03_Palindromos {
	
	public static boolean palindroma(String frase) {
		int longitud = frase.length();
		char primerCaracter = frase.charAt(0);
		char ultimoCaracter = frase.charAt(longitud-1);
		
		if(longitud == 1) {
			return true;
		}
		
		else if(primerCaracter == ultimoCaracter) {
			return palindroma(frase.substring(1,longitud-1));
		}
		
		else {
			return false;
		}
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce una frase: ");
		String frase = entrada.nextLine();
		
		boolean resultado = palindroma(frase);
		
		System.out.println("Resultado: " +resultado);
	}

}
