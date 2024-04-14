package cat.iesthosicodina;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import cat.iesthosicodina.gui.CartaGUI;
import cat.iesthosicodina.gui.ImageGenerator;
import cat.iesthosicodina.gui.PilaGUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

public class Main implements MouseListener, ActionListener {

	private JFrame frame;
	private JPanel pnlWest;
	private JPanel pnlEast;
	private JPanel pnlNorth;
	private JButton btnSortir;
	private JButton btnRepartir;
	private JButton btnPlantar;
	private JButton btnDemanar;
	
	private MenuItem primerElementDeA;
	private MenuItem segonElementDeA;
	private MenuItem primerElementDeB;
	private MenuItem segonElementDeB;
	private MenuItem tercerElementDeB;
	private MenuItem quartElementDeB;
	private MenuItem cinqueElementDeB;
	
	private Baralla baralla;
	
	private PilaDeCartes laMevaPila;
	private PilaDeCartes laPilaDeLaBanca;
	
	private int elsMeusPunts;
	private int elsPuntsDeLaBanca;
	
	private ImageGenerator graphicGenerator;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Ha hagut algun problema ....", e.getMessage(), JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		this.baralla = new Baralla();
		this.laMevaPila = new PilaDeCartes();
		this.laPilaDeLaBanca = new PilaDeCartes();
		
		
		try {
			this.graphicGenerator = new ImageGenerator(120);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		this.initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(10, 102, 50));
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setIconImage (new ImageIcon("src/cat/iesthosicodina/img/logo.png").getImage());
		frame.addMouseListener(this);
		
		// Instancio un objecte de tipus Accelerador de Teclat
        MenuShortcut elMeuAccelerador = new MenuShortcut( KeyEvent.VK_K,true );
		// Instancia varis objectes de tipus Elements de JMenu 
        primerElementDeA = new MenuItem("Primer Element del JMenu A",elMeuAccelerador );
        segonElementDeA = new MenuItem("Segon Element del JMenu A" );
        primerElementDeB = new MenuItem("Primer Element del JMenu B" );
        segonElementDeB = new MenuItem("Segon Element del JMenu B" );
        tercerElementDeB = new MenuItem("Tercer Element del JMenu B" );
        quartElementDeB = new MenuItem("About...", new MenuShortcut( KeyEvent.VK_A,true ));
        cinqueElementDeB = new MenuItem("Sortir...", new MenuShortcut( KeyEvent.VK_S,true ));
        // S'instancia un objete ActionListener y es registra sobre els objectes JJMenuItem
        primerElementDeA.addActionListener( this );
        segonElementDeA.addActionListener( this );
        primerElementDeB.addActionListener( this );
        segonElementDeB.addActionListener( this );
        tercerElementDeB.addActionListener( this );
        quartElementDeB.addActionListener( this );
        cinqueElementDeB.addActionListener( this );
        // S'instancian dos objectes de tipus JMenu y se'ls afegeixen els objectte JJMenuItem
        Menu menuA = new Menu( "Menu A" );
        menuA.add( primerElementDeA );
        menuA.add( segonElementDeA );

        Menu menuB = new Menu( "JMenu B" );
        menuB.add( primerElementDeB );
        menuB.add( segonElementDeB );
        menuB.add( tercerElementDeB );
        menuB.addSeparator();
        menuB.add( quartElementDeB );
        menuB.add( cinqueElementDeB );
        // S'instancia una Barra de JMenu i s'afegeixen els Menus
        MenuBar menuBar = new MenuBar();
        menuBar.add( menuA );  
        menuBar.add( menuB );
        // Afegeixo la barra de menus al meu frame
        frame.setMenuBar(menuBar);
		
		JPanel pnlSouth = new JPanel();
		frame.getContentPane().add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.setBackground(new Color(10, 102, 50));
		pnlSouth.setLayout(new GridLayout(0,4,20,20));

