import java.util.Objects;

/**
 * La clase Temps representa un cronometro con atributos de horas, minutos y segundos. El tiempo se asigna, y la clase posee metodos para sumar y restar tiempos.
 * Ademas el tiempo esta normalizado, de esta manera los minutos y segundos son menores a 60. Para la resta, cuenta con un metodo que comprueba si el tiempo
 * a restar es mayor o igual que el tiempo con el que se desea restar. Por último se tiene en cuenta que el tiempo no puede ser negativo, lanzando asi
 * una excepcion.
 * 
 * @author Hugo Ramos
 */
public class Temps {
	/**
	 * Atributo que asigna las horas.
	 */
	private int horas;
	
	/**
	 * Atributo que asigna los minutos.
	 */
	private int minutos;
	
	/**
	 * Atributo que asigna los segundos.
	 */
	private int segundos;
	
	// CONSTRUCTORES
	
	/**
	 * Constructor por defecto.
	 */
	Temps(){
		this.horas = 0;
		this.minutos = 0;
		this.segundos = 0;
	}
	
	/**
	 * Constructor que crea un objeto Temps, con los atributos de horas, minutos y segundos.
	 * 
	 * @param horas Horas a asignar.
	 * @param minutos Minutos a asignar.
	 * @param segundos Segundos a asignar.
	 */
	Temps(int horas, int minutos, int segundos){
		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
	}
	
	// METODOS PROPIOS
	
	/**
	 * El método suma los tiempos asignados y crea un nuevo objeto tiempo con los valores de la suma, 
	 * posteriormente lo normaliza para dar un valor correcto.
	 * 
	 * @param tiempo1 Es el primer objeto tiempo.
	 * @param tiempo2 Es el segundo objeto tiempo.
	 * @return tiempoSuma Retorna un objeto tiempo, con la suma de ambos tiempos y normalizado.
	 */
	public Temps sumaTiempo(Temps tiempo1, Temps tiempo2) {
		Temps tiempoSuma = new Temps();
		
		tiempoSuma.horas = tiempo1.horas + tiempo2.horas;
		tiempoSuma.minutos = tiempo1.minutos + tiempo2.minutos;
		tiempoSuma.segundos = tiempo1.segundos + tiempo2.segundos;
		
		if (tiempoSuma.segundos >= 60) {
	        tiempoSuma.minutos += tiempoSuma.segundos / 60;
	        tiempoSuma.segundos = tiempoSuma.segundos % 60;
	    }

	    if (tiempoSuma.minutos >= 60) {
	        tiempoSuma.horas += tiempoSuma.minutos / 60;
	        tiempoSuma.minutos = tiempoSuma.minutos % 60;
	    }
		
		return tiempoSuma;
	}
	
	/**
	 * El método, primero comprueba que el primer tiempo sea igual o mayor que el segundo tiempo para realizar la resta, 
	 * una vez comprobado, resta los tiempos asignados y crea un nuevo objeto tiempo con los valores de la resta. 
	 * Posteriormente lo normaliza para dar un valor correcto.
	 * 
	 * @param tiempo1 Es el primer objeto tiempo.
	 * @param tiempo2 Es el segundo objeto tiempo.
	 * @throws Exception Lanza una excepcion, debido a que el tiempo a restar es menor que el tiempo con el que se desea restar.
	 * @return tiempoResta Retorna un objeto tiempo, con la resta de ambos tiempos y normalizado.
	 */
	public Temps restaTiempo(Temps tiempo1, Temps tiempo2) throws Exception {
		Temps tiempoResta = new Temps();
		
		if(tiempo1.compareTo(tiempo2) < 0) {
			throw new Exception("El primer tiempo debe ser mayor o igual que el segundo");
		}
		
		tiempoResta.horas = tiempo1.horas - tiempo2.horas;
		tiempoResta.minutos = tiempo1.minutos - tiempo2.minutos;
		tiempoResta.segundos = tiempo1.segundos - tiempo2.segundos;
		
		if (tiempoResta.segundos >= 60) {
	        tiempoResta.minutos += tiempoResta.segundos / 60;
	        tiempoResta.segundos = tiempoResta.segundos % 60;
	    }

	    if (tiempoResta.minutos >= 60) {
	        tiempoResta.horas += tiempoResta.minutos / 60;
	        tiempoResta.minutos = tiempoResta.minutos % 60;
	    }
		
		return tiempoResta;
	}
	
	/**
	 * El método suma los tiempos asignados y crea un nuevo objeto tiempo con los valores de la suma,
	 * posteriormente lo normaliza para dar un valor correcto. Este método es estático.
	 * 
	 * @param tiempo1 Es el primer objeto tiempo.
	 * @param tiempo2 Es el segundo objeto tiempo.
	 * @return tiempoSuma Retorna un objeto tiempo, con la suma de ambos tiempos y normalizado.
	 */
	public static Temps sumaTiempoEstatico(Temps tiempo1, Temps tiempo2) {
		Temps tiempoSuma = new Temps();
		
		tiempoSuma.horas = tiempo1.horas + tiempo2.horas;
		tiempoSuma.minutos = tiempo1.minutos + tiempo2.minutos;
		tiempoSuma.segundos = tiempo1.segundos + tiempo2.segundos;
		
		if (tiempoSuma.segundos >= 60) {
	        tiempoSuma.minutos += tiempoSuma.segundos / 60;
	        tiempoSuma.segundos = tiempoSuma.segundos % 60;
	    }

	    if (tiempoSuma.minutos >= 60) {
	        tiempoSuma.horas += tiempoSuma.minutos / 60;
	        tiempoSuma.minutos = tiempoSuma.minutos % 60;
	    }
		
		return tiempoSuma;
	}
	
