package pregunta02;

import javax.swing.JOptionPane;

import pregunta01.CustomCheckedException;

public class Main {

	public static void main(String[] args) throws Exception {
		// Operacions.transferir("ES001234", "ES014321", 322.42);
		
		try {
			Operacions.transferir("ES001234", "ES014321", 322.42);
		}catch (CustomCheckedException cce){
			JOptionPane.showMessageDialog(null, cce.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE); 
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Posa't en contacte amb l'administrador", "ERROR FATAL", JOptionPane.ERROR_MESSAGE); 
		}
	}
}
