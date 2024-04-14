
import java.util.Scanner;
import java.io.*;

class Vehicle{
	String marca;
	String model;
	String matricula;
	
	Vehicle(){
		
	}
	
	Vehicle(String mar, String mod, String mat){
		marca = mar;
		model = mod;
		matricula = mat;
	}
	
	public String toString() {
		return marca+" / "+model+" / "+matricula;
	}
}

public class Practica1 {
	/**
	 * Aquest metode cerca en un array de objectes anomenats vehicles, que contenen 3 parametres (marca, model, matricula)
	 * una matricula que introdueixi un usuari. Si resulta que la matricula pertany a un vehicle, aquest es mostrará,
	 * si no coinxideix, es mostrara un valor null.
	 * @param vehicles objectes amd els parametres (marca, model, matricula).
	 * @param matricula dada que introdueix l'usuari i es contrastada amb la matricula de l'objecte.
	 * @return retorna el vehicle que coincideix amb la matricula que ha introuit l'usuari o un valor null en cas de no coincidir.
	 */
	public Vehicle matricula(Vehicle vehicles[], String matricula) {
		Vehicle vehicle = new Vehicle();
		
		for (int i=0; i<vehicles.length; i++) {
			if (matricula.equals(vehicles[i].matricula)) {
				vehicle = vehicles[i];
				return vehicle;
			}
		}
		return null;
	}
	
	/**
	 * Aquest metode consisteix en comptar el nombre de vegades que apareix un caracter introduit per l'usuari en una frase escrita
	 * per l'usuari.
	 * @param frase La frase que introdueix l'usuari.
	 * @param c El caracter que introdueix l'usuari i que s'ha de comptar dins de la frase.
	 * @return retorna el nombre de vegades que el caracter (c) ha aparegut.
	 */
	public int lletres(String frase, char c) {
		int comptador = 0;
		for (int i=0; i<frase.length(); i++) {
			if(c == frase.charAt(i)) {
				comptador++;
			}
		}
		return comptador;
	}
	
	/**
	 * Aquest metode agafa una array, y suma tots el numeros que apareixen en l'ultima fila d'aquesta l'array.
	 * @param tablero es l'array on hi son els numeros.
	 * @return retorna la suma dels numeros que hi han a l'ultima fila de l'array.
	 */
	public int parasols(int tablero[][]) {
		int fila = 0;
        int suma = 0;
        for (int j = 0; j < tablero[fila].length; j++) {
        	fila = tablero[j].length + 1;
            suma = suma + tablero[fila][j];
        }
        return suma;
	}
	
	/**
	 * Aquest metode consisteix en agafar la posició del numero maxim de l'array que excedeix la velocitat legal introduida per l'usuari.
	 * @param velocidades array de velocitats.
	 * @param velMax velocitat maxima permitida (legal).
	 * @return retorna el valor maxim de l'array que excedeix el limit de velocitat (legal).
	 */
	public int fittipaldi(int velocidades[], int velMax) {
		int max = 0;
		int posicion = 0;
		for (int i=0; i<velocidades.length; i++) {
			if(velocidades[i]>max) {
				max = velocidades[i];
				if(velocidades[i] > velMax) {
					posicion = i;
				}else {
					posicion = -1;
				}
			}
		}
		return posicion;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practica1 programa = new Practica1();
		Scanner entrada = new Scanner(System.in);
		
		System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+                     EJERCICIO 1                     +\n"
		+ "+-----------------------------------------------------+\n");
		
		Vehicle[] vehicles = {
				new Vehicle("Porshe", "911", "9999CSV"),
				new Vehicle("Seat", "Leon", "2018XML"),
				new Vehicle("Ferrari", "Portofino", "0001SQL"),
		};

		System.out.println("Introduce una matricula: ");
		String matricula = entrada.nextLine();
		
		System.out.println(programa.matricula(vehicles, matricula));
		
		System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+                     EJERCICIO 2                     +\n"
		+ "+-----------------------------------------------------+\n");
		
        int[][] tablero = { 
                { 0, 0, 0, 0, 0,},
                { 0, 0, 12, 13, 11},
                { 0, 14, 12, 14, 16},
                { 0, 0, 0, 0, 0,},
                { 0, 0, 0, 0, 0,},
                { 4, 4, 5, 0, 6,},
                { 0, 0, 1, 2, 2,},
        };
        
        System.out.println("La suma de la ultima fila es: " +programa.parasols(tablero));
		
		System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+                     EJERCICIO 3                     +\n"
		+ "+-----------------------------------------------------+\n");
		
		System.out.println("Introduce una frase: ");
		String frase = entrada.nextLine();
		
		System.out.println("Introduce un caracter: ");
		char lletra = entrada.nextLine().charAt(0);
		
		System.out.println("El caracter introducido aparece " +programa.lletres(frase, lletra)+ " veces");
		
		System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+                     EJERCICIO 4                     +\n"
		+ "+-----------------------------------------------------+\n");
		
        int[] velocidades = {90, 200, 120, 100, 230, 155};
        
        System.out.println("Velocidad máxima permitida: ");
		int velMax = entrada.nextInt();
		
		System.out.println("Posicion: " +programa.fittipaldi(velocidades, velMax));
	}

}
