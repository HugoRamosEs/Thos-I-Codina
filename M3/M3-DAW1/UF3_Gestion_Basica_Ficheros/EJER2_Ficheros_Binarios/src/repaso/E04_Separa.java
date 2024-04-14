package repaso;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class E04_Separa {
	
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
		E04_Separa programa = new E04_Separa();
		
		 RandomAccessFile entrada = programa.openLectura("enters.dat");
		 if (entrada == null) {
			 return;
		 }
		 
		 RandomAccessFile parells = programa.openEscriptura("parells.dat");
		 if (parells == null) {
			 return;
		 }
		 
		 RandomAccessFile senars = programa.openEscriptura("senars.dat");
		 if (senars == null) {
			 return;
		 }
		 
		 int num = 0;
		 while (entrada.getFilePointer() < entrada.length()) {
			 num = entrada.readInt();
			 if (num%2 == 0) {
				 parells.writeInt(num);
			 }else {
				 senars.writeInt(num);
			 }
		 }
		 
		 entrada.close();
		 parells.close();
		 senars.close();
	}
}
