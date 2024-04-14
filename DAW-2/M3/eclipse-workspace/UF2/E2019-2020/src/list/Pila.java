package list;

import java.util.EmptyStackException;

public class Pila extends MyList {
	/**
	 * Pushes an item onto the top of this stack. This has exactly the same effect
	 * as: addElement(item)
	 * 
	 * @param item - the item to be pushed onto this stack.
	 * @return the item argument.
	 */
	public Object push(Object item) {
		super.insertFirst(item);
		return item;
	}

	/**
	 * Removes the object at the top of this stack and returns that object as the
	 * value of this function.
	 * 
	 * @return - The object at the top of this stack (the last item of the Vector
	 *         object).
	 * @throws EmptyStackException - if this stack is empty.
	 * @throws NoElementInList 
	 */
	public Object pop() throws EmptyStackException, NoElementInList {
		if (empty()) {
            throw new EmptyStackException();
        }
        Object item = super.first();
        super.removeFirst();
        return item;
	}

	/**
	 * Looks at the object at the top of this stack without removing it from the
	 * stack.
	 * 
	 * @return the object at the top of this stack (the last item of the Vector
	 *         object).
	 * @throws EmptyStackException - if this stack is empty.
	 * @throws NoElementInList 
	 */
	public Object peek() throws EmptyStackException, NoElementInList {
		 if (this.isEmpty()) {
	            throw new EmptyStackException();
	     }
		 return super.first();
	}

	/**
	 * Tests if this stack is empty.
	 * 
	 * @return true if and only if this stack contains no items; false otherwise.
	 */
	public boolean empty() {
		return super.isEmpty();
	}
	
	
	/*
	 * Mètodes bloquejats 
	 */
	@Override
    public int indexOf(Object t) throws NoElementInList, NoIndexInList {
        throw new UnsupportedOperationException("No supportat en Pila");
    }
	@Override
	public void removeIndex(int pos) throws NoElementInList, NoIndexInList {
		throw new UnsupportedOperationException("No supportat en Pila");
	}
	@Override
    public void insertLast(Object p) {
        throw new UnsupportedOperationException("No supportat en Pila");
    }
	@Override
	public Object last() throws NoElementInList {
        throw new UnsupportedOperationException("No supportat en Pila");
    }
	@Override
	public int count() {
		throw new UnsupportedOperationException("No supportat en Pila");
	}
}
