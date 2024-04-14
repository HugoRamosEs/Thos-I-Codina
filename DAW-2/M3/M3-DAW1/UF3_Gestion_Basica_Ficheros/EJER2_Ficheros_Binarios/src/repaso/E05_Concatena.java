package repaso;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class E05_Concatena {
	
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
		// TODO Auto-generated method stub
		E05_Concatena programa = new E05_Concatena();
		
		RandomAccessFile parells = programa.openLectura("parells.dat");
		if (parells == null) {
			return;
		}
		
		RandomAccessFile senars = programa.openLectura("senars.dat");
		if (senars == null) {
			return;
		}
		
		RandomAccessFile concatena = programa.openEscriptura("concatena.dat");
		if (concatena == null) {
			return;
		}
		
		while (parells.getFilePointer() < parells.length()) {
			int parell = parells.readInt();
			concatena.writeInt(parell);
		}
		
		while (senars.getFilePointer() < senars.length()) {
			int senar = senars.readInt();
			concatena.writeInt(senar);
		}
		
		parells.close();
		senars.close();
		concatena.close();
	}
}
