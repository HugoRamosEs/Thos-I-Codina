package esdeveniments;

import java.util.Arrays;

public class GestorEsdeveniments {
	private Esdeveniment[] esdeveniments;
	private int num;
	private int front;
	private int rear;
	
	public GestorEsdeveniments() {
		super();
		this.esdeveniments = new Esdeveniment[10];
		this.num = 0;
	}
	
	public void add(Esdeveniment e) {
		if (this.num == 10) {
			System.out.println("Limit máxim excedit");
		}
		
		this.esdeveniments[this.num] = e;
		this.num++;
	}
	
	public void enqueue(Esdeveniment e) {
		if ((this.rear + 1) == this.front) {
			this.rear = this.rear%10;
		}
		
		this.esdeveniments[this.rear++] = e;
	}
	
	public Object clone() {
		GestorEsdeveniments gE = new GestorEsdeveniments();
		gE.setEsdeveniments(this.esdeveniments.clone());
		return gE;
	}
	
	public void mostrarEsdevenimentsPendents() {
	     for (Esdeveniment e: this.esdeveniments) {
	          System.out.println(e.mostra());
	     }
	}

	public Esdeveniment[] getEsdeveniments() {
		return esdeveniments;
	}

	public int getNum() {
		return num;
	}

	public int getFront() {
		return front;
	}

	public int getRear() {
		return rear;
	}

	public void setEsdeveniments(Esdeveniment[] esdeveniments) {
		this.esdeveniments = esdeveniments;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setFront(int front) {
		this.front = front;
	}

	public void setRear(int rear) {
		this.rear = rear;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("COMPONENTS:\n");
		for (int i=0; i<this.esdeveniments.length; i++) {
			if (this.esdeveniments[i] != null) {
				sb.append(this.esdeveniments[i]);
				sb.append("\n");
			}
		}
		return sb.toString();
	}
}
