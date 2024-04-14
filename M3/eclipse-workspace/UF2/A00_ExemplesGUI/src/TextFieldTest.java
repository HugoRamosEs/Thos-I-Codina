import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TextFieldTest extends JFrame {

	private JTextField textField1, textField2, textField3;
	private JPasswordField passwordField;

	public TextFieldTest() {
		super("Testing JTextField and JPasswordField");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		textField1 = new JTextField(10);
		container.add(textField1);

		textField2 = new JTextField("Enter text here");
		container.add(textField2);

		textField3 = new JTextField("Uneditable text field", 20);
		textField3.setEditable(false);
		container.add(textField3);

		passwordField = new JPasswordField("Hidden text");
		container.add(passwordField);

		TextFieldHandler handler = new TextFieldHandler();
		textField1.addActionListener(handler);
		textField2.addActionListener(handler);
		textField3.addActionListener(handler);
		passwordField.addActionListener(handler);

		setSize(325, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TextFieldTest();
			}
		});
	}

	private class TextFieldHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			String string = "";

			if (event.getSource() == textField1) {
				string = "textField1: " + event.getActionCommand();
			} else if (event.getSource() == textField2) {
				string = "textField2: " + event.getActionCommand();
			} else if (event.getSource() == textField3) {
				string = "textField3: " + event.getActionCommand();
			} else if (event.getSource() == passwordField) {
				JPasswordField pwd = (JPasswordField) event.getSource();
				string = "passwordField: "
						+ new String(passwordField.getPassword());
			}

			JOptionPane.showMessageDialog(null, string);
		}
	}
}
