package cat.iesthosicodina;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pnl_center = new JPanel();
		frame.getContentPane().add(pnl_center, BorderLayout.CENTER);
		pnl_center.setLayout(new GridLayout(4, 3, 20, 20));
		
		JButton btn_1 = new JButton("1");
		btn_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		btn_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "1");
			}
		});
		btn_1.setForeground(new Color(255, 255, 255));
		btn_1.setBackground(new Color(0, 0, 205));
		pnl_center.add(btn_1);
		
		JButton button_1 = new JButton("2");
		pnl_center.add(button_1);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "2");
			}
		});
		
		JButton button_2 = new JButton("3");
		pnl_center.add(button_2);
		
		JButton button_3 = new JButton("4");
		pnl_center.add(button_3);
		
		JButton button_4 = new JButton("5");
		pnl_center.add(button_4);
		
		JButton button_5 = new JButton("6");
		pnl_center.add(button_5);
		
		JButton button_6 = new JButton("7");
		pnl_center.add(button_6);
		
		JButton button_7 = new JButton("8");
		pnl_center.add(button_7);
		
		JButton button_8 = new JButton("9");
		pnl_center.add(button_8);
		
		JLabel label = new JLabel("");
		pnl_center.add(label);
		
		JButton button_9 = new JButton("0");
		pnl_center.add(button_9);
		
		JPanel pnl_north = new JPanel();
		frame.getContentPane().add(pnl_north, BorderLayout.NORTH);
		pnl_north.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField = new JTextField();
		textField.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) { 
			}
		});
		textField.setFont(new Font("Dialog", Font.PLAIN, 28));
		pnl_north.add(textField);
		textField.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.SOUTH);
		
		JMenu mnMenu = new JMenu("Menu1");
		menuBar.add(mnMenu);
		
		JMenu nmMenu2 = new JMenu("Menu2");
		menuBar.add(nmMenu2);
	}
	
	
}
