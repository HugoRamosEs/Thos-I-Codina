package thosi;

public class Decimal implements Comparable {
	private double d;

	public Decimal(double d) {
		this.d = d;
	}

	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}

	@Override
	public int compareTo(Object obj) {
		if (this == obj)
			return 0;
		if (obj == null)
			throw new NullPointerException();
		if (getClass() != obj.getClass())
			throw new ClassCastException();
		Decimal other = (Decimal) obj;
		if (this.d < other.getD()) {
			return -1;
		}
		if (this.d > other.getD()) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "" + this.d;
	}
}