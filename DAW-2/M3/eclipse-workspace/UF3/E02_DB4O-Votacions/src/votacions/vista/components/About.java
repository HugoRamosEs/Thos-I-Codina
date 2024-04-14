package votacions.vista.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import votacions.vista.View;

public class About extends JDialog {
	private static final long serialVersionUID = 1L;

	public About(JFrame frame) {
		super(frame, "About", true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(265, 300);
		setLocationRelativeTo(frame);
		setResizable(false);

		afegirComponents();
		setVisible(true);
	}

	public void afegirComponents() {
		JPanel pnl_cAbout = new JPanel(new GridLayout(1, 1));
		pnl_cAbout.setBackground(new Color(38, 27, 19));
		pnl_cAbout.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(pnl_cAbout, BorderLayout.CENTER);
		
		JLabel lbl_aImg = new JLabel("");
		lbl_aImg.setIcon(new ImageIcon(About.class.getResource("/votacions/vista/recursos/logo128.png")));
		lbl_aImg.setHorizontalAlignment(JLabel.CENTER);
		lbl_aImg.setBackground(new Color(245, 245, 245));
		pnl_cAbout.add(lbl_aImg);

		JPanel pnl_sAbout = new JPanel(new GridLayout(4, 1));
		pnl_sAbout.setBackground(new Color(38, 27, 19));
		pnl_sAbout.setBorder(new EmptyBorder(10, 10, 0, 10));
		getContentPane().add(pnl_sAbout, BorderLayout.SOUTH);

		JLabel lbl_a1 = new JLabel("VOTACIONS");
		lbl_a1.setFont(carregarFont("bold", 22));
		lbl_a1.setForeground(Color.WHITE);
		lbl_a1.setHorizontalAlignment(SwingConstants.CENTER);
		pnl_sAbout.add(lbl_a1);

		JLabel lbl_a2 = new JLabel("Versió 1.0");
		lbl_a2.setFont(carregarFont("plain", 14));
		lbl_a2.setForeground(Color.WHITE);
		lbl_a2.setHorizontalAlignment(SwingConstants.CENTER);
		pnl_sAbout.add(lbl_a2);

		JLabel lbl_a3 = new JLabel("© Hugo Ramos");
		lbl_a3.setFont(carregarFont("plain", 14));
		lbl_a3.setForeground(Color.WHITE);
		lbl_a3.setHorizontalAlignment(SwingConstants.CENTER);
		pnl_sAbout.add(lbl_a3);
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
}
