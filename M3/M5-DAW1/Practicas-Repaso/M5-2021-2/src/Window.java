import java.awt.Point;
import java.util.Arrays;

public class Window extends Component {
	private Component components [];
	private int numComponents;
	
	public Window(int width, int height, Point position) {
		super(width, height, position);
		this.components = new Component[10];
		this.numComponents = 0;
	}
	
	public void addComponent(Component c) {
		if (numComponents < 10) {
			this.components[this.numComponents] = c;
			this.numComponents++;
		}
	}
	
	public Component remComponent() {
		Component esborrar = null;
		if (numComponents > 0) {
			esborrar = this.components[this.numComponents - 1];
			this.components[this.numComponents] = null;
			this.numComponents--;
		}
		return esborrar;
	}
	
	public Object clone() {
		Window cp = new Window(super.getWidth(), super.getHeight(), super.getPosition());
		cp.setComponents(this.components.clone());
		return cp;
	}

	public Component[] getComponents() {
		return components;
	}

	public int getNumComponents() {
		return numComponents;
	}
	
	public void setComponents(Component[] components) {
		this.components = components;
	}

	public void setNumComponents(int numComponents) {
		this.numComponents = numComponents;
	}

	@Override
	public String toString() {
		String res = super.toString() + "\nComponents: \n";
		for (int i=0; i<numComponents; i++) {
			res += this.components[i].toString() + "\n";
		}
		return res;
	}
	
	
}
