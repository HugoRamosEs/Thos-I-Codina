package solucion;

import java.io.IOException;
import java.util.EmptyStackException;

public class Stack extends ArrayList {
	
	
	/**
	 * Constructor
	 * Creates an empty Stack.
	 */
	public Stack() {
		super(0);
	}
	
	/**
	 * Pushes an item onto the top of this stack. This has exactly the same effect as: addElement(item)
	 * @param item - the item to be pushed onto this stack.
	 * @return the item argument.
	 */
	public Object push(Object item) {
		super.add(super.size(),item);
		return item;
	}
	
	/**
	 * Removes the object at the top of this stack and returns that object as the value of this function.
	 * @return - The object at the top of this stack (the last item of the Vector object).
	 * @throws EmptyStackException - if this stack is empty.
	 */
	public Object pop() throws EmptyStackException {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		} 
		return super.remove(this.size()-1);
	}
	

	/**
	 * Looks at the object at the top of this stack without removing it from the stack.
	 * @return the object at the top of this stack (the last item of the Vector object).
	 * @throws EmptyStackException - if this stack is empty.
	 */
	public Object peek() throws EmptyStackException {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		} 
		return super.get(this.size()-1);
	}

	
	/**
	 * Tests if this stack is empty.
	 * @return true if and only if this stack contains no items; false otherwise.
	 */
	public boolean empty() {
		return super.isEmpty();
	}
	
	/**
	 * Returns the 1-based position where an object is on this stack. 
	 * If the object o occurs as an item in this stack, this method returns 
	 * the distance from the top of the stack of the occurrence nearest 
	 * the top of the stack; the topmost item on the stack is considered 
	 * to be at distance 1. 
	 * The equals method is used to compare o to the items in this stack.
	 * @param o  - the desired object.
	 * @return the 1-based position from the top of the stack where the object is located; 
	 * the return value -1 indicates that the object is not on the stack.
	 */
	public int search(Object o) {
		return (super.contains(o)) ? super.size()-super.indexOf(o) : -1;
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
