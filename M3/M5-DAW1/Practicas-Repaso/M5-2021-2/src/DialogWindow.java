import java.awt.Point;

public class DialogWindow extends Window {
	private String message;
	private int nombreBotons;
	
	public DialogWindow(int width, int height, Point position, String message) {
		super(width, height, position);
		this.setMessage(message);
	}
	
	public DialogWindow(String msg, int nombreBotons) {
		super(0,0,new Point(0,0));
		this.message = msg;
		this.nombreBotons = nombreBotons;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getNombreBotons() {
		return nombreBotons;
	}

	public void setNombreBotons(int nombreBotons) {
		this.nombreBotons = nombreBotons;
	}

	@Override
	public String toString() {
		return "Missatge: " +this.message + "\n" + super.toString();
	}

}
