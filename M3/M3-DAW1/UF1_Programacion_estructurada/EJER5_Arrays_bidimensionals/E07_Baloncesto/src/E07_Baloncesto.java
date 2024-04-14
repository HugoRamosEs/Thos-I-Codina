/*
 
Utiliza un array 2D escalonado para guardar las puntuaciones de los jugadores
de un equipo de baloncesto.
 
El programa pide el número de jugadores y luego uno por uno el número de
partidos jugados y los puntos conseguidos en cada partido.
 
Finalmente el programa muestra una tabla donde salga la media de cada jugador
y la puntuación máxima conseguida por él.
 
Salida del programa
-----------------------------------------
Entra el número de jugadores : 3
 
Entra el número de partidos jugados por el jugador 1 : 2
Entra los puntos del partido 1 : 11
Entra los puntos del partido 2 : 15
 
Entra el número de partidos jugados por el jugador 2 : 3
Entra los puntos del partido 1 : 8
Entra los puntos del partido 2 : 5
Entra los puntos del partido 3 : 15
 
Entra el número de partidos jugados por el jugador 3 : 2
Entra los puntos del partido 1 : 21
Entra los puntos del partido 2 : 18
 
JUGADOR      MEDIA   MAXIMA
==============================
Jugador 1    13,00       15
Jugador 2     9,33       15
Jugador 3    19,50       21
 
 */
 
import java.io.*;
 
public class E07_Baloncesto {
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
        
        System.out.println("Introduce el numero de jugadores: ");
        int jugadores = Integer.parseInt(entrada.readLine());
        
        int [][] puntos = new int[jugadores][];
        
        for (int i=0; i<jugadores; i++) {
        	System.out.println("Introduce el numero de partidos jugados por el jugador " +jugadores+1+ " : ");
        	int partidos = Integer.parseInt(entrada.readLine());
        	
        	puntos[i]=new int[partidos];
        	
        	for (int j=0; j<partidos; j++) {
        		System.out.println("Introduce los numeros del partido " +partidos+1+ " : ");
        		puntos[i][j] = Integer.parseInt(entrada.readLine());
        	}
        }
        
        System.out.println("JUGADOR      MEDIA   MAXIMA\n================================");
        for(int i=0; i<jugadores; i++){
            System.out.printf("Jugador %d",i+1);
            int suma = 0;
            int max = 0;
            for(int j=0; j<puntos[i].length; j++){
                suma = suma + puntos[i][j];
                if(puntos[i][j]>max) max = puntos[i][j];
            }
            System.out.printf("%9.2f",(double)suma/puntos[i].length);
            System.out.printf("%9d\n",max);
 
        }
    }
}