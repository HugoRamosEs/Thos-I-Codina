package pregunta08;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Finestra extends JFrame implements ActionListener {
	private JButton btn_1;
	private JButton btn_2;
	private JButton btn_3;
	private JPanel pnl_1;
	
	public Finestra() throws HeadlessException {
		super();
		this.setBounds(100, 100, 300, 200);
		
		this.btn_1 = new JButton("1");
		this.btn_2 = new JButton("2");
		this.btn_3 = new JButton("4");
		this.pnl_1 = new JPanel();
		this.getContentPane().add(pnl_1, BorderLayout.NORTH);
		
		this.pnl_1.add(btn_1);
		this.pnl_1.add(btn_2);
		this.pnl_1.add(btn_3);
		
		this.btn_1.addActionListener(this);
		this.btn_2.addActionListener(this);
		this.btn_3.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btn_1) {
            this.setTitle("1");
        } else if (arg0.getSource() == btn_2) {
        	this.setTitle("2");
        } else if (arg0.getSource() == btn_3) {
        	this.setTitle("3");
        }
	}
}
