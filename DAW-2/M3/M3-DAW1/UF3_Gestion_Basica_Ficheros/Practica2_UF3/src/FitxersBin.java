import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class FitxersBin {
	/**
     * Obre el fitxer binari en Lectura
     * @param filename  nom del fitxer
     * @return objecte RandomAccessFile o null si no es pot obrir el fitxer
     */
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
    
    /**
     * Realitza la lectura d'un enter en una posició concreta del fitxer
     * 
     * @param fitxer a on es fa la lectura
     * @param pos  posició de l'enter comptant des de zero
     * @return  l'enter llegit
     * @throws IOException
     */
    int llegir(RandomAccessFile fitxer, long pos) throws Exception {
        fitxer.seek(pos*4);
        if (fitxer.getFilePointer()<fitxer.length()) return fitxer.readInt();
        throw new Exception();
    }
    
    /**
     * Realitza l'escriptura d'un enter en una posició concreta del fitxer
     * 
     * @param fitxer a on es fa l'escriptura
     * @param pos  posició de l'enter comptant des de zero
     * @param valor enter que es vol escriure
     * @throws IOException
     */
    void escriure(RandomAccessFile fitxer, long pos, int valor) throws IOException {
        fitxer.seek(pos*4);
        fitxer.writeInt(valor);
    }
    
    /**
     * Intercanvia el numero d'una posicio per un altra, i viceversa.
     * 
     * @param fitxer nom del fitxer.
     * @param pos1 posicio del primer numero
     * @param pos2 posicio del segon numero
     * @return -1 si no pot obrir el fitxer, -2 si no por canviar els numeros, 0 si ho ha fet
     * @throws Exception llença una excepcio en cas de que no funcioni
     */
	
    public int intercanvi(String fitxer, int pos1, int pos2) throws Exception {
    	RandomAccessFile entrada = openEscriptura(fitxer);
    	if (entrada == null) {
    		return -1;
    	}
    	
    	long num = entrada.length() / 4;
    	
    	if (pos1 > entrada.length() || pos1 < 0 || pos2 > entrada.length() || pos2 < 0) {
    		return -2;
    	}
    	
    	int num1 = llegir(entrada, pos1);
    	int num2 = llegir (entrada, pos2);
    	
    	escriure(entrada, pos2, num1);
    	escriure(entrada, pos1, num2);
    	
    	entrada.close();
    	return 0;
    }
    
    /**
     * El metode mira de reduir la mida d'un fitxer a la quantitat máxima establida per l'usuari.
     * 
     * @param fitxer nom del fitxer
     * @param quantitat quantitat màxima de numeros
     * @return -1 si no es pot obrir el fitxer, 0 si la mida es correcta, num de valors trets
     * @throws IOException llença una excepcio en cas de que no funcioni
     */
    public int reduirMida(String fitxer, int quantitat) throws IOException {
    	RandomAccessFile entrada = openLectura(fitxer);
    	if (entrada == null) {
    		return -1;
    	}
    	
    	int contador = 0;
    	int restants = 0;
    	int num = 0;
    	
    	while(entrada.getFilePointer() < entrada.length()) {
    		num = entrada.readInt();
    		contador++;
    		if (contador < quantitat) {
    			entrada.writeInt(num);
    			return 0;
    		}else {
    			restants++;
    		}
    	}
		
		entrada.close();
		return restants;
    }
    
    /**
     * Contatena ens numeros de dos fitxers, en un tercer fitxer, sempre que aquest siguin menor de 100.
     * 
     * @param fitxer nom del primer fitxer
     * @param fitxer2 nom del segon fitxer
     * @param fitxer3 nom del tercer fitxer
     * @return -1 si no ha pogut obrir el fitxer o el nombre de numeros afegits al tercer fitxer.
     * @throws IOException llença una excepcio en cas de que no funcioni
     */
    public int limit100(String fitxer, String fitxer2, String fitxer3) throws IOException {
    	RandomAccessFile entrada = openLectura(fitxer);
    	if (entrada == null) {
    		return -1;
    	}
    	
    	RandomAccessFile entrada2 = openLectura(fitxer2);
    	if (entrada2 == null) {
    		return -1;
    	}
    	
    	RandomAccessFile entrada3 = openEscriptura(fitxer3);
    	if (entrada3 == null) {
    		return -1;
    	}
    	
    	int contador = 0;
    	entrada3.setLength(0);
    	
    	while (entrada.getFilePointer() < entrada.length()) {
            int num = entrada.readInt();
            if (num < 100) {
            	entrada3.writeInt(num);
                contador ++;
            }
        }
    	
    	while (entrada2.getFilePointer() < entrada2.length()) {
            int num2 = entrada2.readInt();
            if (num2 < 100) {
            	entrada3.writeInt(num2);
                contador ++;
            }
        }
    	
    	entrada.close();
    	entrada2.close();
    	entrada3.close();
    	return contador;
    }
	
	public static void main(String[] args) throws Exception {
		FitxersBin programa = new FitxersBin();
		Scanner entrada = new Scanner(System.in);
		
		System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+                     EJERCICIO 1                     +\n"
		+ "+-----------------------------------------------------+\n");
		
		System.out.println(programa.intercanvi("1.dat", 1, 3));
		
		System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+                     EJERCICIO 2                     +\n"
		+ "+-----------------------------------------------------+\n");
		
		System.out.println(programa.reduirMida("2.dat", 2));
		
		System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+                     EJERCICIO 3                     +\n"
		+ "+-----------------------------------------------------+\n");
		
		System.out.println(programa.limit100("3.dat", "4.dat", "5.dat"));
	}
}
