import java.awt.Point;

public class YesNoWindow extends DialogWindow {

	public YesNoWindow(int width, int height, Point position, String message) {
		super(width, height, position, message);
		
		Button yes = new Button(50, 20, new Point(400, 350), "YES");
		this.addComponent(yes);
		
		Button no = new Button(50, 20, new Point(450, 350), "NO");
		this.addComponent(no);
	}

}
