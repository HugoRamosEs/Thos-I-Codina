package votacions.controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import votacions.model.*;
import votacions.model.objectes.*;
import votacions.vista.PartitView;
import votacions.vista.PrincipalView;

public class PartitController {

	public static void llistarPartits(PrincipalView principalView) {
		try {
            PartitModel partitModel = new PartitModel();
            ArrayList<Partit> partits = partitModel.obtenirPartits();
            principalView.dispose();
            PartitView partitView = new PartitView(partits);
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(principalView, "Error al mostrar la vista de partits.", "Error amb PartitController", JOptionPane.ERROR_MESSAGE);
        }
    }
}
