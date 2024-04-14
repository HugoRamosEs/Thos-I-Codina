package cat.iesthosicodina;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Component;

public class AboutWindow {

	private JFrame frmAboutThosBlackjac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutWindow window = new AboutWindow();
					window.frmAboutThosBlackjac.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AboutWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	    int height = pantalla.height;
	    int width = pantalla.width;
	    		
		frmAboutThosBlackjac = new JFrame();
		frmAboutThosBlackjac.setIconImage(Toolkit.getDefaultToolkit().getImage(AboutWindow.class.getResource("/cat/iesthosicodina/img/logo.png")));
		frmAboutThosBlackjac.setTitle("About Thos BlackJac");
		//frmAboutThosBlackjac.setBounds(100, 100, 900 , 600);
		frmAboutThosBlackjac.setSize(new Dimension(width-500, height-200 ));
		frmAboutThosBlackjac.setLocationRelativeTo(null);
		frmAboutThosBlackjac.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAboutThosBlackjac.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(new GridLayout(8,0,0,0));
		frmAboutThosBlackjac.getContentPane().add(pnlCenter, BorderLayout.CENTER);
		
		JLabel lblLinia1 = new JLabel("BlackJack for Thos i Codina students (includes Incubating components)");
		JLabel lblLinia2 = new JLabel("Version: 2023-02 (4.25.0)");
		JLabel lblLinia3 = new JLabel("Build id: 20220908-1902");
				
		JTextArea txtLinia5 = new JTextArea("(c) Copyright Toni Aguilar contributors and others 2000, 2022. \n"
				+ "All rights reserved. Thos logo is trademarks of the Thos i Codina, Ins., ");
		txtLinia5.setBackground(new Color(238,238,238));
		JTextArea txtLinia6 = new JTextArea("https://www.eclipse.org/. The Eclipse logo cannot be altered without my permission. ");
		txtLinia6.setBackground(new Color(238,238,238));
		JTextArea txtLinia7 = new JTextArea("Eclipse logos are provided for use under the Eclipse logo and trademark guidelines, \n"
				+ "https://www.eclipse.org/logotm/. Oracle and Java are trademarks or registered \n"
				+ "trademarks of Oracle and/or its affiliates. Other names may be trademarks \n");
		txtLinia7.setBackground(new Color(238,238,238));
		JTextArea txtLinia8 = new JTextArea("of their respective owners.");
		txtLinia8.setBackground(new Color(238,238,238));
		JTextArea txtLinia9 = new JTextArea("This product includes software developed by other open source projects including the \n"
				+ "Apache Software Foundation, https://www.apache.org/.");
		txtLinia9.setBackground(new Color(238,238,238));
				
		pnlCenter.add(lblLinia1);
		pnlCenter.add(lblLinia2);
		pnlCenter.add(lblLinia3);		
		pnlCenter.add(txtLinia5);
		//pnlCenter.add(new JLabel(""));
		pnlCenter.add(txtLinia6);
		//pnlCenter.add(new JLabel(""));
		pnlCenter.add(txtLinia7);
		pnlCenter.add(txtLinia8);
		pnlCenter.add(txtLinia9);
		
		JPanel pnlWest = new JPanel();
		frmAboutThosBlackjac.getContentPane().add(pnlWest, BorderLayout.WEST);
		
		JLabel lblImatge = new JLabel(new ImageIcon(AboutWindow.class.getResource("/cat/iesthosicodina/img/thos.png")));		
		pnlWest.add(lblImatge);
		

		JPanel pnlSouth = new JPanel();
		pnlSouth.setLayout(new GridLayout(2,0,5,5));
		frmAboutThosBlackjac.getContentPane().add(pnlSouth, BorderLayout.SOUTH);
		
		JPanel pnlLinia_1 = new JPanel();
		pnlLinia_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		pnlLinia_1.setLayout(new FlowLayout());
		
		JLabel lblLogo_1 = new JLabel(new ImageIcon(AboutWindow.class.getResource("/cat/iesthosicodina/img/logo_p.png")));		
		pnlLinia_1.add(lblLogo_1);
		JLabel lblLogo_2 = new JLabel(new ImageIcon(AboutWindow.class.getResource("/cat/iesthosicodina/img/gene.png")));		
		pnlLinia_1.add(lblLogo_2);
		JLabel lblLogo_3 = new JLabel(new ImageIcon(AboutWindow.class.getResource("/cat/iesthosicodina/img/mataró.jpg")));		
		pnlLinia_1.add(lblLogo_3);
		
		pnlSouth.add(pnlLinia_1);
		
		JPanel pnlLinia_3 = new JPanel();
		pnlLinia_3.setLayout(new GridLayout(0,4,25,25));
		pnlLinia_3.add(new JLabel(""));
		pnlLinia_3.add(new JLabel(""));
		pnlLinia_3.add(new JLabel(""));
		
		JButton btnNewButton = new JButton("Close");		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAboutThosBlackjac.dispose();
			}
		});
		pnlLinia_3.add(btnNewButton);
		pnlSouth.add(pnlLinia_3);
	}
	
	public JFrame getFrame() {
		return this.frmAboutThosBlackjac;
	}

}
