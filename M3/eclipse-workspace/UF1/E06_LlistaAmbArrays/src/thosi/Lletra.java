package thosi;

public class Lletra implements Comparable {
	private char ll;
	
	public Lletra(char ll) {
		super();
		this.ll = ll;
	}

	public char getLl() {
		return ll;
	}

	public void setLl(char ll) {
		this.ll = ll;
	}

	@Override
	public int compareTo(Object obj) {
		if (this == obj)
			return 0;
		if (obj == null)
			throw new NullPointerException();
		if (getClass() != obj.getClass())
			throw new ClassCastException();
		Lletra other = (Lletra) obj;
		int uniLl = this.ll;
		int uniOt = other.getLl();
		if (uniLl < uniOt) {
			return -1;
		}
		if (uniLl > uniOt) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return "" + this.ll;
	}

}
