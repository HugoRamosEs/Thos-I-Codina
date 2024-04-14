package cat.iesthosicodina.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import cat.iesthosicodina.Carta;

public class PilaGUI extends JPanel {
	public Stack<Carta> cartes;

	public PilaGUI(Stack<Carta> pila) {
		super();
		this.cartes = pila;
//		this.generaGafics();
	}

	public PilaGUI(Stack<Carta> pila,boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		this.cartes = pila;
//		this.generaGafics();
	}

	public PilaGUI(Stack<Carta> pila,LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		this.cartes = pila;
//		this.generaGafics();
	}

	public PilaGUI(Stack<Carta> pila,LayoutManager layout) {
		super(layout);
		this.cartes = pila;
//		this.generaGafics();
	}
	
	public void generaGafics(MouseListener myListener) {
		ImageGenerator graphicGenerator = null;
		
		this.setBackground(new Color(10, 102, 50));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		try {
			graphicGenerator = new ImageGenerator(120);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Iterator<Carta> itr = this.cartes.iterator();
		while (itr.hasNext()) {
			Carta carta = itr.next();
			CartaGUI lblCarta = new CartaGUI(carta, new ImageIcon(graphicGenerator.getImatge(carta)));
			lblCarta.addMouseListener(myListener);
							
			this.add(lblCarta);
		}
	}
	
}
