package votacions.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.Db4oException;

import votacions.model.objectes.*;

public class PartitModel extends Model {
	private MiDb4o db4o;
	private List<Partit> partits;

	public PartitModel() {
		this.db4o = MiDb4o.getInstance();
		this.partits = new ArrayList<Partit>();
	}

	public void insertarPartit(Partit par) {
		try {
			if (par == null) {
				throw new IllegalArgumentException("El partit no pot estar buit");
			}

			if (!this.partits.contains(par) && !par.getNom().equals("")) {
				this.db4o.getDb().store(par);
				this.partits.add(par);
			}
		} catch (IllegalArgumentException ie) {
			JOptionPane.showMessageDialog(null, "Error d'argument: " + ie.getMessage(), "Error amb Partit", JOptionPane.ERROR_MESSAGE);
		} catch (Db4oException db4oE) {
			JOptionPane.showMessageDialog(null, "Error amb la base de dades: " + db4oE.getMessage(), "Error amb Partit", JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException ne) {
			JOptionPane.showMessageDialog(null, "Error de null: " + ne.getMessage(), "Error amb Partit", JOptionPane.ERROR_MESSAGE);
		}
	}

	public ArrayList<Partit> obtenirPartits() {
		try {
			ArrayList<Partit> partits = new ArrayList<Partit>();
			ObjectSet<Partit> result = this.db4o.getDb().queryByExample(Partit.class);
			while (result.hasNext()) {
				partits.add(result.next());
			}

			super.imprimirPerConsola(partits);
			return partits;
		} catch (Db4oException db4oE) {
			JOptionPane.showMessageDialog(null, "Error amb la base de dades: " + db4oE.getMessage(), "Error amb Partit", JOptionPane.ERROR_MESSAGE);
			return new ArrayList<Partit>();
		} catch (NullPointerException ne) {
			JOptionPane.showMessageDialog(null, "Error de null: " + ne.getMessage(), "Error amb Partit", JOptionPane.ERROR_MESSAGE);
			return new ArrayList<Partit>();
		}
	}

	public Partit obtenirPartit(Partit par) {
		try {
			if (par == null) {
				throw new IllegalArgumentException("El partit no pot estar buit");
			}

			Partit partit = null;
			ObjectSet<Partit> result = this.db4o.getDb().queryByExample(par);
			if (result.hasNext()) {
				partit = result.next();
			}
			
			return partit;
		} catch (IllegalArgumentException ie) {
			JOptionPane.showMessageDialog(null, "Error d'argument: " + ie.getMessage(), "Error amb Partit", JOptionPane.ERROR_MESSAGE);
			return null;
		} catch (Db4oException db4oE) {
			JOptionPane.showMessageDialog(null, "Error amb la base de dades: " + db4oE.getMessage(), "Error amb Partit", JOptionPane.ERROR_MESSAGE);
			return null;
		} catch (NullPointerException ne) {
			JOptionPane.showMessageDialog(null, "Error de null: " + ne.getMessage(), "Error amb Partit", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
}
