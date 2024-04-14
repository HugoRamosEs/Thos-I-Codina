package thosi;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.FontFormatException;
import javax.swing.JMenuBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JDialog;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JCheckBoxMenuItem;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.io.InputStream;
import java.awt.Cursor;

public class CalculadoraGrafic implements KeyListener {
	private JFrame frame;
	private JTextField textField;
	private JCheckBoxMenuItem chckbx_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraGrafic window = new CalculadoraGrafic();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculadoraGrafic()  {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		chckbx_1 = new JCheckBoxMenuItem("Tema Oscur (T)");
		chckbx_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(CalculadoraGrafic.class.getResource("/img/icon512w.png")));
		frame.setTitle("Calculadora d'Angles");
		frame.setBounds(100, 100, 372, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		
		String rutaNunito = "/font/Nunito/Nunito-VariableFont_wght.ttf";
		String rutaNunitoItalic = "/font/Nunito/Nunito-Italic-VariableFont_wght.ttf";
		String rutaRubik = "/font/Rubik/Rubik-VariableFont_wght.ttf";
		String rutaRubikItalic = "/font/Rubik/Rubik-Italic-VariableFont_wght.ttf";
		
		JPanel pnl_north = new JPanel();
		pnl_north.setBackground(new Color(245, 245, 245));
		pnl_north.setBorder(new EmptyBorder(10, 10, 10, 10));
		frame.getContentPane().add(pnl_north, BorderLayout.NORTH);
		pnl_north.setLayout(new BorderLayout(0, 0));

		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setMargin(new Insets(10, 10, 10, 10));
		textField.setFont(carregarFont(rutaRubik, "bold", 28));
		textField.setForeground(new Color(0, 0, 0));
		textField.setBackground(new Color(255, 255, 255));
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				frame.requestFocus();
			}
		});
		pnl_north.add(textField);

		JPanel pnl_center = new JPanel();
		pnl_center.setBackground(new Color(245, 245, 245));
		pnl_center.setBorder(new EmptyBorder(10, 10, 10, 10));
		frame.getContentPane().add(pnl_center, BorderLayout.CENTER);
		pnl_center.setLayout(new GridLayout(4, 3, 5, 5));

		JButton btn_7 = new JButton("7");
		btn_7.setFont(carregarFont(rutaRubik, "bold", 32));
		btn_7.setForeground(new Color(0, 0, 0));
		btn_7.setBackground(new Color(176, 196, 222));
		btn_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "7");
				frame.requestFocus();
			}
		});

		JButton btn_Ac = new JButton("AC");
		btn_Ac.setFont(carregarFont(rutaRubik, "bold", 32));
		btn_Ac.setForeground(new Color(0, 0, 0));
		btn_Ac.setBackground(new Color(230, 230, 250));
		btn_Ac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
				frame.requestFocus();
			}
		});
		pnl_center.add(btn_Ac);
		pnl_center.add(btn_7);

		JButton btn_8 = new JButton("8");
		btn_8.setFont(carregarFont(rutaRubik, "bold", 32));
		btn_8.setForeground(new Color(0, 0, 0));
		btn_8.setBackground(new Color(176, 196, 222));
		btn_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "8");
				frame.requestFocus();
			}
		});
		pnl_center.add(btn_8);

		JButton btn_9 = new JButton("9");
		btn_9.setFont(carregarFont(rutaRubik, "bold", 32));
		btn_9.setForeground(new Color(0, 0, 0));
		btn_9.setBackground(new Color(176, 196, 222));
		btn_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "9");
				frame.requestFocus();
			}
		});
		pnl_center.add(btn_9);

		JButton btn_4 = new JButton("4");
		btn_4.setFont(carregarFont(rutaRubik, "bold", 32));
		btn_4.setForeground(new Color(0, 0, 0));
		btn_4.setBackground(new Color(176, 196, 222));
		btn_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "4");
				frame.requestFocus();
			}
		});

		JButton btn_suma = new JButton("+");
		btn_suma.setFont(carregarFont(rutaRubik, "bold", 32));
		btn_suma.setBackground(new Color(255, 215, 0));
		btn_suma.setForeground(new Color(0, 0, 0));
		btn_suma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "+");
				frame.requestFocus();
			}
		});
		pnl_center.add(btn_suma);
		pnl_center.add(btn_4);

		JButton btn_5 = new JButton("5");
		btn_5.setFont(carregarFont(rutaRubik, "bold", 32));
		btn_5.setForeground(new Color(0, 0, 0));
		btn_5.setBackground(new Color(176, 196, 222));
		btn_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "5");
				frame.requestFocus();
			}
		});
		pnl_center.add(btn_5);

		JButton btn_6 = new JButton("6");
		btn_6.setFont(carregarFont(rutaRubik, "bold", 32));
		btn_6.setForeground(new Color(0, 0, 0));
		btn_6.setBackground(new Color(176, 196, 222));
		btn_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "6");
				frame.requestFocus();
			}
		});
		pnl_center.add(btn_6);

		JButton btn_1 = new JButton("1");
		btn_1.setFont(carregarFont(rutaRubik, "bold", 32));
		btn_1.setForeground(new Color(0, 0, 0));
		btn_1.setBackground(new Color(176, 196, 222));
		btn_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "1");
				frame.requestFocus();
			}
		});

		JButton btn_resta = new JButton("-");
		btn_resta.setFont(carregarFont(rutaRubik, "bold", 32));
		btn_resta.setBackground(new Color(255, 215, 0));
		btn_resta.setForeground(new Color(0, 0, 0));
		btn_resta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "-");
				frame.requestFocus();
			}
		});
		pnl_center.add(btn_resta);
		pnl_center.add(btn_1);

		JButton btn_2 = new JButton("2");
		btn_2.setFont(carregarFont(rutaRubik, "bold", 32));
		btn_2.setForeground(new Color(0, 0, 0));
		btn_2.setBackground(new Color(176, 196, 222));
		btn_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "2");
				frame.requestFocus();
			}
		});
		pnl_center.add(btn_2);

		JButton btn_3 = new JButton("3");
		btn_3.setFont(carregarFont(rutaRubik, "bold", 32));
		btn_3.setForeground(new Color(0, 0, 0));
		btn_3.setBackground(new Color(176, 196, 222));
		btn_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "3");
				frame.requestFocus();
			}
		});
		pnl_center.add(btn_3);

		JButton btn_dosPunts = new JButton(":");
		btn_dosPunts.setFont(carregarFont(rutaRubik, "bold", 32));
		btn_dosPunts.setForeground(new Color(0, 0, 0));
		btn_dosPunts.setBackground(new Color(176, 196, 222));
		btn_dosPunts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + ":");
				frame.requestFocus();
			}
		});

		JButton btn_igual = new JButton("=");
		btn_igual.setFont(carregarFont(rutaRubik, "bold", 32));
		btn_igual.setBackground(new Color(255, 215, 0));
		btn_igual.setForeground(new Color(0, 0, 0));
		btn_igual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CalculadoraLogic calculadora = new CalculadoraLogic(textField.getText());
				textField.setText(calculadora.opera());
				frame.requestFocus();
			}
		});
		pnl_center.add(btn_igual);
		pnl_center.add(btn_dosPunts);

		JButton btn_esborrar = new JButton("");
		btn_esborrar.setIcon(new ImageIcon(CalculadoraGrafic.class.getResource("/img/del32.png")));
		btn_esborrar.setForeground(new Color(0, 0, 0));
		btn_esborrar.setBackground(new Color(230, 230, 250));
		btn_esborrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textField.getText().length() > 0) {
					String textActualitzat = textField.getText().substring(0, textField.getText().length() - 1);
					textField.setText(textActualitzat);
					frame.requestFocus();
				}
			}
		});

		JButton btn_0 = new JButton("0");
		btn_0.setFont(carregarFont(rutaRubik, "bold", 32));
		btn_0.setForeground(new Color(0, 0, 0));
		btn_0.setBackground(new Color(176, 196, 222));
		btn_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "0");
				frame.requestFocus();
			}
		});
		pnl_center.add(btn_0);
		pnl_center.add(btn_esborrar);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(245, 245, 245));
		frame.setJMenuBar(menuBar);
		
		JMenu mn_1 = new JMenu("Menú");
		mn_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mn_1.setForeground(new Color(100, 100, 100));
		mn_1.setBorder(new EmptyBorder(6, 6, 6, 6));
		mn_1.setIcon(new ImageIcon(CalculadoraGrafic.class.getResource("/img/menu16.png")));
		mn_1.setFont(carregarFont(rutaRubik, "bold", 14));
		menuBar.add(mn_1);
		
		JMenuItem mni_about = new JMenuItem("About");
		mni_about.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mni_about.setBorder(new EmptyBorder(5, 6, 5, 0));
		mni_about.setFont(carregarFont(rutaRubik, "plain", 14));
		mni_about.setBackground(new Color(245, 245, 245));
		mni_about.setForeground(new Color(0, 0, 0));
		mni_about.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mostrarAbout();
			}
		});
		mn_1.add(mni_about);
		
		JMenuItem mni_help = new JMenuItem("Ajuda (A)");
		mni_help.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mni_help.setBorder(new EmptyBorder(5, 6, 5, 0));
		mni_help.setFont(carregarFont(rutaRubik, "plain", 14));
		mni_help.setBackground(new Color(245, 245, 245));
		mni_help.setForeground(new Color(0, 0, 0));
		mni_help.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mostrarAjuda();
			}
		});
		mn_1.add(mni_help);
		
		JMenuItem mni_shorcuts = new JMenuItem("Dreceres (D)");
		mni_shorcuts.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mni_shorcuts.setBorder(new EmptyBorder(5, 6, 5, 0));
		mni_shorcuts.setFont(carregarFont(rutaRubik, "plain", 14));
		mni_shorcuts.setBackground(new Color(245, 245, 245));
		mni_shorcuts.setForeground(new Color(0, 0, 0));
		mni_shorcuts.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mostrarDreceres();
			}
		});
		mn_1.add(mni_shorcuts);

		
		mn_1.add(chckbx_1);
		chckbx_1.setBorder(new EmptyBorder(6, 6, 6, 6));
		chckbx_1.setBackground(new Color(245, 245, 245));
		chckbx_1.setForeground(new Color(0, 0, 0));
		chckbx_1.setFont(carregarFont(rutaRubik, "plain", 14));
		chckbx_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbx_1.isSelected()) {
					pnl_north.setBackground(Color.DARK_GRAY);
					pnl_center.setBackground(Color.DARK_GRAY);
					btn_7.setForeground(new Color(255, 255, 255));
					btn_7.setBackground(new Color(105, 105, 105));
					btn_8.setForeground(new Color(255, 255, 255));
					btn_8.setBackground(new Color(105, 105, 105));
					btn_9.setForeground(new Color(255, 255, 255));
					btn_9.setBackground(new Color(105, 105, 105));
					btn_4.setForeground(new Color(255, 255, 255));
					btn_4.setBackground(new Color(105, 105, 105));
					btn_5.setForeground(new Color(255, 255, 255));
					btn_5.setBackground(new Color(105, 105, 105));
					btn_6.setForeground(new Color(255, 255, 255));
					btn_6.setBackground(new Color(105, 105, 105));
					btn_1.setForeground(new Color(255, 255, 255));
					btn_1.setBackground(new Color(105, 105, 105));
					btn_2.setForeground(new Color(255, 255, 255));
					btn_2.setBackground(new Color(105, 105, 105));
					btn_3.setForeground(new Color(255, 255, 255));
					btn_3.setBackground(new Color(105, 105, 105));
					btn_0.setForeground(new Color(255, 255, 255));
					btn_0.setBackground(new Color(105, 105, 105));
					btn_dosPunts.setForeground(new Color(255, 255, 255));
					btn_dosPunts.setBackground(new Color(105, 105, 105));
					btn_suma.setBackground(new Color(106, 90, 205));
					btn_suma.setForeground(new Color(255, 255, 255));
					btn_resta.setBackground(new Color(106, 90, 205));
					btn_resta.setForeground(new Color(255, 255, 255));
					btn_igual.setBackground(new Color(106, 90, 205));
					btn_igual.setForeground(new Color(255, 255, 255));
					btn_Ac.setForeground(new Color(0, 0, 0));
					btn_Ac.setBackground(new Color(169, 169, 169));
					btn_esborrar.setBackground(new Color(169, 169, 169));
					chckbx_1.setBackground(Color.DARK_GRAY);
					chckbx_1.setForeground(new Color(255, 255, 255));
					menuBar.setBackground(Color.DARK_GRAY);
					mn_1.setForeground(new Color(255, 255, 255));
					mn_1.setIcon(new ImageIcon(CalculadoraGrafic.class.getResource("/img/menu16w.png")));
					mni_help.setBackground(Color.DARK_GRAY);
					mni_help.setForeground(new Color(255, 255, 255));
					mni_about.setBackground(Color.DARK_GRAY);
					mni_about.setForeground(new Color(255, 255, 255));
					mni_shorcuts.setBackground(Color.DARK_GRAY);
					mni_shorcuts.setForeground(new Color(255, 255, 255));
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage(CalculadoraGrafic.class.getResource("/img/icon512b.png")));
					textField.setForeground(new Color(255, 255, 255));
					textField.setBackground(Color.GRAY);
				}else {
					pnl_north.setBackground(new Color(245, 245, 245));
					pnl_center.setBackground(new Color(245, 245, 245));
					btn_7.setForeground(new Color(0, 0, 0));
					btn_7.setBackground(new Color(176, 196, 222));
					btn_8.setForeground(new Color(0, 0, 0));
					btn_8.setBackground(new Color(176, 196, 222));
					btn_9.setForeground(new Color(0, 0, 0));
					btn_9.setBackground(new Color(176, 196, 222));
					btn_4.setForeground(new Color(0, 0, 0));
					btn_4.setBackground(new Color(176, 196, 222));
					btn_5.setForeground(new Color(0, 0, 0));
					btn_5.setBackground(new Color(176, 196, 222));
					btn_6.setForeground(new Color(0, 0, 0));
					btn_6.setBackground(new Color(176, 196, 222));
					btn_1.setForeground(new Color(0, 0, 0));
					btn_1.setBackground(new Color(176, 196, 222));
					btn_2.setForeground(new Color(0, 0, 0));
					btn_2.setBackground(new Color(176, 196, 222));
					btn_3.setForeground(new Color(0, 0, 0));
					btn_3.setBackground(new Color(176, 196, 222));
					btn_0.setForeground(new Color(0, 0, 0));
					btn_0.setBackground(new Color(176, 196, 222));
					btn_dosPunts.setForeground(new Color(0, 0, 0));
					btn_dosPunts.setBackground(new Color(176, 196, 222));
					btn_esborrar.setBackground(new Color(211, 211, 211));
					btn_suma.setBackground(new Color(255, 215, 0));
					btn_suma.setForeground(new Color(0, 0, 0));
					btn_resta.setBackground(new Color(255, 215, 0));
					btn_resta.setForeground(new Color(0, 0, 0));
					btn_igual.setBackground(new Color(255, 215, 0));
					btn_igual.setForeground(new Color(0, 0, 0));
					btn_Ac.setBackground(new Color(230, 230, 250));
					btn_esborrar.setBackground(new Color(230, 230, 250));
					chckbx_1.setBackground(new Color(245, 245, 245));
					chckbx_1.setForeground(new Color(0, 0, 0));
					menuBar.setBackground(new Color(245, 245, 245));
					mn_1.setForeground(new Color(100, 100, 100));
					mn_1.setIcon(new ImageIcon(CalculadoraGrafic.class.getResource("/img/menu16.png")));
					mni_about.setBackground(new Color(245, 245, 245));
					mni_about.setForeground(new Color(0, 0, 0));
					mni_help.setBackground(new Color(245, 245, 245));
					mni_help.setForeground(new Color(0, 0, 0));
					mni_shorcuts.setBackground(new Color(245, 245, 245));
					mni_shorcuts.setForeground(new Color(0, 0, 0));
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage(CalculadoraGrafic.class.getResource("/img/icon512w.png")));
					textField.setForeground(new Color(0, 0, 0));
					textField.setBackground(new Color(255, 255, 255));
				}
			}
		});
		
		frame.setFocusable(true);
		frame.requestFocus();
		frame.setVisible(true);
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
	
	public Font carregarFont(String ruta, String estil, int tamany) {
        try (InputStream is = CalculadoraGrafic.class.getResourceAsStream(ruta)) {
            return Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(estilFont(estil), tamany);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return new Font("Arial", Font.PLAIN, 14);
        }
    }

	public void mostrarAbout() {
		String rutaRubik = "/font/Rubik/Rubik-VariableFont_wght.ttf";
		
        JDialog aboutDialog = new JDialog(frame, "About", true);
        aboutDialog.setResizable(false);
        aboutDialog.setSize(265, 300);
        aboutDialog.setLocationRelativeTo(frame);
        aboutDialog.setBackground(new Color(245, 245, 245));
        
        JPanel pnl_cAbout = new JPanel();
        pnl_cAbout.setBackground(new Color(245, 245, 245));
        pnl_cAbout.setBorder(new EmptyBorder(10, 10, 10, 10));
        aboutDialog.getContentPane().add(pnl_cAbout, BorderLayout.CENTER);
		pnl_cAbout.setLayout(new GridLayout(1, 1, 0, 0));
		
		JLabel lbl_aImg = new JLabel("");
		lbl_aImg.setIcon(new ImageIcon(CalculadoraGrafic.class.getResource("/img/icon128w.png")));
		lbl_aImg.setHorizontalAlignment(JLabel.CENTER);
		lbl_aImg.setBackground(new Color(245, 245, 245));
		pnl_cAbout.add(lbl_aImg);
        
        JPanel pnl_sAbout = new JPanel();
        pnl_sAbout.setBackground(new Color(245, 245, 245));
        pnl_sAbout.setBorder(new EmptyBorder(10, 10, 10, 10));
        aboutDialog.getContentPane().add(pnl_sAbout, BorderLayout.SOUTH);
		pnl_sAbout.setLayout(new GridLayout(4, 1, 0, 0));

		JLabel lbl_a1 = new JLabel("CALCULADORA D'ANGLES");
		lbl_a1.setFont(carregarFont(rutaRubik, "bold", 18));
		lbl_a1.setForeground(new Color(0, 0, 0));
		lbl_a1.setHorizontalAlignment(JLabel.CENTER);
		lbl_a1.setVerticalAlignment(JLabel.BOTTOM);
		pnl_sAbout.add(lbl_a1);
		
		JLabel lbl_a2 = new JLabel("Versió 1.0");
		lbl_a2.setFont(carregarFont(rutaRubik, "plain", 14));
		lbl_a2.setForeground(new Color(0, 0, 0));
		lbl_a2.setHorizontalAlignment(JLabel.CENTER);
		lbl_a2.setVerticalAlignment(JLabel.TOP);
		pnl_sAbout.add(lbl_a2);
		
		JLabel lbl_a3 = new JLabel("© Hugo Ramos");
		lbl_a3.setFont(carregarFont(rutaRubik, "plain", 14));
		lbl_a3.setForeground(new Color(0, 0, 0));
		lbl_a3.setHorizontalAlignment(JLabel.CENTER);
		lbl_a3.setVerticalAlignment(JLabel.BOTTOM);
		pnl_sAbout.add(lbl_a3);
		
		if (chckbx_1.isSelected()) {
			aboutDialog.setBackground(Color.DARK_GRAY);
			pnl_cAbout.setBackground(Color.DARK_GRAY);
			pnl_sAbout.setBackground(Color.DARK_GRAY);
			lbl_a1.setForeground(new Color(255, 255, 255));
			lbl_a2.setForeground(new Color(255, 255, 255));
			lbl_a3.setForeground(new Color(255, 255, 255));
			lbl_aImg.setIcon(new ImageIcon(CalculadoraGrafic.class.getResource("/img/icon128b.png")));
		}else {
			aboutDialog.setBackground(new Color(245, 245, 245));
			pnl_cAbout.setBackground(new Color(245, 245, 245));
			pnl_sAbout.setBackground(new Color(245, 245, 245));
			lbl_a1.setForeground(new Color(0, 0, 0));
			lbl_a2.setForeground(new Color(0, 0, 0));
			lbl_a3.setForeground(new Color(0, 0, 0));
			lbl_aImg.setIcon(new ImageIcon(CalculadoraGrafic.class.getResource("/img/icon128w.png")));
		}

        aboutDialog.setVisible(true);
    }
	
	public void mostrarAjuda() {
		String rutaRubik = "/font/Rubik/Rubik-VariableFont_wght.ttf";
		
        JDialog helpDialog = new JDialog(frame, "Ajuda", true);
        helpDialog.setResizable(false);
        helpDialog.setSize(340, 340);
        helpDialog.setLocationRelativeTo(frame);
        helpDialog.setBackground(new Color(245, 245, 245));
        
        JPanel pnl_cHelp = new JPanel();
        pnl_cHelp.setBackground(new Color(245, 245, 245));
        pnl_cHelp.setBorder(new EmptyBorder(10, 10, 10, 10));
        helpDialog.getContentPane().add(pnl_cHelp, BorderLayout.CENTER);
		pnl_cHelp.setLayout(new GridLayout(2, 1, 0, 0));

		JLabel lbl_hImg = new JLabel("");
		lbl_hImg.setIcon(new ImageIcon(CalculadoraGrafic.class.getResource("/img/ayuda130.png")));
		lbl_hImg.setHorizontalAlignment(JLabel.CENTER);
		lbl_hImg.setBackground(new Color(245, 245, 245));
		pnl_cHelp.add(lbl_hImg);
		
		JLabel lbl_h2 = new JLabel("<html>"
									+ "<p style='text-align: justify;'>Calculadora que permet realitzar operacions matemàtiques amb angles. Només permet operacions de suma i resta d'angles, en totes les seves variants. Només es poden entrar caràcters numèrics i símbols, a del retrocedir i suprimir.</p>"
								+ "</html");
		lbl_h2.setFont(carregarFont(rutaRubik, "plain", 14));
		lbl_h2.setForeground(new Color(0, 0, 0));
		lbl_h2.setHorizontalAlignment(JLabel.CENTER);
		lbl_h2.setVerticalAlignment(JLabel.TOP);
		pnl_cHelp.add(lbl_h2);
		
		if (chckbx_1.isSelected()) {
			helpDialog.setBackground(Color.DARK_GRAY);
			pnl_cHelp.setBackground(Color.DARK_GRAY);
			lbl_h2.setForeground(new Color(255, 255, 255));
		}else {
			helpDialog.setBackground(new Color(245, 245, 245));
			pnl_cHelp.setBackground(new Color(245, 245, 245));
			lbl_h2.setForeground(new Color(0, 0, 0));
		}

        helpDialog.setVisible(true);
    }
	
	public void mostrarDreceres() {
		String rutaRubik = "/font/Rubik/Rubik-VariableFont_wght.ttf";
		
        JDialog shorcutDialog = new JDialog(frame, "Dreceres", true);
        shorcutDialog.setResizable(false);
        shorcutDialog.setSize(300, 300);
        shorcutDialog.setLocationRelativeTo(frame);
        shorcutDialog.setBackground(new Color(245, 245, 245));
        
        JPanel pnl_cShorcut = new JPanel();
        pnl_cShorcut.setBackground(new Color(245, 245, 245));
        pnl_cShorcut.setBorder(new EmptyBorder(10, 10, 10, 10));
        shorcutDialog.getContentPane().add(pnl_cShorcut, BorderLayout.CENTER);
		pnl_cShorcut.setLayout(new GridLayout(1, 1, 0, 0));
		
		JLabel lbl_s2 = new JLabel("<html>"
									+ "<div style='text-align: center;'><span style='font-weight: bold;'>Menú</span></div>"
									+ "<ul>"
										+ "<li>A: Submenú Ajuda</li>"
										+ "<li>D: Submenú Dreceres</li>"
										+ "<li>T: Canviar Tema</li>"
									+ "</ul>"
									+ "<div style='text-align: center;'><span style='font-weight: bold;'>Funcionament</span></div>"
									+ "<ul>"
										+ "<li>Símbols: + - :</li>"
										+ "<li>Números: Del 0 al 9</li>"
										+ "<li>Del: Limpiar text</li>"
										+ "<li>Back: Esborrar l'últim caràcter</li>"
										+ "<li>Enter: Calcular i mostrar resultat</li>"
									+ "</ul>"
								+ "</html>");
		lbl_s2.setFont(carregarFont(rutaRubik, "plain", 14));
		lbl_s2.setHorizontalAlignment(JLabel.CENTER);
		lbl_s2.setVerticalAlignment(JLabel.CENTER);
		pnl_cShorcut.add(lbl_s2);
		
		if (chckbx_1.isSelected()) {
			shorcutDialog.setBackground(Color.DARK_GRAY);
			pnl_cShorcut.setBackground(Color.DARK_GRAY);
			lbl_s2.setForeground(new Color(255, 255, 255));
		}else {
			shorcutDialog.setBackground(new Color(245, 245, 245));
			pnl_cShorcut.setBackground(new Color(245, 245, 245));
			lbl_s2.setForeground(new Color(0, 0, 0));
		}

        shorcutDialog.setVisible(true);
    }

	@Override
	public void keyTyped(KeyEvent e) {
		char tecla = e.getKeyChar();
		
		if (Character.isDigit(tecla)) {
            textField.setText(textField.getText() + tecla);
        }else if (tecla == '+') {
            textField.setText(textField.getText() + "+");
        }else if (tecla == '-') {
            textField.setText(textField.getText() + "-");
        }else if (tecla == ':') {
            textField.setText(textField.getText() + ":");
        }else if (tecla == KeyEvent.VK_BACK_SPACE) {
        	if (textField.getText().length() > 0) {
				String textActualitzat = textField.getText().substring(0, textField.getText().length() - 1);
				textField.setText(textActualitzat);
			}
        }else if (tecla == KeyEvent.VK_DELETE) {
        	textField.setText("");
        }else if (tecla == KeyEvent.VK_ENTER) {
        	CalculadoraLogic calculadora = new CalculadoraLogic(textField.getText());
			textField.setText(calculadora.opera());
        }else if (tecla == 'a' || tecla == 'A') {
            mostrarAjuda();
        }else if (tecla == 'd' || tecla == 'D') {
            mostrarDreceres();
        }else if (tecla == 't' || tecla == 'T') {
        	chckbx_1.doClick();
        }else {
        	JOptionPane.showMessageDialog(null, "Tecla invàlida. Per a més informació sobre les tecles vàlides prem la tecla D.", "TECLA NO PERMESA", JOptionPane.ERROR_MESSAGE);
        }
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
}

