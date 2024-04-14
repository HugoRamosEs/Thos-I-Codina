package figures;

/**
 * Representa una Corona, fill de la classe Cercle, que té com atributs dos objectes Cercle.
 * 
 * @author Hugo Ramos
 */
public class Corona extends Cercle {
	// ATRIBUTS
	
	/**
	 * Representa un objecte cercle, que actua com a cercle interior.
	 */
	private Cercle cercleExterior;
	
	/**
	 * Representa un objecte cercle, que actua com a cercle exterior.
	 */
	private Cercle cercleInterior;
	
	// CONSTRUCTORS
	
	/**
	 * Construeix un objecte Corona que te com atributs els radis de dos objectes Cercle, introduits per l'usuari, 
	 * generant aixi dos objectes Cercle amb el seu radi corresponent. Al ser fill de la classe Cercle, agafa tots 
	 * els metodes, atributs, getters i setters d'aquesta.
	 * 
	 * @param radiExterior Aquest es el valor del radi del cercle exterior que asigna l'usuari.
	 * @param radiInterior Aquest es el valor del radi del cercle interior que asigna l'usuari.
	 */
	public Corona(double radiExterior, double radiInterior) {
		super(radiExterior);
		this.cercleExterior = new Cercle(radiExterior);
		this.cercleInterior = new Cercle(radiInterior);
	}
	
	// MÉTODES
	
	/**
	 * Agafa el valor del radi del cercle exterior.
	 * 
	 * @return el radi del cercle exterior, asignat per l'usuari.
	 */
	public double getRadiExterior(){
		return cercleExterior.getRadi();
	}
	
	/**
	 * Agafa el valor del radi del cercle interior.
	 * 
	 * @return el radi del cercle interior, asignat per l'usuari.
	 */
	public double getRadiInterior(){
		return cercleInterior.getRadi();
	}
	
	/**
	 * Calcula l'area d'una corona.
	 */
	public double calculaArea() {
		return cercleExterior.calculaArea() - cercleInterior.calculaArea();
	}
	
	/**
	 * Calcula el perimetre d'una corona.
	 */
	public double calculaPerimetre() {
		return cercleExterior.calculaPerimetre() + cercleInterior.calculaPerimetre();
	}
	
	// GETTERS I SETTERS
	
	/**
	 * Getter, permet agafar l'objecte cercleExterior d'un objecte Corona.
	 * 
	 * @return L'objecte cercleExterior d'una Corona.
	 */
	public Cercle getCercleExterior() {
		return cercleExterior;
	}
	
	/**
	 * Getter, permet agafar l'objecte cercleInterior d'un objecte Corona.
	 * 
	 * @return L'objecte cercleInterior d'una Corona.
	 */
	public Cercle getCercleInterior() {
		return cercleInterior;
	}
	
	/**
	 * Setter, Permet modificar l'objecte cercleExterior d'un objecte Corona.
	 * 
	 * @param cercleExterior Objeto circuloExterior.
	 */
	public void setCercleExterior(Cercle cercleExterior) {
		this.cercleExterior = cercleExterior;
	}
	
	/**
	 * Setter, Permet modificar l'objecte cercleInterior d'un objecte Corona.
	 * 
	 * @param cercleInterior Objeto circuloInterior.
	 */
	public void setCercleInterior(Cercle cercleInterior) {
		this.cercleInterior = cercleInterior;
	}
}
