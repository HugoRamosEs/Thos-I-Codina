import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderDemo extends JFrame {

	public SliderDemo() {

		super("Slider Demo");

		final OvalPanel myPanel;
		myPanel = new OvalPanel();
		Dimension dim = new Dimension(200, 200);
		myPanel.setPreferredSize(dim);
		myPanel.setBackground(Color.yellow);

		final JSlider diameterSlider;
		diameterSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 10);
		diameterSlider.setMajorTickSpacing(10);
		diameterSlider.setPaintTicks(true);

		diameterSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				myPanel.setDiameter(diameterSlider.getValue());
			}
		});

		Container container = getContentPane();
		container.add(diameterSlider, BorderLayout.SOUTH);
		container.add(myPanel, BorderLayout.CENTER);

		setSize(220, 270);
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new SliderDemo();
			}
		});
	}

	// Inner class
	class OvalPanel extends JPanel {

		private int diameter = 10;

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.fillOval(10, 10, diameter, diameter);
		}

		public void setDiameter(int newDiameter) {
			diameter = (newDiameter >= 0 ? newDiameter : 10);
			repaint();
		}
	}

}
