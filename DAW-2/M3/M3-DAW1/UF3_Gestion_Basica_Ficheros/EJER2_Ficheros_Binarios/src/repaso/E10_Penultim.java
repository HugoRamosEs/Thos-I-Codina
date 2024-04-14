package repaso;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
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
		E10_Penultim programa = new E10_Penultim();
		Scanner entradaTeclat = new Scanner(System.in);
		
		System.out.println("Introduce un numero: ");
		int num = entradaTeclat.nextInt();
		
		RandomAccessFile entrada = programa.openEscriptura("enters.dat");
		if (entrada == null) {
			return;
		}
		
		int numAnterior = 0;
		long posFinal = entrada.length() - 4;
		
		if (posFinal < 0) posFinal  = 0;
		entrada.seek(posFinal);
		
		if (entrada.getFilePointer() < entrada.length()) {
			numAnterior = entrada.readInt();
			entrada.seek(posFinal);
			entrada.writeInt(num);
			entrada.writeInt(numAnterior);
		}else {
			entrada.writeInt(num);
		}
		
		entrada.close();
	}
}
