
public class Senzills_08B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 
		Crea una tabla dentada con los valores : { 3,6,7},{5,7},{8,5,6,7} y 
		calcula la media de los valores de cada fila.
		 
		 */
		
		int dentada[][] = {{3, 6, 7},{5, 7},{8, 5, 6, 7}};
		
		for (int i=0; i<dentada.length; i++) {
			for(int j=0; j<dentada[i].length; j++) {
				System.out.printf("%02d " , dentada[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("------------------------------------------------");
		
		for (int i=0; i<dentada.length; i++) {
			double suma = 0;
			double division = 0;
			for(int j=0; j<dentada[i].length; j++) {
				suma = suma + dentada[i][j];
			}
		division = suma / dentada[i].length;
		System.out.println("La media de la fila " +i+ " es: " +division);
		}
	}
}

