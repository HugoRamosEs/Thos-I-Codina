/**
 * Especifica un comptador que posseeix l'atribut valor, modificable, i dos valors estàtics que indican els límits d'aquest valor.
 * Aquest conté dos mètodes que permeten incrementar o decrementar el valor del comptador, verificant si el valor està dins dels
 * límits.
 * 
 * @author hugo ramos
 *
 */

public class Counter {
	/**
	 * Valor per assignar.
	 */
	private int valor;
	
	/**
	 * Valor mínim que pot pendre l'atribut valor.
	 */
	public static final int MIN = 100;
	
	/**
	 * Valor màxim que pot pendre l'atribut valor.
	 */
	public static final int MAX = 900;
	
	//CONSTRUCTORS
	
	/**
	 * Construeix un nou Counter amb un valor per defecte igual a 100.
	 */
	public Counter() {
		this.valor = 100;
	}
	
	/**
	 * Construeix un nou Counter amb un valor que s'ha d'assignar.
	 * @param valor valor a assignar.
	 */
	public Counter(int valor) {
		this.setValor(valor);
	}
	
	/**
	 * Construeix un nou Counter amb un valor d'altre Counter que ya existeix. Es tracta d'una copia.
	 * @param contador objecte counter a copiar.
	 */
	public Counter(Counter contador) {
		this.valor = contador.valor;
	}
	
	//MÉTODES PROPIS
	
	/**
	 * Incrementa l'atribut valor, d'un objecte Counter, una unitat. A més verifica si es compleix la condició que no ha de ser mínim de 100 ni màxim de 900.
	 */
	public void incrementar() {
		this.setValor(this.valor + 1);
	}
	
	/**
	 * Decrementa l'atribut valor, d'un objecte Counter, una unitat. A més verifica si es compleix la condició que no ha de ser mínim de 100 ni màxim de 900.
	 */
	public void decrementar() {
		this.setValor(this.valor - 1);
	}
	
	// GETTERS I SETTERS
	
	public int getValor() {
		return this.valor;
	}

	public int getMin() {
		return MIN;
	}

	public int getMax() {
		return MAX;
	}

	public void setValor(int pValor) {
		this.valor = pValor;
		if (pValor < MIN) {
			this.valor = MIN;
		}
		
		if (pValor > MAX) {
			this.valor = MAX;
		}
	}
	
	//OVERRIDES
	
	@Override
	public String toString() {
		return "Valor: " + this.valor;
	}
		
}
