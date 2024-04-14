package votacions;

import javax.swing.JOptionPane;

import votacions.controlador.*;

/**
 * La col·lecció escollida per a tot el projecte, es a dir, per les diferents parts del projecte es ArrayList. L'he per la seva simplicitat i per la seva eficiència.
 * És la més adient perque permet afegir, eliminar i modificar elements de manera molt senzilla. El més important es que permet accedir a  qualsevol element de la 
 * col·lecció de manera molt ràpida. Llavors això es molt útil per iterar sobre els elements de la col·lecció.
 */

public class Main {

	public static void main(String[] args) {
	    try {
	        IniciController iniciController = new IniciController();
	        iniciController.mostrar();
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Posa't en contacte amb l'administrador", "Error Fatal", JOptionPane.ERROR_MESSAGE);
		}
	}
}
