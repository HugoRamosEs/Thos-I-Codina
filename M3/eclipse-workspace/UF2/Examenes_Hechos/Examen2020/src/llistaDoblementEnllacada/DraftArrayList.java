package llistaDoblementEnllacada;

import java.util.HashMap;

import slider.MyException;

/**
 * @author toniaguilar
 *
 */
/**
 * @author toni
 *
 */
public class DraftArrayList implements Ordenable {

	private class Element {
		protected int index;
		protected Object dada;
		protected Element seguent;
		protected Element anterior;

		public Element() {
			this.index = -1;
			this.dada = null;
			this.seguent = null;
			this.anterior = null;
		}

		public Element(Object parametre) {
			this.index =-1;
			this.dada = parametre;
			this.seguent = null;
			this.anterior = null;
		}
		
		public Element(int index, Object parametre) {
			this.index = index;
			this.dada = parametre;
			this.seguent = null;
			this.anterior = null;
		}
	}
	
	/*L'ArrayList tindrà dos index per augmentar la seguretat i poder
	 * recorrer la llista en amdós sentits.
	 */
	private Element primer;
	private Element ultim;

	
	/**
	 * Pregunta 3
	 * Examen 2020-2021
	 */	

    public DraftArrayList(HashMap<Integer, Object> mapDStrings) throws MyException {
        if (!esClauNumerica(mapDStrings)) {
            throw new MyException("003", "Les claus no són numèriques");
        }

        for (Integer key : mapDStrings.keySet()) {
            this.add(key, mapDStrings.get(key));
        }
    }

	 private boolean esClauNumerica(HashMap<?, ?> map) {
	        for (Object key : map.keySet()) {
	            if (!(key instanceof Number)) {
	                return false;
	            }
	        }
	        return true;
	    }
	
	/**
	 * Constructs an empty list with the specified initial capacity.
	 * @param initialCapacity - the initial capacity of the list
	 * @throws IllegalArgumentException - if the specified initial capacity is negative
	 */
	public DraftArrayList(int initialCapacity) throws IllegalArgumentException{
		if (initialCapacity < 0) {
			throw new IllegalArgumentException ("No pot ser un tamany negatiu");
		}
		
		this.primer = null;
		this.ultim =  null;

		for (int index = 0; index < initialCapacity; index++) {
			this.add(index, null);
		}
	}
	
	/**
	 * Constructs an empty list with an initial capacity of ten.
	 */
	public DraftArrayList() {
		new DraftArrayList(10);
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

		Element nou = new Element(index, element);

		// Si la llista està buida, només hauré de modificar les referències primer i ultim
		// al nou Element creat
		if (this.isEmpty()) {
			this.primer= nou;
			this.ultim = nou;
		} else if (index == this.size()) {
		// En el cas que hagin elements a la llista, hauré de contemplat tres casos:
			// 1.- que volem insertar al final de la llista: Cambiem relacions de Elements i 
			// l'apuntador a ultim... i no haurem de incrementar els indexos a la dreta (ja és el darrer)
			
			nou.anterior = this.ultim;
			this.ultim.seguent = nou;
			this.ultim = nou;
		} else {
			Element auxiliar = this.primer;

			// Si els vull insertat a l'esquerra:
			//2.- Inserto al primer Element: Cambiem relacions de Elements i l'apuntador a primer.
			if (index == 0) {
				nou.seguent = this.primer;
				this.primer.anterior = nou;
				this.primer = nou;
			} else {
			//3.- Inserto enmig: Cambiem relacions de Elements.
				while (auxiliar.index != index) {
					auxiliar = auxiliar.seguent;
				}
				nou.anterior = auxiliar.anterior;
				nou.seguent = auxiliar;
				auxiliar.anterior.seguent = nou;
				auxiliar.anterior = nou;
			}
			
			// i re-numero tots els que hi ha a la dreta.
			while (auxiliar != null) {
				auxiliar.index ++;
				auxiliar = auxiliar.seguent;
			}
		}
	}	
	
