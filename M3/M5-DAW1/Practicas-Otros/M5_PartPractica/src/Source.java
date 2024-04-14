
public class Source {
	private int num;
	
	public Source() {
		this.num = generadorId();
	}
	
	public int generadorId() {
		return this.num++;
	}
}
