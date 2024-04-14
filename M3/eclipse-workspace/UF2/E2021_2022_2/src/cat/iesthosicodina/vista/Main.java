package cat.iesthosicodina.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.Timer;

import org.xml.sax.SAXException;

import cat.iesthosicodina.controlador.CollectionManager;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

	private Timer timer;
	private long milis;
	private JFrame frame;
	private JTextField textField;
	private JButton btnStartStop;
	private JButton btnReset;

	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                Main window = new Main();
	                window.frame.setVisible(true);
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	    });
	}

	public Main() throws FontFormatException, IOException, SAXException {
		this.milis=0;
		initialize();
		
		CollectionManager cm = new CollectionManager();
		cm.getNews();
		System.out.println(cm.toString());
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	private void initialize() throws FontFormatException, IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlSouth = new JPanel();
		frame.getContentPane().add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnStartStop = new JButton("Start");
		btnStartStop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnStartStop.getText().equals("Start")) {
					btnStartStop.setText("Stop");
					btnReset.setVisible(false);
					timer.start();
				} else {
					btnStartStop.setText("Start");
					btnReset.setVisible(true);
					timer.stop();
				}
			}
		});
		pnlSouth.add(btnStartStop);
		
		btnReset = new JButton("Reset");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				milis=0;
				textField.setText("00:00:000");
			}
		});
		pnlSouth.add(btnReset);
		
		JPanel pnlCenter = new JPanel();
		frame.getContentPane().add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
 		textField = new JTextField();
 		textField.setHorizontalAlignment(JTextField.CENTER);
 		textField.setAlignmentY(JTextField.CENTER_ALIGNMENT);
		textField.setEditable(false);
		textField.setText("00:00:000");
		textField.setColumns(9);
		
		pnlCenter.add(textField);	
		
		this.timer = new javax.swing.Timer(1,
				new java.awt.event.ActionListener() {
					@Override
					public void actionPerformed(java.awt.event.ActionEvent ae) {
						milis++;
						textField.setText(convertir(milis));
					}
				});

	}
	
	public String convertir(long param) {
		int milisegons = (int)param%1000;
		int segons = (int)(param/1000)%60;
		int minuts = (int)(param/(60*1000))%60;
		return String.format("%02d",minuts)+":"+String.format("%02d", segons)+":"+String.format("%03d", milisegons);
	}
	
	

}
