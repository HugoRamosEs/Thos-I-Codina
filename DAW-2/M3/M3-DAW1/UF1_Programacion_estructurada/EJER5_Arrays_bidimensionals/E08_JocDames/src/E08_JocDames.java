/*
Realitza un programa que comprovi quantes peces hi han en
un taulell del joc de les dames.
Les peces es representen per valors numèrics:
    0 - casella buida
    1 - peó blanc
    2 - peó negre
    11 - dama blanca
    12 - dama negre
Es tracta de declarar un taulell com un array d'enters de dues dimensions a
on es guardarà quina peça hi ha a cada casella. Si en una casella no hi ha
cap peça aleshores contindrà un zero.
L'array s'ha d'inicialitzar en el codi del programa, no fa falta fer
cap lectura des de teclat.
El programa ha de comptabilitzar quantes peces hi han de cada color i
visualitzar el resultat.
 
Per exemple, aquest seria el taulell a l'inici d'una partida
    1 0 1 0 1 0 1 0
    0 1 0 1 0 1 0 1
    1 0 1 0 1 0 1 0
    0 0 0 0 0 0 0 0
    0 0 0 0 0 0 0 0
    0 2 0 2 0 2 0 2
    2 0 2 0 2 0 2 0
    0 2 0 2 0 2 0 2
 
El resultat seria:
Hi han 12 peces blanques i 12 peces negres.
 
*/

public class E08_JocDames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int taulell[][] = { { 1, 0, 12, 0, 0, 0, 1, 0 }, { 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 1, 0 },
				{ 0, 1, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 2, 0, 2 },
				{ 0, 0, 2, 0, 11, 0, 2, 0 }, { 0, 2, 0, 0, 0, 0, 0, 2 } };

		for (int i = 0; i < taulell.length; i++) {
			for (int j = 0; j < taulell[i].length; j++) {
				System.out.printf("%3d", taulell[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		int blancas = 0;
		int negras = 0;
		
		for (int i=0; i<taulell.length; i++) {
			for (int j = 0; j < taulell[i].length; j++) {
				if (taulell[i][j] == 11) {
					blancas++;
				}
				if (taulell[i][j] == 12) {
					negras++;
				}
			}
		}
		System.out.println("Damas blancas: " +blancas+ " / Damas Negras: " +negras);
	}

}
