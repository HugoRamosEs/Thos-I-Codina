/*
1- Crea un mètode amb identificador quantitatParaules que retorni la quantitat 
de paraules que té un String passat per paràmetre. Es considera que una paraula 
ha de contenir alguna lletra. Si tots els caràcters d’una paraula són dígits 
aleshores seria un nombre enter.
Exemples:
hola, bon dia!  -->>  ha de retornar 3
espera 10 minuts   -->>  ha de retornar 2
ufff, el càlcul-3R dona 314 no 5236  -->>  ha de retornar 5
 
2- Crea un mètode amb identificador claror que determini el percentatge de 
claror en un array de dues dimensions. L’array contindrà caràcters espai '  ' o 
asteric '*', es tracta de determinar el percentatge que representen els espais. 
Tindrà un paràmetre de tipus array de dues dimensions de char i retornarà el 
percentatge calculat. El percentatge s'obté dividint el total d’espais entre 
el total de caselles i multiplicant per 100.
Exemple:
Array de 5 x 11
**  **  ***
***********
*     *** *
 ** ***** *
   *** *   
Retorna: 36,36 %
 
3- Crea un mètode NO static amb identificador separa que tindrà tres paràmetres, 
que seran tres arrays d’String. El primer paràmetre contindrà paraules diverses, 
algunes començaran amb majúscula i altres en minúscula. El segon paràmetre serà 
un array d’String de la mateixa longitud que el primer a on guardarem paraules 
en minúscules i el tercer servirà per guardar les paraules en majúscules.
El mètode haurà de fer un recorregut de totes les paraules del primer array i 
separar-les en funció de la primera lletra. Si comença en minúscula haurà de 
convertir tota la paraula a minúscula i guardar-la en l’array de minúscules, 
si comença en majúscula haurà de convertir tota la paraula a majúscules i 
guardar-la a l’array de majúscules. Si comença amb un altre caràcter que no és 
ni majúscula ni minúscula aleshores no ha de fer res amb la paraula. 
El mètode retornarà la quantitat de paraules que ha separat.
Per exemple:
Array de paraules inicial "prova" "Total" "2fast4you" "¡peligro!" "fALLAS" "Padre"
El mètode retornarà 4.
Els arrays quedaran de la següent manera.
Array amb minúscules  "prova" "fallas" null null null null
Array amb majúscules  "TOTAL" "PADRE" null null null null
 
4- Per a fer un programa de mots encreuats ens fa falta un mètode que 
ens indiqui si dos mots tenen alguna lletra comú que permeti fer 
un encreuament. Crea un mètode encreuats que donats dos String passats 
per paràmetre ens retorni true si hi ha alguna lletra comú o 
retorni false si no n'hi ha cap. Suposarem que sempre tenim totes 
les lletres en minúscules o totes en majúscules.
Exemples:
ARMARI   ESTANT   →  true
APPLE  MICROSOFT  →  false
 
5- Crea un mètode amb identificador prohibit que permeti sapiguer si 
un panell de leds indica pas prohibit. El mètode tindrà un paràmetre 
de tipus array de char de dues dimensions, aquest array representa 
els leds del panell. Un char '*' indica led actiu i un ' ' indica led apagat.
El mètode retornarà true si el panell indica pas prohibit amb una X, 
en altre cas retornarà false.
El mètode ha de funcionar amb qualsevol mida d’array.
Exemples:// TODO Auto-generated method stub
Array:
'*', ' ', ' ', ' ', '*'
' ', '*', ' ', '*', ' '
' ', ' ', '*', ' ', ' '
' ', '*', ' ', '*', ' '
'*', ' ', ' ', ' ', '*' 
retorna true
 
Array:
'*', ' ', ' ', ' '
' ', '*', ' ', '*'
' ', ' ', '*', ' '
' ', '*', ' ', '*'
retorna false
 
 */

public class UF2Practica5 {
	boolean EsParaula(String operando) {
        for (int i=0; i<operando.length(); i++) {
            if (Character.isLetter(operando.charAt(i))) return true;
        }
        return false;
    }
	
	public int quantitatParaules (String frase) {
		int contador = 0;
		
		if (frase == null) {
			contador = 0;
		}
		
		String paraules[] = frase.split(" ");
		
		for (int i=0; i<paraules.length; i++) {
			if (EsParaula(paraules[i])) {
				contador++;
			}
		}
		
		return contador;
	}
	
	
	
	public static void main(String[] args) {
		

	}

}
