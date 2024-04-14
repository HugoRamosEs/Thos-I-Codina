import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/*
E09_MezclaOrdenada
 
Programa que fusiona dos ficheros con nombres de alumnos en uno solo. 
Los ficheros originales están ordenados alfabéticamente y el final también debe estarlo.
 
Para no malgastar recursos no deben almacenarse todos los nombres en memoria y luego ordenarlos.
 
Se debe leer un nombre de cada fichero, compararlos y guardar en el fichero de salida el menor. 
Luego leer otro nombre, compararlo con el que nos quedaba de antes y guardar el menor. 
Repetir hasta acabar de guardar todos.
 
*/

public class E09_MezclaOrdenada {

	public static void main(String[] args) {
		String filename2 = ("grupoA.txt");
		String filename3 = ("grupoB.txt");
		String filename1 = ("alumnos.txt");
		
		Scanner entrada1 = null;
		Scanner entrada2 = null;
		PrintStream salida1 = null;
		
		try {
			entrada1 = new Scanner(new File(filename2));
		}catch (FileNotFoundException e){
			System.err.println("No existe el fichero: " +filename2);
			System.exit(2);
			//return;
		}
		
		try {
			entrada2 = new Scanner(new File(filename3));
		}catch (FileNotFoundException e){
			System.err.println("No existe el fichero: " +filename3);
			System.exit(2);
			//return;
		}
		
		try {
			salida1 = new PrintStream(new FileOutputStream(filename1, false));
		}catch (FileNotFoundException e){
			System.err.println("No existe el fichero: " +filename1);
			System.exit(1);
			//return;
		}
		
		String linia1 = "";
		String linia2 = "";
		
		linia1 = entrada1.nextLine();
		linia2 = entrada2.nextLine();
		
		while (entrada1.hasNext() && entrada2.hasNext()) {
			if(linia1.compareTo(linia2)<0) {
				salida1.println(linia1);
				linia1 = entrada1.nextLine();
			}
			else if (linia1.compareTo(linia2)>0) {
				salida1.println(linia2);
				linia2 = entrada2.nextLine();
			}
			else {
				salida1.println(linia1);
				salida1.println(linia2);
				linia1 = entrada1.nextLine();
				linia2 = entrada2.nextLine();
			}
		}
		
		if(linia1.compareTo(linia2)<0) {
			salida1.println(linia1);
			salida1.println(linia2);
		}
		else if (linia1.compareTo(linia2)>0) {
			salida1.println(linia2);
			salida1.println(linia1);
		}
		else {
			salida1.println(linia1);
			salida1.println(linia2);
		}
		
		while(entrada1.hasNext()) {
			linia1 = entrada1.nextLine();
			salida1.println(linia1);
			
		}
		
		while(entrada2.hasNext()) {
			linia2 = entrada2.nextLine();
			salida1.println(linia2);
		}

		entrada1.close();
		entrada2.close();
		salida1.close();
		
	}

}
