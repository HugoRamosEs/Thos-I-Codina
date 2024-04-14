import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutDemo extends JFrame {

	private JButton buttons[];
	private String names[] = { "Hide North", "Hide South", "Hide East",
			"Hide West", "Hide Center" };

	public BorderLayoutDemo() {
		
		super("BorderLayout Demo");

		BorderLayout layout = new BorderLayout(5, 5);

		Container container = getContentPane();
		container.setLayout(layout);

		buttons = new JButton[names.length];

		for (int count = 0; count < names.length; count++) {
			buttons[count] = new JButton(names[count]);
			buttons[count].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {
					for (int count = 0; count < buttons.length; count++)

						if (event.getSource() == buttons[count])
							buttons[count].setVisible(false);
						else
							buttons[count].setVisible(true);

					getContentPane().doLayout();
					// getContentPane().validate();
				}
			});

		}

		container.add(buttons[0], BorderLayout.NORTH);
		container.add(buttons[1], BorderLayout.SOUTH);
		container.add(buttons[2], BorderLayout.EAST);
		container.add(buttons[3], BorderLayout.WEST);
		container.add(buttons[4], BorderLayout.CENTER);

		setSize(300, 200);
		setVisible(true);
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new BorderLayoutDemo();
			}
		});
	}

}
