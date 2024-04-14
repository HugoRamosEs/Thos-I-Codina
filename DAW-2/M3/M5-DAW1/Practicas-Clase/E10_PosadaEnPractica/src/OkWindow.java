import java.awt.Point;

public class OkWindow extends DialogWindow{
	//CONSTRUCTORS
	public OkWindow(int width, int height, Point position, String message) throws Exception {
		super(width, height, position, message);
		
		Button ok = new Button(50,20,new Point(450, 350), "OK");
		this.addComponent(ok);
	}
}
