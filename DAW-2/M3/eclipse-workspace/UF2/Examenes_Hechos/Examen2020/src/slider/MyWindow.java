package slider;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyWindow extends JDialog{

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public MyWindow() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("cat.thosicodina/slider/imgs/thos.png"));
		contentPanel.add(lblLogo, BorderLayout.NORTH);

		JLabel lblMsg = new JLabel("Bona sort.... i tranquil que vas bé");
		contentPanel.add(lblMsg, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("Ins Thos i Codina");
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Riera de Cirera, 57 - 08304, Mataró");
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Telèfon: 937 414 203");
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("http://www.iesthosicodina.cat");
		panel.add(lblNewLabel_4);
		
		JButton salir = new JButton("Ok");
		panel.add(salir);
		salir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

	}

}
