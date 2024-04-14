package lista;

public class Lista {
	public class Node {
		private Object dada;
		private Node seguent;
		
		public Node (Object e) {
			if (e==null) {
				throw new NullPointerException("No se puede añadir un nulo");
			}
			this.dada = e;
			this.seguent = null;
		}
	}
	
	private Node primer;
	
	public Lista() {
		this.primer = null;
	}
	
	public boolean isEmpty() {
		return this.primer == null;
	}
	
	public void add (Object e) {
		Node aux = new Node(e);
		aux.seguent = this.primer;
		this.primer = aux;		
	}
	
	public boolean isIn(Object e) {
		Node aux = this.primer;
		while (aux !=null ) {
			if (aux.dada.equals(e)) return true;
			aux=aux.seguent;
		}	
		return false;
	}
	
	public void remove(Object e) {
		if (this.isIn(e)) {
			if (this.primer.equals(e)) {
				this.primer = this.primer.seguent;
			} else {
				Node aux = this.primer.seguent;
				Node anterior = this.primer;
				while (aux != null) {
					if (!aux.dada.equals(e)) {
						aux=aux.seguent;
						anterior = anterior.seguent;
					} else {
						anterior.seguent = aux.seguent;
						aux=null;
					}
				}
			}			
		}
	}

	public int size() {
		int tamany=0;
		Node aux = this.primer;
		
		while (aux != null) {
			tamany ++;
			aux = aux.seguent;
		}
		return tamany;
	}
	
	public void clear() {
		this.primer = null;
	}
	
	public Object get(int i) {
		int tamany = 0;
		Object obj = null;
		Node aux = this.primer;
		
		while (aux != null) {
			if (i == tamany) {
				obj = aux.dada;
			}
			tamany ++;
			aux = aux.seguent;
		}
		return obj;
	}
	
	public int getIndex(Object e) {
		int index = 0;
		int tamany = 0;
		Node aux = this.primer;
		
		while (aux != null) {
			if (aux.dada.equals(e)) {
				index = tamany;
				break;
			}
			tamany ++;
			aux = aux.seguent;
		}
		return index;
	}
	
	public int lastIndexOf(Object e) {
		int lastIndex = 0;
		int tamany = 0;
		Node aux = this.primer;
		
		while (aux != null) {
			if (aux.dada.equals(e)) {
				lastIndex = tamany;
			}
			tamany ++;
			aux = aux.seguent;
		}
		return lastIndex;
	}
	
	public void removeIndex(int i) {
		int tamany = 0;
		Node aux = this.primer;
		Node anterior = null;
		
		while (aux != null) {
			if (i == tamany) {
				if (anterior == null) {
					this.primer = aux.seguent;
				}else {
					anterior.seguent = aux.seguent;
				}
			}
			tamany ++;
			anterior = aux;
			aux = aux.seguent;
		}
	}
	
	public void set(Object e, int i) {
		int tamany = 0;
		Node aux = this.primer;
		Node nouObj = new Node(e);
		
		if (i == 0) {
			nouObj.seguent = this.primer;
			this.primer = nouObj;
		}else {
			while (aux != null) {
				if (tamany + 1 == i) {
					nouObj.seguent = aux.seguent;
					aux.seguent = nouObj;
				}
				tamany++;
				aux = aux.seguent;
			}
		}
	}
	
	public Object[] toArray() {
		int size = size();
		Object[] array = new Object[size];
		Node aux = this.primer;
		
		for (int i=0; i<size; i++) {
			array[i] = aux.dada;
			aux = aux.seguent;
		}
		return array;
	}

	@Override
	public String toString() {
		String result = "";
		Node aux = this.primer;
		
		while (aux != null) {
			result += aux.dada.toString() + "-";
			aux = aux.seguent;
		}		
		return result;
	}
}
