package pregunta1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class About extends JDialog {
	private JPanel pnl_cAbout;
	private JLabel lbl_1;
	
	public About() {
		this.pnl_cAbout = new JPanel();
		this.lbl_1 = new JLabel();
		this.init();
	}
	
	private void init() {
		this.setResizable(false);
		this.setBounds(100, 100, 300, 300);
		this.setTitle("About");
		
		this.pnl_cAbout.setBackground(new Color(245, 245, 245));
		this.pnl_cAbout.setBorder(new EmptyBorder(10, 10, 10, 10));
	    this.getContentPane().add(pnl_cAbout, BorderLayout.CENTER);
	    this.pnl_cAbout.setLayout(new GridLayout(1, 1, 0, 0));
	    
	    this.lbl_1.setText("Hugo Ramos, 6/02/2024");
	    this.lbl_1.setHorizontalAlignment(JLabel.CENTER);
	    this.lbl_1.setVerticalAlignment(JLabel.CENTER);
	    this.pnl_cAbout.add(lbl_1);
	    this.setVisible(true);
	}
}
