package solucion;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * @author toniaguilar
 *
 */
public class Queue extends ArrayList {
	private int capacity;
	
	
	/**
	 * Constructor
	 * Creates an empty Queue.
	 */
	public Queue(int capacity) {
		super(0);
		this.capacity = capacity;
	}
	
	/**
	 * Inserts the specified element into this queue if it is possible to do so immediately 
	 * without violating capacity restrictions, returning true upon success and throwing 
	 * an IllegalStateException if no space is currently available.
	 * @param item  - the element to add
	 * @return true.
	 * @throws IllegalStateException - if the element cannot be added at this time due to capacity restrictions
	 * @throws ClassCastException - if the class of the specified element prevents it from being added to this queue
	 * @throws NullPointerException - if the specified element is null and this queue does not permit null elements
	 * @throws IllegalArgumentException - if some property of this element prevents it from being added to this queue.
	 */

	public boolean add(Object item) throws IllegalStateException, ClassCastException, NullPointerException, IllegalArgumentException {
		if (super.size() >= this.capacity) {
			throw new IllegalStateException();
		}
		if (item == null) {
			throw new NullPointerException();
		}
		
		super.add(super.size(),item);
		return true;
	}
	
	/**
	 * Inserts the specified element into this queue if it is possible to do so 
	 * immediately without violating capacity restrictions. When using a 
	 * capacity-restricted queue, this method is generally preferable to add(E), 
	 * which can fail to insert an element only by throwing an exception.
	 * @param item - the element to add
	 * @return     true if the element was added to this queue, else false
	 * @throws ClassCastException - if the class of the specified element prevents it from being added to this queue
	 * @throws NullPointerException - if the specified element is null and this queue does not permit null elements
	 * @throws IllegalArgumentException - if some property of this element prevents it from being added to this queue
	 */
	public boolean offer(Object item) throws ClassCastException, NullPointerException, IllegalArgumentException {
		boolean resultat = false;
		
		if (super.size() >= this.capacity) {
			throw new IllegalStateException();
		}
		if (item == null) {
			throw new NullPointerException();
		}
		
		super.add(super.size(),item);
		if (super.contains(item)) {
			resultat = true;
		}

		return resultat;
	}
	
	
	
	/**
	 * Retrieves and removes the head of this queue. This method differs from poll only 
	 * in that it throws an exception if this queue is empty.
	 * @return - the head of this queue
	 * @throws NoSuchElementException - if this queue is empty
	 */
	public Object remove() throws NoSuchElementException {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		} 
		return super.remove(0);
	}
	

	/**
	 * Retrieves and removes the head of this queue, or returns null if this queue is empty.
	 * @return the head of this queue, or null if this queue is empty
	 */
	public Object poll() {
		return super.isEmpty() ? null : super.remove(0);
	}
	
	/**
	 * Retrieves, but does not remove, the head of this queue. This method differs from peek 
	 * only in that it throws an exception if this queue is empty.
	 * @return the head of this queue
	 * @throws NoSuchElementException - if this queue is empty
	 */
	public Object element() throws NoSuchElementException{
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		} 
		return super.isEmpty() ? null : super.get(0);
	}

	
	/**
	 * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
	 * @return the head of this queue, or null if this queue is empty
	 */
	public Object peek(){
		return super.isEmpty() ? null : super.get(0);
	}
	
	/*
	 * Mètodes a ser bloquejats 
	 */
	public void add(int index, Object element) {}
	public Object get(int index){return null;}
	public Object set(int index, Object element) {return null;}
	public Object remove(int index) {return null;}
	public boolean remove(Object o) {return false;}
	public Object[] toArray() {return null;}
	
	
	
	
	

}
