import java.util.Scanner;

public class Senzills_04B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 
		Amplia el ejercicio 3 pidiendo al usuario un número de columna y 
		mostrando la suma de esa columna.
		 
		 */
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce la columna: ");
		int columna = entrada.nextInt();
		
		int aleatorios[][] = new int [5][8];
		int suma = 0;
		
		for (int i = 0; i < aleatorios.length; i++) {
            for (int j = 0; j < aleatorios[i].length; j++) {
                aleatorios[i][j] = (int) (Math.random() * 100);
            }
        }
        for (int i = 0; i < aleatorios.length; i++) {
            for (int j = 0; j < aleatorios[i].length; j++) {
                System.out.printf("%02d ", aleatorios[i][j]);
            }
            System.out.println();
        }
		
        System.out.println("------------------------------------------------");
        
		for(int f=0; f<aleatorios.length; f++) {
			suma = suma + aleatorios[f][columna];
		}
		System.out.println("La suma de la columna "+columna+" es: "+suma);
	}
}
