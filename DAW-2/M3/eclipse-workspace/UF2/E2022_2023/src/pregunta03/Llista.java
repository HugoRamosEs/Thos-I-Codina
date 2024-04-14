package pregunta03;

public class Llista {
	private class Element {
		protected Object dada;
		protected Element seguent;

		public Element() {
			this.dada = null;
			this.seguent = null;
		}

		public Element(Object p) {
			this.dada = p;
			this.seguent = null;
		}
	}

	private Element primer;

	public Llista() { // Constructor
		this.primer = null;
	}

	private void emptyList() {
		this.primer = null;
	}

	public boolean isEmpty() {
		return this.primer == null;
	}

	public int count() { // Retorna el nombre d'elements de la llista
		int numeroDelements = 0;
		Element aux = this.primer;

		while (aux != null) {
			numeroDelements++;
			aux = aux.seguent;
		}

		return numeroDelements;
	}

	public void insertFirst(Object p) { // Inserta un objecte al principi de la llista
		Element nou = new Element(p);
		nou.seguent = this.primer;
		this.primer = nou;
	}

	public void insertLast(Object p) { // Inserta un objecte al final de la llista
		Element nou = new Element(p);
		Element rec_aux;

		if (this.isEmpty()) {
			primer = nou;
		} else {
			rec_aux = primer;
			while (rec_aux.seguent != null)
				rec_aux = rec_aux.seguent;
			rec_aux.seguent = nou;
		}
	}

	public void removeFirst() throws Exception { // Elimina el primer element de la llista
		Element aux;

		if (this.isEmpty()) {
			throw new Exception("Sense elements a la llista");
		} else {
			aux = primer;
			primer = primer.seguent;
		}
	}

	public void removeLast() throws Exception { // Elimina el darrer element de la llista
		Element aux = primer;

		if (this.isEmpty()) {
			throw new Exception("Sense elements a la llista");
		} else {
			aux = primer;
			while (aux.seguent.seguent != null)
				aux = aux.seguent;
			aux.seguent = null;
		}
	}

	public Object last() throws Exception { // Retorna el darrer element de la llista
		Object elemen = null;
		Element aux = null;

		if (this.isEmpty()) {
			throw new Exception("Sense elements a la llista");
		} else {
			aux = primer;
			while (aux.seguent != null)
				aux = aux.seguent;
			elemen = (Object) aux.dada;
		}
		return elemen;
	}

	public Object first() throws Exception { // Retorna el primer element de la llista
		if (this.isEmpty()) {
			throw new Exception("La llista està buida");
		}

		return this.primer.dada;
	}

	public void removeIndex(int pos) throws Exception { // Esborra l'element de la posició indicada
		if (this.isEmpty()) {
			throw new Exception("La llista està buida");
		} else if (pos <= 0 || pos > this.count()) {
			throw new Exception("Index fora de rang");
		}

		Element aux = primer, ant = null;
		int cont = 1;
		while (aux != null) {
			if (pos == cont) {
				if (ant == null) {
					primer = primer.seguent;
					aux = null;
				} else {
					ant.seguent = aux.seguent;
					aux = null;
				}
			} else {
				ant = aux;
				aux = aux.seguent;
				cont++;
			}
		}

	}

	public int indexOf(Object t) throws Exception { // Donat un objecte, retorna en quina posició està
		if (isEmpty()) {
			throw new Exception("Index fora de rang");

		}
		if (this.isIn(t)) {
			throw new Exception("L'element no està a la llista");
		}

		Element aux = primer;
		int cont = 0;
		boolean trobat = false;

		while (aux != null && !trobat) {
			if (t.equals(aux.dada)) {
				trobat = true;
			}
			cont++;
			aux = aux.seguent;
		}

		return cont;

	}

	public boolean isIn(Object t) { // Indica si l'objecte donat està en la llista
		boolean existe = false;
		Element aux = primer;

		while (aux != null && !existe) {
			Object oActual = aux.dada;
			if (oActual.equals(t)) {
				existe = true;
			}
			aux = aux.seguent;
		}
		return existe;
	}

	@Override
	public String toString() {
		String result = "";
		Element aux = this.primer;
		while (aux != null) {
			result += aux.dada.toString() + "-";
			aux = aux.seguent;
		}
		return result;
	}

}
