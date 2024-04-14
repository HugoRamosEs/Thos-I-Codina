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

public class Main implements ActionListener {

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
						Main window;
						window = new Main();
						window.frame.setVisible(true);
					} catch (FontFormatException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error FontFormatException", JOptionPane.ERROR_MESSAGE);
					} catch (SAXException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error SAXException", JOptionPane.ERROR_MESSAGE);
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error IOException", JOptionPane.ERROR_MESSAGE);
					}
			}
		});
	}

	public Main() throws FontFormatException, IOException, SAXException{
	        this.milis = 0;
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
		
	    Font buttonFont = new Font("Chilanka", Font.ITALIC | Font.BOLD, 25);
		
		btnStartStop = new JButton("Start");
		btnStartStop.setFont(buttonFont);
		btnStartStop.addActionListener(this);
//		btnStartStop.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if (btnStartStop.getText().equals("Start")) {
//					btnStartStop.setText("Stop");
//					btnReset.setVisible(false);
//					timer.start();
//				} else {
//					btnStartStop.setText("Start");
//					btnReset.setVisible(true);
//					timer.stop();
//				}
//			}
//		});
		pnlSouth.add(btnStartStop);
		
		btnReset = new JButton("Reset");
		btnReset.setFont(buttonFont);
		btnReset.addActionListener(this);
//		btnReset.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				milis=0;
//				textField.setText("00:00:000");
//			}
//		});
		pnlSouth.add(btnReset);
		
		JPanel pnlCenter = new JPanel();
		frame.getContentPane().add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
 		textField = new JTextField();
 		textField.setHorizontalAlignment(JTextField.CENTER);
 		textField.setAlignmentY(Component.CENTER_ALIGNMENT);
		textField.setEditable(false);
		textField.setText("00:00:000");
		textField.setColumns(9);
		
		File fileFont = new File("src/fonts/CursedTimerULiL.ttf");
		if (fileFont.exists()) {
			textField.setFont(new Font("src/fonts/CursedTimerULiL.ttf", Font.PLAIN, 40));
		} else {
			textField.setFont(new Font("Ani", Font.ITALIC, 40));
		}		
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton boton = (JButton) e.getSource();
		String btnNombre = boton.getText();
		
		if (btnNombre.equals("Reset")) {
			milis=0;
			textField.setText("00:00:000");
		} else if (btnNombre.equals("Start")) {
			btnStartStop.setText("Stop");
			btnReset.setVisible(false);
			timer.start();
		} else if (btnNombre.equals("Stop")) {
			btnStartStop.setText("Start");
			btnReset.setVisible(true);
			timer.stop();
		}
	}
	
	

}

//private void initialize() throws FontFormatException, IOException {
//    frame = new JFrame();
//    frame.setBounds(100, 100, 450, 300);
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    frame.getContentPane().setLayout(new BorderLayout(0, 0));
//
//    JPanel pnlSouth = new JPanel();
//    frame.getContentPane().add(pnlSouth, BorderLayout.SOUTH);
//    pnlSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//
//    btnStartStop = new JButton("Start");
//    btnStartStop.addMouseListener(new MouseAdapter() {
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            if (btnStartStop.getText().equals("Start")) {
//                btnStartStop.setText("Stop");
//                btnReset.setVisible(false);
//                timer.start();
//            } else {
//                btnStartStop.setText("Start");
//                btnReset.setVisible(true);
//                timer.stop();
//            }
//        }
//    });
//    pnlSouth.add(btnStartStop);
//
//    btnReset = new JButton("Reset");
//    btnReset.addMouseListener(new MouseAdapter() {
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            milis = 0;
//            textField.setText("00:00:000");
//        }
//    });
//    pnlSouth.add(btnReset);
//
//    JPanel pnlCenter = new JPanel();
//    frame.getContentPane().add(pnlCenter, BorderLayout.CENTER);
//
//    // Usar BoxLayout para centrar verticalmente el componente
//    pnlCenter.setLayout(new BoxLayout(pnlCenter, BoxLayout.Y_AXIS));
//
//    textField = new JTextField();
//    textField.setHorizontalAlignment(JTextField.CENTER);
//    textField.setEditable(false);
//    textField.setText("00:00:000");
//    textField.setColumns(9);
//
//    // Añadir un espacio en blanco para centrar verticalmente
//    pnlCenter.add(Box.createVerticalGlue());
//    pnlCenter.add(textField);
//    pnlCenter.add(Box.createVerticalGlue());
//
//    this.timer = new javax.swing.Timer(1, new java.awt.event.ActionListener() {
//        @Override
//        public void actionPerformed(java.awt.event.ActionEvent ae) {
//            milis++;
//            textField.setText(convertir(milis));
//        }
//    });
//}
