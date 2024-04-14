package escacs;

public abstract class Peça implements Ordenable {
	private int puntuacio;
	private Color color;

	public Peça(int puntuacio, Color color) {
		super();
		this.puntuacio = puntuacio;
		this.color = color;
	}
	
	// PREGUNTA 6
		// public Object clone() {
			// Peça p = new Peça(this.puntuacio, this.color);
			// return p;
		// }
	
		/*
		 * Creac que no en te sentit realitzar una copia profunda de la clase Peça perque aquesta clase es abstracta, ya que per realitzar l'aplicació
		 * amb sentit, es volen crear peces en especific, y aquesta clase actua com una clase general d'aquestes peces. Per altre costat, al ser una 
		 * clase abstracta, no es pot instanciar, i per tant el metode com tal no es pot realitzar. En cas de que no fos abstracta, si que es podria realitzar
		 * pero no tindria sentit perque estaries creant un nou objecte agafant com a referencia els valors de l'objecte que estas intentant clonant, es com si
		 * crees un nou objecte amb els mateixos valors, i això ho pots fer directament amb el constructor.
		 */

	public int getPuntuacio() {
		return puntuacio;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setPuntuacio(int puntuacio) {
		this.puntuacio = puntuacio;
	}

	@Override
	public String toString() {
		return " [punts: " + this.puntuacio + ", color: " + this.color + "]";
	}

	@Override
	public int ordena(Ordenable e) throws NullPointerException, ClassCastException {
		if (this == e)
			return 0;
		if (e == null)
			throw new NullPointerException();
		if (getClass() != e.getClass())
			throw new ClassCastException();
		Peça other = (Peça) e;
		if (this.puntuacio < other.getPuntuacio()) {
			return -1;
		}
		if (this.puntuacio < other.getPuntuacio()) {
			return 1;
		}
		return 0;
	}
}
