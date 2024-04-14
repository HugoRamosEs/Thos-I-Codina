
public abstract class Esdeveniment implements Mostrable {
	private Object source;
	private int num;
	private static int last;
	
	public Esdeveniment(Object source) {
		this.source = source;
		this.num = Esdeveniment.last++;
	}

}
