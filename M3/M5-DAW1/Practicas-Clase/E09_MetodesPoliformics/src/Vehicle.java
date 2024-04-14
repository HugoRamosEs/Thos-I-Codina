/**
 * Es la classe pare de totes les classes que conformen un tipus de vehicle. Aquesta conta amb un métode 
 * per asginar el preu de compra dels objectes fills.
 * 
 * @author Hugo Ramos
 */
public class Vehicle {
	/**
	 * Atribut matricula del Vehicle.
	 */
	private String matricula;
	
	/**
	 * Atribut numero de rodes del Vehicle.
	 */
	private int numeroDeRodes;
	
	/**
	 * Construeix un objecte Vehicle amb les dades introduides per l'usuari.
	 * 
	 * @param matricula Asigna la matricula introduida per l'usuari a l'objecte.
	 * @param numeroDeRodes Asigna el número de rodes introduit per l'usuari a l'objecte.
	 */
	public Vehicle(String matricula, int numeroDeRodes) {
		this.matricula = matricula;
		this.numeroDeRodes = numeroDeRodes;
	}
	
	/**
	 * Obté el cost de la compra d'un Vehicle.
	 * 
	 * @return 33000
	 */
	public int obtenirCostCompra() {
		return 33000;
	}
	
	/**
	 * Getter, permet agafar la matricula asignada al Vehicle.
	 * 
	 * @return La matricula del Vehicle.
	 */
	public String getMatricula() {
		return this.matricula;
	}
	
	/**
	 * Getter, permet agafar el numero de rodes asignat al Vehicle.
	 * 
	 * @return El nombre de rodes del Vehicle.
	 */
	public int getNumeroDeRodes() {
		return this.numeroDeRodes;
	}
	
	/**
	 * Setter, permet modificar el valor de l'atribut matricula.
	 * 
	 * @param matricula Atribut matricula del Vehicle, asignat per l'usuari.
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	/**
	 * Setter, permet modificar el valor de l'atribut numeroDeRodes.
	 * 
	 * @param numeroDeRodes Atribut número de rodes del Vehicle, asignat per l'usuari.
	 */
	public void setNumeroDeRodes(int numeroDeRodes) {
		this.numeroDeRodes = numeroDeRodes;
	}
	
	/**
	 * Mostra l'informació referent a l'objecte Vehicle.
	 * 
	 * @return La matricula i número de rodes del vehicle.
	 */
	public String toString() {
		return "Vehicle: "+this.matricula+" / "+this.numeroDeRodes;
	}
}
