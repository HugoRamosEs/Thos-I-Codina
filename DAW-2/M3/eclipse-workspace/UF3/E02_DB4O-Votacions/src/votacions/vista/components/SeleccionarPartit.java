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

import votacions.model.objectes.Partit;
import votacions.vista.View;

public class SeleccionarPartit extends JDialog {
	private static final long serialVersionUID = 1L;
	private ArrayList<Partit> partits;
	private String partit;
	private JComboBox<String> comboBox;

	public SeleccionarPartit(JFrame parent, ArrayList<Partit> partits) {
		super(parent, "Partits", true);
		this.partits = partits;
		this.comboBox = new JComboBox<>();
		this.partit = "";
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                partit = "";
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

	    JLabel lbl_1 = new JLabel("SELECCIONA UN PARTIT", SwingConstants.CENTER);
	    lbl_1.setForeground(new Color(149, 148, 148));
	    lbl_1.setFont(carregarFont("bold", 18));
	    pnl_1.add(lbl_1);

	    JPanel pnl_2 = new JPanel(new GridLayout(1, 2, 5, 10));
	    pnl_2.setBackground(new Color(38, 27, 19));
		
	    JButton btn_1 = new JButton("OK");
	    btn_1.setForeground(Color.WHITE);
	    btn_1.setFont(carregarFont("plain", 13));
	    btn_1.setBackground(new Color(149, 148, 148));
		btn_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				partit = (String) comboBox.getSelectedItem();
			}
		});
		
		this.comboBox.setForeground(Color.WHITE);
	    this.comboBox.setFont(carregarFont("plain", 13));
	    this.comboBox.setBackground(new Color(149, 148, 148));
		
		for (Partit par : this.partits) {
			this.comboBox.addItem(par.getNom());
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
	
	public String getPartit() {
		return partit;
	}
	public void setPartit(String partit) {
		this.partit = partit;
	}
}
