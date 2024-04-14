package votacions.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import votacions.model.objectes.MiDb4o;
import votacions.vista.components.About;

public abstract class View extends JFrame implements MouseListener, KeyListener {
	private static final long serialVersionUID = 1L;

	public void generarFinestra(int width, int height, String titol) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) (screenSize.getWidth() - width) / 2;
		int y = (int) (screenSize.getHeight() - height) / 2;
		this.setBounds(x, y, width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(titol);
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		this.setIconImage(
				Toolkit.getDefaultToolkit().getImage(View.class.getResource("/votacions/vista/recursos/logo.png")));
		this.setVisible(true);
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	MiDb4o.getInstance().getDb().close();
                dispose();
            }
        });
	}

	public void afegirMenu() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(149, 148, 148));
		menuBar.setBorder(new EmptyBorder(0, 15, 0, 0));
		
		setJMenuBar(menuBar);

		JMenu mn_1 = new JMenu("Menú");
		mn_1.setFont(this.carregarFont("plain", 14));
		menuBar.add(mn_1);

		JMenuItem mntm_1 = new JMenuItem("About");
		mntm_1.setFont(this.carregarFont("plain", 12));
		mn_1.add(mntm_1);
		mntm_1.setAccelerator(KeyStroke.getKeyStroke("control A"));
		mntm_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About about = new About(View.this);
			}
		});

		JSeparator separator = new JSeparator();
		mn_1.add(separator);

		JMenuItem mntm_2 = new JMenuItem("Sortir");
		mntm_2.setFont(this.carregarFont("plain", 12));
		mn_1.add(mntm_2);
		mntm_2.setAccelerator(KeyStroke.getKeyStroke("control S"));
		mntm_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MiDb4o.getInstance().getDb().close();
				System.exit(0);
			}
		});
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
