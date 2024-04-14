import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/*
  E07_TabulacionesPorEspacios
   
  Programa que reemplaza las tabulaciones por grupos de 4 espacios en un fichero de texto
 
*/

// tab = \t

public class E07_TabulacionesPorEspacios {

	public static void main(String[] args) {
		String filename = "tabular.txt";
		String filename2 = "4espacios.txt";
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
			linia = linia.replace("\t", "    ");
			salida.println(linia);
		}
		
		fichero.close();
		salida.close();
		
		File antiguo = new File ("tabular.txt");
		File copia = new File("4espacios.txt");
		antiguo.delete();
		copia.renameTo(antiguo);	
	}

}
