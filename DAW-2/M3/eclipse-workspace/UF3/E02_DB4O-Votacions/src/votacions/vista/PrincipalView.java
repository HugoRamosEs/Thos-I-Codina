package votacions.vista;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import votacions.controlador.*;
import votacions.model.*;
import votacions.vista.components.SeleccionarMunicipi;
import votacions.vista.components.SeleccionarPartit;
import votacions.vista.components.MiJButton;
import votacions.vista.components.SeleccionarComarcaOProvincia;

import java.awt.Color;

public class PrincipalView extends View {
	private static final long serialVersionUID = 1L;
	private JButton btn_1;
	private JButton btn_2;
	private JButton btn_3;
	private JButton btn_4;
	private JButton btn_5;
	private JButton btn_6;
	private JButton btn_7;

	public PrincipalView() {
		this.btn_1 = new MiJButton("Llistar Partits", "plain", 18);
		this.btn_2 = new MiJButton("Llistar Municipis", "plain", 18);
		this.btn_3 = new MiJButton("Resultats en un municipi", "plain", 16);
		this.btn_4 = new MiJButton("Resultats d'un partit", "plain", 18);
		this.btn_5 = new MiJButton("Resultats pro. o com.", "plain", 18);
		this.btn_6 = new MiJButton("Actualitzar resultats", "plain", 18);
		this.btn_7 = new JButton("");
		

		this.btn_1.addMouseListener(this);
		this.btn_2.addMouseListener(this);
		this.btn_3.addMouseListener(this);
		this.btn_4.addMouseListener(this);
		this.btn_5.addMouseListener(this);
		this.btn_6.addMouseListener(this);
		
		this.btn_7.addMouseListener(this);
		this.btn_7.addKeyListener(this);

		init();
	}

	private void init() {
		super.generarFinestra(854, 480, "Votacions - Principal");
		super.afegirMenu();
		afegirComponents();
	}

