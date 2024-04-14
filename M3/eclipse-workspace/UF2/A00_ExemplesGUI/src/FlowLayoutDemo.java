// Fig. 12.24: FlowLayoutDemo.java
// Demonstrating FlowLayout alignments.

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class FlowLayoutDemo extends JFrame {

	public FlowLayoutDemo() {
		
		super("FlowLayout Demo");
		
		final FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.CENTER);
		
		final Container container = getContentPane();
		container.setLayout(layout);
		
		JButton leftButton = new JButton("Left");
		leftButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				layout.setAlignment(FlowLayout.LEFT);
				container.doLayout();
			}
		});
		container.add(leftButton);

		JButton centerButton = new JButton("Center");
		centerButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				layout.setAlignment(FlowLayout.CENTER);
				container.doLayout();
			}
		});
		container.add(centerButton);

		JButton rightButton = new JButton("Right");
		rightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				layout.setAlignment(FlowLayout.RIGHT);
				container.doLayout();
			}
		});
		container.add(rightButton);
	
		setSize(300, 75);
		setVisible(true);
	}

	public static void main (String [] args){
        EventQueue.invokeLater ( new Runnable (){
            public void run (){
                new FlowLayoutDemo();
        }});
    }

}
