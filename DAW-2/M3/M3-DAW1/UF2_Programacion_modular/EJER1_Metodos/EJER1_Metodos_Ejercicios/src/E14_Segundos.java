/*
 
Transformación de una cantidad de segundos en horas, minutos y segundos.
La cantidad de segundos se entran por teclado.
 
Utiliza una clase Tiempo con campos para las horas, minutos y segundos.
 
Escribe los métodos que faltan.
 
Salida del programa
---------------------------------------------------
Entra la cantidad de segundos : 5623
5623 segundos son 1 horas, 33 minutos y 43 segundos
 
*/

import java.io.*;
import java.util.Scanner;


public class E14_Segundos {
	
	public Tiempo calcularTiempo(int segundos) {
		Tiempo tC = new Tiempo();
		
		tC.minutos = segundos / 60;
		tC.segundos = segundos & 60;
		
		tC.hora = tC.minutos / 60;
		tC.minutos = tC.minutos & 60;
		
		return tC;
	}
	
    public static void main(String[] args) throws IOException {
 
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        E14_Segundos programa = new E14_Segundos();
 
        System.out.print("Entra la cantidad de segundos : ");
        int segundos = Integer.parseInt(entrada.readLine());
 
        Tiempo t = programa.calcularTiempo(segundos);
 
        System.out.printf("%d segundos son %d horas, %d minutos y %d segundos", segundos, t.hora, t.minutos,
                t.segundos);
    }
}
 
