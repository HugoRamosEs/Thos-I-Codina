package repaso;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class E03_SumaNumeros {
	
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
 
    /**
     * Obre el fitxer binari en escriptura
     * @param filename nom del fitxer
     * @return objecte RandomAccessFile o null si no es pot crear el fitxer
     */
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
		E03_SumaNumeros programa = new E03_SumaNumeros();
		
		RandomAccessFile entrada = programa.openLectura("enters.dat");
		if (entrada == null) {
			return;
		}
		
		RandomAccessFile sortida = programa.openEscriptura("suma.dat");
		if (sortida == null) {
			return;
		}
		
		int suma = 0;
		sortida.setLength(0);
		while(entrada.getFilePointer() < entrada.length()) {
			suma = suma + entrada.readInt();
		}
		
		sortida.writeInt(suma);
		entrada.close();
		sortida.close();
	}
}
