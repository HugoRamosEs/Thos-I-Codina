package figures;

/**
 * Representa un PoligonRegular, fill de la classe Figura, que té com atributs el numero de costats i la longitud d'aquests.
 * Inclou dos métodes que permeten calcular l'area i el perimetre de qualsevol poligon regular.
 * 
 * @author Hugo Ramos
 */
public class PoligonRegular extends Figura {
	// ATRIBUTS
	
	/**
	 * Representa l'atribut de numero de costats que te el poligon regular.
	 */
	private int numeroCostats;
	
	/**
	 * Representa la longitud d'un dels costats.
	 */
	private double longitudCostats;
	
	// CONSTRUCTORS
	
	/**
	 * Construeix un objecte PoligonRegular que te com atributs el numero de costats introduits per l'usuari i la longitud d'aquests.
	 * 
	 * @param numeroCostats Es el numero de costats que te el poligon regular.
	 * @param longitudCostats Es la longitud dels costats del poligon.
	 */
	public PoligonRegular(int numeroCostats, double longitudCostats) {
		this.numeroCostats = numeroCostats;
		this.longitudCostats = longitudCostats;
	}
	
	// MÉTODES
	
	/**
	 * Calcula l'area d'un poligon regular.
	 */
	public double calculaArea() {
		return (numeroCostats * (Math.pow(longitudCostats, 2))) / (4 * Math.tan(180/numeroCostats));
	}
	
	/**
	 * Calcula el perimetre d'un poligon regular.
	 */
	public double calculaPerimetre() {
		return numeroCostats * longitudCostats;
	}
	
	// GETTERS I SETTERS
	
	/**
	 * Getter, permet agafar el numero de costats d'un objecte PoligonRegular.
	 * 
	 * @return El numero de costats
	 */
	public int getNumeroCostats() {
		return numeroCostats;
	}
	
	/**
	 * Getter, permet agafar la longitud dels cotats d'un objecte PoligonRegular.
	 * 
	 * @return La longitud dels costats
	 */
	public double getLongitudCostats() {
		return longitudCostats;
	}
	
	/**
	 * Setter, Permet modificar el valor de l'atribut numeroCostats.
	 * 
	 * @param numeroCostats El valor del numeroCostats introduit per l'usuari.
	 */
	public void setNumeroCostats(int numeroCostats) {
		this.numeroCostats = numeroCostats;
	}
	
	/**
	 * Setter, Permet modificar el valor de l'atribut longitudCostats.
	 * 
	 * @param longitudCostats El valor del longitudCostats introduit per l'usuari.
	 */
	public void setLongitudCostats(double longitudCostats) {
		this.longitudCostats = longitudCostats;
	}	
}
