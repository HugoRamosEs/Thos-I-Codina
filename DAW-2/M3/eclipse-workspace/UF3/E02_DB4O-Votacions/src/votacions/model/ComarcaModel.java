package votacions.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.db4o.ObjectSet;
import com.db4o.ext.Db4oException;
import com.db4o.query.Query;

import votacions.model.objectes.*;

public class ComarcaModel extends Model {
	private MiDb4o db4o;
	private List<Comarca> comarques;
	private ProvinciaModel provinciaModel;

	public ComarcaModel() {
		this.db4o = MiDb4o.getInstance();
		this.comarques = new ArrayList<Comarca>();
		this.provinciaModel = new ProvinciaModel();
	}

	public void insertarComarca(Comarca c) {
	    try {
	        if (c == null) {
	            throw new IllegalArgumentException("La comarca no pot estar buida");
	        }

	        if (!this.comarques.contains(c) && !c.getNom().equals("")) {
	            Provincia pro = this.provinciaModel.obtenirProvincia(c.getProvincia());
	            if (pro != null) {
	                c.setProvincia(pro);
	            }
	            this.db4o.getDb().store(c);
	            this.comarques.add(c);
	        }
	    } catch (IllegalArgumentException ie) {
	        JOptionPane.showMessageDialog(null, "Error d'argument: " + ie.getMessage(), "Error amb Comarca", JOptionPane.ERROR_MESSAGE);
	    } catch (Db4oException db4oE) {
	        JOptionPane.showMessageDialog(null, "Error amb la base de dades: " + db4oE.getMessage(), "Error amb Comarca", JOptionPane.ERROR_MESSAGE);
	    } catch (NullPointerException ne) {
	        JOptionPane.showMessageDialog(null, "Error de null: " + ne.getMessage(), "Error amb Comarca", JOptionPane.ERROR_MESSAGE);
	    }
	}

	public ArrayList<Comarca> obtenirComarques() {
		try {
	        ArrayList<Comarca> comarques = new ArrayList<Comarca>();
	        ObjectSet<Comarca> result = this.db4o.getDb().queryByExample(Comarca.class);
	        while (result.hasNext()) {
	        	comarques.add(result.next());
	        }

	        super.imprimirPerConsola(comarques);
	        return comarques;
	    } catch (Db4oException db4oE) {
	        JOptionPane.showMessageDialog(null, "Error amb la base de dades: " + db4oE.getMessage(), "Error amb Comarca", JOptionPane.ERROR_MESSAGE);
	        return new ArrayList<Comarca>();
	    } catch (NullPointerException ne) {
	        JOptionPane.showMessageDialog(null, "Error de null: " + ne.getMessage(), "Error amb Comarca", JOptionPane.ERROR_MESSAGE);
	        return new ArrayList<Comarca>();
	    }
    }

	public Comarca obtenirComarca(Comarca c) {
	    try {
	        if (c == null) {
	            throw new IllegalArgumentException("La comarca no pot estar buida");
	        }

	        Comarca com = null;
	        ObjectSet<Comarca> result = this.db4o.getDb().queryByExample(c);
	        if (result.hasNext()) {
	            com = result.next();
	        }
	        
	        return com;
	    } catch (IllegalArgumentException ie) {
	        JOptionPane.showMessageDialog(null, "Error d'argument: " + ie.getMessage(), "Error amb Comarca", JOptionPane.ERROR_MESSAGE);
	        return null;
	    } catch (Db4oException db4oE) {
	        JOptionPane.showMessageDialog(null, "Error amb la base de dades: " + db4oE.getMessage(), "Error amb Comarca", JOptionPane.ERROR_MESSAGE);
	        return null;
	    } catch (NullPointerException ne) {
	        JOptionPane.showMessageDialog(null, "Error de null: " + ne.getMessage(), "Error amb Comarca", JOptionPane.ERROR_MESSAGE);
	        return null;
	    }
	}

	public Comarca obtenirComarcaPerNom(String comNom) {
        try {
            if (comNom == null || comNom.equals("")) {
                throw new IllegalArgumentException("El nom de la comarca no pot estar buit");
            }

            Query query = this.db4o.getDb().query();
            query.constrain(Comarca.class);
            query.descend("nom").constrain(comNom);
            
            Comarca com = null;
            ObjectSet<Comarca> result = query.execute();
            if (result.hasNext()) {
                com = result.next();
            }
            
            return com;
        } catch (IllegalArgumentException ie) {
	        JOptionPane.showMessageDialog(null, "Error d'argument: " + ie.getMessage(), "Error amb Comarca", JOptionPane.ERROR_MESSAGE);
	        return null;
	    } catch (Db4oException db4oE) {
	        JOptionPane.showMessageDialog(null, "Error amb la base de dades: " + db4oE.getMessage(), "Error amb Comarca", JOptionPane.ERROR_MESSAGE);
	        return null;
	    } catch (NullPointerException ne) {
	        JOptionPane.showMessageDialog(null, "Error de null: " + ne.getMessage(), "Error amb Comarca", JOptionPane.ERROR_MESSAGE);
	        return null;
	    }
    }
}
