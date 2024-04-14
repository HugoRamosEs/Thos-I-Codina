package votacions.model;

import java.util.Collection;

import javax.swing.JOptionPane;

public abstract class Model {
	
	public static void imprimirPerConsola(Collection<?> col) {
		try {
			if (col == null) {
				throw new IllegalArgumentException("La col·lecció no pot estar buida");
			}

			System.out.println("Tamany: " + col.size());
			for (Object obj : col) {
				System.out.println(obj);
			}
		} catch (IllegalArgumentException ie) {
	        JOptionPane.showMessageDialog(null, "Error d'argument: " + ie.getMessage(), "Error amb Model", JOptionPane.ERROR_MESSAGE);
	    }
	}
}
