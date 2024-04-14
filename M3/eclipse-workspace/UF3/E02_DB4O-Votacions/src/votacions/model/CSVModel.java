package votacions.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import votacions.model.objectes.*;

public class CSVModel {
	private ProvinciaModel provinciaModel;
	private ComarcaModel comarcaModel;
	private MunicipiModel municipiModel;
	private PartitModel partitModel;
	private ResultatModel resultatModel;

	public CSVModel() {
		this.provinciaModel = new ProvinciaModel();
		this.comarcaModel = new ComarcaModel();
		this.municipiModel = new MunicipiModel();
		this.partitModel = new PartitModel();
		this.resultatModel = new ResultatModel();
	}

	public boolean generarBaseDeDades(String rutaCSV) {
	    boolean generada = false;
	    try {
	        if (!rutaCSV.endsWith(".csv")) {
	            JOptionPane.showMessageDialog(null, "El fitxer ha de ser un CSV.", "Error amb CSV", JOptionPane.ERROR_MESSAGE);
	            return false;
	        }

	        System.out.println("Generant base de dades...");
	        MiDb4o.getInstance();
	        BufferedReader br = new BufferedReader(new FileReader(rutaCSV));
	        
	        String linia;
	        boolean primeraLinia = true;

	        while ((linia = br.readLine()) != null) {
	            if (primeraLinia) {
	                primeraLinia = false;
	            } else {
	                String[] dades = linia.split(";");
	                String proNom = dades[0];
	                String comNom = dades[1];
	                String munNom = dades[2];
	                String parSigles = dades[3];
	                String parNom = dades[4];
	                String[] canvis = renombrarPartits(parNom, parSigles);
	                parNom = canvis[0];
	                parSigles = canvis[1];
	                int resVots = Integer.parseInt(dades[5].replace("-", "0"));
	                double resPercentatge = Double.parseDouble(dades[6].replace(",", ".").replace("-", "0"));

	                Provincia pro = new Provincia(proNom);
	                Comarca com = new Comarca(comNom, pro);
	                Municipi mun = new Municipi(munNom, com, pro);
	                Partit par = new Partit(parNom, parSigles);
	                Resultat res = new Resultat(resVots, resPercentatge, par, mun, com, pro);

	                this.provinciaModel.insertarProvincia(pro);
	                this.comarcaModel.insertarComarca(com);
	                this.municipiModel.insertarMunicipi(mun);
	                this.partitModel.insertarPartit(par);
	                this.resultatModel.insertarResultat(res);
	            }
	        }

	        br.close();
	        generada = true;
	    } catch (FileNotFoundException fnfe) {
	        JOptionPane.showMessageDialog(null, "Fitxer CSV no trobat.", "Error amb CSV", JOptionPane.ERROR_MESSAGE);
	    } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
	        JOptionPane.showMessageDialog(null, "El fitxer no és un CSV vàlid.", "Error amb CSV", JOptionPane.ERROR_MESSAGE);
	    } catch (IOException ioe) {
	        JOptionPane.showMessageDialog(null, "Error d'entrada/sortida.", "Error amb CSV", JOptionPane.ERROR_MESSAGE);
	    } catch (IllegalArgumentException iae) {
	        JOptionPane.showMessageDialog(null, iae.getMessage(), "Error amb CSV", JOptionPane.ERROR_MESSAGE);
	    } finally {
	        if (generada) {
	            System.out.println("Base de dades generada.");
	        }
	    }

	    return generada;
	}

	public boolean actualitzarBaseDeDades(String rutaCSV, String munNom) {
		boolean actualitzada = false;
		try {
			if (!rutaCSV.endsWith(".csv")) {
	        	JOptionPane.showMessageDialog(null, "El fitxer ha de ser un CSV.", "Error amb CSV", JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
			
			System.out.println("Actualitzant base de dades...");
			BufferedReader br = new BufferedReader(new FileReader(rutaCSV));

			String linia;
			boolean primeraLinia = true;

			while ((linia = br.readLine()) != null) {
				if (primeraLinia) {
					primeraLinia = false;
				} else {
					String[] dades = linia.split(";");
					String munLinia = dades[2];
					if (munNom.equals(munLinia)) {
						String munNomCSV = dades[2];
						String parSigles = dades[3];
						String parNom = dades[4];
						String[] canvis = renombrarPartits(parNom, parSigles);
		                parNom = canvis[0];
		                parSigles = canvis[1];
						int resVots = Integer.parseInt(dades[5].replace("-", "0"));
						double resPercentatge = Double.parseDouble(dades[6].replace(",", ".").replace("-", "0"));
						boolean actualitzat = this.resultatModel.actualitzarResultats(munNom, munNomCSV, parNom, resVots, resPercentatge);
						if (!actualitzat) {
							return false;
						} else {
							actualitzada = true;
						}
					}
				}
			}

			br.close();
		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(null, "Fitxer CSV no trobat.", "Error amb CSV", JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
			JOptionPane.showMessageDialog(null, "El fitxer no és un CSV vàlid.", "Error amb CSV", JOptionPane.ERROR_MESSAGE);
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "Error d'entrada/sortida.", "Error amb CSV", JOptionPane.ERROR_MESSAGE);
		} catch (IllegalArgumentException iae) {
			JOptionPane.showMessageDialog(null, iae.getMessage(), "Error amb CSV", JOptionPane.ERROR_MESSAGE);
		} finally {
			if (actualitzada) {
				System.out.println("Base de dades actualitzada.");
			}
		}

		return actualitzada;
	}
	
	public String[] renombrarPartits(String parNom, String parSigles) {
		String[] canvis = new String[2];
		
		if (parNom.equals("PARTIDO POPULAR/PARTIT POPULAR") || parNom.equals("PARTIT POPULAR-PARTIDO POPULAR")) {
        	parNom = "PARTIDO POPULAR";
        } else if (parNom.equals("PARTIDO SOCIALISTA OBRERO ESPAÑOL") && parSigles.equals("PSOE")) {
        	parNom = "PARTIT DELS SOCIALISTES DE CATALUNYA (PSC-PSOE)";
        	parSigles = "PSC";
        } else if (parNom.equals("CIUTADANS-PARTIDO DE LA CIUDADANÍA")) {
        	parNom = "CIUDADANOS-PARTIDO DE LA CIUDADANÍA";
        } else if (parNom.equals("POR UN MUNDO MÁS JUSTO")) {
        	parNom = "PER UN MÓN MÉS JUST";
        } else if (parNom.equals("PARTIT ANIMALISTA CONTRA EL MALTRACTAMENT ANIMAL")) {
        	parNom = "PARTIDO ANIMALISTA CONTRA EL MALTRATO ANIMAL";
        } else if (parNom.equals("PARTIDO COMUNISTA DE LOS PUEBLOS DE ESPAÑA") && parSigles.equals("PCPE")) {
        	parNom = "PARTIT COMUNISTA DEL POBLE DE CATALUNYA";
        	parSigles = "PCPC";
        } else if (parNom.equals("PARTIDO COMUNISTA DE LOS TRABAJADORES DE ESPAÑA") && parSigles.equals("PCTE")) {
        	parNom = "PARTIT COMUNISTA DELS TREBALLADORS DE CATALUNYA";
        	parSigles = "PCTC";
        } else if (parNom.equals("UNIDAS PODEMOS") && parSigles.equals("PODEMOS")) {
        	parNom = "EN COMÚ PODEM - GUANYEM EL CANVI";
        	parSigles = "ECP";
        }
		
		canvis[0] = parNom;
		canvis[1] = parSigles;
		return canvis;
	}
}
