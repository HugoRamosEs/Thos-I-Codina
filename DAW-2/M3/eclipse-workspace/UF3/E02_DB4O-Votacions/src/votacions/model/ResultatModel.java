package votacions.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.db4o.ObjectSet;
import com.db4o.ext.Db4oException;
import com.db4o.query.Query;

import votacions.model.objectes.*;

public class ResultatModel extends Model {
	private MiDb4o db4o;
	private List<Resultat> resultats;
	private PartitModel partitModel;
	private MunicipiModel municipiModel;
	private ComarcaModel comarcaModel;
	private ProvinciaModel provinciaModel;

	public ResultatModel() {
		this.db4o = MiDb4o.getInstance();
		this.resultats = new ArrayList<Resultat>();
		this.partitModel = new PartitModel();
		this.municipiModel = new MunicipiModel();
		this.comarcaModel = new ComarcaModel();
		this.provinciaModel = new ProvinciaModel();
	}

	public void insertarResultat(Resultat res) {
		try {
			if (res == null) {
				throw new IllegalArgumentException("El resultat no pot estar buit");
			}
			
			if (!this.resultats.contains(res)) {
				Partit par = this.partitModel.obtenirPartit(res.getPartit());
				Municipi mun = this.municipiModel.obtenirMunicipi(res.getMunicipi());
				Comarca com = this.comarcaModel.obtenirComarca(res.getComarca());
				Provincia pro = this.provinciaModel.obtenirProvincia(res.getProvincia());
				
				if (par != null) {
					res.setPartit(par);
				}
				if (mun != null) {
					res.setMunicipi(mun);
				}
				if (com != null) {
					res.setComarca(com);
				}
				if (pro != null) {
					res.setProvincia(pro);
				}

				if (!res.getMunicipi().getNom().equals("")) {
					this.db4o.getDb().store(res);
					this.resultats.add(res);
				}
			}
	    } catch (IllegalArgumentException ie) {
	        JOptionPane.showMessageDialog(null, "Error d'argument: " + ie.getMessage(), "Error amb Resultat", JOptionPane.ERROR_MESSAGE);
	    } catch (Db4oException db4oE) {
	        JOptionPane.showMessageDialog(null, "Error amb la base de dades: " + db4oE.getMessage(), "Error amb Resultat", JOptionPane.ERROR_MESSAGE);
	    } catch (NullPointerException ne) {
	        JOptionPane.showMessageDialog(null, "Error de null: " + ne.getMessage(), "Error amb Resultat", JOptionPane.ERROR_MESSAGE);
	    }
	}

	public ArrayList<Resultat> obtenirResultats() {
		try {
			ArrayList<Resultat> resultats = new ArrayList<Resultat>();
			ObjectSet<Resultat> result = this.db4o.getDb().queryByExample(Resultat.class);
			while (result.hasNext()) {
				resultats.add(result.next());
			}

			super.imprimirPerConsola(resultats);
			return resultats;
	    } catch (Db4oException db4oE) {
	        JOptionPane.showMessageDialog(null, "Error amb la base de dades: " + db4oE.getMessage(), "Error amb Resultat", JOptionPane.ERROR_MESSAGE);
	        return new ArrayList<Resultat>();
	    } catch (NullPointerException ne) {
	        JOptionPane.showMessageDialog(null, "Error de null: " + ne.getMessage(), "Error amb Resultat", JOptionPane.ERROR_MESSAGE);
	        return new ArrayList<Resultat>();
	    }
	}

	public ArrayList<Resultat> obtenirResultatsPerPartitEnUnMunicipi(String munNom) {
		try {
            if (munNom == null || munNom.equals("")) {
                throw new IllegalArgumentException("El nom del municipi no pot estar buit");
            }
			
			ArrayList<Resultat> resultats = new ArrayList<Resultat>();
			Query query = this.db4o.getDb().query();
			query.constrain(Resultat.class);
			query.descend("municipi").descend("nom").constrain(munNom);
			ObjectSet<Resultat> result = query.execute();

			while (result.hasNext()) {
				resultats.add(result.next());
			}

			super.imprimirPerConsola(resultats);
			return resultats;
        } catch (IllegalArgumentException ie) {
	        JOptionPane.showMessageDialog(null, "Error d'argument: " + ie.getMessage(), "Error amb Resultat", JOptionPane.ERROR_MESSAGE);
	        return new ArrayList<Resultat>();
	    } catch (Db4oException db4oE) {
	        JOptionPane.showMessageDialog(null, "Error amb la base de dades: " + db4oE.getMessage(), "Error amb Resultat", JOptionPane.ERROR_MESSAGE);
	        return new ArrayList<Resultat>();
	    } catch (NullPointerException ne) {
	        JOptionPane.showMessageDialog(null, "Error de null: " + ne.getMessage(), "Error amb Resultat", JOptionPane.ERROR_MESSAGE);
	        return new ArrayList<Resultat>();
	    }
	}

