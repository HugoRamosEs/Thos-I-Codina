package finestres;

import java.awt.Point;
import java.util.Arrays;

public class Window extends Component {
	private Component[] components;
	private static final int MAX = 10;
	private int num;
	
	public Window(double width, double height, Point posicio) {
		super(width, height, posicio);
		this.components = new Component[Window.MAX];
		this.num = 0;
	}
	
	public void add(Component c) {
		if (this.num == Window.MAX) {
			System.out.println("Limit máxim de components exedit.");
		}
		
		this.components[this.num] = c;
		this.num++;
	}
	
	public void remove() {
		if (this.num < 0) {
			System.out.println("Limit mínim de components exedit.");
		}
		
		this.components[this.num] = null;
		this.num--;
	}
	
	public Object clone() {
		Window cp = new Window(super.getWidth(), super.getHeight(), super.getPosicio());
		cp.setComponents(this.components.clone());
		return cp;
	}

	public Component[] getComponents() {
		return components;
	}

	public static int getMax() {
		return MAX;
	}

	public int getNum() {
		return num;
	}

	public void setComponents(Component[] components) {
		this.components = components;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("\nComponents: \n");
	    for (int i = 0; i < this.components.length; i++) {
	    	if (this.components[i] != null) {
	    		sb.append(this.components[i]);
		        sb.append("\n");
	    	}
	    }
	    return sb.toString();		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}
