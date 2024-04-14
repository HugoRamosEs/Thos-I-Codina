import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/*
E09_Rotacio
 
Programa que realitza la rotació dels nombres enters d'un fitxer binari 
creat amb la classe RandomAccessFile. Avança tots els nombres una posició i 
l'últim l'escriu a l'inici del fitxer.
 
Exemple:
 
Fitxer inicialment conté :  34  56  63  112   1   34   5  -34  88
 
Fitxer al final conté:         88  34  56  63  112   1   34   5  -34
 
*/

public class E09_Rotacio {
	
	RandomAccessFile openLectura(String filename) {
		RandomAccessFile fitxer = null;
		try {

			fitxer = new RandomAccessFile(filename, "r");
		} catch (FileNotFoundException e) {
			System.err.println("No existeix el fitxer " + filename);
			return null;
		}
		return fitxer;
	}

	RandomAccessFile openEscriptura(String filename) {
		RandomAccessFile fitxer = null;
		try {

			fitxer = new RandomAccessFile(filename, "rw");
		} catch (FileNotFoundException e) {
			System.err.println("No pot crear-se el fitxer " + filename);
			return null;
		}
		return fitxer;
	}
	
	public static void main(String[] args) {
		E09_Rotacio programa = new E09_Rotacio();
		
		RandomAccessFile fitxer = programa.openLectura("");
	}
}
