/*
  E06_NoBlankLines
   
  Programa que elimina las líneas vacías de un fichero de texto
 
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class E06_NoBlankLines {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "NoLiniesBlanc.txt";
		String filename2 = "sin-espacios.txt";
		Scanner fichero = null;
		PrintStream salida = null;
		
		try {
			fichero = new Scanner(new File(filename));
		}catch (FileNotFoundException e){
			System.err.println("No existe el fichero: " +filename);
			System.exit(2);
			//return;
		}
		
		try {
			salida = new PrintStream(new FileOutputStream(filename2, true));
		}catch (FileNotFoundException e){
			System.err.println("No existe el fichero: " +filename2);
			System.exit(1);
			//return;
		}
		
		while (fichero.hasNext()) {
			String linia = fichero.nextLine();
			if (linia.trim().length() > 0) {
				salida.println(linia);
			}
		}
		fichero.close();
		salida.close();
		
		File antiguo = new File ("NoLiniesBlanc.txt");
		File copia = new File("sin-espacios.txt");
		antiguo.delete();
		copia.renameTo(antiguo);
	}

}
