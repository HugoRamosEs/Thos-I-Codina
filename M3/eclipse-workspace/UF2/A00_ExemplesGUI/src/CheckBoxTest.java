// Fig. 12.11: CheckBoxTest.java
// Creating Checkbox buttons.

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class CheckBoxTest extends JFrame {

	private JTextField field;
	private JCheckBox bold, italic;

	public CheckBoxTest() {

		super("JCheckBox Test");

		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		field = new JTextField("Watch the font style change", 20);
		field.setFont(new Font("Serif", Font.PLAIN, 14));
		container.add(field);

		bold = new JCheckBox("Bold");
		container.add(bold);

		italic = new JCheckBox("Italic");
		container.add(italic);

		CheckBoxHandler handler = new CheckBoxHandler();
		bold.addItemListener(handler);
		italic.addItemListener(handler);

		setSize(275, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CheckBoxTest();
			}
		});
	}

	//Nested class
	private class CheckBoxHandler implements ItemListener {

		public void itemStateChanged(ItemEvent event) {

			int style = Font.PLAIN;

			if (bold.isSelected())
				style = style | Font.BOLD;
			if (italic.isSelected())
				style = style | Font.ITALIC;

			field.setFont(new Font("Serif", style, 14));
		}
	}

}