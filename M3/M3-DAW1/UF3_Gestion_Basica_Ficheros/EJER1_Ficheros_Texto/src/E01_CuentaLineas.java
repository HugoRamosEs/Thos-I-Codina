import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
  E01_CuentaLineas
 
  Programa que cuenta las líneas de un fichero de texto
 
*/
public class E01_CuentaLineas {

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
		
		int cont = 0;
		while (fichero.hasNext()) {
			fichero.nextLine();
			cont ++;
		}
		
		fichero.close();
		
		System.out.println("El fichero " +filename+ " tiene " +cont+ " lineas");
	}

}
