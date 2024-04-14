/*
1- Crea un mètode NO static amb identificador misteri que calculi la següent definició recursiva:
misteri(n, m):
    1            si n<=0  o  m<n
    misteri(n-2, m/n)+m    si n>0 i n<30 i m<50
    misteri(n/2, m)+m/7    si n>0 i  (n>=30 o m>=50)
 
Exemples de resultat:
misteri(23, 47) → 48.0
misteri(41, 76) → 11726.71
 
2- Crea un mètode NO static amb identificador correu. Aquest mètode modificarà un String substituint les adreces de correu que contingui per la mateixa adreça en minúscules, no modificarà altres paraules (suposarem que si una paraula conté una ‘@’, és una adreça). Tindrà un paràmetre de tipus String que contindrà una frase. Retornarà un altre String que serà igual a l’original però amb els canvis a minúscules indicats.
Per exemple:
"Aquest investigadors han de rebre les entrades al XXV P.I. World Congress: Holmes@gmail.com house@GMAIL.com PoiRoT@gmail.com mARLOWE@gmail.COM"
Retorna:
"Aquest investigadors han de rebre les entrades al XXV P.I. World Congress: holmes@gmail.com house@gmail.com poirot@gmail.com marlowe@gmail.com"
 
3- Crea un mètode matricula que faci la recerca d’un vehicle en un array de vehicles. Cada Vehicle serà un objecte que tindrà 3 atributs: marca, model i matrícula. El mètode tindrà 2 paràmetres, el primer serà un array de Vehicle, el segon serà la matrícula que volem trobar. El mètode retornarà el Vehicle amb la matrícula indicada o null. No ha de fer cap print per consola.
Per exemple:
array: 
("seat","leon","2018XML"),("porsche","911","9999CSV"),("ferrari","portofino","0001SQL")
matricula: "2018XML"    retorna objecte ("seat","leon","2018XML")
matrícula: "6185PHP"    retorna null.
 
4- Realitza un mètode amb identificador primeraRepetida. Aquest mètode tindrà un paràmetre de tipus String que conté una frase. El mètode haurà de determinar quantes vegades es repeteix la primera paraula dins de la frase, la comparació ha de ser indiferent de les majúscules i minúscules, per exemple "la", "La" i "LA" es compten com repetides. Suposarem que no es fan servir accents. Retornarà la quantitat calculada.
Exemples:
"Un pequeño paso para el hombre, un gran salto para la humanidad" →  2
"Tres tristes tigres comian trigo en tres tristes platos, sentados en un trigal. Sentados en un trigal, en tres tristes platos, comian trigo tres tristes tigres."  → 4
"Somos sentimientos y tenemos seres humanos"  → 1
 
*/

import java.util.*;

public class UF2Practica6 {
	/**
	 * misteri(n, m):
	    1            si n<=0  o  m<n
	    misteri(n-2, m/n)+m    si n>0 i n<30 i m<50
	    misteri(n/2, m)+m/7    si n>0 i  (n>=30 o m>=50)
	
	 */
	
	public double misteri(double n, double m) {
		double resultat = 0;
		
		if (n <= 0 || m < n) {
			resultat = 1;
		}
		
		if (n>0 && n<30 && m<50) {
			resultat = misteri(n-2, m/n) + m;
		}
		
		if (n>0 && (n>=30 || m>=50)) {
			resultat = misteri(n/2, m) + m/7;
		}
		
		return resultat;
	}
	
	public static void main(String[] args) {
		UF2Practica6 programa = new UF2Practica6();
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+                     EJERCICIO 1                     +\n"
		+ "+-----------------------------------------------------+\n");
		
		System.out.println("Introduce un valor para n: ");
		double n = entrada.nextInt();
		
		System.out.println("Introduce un valor para m: ");
		double m = entrada.nextInt();
		
		System.out.println(programa.misteri(n, m));
	}
}
