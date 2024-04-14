import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Practica1 {

	/**
	 * Abre un fichero de texto en lectura
	 * 
	 * @param filename Nombre del fichero
	 * @return objecte Scanner o null si no existe el fichero
	 */
	Scanner openLectura(String filename) {
		Scanner file = null;

		try {
			file = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.err.println("No existeix el fitxer " + filename);
			return null;
		}
		return file;
	}

	/**
	 * Abre un fichero de texto en escritura
	 * 
	 * @param filename Nombre del fichero
	 * @return objeto PrinStream o null o sino se puede crear el objeto
	 */
	PrintStream openEscriptura(String filename) {
		PrintStream sortida = null;

		try {
			sortida = new PrintStream(new File(filename));
		} catch (FileNotFoundException e) {
			System.err.println("No pot crear-se el fitxer " + filename);
			return null;
		}
		return sortida;
	}
	
	/**
	 * Metode que treu linia amb un nombre asignat, y copia a altra fitxer les que no son del numero.
	 * 
	 * @param entrada fitxer donat.
	 * @param numLinia linia donada-
	 * @return true o false
	 */
	public boolean treuLinia(String entrada, int numLinia) {
		Scanner text = openLectura(entrada);
		if (text == null) {
			return false;
		}
		
		String temporal = "temp.txt";
		
		PrintStream temp = openEscriptura(temporal);
		if (temp == null) {
			return false;
		}
		
		int cont = 0;
		while (text.hasNext()) {
			cont++;
			String linia = text.nextLine();
			if (numLinia != cont) {
				temp.println(linia);
			}
		}
		
		if (numLinia > cont) {
			return false;
		}
		
		text.close();
		temp.close();
		
		File original = new File(entrada);
        File copia = new File(temporal);
        original.delete();
        copia.renameTo(original);
        return true;
	}
	
	/**
	 * Metode que conta les lines que superen le quantitat maxima donada.
	 * 
	 * @param entrada fitxer donat
	 * @param quantitat quantitat donada
	 * @return les linies que superen le quantiat maxima
	 */
	public int reduirMida(String entrada, int quantitat) {
		Scanner text = openLectura(entrada);
		if (text == null) {
			return 0;
		}
		
		int cont = 0;
		int mas = 0;
		while (text.hasNext()) {
			String linia = text.nextLine();
			if (cont < quantitat) {
				cont ++;
			}else {
				mas ++;
			}
		}
		text.close();
		
		return mas;
	}
	
	/**
	 * Conta les linies que linies que no son superiors a la mida donada y les copia a un altra fitxer mantenint el contingut anterior.
	 * 
	 * @param maxima longitud per linia maxima
	 * @param entrada fitxer 1 donat.
	 * @param entrada2 fitxer 2 donat.
	 * @return el nombre de linies afegides.
	 */
	public int appendTrunc(int maxima, String entrada, String entrada2) {
		Scanner text = openLectura(entrada);
		if (text == null) {
			return 0;
		}
		
		Scanner text2 = openLectura(entrada2);
		if (text2 == null) {
			return 0;
		}
		
		PrintStream textFinal = openEscriptura("E3_Final.txt");
		if (textFinal == null) {
			return 0;
		}
		
		int liniesAfegides = 0;
		
		while (text.hasNext() && text2.hasNext()) {
			String linia = text.nextLine();
			String linia2 = text2.nextLine();
			
			if (linia.length() - 1 < maxima) {
				textFinal.println(linia);
				liniesAfegides++;
			}
			
			if (linia2.length() - 1 < maxima) {
				textFinal.println(linia2);
				liniesAfegides++;
			}
		}
		
		text.close();
		text2.close();
		textFinal.close();
		
		return liniesAfegides;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practica1 programa = new Practica1();
		System.out.println(programa.treuLinia("hola.txt", 2));
		
		System.out.println(programa.reduirMida("hola.txt", 7));
		
		System.out.println(programa.appendTrunc(8, "E3_1.txt", "E3_2.txt"));
	}

}
