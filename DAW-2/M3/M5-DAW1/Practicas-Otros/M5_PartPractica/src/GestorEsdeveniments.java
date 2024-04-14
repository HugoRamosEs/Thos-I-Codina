
public class GestorEsdeveniments extends Event{
	private final Event[] cua;
	private Event events[];
	private int numEvents;
	private int inicial;
	
	public GestorEsdeveniments() {
		this.numEvents = generadorId();
		this.inicial = 0;
		this.cua = new Event[5];
		this.events = new Event[numEvents];
	}
	
	public void add(Event toAdd) throws Exception {
		if (this.inicial == this.numEvents) {
    		throw new Exception("No se pueden añadir más eventos.");
    	}
		this.events[this.numEvents] = toAdd;
    	this.inicial++;
	}
	
	@Override
	public GestorEsdeveniments clone() throws CloneNotSupportedException {
		GestorEsdeveniments copia = (GestorEsdeveniments) super.clone();

		copia.events = new Event[this.events.length];
		for (int i = 0; i < this.numEvents; i++) {
			if (this.events[i] != null) {
				copia.events[i] = this.events[i].clone(); // Copia profunda de cada evento
			}
		}

		return copia;
	}
	
	public void enqueu() {
		for (int i=0; i<cua.length; i++) {
			
		}
	}
	
	
	
	public void mostrarEsdevenimentsPendents() {

	     for (Event e: this.cua) {

	          System.out.println(e.mostra());

	     }

	}
}
