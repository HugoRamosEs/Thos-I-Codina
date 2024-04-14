package figures;

/**
 * Representa un Pentagon, fill de la classe PoligonRegular.
 * 
 * @author Hugo Ramos
 */
public class Pentagon extends PoligonRegular {

	// CONSTRUCTORS
	
	/**
	 * Construiex un objecte Quadrat, que conté tots els métodes de la classe PoligonRegular. Només rep la longitud dels costats.
	 * El número de costats esta fixat a 5.
	 * 
	 * @param longitudCostats Representa la longitud d'un dels costats.
	 */
	public Pentagon(double longitudCostats) {
		super(5, longitudCostats);
	}
}
