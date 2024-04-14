package figures;

/**
 * Representa un Quadrat, fill de la classe Rectangle.
 * 
 * @author Hugo Ramos
 */
public class Quadrat extends Rectangle {
	// CONSTRUCTORS
	
	/**
	 * Construiex un objecte Quadrat, que conté tots els métodes de la classe rectangle. Només rep la longitud dels costats.
	 * El número de costats esta fixat a 4, perque es fill de la classe Rectangle.
	 * 
	 * @param costat Representa la longitud d'un dels costats.
	 */
	public Quadrat(double costat) {
		super(costat, costat);
	}
}
