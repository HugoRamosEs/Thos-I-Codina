import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Crea un mètode amb identificador nozeros que elimini els enters zero (0) en 
un fitxer d'enters passat per paràmetre, el mètode haurà de llegir tot 
el fitxer i escriure el contingut en un altre fitxer eliminant els zeros. 
El mètode tindrà com a paràmetres dos noms de fitxer,  el primer
correspon al fitxer original del que no s'ha de modificar el contingut, 
el segon correspon al fitxer que s'ha de crear amb els canvis demanats.
Aquest mètode retornarà 0 si ha pogut crear el fitxer o
-1 en cas d'error.
 
*/

public class E11_NoZeros {
	
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
	
	public int noZeros(String llegir, String escriure) throws IOException {
		RandomAccessFile fitxer = openLectura(llegir);
		if (fitxer == null) {
			return -1;
		}
		
		RandomAccessFile fitxer2 = openEscriptura(escriure);
		if (fitxer2 == null) {
			return -1;
		}
		
		fitxer2.setLength(0);
		
		while (fitxer.getFilePointer() < fitxer.length()) {
			int num = fitxer.readInt();
			if (num != 0) {
				fitxer2.writeInt(num);
			}
		}
		fitxer.close();
		fitxer2.close();
		
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		E11_NoZeros programa = new E11_NoZeros();
		
		System.out.println(programa.noZeros("numeros.dat", "resultat.dat"));
        System.out.println(programa.noZeros("numeros2.dat", "dades.dat"));

	}
}
