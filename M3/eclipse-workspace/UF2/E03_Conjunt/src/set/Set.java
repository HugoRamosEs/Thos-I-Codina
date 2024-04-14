package set;

public class Set {
	public class Element {
		private Object dada;
		private Element seguent;

		public Element(Object e) {
			if (e == null) {
				throw new NullPointerException("No es pot afegir un null.");
			}
			this.dada = e;
			this.seguent = null;
		}
	}

	private Element primer;

	public Set() {
		this.primer = null;
	}

	public boolean isEmpty() {
		return this.primer == null;
	}

	public boolean contains(Object o) throws ClassCastException, NullPointerException {
		if (o == null) {
			throw new NullPointerException("No es por cercar un element null.");
		}

		Element aux = this.primer;
		while (aux != null) {
			if (aux.dada.equals(o))
				return true;
			aux = aux.seguent;
		}
		return false;
	}

	public boolean add(Object e)
			throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException {
		if (contains(e)) {
			return false;
		}

		Element aux = new Element(e);
		aux.seguent = this.primer;
		this.primer = aux;
		return true;
	}

	public boolean remove(Object o) throws ClassCastException, NullPointerException, UnsupportedOperationException {
		if (this.contains(o)) {
			Element aux = this.primer;
			Element anterior = null;
			
			while (aux != null && !aux.dada.equals(o)) {
				anterior = aux;
				aux = aux.seguent;
			}
			if (aux != null) {
				if (anterior == null) {
					this.primer = aux.seguent;
				} else {
					anterior.seguent = aux.seguent;
				}
				return true;
			}
		}
		return false;
	}

	public int size() {
		int tamany = 0;
		Element aux = this.primer;

		while (aux != null) {
			tamany++;
			aux = aux.seguent;
		}
		return tamany;
	}

	public void clear() throws UnsupportedOperationException {
		this.primer = null;
	}

	public Object[] toArray() {
		int size = size();
		Object[] array = new Object[size];
		Element aux = this.primer;

		for (int i = 0; i < size; i++) {
			array[i] = aux.dada;
			aux = aux.seguent;
		}
		return array;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Set: ");
		Element aux = this.primer;

		while (aux != null) {
			sb.append(aux.dada.toString() + ", ");
			aux = aux.seguent;
		}
		return sb.toString();
	}
}
