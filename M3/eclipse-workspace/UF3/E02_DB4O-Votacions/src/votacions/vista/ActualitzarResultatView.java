package votacions.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import votacions.controlador.PrincipalController;
import votacions.controlador.ResultatController;
import votacions.model.objectes.Municipi;
import votacions.model.objectes.Resultat;
import votacions.vista.components.MiJTable;
import votacions.vista.components.SeleccionarFitxer;

import java.awt.GridLayout;

public class ActualitzarResultatView extends View {
	private static final long serialVersionUID = 1L;
	private MiJTable tbl_1;
	private JButton btn_1;
	private JButton btn_2;
	private ArrayList<Resultat> resultats;
	private ArrayList<Municipi> municipis;
	private JComboBox<String> comboBox;

	public ActualitzarResultatView(ArrayList<Resultat> resultats, ArrayList<Municipi> municipis) {
		this.tbl_1 = new MiJTable();
		this.btn_1 = new JButton();
		this.btn_2 = new JButton("Importar...");

		this.resultats = resultats;
		this.municipis = municipis;
		this.comboBox = new JComboBox<>();

		this.btn_1.addMouseListener(this);
		this.btn_2.addMouseListener(this);
		this.btn_1.addKeyListener(this);

		init();
	}

	private void init() {
		super.generarFinestra(1280, 720, "Votacions - Actualitzar resultats");
		super.afegirMenu();
		afegirComponents();
		mostrarResultats();
	}

	public void afegirComponents() {
		JLabel lbl_fons = new JLabel();
		lbl_fons.setIcon(new ImageIcon(PrincipalView.class.getResource("/votacions/vista/recursos/minecraft.jpg")));
		lbl_fons.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fons.setVerticalAlignment(SwingConstants.CENTER);
		lbl_fons.setLayout(new BorderLayout());
		getContentPane().add(lbl_fons, BorderLayout.CENTER);

		JPanel pnl_north = new JPanel();
		pnl_north.setOpaque(false);
		pnl_north.setBorder(new EmptyBorder(20, 20, 20, 20));
		lbl_fons.add(pnl_north, BorderLayout.NORTH);
		pnl_north.setLayout(new BorderLayout(0, 0));

		JLabel lbl_1 = new JLabel("ACTUALITZAR RESULTATS", SwingConstants.CENTER);
		lbl_1.setForeground(new Color(149, 148, 148));
		lbl_1.setFont(super.carregarFont("bold", 40));
		lbl_1.setBorder(new EmptyBorder(0, -62, 0, 0));
		pnl_north.add(lbl_1, BorderLayout.CENTER);

		pnl_north.add(this.btn_1, BorderLayout.WEST);

		JPanel pnl_center = new JPanel();
		pnl_center.setOpaque(false);
		pnl_center.setBorder(new EmptyBorder(0, 20, 20, 20));
		lbl_fons.add(pnl_center, BorderLayout.CENTER);
		pnl_center.setLayout(new BorderLayout(0, 0));

		JPanel pnl_center_north = new JPanel();
		pnl_center_north.setOpaque(false);
		pnl_center.add(pnl_center_north, BorderLayout.NORTH);
		pnl_center_north.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lbl_4 = new JLabel("");
		pnl_center_north.add(lbl_4);

		JLabel lbl_5 = new JLabel("");
		pnl_center_north.add(lbl_5);

		JLabel lbl_6 = new JLabel("");
		pnl_center_north.add(lbl_6);

		pnl_center_north.add(this.btn_2);

		JLabel lbl_7 = new JLabel("");
		pnl_center_north.add(lbl_7);

		JLabel lbl_8 = new JLabel("");
		pnl_center_north.add(lbl_8);

		for (Municipi municipi : this.municipis) {
			this.comboBox.addItem(municipi.getNom());
		}
		pnl_center_north.add(this.comboBox);

		JPanel pnl_center_center = new JPanel(new BorderLayout());
		pnl_center_center.setOpaque(false);
		pnl_center_center.setBorder(new EmptyBorder(20, 0, 0, 0));
		pnl_center.add(pnl_center_center, BorderLayout.CENTER);

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("VOTS");
		model.addColumn("PERCENTATGE");
		model.addColumn("PARTIT");
		model.addColumn("MUNICIPI");
		model.addColumn("COMARCA");
		model.addColumn("PROVINCIA");

		JLabel lbl_2 = new JLabel("Resultats Actualitzats: " + this.resultats.size());
		lbl_2.setFont(carregarFont("bold", 20));
		lbl_2.setForeground(Color.WHITE);
		lbl_2.setBorder(new EmptyBorder(0, 0, 10, 0));
		pnl_center_center.add(lbl_2, BorderLayout.NORTH);
		this.tbl_1.setModel(model);

		JScrollPane scrollPane_1 = new JScrollPane(this.tbl_1);
		scrollPane_1.setBackground(new Color(96, 96, 96));
		pnl_center_center.add(scrollPane_1, BorderLayout.CENTER);

		this.btn_1.setIcon(new ImageIcon(PrincipalView.class.getResource("/votacions/vista/recursos/tornar40.png")));
		this.btn_1.setBackground(new Color(149, 148, 148));

		this.btn_2.setFont(super.carregarFont("plain", 13));
		this.btn_2.setForeground(Color.WHITE);
		this.btn_2.setBackground(new Color(149, 148, 148));

		this.comboBox.setForeground(Color.WHITE);
		this.comboBox.setFont(carregarFont("plain", 13));
		this.comboBox.setBackground(new Color(149, 148, 148));
	}

	public void mostrarResultats() {
		DefaultTableModel model = (DefaultTableModel) this.tbl_1.getModel();
		model.setRowCount(0);
		for (Resultat resultat : this.resultats) {
			model.addRow(new Object[] { resultat.getVots(), resultat.getPercentatge() + " %",
					resultat.getPartit().getNom(), resultat.getMunicipi().getNom(), resultat.getComarca().getNom(),
					resultat.getProvincia().getNom() });
		}
	}

	public String getMunNom() {
		return (String) this.comboBox.getSelectedItem();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == this.btn_1) {
			PrincipalController.tornar(this);
		} else if (e.getSource() == this.btn_2) {
			ResultatController.llistarResultatsActualitzats(this);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			PrincipalController.tornar(this);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
