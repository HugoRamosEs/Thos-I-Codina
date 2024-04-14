import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;
import java.io.RandomAccessFile;

/*
E08_Posicio
 
Programa que demana una posició del fitxer i mostra el nombre enter 
de la posició escollida.
 
*/


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
		E08_Posicio programa = new E08_Posicio();
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce un numero: ");
		int num = entrada.nextInt();
		
		RandomAccessFile fitxer = programa.openLectura("enters.dat");
		
		fitxer.seek((num - 1)*4);
		
		System.out.println("NUM: " +fitxer.readInt());
		
		fitxer.close();

	}

}
