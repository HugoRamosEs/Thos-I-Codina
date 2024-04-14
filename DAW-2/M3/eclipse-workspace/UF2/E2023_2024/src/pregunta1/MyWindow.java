package pregunta1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class MyWindow extends JFrame implements MouseListener {
	private JButton btnGreen;
	private JButton btnYellow;
	private JButton btnRed;
	private JLabel lblText;
	private JPanel pnlSouth;
	private JPanel pnlCenter;
	private About about;
	private boolean grisClaro;

	public MyWindow() {
		this.pnlSouth = new JPanel();
		this.pnlCenter = new JPanel();
		this.btnGreen = new JButton("Green");
		this.btnYellow = new JButton("Yellow");
		this.btnRed = new JButton("Red");
		this.lblText = new JLabel("Examen M03 UF5 2023-2024 - Bona sort");
		this.grisClaro = true;
		init();
	}
	
	private void init() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		this.getContentPane().add(this.pnlSouth, BorderLayout.SOUTH);
		this.getContentPane().add(pnlCenter, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		getContentPane().add(menuBar, BorderLayout.NORTH);
		JMenu menu_a = new JMenu("Menu A");
		menuBar.add(menu_a);
		JMenu menu_b = new JMenu("Menu B");
		menuBar.add(menu_b);
		JMenu menu_1 = new JMenu("Menu 1");
		menu_b.add(menu_1);
		JMenuItem submenu_1 = new JMenuItem("Submenu 1.1");
		menu_1.add(submenu_1);
		JMenuItem submenu_2 = new JMenuItem("Submenu 1.2");
		menu_1.add(submenu_2);
		JMenuItem menu_acerca = new JMenuItem("Acerca de...");
		menu_b.add(menu_acerca);
		JSeparator separator = new JSeparator();
		menu_b.add(separator);
		JMenuItem menu_salir = new JMenuItem("Salir");
		menu_b.add(menu_salir);
		
		this.pnlCenter.add(btnGreen);
		this.btnGreen.addMouseListener(this);
		
		this.pnlCenter.add(btnYellow);
		this.btnYellow.addMouseListener(this);
		
		this.pnlCenter.add(btnRed);
		this.btnRed.addMouseListener(this);
		
		this.lblText.setBackground(new Color(211, 211, 211));
		this.pnlSouth.add(this.lblText);
	}
	
	public Font carregarFont(String ruta, int tamany) {
        try (InputStream is = MyWindow.class.getResourceAsStream(ruta)) {
            return Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(Font.PLAIN, tamany);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return new Font("Arial", Font.BOLD, 20);
        }
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == this.btnGreen) {
            this.lblText.setBackground(Color.WHITE);
			this.pnlSouth.setBackground(Color.WHITE);
            this.lblText.setForeground(Color.GREEN);
            this.lblText.setFont(new Font("Liberation Mono", Font.BOLD, 20));
        } else if (e.getSource() == this.btnYellow) {
        	this.lblText.setBackground(new Color(238,245,11, 160));
        	this.pnlSouth.setBackground(new Color(238,245,11));
        	this.lblText.setFont(carregarFont("fonts/Rubik_Burned/RubikBurned-Regular.ttf", 20));
        	this.lblText.setForeground(new Color(63,63,63,160));
        	if (this.grisClaro == true) {
        		this.lblText.setForeground(new Color(238,238,238,160));
        		this.grisClaro = false;
        	}else {
        		this.lblText.setForeground(new Color(63,63,63,160));
        		this.grisClaro = true;
        	}
        } else if (e.getSource() == this.btnRed) {
        	this.about = new About();
        }
	}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
