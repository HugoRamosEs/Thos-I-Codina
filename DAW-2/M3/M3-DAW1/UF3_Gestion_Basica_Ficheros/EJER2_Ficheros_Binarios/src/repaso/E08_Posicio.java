package repaso;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class E08_Posicio {
	
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
		E08_Posicio programa = new E08_Posicio();
		Scanner entradaTeclat = new Scanner(System.in);
		
		System.out.println("Introduce una posicion: ");
		int posicion = entradaTeclat.nextInt();
		
		RandomAccessFile entrada = programa.openLectura("enters.dat");
		if (entrada == null) {
			return;
		}
		
		int num = 0;
		entrada.seek(((posicion - 1)*4));
		
		num = entrada.readInt();
		
		System.out.println(num);
		
		entrada.close();
	}
}
