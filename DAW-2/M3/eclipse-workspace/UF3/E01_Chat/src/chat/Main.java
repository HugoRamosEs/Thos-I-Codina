package chat;

import javax.swing.JOptionPane;

import chat.vista.*;

/**
 * Classe principal de l'aplicació.
 * 
 * @version 1.0
 * @author Hugo
 */
public class Main {
	/**
	 * Mètode principal del programa. Crea una instancia de la vista del xat.
	 * 
	 * @param args Arguments del programa.
	 */
	public static void main(String[] args) {
		try {
			ChatView cv = new ChatView();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error fatal, posa't en contacte amb l'administrador.", "Error fatal", JOptionPane.ERROR_MESSAGE);
		}
	}
}
