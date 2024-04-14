
public class GestorEsdeveniment {
	private Esdeveniment esdeveniments[];
	private int front;
	private int rear;
	private static final int MAX = 10;
	
	public GestorEsdeveniment() {
		super();
		this.esdeveniments = new Esdeveniment[MAX];
		this.front = 0;
		this.rear = 0;
	}
	
	public void enqueue(Esdeveniment e) throws Exception {
		if (this.rear + 1 == this.front) {
			throw new Exception("Error");
		}
		
		if (this.rear < this.esdeveniments.length) {
			this.esdeveniments[this.rear] = e;
			this.rear++;
		}else {
			this.esdeveniments[0] = e;
			this.rear = 0;
		}
	}
	
	public Esdeveniment dequeue() throws Exception {
		if (this.front == this.rear) {
			throw new Exception("Error");
		}
		
		Esdeveniment esborrar = this.esdeveniments[this.front];
		this.esdeveniments[this.front] = null;
		this.front++;
		if (this.front == this.esdeveniments.length) {
			this.front = 0;
		}
		return esborrar;
	}
	
	public Object clone() {
		GestorEsdeveniment cp = new GestorEsdeveniment();
		cp.setEsdeveniments(this.esdeveniments.clone());
		return cp;
	}
	
	// no se puede implementar un metodo de clase (static) "add". Los metodos de clase, sino tiene atributos, no tienen sentido.
	
	public void mostrarEsdevenimentsPendents() {

	     for (Esdeveniment e: this.esdeveniments) {

	          e.mostra();

	     }

	}

	public Esdeveniment[] getEsdeveniments() {
		return esdeveniments;
	}

	public int getFront() {
		return front;
	}

	public int getRear() {
		return rear;
	}

	public static int getMax() {
		return MAX;
	}

	public void setEsdeveniments(Esdeveniment[] esdeveniments) {
		this.esdeveniments = esdeveniments;
	}

	public void setFront(int front) {
		this.front = front;
	}

	public void setRear(int rear) {
		this.rear = rear;
	}
	
}