	/**
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
		/* Programant o fent servir indexOf
		boolean conteObjecte = false;
		Element punterAuxiliar = this.primer;
		
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
		*/
		return indexOf(o)==-1 ? false : true;
	}
	
	/**
	 * Returns the element at the specified position in this list.
	 * @param index  - index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
	 */
	public Object get(int index) throws IndexOutOfBoundsException {
		return (this.obtenirElement(index)).dada;
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
	 * 
	
	/**
	 * Returns the index of the last occurrence of the specified element in this list, 
	 * or -1 if this list does not contain the element. 
	 * More formally, returns the highest index i such that 
	 * (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
	 *
	 * @param o
	 * @return Returns the index of the last occurrence of the specified element in this list, 
	 * or -1 if this list does not contain the element.
	 */
	public int lastIndexOf(Object o) {
		int index = -1;		
		int tamany = this.size();
		int i = tamany-1;
		while (i>=0 && index==-1 ) {
			if ((o==null) ? get(i)==null : o.equals(get(i))) {
				index = i;
			}
			i--;
		}		
		return index;
		
	}

	/**
	 * Returns true if this list contains no elements.
	 * @return true if this list contains no elements
	 */
	public boolean isEmpty() {
		return (primer == null && ultim == null);
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

		Element punterAuxiliar = this.obtenirElement(index);
		Object dadaAnterior = punterAuxiliar.dada;
		
		if (this.size() == 1) {
			this.primer = null;
			this.ultim = null;
		} else {
			// Cas index 0
			if (index == 0) {
				this.primer = punterAuxiliar.seguent;
				this.primer.anterior = null;
			} else if (index==this.size()-1) {
				// Cas index size()
				this.ultim = punterAuxiliar.anterior;
				this.ultim.seguent = null;
			} else {
				punterAuxiliar.anterior.seguent = punterAuxiliar.seguent;
				punterAuxiliar.seguent.anterior = punterAuxiliar.anterior;
			}
			punterAuxiliar = punterAuxiliar.seguent;
			
			// Modifico els registres posteriors
			while (punterAuxiliar!=null) {
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
	 * Replaces the element at the specified position in this list with the specified element.
	 * @param index - index of the element to replace
	 * @param element - element to be stored at the specified position
	 * @return  - element to be stored at the specified position
	 * @throws IndexOutOfBoundsException  - if the index is out of range (index < 0 || index >= size())
	 */
	public Object set(int index, Object element) throws IndexOutOfBoundsException {
		Element aux = this.obtenirElement(index);
		Object  antic = aux.dada;
		
		aux.dada = element;
		return antic;
	}
	
	/**
	 * Returns the number of elements in this list.
	 * @return the number of elements in this list
	 */
	public int size() {
		int numeroDeElements = 0;
		Element ElementAuxiliar = this.primer;
		
		while (ElementAuxiliar != null ) {
			numeroDeElements++;
			ElementAuxiliar = ElementAuxiliar.seguent;
		}
		return numeroDeElements;
	}
	
	/**
	 * Returns a view of the portion of this list between the specified fromIndex, 
	 * inclusive, and toIndex, exclusive. (If fromIndex and toIndex are equal, 
	 * the returned list is empty.) The returned list is backed by this list, 
	 * so non-structural changes in the returned list are reflected in this list, 
	 * and vice-versa. The returned list supports all of the optional list operations. 
	 * @param fromIndex
	 * @param toIndex
	 * @return
	 */
	public DraftArrayList subList(int fromIndex, int toIndex) {
		if (fromIndex < 0 || toIndex > this.size()) {
			throw new IndexOutOfBoundsException("Index fora de rang");
		}
		if (fromIndex > toIndex) {
			throw new IllegalArgumentException("Final fora de rang");
		}
		
		DraftArrayList novaSubllista = new DraftArrayList();
		novaSubllista.setPrimer(this.obtenirElement(fromIndex));
		novaSubllista.setUltim(this.obtenirElement(toIndex-1));
		return novaSubllista;
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
		
		while (auxiliar != null) {
			arrayResultant[auxiliar.index] = auxiliar.dada;
			auxiliar = auxiliar.seguent;
		}
		return arrayResultant;		
	}
	
	/**
	 * @param index - Posició que volem trobar el Element
	 * @return El Element de la posició index
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
	 */
	private Element obtenirElement(int index) throws IndexOutOfBoundsException{
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException ("index fora de rang");
		} 

		Element punterAuxiliar = this.primer;
		while (punterAuxiliar.index!=index) {
			punterAuxiliar = punterAuxiliar.seguent;
		}
		return punterAuxiliar;
	}
	
	
	/*
	 * Getters i setters
	 */
	public void setPrimer(Element primer) {
		this.primer = primer;
	}
	
	public void setUltim(Element ultim) {
		this.ultim = ultim;
	}

	/* Returns a shallow copy of this ArrayList instance. (The elements themselves are not copied.)
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 * Returns: a clone of this ArrayList instance
	 */
	public Object clone () {
		DraftArrayList copia = new DraftArrayList(0);
		copia.setPrimer(this.primer);
		copia.setUltim(this.ultim);
		return copia;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String cadena = "";
		Element punter = this.primer;

		while (punter != null) {
			cadena = cadena + "[" + punter.index + ", " + punter.dada + "] ";
			punter = punter.seguent;
		}
		return cadena;
	}
	
	public int sizeBack() {
		int numeroDeElements = 0;
		Element ElementAuxiliar = this.ultim;
		
		while (ElementAuxiliar != null ) {
			numeroDeElements++;
			ElementAuxiliar = ElementAuxiliar.anterior;
		}
		return numeroDeElements;
	}
	
	@Override
    public boolean menorQue(Object o) {
        if (o == null)
            throw new NullPointerException("No se puede comparar con un null");
        if (this.getClass() != o.getClass())
            throw new ClassCastException("No se pueden comparar objetos de diferentes tipos");
        DraftArrayList altreLlista = (DraftArrayList) o;
        
        return this.size() < altreLlista.size();

    }

}