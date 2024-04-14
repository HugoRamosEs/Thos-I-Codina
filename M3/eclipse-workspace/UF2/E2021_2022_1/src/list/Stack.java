package list;

import java.util.EmptyStackException;


public class Stack extends MyList{
	
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
		if (super.count() == 0) {
			throw new EmptyStackException();
		}
		Object aux = super.last();
		super.removeLast();
		return aux;
	}
	
	/**
	 * Looks at the object at the top of this stack without removing it from the stack.
	 * @return the object at the top of this stack (the last item of the Vector object).
	 * @throws EmptyStackException - if this stack is empty.
	 * @throws NoElementInList 
	 */
	public Object peek() throws EmptyStackException, NoElementInList {
		if (super.count() == 0) {
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
	
	public void insertFirst(Object p) {	}

	public void insertLast(Object p) { }

	public void removeFirst() throws NoElementInList { }

	public void removeLast() throws NoElementInList { }
	
	public void removeIndex(int pos) throws NoElementInList, NoIndexInList { }

}
