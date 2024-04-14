import java.awt.Point;

public class Button extends Component {
	// ATRIBUTS
	private String text;
	
	// CONSTRUCTORS
	public Button(int width, int height, Point position, String text) {
		super(width, height, position);
		this.text = text;
	}
	
	// GETTERS I SETTERS
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	// OVERRIDES
	@Override
	public String toString() {
		return "BUTTON -> " + this.text + " - " + super.toString();
	}

}
