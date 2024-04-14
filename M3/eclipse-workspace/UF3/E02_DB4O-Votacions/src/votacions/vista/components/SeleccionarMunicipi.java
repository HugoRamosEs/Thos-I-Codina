package votacions.vista.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import votacions.model.objectes.Municipi;
import votacions.vista.View;

public class SeleccionarMunicipi extends JDialog {
	private static final long serialVersionUID = 1L;
	private ArrayList<Municipi> municipis;
	private String municipi;
	private JComboBox<String> comboBox;

	public SeleccionarMunicipi(JFrame parent, ArrayList<Municipi> municipis) {
		super(parent, "Municipis", true);
		this.municipis = municipis;
		this.comboBox = new JComboBox<>();
		this.municipi = "";
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                municipi = "";
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
	    JPanel pnl_1 = new JPanel(new GridLayout(3, 1, 5, 5));
	    pnl_1.setBackground(new Color(38, 27, 19));
	    pnl_1.setBorder(new EmptyBorder(10, 20, 20, 20));
	    getContentPane().add(pnl_1);

	    JLabel lbl_1 = new JLabel("SELECCIONA UN MUNICIPI", SwingConstants.CENTER);
	    lbl_1.setForeground(new Color(149, 148, 148));
	    lbl_1.setFont(carregarFont("bold", 18));
	    pnl_1.add(lbl_1);

	    JPanel pnl_2 = new JPanel(new GridLayout(1, 2, 5, 10));
	    pnl_2.setBackground(new Color(38, 27, 19));

	    JButton btn_1 = new JButton("OK");
	    btn_1.setForeground(Color.WHITE);
	    btn_1.setFont(carregarFont("plain", 13));
	    btn_1.setBackground(new Color(149, 148, 148));
	    btn_1.setPreferredSize(new Dimension(60, btn_1.getPreferredSize().height));
	    btn_1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            dispose();
	            municipi = (String) comboBox.getSelectedItem();
	        }
	    });

	    this.comboBox.setForeground(Color.WHITE);
	    this.comboBox.setFont(carregarFont("plain", 13));
	    this.comboBox.setBackground(new Color(149, 148, 148));
	    this.comboBox.setPreferredSize(new Dimension(80, this.comboBox.getPreferredSize().height));

	    for (Municipi mun : this.municipis) {
	        this.comboBox.addItem(mun.getNom());
	    }

	    pnl_1.add(lbl_1);
	    pnl_1.add(comboBox);
	    pnl_1.add(pnl_2);
	    pnl_2.add(btn_1);

	    pack();
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
        try (InputStream is = View.class.getResourceAsStream("/votacions/vista/recursos/minecraftia.ttf")) {
            return Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(estilFont(estil), tamany);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return new Font("Arial", estilFont(estil), tamany);
        }
    }
	
	public String getMunicipi() {
        return this.municipi;
    }
	public void setMunicipi(String municipi) {
		this.municipi = municipi;
	}
}
