package pregunta4;

import java.io.IOException;

import javax.swing.JOptionPane;

public class ATM {

	public static void main(String[] args) throws IOException {
		try {
			OptionMenu optionMenu = new OptionMenu();
			introduction();
			optionMenu.mainMenu();
		}catch (IOException io){
			JOptionPane.showMessageDialog(null, io.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE); 
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Posa't en contacte amb l'administrador", "ERROR FATAL", JOptionPane.ERROR_MESSAGE); 
		}
	}

	public static void introduction() {
		System.out.println("Welcome to the ATM Project!");
	}
}