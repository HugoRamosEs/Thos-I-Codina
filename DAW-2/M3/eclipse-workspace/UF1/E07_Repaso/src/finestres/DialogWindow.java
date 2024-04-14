package finestres;

import java.awt.Point;

public class DialogWindow extends Window {
	private String missatge;
	private int numBotons;

	public DialogWindow(double width, double height, Point posicio, String missatge) {
		super(width, height, posicio);
		this.missatge = missatge;
	}
	
	public DialogWindow(String msg, int nombreBotons) {
		super(0, 0, new Point(0, 0));
		this.missatge = msg;
		this.numBotons = nombreBotons;
	}

	public String getMissatge() {
		return missatge;
	}

	public int getNumBotons() {
		return numBotons;
	}

	public void setMissatge(String missatge) {
		this.missatge = missatge;
	}

	public void setNumBotons(int numBotons) {
		this.numBotons = numBotons;
	}

	@Override
    public Object clone() {
        DialogWindow cp = new DialogWindow(super.getWidth(), super.getHeight(), super.getPosicio(), this.missatge);
        cp.setComponents(super.getComponents().clone());
        return cp;
    }

	@Override
	public String toString() {
		return "Missatge: " 
				+ this.missatge + "\n"
				+ super.toString();
	}
}
