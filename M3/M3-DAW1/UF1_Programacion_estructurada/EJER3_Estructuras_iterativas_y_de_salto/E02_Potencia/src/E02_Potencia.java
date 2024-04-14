import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E02_Potencia {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		double potencia = 1;
		
		BufferedReader teclat=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce el numero para la base:");
		double base=Double.parseDouble(teclat.readLine());
		
		System.out.println("Introduce el numero para el exponente: ");
		double exponente=Double.parseDouble(teclat.readLine());
		
		for(int i=0; i<exponente; i++) {
			potencia = potencia * base;
			System.out.println("El resultado es: " +potencia);
		}
		
		

	}

}
