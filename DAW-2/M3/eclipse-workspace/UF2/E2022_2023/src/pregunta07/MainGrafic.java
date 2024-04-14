package pregunta07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainGrafic {

	private JFrame frmPregunta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGrafic window = new MainGrafic();
					window.frmPregunta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGrafic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	    frmPregunta = new JFrame();
	    frmPregunta.setTitle("Pregunta08");
	    frmPregunta.setBackground(Color.GRAY);
	    frmPregunta.setBounds(100, 100, 450, 300);
	    frmPregunta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel panel = new JPanel();
	    frmPregunta.getContentPane().add(panel, BorderLayout.CENTER);
	    panel.setLayout(new GridLayout(1, 0, 0, 0));
	    
	    JPanel panel_1 = new JPanel();
	    frmPregunta.getContentPane().add(panel_1, BorderLayout.NORTH);
	    
	    JButton btnBlue = new JButton("BLUE");
	    panel_1.add(btnBlue);
	    
	    JButton btnRed = new JButton("RED");
	    panel_1.add(btnRed);
	    
	    JPanel panel_2 = new JPanel();
	    frmPregunta.getContentPane().add(panel_2, BorderLayout.SOUTH);
	    
	    JButton btnJ = new JButton("J1");
	    btnJ.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		frmPregunta.setTitle("1");
	    	}
	    });
	    panel_2.add(btnJ);
	    
	    JButton btnJ_1 = new JButton("J2");
	    btnJ_1.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		frmPregunta.setTitle("2");
	    	}
	    });
	    panel_2.add(btnJ_1);
	    
	    JButton btnJ_2 = new JButton("J3");
	    btnJ_2.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		frmPregunta.setTitle("3");
	    	}
	    });
	    panel_2.add(btnJ_2);
	    btnRed.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	        	panel.setBackground(Color.RED);
	        	panel_1.setBackground(Color.RED);
	        	panel_2.setBackground(Color.RED);
	        }
	    });
	    btnBlue.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	        	panel.setBackground(Color.BLUE);
	        	panel_1.setBackground(Color.BLUE);
	        	panel_2.setBackground(Color.BLUE);
	        }
	    });
	    
	    frmPregunta.setVisible(true);
	}
}
