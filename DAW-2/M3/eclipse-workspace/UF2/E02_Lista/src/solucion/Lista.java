package solucion;

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
	

	/**
	 * Returns the element at the specified position in this list.
	 * @param index - index of the element to return
	 * @return the element at the specified position in this list
	 * @throws - if the index is out of range (index < 0 || index >= size())
	 **/
	public Object get(int index) throws IndexOutOfBoundsException{
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException();
		}
		Node aux = this.primer;
		for (int i=1; i<index; i++) {
			aux = aux.seguent;
		}
		return aux;
	}
	
//	public int getIndex(Object e) {
	
	/**
	 * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element. More formally, returns the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
	 * @param o - element to search for
	 * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
	 * @throws ClassCastException - if the type of the specified element is incompatible with this list (optional)
	 * @throws NullPointerException - if the specified element is null and this list does not permit null elements (optional)
	 */
	public int indexOf (Object o) throws ClassCastException, NullPointerException {
		if (this.size()==0 || !this.isIn(o)) {
			return -1;
		}
		
		Node aux = this.primer;
		int i=0;
		while (aux != null) {
			if (o==null) {
				if (this.get(i)==null) return i; 
			} else {
				if (o.equals(get(i))) return i;
			}
			aux = aux.seguent;
			i++;
		}
		return -1;
	}
	
	/**
	 * Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element. More formally, returns the highest index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
	 * @param o - element to search for
	 * @return the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element
	 * @throws ClassCastException - if the type of the specified element is incompatible with this list (optional)
	 * @throws NullPointerException - if the specified element is null and this list does not permit null elements (optional)
	 */
	public int lastIndexOf(Object o) throws ClassCastException, NullPointerException {
		if (this.size()==0 || !this.isIn(o)) {
			return -1;
		}
		
		Node aux = this.primer;
		int lastIndexFound=0;
		int i=0;
		while (aux != null) {
			if (o==null) {
				if (this.get(i)==null) lastIndexFound=i; 
			} else {
				if (o.equals(get(i))) lastIndexFound=i;
			}
			aux = aux.seguent;
			i++;
		}
		return lastIndexFound;
	}
	
	/**
	 * Removes the element at the specified position in this list (optional operation). Shifts any subsequent elements to the left (subtracts one from their indices). Returns the element that was removed from the list.
	 * @param index - the index of the element to be removed
	 * @throws UnsupportedOperationException - if the remove operation is not supported by this list
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
	 */
	public void removeIndex(int index) throws UnsupportedOperationException, IndexOutOfBoundsException {
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException();
		}
		
		Node aux = this.primer.seguent;
		Node ant = this.primer;
		
		if (index==0) {
			this.primer=aux;
		} else {			
			for (int i=0; i<index; i++) {
				aux=aux.seguent;
				ant=ant.seguent;
			}
			ant.seguent=aux.seguent;
		}
		
	}
	
	
	/**
	 * Replaces the element at the specified position in this list with the specified element (optional operation).
	 * @param e element to be stored at the specified position
	 * @param index index of the element to replace
	 * @throws UnsupportedOperationException element to be stored at the specified position
	 * @throws ClassCastException - if the class of the specified element prevents it from being added to this list
	 * @throws NullPointerException - if the specified element is null and this list does not permit null elements
	 * @throws IllegalArgumentException - if some property of the specified element prevents it from being added to this list
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
	 */
	public void set(Object e, int index) throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException();
		}
		
		Node aux = this.primer.seguent;
		for (int i=0; i<index; i++) {
			aux=aux.seguent;
		}
		aux.dada = e;
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence (from first to last element).
	 * The returned array will be "safe" in that no references to it are maintained by this list. (In other words, this method must allocate a new array even if this list is backed by an array). The caller is thus free to modify the returned array.
	 * This method acts as bridge between array-based and collection-based APIs.
	 * @return an array containing all of the elements in this list in proper sequence
	 * @see Arrays.asList(Object[])
	 */
	public Object[] toArray() {
		Object[] result = new Object[this.size()];
		for (int i=0; i<this.size(); i++) {
			result[i] = this.get(i);
		}
		return result;
	}
	

	@Override
	public String toString() {
		String result= "";
		Node aux = this.primer;
		
		while (aux != null) {
			result += aux.dada.toString() + "-";
			aux = aux.seguent;
		}		
		return result;
	}	
}
