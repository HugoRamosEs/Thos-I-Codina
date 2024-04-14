
public class Senzills_01B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 
		Crea una tabla de 5 filas y 8 columnas y llénala con números aleatorios. 
		Luego muéstrala por pantalla.
		 
		 */
		
		int aleatorios[][]= new int [5][8];
		
		for (int i=0; i<aleatorios.length; i++) {
			for(int j=0; j<aleatorios[i].length; j++) {
				aleatorios[i][j]= (int) (Math.random()*100);
			}
		}
		
		for (int i=0; i<aleatorios.length; i++) {
			for(int j=0; j<aleatorios[i].length; j++) {
				System.out.printf("%02d " , aleatorios[i][j]);
			}
			System.out.println();
		}
	}
}
