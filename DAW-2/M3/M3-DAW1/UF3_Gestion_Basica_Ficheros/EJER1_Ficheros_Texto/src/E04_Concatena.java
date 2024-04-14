/*
  E04_Concatena
 
  Programa que concatena dos ficheros de texto, es decir añade el contenido de uno a otro ya existente.
 
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class E04_Concatena {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "proves-dades.txt";
		String filename2 = "numeros.txt";
		PrintStream fichero = null;
		Scanner fichero2 = null;
		
		
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
		
		while (fichero2.hasNext()) {
			String fich = fichero2.nextLine();
			fichero.println(fich);
		}
		
		fichero.close();
		fichero2.close();
	}

}
