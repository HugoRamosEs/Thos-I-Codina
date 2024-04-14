package repaso;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class E12_Porcio {
	
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
    
    public void porcio(String lectura, String escriptura, long pos, int quantitat) throws IOException {
    	 RandomAccessFile entrada = openLectura(lectura);
    	 if (entrada == null) {
    		 return;
    	 }
    	 
    	 RandomAccessFile sortida = openEscriptura(escriptura);
    	 if (sortida == null) {
    		 return;
    	 }
    	 
    	 sortida.setLength(0);
    	 entrada.seek(pos*4);
    	 int num = 0;
    	 
    	 if (entrada.getFilePointer() < entrada.length()) {
    		 for (int i=0; i<quantitat; i++) {
    			 num = entrada.readInt();
    			 sortida.writeInt(num);
    		 }
    	 }
    	 
    	 entrada.close();
    	 sortida.close();
    }
	
	public static void main(String[] args) throws IOException {
		E12_Porcio programa = new E12_Porcio();
		
		programa.porcio("enters.dat", "porcio.dat", 3, 2);
	}

}
