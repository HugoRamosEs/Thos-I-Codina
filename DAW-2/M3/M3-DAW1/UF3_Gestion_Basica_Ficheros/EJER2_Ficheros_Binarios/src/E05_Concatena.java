import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
E05_Concatena
 
Programa que concatena els fitxers "parells.dat" i "senars.dat" en un fitxer "enters.dat"
 
*/

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
		E05_Concatena programa = new E05_Concatena();
		
		RandomAccessFile parells = programa.openLectura("parells.dat");
		if (parells == null) {
			return;
		}
		
		RandomAccessFile senars = programa.openLectura("senars.dat");
		if (senars == null) {
			return;
		}
		
		RandomAccessFile fitxer = programa.openEscriptura("enters-concatena.dat");
		if (fitxer == null) {
			return;
		}
		
		while (parells.getFilePointer() < parells.length()) {
            int num=parells.readInt();
            fitxer.writeInt(num);
        }
        while (senars.getFilePointer() < senars.length()) {
            int num=senars.readInt();
            fitxer.writeInt(num);
        }
         
        fitxer.close();
        parells.close();
        senars.close();
 

	}

}
