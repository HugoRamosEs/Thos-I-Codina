import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class IconFrame extends JFrame {
	JButton load, save, subscribe, unsubscribe;

	public IconFrame() {
		
		super("Icon Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();

		ImageIcon loadIcon = new ImageIcon("img/load.gif");
		ImageIcon saveIcon = new ImageIcon("img/save.gif");
		ImageIcon subscribeIcon = new ImageIcon("img/subscribe.gif");
		ImageIcon unsubscribeIcon = new ImageIcon("img/unsubscribe.gif");

		load = new JButton("Load", loadIcon);
		save = new JButton("Save", saveIcon);
		subscribe = new JButton("Subscribe", subscribeIcon);
		unsubscribe = new JButton("Unsubscribe", unsubscribeIcon);
	
		panel.add(load);
		panel.add(save);
		panel.add(subscribe);
		panel.add(unsubscribe);
	
		add(panel);
		
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new IconFrame();
			}
		});
	}
}
