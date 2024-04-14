package list;

import java.io.IOException;
import java.util.EmptyStackException;

public class Stack extends MyList {
	
	
	/**
	 * Constructor
	 * Creates an empty Stack.
	 */
	public Stack() {
		super();
	}
	
	/**
	 * Pushes an item onto the top of this stack. This has exactly the same effect as: addElement(item)
	 * @param item - the item to be pushed onto this stack.
	 * @return the item argument.
	 */
	public Object push(Object item) {
		super.insertLast(item);
		return item;
	}
	
	/**
	 * Removes the object at the top of this stack and returns that object as the value of this function.
	 * @return - The object at the top of this stack (the last item of the Vector object).
	 * @throws EmptyStackException - if this stack is empty.
	 * @throws NoElementInList 
	 */
	public Object pop() throws EmptyStackException, NoElementInList {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		} 
		Object last=super.last();
		super.removeLast();
		return last;
	}
	

	/**
	 * Looks at the object at the top of this stack without removing it from the stack.
	 * @return the object at the top of this stack (the last item of the Vector object).
	 * @throws EmptyStackException - if this stack is empty.
	 * @throws NoElementInList 
	 */
	public Object peek() throws EmptyStackException, NoElementInList {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		} 
		return super.last();
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
	 * @throws NoIndexInList 
	 * @throws NoElementInList 
	 */
	public int search(Object o) throws NoElementInList, NoIndexInList {
		return (super.isIn(o)) ? super.indexOf(o) : -1;
	}
	
	/*
	 * Mètodes a ser bloquejats 
	 */
	public void insertFirst(Object p) {}
	public void removeFirst() throws NoElementInList {}
	public Object first() throws NoElementInList {return null;}
	public void removeIndex(int pos) throws NoElementInList, NoIndexInList {}
	
	
	
//	public void add(int index, Object element) {}
//	public Object get(int index){return null;}
//	public Object set(int index, Object element) {return null;}
//	public Object remove(int index) {return null;}
//	public boolean remove(Object o) {return false;}
//	public Object[] toArray() {return null;}
	
	
	
	
	

}
