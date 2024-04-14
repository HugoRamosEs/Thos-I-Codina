package list;

public class MyListEnlacada {
	
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

	public MyListEnlacada() {
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

        if (this.isEmpty()) {
            primer = aux;
            primer.seguent = primer; // Hacer que el primer nodo apunte a sí mismo en una lista vacía
        } else {
            Node rec_aux = primer;
            while (rec_aux.seguent != primer) { // Buscar el último nodo
                rec_aux = rec_aux.seguent;
            }
            rec_aux.seguent = aux; // Conectar el nuevo nodo al último
            aux.seguent = primer; // Hacer que el nuevo nodo apunte al primer nodo para cerrar el ciclo
        }
    }

	public void removeFirst() throws NoElementInList {
        if (this.isEmpty()) {
            throw new NoElementInList();
        } else {
            primer = primer.seguent;
        }
    }


	public void removeLast() throws NoElementInList {
        if (this.isEmpty()) {
            throw new NoElementInList();
        } else {
            Node aux = primer;
            while (aux.seguent.seguent != primer) {
                aux = aux.seguent;
            }
            aux.seguent = primer; // Hacer que el penúltimo nodo apunte al primer nodo
        }
    }

	public Object last() throws NoElementInList {
        if (this.isEmpty()) {
            throw new NoElementInList();
        } else {
            Node aux = primer;
            while (aux.seguent != primer) {
                aux = aux.seguent;
            }
            return aux.dada;
        }
    }

	public Object first() throws NoElementInList {
        if (isEmpty()) {
            throw new NoElementInList();
        } else {
            return primer.dada;
        }
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
		} else if (pos<=0 || pos > this.count()) {
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
