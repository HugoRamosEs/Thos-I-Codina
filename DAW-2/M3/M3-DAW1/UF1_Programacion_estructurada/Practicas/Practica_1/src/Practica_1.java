import java.util.Scanner;
import java.io.*;

public class Practica_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Exercici 1
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introdueix la demanda de m3/h de gas: ");
		double quantitatGas = entrada.nextDouble();
		
		Scanner entrada2 = new Scanner(System.in);
		System.out.println("El gasoducte 1 esta en manteniment? (true o false):  ");
		boolean estat = entrada2.nextBoolean();
		
		Scanner entrada3 = new Scanner(System.in);
		System.out.println("El gasoducte 2 esta en manteniment? (true o false): ");
		boolean estat2 = entrada3.nextBoolean();
		
		if (estat == true && estat2 == true) {
			System.out.println("El gasoducte 1 y el gasoducte 2, estan tancats");
		}
		
		if (estat == true && estat2 == false) {
			System.out.println("El gasoducte 1 esta tancat y el gasoducte 2 esta obert");
		}
		
		if (estat == false && estat2 == true) {
			System.out.println("El gasoducte 1 esta obert y el gasoducte 2 esta tancat");
		}
		
		if (estat == false && estat2 == false) {
			if (quantitatGas < 90000) {
				System.out.println("El gasoducte 1 esta obert y el gasoducte 2 esta tancat");
			}
			if (quantitatGas >= 90000) {
				System.out.println("El gasoducte 1 esta obert y el gasoducte 2 esta obert");
			}
		}
			
		// Exercici 2
		
		int convidat = 1;
		
		Scanner entrada4 = new Scanner(System.in);
		System.out.println("Introdueix la quantitat de convidats: ");
		int convidats = entrada4.nextInt();
		
		Scanner entrada5 = new Scanner(System.in);
		System.out.println("Introdueix la quantitat de panellets: ");
		int panellets = entrada5.nextInt();
		
		Scanner entrada6 = new Scanner(System.in);
		System.out.println("Introdueix la quantitat de castanyes: ");
		int castanyes = entrada6.nextInt();
		
		int castanyes_min = convidat * 3;
		int panellets_min = convidat * 2;
		
		int num_castanyes = convidats / castanyes;
		int num_panellets = convidats / panellets;
		
		int falta_castanyes = panellets_min - num_castanyes;
		int falta_panellets = castanyes_min - num_panellets;
	
		
		System.out.println(+convidats+ " convidats " +num_panellets+ " panellets " +num_castanyes+ " castanyes ");
		
		// Exercici 3
		
		int hora = 1;
		
		Scanner entrada7 = new Scanner(System.in);
		System.out.println("Introdueix la quantitat de radiacio inicial: ");
		double radiacioInicial = entrada7.nextDouble();
		
		Scanner entrada8 = new Scanner(System.in);
		System.out.println("Introdueix la quantitat de d'hores: ");
		int hores = entrada8.nextInt();
		
		if (hores == 1) {
			System.out.println("Radiacio Inicial: " +radiacioInicial);
			System.out.println("Hores: " +hora);
			System.out.println("Resultat ultima hora: " +radiacioInicial+ " Sieverts/hora");
			
		}else {
			while (hora<hores) {
				hora++;
				radiacioInicial = radiacioInicial - (0.01 * hora);
			}
		System.out.println("Radiacio Inicial: " +radiacioInicial);
		System.out.println("Hores: " +hores);
		System.out.println("Resultat ultima hora: " +radiacioInicial+ " Sieverts/hora");
	}	
		
		// Exercici 4
		
		Scanner entrada9 = new Scanner(System.in);
		System.out.println("Introdueix la mida: ");
		int mida = entrada9.nextInt();
		
		for(int i = 1; i<mida; i++) {
			
			System.out.print("*");
			}
		
		for(int j = 1; j<mida; j++) {
			System.out.println("*");
			}
		
		for(int k = 0; k<mida; k++) {
			System.out.print("*");
			}
	}
}
