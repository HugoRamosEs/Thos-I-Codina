package thosi;
import java.util.EmptyStackException;

public class Stack extends Llista {
	public Stack() {
		super();
	}
	
	public boolean isEmpty() {
		return super.isEmpty();
	}
	
	public Object peek() throws EmptyStackException {
		 if (this.isEmpty()) {
	            throw new EmptyStackException();
	     }
		 return super.get(0);
	}
	
	public Object pop() throws EmptyStackException {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		}
		Object e = super.get(0);
		super.removeIndex(0);
		return e;
	}
	
	public void push(Object e) {
		super.add(e);
	}
	
	public int search(Object o) {
		return super.indexOf(o);
	}	
	
	@Override
    public String toString() {
        return super.toString();
    }
}
