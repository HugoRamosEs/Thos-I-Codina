package votacions.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.db4o.ObjectSet;
import com.db4o.ext.Db4oException;
import com.db4o.query.Query;

import votacions.model.objectes.*;

public class ProvinciaModel extends Model {
	private MiDb4o db4o;
	private List<Provincia> provincies;

	public ProvinciaModel() {
		this.db4o = MiDb4o.getInstance();
		this.provincies = new ArrayList<Provincia>();
	}

	public void insertarProvincia(Provincia p) {
		try {
			if (p == null) {
				throw new IllegalArgumentException("La provincia no pot estar buida");
			}

			if (!this.provincies.contains(p) && !p.getNom().equals("")) {
				this.db4o.getDb().store(p);
				this.provincies.add(p);
			}
	    } catch (IllegalArgumentException ie) {
	        JOptionPane.showMessageDialog(null, "Error d'argument: " + ie.getMessage(), "Error amb Provincia", JOptionPane.ERROR_MESSAGE);
	    } catch (Db4oException db4oE) {
	        JOptionPane.showMessageDialog(null, "Error amb la base de dades: " + db4oE.getMessage(), "Error amb Provincia", JOptionPane.ERROR_MESSAGE);
	    } catch (NullPointerException ne) {
	        JOptionPane.showMessageDialog(null, "Error de null: " + ne.getMessage(), "Error amb Provincia", JOptionPane.ERROR_MESSAGE);
	    }
		
	}

	public ArrayList<Provincia> obtenirProvincies() {
		try {
			ArrayList<Provincia> provincies = new ArrayList<Provincia>();
			ObjectSet<Provincia> result = this.db4o.getDb().queryByExample(Provincia.class);
//			if (!result.hasNext()) {
//				throw new Db4oException("No hi ha cap provincia");
//			}
			
			while (result.hasNext()) {
				provincies.add(result.next());
			}

			super.imprimirPerConsola(provincies);
			return provincies;
		} catch (Db4oException db4oE) {
			JOptionPane.showMessageDialog(null, "Error amb la base de dades: " + db4oE.getMessage(), "Error amb Provincia", JOptionPane.ERROR_MESSAGE);
		    return new ArrayList<Provincia>();
		} catch (NullPointerException ne) {
		    JOptionPane.showMessageDialog(null, "Error de null: " + ne.getMessage(), "Error amb Provincia", JOptionPane.ERROR_MESSAGE);
		    return new ArrayList<Provincia>();
		}
	}

	public Provincia obtenirProvincia(Provincia p) {
		try {
			if (p == null) {
				throw new IllegalArgumentException("La provincia no pot estar buida");
			}

			Provincia pro = null;
			ObjectSet<Provincia> result = this.db4o.getDb().queryByExample(p);
			if (result.hasNext()) {
				pro = result.next();
			}

			return pro;
	    } catch (IllegalArgumentException ie) {
	        JOptionPane.showMessageDialog(null, "Error d'argument: " + ie.getMessage(), "Error amb Provincia", JOptionPane.ERROR_MESSAGE);
	        return null;
	    } catch (Db4oException db4oE) {
	        JOptionPane.showMessageDialog(null, "Error amb la base de dades: " + db4oE.getMessage(), "Error amb Provincia", JOptionPane.ERROR_MESSAGE);
	        return null;
	    } catch (NullPointerException ne) {
	        JOptionPane.showMessageDialog(null, "Error de null: " + ne.getMessage(), "Error amb Provincia", JOptionPane.ERROR_MESSAGE);
	        return null;
	    }
	}

	public Provincia obtenirProvinciaPerNom(String proNom) {
		try {
			if (proNom == null || proNom.equals("")) {
				throw new IllegalArgumentException("El nom de la provincia no pot estar buit");
			}

			Query query = this.db4o.getDb().query();
			query.constrain(Provincia.class);
			query.descend("nom").constrain(proNom);
			
			Provincia pro = null;
			ObjectSet<Provincia> result = query.execute();
			if (result.hasNext()) {
				pro = result.next();
			}
			
			return pro;
        } catch (IllegalArgumentException ie) {
	        JOptionPane.showMessageDialog(null, "Error d'argument: " + ie.getMessage(), "Error amb Provincia", JOptionPane.ERROR_MESSAGE);
	        return null;
	    } catch (Db4oException db4oE) {
	        JOptionPane.showMessageDialog(null, "Error amb la base de dades: " + db4oE.getMessage(), "Error amb Provincia", JOptionPane.ERROR_MESSAGE);
	        return null;
	    } catch (NullPointerException ne) {
	        JOptionPane.showMessageDialog(null, "Error de null: " + ne.getMessage(), "Error amb Provincia", JOptionPane.ERROR_MESSAGE);
	        return null;
	    }
	}
}
