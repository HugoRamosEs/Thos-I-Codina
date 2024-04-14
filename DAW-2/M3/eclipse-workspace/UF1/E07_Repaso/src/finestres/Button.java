package finestres;

import java.awt.Point;

public class Button extends Component {
	private String text;

	public Button(double width, double height, Point posicio, String text) {
		super(width, height, posicio);
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
		return "BUTTON -> " + this.text + " - "  + super.toString();
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}
