package angle;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/nimbus.html
 */
public class LandF {

	public static void main(String[] args) {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		    	System.out.println(info.getClassName());
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		
		}catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
			JOptionPane.showMessageDialog(null, "No es pot carregar numbus L&F", "Caption", JOptionPane.ERROR_MESSAGE);
		}

	}

}
