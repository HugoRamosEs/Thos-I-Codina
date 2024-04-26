package chat.model;

import java.util.Collection;

import javax.swing.JOptionPane;

/**
 * Classe model que gestiona té mètodes estatics utils per altres classes model.
 * 
 * @version 1.0
 * @author Hugo
 */
public abstract class Model {
	
	/**
	 * Mètode que imprimeix una col·lecció a la consola.
	 * 
	 * @param col Col·lecció a imprimir.
	 * @param title Títol de la col·lecció.
	 * 
	 * @version 1.0
	 * @author Hugo
	 */
	public static void printToConsole(Collection<?> col, String title) {
		try {
			if (col == null) {
				throw new IllegalArgumentException("La col·lecció no pot estar buida");
			}
			
			System.out.println("----------------\n" + title + " (" + col.size() + "):");
			for (Object obj : col) {
				System.out.println(" - " + obj);
			}
		} catch (IllegalArgumentException ie) {
			JOptionPane.showMessageDialog(null, "Error d'argument: " + ie.getMessage(), "Error amb Model", JOptionPane.ERROR_MESSAGE);
		}
	}
}
