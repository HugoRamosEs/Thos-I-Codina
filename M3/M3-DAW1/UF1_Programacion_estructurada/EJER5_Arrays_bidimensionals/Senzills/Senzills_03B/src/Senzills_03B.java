/*
 
Amplia el ejercicio 1 pidiendo al usuario un número de fila y mostrando 
la suma de esa fila.
 
 */
 
import java.io.IOException;
import java.util.Scanner;
 
public class Senzills_03B {
    public static void main(String[] args) throws IOException {
        int aleatoris[][] = new int[5][8];
        Scanner teclat = new Scanner(System.in);
 
        for (int i = 0; i < aleatoris.length; i++) {
            for (int j = 0; j < aleatoris[i].length; j++) {
                aleatoris[i][j] = (int) (Math.random() * 10);
            }
        }
        for (int i = 0; i < aleatoris.length; i++) {
            for (int j = 0; j < aleatoris[i].length; j++) {
                System.out.printf("%02d ", aleatoris[i][j]);
            }
            System.out.println();
        }
 
        System.out.println("Número de fila ?");
        int fila = teclat.nextInt();
        int suma = 0;
        for (int j = 0; j < aleatoris[fila].length; j++) {
            suma = suma + aleatoris[fila][j];
        }
        System.out.println("La fila " + fila + " té una suma de " + suma);
    }
}
