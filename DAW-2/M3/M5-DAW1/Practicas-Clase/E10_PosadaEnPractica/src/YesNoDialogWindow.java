import java.awt.Point;

public class YesNoDialogWindow extends DialogWindow {
	//CONSTRUCTORS
	public YesNoDialogWindow(int width, int height, Point position, String message) throws Exception {
		super(width, height, position, message);
		
		Button yes = new Button(50,20,new Point(450, 350), "YES");
		this.addComponent(yes);
		
		Button no = new Button(50,20,new Point(450, 350), "NO");
		this.addComponent(no);
	}
}
