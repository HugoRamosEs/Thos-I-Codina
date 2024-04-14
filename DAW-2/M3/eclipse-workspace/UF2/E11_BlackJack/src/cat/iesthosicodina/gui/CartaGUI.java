package cat.iesthosicodina.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import cat.iesthosicodina.Carta;

public class CartaGUI extends JLabel {
	private Carta carta;

	public CartaGUI(Carta param) {
		super();
		this.carta = param;
	}

	public CartaGUI(Carta param, Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
		this.carta = param;
	}

	public CartaGUI(Carta param, Icon image) {
		super(image);
		this.carta = param;
	}

	public CartaGUI(Carta param, String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
		this.carta = param;
	}

	public CartaGUI(Carta param, String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		this.carta = param;
	}

	public CartaGUI(Carta param, String text) {
		super(text);
		this.carta = param;
	}
	
	public Carta getCarta () {
		return this.carta;
	}
	
}
