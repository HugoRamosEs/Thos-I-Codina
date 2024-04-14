/*
 
Definición de la clase Alumno para guardar el nombre y el NIF.
Creción de un array con 3 objetos de tipo Alumno inicializados.
El programa pide un NIF y busca el alumno que tenga ese NIF.
 
Salida del programa:
--------------------------------------------------
Entra un nif : 87654321A
El nif 87654321A corresponde al alumno Manel Vidal
 
 
*/
import java.util.Scanner;

class Alumno{
	String nombre;
	String nif;
	
	Alumno(){
		
	}
	
	Alumno(String n, String nif){
		nombre = n;
		this.nif = nif;
	}
	
	public String toString() {
		return ("NIF: " +nif+ " alumno: " +nombre);
	}
}

public class E07_Alumnos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		
		
		Alumno[] alumnos = {
				new Alumno ("Anna Costa", "12345678X"),
				new Alumno ("Carles Barbera", "87654321X"),
				new Alumno ("Manel Vidal", "12348765X"),
		};
		
		System.out.println("Entra un NIF: ");
		String nif = entrada.next();
		
		int correcto = -1;
		for (int i=0; i<alumnos.length; i++) {
			if (nif.equals(alumnos[i].nif));
			correcto = i;
		}
		
		if (correcto != -1) {
			System.out.println("El nif " +alumnos[correcto].nif+ " se corresponde al alumno: " +alumnos[correcto].nombre);
		}else {
			System.out.println("Alumno no encontrado");
		}
	}
}