	public ArrayList<Resultat> obtenirResultatsPerMunicipiAmbUnPartit(String parNom) {
		try {
            if (parNom == null || parNom.equals("")) {
                throw new IllegalArgumentException("El nom del partit no pot estar buit");
            }
			
			ArrayList<Resultat> resultats = new ArrayList<Resultat>();
			Query query = this.db4o.getDb().query();
			query.constrain(Resultat.class);
			query.descend("partit").descend("nom").constrain(parNom);
			ObjectSet<Resultat> result = query.execute();

			while (result.hasNext()) {
				resultats.add(result.next());
			}

			super.imprimirPerConsola(resultats);
			return resultats;
        } catch (IllegalArgumentException ie) {
	        JOptionPane.showMessageDialog(null, "Error d'argument: " + ie.getMessage(), "Error amb Resultat", JOptionPane.ERROR_MESSAGE);
	        return new ArrayList<Resultat>();
	    } catch (Db4oException db4oE) {
	        JOptionPane.showMessageDialog(null, "Error amb la base de dades: " + db4oE.getMessage(), "Error amb Resultat", JOptionPane.ERROR_MESSAGE);
	        return new ArrayList<Resultat>();
	    } catch (NullPointerException ne) {
	        JOptionPane.showMessageDialog(null, "Error de null: " + ne.getMessage(), "Error amb Resultat", JOptionPane.ERROR_MESSAGE);
	        return new ArrayList<Resultat>();
	    }
	}

	public ArrayList<Resultat> obtenirResultatsPerComarcaOProvincia(String nom) {
		try {
			if (nom == null || nom.equals("")) {
				throw new IllegalArgumentException("El nom de la comarca o provincia no pot estar buit");
			}

			ArrayList<Resultat> resultats = new ArrayList<Resultat>();
			if (this.comarcaModel.obtenirComarcaPerNom(nom) != null) {
				Query query = this.db4o.getDb().query();
				query.constrain(Resultat.class);
				query.descend("comarca").descend("nom").constrain(nom);
				ObjectSet<Resultat> result = query.execute();

				while (result.hasNext()) {
					resultats.add(result.next());
				}
			} else if (this.provinciaModel.obtenirProvinciaPerNom(nom) != null) {
				Query query = this.db4o.getDb().query();
				query.constrain(Resultat.class);
				query.descend("provincia").descend("nom").constrain(nom);
				ObjectSet<Resultat> result = query.execute();

				while (result.hasNext()) {
					resultats.add(result.next());
				}
			} else {
				throw new NullPointerException("No s'ha trobat la comarca o provincia");
			}

			super.imprimirPerConsola(resultats);
			return resultats;
			
        } catch (IllegalArgumentException ie) {
	        JOptionPane.showMessageDialog(null, "Error d'argument: " + ie.getMessage(), "Error amb Resultat", JOptionPane.ERROR_MESSAGE);
	        return new ArrayList<Resultat>();
	    } catch (Db4oException db4oE) {
	        JOptionPane.showMessageDialog(null, "Error amb la base de dades: " + db4oE.getMessage(), "Error amb Resultat", JOptionPane.ERROR_MESSAGE);
	        return new ArrayList<Resultat>();
	    } catch (NullPointerException ne) {
	        JOptionPane.showMessageDialog(null, ne.getMessage(), "Error amb Resultat", JOptionPane.ERROR_MESSAGE);
	        return new ArrayList<Resultat>();
	    }
	}
	
	public boolean actualitzarResultats(String munNom, String munNomCSV, String parNom, int resVots, double resPercentatge) {
	    boolean actualitzat = false;
	    try {
	        if (munNom == null || munNom.isEmpty() || parNom == null || parNom.isEmpty()) {
	            throw new IllegalArgumentException("El nom del municipi o partit no pot estar buit");
	        }

	        ArrayList<Resultat> resultatsActualitzats = new ArrayList<>();
	        ArrayList<Resultat> resultats = this.obtenirResultatsPerPartitEnUnMunicipi(munNom);

	        for (Resultat res : resultats) {
	            if (res.getPartit().getNom().equals(parNom)) {
	                res.setVots(resVots);
	                res.setPercentatge(resPercentatge);
	                resultatsActualitzats.add(res);
	            }
	        }

	        for (Resultat res : resultatsActualitzats) {
	            this.insertarResultat(res);
	            actualitzat = true;
	        }
	        
	    } catch (IllegalArgumentException ie) {
	        JOptionPane.showMessageDialog(null, "Error d'argument: " + ie.getMessage(), "Error amb Resultat", JOptionPane.ERROR_MESSAGE);
	    } catch (Db4oException db4oE) {
	        JOptionPane.showMessageDialog(null, "Error amb la base de dades: " + db4oE.getMessage(), "Error amb Resultat", JOptionPane.ERROR_MESSAGE);
	    } catch (NullPointerException ne) {
	        JOptionPane.showMessageDialog(null, "Error de null: " + ne.getMessage(), "Error amb Resultat", JOptionPane.ERROR_MESSAGE);
	    }
	    
	    return actualitzat;
	}
}
