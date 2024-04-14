/*
  E05_echo
 
  Programa que guarda en un fichero de texto toda la información que se lee del teclado hasta que se pulse ENTER sin datos.
 
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class E05_echo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "proves-dades.txt";
		String filename2 = "numeros.txt";
		PrintStream fichero = null;
		Scanner fichero2 = null;
		Scanner entrada = new Scanner(System.in);
		
		try {
			fichero = new PrintStream(new FileOutputStream(filename, true));
		}catch (FileNotFoundException e){
			System.err.println("No existe el fichero: " +filename);
			System.exit(2);
			//return ;
		}
		
		try {
			fichero2 = new Scanner(new File(filename2));
		}catch (FileNotFoundException e){
			System.err.println("No existe el fichero: " +filename2);
			System.exit(1);
			//return ;
		}
		
		while (true) {
			System.out.println("Introduce una palabra: ");
			String palabra = entrada.nextLine();
			
			if(palabra.equals("")) {
				break;
			}else {
				fichero.println(palabra);
			}
		}
		
		fichero.close();
		fichero2.close();
	}

}
