package escacs;

public class Main {

	public static void main(String[] args) {
		// PREGUNTA 2
			// No es pot reedefinir el metode getClass() de la clase Object, perque es de tipus final.
		
		// PREGUNTA 4
			// Tauler
		Tauler tauler = new Tauler();
		
			// PECES BLANQUES
		Peo peoB1 = new Peo(Color.BLANC);
		Peo peoB2 = new Peo(Color.BLANC);
		Peo peoB3 = new Peo(Color.BLANC);
		Peo peoB4 = new Peo(Color.BLANC);
		Peo peoB5 = new Peo(Color.BLANC);
		Peo peoB6 = new Peo(Color.BLANC);
		Peo peoB7 = new Peo(Color.BLANC);
		Peo peoB8 = new Peo(Color.BLANC);
		Cavall cavallB1 = new Cavall(Color.BLANC);
		Cavall cavallB2 = new Cavall(Color.BLANC);
		Alfil alfilB1 = new Alfil(Color.BLANC);
		Alfil alfilB2 = new Alfil(Color.BLANC);
		Torre torreB1 = new Torre(Color.BLANC);
		Torre torreB2 = new Torre(Color.BLANC);
		Rei reiB1 = new Rei(Color.BLANC);
		Reina reinaB1 = new Reina(Color.BLANC);
		
		tauler.addBlanques(peoB1);
		tauler.addBlanques(peoB2);
		tauler.addBlanques(peoB3);
		tauler.addBlanques(peoB4);
		tauler.addBlanques(peoB5);
		tauler.addBlanques(peoB6);
		tauler.addBlanques(peoB7);
		tauler.addBlanques(peoB8);
		tauler.addBlanques(cavallB1);
		tauler.addBlanques(cavallB2);
		tauler.addBlanques(alfilB1);
		tauler.addBlanques(alfilB2);
		tauler.addBlanques(torreB1);
		tauler.addBlanques(torreB2);
		tauler.addBlanques(reiB1);
		tauler.addBlanques(reinaB1);
		
			// PECES NEGRES
		Peo peoN1 = new Peo(Color.NEGRE);
		Peo peoN2 = new Peo(Color.NEGRE);
		Peo peoN3 = new Peo(Color.NEGRE);
		Peo peoN4 = new Peo(Color.NEGRE);
		Peo peoN5 = new Peo(Color.NEGRE);
		Peo peoN6 = new Peo(Color.NEGRE);
		Peo peoN7 = new Peo(Color.NEGRE);
		Peo peoN8 = new Peo(Color.NEGRE);
		Cavall cavallN1 = new Cavall(Color.NEGRE);
		Cavall cavallN2 = new Cavall(Color.NEGRE);
		Alfil alfilN1 = new Alfil(Color.NEGRE);
		Alfil alfilN2 = new Alfil(Color.NEGRE);
		Torre torreN1 = new Torre(Color.NEGRE);
		Torre torreN2 = new Torre(Color.NEGRE);
		Rei reiN1 = new Rei(Color.NEGRE);
		Reina reinaN1 = new Reina(Color.NEGRE);
		
		tauler.addNegres(peoN1);
		tauler.addNegres(peoN2);
		tauler.addNegres(peoN3);
		tauler.addNegres(peoN4);
		tauler.addNegres(peoN5);
		tauler.addNegres(peoN6);
		tauler.addNegres(peoN7);
		tauler.addNegres(peoN8);
		tauler.addNegres(cavallN1);
		tauler.addNegres(cavallN2);
		tauler.addNegres(alfilN1);
		tauler.addNegres(alfilN2);
		tauler.addNegres(torreN1);
		tauler.addNegres(alfilN2);
		tauler.addNegres(reiN1);
		tauler.addNegres(reinaN1);
		
		tauler.generarTauler();
		System.out.println(tauler.toString());
	}
}
