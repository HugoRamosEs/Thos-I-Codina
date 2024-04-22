package chat;

import javax.swing.JOptionPane;

import chat.vista.*;

public class Main {

	public static void main(String[] args) {
		try {
			ChatView cv = new ChatView();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error fatal, posa't en contacte amb l'administrador.", "Error fatal", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
