/*
Crea un fitxer Practica1.java i inclou tots els exercicis següents.
Indica amb un comentari a on comença cada exercici. 
Tots els mètodes han d’incloure el seu javadoc. 
S’han de fer crides als mètodes des del main, fent print del resultat en el main.
 
1-
a) Crea una class Sancio per definir les sancions econòmiques i comercials
que l’ONU aplica als països que no compleixen les seves resolucions. 
Els atributs seran: nom del país, nom persona o organització, data inici, import estimat.
b) Afegeix un constructor a la class i crea un array, amb dades inventades, al 
main de la class Practica1.
Exemple d’una Sancio:  «Transsilvània», «Vlad Tepes», 1/1/2000, 99000000.
 
2- Crea un mètode sumaSancions que tindrà dos paràmetres, un nom de país i 
un array de Sancio. Aquest mètode ha de retornar la suma dels imports 
estimats de totes les sancions del país indicat. Fes una crida al mètode des del main. 
Crea el javadoc.
 
3-Crea un mètode mesAlt (NO STATIC), que trobi l’índex de contagi COVID més alt
de tots els guardats en un array. L’array s’ha de definir al main de la 
class Practica1 i passar-lo per paràmetre al mètode. 
Exemple de dades de l’array: 120.6, 78.9, 1234.8, 12.0, 0, 456.8, 2345.7, 23.8
Fes una crida al mètode des del main. Crea el javadoc.
 
4- Defineix la class IPC següent:
class IPC {
   double mensual;         //  % mensual
   double interanual;      //  %  interanual
   int mes;
   int any;
}
Crea un array de IPC al main amb dades inventades.
Dades exemple:
0.8, 7.6, 2, 2022
-0.4, 6.1, 1, 2022
1.2, 6.5, 12, 2021
0.3, 5.5, 11, 2021
1.8, 5.4, 10, 2021
0.8, 4.0, 9, 2021
0.5, 3.3, 8, 2021
-0.8, 2.9, 7, 2021
0.5, 2.7, 6, 2021
0.5, 2.7, 5, 2021
1.2, 2.2, 4, 2021
1.0, 1.3, 3, 2021
-0.6, 0.0, 2, 2021
0.0, 0.5, 1, 2021
 
Crea un mètode mitjanaMensual amb dos paràmetres, el primer paràmetre és un any
i el segon és un array de IPC. El mètode ha de retornar la mitjana dels valors 
mensuals de l’any indicat. Fes una crida al mètode des del main. Crea el javadoc.
NOTA: La mitjana és la suma de tots els valors dividida per la quantitat de valors.
Exemple de mitjana:  5, 6, 8, 2, 3  → 24/5 → 4.8
 
*/

import java.util.Scanner;

class Data{
	int dia;
	int mes;
	int año;
	
	Data(int d, int m, int a){
		dia = d;
		mes = m;
		año = a;
	}
	
	Data(String data){
		String partes[]=data.split("/");
		dia=Integer.parseInt(partes[0]);
		mes=Integer.parseInt(partes[1]);
		año=Integer.parseInt(partes[2]);
	}
	
	public String toString() {
		return dia+"/"+mes+"/"+año;
	}
}

class Sancio{
	String nomPais;
	String nomPersona;
	Data dataInici;
	double importEstimat;
	
	Sancio(){
		
	}
	
	Sancio(String nPais, String nPer, Data dataI, double iEst){
		nomPais = nPais;
		nomPersona = nPer;
		dataInici = dataI;
		importEstimat = iEst;
	}
}

class IPC {
	   double mensual;         //  % mensual
	   double interanual;      //  %  interanual
	   int mes;
	   int any;
	   
	   IPC(){
		   
	   }
	   
	   IPC(double men, double i, int mes, int a){
		   mensual = men;
		   interanual = i;
		   this.mes = mes;
		   any = a;
	   }
}

public class CursosAnteriors {
	
	public static double sumaSancions(String nomPais, Sancio sancions[]) {
		double suma = 0;
		
		for (int i=0; i<sancions.length; i++) {
			if (nomPais.equals(sancions[i].nomPais)) {
				suma = suma + sancions[i].importEstimat;
			}
		}
		return suma;
	}
	
	public double mesAlt(double covid[]) {
		double mAlt = 0;
		for (int i=0; i<covid.length; i++) {
			if(mAlt < covid[i]) {
				mAlt = covid[i];
			}
		}
		return mAlt;
	}
	
	public double mitjanaMensual(int any, IPC dades[]) {
		double mitjana = 0;
		int contador = 0;
		
		for (int i=0; i<dades.length; i++) {
			if (any == dades[i].any) {
				mitjana = mitjana + dades[i].mensual;
				contador ++;
			}
			
		}
		mitjana = mitjana / contador;
		return mitjana;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CursosAnteriors programa = new CursosAnteriors();
		
		Scanner entrada = new Scanner(System.in);
		
		Sancio[] sancions = {
				new Sancio("Espanya", "Alex", new Data("10/02/2023"), 300.3),
				new Sancio("Francia", "Franchesco", new Data("01/01/1999"), 7199.99),
				new Sancio("Japon", "Nishida", new Data("23/08/1956"), 500.2),
				new Sancio("Espanya", "Hugo", new Data("02/07/2013"), 600.6),
				new Sancio("Francia", "Laporte", new Data("02/02/1890"), 6542.99),
				new Sancio("Japon", "Levi", new Data("03/03/1924"), 8000.2),
		};
		
		System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+                     EJERCICIO 2                     +\n"
		+ "+-----------------------------------------------------+\n");
		
		System.out.println("Entra el pais: ");
		String pais = entrada.nextLine();
		double suma = sumaSancions(pais, sancions);
		System.out.println("Import Sumat: " +suma);
		
		System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+                     EJERCICIO 3                     +\n"
		+ "+-----------------------------------------------------+\n");
		
		double [] covid =  {120.6, 78.9, 1234.8, 12.0, 0, 456.8, 2345.7, 23.8};
		System.out.println("Index de contagi mes alt: " +programa.mesAlt(covid));
		
		System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+                     EJERCICIO 4                     +\n"
		+ "+-----------------------------------------------------+\n");
		
		IPC[] dades = {
				new IPC(0.8, 7.6, 2, 2022),
				new IPC(-0.4, 6.1, 1, 2022),
				new IPC(1.2, 6.5, 12, 2021),
				new IPC(0.3, 5.5, 11, 2021),
				new IPC(1.8, 5.4, 10, 2021),
				new IPC(0.8, 4.0, 9, 2021),
		};
		
		System.out.println("Introdueix un any: ");
		int any = entrada.nextInt();
		
		System.out.println("Mitjana: " +programa.mitjanaMensual(any, dades));
		
	}

}
