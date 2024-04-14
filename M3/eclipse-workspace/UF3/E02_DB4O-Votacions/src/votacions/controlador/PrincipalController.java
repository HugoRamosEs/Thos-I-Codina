package votacions.controlador;

import javax.swing.JOptionPane;

import votacions.vista.*;

public class PrincipalController {

	public static void tornar(View view) {
		try {
			view.dispose();
			PrincipalView principalView = new PrincipalView();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(view, "Error al mostrar la vista principal.", "Error amb PrincipalController", JOptionPane.ERROR_MESSAGE);
		}
	}
}
