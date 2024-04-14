package figures;

/**
 * Representa un Cercle, fill de la classe Figura, que té com atribut el radi. A més disposa de dos métodes que permeten calcular l'area i el perimetre.
 * 
 * @author Hugo Ramos
 */
public class Cercle extends Figura {
	// ATRIBUTS
	
	/**
	 * Representa l'atribut radi d'un cercle.
	 */
	private double radi;
	
	// CONSTRUCTORS
	
	/**
	 * Construeix un objecte Cercle que te com atribut de radi el valor introduit per l'usuari.
	 * 
	 * @param radi Aquest es el valor del radi que asigna l'usuari.
	 */
	public Cercle(double radi) {
		this.radi = radi;
	}
	
	// MÉTODES
	
	/**
	 * Calcula l'area d'un cercle.
	 * 
	 * @return l'area calculada del cercle.
	 */
	public double calculaArea() {
		return Math.PI * Math.pow(radi, 2);
	}
	
	/**
	 * Calcula el perimetre d'un cercle.
	 * 
	 * @return El perimetre calculat del cercle.
	 */
	public double calculaPerimetre() {
		return 2 * Math.PI * radi;
	}
	
	// GETTERS I SETTERS
	
	/**
	 * Getter, permet agafar el valor del radi d'un objecte Cercle.
	 * 
	 * @return L'atribut de radi, es a dir, el valor que conté.
	 */
	public double getRadi() {
		return radi;
	}
	
	/**
	 * Setter, Permet modificar el valor de l'atribut radi.
	 * 
	 * @param radi Valor de radi assignat per l'usuari.
	 */
	public void setRadi(double radi) {
		this.radi = radi;
	}
}
