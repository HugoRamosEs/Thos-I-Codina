import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


/*
Crea un mètode amb identificador penultim que escrigui, en un 
fitxer binari d'enters, un nombre enter passat per paràmetre i 
ho faci a la penúltima posició. El mètode tindrà dos paràmetres,
el nom del fitxer i l'enter. Haurà d'escriure l'enter a la penúltima 
posició del fitxer conservant el contingut previ. 
Aquest mètode no retorna res.
 
Exemple:
Fitxer:
123
54
342
734
98
Enter:
24
 
Resultat:
123
54
342
734
24
98
 
*/
import java.util.*;

public class E10_Penultim {
	
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
	
	public static void main(String[] args) throws IOException {
		E10_Penultim programa = new E10_Penultim();
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce un numero: ");
		int num = entrada.nextInt();
		
		RandomAccessFile fitxer = programa.openEscriptura("enters10.dat");
		
		int numAnterior = 0;
		long ultim = fitxer.length() - 4;
		if (ultim < 0) ultim = 0;
		fitxer.seek(ultim);
		
		if (fitxer.getFilePointer() < fitxer.length()) {
			numAnterior = fitxer.readInt();
			fitxer.seek(ultim);
			fitxer.writeInt(num);
			fitxer.writeInt(numAnterior);
			
		}else {
			fitxer.writeInt(num);
		}
		fitxer.close();
	}
}
