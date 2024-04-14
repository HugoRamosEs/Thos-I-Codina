package votacions.vista.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import votacions.model.objectes.Comarca;
import votacions.model.objectes.Provincia;

public class SeleccionarComarcaOProvincia extends JDialog {
	private static final long serialVersionUID = 1L;
	private ArrayList<Comarca> comarques;
	private ArrayList<Provincia> provincies;
	private String seleccionat;
	private JComboBox<String> comboBox;
	private JCheckBox cCheckBox;
	private JCheckBox pCheckBox;

	public SeleccionarComarcaOProvincia(JFrame parent, ArrayList<Comarca> comarques, ArrayList<Provincia> provincies) {
		super(parent, "Comarca o Provincia", true);
		this.comarques = comarques;
		this.provincies = provincies;
		this.comboBox = new JComboBox<>();
		this.cCheckBox = new JCheckBox("Comarca");
		this.pCheckBox = new JCheckBox("Provincia");

		cCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (cCheckBox.isSelected()) {
					mostrarComarques(comarques);
					pCheckBox.setSelected(false);
				}
			}
		});

		pCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (pCheckBox.isSelected()) {
					mostrarProvincies(provincies);
					cCheckBox.setSelected(false);
				}
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				seleccionat = "";
				dispose();
			}
		});

		setLocationRelativeTo(parent);
		setResizable(false);
		afegirComponents();
		centrar();
	}

	private void centrar() {
		Dimension parentSize = getParent().getSize();
		Dimension dialogSize = getSize();
		int x = (parentSize.width - dialogSize.width) / 2;
		int y = (parentSize.height - dialogSize.height) / 2;
		setLocation(getParent().getX() + x, getParent().getY() + y);
	}

	public void afegirComponents() {
		JPanel pnl_1 = new JPanel(new GridLayout(4, 1, 5, 5));
		pnl_1.setBackground(new Color(38, 27, 19));
		pnl_1.setBorder(new EmptyBorder(10, 20, 20, 20));
		getContentPane().add(pnl_1);

		JLabel lbl_1 = new JLabel("SELECCIONA UNA PROVÍNCIA O COMARCA", SwingConstants.CENTER);
		lbl_1.setForeground(new Color(149, 148, 148));
		lbl_1.setFont(carregarFont("bold", 14));
		pnl_1.add(lbl_1);

		JPanel pnl_2 = new JPanel(new GridLayout(1, 2, 5, 10));
		pnl_2.setBackground(new Color(38, 27, 19));
		pnl_2.add(this.cCheckBox);
		pnl_2.add(this.pCheckBox);
		pnl_1.add(pnl_2);
		
		this.pCheckBox.setForeground(Color.WHITE);
		this.pCheckBox.setFont(carregarFont("plain", 13));
		this.pCheckBox.setBackground(new Color(149, 148, 148));
		
		this.cCheckBox.setForeground(Color.WHITE);
		this.cCheckBox.setFont(carregarFont("plain", 13));
		this.cCheckBox.setBackground(new Color(149, 148, 148));

		this.comboBox.setForeground(Color.WHITE);
		this.comboBox.setFont(carregarFont("plain", 13));
		this.comboBox.setBackground(new Color(149, 148, 148));
		this.comboBox.setPreferredSize(new Dimension(200, this.comboBox.getPreferredSize().height));
		pnl_1.add(this.comboBox);

		JButton btn_1 = new JButton("OK");
		btn_1.setForeground(Color.WHITE);
		btn_1.setFont(carregarFont("plain", 13));
		btn_1.setBackground(new Color(149, 148, 148));
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cCheckBox.isSelected()) {
					seleccionat = (String) comboBox.getSelectedItem();
				} else if (pCheckBox.isSelected()) {
					seleccionat = (String) comboBox.getSelectedItem();
				}
				dispose();
			}
		});
		pnl_1.add(btn_1);

		pack();
	}

	public void mostrarComarques(ArrayList<Comarca> comarques) {
		comboBox.removeAllItems();
		for (Comarca comarca : comarques) {
			comboBox.addItem(comarca.getNom());
		}
	}

	public void mostrarProvincies(ArrayList<Provincia> provincies) {
		comboBox.removeAllItems();
		for (Provincia provincia : provincies) {
			comboBox.addItem(provincia.getNom());
		}
	}

	public int estilFont(String estil) {
		switch (estil.toLowerCase()) {
		case "plain":
			return Font.PLAIN;
		case "bold":
			return Font.BOLD;
		case "italic":
			return Font.ITALIC;
		case "bolditalic":
			return Font.BOLD | Font.ITALIC;
		default:
			return Font.PLAIN;
		}
	}

	public Font carregarFont(String estil, int tamany) {
		try (InputStream is = SeleccionarComarcaOProvincia.class
				.getResourceAsStream("/votacions/vista/recursos/minecraftia.ttf")) {
			return Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(estilFont(estil), tamany);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
			return new Font("Arial", estilFont(estil), tamany);
		}
	}

	public String getSeleccionat() {
		return seleccionat;
	}

	public void setSeleccionat(String seleccionat) {
		this.seleccionat = seleccionat;
	}
}
