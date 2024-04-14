import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListTest extends JFrame {

	private JList colorList;
	private Container container;

	private String colorNames[] = { "Black", "Blue", "Cyan", "Dark Gray",
			"Gray", "Green", "Light Gray", "Magenta", "Orange", "Pink", "Red",
			"White", "Yellow" };

	private Color colors[] = { Color.black, Color.blue, Color.cyan,
			Color.darkGray, Color.gray, Color.green, Color.lightGray,
			Color.magenta, Color.orange, Color.pink, Color.red, Color.white,
			Color.yellow };

	public ListTest() {

		super("List Test");

		container = getContentPane();
		container.setLayout(new FlowLayout());

		colorList = new JList(colorNames);
		colorList.setVisibleRowCount(5);

		colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		container.add(new JScrollPane(colorList));

		colorList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				container.setBackground(colors[colorList.getSelectedIndex()]);
			}
		});

		setSize(350, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ListTest();
			}
		});
	}

}