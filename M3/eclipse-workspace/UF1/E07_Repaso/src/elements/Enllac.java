package elements;

public class Enllac {
	private Element[] elements;
	private int num;
	
	public Enllac() {
		super();
		this.elements = new Element[10];
		this.num = 0;
	}
	
	// Metodo add como todos
	
	public Object cloneSuperficial() {
		Enllac e = new Enllac();
		e.setElements(this.elements);
		return e;
	}
	
	public Element[] getElements() {
		return elements;
	}
	public int getNum() {
		return num;
	}
	public void setElements(Element[] elements) {
		this.elements = elements;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
