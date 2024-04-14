/*
E02_cat
 
Programa que llegeix un fitxer del tipus de l'exercici anterior, fitxer binari d'enters, i el mostra per consola.
 
*/
 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
 
public class E02_cat {
 
  public static void main(String[] args) throws IOException {
 
      String filename = "2.dat";
      RandomAccessFile fitxer=null;
       
      try {
       
          fitxer = new RandomAccessFile(filename,"r");
      }
      catch (FileNotFoundException e) {
          System.err.println("No existeix el fitxer "+filename);
          return;
      }
       
      while ( fitxer.getFilePointer()<fitxer.length()) {
          System.out.println(fitxer.readInt());
      }
      fitxer.close();
  }
}