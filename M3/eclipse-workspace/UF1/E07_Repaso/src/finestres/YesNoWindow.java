package finestres;

import java.awt.Point;
import java.util.Arrays;

public class YesNoWindow extends DialogWindow {

	public YesNoWindow(double width, double height, Point posicio, String missatge) {
		super(width, height, posicio, missatge);
		Button yes = new Button(50, 20, new Point(400, 350), "YES");
		Button no = new Button(50, 20, new Point(450, 350), "NO");
		super.add(yes);
		super.add(no);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
