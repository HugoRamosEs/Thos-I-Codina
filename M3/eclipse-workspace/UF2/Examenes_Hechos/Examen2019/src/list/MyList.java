package list;

public class MyList {

	private class Node {
		protected Object dada;
		protected Node seguent;

		public Node() {
			seguent = null;
			dada = null;
		}

		public Node(Object p) {
			seguent = null;
			dada = p;
		}
	}

	private Node primer;

	public MyList() {
		emptyList();
	}

	private void emptyList() {
		primer = null;
	}

	public boolean isEmpty() {
		return primer == null;
	}

	public void insertFirst(Object p) {
		Node nou = new Node(p);

		if (!isEmpty())
			nou.seguent = primer;
		primer = nou;
	}

	public void insertLast(Object p) {
		Node aux = new Node(p);
		Node rec_aux;

		if (this.isEmpty()) {
			primer = aux;
			aux.seguent = primer;
		} else {
			rec_aux = primer;
			while (rec_aux.seguent != null)
				rec_aux = rec_aux.seguent;
			rec_aux.seguent = aux;
			aux.seguent = primer;
		}
	}

	public void removeFirst() throws NoElementInList {
		Node aux;

		if (this.isEmpty()) {
			throw new NoElementInList();
		} else {
			aux = primer;
			primer = primer.seguent;
		}
	}

	public void removeLast() throws NoElementInList {
		Node aux = primer;
		Node ant = null;

		if (this.isEmpty()) {
			throw new NoElementInList();
		} else {
			while (aux.seguent != primer) {
				ant = aux;
				aux = aux.seguent;
			}
			if (ant == null) {
				primer = null;
			} else {
				ant.seguent = primer;
			}
		}
	}

	public Object last() throws NoElementInList {
		Object elemen = null;
		Node aux = null;

		if (this.isEmpty()) {
			throw new NoElementInList();
		} else {
			aux = primer;
			while (aux.seguent != null)
				aux = aux.seguent;
			elemen = (Object) aux.dada;
		}
		return elemen;
	}

	public Object first() throws NoElementInList {
		Object elemen = null;

		if (isEmpty()) {
			throw new NoElementInList();
		} else {
			elemen = (Object) primer.dada;
		}
		return elemen;
	}

	public int count() {
		Node aux = null;
		int i = 0;
		aux = primer;

		while (aux != null) {
			aux = aux.seguent;
			i++;
		}
		return i;
	}

	public void removeIndex(int pos) throws NoElementInList, NoIndexInList {
		Node aux, ant;
		int cont = 1;

		if (this.isEmpty()) {
			throw new NoElementInList("llista sense elements");
		} else if (pos <= 0 || pos > this.count()) {
			throw new NoIndexInList("Index fora de rang");
		} else {

			aux = primer;
			ant = null;
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
	}

	public int indexOf(Object t) throws NoElementInList, NoIndexInList {
		Node aux = primer;
		int cont = 0;
		boolean trobat = false;

		if (isEmpty()) {
			throw new NoElementInList();
		} else {
			if (this.isIn(t)) {
				while (aux != null && !trobat) {
					if (t.equals(aux.dada)) {
						trobat = true;
					}
					cont++;
					aux = aux.seguent;
				}
			} else {
				throw new NoIndexInList();
			}
		}
		return cont;
	}

	public boolean isIn(Object t) {
		boolean existe = false;
		Node aux = primer;

		while (aux != null && !existe) {
			Object oActual = aux.dada;
			if (oActual.equals(t)) {
				existe = true;
			}
			aux = aux.seguent;
		}
		return existe;
	}

	public String toString() {
		String cadena = "";
		Node punter = primer;

		while (punter != null) {
			cadena += punter.dada;
			punter = punter.seguent;
		}
		return cadena;
	}

}