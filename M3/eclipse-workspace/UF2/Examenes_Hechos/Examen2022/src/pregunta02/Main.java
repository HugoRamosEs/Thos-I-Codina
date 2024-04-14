package pregunta02;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		try {
			Operacions.transferir("ES001234", "ES014321", 322.42);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido transferir." + e.getMessage(), "Error de conexió", JOptionPane.ERROR_MESSAGE); 
		}
	}

}
