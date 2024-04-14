package votacions.controlador;

import java.io.File;

import javax.swing.JOptionPane;

import votacions.model.*;
import votacions.model.objectes.MiDb4o;
import votacions.vista.*;
import votacions.vista.components.SeleccionarFitxer;

public class IniciController {
    
    public void mostrar() {
    	try {
    		IniciView iniciView = new IniciView();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al mostrar la vista d'inici.", "Error amb IniciController", JOptionPane.ERROR_MESSAGE);
		} 
    }

    public static void generarBaseDeDades(IniciView iniciView) {
        try {
        	SeleccionarFitxer sf_1 = new SeleccionarFitxer(iniciView);
			sf_1.setVisible(true);
			String ruta = sf_1.getRuta();
			if (!ruta.isEmpty()) {
				MiDb4o.eliminarDb();
	            CSVModel csvModel = new CSVModel();
	            boolean generada = csvModel.generarBaseDeDades(ruta);
	            if (generada && iniciView != null) {
	            	JOptionPane.showMessageDialog(iniciView, "Base de dades generada !!!", "CSV", JOptionPane.INFORMATION_MESSAGE);
	            	iniciView.dispose();
	                PrincipalView principalView = new PrincipalView();
	            }
			}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(iniciView, "Error al mostrar la vista principal.", "Error amb IniciController", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void baseDeDadesExistent(IniciView iniciView) {
        try {
        	File db4o = new File(MiDb4o.getDb4oFile());
			if (db4o.exists()) {
				iniciView.dispose();
				PrincipalView principalView = new PrincipalView();
			} else {
				throw new Exception("No existeix cap base de dades.");
			}
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(iniciView, "Error al mostrar la vista principal. " + e.getMessage(), "Error amb IniciController", JOptionPane.ERROR_MESSAGE);
        }
    }
    
	public static void tornar(View view) {
		try {
			view.dispose();
			IniciView iniciView = new IniciView();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(view, "Error al mostrar la vista d'inici.", "Error amb IniciController", JOptionPane.ERROR_MESSAGE);
        }
	}
}
