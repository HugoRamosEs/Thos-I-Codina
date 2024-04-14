
public class Senzills_05B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 
		Amplia el ejercicio 1 mostrando el valor más grande que hay en la tabla.
		 
		 */
		
		int aleatorios[][]= new int [5][8];
		int max = 0;
		
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
		for (int i=0; i<aleatorios.length; i++) {
			for(int j=0; j<aleatorios[i].length; j++) {
				if (aleatorios[i][j]>max) {
					max = aleatorios[i][j];
				}
			}
		}
		
		System.out.println("El numero más grande es: " +max);
	}
}

