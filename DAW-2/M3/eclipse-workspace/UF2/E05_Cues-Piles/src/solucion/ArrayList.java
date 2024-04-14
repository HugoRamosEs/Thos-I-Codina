package solucion;

/**
 * @author toniaguilar
 *
 */
public class ArrayList {
	private class Node {
		protected int index;
		protected Object dada;
		protected Node seguent;
		protected Node anterior;

		public Node() {
			this.index = -1;
			this.dada = null;
			this.seguent = null;
			this.anterior = null;
		}

		public Node(Object parametre) {
			this.index =-1;
			this.dada = parametre;
			this.seguent = null;
			this.anterior = null;
		}
		
		public Node(int index, Object parametre) {
			this.index = index;
			this.dada = parametre;
			this.seguent = null;
			this.anterior = null;
		}
	}
	
	/*L'ArrayList tindrà dos index per augmentar la seguretat i poder
	 * recorrer la llista en amdós sentits.
	 */
	private Node primer;
	private Node ultim;

	
	
	/**
	 * Constructs an empty list with the specified initial capacity.
	 * @param initialCapacity - the initial capacity of the list
	 * @throws IllegalArgumentException - if the specified initial capacity is negative
	 */
	public ArrayList(int initialCapacity) throws IllegalArgumentException{
		this.arrayList(initialCapacity);
	}
	
	/**
	 * Constructs an empty list with an initial capacity of ten.
	 */
	public ArrayList() {
		this.arrayList(10);
	}
	
	/**
	 * Mètode comú als constructors. Constructs an empty list with the specified initial capacity.
	 * @param initialCapacity - the initial capacity of the list
	 * @throws IllegalArgumentException - if the specified initial capacity is negative
	 */
	private void arrayList (int initialCapacity) throws IllegalArgumentException {
		this.primer = null;
		this.ultim =  null;
		
		if (initialCapacity < 0) {
			throw new IllegalArgumentException ("No pot ser un tamany negatiu");
		} else {
			for (int index = 0; index < initialCapacity; index++) {
				this.add(index, null);
			}
		}	
	}

	/**
	 * Returns true if this list contains no elements.
	 * @return true if this list contains no elements
	 */
	public boolean isEmpty() {
		return (primer == null && ultim == null);
	}
	
	/**
	 * Returns the number of elements in this list.
	 * @return the number of elements in this list
	 */
	public int size() {
		int numeroDeNodes = 0;
		Node nodeAuxiliar = this.primer;
		
		while (nodeAuxiliar != null ) {
			numeroDeNodes++;
			nodeAuxiliar = nodeAuxiliar.seguent;
		}
		return numeroDeNodes;
	}
	
	
	/**
	 * Appends the specified element to the end of this list.
	 * @param parametre - element to be appended to this list
	 */
	public boolean add (Object element) {
		this.add(this.size(), element);
		return true;
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
		Node nou = new Node(index, element);
		
		if (index < 0 || index > this.size()) {
			throw new IndexOutOfBoundsException("Index erroni: " + index);
		} else {
			if (this.isEmpty()) {
				this.primer= nou;
				this.ultim = nou;
			} else if (index == this.size()) {
				nou.anterior = this.ultim;
				this.ultim.seguent = nou;
				this.ultim = nou;
			} else {
				Node auxiliar = this.primer;
				int posicio = 0;
				
				if (index == 0) {
					nou.seguent = this.primer;
					this.primer = nou;
				} else {
					Node anterior = null;
					while (posicio != index) {
						anterior = auxiliar;
						auxiliar = auxiliar.seguent;
						posicio ++;
					}
					nou.anterior = anterior;
					nou.seguent = auxiliar;
					anterior.seguent = nou;
					auxiliar.anterior = nou;
				}
				while (auxiliar != null) {
					auxiliar.index ++;
					auxiliar = auxiliar.seguent;
				}
	
			}
		}

	}
	
	/**
	 * 
	 * Removes all of the elements from this list. The list will be empty after this call returns.
	 */
	public void clear() {
		this.primer = null;
		this.ultim = null;
	}
	
