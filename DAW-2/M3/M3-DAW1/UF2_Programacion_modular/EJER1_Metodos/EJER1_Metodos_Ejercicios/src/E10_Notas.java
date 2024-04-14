/*
 
Programa que permite introducir 10 notas y calcular :
la nota máxima, la nota media y el número de suspensos.
 
Debe contar con :
 
- un método para llenar el array con las notas introducidas
por el usuario
 
- un método para calcular cada uno de los datos que se
piden en el enunciado.
 
Estos últimos métodos no deben contener ninguna instrucción para imprimir
por pantalla, utilizar valores de retorno.
Los print se deben realizar en el main.
 
*/

import java.util.Scanner;
import java.io.*;

public class E10_Notas {
	
	
	
	public double [] arrayNotas (){
		Scanner entrada = new Scanner(System.in);
		double notas [] = new double [10];
		for (int i=0; i<notas.length; i++) {
			System.out.println("Introduce un nota: ");
			notas[i] = entrada.nextDouble();
		}
		return notas;
	}
	
	public double notaMedia(double notas[]) {
		double media = 0;
		double suma = 0;
		for(int i=0; i<notas.length; i++) {
			suma = suma + notas[i];
		}
		media = suma / 10;
		return media;
	}
	
	public double notaMax(double notas[]) {
		double max = 0;
		for(int i=0; i<notas.length; i++) {
			if(max < notas[i]) {
				max = notas[i];
			}
		}
		return max;
	}
	
	public int numSuspensos(double notas[]) {
		int suspensos = 0;
		for(int i=0; i<notas.length;i++) {
			if (notas[i]<5) {
				suspensos++;
			}
		}
		return suspensos;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E10_Notas programa = new E10_Notas();
		
		Scanner entrada = new Scanner(System.in);
		double notas[] = programa.arrayNotas();
		
		System.out.println("Nota media: " +programa.notaMedia(notas));
		System.out.println("Nota maxima: " +programa.notaMax(notas));
		System.out.println("Suspensos: " +programa.numSuspensos(notas));
		
	}

}
