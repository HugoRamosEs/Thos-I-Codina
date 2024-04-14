package lista;

import java.io.IOException;
import java.util.EmptyStackException;

public class Stack extends Llista {
	
	
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
	
	/*
	 * Mètodes a ser bloquejats 
	 */
	public void insertFirst(Object p) {}
	public void removeFirst() throws NoElementInList {}
	public Object first() throws NoElementInList {return null;}
	public int removeIndex(int pos) throws NoElementInList, NoIndexInList { return 0;}
	
	
	
//	public void add(int index, Object element) {}
//	public Object get(int index){return null;}
//	public Object set(int index, Object element) {return null;}
//	public Object remove(int index) {return null;}
//	public boolean remove(Object o) {return false;}
//	public Object[] toArray() {return null;}
	
	
	
	
	

}
