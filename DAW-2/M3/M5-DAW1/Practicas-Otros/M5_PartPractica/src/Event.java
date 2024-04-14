
public class Event extends Source {
	
	@Override
    public Event clone() throws CloneNotSupportedException {
        return (Event) super.clone();
    }

	public int mostra() {
		return super.generadorId();
	}
}
