import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RadioButtonTest extends JFrame {

	private JTextField field;
	private Font plainFont, boldFont, italicFont, boldItalicFont;
	private JRadioButton plainButton, boldButton, italicButton,
			boldItalicButton;
	private ButtonGroup radioGroup;

	public RadioButtonTest() {

		super("RadioButton Test");

		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		field = new JTextField("Watch the font style change", 25);
		container.add(field);

		plainButton = new JRadioButton("Plain", true);
		container.add(plainButton);

		boldButton = new JRadioButton("Bold", false);
		container.add(boldButton);

		italicButton = new JRadioButton("Italic", false);
		container.add(italicButton);

		boldItalicButton = new JRadioButton("Bold/Italic", false);
		container.add(boldItalicButton);

		RadioButtonHandler handler = new RadioButtonHandler();
		plainButton.addItemListener(handler);
		boldButton.addItemListener(handler);
		italicButton.addItemListener(handler);
		boldItalicButton.addItemListener(handler);

		radioGroup = new ButtonGroup();
		radioGroup.add(plainButton);
		radioGroup.add(boldButton);
		radioGroup.add(italicButton);
		radioGroup.add(boldItalicButton);

		plainFont = new Font("Serif", Font.PLAIN, 14);
		boldFont = new Font("Serif", Font.BOLD, 14);
		italicFont = new Font("Serif", Font.ITALIC, 14);
		boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
		field.setFont(plainFont);

		setSize(300, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new RadioButtonTest();
			}
		});
	}

	private class RadioButtonHandler implements ItemListener {

		public void itemStateChanged(ItemEvent event) {

			if (event.getSource() == plainButton)
				field.setFont(plainFont);
			else if (event.getSource() == boldButton)
				field.setFont(boldFont);
			else if (event.getSource() == italicButton)
				field.setFont(italicFont);
			else if (event.getSource() == boldItalicButton)
				field.setFont(boldItalicFont);
		}

	}

}