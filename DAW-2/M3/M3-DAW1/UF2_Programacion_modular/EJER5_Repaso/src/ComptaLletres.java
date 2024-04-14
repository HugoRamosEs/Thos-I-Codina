/*
 
Crea un mètode recursiu comptaLletres que realitzi el càlcul 
indicat a la següent definició:
 
comptaLletres(frase):
 si longitud de frase==0    retorna 0
 si primer caràcter és lletra   retorna 1+comptaLletres(substring(1))
 si primer caràcter NO és lletra   retorna comptaLletres(substring(1))
 
Exemples:
si frase és "" retorna 0
si frase és "the quick brown fox jumps over 12 dogs" retorna 29
si frase és "tienes 123 euros con 10 centimos" retorna 22
 
*/



public class ComptaLletres {
	
	public static int comptaLletres (String frase) {
		int contador = 0;
		
		if (frase.length() == 0) {
			contador = 0;
		}
			
		if (Character.isLetter(frase.charAt(0))) {
			contador = 1+comptaLletres(frase.substring(1));
		}
		
		contador = comptaLletres(frase.substring(1));
		
		return contador;
	}
	
	public static void main(String[] args) {
		
	}
}
