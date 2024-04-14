
public class Senzills_07B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 
		Amplia el ejercicio 1 calculando la suma de todas las columnas.
		 
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
		
		 System.out.println("------------------------------------------------");
		
		for (int j=0; j<aleatorios[0].length; j++) {
			int suma = 0;
			for(int i=0; i<aleatorios.length; i++) {
				suma = suma + aleatorios[i][j];
			}
			System.out.println("La suma de la columna " +j+ " es: "+suma);
		}
	}
}
