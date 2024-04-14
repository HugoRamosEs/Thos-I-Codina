/*
 
Utiliza un array 2D escalonado para guardar las distancias entre 4 ciudades.
Este array se inicializa en el codigo y tendrá forma de pirámide.
Utiliza valores inventados o busca en la web.
 
Ademas se cuenta con un array con los nombres de las ciudades.
 
El programa pide al usuario que elija dos ciudades y muestra la distancia
que hay entre ellas.
 
Salida del programa
-----------------------------------------
CIUDADES
=========================
1. Barcelona
2. Madrid
3. Salamanca
4. Zaragoza
 
Elige la primera ciudad : 1
 
Elige la segunda ciudad : 2
 
La distancia entre Barcelona y Madrid es de 600 km
 
 */
 
import java.io.*;
import java.util.Scanner;
 
public class E06_Distancias {
 
	public static void main(String[] args) throws Exception {
 
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        int CiudadAux = 0;
        int CiudadSal = 0;
        int CiudadLle = 0;
        int distancias [][] = {
        {0},
        {600,0},
        {800,200,0},
        {400,300,300,0}};
        
        System.out.println("CIUTATS");
        System.out.println("--------------------");
        System.out.println("1 = Barcelona");
        System.out.println("2 = Madrid");
        System.out.println("3 = Salamanca");
        System.out.println("4 = Zaragoza");
        System.out.println("--------------------");
        
        System.out.println("Introduce la ciudad de salida: ");
        CiudadSal = Integer.parseInt(entrada.readLine());
        
        System.out.println("Introduce la ciudad de llegada: ");
        CiudadLle = Integer.parseInt(entrada.readLine());
        
        if (CiudadSal == CiudadLle) {
        	System.out.println("Son la misma ciudad");
        }
        
        if (CiudadSal < CiudadLle) {
        	CiudadAux=CiudadSal;
        	CiudadSal=CiudadLle;
        	CiudadLle=CiudadAux;
        }
        System.out.println("La Distancia entre " +CiudadLle+ " y " +CiudadSal+ " es: " +distancias[CiudadSal-1][CiudadLle-1]);
    }
}