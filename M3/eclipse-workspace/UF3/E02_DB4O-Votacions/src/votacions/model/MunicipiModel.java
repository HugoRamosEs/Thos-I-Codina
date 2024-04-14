package votacions.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.Db4oException;
import com.db4o.query.Query;

import votacions.model.objectes.*;

public class MunicipiModel extends Model {
	private MiDb4o db4o;
	private List<Municipi> municipis;
	private ComarcaModel comarcaModel;
	private ProvinciaModel provinciaModel;

	public MunicipiModel() {
		this.db4o = MiDb4o.getInstance();
		this.municipis = new ArrayList<Municipi>();
		this.comarcaModel = new ComarcaModel();
		this.provinciaModel = new ProvinciaModel();
	}

	public void insertarMunicipi(Municipi m) {
		try {
			if (m == null) {
				throw new IllegalArgumentException("El municipi no pot estar buit");
			}

			if (!this.municipis.contains(m) && !m.getNom().equals("")) {
				Comarca com = this.comarcaModel.obtenirComarca(m.getComarca());
				Provincia pro = this.provinciaModel.obtenirProvincia(m.getProvincia());
				if (com != null) {
					m.setComarca(com);
				}
				if (pro != null) {
					m.setProvincia(pro);
				}

				this.db4o.getDb().store(m);
				this.municipis.add(m);
			}
		} catch (IllegalArgumentException ie) {
	        JOptionPane.showMessageDialog(null, "Error d'argument: " + ie.getMessage(), "Error amb Municipi", JOptionPane.ERROR_MESSAGE);
	    } catch (Db4oException db4oE) {
	        JOptionPane.showMessageDialog(null, "Error amb la base de dades: " + db4oE.getMessage(), "Error amb Municipi", JOptionPane.ERROR_MESSAGE);
	    } catch (NullPointerException ne) {
	        JOptionPane.showMessageDialog(null, "Error de null: " + ne.getMessage(), "Error amb Municipi", JOptionPane.ERROR_MESSAGE);
	    }
	}

	public ArrayList<Municipi> obtenirMunicipis() {
	    try {
	        ArrayList<Municipi> municipis = new ArrayList<Municipi>();
	        Query query = this.db4o.getDb().query();
	        query.constrain(Municipi.class);
	        query.descend("nom").orderAscending();
	        
	        ObjectSet<Municipi> result = query.execute();
	        while (result.hasNext()) {
	            municipis.add(result.next());
	        }

	        super.imprimirPerConsola(municipis);
	        return municipis;
	    } catch (Db4oException db4oE) {
	        JOptionPane.showMessageDialog(null, "Error amb la base de dades: " + db4oE.getMessage(), "Error amb Municipi", JOptionPane.ERROR_MESSAGE);
	        return new ArrayList<Municipi>();
	    } catch (NullPointerException ne) {
	        JOptionPane.showMessageDialog(null, "Error de null: " + ne.getMessage(), "Error amb Municipi", JOptionPane.ERROR_MESSAGE);
	        return new ArrayList<Municipi>();
	    }
	}

	public Municipi obtenirMunicipi(Municipi m) {
		try {
			if (m == null) {
				throw new IllegalArgumentException("El municipi no pot estar buit");
			}
			
			Municipi mun = null;
			ObjectSet<Municipi> result = this.db4o.getDb().queryByExample(m);
			if (result.hasNext()) {
				mun = result.next();
			}
			
			return mun;
	    } catch (IllegalArgumentException ie) {
	        JOptionPane.showMessageDialog(null, "Error d'argument: " + ie.getMessage(), "Error amb Municipi", JOptionPane.ERROR_MESSAGE);
	        return null;
	    } catch (Db4oException db4oE) {
	        JOptionPane.showMessageDialog(null, "Error amb la base de dades: " + db4oE.getMessage(), "Error amb Municipi", JOptionPane.ERROR_MESSAGE);
	        return null;
	    } catch (NullPointerException ne) {
	        JOptionPane.showMessageDialog(null, "Error de null: " + ne.getMessage(), "Error amb Municipi", JOptionPane.ERROR_MESSAGE);
	        return null;
	    }
	}
}
