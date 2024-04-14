
public class GestorEsdeveniments {
	private Evento [] cola;
	private int front;
	private int rear;
	private static final int TAM = 10;
	
	public GestorEsdeveniments(){
		this.cola = new Evento[TAM];
		this.front = 0;
		this.rear = 0; 
	}
	
	public void enqueue (Evento e) {
		if ((this.rear + 1) == this.front) {
			this.rear = this.rear%10;
		}
		
		this.cola[this.rear++] = e;
	}
	
	public Object clone() {
		GestorEsdeveniments copiaProfunda = new GestorEsdeveniments();
		copiaProfunda.setCola(this.cola.clone());
		copiaProfunda.setFront(this.front);
		
		return copiaProfunda;
	}
	
	// no se puede implementar un metodo de clase (static) "add". Los metodos de clase, sino tiene atributos, no tienen sentido.

	public Evento[] getCola() {
		return cola;
	}

	public int getFront() {
		return front;
	}

	public int getRear() {
		return rear;
	}

	public static int getTam() {
		return TAM;
	}

	public void setCola(Evento[] cola) {
		this.cola = cola;
	}

	public void setFront(int front) {
		this.front = front;
	}

	public void setRear(int rear) {
		this.rear = rear;
	}
	
	
}