	public void afegirComponents() {
	    JLabel lbl_fons = new JLabel();
	    lbl_fons.setIcon(new ImageIcon(PrincipalView.class.getResource("/votacions/vista/recursos/minecraft.jpg")));
	    lbl_fons.setHorizontalAlignment(SwingConstants.CENTER);
	    lbl_fons.setVerticalAlignment(SwingConstants.CENTER);
	    lbl_fons.setLayout(new BorderLayout());
	    getContentPane().add(lbl_fons);
	    
	    JPanel pnl_north = new JPanel();
	    pnl_north.setOpaque(false);
	    pnl_north.setBorder(new EmptyBorder(20, 20, 20, 20));
	    lbl_fons.add(pnl_north, BorderLayout.NORTH);
	    pnl_north.setLayout(new BorderLayout(0, 0));

	    JLabel lbl_1 = new JLabel("PRINCIPAL", SwingConstants.CENTER);
	    lbl_1.setForeground(new Color(149, 148, 148));
	    lbl_1.setFont(super.carregarFont("bold", 40));
	    lbl_1.setBorder(new EmptyBorder(0, -62, 0, 0));
	    pnl_north.add(lbl_1, BorderLayout.CENTER);

	    pnl_north.add(this.btn_7, BorderLayout.WEST);

	    JPanel pnl_center = new JPanel();
	    pnl_center.setOpaque(false);
	    pnl_center.setBorder(new EmptyBorder(0, 20, 20, 20));
	    lbl_fons.add(pnl_center, BorderLayout.CENTER);
	    pnl_center.setLayout(new GridLayout(0, 3, 5, 5));

	    JLabel lbl_2 = new JLabel("");
	    pnl_center.add(lbl_2);

	    pnl_center.add(this.btn_1);

	    JLabel lbl_3 = new JLabel("");
	    pnl_center.add(lbl_3);

	    JLabel lbl_4 = new JLabel("");
	    pnl_center.add(lbl_4);

	    pnl_center.add(this.btn_2);

	    JLabel lbl_5 = new JLabel("");
	    pnl_center.add(lbl_5);

	    JLabel lbl_6 = new JLabel("");
	    pnl_center.add(lbl_6);

	    pnl_center.add(this.btn_3);

	    JLabel lbl_7 = new JLabel("");
	    pnl_center.add(lbl_7);

	    JLabel lbl_8 = new JLabel("");
	    pnl_center.add(lbl_8);

	    pnl_center.add(this.btn_4);

	    JLabel lbl_9 = new JLabel("");
	    pnl_center.add(lbl_9);

	    JLabel lbl_10 = new JLabel("");
	    pnl_center.add(lbl_10);

	    pnl_center.add(this.btn_5);

	    JLabel lbl_11 = new JLabel("");
	    pnl_center.add(lbl_11);

	    JLabel lbl_12 = new JLabel("");
	    pnl_center.add(lbl_12);

	    pnl_center.add(this.btn_6);
	    
	    this.btn_7.setIcon(new ImageIcon(PrincipalView.class.getResource("/votacions/vista/recursos/tornar40.png")));
		this.btn_7.setBackground(new Color(149, 148, 148));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == this.btn_1) {
			PartitController.llistarPartits(this);
		} else if (e.getSource() == this.btn_2) {
			MunicipiController.llistarMunicipis(this);
		} else if (e.getSource() == this.btn_3) {
			ResultatController.llistarResultatsPerPartitEnUnMunicipi(this);
		} else if (e.getSource() == this.btn_4) {
			ResultatController.llistarResultatsPerMunicipiAmbUnPartit(this);
		} else if (e.getSource() == this.btn_5) {
			ResultatController.llistarResultatsPerPartitOMunicipi(this);
		} else if (e.getSource() == this.btn_6) {
			ResultatController.mostrarActualitzarResultat(this);
		} else if (e.getSource() == this.btn_7) {
			IniciController.tornar(this);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == this.btn_1) {
			this.btn_1.setForeground(Color.YELLOW);
		} else if (e.getSource() == this.btn_2) {
			this.btn_2.setForeground(Color.YELLOW);
		} else if (e.getSource() == this.btn_3) {
			this.btn_3.setForeground(Color.YELLOW);
		} else if (e.getSource() == this.btn_4) {
			this.btn_4.setForeground(Color.YELLOW);
		} else if (e.getSource() == this.btn_5) {
			this.btn_5.setForeground(Color.YELLOW);
		} else if (e.getSource() == this.btn_6) {
			this.btn_6.setForeground(Color.YELLOW);
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == this.btn_1) {
			this.btn_1.setForeground(Color.BLACK);
		} else if (e.getSource() == this.btn_2) {
			this.btn_2.setForeground(Color.BLACK);
		} else if (e.getSource() == this.btn_3) {
			this.btn_3.setForeground(Color.BLACK);
		} else if (e.getSource() == this.btn_4) {
			this.btn_4.setForeground(Color.BLACK);
		} else if (e.getSource() == this.btn_5) {
			this.btn_5.setForeground(Color.BLACK);
		} else if (e.getSource() == this.btn_6) {
			this.btn_6.setForeground(Color.BLACK);
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == this.btn_1) {
			this.btn_1.setForeground(Color.WHITE);
		} else if (e.getSource() == this.btn_2) {
			this.btn_2.setForeground(Color.WHITE);
		} else if (e.getSource() == this.btn_3) {
			this.btn_3.setForeground(Color.WHITE);
		} else if (e.getSource() == this.btn_4) {
			this.btn_4.setForeground(Color.WHITE);
		} else if (e.getSource() == this.btn_5) {
			this.btn_5.setForeground(Color.WHITE);
		} else if (e.getSource() == this.btn_6) {
			this.btn_6.setForeground(Color.WHITE);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			IniciController.tornar(this);
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
}
