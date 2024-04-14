/*
E01_echo
 
Programa que guarda en un fitxer binari nombres enters entrats per teclat fins que es premi ENTER sense dades.
 
*/
 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
 
public class E01_echo {
    public static void main(String[] args) throws IOException {
 
        String filename = "enters.dat";
        RandomAccessFile fitxer = null;
 
        try {
 
            fitxer = new RandomAccessFile(filename,"rw");
        } catch (FileNotFoundException e) {
            System.err.println("No es pot crear el fitxer " + filename);
            return;
        }
 
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
 
        fitxer.setLength(0);  // Esborra fitxer
         
        System.out.println("Entra valors:");
        String linia = entrada.readLine();
        while (linia.length() > 0) {
             
            int num = Integer.parseInt(linia);
            fitxer.writeInt(num);
             
            linia = entrada.readLine();
        }
        fitxer.close();
        entrada.close();
 
    }
}
