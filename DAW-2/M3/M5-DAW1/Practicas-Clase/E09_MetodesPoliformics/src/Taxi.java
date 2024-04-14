/**
 * Representa un tipus de Vehicle, concretament, un Taxi. Es fill de la classe Vehicle. Poseeix dos atributs per saber el 
 * nombre del conductor i el número de places disponibles. A més compta amb un métode per sumar el cost del Vehicle + la
 * llicencia. 
 * 
 * @author Hugo Ramos
 */
public class Taxi extends Vehicle {
	/*
	 * Atribut nombre del conductor del Taxi.
	 */
	private String nomDelConductor;
	
	/*
	 * Atribut que conté el nombre de places del Taxi.
	 */
	private int numeroDePlaces;
	
	/**
	 * Construeix un objecte Taxi, amb les dades introduides per l'usuari.
	 * 
	 * @param matricula Atribut heretat de la classe pare Vehicle, asigna una matricula al Taxi.
	 * @param numeroDeRodes Atribut heretat de la classe pare Vehicle, asigna un número de rodes al Taxi.
	 * @param nomDelConductor Atribut propi de la classe Taxi, asigna el nombre del conductor.
	 * @param numeroDePlaces Atribut propi de la classe Taxi, asigna el número de places del Taxi.
	 */
	public Taxi(String matricula, int numeroDeRodes, String nomDelConductor, int numeroDePlaces) {
		super(matricula, numeroDeRodes);
		this.nomDelConductor = nomDelConductor;
		this.numeroDePlaces = numeroDePlaces;
	}

//  REDEFINIDA
	/**
	 * Calcula la suma del cost del vehicle, heretat de la classe pare Vehicle i la llicencia. Es tracta
	 * d'un métode redefinit, ya que es rescriu el métode.
	 * 
	 * @return Retorna la suma entre el cost del vehicle, heretat de la classe pare Vehicle, i la llicencia.
	 */
	@Override
	public int obtenirCostCompra() {
		return super.obtenirCostCompra() + 21000;
	}

//  REFINADA
	/**
	 * Calcula la suma del cost del vehicle, heretat de la classe pare Vehicle i la llicencia. Es tracta
	 * d'un métode refinat, ya que no es rescriu el métode, sino que es fa una modificació respecte al
	 * métode original.
	 * 
	 * @return Retorna la suma entre el cost del vehicle, heretat de la classe pare Vehicle, i la llicencia.
	 */
//	@Override
//  public int obtenirCostCompra() {
//      int preuVehicle = super.obtenirCostCompra();
//      int preuLlicencia = 21000;
//      return preuVehicle + preuLlicencia;
//  }
	
	/**
	 * Getter, permet agafar el nombre asignat al conductor del Taxi.
	 * 
	 * @return El nombre del conductor del Taxi.
	 */
	public String getNomDelConductor() {
		return this.nomDelConductor;
	}
	
	/**
	 * Getter, permet agafar el número de places del Taxi.
	 * 
	 * @return El número de places del Taxi.
	 */
	public int getNumeroDePlaces() {
		return this.numeroDePlaces;
	}
	
	/**
	 * Setter, permet modificar el valor de l'atribut nomDelConductor.
	 * 
	 * @param nomDelConductor Atribut nombre del conductor del Taxi, asignat per l'usuari.
	 */
	public void setNomDelConductor(String nomDelConductor) {
		this.nomDelConductor = nomDelConductor;
	}
	
	/**
	 * Setter, permet modificar el valor de l'atribut numeroDePlaces.
	 * 
	 * @param numeroDePlaces Atribut que conté el nombre de places del Taxi, asignat per l'usuari.
	 */
	public void setNumeroDePlaces(int numeroDePlaces) {
		this.numeroDePlaces = numeroDePlaces;
	}
	
	/**
	 * Mostra l'informació referent a l'objecte Taxi.
	 * 
	 * @return El nombre del conductor i el nombre de places del Taxi.
	 */
	@Override
	public String toString() {
		return "Taxi: "+this.nomDelConductor+" / "+this.numeroDePlaces;
	}
}
