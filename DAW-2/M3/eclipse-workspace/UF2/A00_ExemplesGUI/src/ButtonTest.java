import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ButtonTest extends JFrame {

	private JButton plainButton, fancyButton;

	
	public ButtonTest() {
		
		super("Testing Buttons");

		Icon icon1 = new ImageIcon("img/button.png");
		Icon icon2 = new ImageIcon("img/button-disabled-selected.png");
		Icon icon3 = new ImageIcon("img/button-disabled.png");
		Icon icon4 = new ImageIcon("img/button-down.png");
		Icon icon5 = new ImageIcon("img/button-over.png");
		Icon icon6 = new ImageIcon("img/button-sel-over.png");
		Icon icon7 = new ImageIcon("img/button-sel.png");

		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		plainButton = new JButton("Plain Button");
		container.add(plainButton);
		
		fancyButton = new JButton(icon1);
		fancyButton.setPreferredSize(new Dimension(icon1.getIconWidth(),icon1.getIconHeight()));
		fancyButton.setDisabledIcon(icon3);
		fancyButton.setSelectedIcon(icon7);
		fancyButton.setPressedIcon(icon4);
		fancyButton.setRolloverIcon(icon5);
		fancyButton.setActionCommand("Graphic Button");
		fancyButton.setBorderPainted(false);
		
		
		container.add(fancyButton);
		
		fancyButton.addActionListener(new ButtonHandler());
		plainButton.addActionListener(new ButtonHandler());
		
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ButtonTest();
			}
		});
	}

	//Nested class
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(null,
					"You pressed: " + event.getActionCommand());
		}
	} 

} 
