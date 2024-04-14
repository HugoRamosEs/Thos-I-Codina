package calculadora;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.annotation.processing.SupportedSourceVersion;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import acercaDE.Dialeg;
import angle.Angle;
import angle.CalculadoraException;
import angle.RoundedBorder;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyAdapter;

public class Calculadora extends JFrame implements MouseListener, KeyListener{
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	
	private Angle primerOperador;
	private String signe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora window = new Calculadora();
					window.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(),"Error en el procés", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculadora() {
		this.primerOperador = null;
		initialize();
		
		this.addKeyListener(this);
//		this.addMouseListener(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.defineLookAndFeel("Nimbus");		
		
		this.setTitle("Calculadora d'Angles");
		this.setBounds(100, 100, 450, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.creacioDeMenus();
		
		JPanel pnl_center = new JPanel();
		getContentPane().add(pnl_center, BorderLayout.CENTER);
		pnl_center.setLayout(new GridLayout(4, 5, 20, 20));
		
		JButton btn_1 = new JButton("1");
		btn_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "1");
			}
		});
		btn_1.setFont(new Font("Dialog", Font.BOLD, 24));
		pnl_center.add(btn_1);
		
		JButton btn_2 = new JButton("2");
		btn_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "2");
			}
		});
		btn_2.setFont(new Font("Dialog", Font.BOLD, 24));
		pnl_center.add(btn_2);
		
		JButton btn_3 = new JButton("3");
		btn_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "3");
			}
		});
		btn_3.setFont(new Font("Dialog", Font.BOLD, 24));
		pnl_center.add(btn_3);
		
		JButton btn_borra = new JButton("<<");
		btn_borra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				if (str.length()>0) {
					str = str.substring(0, str.length() - 1);
					textField.setText(str);
				}
			}
		});
		btn_borra.setFont(new Font("Dialog", Font.BOLD, 30));
		btn_borra.setBackground(new Color(255, 239, 213));
		pnl_center.add(btn_borra);
		
		JButton btn_4 = new JButton("4");
		btn_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "4");
			}
		});
		btn_4.setFont(new Font("Dialog", Font.BOLD, 24));
		pnl_center.add(btn_4);
		
		JButton btn_5 = new JButton("5");
		btn_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "5");
			}
		});
		btn_5.setFont(new Font("Dialog", Font.BOLD, 24));
		pnl_center.add(btn_5);
		
		JButton btn_6 = new JButton("6");
		btn_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "6");
			}
		});
		btn_6.setFont(new Font("Dialog", Font.BOLD, 24));
		pnl_center.add(btn_6);

		JButton btn_mes = new JButton("+");
		btn_mes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				suma();				
			}
		});
		btn_mes.setFont(new Font("Dialog", Font.BOLD, 30));
		btn_mes.setBackground(new Color(255, 235, 205));
		pnl_center.add(btn_mes);

		JButton btn_7 = new JButton("7");
		btn_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "7");
			}
		});
		btn_7.setFont(new Font("Dialog", Font.BOLD, 24));
		pnl_center.add(btn_7);

		JButton btn_8 = new JButton("8");
		btn_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "8");
			}
		});
		btn_8.setFont(new Font("Dialog", Font.BOLD, 24));
		pnl_center.add(btn_8);
		
		JButton btn_9 = new JButton("9");
		btn_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "9");
			}
		});
		btn_9.setFont(new Font("Dialog", Font.BOLD, 24));
		pnl_center.add(btn_9);
		
		JButton btn_menys = new JButton("-");
		btn_menys.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resta();
			}
		});
		btn_menys.setFont(new Font("Dialog", Font.BOLD, 30));
		btn_menys.setBackground(new Color(255, 239, 213));
		pnl_center.add(btn_menys);

		JButton btn_signe = new JButton("+/-");
		btn_signe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "-");
			}
		});
		pnl_center.add(btn_signe);
		
		JButton btn_0 = new JButton("0");
		btn_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "0");
			}
		});
		btn_0.setFont(new Font("Dialog", Font.BOLD, 24));
		pnl_center.add(btn_0);
		
		JButton btn_dospunts = new JButton(":");
		btn_dospunts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + ":");
			}
		});
		btn_dospunts.setFont(new Font("Dialog", Font.BOLD, 24));
		pnl_center.add(btn_dospunts);
		
		JButton btn_igual = new JButton("=");
		btn_igual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					igual();
				} catch (CalculadoraException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(),"Error en el procés", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btn_igual.setFont(new Font("Dialog", Font.BOLD, 30));
		btn_igual.setBackground(new Color(255, 160, 122));
		pnl_center.add(btn_igual);

		JPanel pnl_north = new JPanel();
		getContentPane().add(pnl_north, BorderLayout.NORTH);
		pnl_north.setLayout(new GridLayout(2, 1, 0, 0));
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println(e.getKeyCode() + " - " + e.getKeyChar());
			}
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println(e.getKeyCode() + " - " + e.getKeyChar());
				if (e.getKeyCode()==110) {
					textField.setText(textField.getText().replace(".", ":"));
				} else if (e.getKeyCode()==107 || e.getKeyCode()==521) {
					textField.setText(textField.getText().replace("+", ""));
					suma();
				} else if (e.getKeyCode()==109 || e.getKeyCode()==45) {					
					if (textField.getText().length()==1 || textField.getText().substring(textField.getText().length()-2,textField.getText().length()-1).equals(":") ) {
						//textField.setText(textField.getText() + "-");
					} else {
						textField.setText(textField.getText().substring(0,textField.getText().length()-1));
						resta();
					}
				} else if (e.getKeyCode()==10 || e.getKeyCode()==48) {
					try {
						textField.setText(textField.getText().replace("=", ""));
						igual();
					} catch (CalculadoraException ce) {
						JOptionPane.showMessageDialog(null, ce.getMessage(),"Error en el procés", JOptionPane.ERROR_MESSAGE);
						ce.printStackTrace();
					}
				}
			}
		});
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("Dialog", Font.PLAIN, 24));
		pnl_north.add(textField);
		textField.setColumns(40);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 24));
		pnl_north.add(textField_1);
		textField_1.setColumns(40);
		
		
	}
	
	public void creacioDeMenus() {
		//Creació de la barra de menús
		JMenuBar barra = new JMenuBar();
		
		//Creació dels submenús
		JMenu programa = new JMenu("Programa");
		JMenuItem lookandfeel = new JMenu("Look and feel");
		JMenuItem acerca = new JMenuItem("Acerca de...");
		JMenuItem salir = new JMenuItem("Salir");
		
		JMenuItem metal = new JMenuItem("Metal look and feel");
		JMenuItem nimbus = new JMenuItem("Numbus look and feel");
		
		//Afegim la barra de menús, junament amb les seves opcion.
		this.setJMenuBar(barra);

		barra.add(programa);
		programa.add(lookandfeel);
		lookandfeel.add(metal);
		lookandfeel.add(nimbus);
		programa.add(acerca);
		programa.addSeparator();
		programa.add(salir);

		//Establim accessos accés ràpids
		programa.setMnemonic('P'); //ALT + P
		acerca.setMnemonic('A'); //ALT + A
		
		//Establim toolTips a les opcions de menú
		acerca.setToolTipText("Mostra la informació de la meva calculadora");
		salir.setToolTipText("Sortir del programa");
		
		//Afegim events
		acerca.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				Dialeg winAcercaDe = new Dialeg();
				winAcercaDe.show();
			}
		});
		salir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.exit(0);
			}
		});
	}
	
	public void defineLookAndFeel(String selected) {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if (selected.equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		
		}catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
			JOptionPane.showMessageDialog(null, "No es pot carregar numbus L&F", "Caption", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void suma() {
		if (this.primerOperador == null) {
			try {
				this.primerOperador = new Angle(this.textField.getText());
				this.textField_1.setText(this.primerOperador.toString() + "+");
				this.textField.setText("");
				this.signe="+";
			} catch (CalculadoraException ce) {
				JOptionPane.showMessageDialog(null, ce.getMessage(),"Error en el procés", JOptionPane.ERROR_MESSAGE);
				ce.printStackTrace();
			}
		} else {
			try {
				Angle segonOperador = new Angle(textField.getText());
				Angle resultat = (this.signe == "+") ? this.primerOperador.suma(segonOperador) : this.primerOperador.resta(segonOperador);
				this.primerOperador = resultat;
				this.textField.setText(resultat.toString());
				this.textField_1.setText(textField_1.getText() + segonOperador.toString() + "=" + resultat.toString());
				this.signe = "+";
			} catch (CalculadoraException ce) {
				JOptionPane.showMessageDialog(null, ce.getMessage(),"Error en el procés", JOptionPane.ERROR_MESSAGE);
				ce.printStackTrace();
			}
		}
	}
	
	public void resta() {
		if (this.primerOperador == null) {
			try {
				this.primerOperador = new Angle(this.textField.getText());
				this.textField_1.setText(this.primerOperador.toString() + "-");
				this.textField.setText("");
				this.signe="-";
			} catch (CalculadoraException ce) {
				JOptionPane.showMessageDialog(null, ce.getMessage(),"Error en el procés", JOptionPane.ERROR_MESSAGE);
				ce.printStackTrace();
			}
		} else {
			try {
				Angle segonOperador = new Angle(textField.getText());
				Angle resultat = (this.signe == "+") ? this.primerOperador.suma(segonOperador) : this.primerOperador.resta(segonOperador);
				this.primerOperador = resultat;
				this.textField.setText(resultat.toString());
				this.textField_1.setText(textField_1.getText() + segonOperador.toString() + "=" + resultat.toString());
				this.signe = "-";
			} catch (CalculadoraException ce) {
				JOptionPane.showMessageDialog(null, ce.getMessage(),"Error en el procés", JOptionPane.ERROR_MESSAGE);
				ce.printStackTrace();
			}
		}
	}
	
	public void igual() throws CalculadoraException{
		if (this.primerOperador == null) {
			throw new CalculadoraException("Són necessaris dos operadors per realitzar una opeació");
		} else {
			try {
				Angle segonOperador = new Angle(textField.getText());
				Angle resultat = (this.signe == "+") ? this.primerOperador.suma(segonOperador) : this.primerOperador.resta(segonOperador);
//				this.primerOperador = resultat;
				this.textField.setText(resultat.toString());
//				this.textField.setText("");
				this.primerOperador=null;
				this.textField_1.setText(textField_1.getText() + segonOperador.toString() + "=" + resultat.toString());
			} catch (CalculadoraException ce) {
				JOptionPane.showMessageDialog(null, ce.getMessage(),"Error en el procés", JOptionPane.ERROR_MESSAGE);
				ce.printStackTrace();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("kkk");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode() + " - " + e.getKeyChar());
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode() + " - " + e.getKeyChar());
//		if ((e.getKeyCode()>=48 && e.getKeyCode()<=57) || (e.getKeyCode()>=96 && e.getKeyCode()<=105) ) {
//			textField_1.setText(textField_1.getText() + e.getKeyChar());
//		}
//		if (e.getKeyCode()==110 || e.getKeyCode()==46) {
//			textField_1.setText(textField_1.getText() + ":");
//		}
//		//suma
//		if (e.getKeyCode()==521 || e.getKeyCode()==107) {
//			
//		}
//		//resta
//		if (e.getKeyCode()==45 || e.getKeyCode()==109) {
//			
//		}
//		//Igual
//		if (e.getKeyCode()==48 || e.getKeyCode()==10) {
//			
//		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
