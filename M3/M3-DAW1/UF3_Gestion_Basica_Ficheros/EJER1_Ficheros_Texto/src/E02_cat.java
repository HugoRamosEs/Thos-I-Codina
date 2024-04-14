import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
  E02_cat
 
  Programa que lee las lineas de un fichero y las muestra por pantalla.
 
*/

public class E02_cat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "proves-dades.txt";
		Scanner fichero = null;
		
		try {
			fichero = new Scanner(new File(filename));
		} catch (FileNotFoundException e){
			System.err.println("No existe el fichero: " +filename);
			System.exit(1);
			//return ;
		}
		
		while (fichero.hasNext()) {
			System.out.println(fichero.nextLine());
		}
		fichero.close();
	}

}
