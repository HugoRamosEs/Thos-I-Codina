import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class E03_SumaNumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "numeros.txt";
		Scanner fichero = null;
		
		try {
			fichero = new Scanner(new File(filename));
		}catch (FileNotFoundException e){
			System.err.println("No existe el fichero: " +filename);
			System.exit(1);
			//return ;
		}
		
		double numero = 0;
		double suma = 0;
		while (fichero.hasNext()) {
			numero = Double.parseDouble(fichero.nextLine());
			suma = suma + numero;
		}
		
		fichero.close();
		System.out.println("Total: " +suma);
	}

}
