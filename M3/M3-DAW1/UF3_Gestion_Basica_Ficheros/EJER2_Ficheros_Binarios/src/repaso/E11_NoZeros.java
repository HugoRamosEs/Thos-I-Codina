package repaso;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;


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
	
    public int nozeros(String original, String canviat) throws IOException {
    	 RandomAccessFile entrada = openEscriptura(original);
    	 if (entrada == null) {
    		 return -1;
    	 }
    	 
    	 RandomAccessFile sortida = openEscriptura(canviat);
    	 if (sortida == null) {
    		 return -1;
    	 }
    	 
    	 while (entrada.getFilePointer() < entrada.length()) {
    		 int num = entrada.readInt();
    		 
    		 if (num!=0) {
    			 sortida.writeInt(num);
    		 }
    	 }
    	 
    	 entrada.close();
    	 sortida.close();
    	 return 0;
    }
	
	public static void main(String[] args) throws IOException {
		E11_NoZeros programa = new E11_NoZeros();
		
		programa.nozeros("enters.dat", "nozeros.dat");
		
		
	}
}
