package peces;

import joc.Color;

public abstract class Escac {
    protected Color color;
    
    
    public Escac (Color color) {
    	this.color = color;
    }
     
    public Color getColor() {
        return this.color;
    }

	@Override
	public String toString() {		
		return ((this.color==Color.BLANC) ? "b" : "n");
	}
    
    
}
