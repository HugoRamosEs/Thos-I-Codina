import java.awt.Point;

public class DialogWindow extends Window{
	// ATRIBUTS
	private String message;
	
	//CONSTRUCTORS
	public DialogWindow(int width, int height, Point position, String message) {
		super(width, height, position);
		this.message = message;
	}
	
	public DialogWindow(String msg, int nombreDeBotons) {
		super(0,0, new Point(0,0));
		this.message = msg;
	}
	
	// GETTERS I SETTERS
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// OVERRIDES
	@Override
	public String toString() {
		return "Missatge: " + this.message + super.toString();
	}
}
