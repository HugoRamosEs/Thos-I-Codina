package figures;

/**
 * Representa un Rectangle, fill de la classe PoligonRegular, que té com atributs la base (costat1) i l'altura (costat2).
 * Inclou dos métodes que permeten calcular l'area i el perimetre d'un rectangle.
 * 
 * @author Hugo Ramos
 */
public class Rectangle extends PoligonRegular {
	// ATRIBUTS
	
	/**
	 * Representa l'atribut base d'un rectangle.
	 */
	private double costat1;
	
	/**
	 * Representa l'atribut altura d'un rectangle.
	 */
	private double costat2;
	
	// CONSTRUCTORS
	
	/**
	 * Construiex un objecte Rectangle, que conté tots els métodes de la classe PoligonRegular. Rep la longitud de la base i l'altura.
	 * El número de costats esta fixat a 4.
	 * 
	 * @param costat1 És la base d'un rectangle, asignada per l'usuari.
	 * @param costat2 És l'altura d'un rectangle, asignada per l'usuari.
	 */
	public Rectangle(double costat1, double costat2) {
		super(4, costat1);
		this.costat1 = costat1;
		this.costat2 = costat2;
	}
	
	// MÉTODES
	
	/**
	 * Calcula l'area d'un rectangle.
	 */
	public double calculaArea() {
		return costat1 * costat2;
	}
	
	/**
	 * Calcula el perimetre d'un rectangle.
	 */
	public double calculaPerimetre() {
		return (costat1 * 2) + (costat2 * 2);
	}

	
	// GETTERS I SETTERS
	
	/**
	 * Getter, permet agafar el valor de la base d'un objecte Rectangle.
	 * 
	 * @return La longitud base del rectangle.
	 */
	public double getCostat1() {
		return costat1;
	}
	
	/**
	 * Getter, permet agafar el valor de l'altura d'un objecte Rectangle.
	 * 
	 * @return La longitud de l'altura del rectangle.
	 */
	public double getCostat2() {
		return costat2;
	}
	
	/**
	 * Setter, Permet modificar el valor de l'atribut costat1 (base).
	 * 
	 * @param costat1 Valor de la base, assignat per l'usuari.
	 */
	public void setCostat1(double costat1) {
		this.costat1 = costat1;
	}
	
	/**
	 * Setter, Permet modificar el valor de l'atribut costat2 (altura).
	 * 
	 * @param costat2 Valor de l'altura, assignat per l'usuari.
	 */
	public void setCostat2(double costat2) {
		this.costat2 = costat2;
	}
}
