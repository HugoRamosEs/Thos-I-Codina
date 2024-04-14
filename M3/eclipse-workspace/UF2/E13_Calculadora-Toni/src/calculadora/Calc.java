package calculadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.KeyStroke;

import angle.Angle;
import angle.CalculadoraException;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Component;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class Calc implements ActionListener{

	private JFrame frmCalculadoraDelTemps;
	private JPanel panelNumeros;
	private JPanel panelOperadors;
	private JPanel panelControl;
	private JTextField pantalla;
	private Angle temps1;
	private boolean borrar = false;
	private String operacio = "";

	private JMenuBar menuBar;
	private JMenu menu1, menu2, menu3, menu4;
	private JMenuItem menuItem21, menuItem22, menuItem31, menuItem32, menuItem41;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc window = new Calc();
					window.frmCalculadoraDelTemps.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadoraDelTemps = new JFrame();
		frmCalculadoraDelTemps.setTitle("CALCULADORA DEL TEMPS");
		frmCalculadoraDelTemps.setBounds(100, 100, 450, 300);
		frmCalculadoraDelTemps.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculadoraDelTemps.getContentPane().setLayout(new BorderLayout(5, 5));
		
		this.initMenus();

		JLabel lblNewLabel = new JLabel("Thos i Codina by Toni");
		lblNewLabel.setFont(new Font("OpenDyslexicMono", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.RED);
		frmCalculadoraDelTemps.getContentPane().add(lblNewLabel, BorderLayout.SOUTH);

		/*
		 * PANELL DE NUMEROS
		 * ******************************************************************** ZONA
		 * CENTER
		 */
		panelNumeros = new JPanel();
		panelNumeros.setLayout(new GridLayout(4, 3, 5, 5));

		JButton button1 = new JButton("1");
		button1.setAlignmentX(Component.CENTER_ALIGNMENT);
		button1.setFont(new Font("Dialog", Font.BOLD, 40));
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (borrar) {
					pantalla.setText("1");
					borrar = false;
				} else {
					pantalla.setText(pantalla.getText() + "1");
				}
			}
		});
		panelNumeros.add(button1);

		JButton button2 = new JButton("2");
		button2.setFont(new Font("Dialog", Font.BOLD, 40));
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (borrar) {
					pantalla.setText("2");
					borrar = false;
				} else {
					pantalla.setText(pantalla.getText() + "2");
				}
			}
		});
		panelNumeros.add(button2);

		JButton button3 = new JButton("3");
		button3.setFont(new Font("Dialog", Font.BOLD, 40));
		button3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (borrar) {
					pantalla.setText("3");
					borrar = false;
				} else {
					pantalla.setText(pantalla.getText() + "3");
				}
			}
		});
		panelNumeros.add(button3);

		JButton button4 = new JButton("4");
		button4.setFont(new Font("Dialog", Font.BOLD, 40));
		button4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (borrar) {
					pantalla.setText("4");
					borrar = false;
				} else {
					pantalla.setText(pantalla.getText() + "4");
				}
			}
		});
		panelNumeros.add(button4);

		JButton button5 = new JButton("5");
		button5.setFont(new Font("Dialog", Font.BOLD, 40));
		button5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (borrar) {
					pantalla.setText("5");
					borrar = false;
				} else {
					pantalla.setText(pantalla.getText() + "5");
				}
			}
		});
		panelNumeros.add(button5);

		JButton button6 = new JButton("6");
		button6.setFont(new Font("Dialog", Font.BOLD, 40));
		button6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (borrar) {
					pantalla.setText("6");
					borrar = false;
				} else {
					pantalla.setText(pantalla.getText() + "6");
				}
			}
		});
		panelNumeros.add(button6);

		JButton button7 = new JButton("7");
		button7.setFont(new Font("Dialog", Font.BOLD, 40));
		button7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (borrar) {
					pantalla.setText("7");
					borrar = false;
				} else {
					pantalla.setText(pantalla.getText() + "7");
				}
			}
		});
		panelNumeros.add(button7);

		JButton button8 = new JButton("8");
		button8.setFont(new Font("Dialog", Font.BOLD, 40));
		button8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (borrar) {
					pantalla.setText("8");
					borrar = false;
				} else {
					pantalla.setText(pantalla.getText() + "8");
				}
			}
		});
		panelNumeros.add(button8);

		JButton button9 = new JButton("9");
		button9.setFont(new Font("Dialog", Font.BOLD, 40));
		button9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (borrar) {
					pantalla.setText("9");
					borrar = false;
				} else {
					pantalla.setText(pantalla.getText() + "9");
				}
			}
		});
		panelNumeros.add(button9);

		JButton button0 = new JButton("0");
		button0.setFont(new Font("Dialog", Font.BOLD, 40));
		button0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (borrar) {
					pantalla.setText("0");
					borrar = false;
				} else {
					pantalla.setText(pantalla.getText() + "0");
				}
			}
		});
		panelNumeros.add(button0);

		frmCalculadoraDelTemps.getContentPane().add(panelNumeros, BorderLayout.CENTER);

		/*
		 * PANTALLA *************************************************************
		 * *****************
		 */

		pantalla = new JTextField();
		pantalla.setHorizontalAlignment(JTextField.RIGHT);
		pantalla.setFont(new Font("Pocket Calculator", Font.BOLD, 40));
		pantalla.setForeground(Color.BLUE);
		pantalla.setColumns(15);
		frmCalculadoraDelTemps.getContentPane().add(pantalla, BorderLayout.NORTH);

		/*
		 * PANELL D'OPERADORS
		 * ******************************************************************** ZONA
		 * EAST
		 */
		panelOperadors = new JPanel();
		panelOperadors.setLayout(new GridLayout(3, 1, 5, 5));

		JButton buttonMas = new JButton("+");
		buttonMas.setFont(new Font("Dialog", Font.BOLD, 40));
		buttonMas.setBackground(Color.ORANGE);
		buttonMas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (temps1 == null) {
						temps1 = new Angle(pantalla.getText());
					} else {
						if (operacio == "") {
							pantalla.setText("");
						} else {
							temps1 = temps1.suma(new Angle(pantalla.getText()));
							pantalla.setText(temps1.toString());
						}
					}
					operacio = "+";
					borrar = true;
				} catch (CalculadoraException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Temps negatiu", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		panelOperadors.add(buttonMas);

		JButton buttonMenos = new JButton("-");
		buttonMenos.setFont(new Font("Dialog", Font.BOLD, 40));
		buttonMenos.setBackground(Color.ORANGE);
		buttonMenos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (temps1 == null) {
						temps1 = new Angle(pantalla.getText());
					} else {
						if (operacio == "") {
							pantalla.setText("");
						} else {
							temps1 = temps1.resta(new Angle(pantalla.getText()));
							pantalla.setText(temps1.toString());
						}
					}
					operacio = "-";
					borrar = true;
				} catch (CalculadoraException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Temps negatiu", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		panelOperadors.add(buttonMenos);

		JButton buttonIgual = new JButton("=");
		buttonIgual.setFont(new Font("Dialog", Font.BOLD, 40));
		buttonIgual.setBackground(Color.ORANGE);
		buttonIgual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (operacio == "+") {
						temps1 = temps1.suma(new Angle(pantalla.getText()));
					} else if (operacio == "-") {
						temps1 = temps1.resta(new Angle(pantalla.getText()));
					} else if (operacio == "") {
						temps1 = new Angle(pantalla.getText());
					}
				} catch (CalculadoraException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Temps negatiu", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} finally {
					operacio = "";
					borrar = true;
					pantalla.setText(temps1.toString());

				}
			}
		});
		panelOperadors.add(buttonIgual);

		frmCalculadoraDelTemps.getContentPane().add(panelOperadors, BorderLayout.EAST);

		/*
		 * PANELL DE CONTROL
		 * ******************************************************************** ZONA
		 * WEST
		 */
		panelControl = new JPanel();
		panelControl.setLayout(new GridLayout(3, 1, 5, 5));

		JButton buttonAC = new JButton("AC");
		buttonAC.setFont(new Font("Dialog", Font.BOLD, 40));
		buttonAC.setBackground(Color.WHITE);
		buttonAC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pantalla.setText("");
				operacio = "";
				temps1 = null;
				borrar = false;
			}
		});
		panelControl.add(buttonAC);

		JButton buttonDosPuntos = new JButton(":");
		buttonDosPuntos.setFont(new Font("Dialog", Font.BOLD, 40));
		buttonDosPuntos.setBackground(Color.WHITE);
		buttonDosPuntos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pantalla.setText(pantalla.getText() + ":");
			}
		});
		panelControl.add(buttonDosPuntos);

		frmCalculadoraDelTemps.getContentPane().add(panelControl, BorderLayout.WEST);

	}
	
	public void initMenus() {
		// Creem el JMenuBar i ho associem al JFrame
		this.menuBar = new JMenuBar();
		this.frmCalculadoraDelTemps.setJMenuBar(menuBar);

		// Creem el primer JMenu i el passem per paràmetre amb el mètode add
		this.menu1 = new JMenu("Opcions1");
		this.menuBar.add(menu1);
		
		this.menu4 = new JMenu("Opcions2");
		this.menuBar.add(menu4);

		// Creem el segon i tercer objecte de la classe JMenu i els associem amb el
		// primer JMenu creat
		this.menu2 = new JMenu("Tamany de la finestra");
		this.menu1.add(menu2);
		this.menu3 = new JMenu("Color de fonds");
		menu1.add(menu3);

		// Creem els dos primers primers objectes de la clase JMenuItem i els associem amb el
		// segon JMenu
		this.menuItem21 = new JMenuItem("640*480");
		this.menu2.add(menuItem21);
		this.menuItem21.addActionListener(this);
		this.menuItem22 = new JMenuItem("1024*768");
		this.menu2.add(menuItem22);
		menuItem22.addActionListener(this);

		// Creem els altres dos objectes de la classe JMenuItem i els associem amb el
		// tercer JMenu
		this.menuItem31 = new JMenuItem("Vermell");
		this.menu3.add(menuItem31);
		this.menuItem31.addActionListener(this);
		this.menuItem32 = new JMenuItem("Verd");
		this.menu3.add(menuItem32);
		this.menuItem32.addActionListener(this);
		
		this.menu1.add(new JSeparator());
		
		
		//set shortcut ALT+maj+H (command+h on mac os)
        KeyStroke ctrlH = KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.VK_H);
        
		this.menuItem41 = new JMenuItem("About");
		this.menu1.add(menuItem41);
		
		//set the accelerator
        this.menuItem41.setAccelerator(ctrlH);
		
		this.menuItem41.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(null,"message in a bottle");
            }
        });
	}
	
	
	
	
    /* Mètode que implementa les accions de cada ítem de menú */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==menuItem21) {
        	frmCalculadoraDelTemps.setSize(640,480);
        }
        if (e.getSource()==menuItem22) {
        	frmCalculadoraDelTemps.setSize(1024,768);
        }
        if (e.getSource()==menuItem31) {
        	frmCalculadoraDelTemps.getContentPane().setBackground(new Color(255,0,0));
        }
        if (e.getSource()==menuItem32) {
        	frmCalculadoraDelTemps.getContentPane().setBackground(new Color(0,255,0));
        }
    }


}