	/**
	 * Returns true if this list contains the specified element. More formally, 
	 * returns true if and only if this list contains at least one element e 
	 * such that (o==null ? e==null : o.equals(e)).
	 * @param o - element whose presence in this list is to be tested
	 * @return true if this list contains the specified element
	 */
	public boolean contains(Object o) {
		boolean conteObjecte = false;
		Node punterAuxiliar = this.primer;
		
		while ((punterAuxiliar != null) && (conteObjecte == false)) {
			if (o==null) {
				if (punterAuxiliar.dada == null) {
					conteObjecte = true;
				} else {
					punterAuxiliar = punterAuxiliar.seguent;
				}
			} else {
				if (o.equals(punterAuxiliar.dada)) {
					conteObjecte = true;
				} else {
					punterAuxiliar = punterAuxiliar.seguent;
				}
			}
		}
		return conteObjecte;
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
		Node punterAuxiliar = this.primer;
	
		if (this.contains(o)) {
			while ((punterAuxiliar != null) && (index == -1)) {
				if (o==null) {
					if (punterAuxiliar.dada == null) {
						index = punterAuxiliar.index;
					} else {
						punterAuxiliar = punterAuxiliar.seguent;
					}
				} else {
					if (o.equals(punterAuxiliar.dada)) {
						index = punterAuxiliar.index;
					} else {
						punterAuxiliar = punterAuxiliar.seguent;
					}
				}
			}
		}
		return index;
	}
	
	
	/**
	 * Returns the element at the specified position in this list.
	 * @param index  - index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
	 */
	public Object get(int index) throws IndexOutOfBoundsException {
		Node punterAuxiliar = this.primer;
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException ("index fora de rang");
		} else {
			
			while ((punterAuxiliar!=null) && (punterAuxiliar.index!=index)) {
				punterAuxiliar = punterAuxiliar.seguent;
			}
		}
		return punterAuxiliar.dada;
	}
	
	/**
	 * Replaces the element at the specified position in this list with the specified element.
	 * @param index - index of the element to replace
	 * @param element - element to be stored at the specified position
	 * @return  - element to be stored at the specified position
	 * @throws IndexOutOfBoundsException  - if the index is out of range (index < 0 || index >= size())
	 */
	public Object set(int index, Object element) throws IndexOutOfBoundsException {
		Node punterAuxiliar = this.primer;
		Object dadaAnterior;
		
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException ("index fora de rang");
		} else {
			
			while ((punterAuxiliar!=null) && (punterAuxiliar.index!=index)) {
				punterAuxiliar = punterAuxiliar.seguent;
			}
		}
		dadaAnterior = punterAuxiliar.dada;
		punterAuxiliar.dada = element;
		return dadaAnterior;
	}
	
	/**
	 * Removes the element at the specified position in this list. 
	 * Shifts any subsequent elements to the left (subtracts one from their indices).
	 * @param index - the index of the element to be removed
	 * @return the element that was removed from the list
	 * @throws IndexOutOfBoundsException  - if the index is out of range (index < 0 || index >= size())
	 */
	public Object remove(int index) throws IndexOutOfBoundsException {
		Node punterAuxiliar = this.primer;
		Object dadaAnterior;
		
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException ("index fora de rang");
		} else {
			while ((punterAuxiliar!=null) && (punterAuxiliar.index!=index)) {
				punterAuxiliar = punterAuxiliar.seguent;
			}
		}
		dadaAnterior = punterAuxiliar.dada;
		if (punterAuxiliar.anterior == null) {
			this.primer = punterAuxiliar.seguent;
			punterAuxiliar.seguent.anterior = null;
		} else {
			punterAuxiliar.anterior.seguent = punterAuxiliar.seguent;
		}
		if (punterAuxiliar.seguent == null) {
			this.ultim = punterAuxiliar.anterior;
			punterAuxiliar.seguent = null;
		} else {
			punterAuxiliar.seguent.anterior = punterAuxiliar.anterior;
		}
		
		while (punterAuxiliar!=null) {
			punterAuxiliar.index = punterAuxiliar.index -1;
			punterAuxiliar = punterAuxiliar.seguent;
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
		Node punterAuxiliar = this.primer;
		Object dadaAnterior;

		if (this.contains(o)) {
			existeix = true;
			this.remove(this.indexOf(o));
		}
		return existeix;
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
		Node auxiliar = this.primer;
		
		while (auxiliar != null) {
			arrayResultant[auxiliar.index] = auxiliar.dada;
			auxiliar = auxiliar.seguent;
		}
		return arrayResultant;		
	}
	
	
	/*
	 * Getters i setters
	 */
	public void setPrimer(Node primer) {
		this.primer = primer;
	}
	
	public void setUltim(Node ultim) {
		this.ultim = ultim;
	}

	/* Returns a shallow copy of this ArrayList instance. (The elements themselves are not copied.)
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 * Returns: a clone of this ArrayList instance
	 */
	public Object clone () {
		ArrayList copia = new ArrayList(0);
		copia.setPrimer(this.primer);
		copia.setUltim(this.ultim);
		return copia;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String cadena = "";
		Node punter = this.primer;

		while (punter != null) {
			cadena = cadena + "[" + punter.index + ", " + punter.dada + "] ";
			punter = punter.seguent;
		}
		return cadena;
	}

}