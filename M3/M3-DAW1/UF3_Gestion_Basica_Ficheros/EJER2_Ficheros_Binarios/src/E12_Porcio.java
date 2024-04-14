import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Crea un mètode amb identificador porcio que servirà per crear 
un fitxer d'enters amb el contingut d'una porció d'un altre 
fitxer d'enters.  El mètode tindrà com a paràmetres el 
nom d'un fitxer a llegir, el nom d'un fitxer nou que hem de crear, 
una posició d'enter inicial (comptat des de zero) i 
la quantitat d'enters a llegir. 
El primer fitxer serà el que hem de llegir, el mètode haurà de 
llegir el contingut d'aquest fitxer i escriure, en el nou fitxer 
a crear, només els enters des de la posició inicial i en la 
quantitat indicada.
Podem suposar que els paràmetres posició inicial i quantitat d'enters a
llegir seran correctes i corresponen a dades vàlides del fitxer a llegir. 
Si el fitxer a llegir no existeix aleshores no ha d'escriure res. 
Aquest mètode no retorna res.
 
Exemple:
Fitxer a llegir té el següent contingut
27
87
93
223
654
902
Suposem que demanem la porció des de la posició inicial 3 i en quantitat 2. 
El fitxer nou que es crearà, contindrà:
223
654
*/

public class E12_Porcio {
	
	public static RandomAccessFile openLectura(String filename) {
		RandomAccessFile fitxer = null;
		try {

			fitxer = new RandomAccessFile(filename, "r");
		} catch (FileNotFoundException e) {
			System.err.println("No existeix el fitxer " + filename);
			return null;
		}
		return fitxer;
	}

	public static RandomAccessFile openEscriptura(String filename) {
		RandomAccessFile fitxer = null;
		try {

			fitxer = new RandomAccessFile(filename, "rw");
		} catch (FileNotFoundException e) {
			System.err.println("No pot crear-se el fitxer " + filename);
			return null;
		}
		return fitxer;
	}
	
	public void porcio(String llegit, String escrit, int posInicial, int quantitat) throws IOException {
		RandomAccessFile llegir = openLectura(llegit);
		if (llegir == null) {
			return;
		}
		
		RandomAccessFile escriure = openEscriptura(escrit);
		if (escriure == null) {
			return;
		}
		
		int num = 0;
		
		llegir.seek(posInicial*4);
		
		escriure.setLength(0);
		
		if (llegir.getFilePointer() < llegir.length()) {
			for (int i=0; i<quantitat; i++) {
				num = llegir.readInt();
				escriure.writeInt(num);
			}
		}
		
		llegir.close();
		escriure.close();
	}
	
	public static void main(String[] args) throws IOException {
		E12_Porcio programa = new E12_Porcio();
		
		programa.porcio("enters.dat", "porcio.dat", 3, 4);
	}
}
