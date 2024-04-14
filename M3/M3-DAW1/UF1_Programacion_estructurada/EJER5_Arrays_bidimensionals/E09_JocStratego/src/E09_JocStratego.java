/*
Realitza un programa en Java que ens ajudi a comprovar l'estat d'una partida d'stratego.
Hi ha una modalitat ràpida d'aquest joc que es realitza en un taulell de 8x8 caselles, 
a cada casella pot haver-hi una fitxa o res. 
Un dels jugadors utilitza les fitxes vermelles i l'altre les blaves.
Per a cada jugador inicialment tenim: 
1 Bandera, 2 Bombes, 1 Espia, 2 Exploradors,  2 Antimines, 
1 General i 1 Mariscal. 
Durant la partida les fitxes es van eliminant fins aconseguir 
eliminar la bandera contraria.
 
Per diferenciar el contingut de cada casella s'assignarà 
un número enter a cada una segons convingui:
0   casella buida
1   bandera vermella
2   bomba vermella
3   espia vermell
4   explorador vermell
5   antimines vermell
6   general vermell
7   mariscal vermell
11  bandera blava
12  bomba blava
13  espia blau
14  explorador blau
15  antimines blau
16  general blau
17  mariscal blau 
 
Demana per teclat un número de columna des de 1 fins a 8. 
S'haurà de verificar el contingut de la columna corresponent i 
mostrarà un missatge indicant la suma dels punts de totes fitxes a la columna. 
Punts assignats segons el tipus:
bandera 0 punts / bomba 1 punt / espia 2 punts / 
explorador 3 punts / antimines 5 punts / 
general 8 punts / mariscal 10 punts.
Per exemple:
    Entra una columna (1 a  8) : 3
    Punts a la columna 3 :  7
 
*/
 
import java.util.Scanner;
 
public class E09_JocStratego {
     
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
 
        int[][] tablero = { 
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 12, 13, 11, 17, 0, 0 },
                { 0, 14, 12, 14, 16, 0, 15, 15 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 4, 4, 5, 0, 6, 0, 0, 0 },
                { 0, 0, 1, 2, 2, 5, 0, 0 },
                { 3, 0, 0, 0, 7, 0, 0, 0 }
        };
        
        int puntos []= {0,1,2,3,4,8,10};
        
        System.out.print("Entra una columna (1 a 8): ");
        int col = teclat.nextInt() - 1;
        int sumaPuntos=0;
        
        for (int f=0; f<tablero.length; f++) {
        	int pieza=tablero[f][col];
        	
        	if(pieza>0) {
        		if (pieza>10) pieza=pieza-10;
            	pieza--;
            	
            	
            	int ptPieza= puntos[pieza];
            	
            	sumaPuntos=sumaPuntos+ptPieza;
        	}
        }
        System.out.println(sumaPuntos);
    }
}