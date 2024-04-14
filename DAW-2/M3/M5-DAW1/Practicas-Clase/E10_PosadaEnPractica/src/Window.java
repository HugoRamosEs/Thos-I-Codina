import java.awt.Point;
import java.util.Arrays;

public class Window extends Component {
	// ATRIBUTS
	private Component components[];
	private int numeroComponents;
	
	// CONSTRUCTORS
	public Window(int width, int height, Point position) {
		super(width, height, position);
		this.components = new Component[10];
		this.numeroComponents = 0;
	}
	
	// METODES

	
	public void addComponent(Component toAdd) throws Exception {
		if (this.numeroComponents < 10) {
			this.components[this.numeroComponents] = toAdd;
	    	this.numeroComponents++;
    	}
	}
	
	public Component removeComponent() throws Exception {
		Component esborrat = null;
		if (this.numeroComponents > 0) {
			esborrat = this.components[this.numeroComponents - 1];
			this.components[this.numeroComponents] = null;
			this.numeroComponents--;
		}
		return esborrat;
	}
	
	// GETTERS I SETTERS
	public Component[] getComponents() {
		return components;
	}

	public int getNumeroComponents() {
		return numeroComponents;
	}

	public void setComponents(Component[] components) {
		this.components = components;
	}

	public void setNumeroComponents(int numeroComponents) {
		this.numeroComponents = numeroComponents;
	}

	// OVERRIDES
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Window copia = new Window(this.getHeight(), this.getWidth(), new Point(this.getPosition().x, this.getPosition().y));
		for (int i=0; i<this.numeroComponents; i++) {
			try {
				copia.addComponent((Component)this.components[i].clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return copia;
	}
	
	@Override
	public String toString() {
		String res = super.toString() + "\n Components: \n";
		for (int i=0; i<this.numeroComponents; i++) {
			res += this.components[i].toString() + "\n";
		}
		return res;
	}	
}