
public abstract class Evento implements Mostrable {
	private Object source;
	private int id;
	private static int last;
	
	public Evento(Object e) {
		this.source = e;
		this.id = Evento.last++;
	}
}
