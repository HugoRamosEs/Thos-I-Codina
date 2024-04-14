package thosi;

public class Enter implements Comparable {
	private int i;

	public Enter(int i) {
		super();
		this.i = i;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	@Override
	public int compareTo(Object obj) {
		if (this == obj)
			return 0;
		if (obj == null)
			throw new NullPointerException();
		if (getClass() != obj.getClass())
			throw new ClassCastException();
		Enter other = (Enter) obj;
		if (this.i < other.getI()) {
			return -1;
		}
		if (this.i > other.getI()) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "" + this.i;
	}
	
	
}
