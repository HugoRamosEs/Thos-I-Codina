package votacions.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import votacions.controlador.IniciController;
import votacions.vista.components.MiJButton;
import votacions.vista.components.SeleccionarFitxer;
import java.awt.Color;
import javax.swing.SwingConstants;

public class IniciView extends View {
	private static final long serialVersionUID = 1L;
	private JButton btn_1;
	private JButton btn_2;
	private JButton btn_3;

	public IniciView() {
		this.btn_1 = new MiJButton("Generar BD", "plain", 16);
		this.btn_2 = new MiJButton("Continuar amb BD", "plain", 16);
		this.btn_3 = new MiJButton("Sortir", "plain", 16);

		this.btn_1.addMouseListener(this);
		this.btn_2.addMouseListener(this);
		this.btn_3.addMouseListener(this);

		init();
	}

	private void init() {
		super.generarFinestra(640, 360, "Votacions - Inici");
		afegirComponents();
	}

	public void afegirComponents() {
		JPanel pnl_north = new JPanel();
		pnl_north.setBackground(new Color(38, 27, 19));
		pnl_north.setBorder(new EmptyBorder(20, 20, 20, 20));
		getContentPane().add(pnl_north, BorderLayout.NORTH);

		JLabel lbl_1 = new JLabel("GESTOR DE VOTACIONS", SwingConstants.CENTER);
		lbl_1.setForeground(new Color(149, 148, 148));
		lbl_1.setBackground(Color.WHITE);
		lbl_1.setFont(new Font("Dialog", Font.BOLD, 32));
		pnl_north.add(lbl_1);

		JPanel pnl_center = new JPanel();
		pnl_center.setBackground(new Color(38, 27, 19));
		getContentPane().add(pnl_center, BorderLayout.CENTER);
		pnl_center.setLayout(new GridLayout(0, 3, 5, 5));

		JLabel lbl_4 = new JLabel("");
		pnl_center.add(lbl_4);
		pnl_center.add(this.btn_1);

		JLabel lbl_6 = new JLabel("");
		pnl_center.add(lbl_6);

		JLabel lbl_11 = new JLabel("");
		pnl_center.add(lbl_11);
		pnl_center.add(this.btn_2);
		JLabel lbl_9 = new JLabel("");
		pnl_center.add(lbl_9);

		JLabel lbl_10 = new JLabel("");
		pnl_center.add(lbl_10);

		pnl_center.add(this.btn_3);

		JLabel lbl_5 = new JLabel("");
		pnl_center.add(lbl_5);

		JLabel lbl_7 = new JLabel("");
		pnl_center.add(lbl_7);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == this.btn_1) {
			IniciController.generarBaseDeDades(this);
		} else if (e.getSource() == this.btn_2) {
			IniciController.baseDeDadesExistent(this);
		} else if (e.getSource() == this.btn_3) {
			System.exit(0);
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
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
