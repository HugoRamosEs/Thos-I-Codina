package llistaDoblementEnllacadaCircular;

public class ArrayList {
	private class Element {
		protected Object dada;
		protected Element seguent;
		protected Element anterior;

		public Element() {}
		public Element(Object parametre) {
			this.dada = parametre;
			this.seguent = null;
			this.anterior = null;
		}
	}

	private Element primer;
	private int capacitat;

	public ArrayList(int initialCapacity) throws IllegalArgumentException {
		this.primer = null;
		this.capacitat = initialCapacity;
		init();
	}

	public ArrayList() {
		this.primer = null;
		this.capacitat = 10;
		init();
	}

	private void init() {
		for (int i = 0; i < this.capacitat; i++) {
			Element aux = new Element(null);
			if (this.primer == null) {
				this.primer = aux;
				this.primer.seguent = this.primer;
				this.primer.anterior = this.primer;
			} else {
				Element ultim = this.primer.anterior;
				ultim.seguent = aux;
				aux.anterior = ultim;
				aux.seguent = this.primer;
				this.primer.anterior = aux;
			}
		}
	}

	public boolean add(Object element) {
		Element aux = this.primer;
		do {
			if (aux.dada == null) {
				aux.dada = element;
				return true;
			}
			aux = aux.seguent;
		} while (aux != this.primer);
		Element nuevoElemento = new Element(element);
		Element ultim = this.primer.anterior;
		ultim.seguent = nuevoElemento;
		nuevoElemento.anterior = ultim;
		nuevoElemento.seguent = this.primer;
		this.primer.anterior = nuevoElemento;
		return true;
	}

	public void add(int index, Object element) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException();
		}
		Element nouElement = new Element(element);
		Element aux = this.primer;
		for (int i = 0; i < index; i++) {
			aux = aux.seguent;
		}
		if (aux.dada == null) {
			aux.dada = element;
		} else {
			nouElement.seguent = aux.seguent;
			nouElement.anterior = aux;
			aux.seguent.anterior = nouElement;
			aux.seguent = nouElement;
		}
	}

	public void clear() {
		this.primer = null;
	}

	public boolean contains(Object o) {
		if (o == null) {
			return false;
		}
		Element aux = this.primer;
		for (int i = 0; i < this.size(); i++) {
			if (aux.dada != null && aux.dada.equals(o)) {
				return true;
			}
			aux = aux.seguent;
			if (aux == this.primer) {
				break;
			}
		}
		return false;
	}

	public void ensureCapacity(int minCapacity) throws IllegalArgumentException {
		if (minCapacity > 0 && minCapacity > this.capacitat) {
			this.capacitat = minCapacity;
		}else {
			throw new IllegalArgumentException();
		}
	}

	public Object get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException();
		}
		Element aux = this.primer;
		for (int i = 0; i < index; i++) {
			aux = aux.seguent;
		}
		return aux.dada;
	}

	public int indexOf(Object o) {
		if (this.size() == 0 || !this.contains(o)) {
			return -1;
		}
		Element aux = this.primer;
		for (int i = 0; i < this.size(); i++) {
			if (o == null) {
				if (this.get(i) == null)
					return i;
			} else {
				if (o.equals(get(i)))
					return i;
			}
			aux = aux.seguent;
		}
		return -1;
	}

	public boolean isEmpty() {
		return this.primer == null;
	}

	public int lastIndexOf(Object o) {
		if (this.size() == 0 || !this.contains(o)) {
			return -1;
		}
		Element aux = this.primer;
		int lastIndex = -1;
		for (int i = 0; i < this.size(); i++) {
			if (o == null) {
				if (this.get(i) == null)
					lastIndex = i;
			} else {
				if (o.equals(get(i)))
					lastIndex = i;
			}
			aux = aux.seguent;
		}
		return lastIndex;
	}

	public Object remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException();
		}
		Element aux = this.primer;
		for (int i = 0; i < index; i++) {
			aux = aux.seguent;
		}
		Object eliminat = aux.dada;
		if (aux.anterior != null) {
			aux.anterior.seguent = aux.seguent;
		} else {
			this.primer = aux.seguent;
		}

		if (aux.seguent != null) {
			aux.seguent.anterior = aux.anterior;
		}
		return eliminat;
	}

	public boolean remove(Object o) {
		int pos = this.indexOf(o);
		if (pos != -1) {
			this.remove(pos);
			return true;
		}
		return false;
	}

	protected void removeRange(int fromIndex, int toIndex) throws IndexOutOfBoundsException {
		if (fromIndex < 0 || fromIndex >= this.size() || toIndex > this.size() || toIndex < fromIndex) {
			throw new IndexOutOfBoundsException();
		}
		if (toIndex != fromIndex) {
			for (int i = toIndex - 1; i >= fromIndex; i--) {
				this.remove(i);
			}
		}
	}

	public Object set(int index, Object element) throws IndexOutOfBoundsException {
		Element aux = this.primer;
		for (int i = 0; i < index; i++) {
			aux = aux.seguent;
		}
		Object anterior = aux.dada;
		aux.dada = element;
		return anterior;
	}

	public int size() {
		if (this.primer == null) {
			return 0;
		} else {
			int tamany = 1;
			Element aux = this.primer;
			while (aux.seguent != this.primer) {
				tamany++;
				aux = aux.seguent;
			}
			return tamany;
		}
	}

	public ArrayList subList(int fromIndex, int toIndex) throws IndexOutOfBoundsException, IllegalArgumentException {
		if ((fromIndex < 0 || toIndex > this.size())) {
			throw new IndexOutOfBoundsException();
		}
		if (fromIndex > toIndex) {
			throw new IllegalArgumentException();
		}
		ArrayList subList = new ArrayList(toIndex - fromIndex);
		Element aux = this.primer;
		for (int i = 0; i < fromIndex; i++) {
			aux = aux.seguent;
		}
		for (int i = fromIndex; i < toIndex; i++) {
			subList.add(aux.dada);
			aux = aux.seguent;
		}
		return subList;
	}

	public Object[] toArray() {
		Object[] array = new Object[this.size()];
		for (int i = 0; i < this.size(); i++) {
			array[i] = this.get(i);
		}
		return array;
	}

	public void trimToSize() {
		this.capacitat = this.size();
	}

	public Object clone() {
		Element aux = this.primer;
		ArrayList copia = new ArrayList(this.size());
		for (int i=0; i<copia.getCapacitat(); i++) {
			copia.add(aux.dada);
			aux = aux.seguent;
		}
		return copia;
	}
	
	/*
	 * Copia superficial de ArrayList (shadow copy)
	 * public ArrayList clone(){
	 * 		ArrayList copia = new ArrayList();
	 * 		copia.primer.setPrimer(this.primer);
	 * 		return copia;
	 * }
	 */
	
	public Element getPrimer() {
		return primer;
	}

	public int getCapacitat() {
		return capacitat;
	}

	public void setPrimer(Element primer) {
		this.primer = primer;
	}

	public void setCapacitat(int capacitat) {
		this.capacitat = capacitat;
	}

	public String toString() {
		String cadena = "";
		int index = 0;
		Element punter = this.primer;
		if (!this.isEmpty()) {
			cadena = "";
			do {
				cadena += "[" + index + ", " + punter.dada + "] ";
				index++;
				punter = punter.seguent;
			} while (punter != this.primer);
		}
		return cadena;
	}
}