		frame.setBounds(100, 100, 1200, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnSortir = new JButton("Sortir");
		btnSortir.addMouseListener(this);
		pnlSouth.add(btnSortir);
		
		btnRepartir = new JButton("Repartir Cartes");
		btnRepartir.addMouseListener(this);
		pnlSouth.add(btnRepartir);
		
		btnDemanar = new JButton("Demanar Carta");
		btnDemanar.addMouseListener(this);
		btnDemanar.setVisible(false);
		pnlSouth.add(btnDemanar);
		
		btnPlantar = new JButton("Em planto");
		btnPlantar.addMouseListener(this);
		btnPlantar.setVisible(false);
		pnlSouth.add(btnPlantar);
		
		pnlWest = new JPanel();
		pnlWest.setBackground(new Color(10, 102, 50));
		frame.getContentPane().add(pnlWest, BorderLayout.WEST);
		pnlWest.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		pnlEast = new JPanel();
		pnlEast.setBackground(new Color(10, 102, 50));
		frame.getContentPane().add(pnlEast, BorderLayout.EAST);
		pnlEast.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		pnlNorth = new JPanel();
		frame.getContentPane().add(pnlNorth, BorderLayout.NORTH);
		pnlNorth.setLayout(new GridLayout(0, 2, 0, 0));
		JLabel lblLesMevesCartes = new JLabel("Les meves Cartes");
		pnlNorth.add(lblLesMevesCartes);
		JLabel lblLesCartesDeLaBanca = new JLabel("Les Cartes de la Banca");
		pnlNorth.add(lblLesCartesDeLaBanca);
	}


	public void calculaElsPuntsDeLaBanca() {
		int valor;
		if (this.laPilaDeLaBanca.numeroDAses()>0) {
			valor = this.elsPuntsDeLaBanca = laPilaDeLaBanca.valor() + 10;
			if (valor > 21) {
				this.elsPuntsDeLaBanca = laPilaDeLaBanca.valor();
			} else {
				this.elsPuntsDeLaBanca = laPilaDeLaBanca.valor()+10;
			}
		} else {
			this.elsPuntsDeLaBanca = laPilaDeLaBanca.valor();
		}
	}

