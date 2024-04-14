/*
 
Cálculo del área de una corona circular.
Los valores de los radios se entran por teclado.
 
Instrucciones:
Desde el método que calcula el área de la corona se debe llamar a
otro método que calcule el área de un círculo, ya que el área de una
corona circular es el área del 'círculo mayor' menos el área del
'círculo menor'.
 
 
Salida del programa
----------------------------------------
Escribe el radio interior : 6
Escribe el radio exterior : 9
El area es 141,37
 
*/
import java.io.*;

public class E04_AreaCoronaCircular {

	 public static void main (String[]args)throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Escribe el radio exterior: ");
		double radioInt = Double.parseDouble(entrada.readLine());
		
		System.out.println("Escribe el radio exterior: ");
		double radioExt = Double.parseDouble(entrada.readLine());
		
		Cercle petit = new Cercle(radioInt);
		Cercle gran = new Cercle(radioExt);
		
		Corona circular = new Corona(petit, gran);
		
//		System.out.println("L'area del petit es: " +petit.area());
//		System.out.println("L'area del gran es: " +gran.area());
		System.out.println("Area de la corona: " +circular.area());
	}

}
