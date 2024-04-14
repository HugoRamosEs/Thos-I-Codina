package figures;

/**
 * Es la classe pare de totes les classes que conformen una figura geometrica. Aquesta conta amb dos métodes per calcular l'area i perimetres dels objectes fills.
 * 
 * @author Hugo Ramos
 */
public class Figura {
	// MÉTODES
	
	/**
	 * Métode per calcular l'area d'una figura geometrica.
	 * 
	 * @return 0
	 */
	public double calculaArea() {
		return 0;
	}
	
	/**
	 * Métode per calcular el perimetre d'una figura geometrica.
	 * 
	 * @return 0
	 */
	public double calculaPerimetre() {
		return 0;
	}
	
	@Override
	public String toString() {
		return "Area: " +calculaArea() + " / Perimetre: " +calculaPerimetre();
	}
}