	/**
	 * El método, primero comprueba que el primer tiempo sea igual o mayor que el segundo tiempo para realizar la resta,
	 * una vez comprobado, resta los tiempos asignados y crea un nuevo objeto tiempo con los valores de la resta.
	 * Posteriormente lo normaliza para dar un valor correcto. Este método es estático.
	 * 
	 * @param tiempo1 Es el primer objeto tiempo.
	 * @param tiempo2 Es el segundo objeto tiempo.
	 * @throws Exception Lanza una excepcion, debido a que el tiempo a restar es menor que el tiempo con el que se desea restar.
	 * @return tiempoResta Retorna un objeto tiempo, con la resta de ambos tiempos y normalizado.
	 */
	public static Temps restaTiempoEstatico(Temps tiempo1, Temps tiempo2) throws Exception {
		Temps tiempoResta = new Temps();
		
		if(tiempo1.compareTo(tiempo2) < 0) {
			throw new Exception("El primer tiempo debe ser mayor o igual que el segundo");
		}
		
		tiempoResta.horas = tiempo1.horas - tiempo2.horas;
		tiempoResta.minutos = tiempo1.minutos - tiempo2.minutos;
		tiempoResta.segundos = tiempo1.segundos - tiempo2.segundos;
		
		if (tiempoResta.segundos >= 60) {
	        tiempoResta.minutos += tiempoResta.segundos / 60;
	        tiempoResta.segundos = tiempoResta.segundos % 60;
	    }

	    if (tiempoResta.minutos >= 60) {
	        tiempoResta.horas += tiempoResta.minutos / 60;
	        tiempoResta.minutos = tiempoResta.minutos % 60;
	    }
		
		return tiempoResta;
	}
	
	// GETTERS Y SETTERS
	
	/**
	 * Getter, devuelve el valor de las horas almacenadas en Temps.
	 * 
	 * @return retorna el valor representativo de las horas.
	 */
	public int getHoras() {
		return horas;
	}
	
	/**
	 * Getter, devuelve el valor de los minutos almacenados en Temps.
	 * 
	 * @return retorna el valor representativo de los minutos.
	 */
	public int getMinutos() {
		return minutos;
	}
	
	/**
	 * Getter, devuelve el valor de las segundos almacenados en Temps.
	 * 
	 * @return retorna el valor representativo de los segundos.
	 */
	public int getSegundos() {
		return segundos;
	}
	
	/**
	 * Setter, establece el valor de las horas almacenadas en Temps.
	 * 
	 * @param horas Nuevo valor representativo de las horas.
	 * @throws ArithmeticException Lanza una excepcion en caso de que las horas sean negativas, ya que se considera que no existe el tiempo negativo.
	 */
	public void setHoras(int horas) {
		this.horas = horas;
		if (horas < 0) {
			throw new ArithmeticException();
		}
	}
	
	/**
	 * Setter establece el valor de los minutos almacenados en Temps.
	 * 
	 * @param minutos Nuevo valor representativo de los minutos.
	 * @throws ArithmeticException Lanza una excepcion en caso de que los minutos sean negativos, ya que se considera que no existe el tiempo negativo.
	 */
	public void setMinutos(int minutos) {
		this.minutos = minutos;
		if (minutos < 0) {
			throw new ArithmeticException();
		}
	}
	
	/**
	 * Setter, establece el valor de los segundos almacenados en Temps.
	 * 
	 * @param segundos Nuevo valor representativo de los segundos.
	 * @throws ArithmeticException Lanza una excepcion en caso de que los segundos sean negativos, ya que se considera que no existe el tiempo negativo.
	 */
	public void setSegundos(int segundos) {
		this.segundos = segundos;
		if (segundos < 0) {
			throw new ArithmeticException();
		}
	}

	// OVERRIDES

	@Override
	public String toString() {
		return this.horas+":"+this.minutos+":"+this.segundos;
	}
	
	/**
	 * Se encarga de comparar si es objeto que se recibe es igual al objeto Temps creado en la clase, si es nulo o pertenece a otra clase.
	 * Una vez se comprueba si es de la misma clase y se trata de un objeto Temps, realiza una transformacion y compara las horas, minutos
	 * y segundos de ambos objetos. En caso de que sean iguales, se pasa al siguiente atributo hasta finalizar con los segundos, si 
	 * encuentra que un atributo es menor, retorna -1, si es mayor retorna 1 y si son iguales 0.
	 * 
	 * @param obj es el objeto padre de Java, es decir, que representa a todos los objetos.
	 * @throws NullPointerException en caso de que el objeto sea nulo.
	 * @throws ClassCastException en caso de que el objeto no pertenezca a la clase Temps.
	 * @return 0 es decir que son equivalentes. Si es -1 es menor y si es 1 es mayor.
	 */
	public int compareTo(Object obj) {
		if (this == obj)
			return 0;
		if (obj == null)
			throw new NullPointerException();
		if (getClass() != obj.getClass())
			throw new ClassCastException();
		Temps other = (Temps) obj;
		if (this.horas < other.horas) {
			return -1;
		}
		if (this.horas > other.horas) {
			return 1;
		}
		if(this.horas == other.horas) {
			if (this.minutos < other.minutos) {
				return -1;
			}
			if (this.minutos > other.minutos) {
				return 1;
			}
			if(this.segundos == other.segundos) {
				if (this.segundos < other.segundos) {
					return -1;
				}
				if (this.segundos > other.segundos) {
					return 1;
				}
			}
		}
		return 0;
	}
}