	public void repartirDuesCartes() {
		try {
			laPilaDeLaBanca = new PilaDeCartes();
			laPilaDeLaBanca.push(baralla.get().girar());
			laPilaDeLaBanca.push(baralla.get());
			
			laMevaPila = new PilaDeCartes();;
			laMevaPila.push(baralla.get().girar());
			laMevaPila.push(baralla.get());
		} catch (EmptyStackException ese) {
			int seleccion = JOptionPane.showOptionDialog(
			   null,
			   "La pila s'ha quedat sense cartes.\n Per poder continuar he de fer una nova baralla.\n Vols continuar?", 
			   "Ens hem quedat sense cartes.",
			   JOptionPane.YES_NO_OPTION,
			   JOptionPane.QUESTION_MESSAGE,
			   null,    // null para icono por defecto.
			   new Object[] { "Si", "No" },   // null para YES, NO y CANCEL
			   "Si");

			if (seleccion == 0) {
				this.baralla = new Baralla();
				this.repartirDuesCartes();
			} 
		} 
		
		frame.getContentPane().remove(this.pnlWest);
		PilaGUI pnlNou = new PilaGUI(laMevaPila, new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnlNou.generaGafics(this);
		this.pnlWest = pnlNou;
		frame.getContentPane().add(pnlWest, BorderLayout.WEST);
		
		frame.getContentPane().remove(this.pnlEast);
		pnlEast = new JPanel();
		pnlEast.setBackground(new Color(10, 102, 50));
		frame.getContentPane().add(pnlEast, BorderLayout.EAST);
		pnlEast.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Iterator<Carta> itr = laPilaDeLaBanca.iterator();
		while (itr.hasNext()) {
			pnlEast.add(new JLabel(new ImageIcon(graphicGenerator.getImatge(itr.next()))));
		}
		
		this.elsMeusPunts =  laMevaPila.valor();
	}
	
	public void demanoUnaCarta() {
		Iterator<Carta> itr;
		
		try { 
			if (laMevaPila.totesVistes()) {
				laMevaPila.push(baralla.get());
			} else {
				laMevaPila.push(baralla.get().girar());
			}
		} catch (EmptyStackException ese) {
			int seleccion = JOptionPane.showOptionDialog(
			   null,
			   "La pila s'ha quedat sense cartes.\n Per poder continuar he de fer una nova baralla.\n Vols continuar?", 
			   "Ens hem quedat sense cartes.",
			   JOptionPane.YES_NO_OPTION,
			   JOptionPane.QUESTION_MESSAGE,
			   null,    // null para icono por defecto.
			   new Object[] { "Si", "No" },   // null para YES, NO y CANCEL
			   "Si");

			if (seleccion == 0) {
				this.baralla = new Baralla();
				this.repartirDuesCartes();
			} 
		} 
		
		this.elsMeusPunts =  laMevaPila.valor();
		
		if (this.elsMeusPunts > 21) {
			btnRepartir.setVisible(true);
			btnPlantar.setVisible(false);
			btnDemanar.setVisible(false);
			
			//Giro totes les cartes i les poso vistes
			itr = laMevaPila.iterator();
			while (itr.hasNext()) {
				Carta c = itr.next();
				if (!c.getVista()) c.girar(); 
			}
			
			frame.getContentPane().remove(this.pnlWest);
			PilaGUI pnlNou = new PilaGUI(laMevaPila, new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnlNou.generaGafics(this);
			this.pnlWest = pnlNou;
			frame.getContentPane().add(pnlWest, BorderLayout.WEST);
			
			JOptionPane.showMessageDialog(
			   null,
			   "Ho sento però t'has passat i acabes de perdre");
		} else {
			frame.getContentPane().remove(this.pnlWest);
			PilaGUI pnlNou = new PilaGUI(laMevaPila, new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnlNou.generaGafics(this);
			this.pnlWest = pnlNou;
			frame.getContentPane().add(pnlWest, BorderLayout.WEST);
			
			frame.getContentPane().remove(this.pnlEast);
			pnlEast = new JPanel();
			pnlEast.setBackground(new Color(10, 102, 50));
			frame.getContentPane().add(pnlEast, BorderLayout.EAST);
			pnlEast.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			itr = laPilaDeLaBanca.iterator();
			while (itr.hasNext()) {
				pnlEast.add(new JLabel(new ImageIcon(graphicGenerator.getImatge(itr.next()))));
			}
		}
		
	}
	
	public void jugaLaBanca() {
		//Giro totes les cartes i les poso vistes
		Iterator<Carta> itr = laMevaPila.iterator();
		while (itr.hasNext()) {
			Carta c = itr.next();
			if (!c.getVista()) c.girar(); 
		}
		
		//Giro totes les cartes i les poso vistes
		itr = laPilaDeLaBanca.iterator();
		while (itr.hasNext()) {
			Carta c = itr.next();
			if (!c.getVista()) c.girar(); 
		}
		
		frame.getContentPane().remove(this.pnlEast);
		PilaGUI pnlNou = new PilaGUI(this.laPilaDeLaBanca, new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnlNou.generaGafics(this);
		this.pnlEast = pnlNou;
		frame.getContentPane().add(pnlEast, BorderLayout.EAST);
		
		btnRepartir.setVisible(true);
		btnPlantar.setVisible(false);
		btnDemanar.setVisible(false);
		
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		
		this.calculaElsPuntsDeLaBanca();
		
		boolean finalDelJoc = false;
		while (!finalDelJoc) {
			if (this.elsPuntsDeLaBanca < this.elsMeusPunts) {
				JOptionPane.showMessageDialog(
				   null,
				   "Tens " + this.elsMeusPunts + " i jo en tinc " + this.elsPuntsDeLaBanca + "\n Així que demano una altra carta");
				Carta c=null;
				try {
					c = baralla.get().girar();
					this.laPilaDeLaBanca.push(c);
				} catch (EmptyStackException ese) {
					int seleccion = JOptionPane.showOptionDialog(
					   null,
					   "La pila s'ha quedat sense cartes.\n Per poder continuar he de fer una nova baralla.\n Vols continuar?", 
					   "Ens hem quedat sense cartes.",
					   JOptionPane.YES_NO_OPTION,
					   JOptionPane.QUESTION_MESSAGE,
					   null,    // null para icono por defecto.
					   new Object[] { "Si", "No" },   // null para YES, NO y CANCEL
					   "Si");

					if (seleccion == 0) {
						this.baralla = new Baralla();
						this.repartirDuesCartes();
					} 
				} 
				this.calculaElsPuntsDeLaBanca();
				
				pnlEast.add(new JLabel(new ImageIcon(graphicGenerator.getImatge(c))));
				
				frame.getContentPane().validate();
				frame.getContentPane().repaint();
			} else if (this.elsPuntsDeLaBanca > 21) {
				JOptionPane.showMessageDialog(
						   null,
						   "Tens " + this.elsMeusPunts + " i jo en tinc " + this.elsPuntsDeLaBanca + "\n Així que GUANYES TÚ !!!","Guanyes tu",
						    JOptionPane.WARNING_MESSAGE);
						finalDelJoc = true;
				btnRepartir.setVisible(true);
				btnPlantar.setVisible(false);
				btnDemanar.setVisible(false);
				this.laMevaPila = new PilaDeCartes();
				this.laPilaDeLaBanca = new PilaDeCartes();
			} else {
				JOptionPane.showMessageDialog(
				   null,
				   "Tens " + this.elsMeusPunts + " i jo en tinc " + this.elsPuntsDeLaBanca + "\nCom sempre, guanya la banca !!!","Guanyo yo",
				    JOptionPane.ERROR_MESSAGE);
				finalDelJoc = true;
				btnRepartir.setVisible(true);
				btnPlantar.setVisible(false);
				btnDemanar.setVisible(false);
				this.laMevaPila = new PilaDeCartes();
				this.laPilaDeLaBanca = new PilaDeCartes();
			}
		}
	}
	
	public void sortir() {
		int resposta = JOptionPane.showConfirmDialog(null, "Segur que vols tancar?");
		if (resposta == JOptionPane.OK_OPTION) {
			frame.dispose();
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		if (arg0.getSource().getClass().getName().equals("javax.swing.JButton")) {	
			if (arg0.getSource() == this.btnSortir) {
				this.sortir();
			}
			
			if (arg0.getSource() == this.btnRepartir) {
				//Dos cartes per cadascú
				this.repartirDuesCartes();
				
				btnRepartir.setVisible(false);
				btnPlantar.setVisible(true);
				btnDemanar.setVisible(true);
			}
			
			if (arg0.getSource() == this.btnDemanar) {
				this.demanoUnaCarta();
			}

			if (arg0.getSource() == this.btnPlantar) {
				this.jugaLaBanca();

			}
		}
		
		if (arg0.getSource().getClass().getName().equals("cat.iesthosicodina.gui.CartaGUI")) {
			//System.out.println("carta");
			((CartaGUI)arg0.getSource()).getCarta().girar();
			
			frame.getContentPane().remove(this.pnlWest);
			PilaGUI pnlNou = new PilaGUI(laMevaPila, new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnlNou.generaGafics(this);
			this.pnlWest = pnlNou;
			frame.getContentPane().add(pnlWest, BorderLayout.WEST);
		}
		
		if (arg0.getSource().getClass().getName().equals("javax.swing.JFrame")) {
			if (this.laMevaPila.empty() && this.laPilaDeLaBanca.empty()) {
				this.repartirDuesCartes();
				
				btnRepartir.setVisible(false);
				btnPlantar.setVisible(true);
				btnDemanar.setVisible(true);
			} else {
				
				if (arg0.getClickCount()==1) {
					this.demanoUnaCarta();
				} else {
					System.out.println("que jugi la banca");
					this.jugaLaBanca();
				}
			}
		}
		
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		if (arg0.getSource() == cinqueElementDeB) {
			this.sortir();
		}
		
		if (arg0.getSource() == quartElementDeB) {
			try {
				AboutWindow window = new AboutWindow();
				window.getFrame().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	
}
