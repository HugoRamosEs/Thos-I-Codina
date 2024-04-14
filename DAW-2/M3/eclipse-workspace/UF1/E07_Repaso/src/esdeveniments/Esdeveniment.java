package esdeveniments;

public class Esdeveniment implements Mostrable {
	private Object source;
	private int num;
	private static int last;
	
	public Esdeveniment(Object source) {
		super();
		this.source = source;
		this.num = Esdeveniment.last++;
	}

	public Object getSource() {
		return source;
	}

	public int getNum() {
		return num;
	}

	public static int getLast() {
		return last;
	}

	public void setSource(Object source) {
		this.source = source;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public static void setLast(int last) {
		Esdeveniment.last = last;
	}

	@Override
	public String toString() {
		return "Esdeveniment [source=" + source + ", num=" + num + "]";
	}

	@Override
	public boolean mostra() {
		return false;
	}
}
