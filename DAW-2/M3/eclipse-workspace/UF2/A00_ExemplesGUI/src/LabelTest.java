import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelTest extends JFrame {
	
	
	public LabelTest() {
		super("Testing JLabel");

		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		JLabel label1 = new JLabel("Label with text");
		label1.setToolTipText("This is label1");
		container.add(label1);

		Icon bug = new ImageIcon("img/load.gif");
		JLabel label2 = new JLabel("Label with text and icon", bug,
				SwingConstants.LEFT);
		label2.setToolTipText("This is label2");
		container.add(label2);

		JLabel label3 = new JLabel();
		label3.setText("Label with icon and text at bottom");
		label3.setIcon(bug);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setToolTipText("This is label3");
		container.add(label3);

		setSize(275, 170);
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LabelTest();
			}
		});
	}

}
