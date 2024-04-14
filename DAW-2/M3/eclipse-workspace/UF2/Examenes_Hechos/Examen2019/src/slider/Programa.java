package slider;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Programa {

	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			Imageslider obj = new Imageslider();
		} catch (MyException e) {
			// Captura l'excepció i mostra un missatge d'error
			JOptionPane.showMessageDialog(null, "MyException: " + e.getMessage() + " (Code: " + e.getCode() + ")");
		}
	}
}
