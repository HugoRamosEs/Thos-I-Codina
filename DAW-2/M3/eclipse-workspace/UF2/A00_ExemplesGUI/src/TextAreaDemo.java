// Fig. 13.1: TextAreaDemo.java
// Copying selected text from one text area to another. 

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class TextAreaDemo extends JFrame {
   private JTextArea textArea1, textArea2;
   private JButton copyButton;

   // set up GUI
   public TextAreaDemo() 
   {
      super( "TextArea Demo" );

      Box box = Box.createHorizontalBox();

      String string = "This is a demo string to\n" +
         "illustrate copying text\n" +
         "from one TextArea to \n" +
         "another TextArea using an\n" + "external event\n";

      // set up textArea1
      textArea1 = new JTextArea( string, 10, 15 );
      box.add( new JScrollPane( textArea1 ) );

      // set up copyButton
      copyButton = new JButton( "Copy >>>" );
      copyButton.addActionListener(

         // anonymous inner class to handle copyButton event
         new ActionListener() {

            // set text in textArea2 to selected 
            // text from textArea1
            public void actionPerformed( ActionEvent event )
            {
               textArea2.setText( textArea1.getSelectedText() );
            }

         }  // end anonymous inner class
 
      ); // end call to addActionListener

      box.add( copyButton );

      // set up textArea2
      textArea2 = new JTextArea( 10, 15 );
      textArea2.setEditable( false );
      box.add( new JScrollPane( textArea2 ) );

      // add box to content pane
      Container container = getContentPane();
      container.add( box );   // place in BorderLayout.CENTER

      setSize( 425, 200 );
      setVisible( true );
   }

   // execute application
   public static void main( String args[] )
   {
      TextAreaDemo application = new TextAreaDemo();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

}  // end class TextAreaDemo

/**************************************************************************
 * (C) Copyright 2002 by Deitel & Associates, Inc. and Prentice Hall.     *
 * All Rights Reserved.                                                   *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
