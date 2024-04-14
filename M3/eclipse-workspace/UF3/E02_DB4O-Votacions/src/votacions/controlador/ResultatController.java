package votacions.controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import votacions.model.CSVModel;
import votacions.model.ComarcaModel;
import votacions.model.MunicipiModel;
import votacions.model.PartitModel;
import votacions.model.ProvinciaModel;
import votacions.model.ResultatModel;
import votacions.model.objectes.Municipi;
import votacions.model.objectes.Resultat;
import votacions.vista.*;
import votacions.vista.components.SeleccionarComarcaOProvincia;
import votacions.vista.components.SeleccionarFitxer;
import votacions.vista.components.SeleccionarMunicipi;
import votacions.vista.components.SeleccionarPartit;

public class ResultatController {
	
	public static void llistarResultatsPerPartitEnUnMunicipi(PrincipalView principalView) {
        try {
        	MunicipiModel municipiModel = new MunicipiModel();
		    SeleccionarMunicipi selMun = new SeleccionarMunicipi(principalView, municipiModel.obtenirMunicipis());
		    selMun.setVisible(true);
		    String munNom = selMun.getMunicipi();
		    selMun.dispose();
		    if (!munNom.isEmpty() && munNom != null) {
	            ResultatModel resultatModel = new ResultatModel();
	            ArrayList<Resultat> resultats = resultatModel.obtenirResultatsPerPartitEnUnMunicipi(munNom);
	            principalView.dispose();
	            ResultatView resultatView = new ResultatView(resultats);
		    }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(principalView, "Error al mostrar la vista de resultats.", "Error amb ResultatController", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	public static void llistarResultatsPerMunicipiAmbUnPartit(PrincipalView principalView) {
		try {
			PartitModel partitModel = new PartitModel();
		    SeleccionarPartit selPar = new SeleccionarPartit(principalView, partitModel.obtenirPartits());
		    selPar.setVisible(true);
		    String parNom = selPar.getPartit();
		    selPar.dispose();
		    if (!parNom.isEmpty() && parNom != null) {
		    	ResultatModel resultatModel = new ResultatModel();
				ArrayList<Resultat> resultats = resultatModel.obtenirResultatsPerMunicipiAmbUnPartit(parNom);
				principalView.dispose();
				ResultatView resultatView = new ResultatView(resultats);
		    }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(principalView, "Error al mostrar la vista de resultats.", "Error amb ResultatController", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void llistarResultatsPerPartitOMunicipi(PrincipalView principalView) {
		try {
			ComarcaModel comarcaModel = new ComarcaModel();
			ProvinciaModel provinciaModel = new ProvinciaModel();
			SeleccionarComarcaOProvincia selCom = new SeleccionarComarcaOProvincia(principalView, comarcaModel.obtenirComarques(), provinciaModel.obtenirProvincies());
			selCom.setVisible(true);
			String nom = selCom.getSeleccionat();
			if (nom != null && !nom.isEmpty()) {
				ResultatModel resultatModel = new ResultatModel();
				ArrayList<Resultat> resultats = resultatModel.obtenirResultatsPerComarcaOProvincia(nom);
				principalView.dispose();
				ResultatView resultatView = new ResultatView(resultats);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(principalView, "Error al mostrar la vista de resultats.", "Error amb ResultatController", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void mostrarActualitzarResultat(PrincipalView principalView) {
		try {
			MunicipiModel municipiModel = new MunicipiModel();
			ArrayList<Municipi> municipis = municipiModel.obtenirMunicipis();
			principalView.dispose();
			ActualitzarResultatView actualitzarResultatView = new ActualitzarResultatView(new ArrayList<Resultat>(), municipis);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(principalView, "Error al mostrar la vista de resultats.", "Error amb ResultatController", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void llistarResultatsActualitzats(ActualitzarResultatView actualitzarResultatView) {
		try {
			SeleccionarFitxer sf_1 = new SeleccionarFitxer(actualitzarResultatView);
	        sf_1.setVisible(true);
	        String ruta = sf_1.getRuta();
	        String munNom = actualitzarResultatView.getMunNom();
	        
	        if (!ruta.isEmpty() && munNom != null) {
	        	MunicipiModel municipiModel = new MunicipiModel();
				ArrayList<Municipi> municipis = municipiModel.obtenirMunicipis();
				ResultatModel resultatModel = new ResultatModel();
				CSVModel csvModel = new CSVModel();
				boolean actualizada = csvModel.actualitzarBaseDeDades(ruta, munNom);
				if (actualizada) {
					ArrayList<Resultat> resultatsActualitzats = resultatModel.obtenirResultatsPerPartitEnUnMunicipi(munNom);
					JOptionPane.showMessageDialog(actualitzarResultatView, "Base de dades actualitzada !!!", "CSV", JOptionPane.INFORMATION_MESSAGE);
					actualitzarResultatView.dispose();
					ActualitzarResultatView actualitzarResultatView2 = new ActualitzarResultatView(resultatsActualitzats, municipis);
				} else {
					JOptionPane.showMessageDialog(actualitzarResultatView, "No s'ha pogut actualitzar la base de dades, degut a que els municipis son diferents", "Error amb CSV", JOptionPane.ERROR_MESSAGE);
				}
	        }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(actualitzarResultatView, "Error al mostrar la vista de resultats actualitzats.", "Error amb ResultatController", JOptionPane.ERROR_MESSAGE);
		}
	}
}
