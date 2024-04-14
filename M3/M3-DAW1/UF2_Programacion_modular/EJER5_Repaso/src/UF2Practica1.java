/*
1- Crea una class Esqui per definir una estació d’esquí. 
Aquesta class ha de permetre guardar les següents dades de cada 
estació d’esquí: nom, altitud, quantitat de remuntadors, 
quantitat de pistes, preu forfait/dia
Crea un constructor en aquesta classe que permeti passar per 
paràmetre les dades necessàries.
Crea un array de tipus Esqui, anomenat estacions, al main 
d’una class UF2Practica1 amb les següents dades:
estacions:
    "LaMolina"      1600    29  67  50
    "Vallter2000"   2000    3   6   30  
    "GrandValira"   2200    40  112 55
    "Baqueira"      1800    39  85  60  
 
2- Crea un mètode costTotal amb dos paràmetres, un de tipus Esqui i 
un altre de tipus int que representa la quantitat de dies esquiant. 
El mètode ha de calcular el cost total tenit en compte el preu del 
forfait/dia i la quantitat de dies. Es retornarà un double amb el resultat.
Exemple:
Estació "Baqueira"  1800 39 85 60
dies  4
costTotal  240
 
3- Crea un mètode mespetita amb un paràmetre de tipus array d’Esqui, que 
retorni l’objecte Esqui d’aquest array amb la quantitat més petita de remuntadors.
 
4-  Crea un mètode totals amb un paràmetre de tipus array d’Esqui, que 
retorni la suma d’algunes característiques de les estacions d’esquí de 
l’array. Ha de retornar un objecte amb la següent informació: 
quantitat d’estacions, suma de totes les pistes i suma total de remuntadors.
 
5- Crea un mètode troba amb dos paràmetres, un paràmetre de tipus 
array d’Esquí amb totes les estacions i un altre de tipus int amb una altitud. 
El mètode ha de retornar una estació d’esquí que tingui una altitud 
més gran o igual a la indicada pel paràmetre, en cas de que no existeixi 
ha de retornar null.
 
6- Crea un mètode menu que mostri un menú d’opcions i a continuació 
llegeixi de teclat l’opció escollida i faci una crida als mètodes corresponents. 
El mètode menu retornarà l'opció escollida. Afegeix al main un bucle per 
fer crides al mètode menu fins que escollim l'opció Finalitza. 
Farem servir l’array creat a la pregunta 1.
Opcions
    1-Cost a l’estació més petita.  → Demana per teclat una quantitat de dies i 
      mostra quin és el cost d’aquests dies a l’estació més petita.
    2-Totals. → Mostra els totals de totes les estacions.
    3-Mostra estació. → Demana per teclat una altitud i mostra una estació amb 
      altitud igual o superior. Si no existeix ha de mostrar 
      el missatge «INEXISTENT».
    4-Finalitza  → acaba
 
 */

import java.util.*;
import java.io.*;

class Esqui {
	String nom;
	double altitud;
	int remuntadors;
	int pistes;
	double forfait;

	Esqui() {

	}

	Esqui(String nom, double altitud, int remuntadors, int pistes, double forfait) {
		this.nom = nom;
		this.altitud = altitud;
		this.remuntadors = remuntadors;
		this.pistes = pistes;
		this.forfait = forfait;
	}

	public String toString() {
		return "Esqui: " + this.altitud + this.remuntadors + this.pistes + this.forfait;
	}

}

class Comptadors {
	int qestacions;
	int qpistes;
	int qremuntadors;
}

public class UF2Practica1 {

	public double costTotal(Esqui esqui, int dies) {
		double cost = esqui.forfait * dies;
		return cost;
	}

	public Esqui mespetita(Esqui[] esquis) {
		Esqui petit = esquis[0];

		for (int i = 0; i < esquis.length; i++) {
			if (petit.remuntadors < esquis[i].forfait) {
				petit = esquis[i];
			}
		}
		return petit;
	}

	public Comptadors totals(Esqui[] esquis) {
		Comptadors dades = new Comptadors();

		for (int i = 0; i < esquis.length; i++) {
			dades.qpistes = dades.qpistes + esquis[i].pistes;
			dades.qremuntadors = dades.qremuntadors + esquis[i].remuntadors;
			dades.qestacions++;
		}
		return dades;
	}

	public Esqui troba(Esqui[] esquis, double altitud) {
		for (int i = 0; i < esquis.length; i++) {
			if (esquis[i].altitud > altitud) {
				return esquis[i];
			}
		}
		return null;
	}

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		System.out.printf("+-----------------------------------------------------+\n"
				+ "+                     EJERCICIO 1                     +\n"
				+ "+-----------------------------------------------------+\n");

		Esqui estacions[] = { new Esqui("LaMolina", 1600, 29, 67, 50), new Esqui("Vallter2000", 2000, 3, 6, 30),
				new Esqui("GrandValira", 2200, 40, 112, 55), new Esqui("Baqueira", 1800, 39, 85, 60) };

	}

}
