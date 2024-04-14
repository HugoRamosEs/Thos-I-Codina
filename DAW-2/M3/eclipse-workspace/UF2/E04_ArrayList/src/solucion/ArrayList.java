package solucion;

public class ArrayList {
	private class Element {
		protected int index;
		protected Object dada;
		protected Element seguent;
		protected Element anterior;

		public Element(int index, Object parametre) {
			this.index = index;
			this.dada = parametre;
			this.seguent = this;
			this.anterior = this;
		}
	}
	
	private Element primer;
	
	/**
	 * Constructs an empty list with the specified initial capacity.
	 * @param initialCapacity - the initial capacity of the list
	 * @throws IllegalArgumentException - if the specified initial capacity is negative
	 */
	public ArrayList(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException ("No pot ser un tamany negatiu");
		}

		for (int index = 0; index < initialCapacity; index++) {
			this.add(index, null);
		}
	}
	
	/**
	 * Constructs an empty list with an initial capacity of ten.
	 */
	public ArrayList() {
		this(10);
	}
	
	/**
	 * Appends the specified element to the end of this list.
	 * @param parametre - element to be appended to this list
	 */
	public boolean add (Object element) {
		int sizeBefore = this.size();
		this.add(this.size(), element);
		return (this.size()==sizeBefore+1) ? true : false;
	}
	
	/**
	 * Inserts the specified element at the specified position in this list. 
	 * Shifts the element currently at that position (if any) and any subsequent elements 
	 * to the right (adds one to their indices).
	 * @param index - index at which the specified element is to be inserted
	 * @param element - element to be inserted
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
	 */
	public void add(int index, Object element) throws IndexOutOfBoundsException {
		if (index < 0 || index > this.size()) {
			throw new IndexOutOfBoundsException("Index erroni: " + index);
		} 
		
		Element auxiliar = this.primer;
		Element nou = new Element(index, element);

		//em posiciono al index on vull insertar.
		if (this.isEmpty()) {
			this.primer=nou;
		} else {
			if (index==0) {
				//Només si insereixo a 0, hauré de modificar l'atribut primer
				this.primer=nou;
			} else {
				if (index==this.size()) {
					auxiliar=this.primer;
				} else {
					while ((auxiliar.index != index) && (auxiliar.seguent != this.primer)) {
						auxiliar = auxiliar.seguent;
					}
				}
			}
			
			//modifico les referències.
			nou.anterior = auxiliar.anterior;
			nou.seguent = auxiliar;
			auxiliar.anterior.seguent = nou;
			auxiliar.anterior = nou;

			// i re-numero tots els que hi ha a la dreta.
			while (auxiliar != this.primer) {
				auxiliar.index ++;
				auxiliar = auxiliar.seguent;
			}
		}			

		
		if (index==0) {
			this.primer=nou;
		}
	}
	
	/**
	 * 
	 * Removes all of the elements from this list. The list will be empty after this call returns.
	 */
	public void clear() {
		this.primer = null;
	}
	
	/**
	 * Returns true if this list contains the specified element. More formally, 
	 * returns true if and only if this list contains at least one element e 
	 * such that (o==null ? e==null : o.equals(e)).
	 * @param o - element whose presence in this list is to be tested
	 * @return true if this list contains the specified element
	 */
	public boolean contains(Object o) {
		return indexOf(o)==-1 ? false : true;
	}
 
	/**
	 * Increases the capacity of this ArrayList instance, if necessary, to ensure 
	 * that it can hold at least the number of elements specified by the minimum 
	 * capacity argument.
	 * @param minCapacity
	 */
	public void ensureCapacity(int minCapacity)  {
		while (this.size() < minCapacity) {
			this.add(null);
		}
	}

	/**
	 * Returns the element at the specified position in this list.
	 * @param index  - index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
	 */
	public Object get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException ("index fora de rang");
		} 

		Element punterAuxiliar = this.primer;
		while (punterAuxiliar.index!=index) {
			punterAuxiliar = punterAuxiliar.seguent;
		}

		return punterAuxiliar.dada;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in this list, 
	 * or -1 if this list does not contain the element. More formally, returns the lowest 
	 * index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if 
	 * there is no such index.
	 * @param o - element to search for
	 * @return the index of the first occurrence of the specified element in this list, 
	 * or -1 if this list does not contain the element
	 */
	public int indexOf(Object o) {
		int index = -1;
		
		int i = 0;
		int tamany = this.size();
		while (i<tamany && index==-1 ) {
			if ((o==null) ? get(i)==null : o.equals(get(i))) {
				index = i;
			}
			i++;
		}
		
		return index;
	}

	/**
	 * Returns true if this list contains no elements.
	 * @return true if this list contains no elements
	 */
	public boolean isEmpty() {
		return this.primer == null;
	}

	/**
	 * Returns the index of the last occurrence of the specified element in this list, 
	 * or -1 if this list does not contain the element. More formally, returns the 
	 * highest index i such that (o==null ? get(i)==null : o.equals(get(i))), 
	 * or -1 if there is no such index.
	 * @param o - element to search for
	 * @return - the index of the last occurrence of the specified element in this list, 
	 * or -1 if this list does not contain the element
	 */
	public int lastIndexOf(Object o) {
		int index = -1;
		
		int i = this.size()-1;
		int tamany = this.size();
		while (i>=0 && index==-1 ) {
			if ((o==null) ? get(i)==null : o.equals(get(i))) {
				index = i;
			}
			i--;
		}
				
		return index;
	}

	/**
	 * Removes the element at the specified position in this list. 
	 * Shifts any subsequent elements to the left (subtracts one from their indices).
	 * @param index - the index of the element to be removed
	 * @return the element that was removed from the list
	 * @throws IndexOutOfBoundsException  - if the index is out of range (index < 0 || index >= size())
	 */
	public Object remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException ("index fora de rang");
		} 

		Element punterAuxiliar = this.primer;
		while (punterAuxiliar.index!=index) {
			punterAuxiliar = punterAuxiliar.seguent;
		}
		
		Object dadaAnterior = punterAuxiliar.dada;
		
		if (this.size() == 1) {
			this.primer = null;
		} else {
			// Cas index 0
			if (index == 0) {
				this.primer = punterAuxiliar.seguent;
			}

			punterAuxiliar.anterior.seguent = punterAuxiliar.seguent;
			punterAuxiliar.seguent.anterior = punterAuxiliar.anterior;
			punterAuxiliar = punterAuxiliar.seguent;
		
			// Modifico els registres posteriors
			while (punterAuxiliar.index!=0) {
				punterAuxiliar.index = punterAuxiliar.index -1;
				punterAuxiliar = punterAuxiliar.seguent;
			}
			

			
		}
		return dadaAnterior;
	}

	/**
	 * Removes the first occurrence of the specified element from this list, 
	 * if it is present. If the list does not contain the element, it is unchanged. 
	 * More formally, removes the element with the lowest index i such 
	 * that (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists). 
	 * Returns true if this list contained the specified element (or equivalently, 
	 * if this list changed as a result of the call).
	 * @param o - element to be removed from this list, if present
	 * @return true if this list contained the specified element
	 */
	public boolean remove(Object o) {
		boolean existeix = false;
		Element punterAuxiliar = this.primer;
		Object dadaAnterior;

		if (this.contains(o)) {
			existeix = true;
			this.remove(this.indexOf(o));
		}
		return existeix;
	}

	/**
	 * Removes from this list all of the elements whose index is between fromIndex, 
	 * inclusive, and toIndex, exclusive. Shifts any succeeding elements to the left 
	 * (reduces their index). This call shortens the list by (toIndex - fromIndex) 
	 * elements. (If toIndex==fromIndex, this operation has no effect.)
	 * @param fromIndex  - index of first element to be removed
	 * @param toIndex - index after last element to be removed
	 * @throws IndexOutOfBoundsException - if fromIndex or toIndex is out of range 
	 * (fromIndex < 0 || fromIndex >= size() || toIndex > size() || toIndex < fromIndex)
	 */
	public void removeRange(int fromIndex, int toIndex) throws IndexOutOfBoundsException {
		if (fromIndex < 0 || fromIndex >= this.size() || toIndex > this.size() || toIndex < fromIndex) {
			throw new IndexOutOfBoundsException("fromIndex or toIndex is out of range");
		}
		
		//Si toIndex==fromIndex, la operació no té efecte.
		if (fromIndex != toIndex) {			
			for (int index=toIndex-1; index>=fromIndex; index--) {
				this.remove(index);
			}
		
		}
	}

	/**
	 * Replaces the element at the specified position in this list with the specified element.
	 * @param index - index of the element to replace
	 * @param element - element to be stored at the specified position
	 * @return  - element to be stored at the specified position
	 * @throws IndexOutOfBoundsException  - if the index is out of range (index < 0 || index >= size())
	 */
	public Object set(int index, Object element) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException("Index fora de rang");
		}
		
		Element punterAuxiliar = this.primer;
		while (punterAuxiliar.index!=index) {
			punterAuxiliar = punterAuxiliar.seguent;
		}

		Object  antic = punterAuxiliar.dada;		
		punterAuxiliar.dada = element;
		
		return antic;
	}
	
	/**
	 * Returns the number of elements in this list.
	 * @return the number of elements in this list
	 */
	public int size() {
		int numeroDeElements = 0;
		Element ElementAuxiliar = this.primer;
		
		if (!this.isEmpty()) {
			do {
				numeroDeElements++;
				ElementAuxiliar = ElementAuxiliar.seguent;
			} while (ElementAuxiliar != this.primer ); 
		}
		
		return numeroDeElements;
	}
	
	public int sizeBack() {
		int numeroDeElements = 0;
		Element ElementAuxiliar = this.primer;
		
		if (!this.isEmpty()) {
			numeroDeElements++;
			do {
				numeroDeElements++;
				ElementAuxiliar = ElementAuxiliar.anterior;
			} while (ElementAuxiliar != this.primer ); 
		}
		
		return numeroDeElements;
	}

	/**
	 * Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
	 * @param fromIndex - low endpoint (inclusive) of the subList
	 * @param toIndex -high endpoint (exclusive) of the subList
	 * @return a view of the specified range within this list
	 * @throws IndexOutOfBoundsException - if an endpoint index value is out of range (fromIndex < 0 || toIndex > size)
	 * @throws IllegalArgumentException - if the endpoint indices are out of order (fromIndex > toIndex)
	 */
	public ArrayList subList(int fromIndex, int toIndex ) throws IndexOutOfBoundsException, IllegalArgumentException  {
		if (fromIndex < 0 || toIndex > this.size()) {
			throw new IndexOutOfBoundsException("an endpoint index value is out of range");
		}
		if (fromIndex > toIndex) {
			throw new IllegalArgumentException("the endpoint indices are out of order");
		}
		
		ArrayList subList = new ArrayList(0);
		if (fromIndex!=toIndex) {
			for (int index=fromIndex; index<toIndex; index++) {
				subList.add(this.get(index));
			}
		}
		
		return subList;
	}
	
	/**
	 * Returns an array containing all of the elements in this list in proper sequence 
	 * (from first to last element).
	 * The returned array will be "safe" in that no references to it are maintained 
	 * by this list. (In other words, this method must allocate a new array). 
	 * The caller is thus free to modify the returned array.
	 * This method acts as bridge between array-based and collection-based APIs.
	 * @return an array containing all of the elements in this list in proper sequence
	 */
	public Object[] toArray() {
		Object[] arrayResultant = new Object[this.size()];
		Element auxiliar = this.primer;
		
		if (!isEmpty()) {
			do  {
				arrayResultant[auxiliar.index] = auxiliar.dada;
				auxiliar = auxiliar.seguent;
			} while (auxiliar != this.primer);
		}
		return arrayResultant;		
	}
	
	/**
	 * Trims the capacity of this ArrayList instance to be the list's current size. 
	 * An application can use this operation to minimize the storage of an ArrayList instance.
	 */
	public void trimToSize() {
		if (!this.isEmpty()) {
			int index = 0;
			while (index<this.size()) {
				if (this.get(index)==null) {
					this.remove(index);
				} else {
					index++;
				}
			}
		}
	}
	
	public void setPrimer(Element e) {
		this.primer=e;
	}
	
	public ArrayList clone () {
		ArrayList copia = new ArrayList(0);
		copia.setPrimer(this.primer);
		return copia;
	}
	
	public String toString() {
		String cadena = "";
		Element punter = this.primer;

		if (!this.isEmpty()) {
			cadena = "";
			do {
				cadena += "[" + punter.index + ", " + punter.dada + "] ";
				punter = punter.seguent;
			} while (punter != this.primer);
		}
		return cadena;
	}
	
	public String backString() {
		String cadena = "";
		Element punter = this.primer;

		if (!this.isEmpty()) {
			cadena = "";
			do {
				punter = punter.anterior;
				cadena += "[" + punter.index + ", " + punter.dada + "] ";
			} while (punter != this.primer);
		}
		return cadena;
	}
	
}