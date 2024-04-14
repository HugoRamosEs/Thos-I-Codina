package votacions.controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import votacions.model.MunicipiModel;
import votacions.model.objectes.Municipi;
import votacions.vista.MunicipiView;
import votacions.vista.PrincipalView;

public class MunicipiController {
	
	public static void llistarMunicipis(PrincipalView principalView) {
		try {
            MunicipiModel municipiModel = new MunicipiModel();
            ArrayList<Municipi> municipis = municipiModel.obtenirMunicipis();
            principalView.dispose();
            MunicipiView municipiView = new MunicipiView(municipis);
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(principalView, "Error al mostrar la vista de municipis.", "Error amb MunicipiController", JOptionPane.ERROR_MESSAGE);
        }
    }
}
