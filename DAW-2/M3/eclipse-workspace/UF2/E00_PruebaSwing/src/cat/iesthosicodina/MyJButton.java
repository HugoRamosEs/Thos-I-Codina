package cat.iesthosicodina;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class MyJButton extends Canvas {
	private static final long serialVersionUID = 1L;
	private static final int MARGEN_X=12;
	private static final int MARGEN_Y=8;
	private transient Vector actionListeners;
	private Color color;
	private String titol;
	private boolean bPulsat;
	

	public MyJButton(String titol) {
		this.titol = titol;
		
		try {
			init();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// VALORS PER DEFECTE + REPOSTA A ACCIONS D'USUARI
	private void init() throws Exception {
		this.setSize(60,40);
		this.color = Color.YELLOW;
		this.setFont(new Font("Dialog", Font.BOLD, 12));
		
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				this_mousePressed(e);
			}
			
			public void mouseReleased (MouseEvent e) {
				this_mouseReleased(e);
			}
		});
	}
	
	void this_mousePressed(MouseEvent e) {
		this.bPulsat = true;
		this.repaint();
	}
	
	void this_mouseReleased(MouseEvent e) {
		if (this.bPulsat) {
			this.bPulsat = false;
			ActionEvent ev = new ActionEvent(e.getSource(), e.getID(), this.titol);
			this.fireActionPerformed(ev);
		}
		this.repaint();
	}
	
	// RENDER (Lo que esta comentado es lo viejo, para ponerlo descomentar y quitar el if,else)
	public synchronized void paint (Graphics g) {
		int ample = this.getSize().width;
		int alt = this.getSize().height;
		
		if (this.bPulsat) {
			g.setColor(this.getForeground());
			g.fillRoundRect(0, 0, ample, alt, 12, 12);
			g.setColor(color);
			g.fillRoundRect(4, 4, ample - 1, alt - 1, 12, 12);
		}else {
			g.setColor(this.getForeground());
			g.fillRoundRect(0, 0, ample, alt, 12, 12);
			g.setColor(color);
			g.fillRoundRect(4, 4, ample - 1, alt - 1, 12, 12);
		}
		
//		g.setColor(color);
//		g.fillRect(1, 1, ample-2, alt-2);
//		g.draw3DRect(0, 0, ample-1, alt-1, false);
		
		g.setColor(getForeground());
		g.setFont(getFont());
		
//		g.drawRect(2, 2, ample-4, alt-4);
		FontMetrics fm = g.getFontMetrics();
		g.drawString(this.titol, (ample-fm.stringWidth(this.titol))/2, (alt+fm.getMaxAscent()-fm.getMaxDescent())/2);
	}
	
	// TAMANY
	public Dimension getPreferredSize() {
		FontMetrics fm = getFontMetrics(this.getFont());
		return new Dimension(fm.stringWidth(this.titol) + MyJButton.MARGEN_X,
				fm.getMaxAscent() + fm.getMaxDescent() + MyJButton.MARGEN_Y);
	}
	
	public Dimension getMinimunSize() {
		return getPreferredSize();
	}
	
	// PARA QUE EL BOTON EMITA EVENTOS SUCCESIVOS
		public synchronized void removeActionListener(ActionListener l) {
			if (this.actionListeners != null && this.actionListeners.contains(l)) {
				Vector v = (Vector) this.actionListeners.clone();
				this.actionListeners = v;
			}
		}
		
		public synchronized void addActionListener(ActionListener l) {
			Vector v = this.actionListeners == null ? new Vector(2) : (Vector) this.actionListeners.clone();
			if (!v.contains(l)) {
				v.addElement(l);
				this.actionListeners = v;
			}
		}
		
		public synchronized void fireActionPerformed(ActionEvent e) {
			if (this.actionListeners != null) {
				Vector listeners = this.actionListeners;
				int count = listeners.size();
				for (int i=0; i<count; i++) {
					((ActionListener) listeners.elementAt(i)).actionPerformed(e);
				}
			}
		}
	
	// RELACIÓ ASPECTE (GETTERS I SETTERS)
	public Color getColor() {
		return color;
	}

	public String getTitol() {
		return titol;
	}

	public void setColor(Color color) {
		this.color = color;
		this.repaint();
	}

	public void setTitol(String titol) {
		this.titol = titol;
		Dimension d = getPreferredSize();
		this.setSize(d.width, d.height);
		invalidate();
	}
}
