
public class Senzills_02B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 
		Crea una tabla de 8 filas y 8 columnas y llénala, mediante bucles, con 
		los números del 1 al 64 donde los números crezcan de izquierda a derecha 
		y de arriba abajo. Luego muéstrala por pantalla.
		 
		 */
		
		int numeros[][] = new int [8][8];
		int num = 1;
		
		for (int i=0; i<numeros.length; i++) {
			for (int j=0; j<numeros[i].length; j++) {
				numeros[i][j] = num;
				num++;
			}
		}
		
		for (int i=0; i<numeros.length; i++) {
			for (int j=0; j<numeros[i].length; j++) {
				System.out.printf("%02d ", numeros[i][j]);
			}
			System.out.println();
		}
	}
}
