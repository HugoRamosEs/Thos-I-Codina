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

public class UF2Practica_6 {
	
	public double misteri(double n, double m) {
		double resultado = 0;
		if (n<=0 || m<n) {
			resultado = 1;
		}
		
		if (n>0 && n<30 && m<50) {
			resultado = misteri(n-2, m/n)+m;
		}
		
		if (n>0 && (n>=30 || m>=50)) {
			resultado = misteri(n/2, m)+m/7;
		}
		
		return resultado;
	}
	
	public String correu(String correu) {
		String correuModificat = "";
		String parts [] = correu.split(" ");
		
		for (int i=0; i<parts.length; i++) {
			if (parts[i].contains("@")) {
				correuModificat = correuModificat+parts[i].toLowerCase()+ " ";
			}else {
				correuModificat = correuModificat+parts[i] + " ";
			}
		}
		
		return correuModificat;
	}
	
	public int primeraRepetida(String frase) {
		int contador = 0;
		
		String paraules [] = frase.split(" ");
		String paraulaInicial = paraules[0];
		
		for (int i=0; i<paraules.length; i++) {
			if(paraules[i].equalsIgnoreCase(paraulaInicial)) {
				contador++;
			}
		}
		return contador;
	}
	
	public static void main(String[] args) {
		
		UF2Practica_6 programa = new UF2Practica_6();
		
		System.out.println(programa.misteri(23, 47));
		System.out.println(programa.misteri(41, 76));
	}
	
	
}
