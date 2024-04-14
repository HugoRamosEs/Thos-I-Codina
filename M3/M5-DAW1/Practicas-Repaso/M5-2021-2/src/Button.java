import java.awt.Point;

public class Button extends Component {
	private String text;
	
	public Button(int width, int height, Point position, String text) {
		super(width, height, position);
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "BUTTON -> " + this.text +" - "+ super.toString();
	}
	
}
