package thosi;
import java.util.NoSuchElementException;

public class Queue {
	public class Element {
		private Object dada;
		private Element seguent;
		
		public Element (Object e) {
			if (e == null) {
				throw new NullPointerException("No es pot afegir un null.");
			}
			this.dada = e;
			this.seguent = null;
		}
		
		@Override
	    public String toString() {
			return dada.toString();
	    }
	}
	private Element primer;
	
    public Queue() {
        this.primer = null;
    }

    public boolean add(Object e) throws IllegalStateException, ClassCastException, IllegalArgumentException, NullPointerException {
    	if (e == null) {
            throw new NullPointerException();
        }
        Element element = new Element(e);
        if (primer == null) {
            this.primer = element;
        }else {
            Element actual = primer;
            while (actual.seguent != null) {
                actual = actual.seguent;
            }
            actual.seguent = element;
        }
        return true;
    }
    
    public Object element() throws NoSuchElementException{
    	if (this.primer == null) {
    		throw new NoSuchElementException();
    	}
    	return this.primer;
    }

    public boolean offer(Object e) throws ClassCastException, NullPointerException, IllegalArgumentException {
        return this.add(e);
    }

    public Object peek() {
        if (this.primer == null) {
            return null;
        }
        return this.primer;
    }

    public Object poll() {
        if (this.primer == null) {
            return null;
        }
        Object e = this.primer;
        if (this.primer.equals(e)) {
			this.primer = this.primer.seguent;
		}
        return e;
    }

    public Object remove() throws NoSuchElementException {
        if (this.primer == null) {
            throw new NoSuchElementException();
        }
        Object e = this.primer;
        if (this.primer.equals(e)) {
			this.primer = this.primer.seguent;
		}
        return e;
    }
    
    @Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
		Element aux = this.primer;

		while (aux != null) {
			sb.append(aux.dada.toString() + "-");
			aux = aux.seguent;
		}
		return sb.toString();
	}
}
