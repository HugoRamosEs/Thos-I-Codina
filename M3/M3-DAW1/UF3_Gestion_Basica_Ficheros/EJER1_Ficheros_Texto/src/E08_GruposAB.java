import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/*
E08_GruposAB
 
Tenemos un fichero con un listado de alumnos como este:
 
Abad Mesa, Oscar:B
Agustí Pérez, Arturo:A
Bespa Cinta, Dunia:A
Betas Sorribas, Mario:B
Cano Domínguez, Carlos:B
Casano Minguillon, Alejandro:A
Darpa Sánchez, Néstor:B
Fleming Sánchez, Andrés:A
Gates Heredia, Marcos:B
Martínez Graupera, Kevin:A
Piera Molina, Manuel:B
 
Escribe un programa que guarde en dos ficheros diferentes, “grupoa.txt” y “grupob.txt”, 
los alumnos del grupo A y del grupo B por separado.
 
*/

public class E08_GruposAB {

	public static void main(String[] args) {
		String filename1 = ("gruposfull.txt");
		String filename2 = ("grupoA.txt");
		String filename3 = ("grupoB.txt");
		
		Scanner entrada = null;
		PrintStream salidaA = null;
		PrintStream salidaB = null;
		
		try {
			entrada = new Scanner(new File(filename1));
		}catch (FileNotFoundException e){
			System.err.println("No existe el fichero: " +filename1);
			System.exit(2);
			//return;
		}
		
		try {
			salidaA = new PrintStream(new FileOutputStream(filename2, true));
		}catch (FileNotFoundException e){
			System.err.println("No existe el fichero: " +filename2);
			System.exit(1);
			//return;
		}
		
		try {
			salidaB = new PrintStream(new FileOutputStream(filename3, true));
		}catch (FileNotFoundException e){
			System.err.println("No existe el fichero: " +filename3);
			System.exit(1);
			//return;
		}
		
		String linia = "";
		String liniaA = "";
		String liniab = "";
		
		while (entrada.hasNext()) {
			linia = entrada.nextLine();
			if(linia.endsWith("A")) {
				salidaA.println(linia);
			}
			
			if(linia.endsWith("B")) {
				salidaB.println(linia);
			}
		}
		
		entrada.close();
		salidaA.close();
		salidaB.close();

	}

}
