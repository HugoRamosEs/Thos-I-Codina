package pregunta03;

import java.util.EmptyStackException;

public class Pila extends Llista {
	
	public boolean empty() {
		return super.isEmpty();
	}
	
	public Object peek() throws Exception {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		} 
		return super.last();
	}
	
	public Object pop() throws Exception {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		} 
		super.removeLast();
		return super.last();
	}
	
	public Object push(Object item) {
		super.insertLast(item);
		return item;
	}
	
	public int search(Object o) throws Exception {
		return (super.isIn(o)) ? super.count()-super.indexOf(o) : -1;
	}
	
	public Object first() {return null;}
	public void removeIndex(int pos){}
	public int indexOf(Object t) {return -1;}
	public void removeFirst() {}
	public void insertFirst(Object p) {}
}
