// Fig. 12.26: GridLayoutDemo.java
// Demonstrating GridLayout.

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class GridLayoutDemo extends JFrame {

   public GridLayoutDemo()
   {
      super( "GridLayout Demo" );

      GridLayout grid = new GridLayout( 2, 3, 5, 5 );
      
      Container container = getContentPane();
      container.setLayout( grid );
      
      final JButton[][]  buttons = new JButton[2][3];

      for (int i=0; i<2; i++ ) {
         for(int j=0; j<3; j++){
        	 JButton btn = new JButton("Button " + (i*3+j));
        	 btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					JButton btn = (JButton)event.getSource();
					int row = 0;
					int col = 0;
					for (int i=0; i<2; i++ ) {
				         for(int j=0; j<3; j++){
				        	 if(buttons[i][j]==btn){
				        		 row = i;
				        		 col = j;
				        	 }
				         }
					}
					JOptionPane.showMessageDialog(GridLayoutDemo.this,
							"Click on: " + row + "," + col); 	
				}
			 });
        	 buttons[i][j] = btn;
        	 container.add( btn );
         }
      }

      setSize( 300, 150 );
      setVisible( true );
   }
   
   public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GridLayoutDemo();
			}
		});
	}
} 
