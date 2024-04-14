package finestres;

import java.awt.Point;

public class OkWindow extends DialogWindow {

	public OkWindow(double width, double height, Point posicio, String missatge) {
		super(width, height, posicio, missatge);
		Button ok = new Button(50, 20, new Point(450, 350), "OK");
		super.add(ok);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
