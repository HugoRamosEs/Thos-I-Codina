/*
 
Supongamos que tenemos un tablero de ajedrez con las casillas numeradas
de la 1 a la 64 en el orden de izquierda a derecha y de arriba abajo.
Calcular la fila y la columna en que se encuentra una casilla determinada
entrando su número.
 
Salida del programa
----------------------------------------
Escribe el número de la casilla : 18
 
La casilla 18 se encuentra en la fila 3 y columna 2
 
*/
import java.util.Scanner;

class Coordenada{
	int fila;
	int columna;
}

public class E12_Tablero {
	
	public int [][] array(){
		int tablero[][] = new int [8][8];
		int num = 1;
		
		for (int i=0; i<tablero.length; i++) {
			for (int j=0; j<tablero[i].length; j++) {
				tablero[i][j] = num;
				num++;
			}
		}
		return tablero;
	}
	
	public Coordenada posicion(int pos){
		int tablero [][] = array();
		Coordenada resultat = new Coordenada();
		
		for (int i=0; i<tablero.length; i++) {
			for(int j=0; j<tablero.length; j++) {
				if(pos == tablero[i][j]) {
					resultat.columna = j+1;
					resultat.fila = i+1;
					System.out.println("La columna es: " +resultat.columna);
					System.out.println("La fila es: " +resultat.fila);
				}
			}
		}
		return resultat;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E12_Tablero programa = new E12_Tablero();
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce un numero: ");
		int num = entrada.nextInt();
		programa.posicion(num);
	}

}
