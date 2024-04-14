import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
E04_Separa
 
Programa que llegeix nombres enters d'un fitxer binari i guarda els valors en
dos fitxers binaris separats "parells.dat" i "senars.dat".
 
*/

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
		
		RandomAccessFile parells = programa.openEscriptura("parells.dat");
		if (parells == null) {
			return;
		}
		
		RandomAccessFile senars = programa.openEscriptura("senars.dat");
		if (senars == null) {
			return;
		}
		
		RandomAccessFile fitxer = programa.openLectura("enters.dat");
		if (fitxer == null) {
			return;
		}
		
		int num = 0;
		while (fitxer.getFilePointer() < fitxer.length()) {
			num = fitxer.readInt();
			if (num%2 == 0) {
				parells.writeInt(num);
			}else {
				senars.writeInt(num);
			}
		}
		
		parells.close();
		senars.close();
		fitxer.close();
	}

}
